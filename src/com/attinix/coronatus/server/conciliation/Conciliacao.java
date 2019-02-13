package com.attinix.coronatus.server.conciliation;

import java.util.ArrayList;
import java.util.List;

import com.attinix.coronatus.client.model.Cartao;
import com.attinix.coronatus.client.model.Empresa;
import com.attinix.coronatus.client.model.MovimentoEmpresa;
import com.attinix.coronatus.client.model.PagamentoCartao;
import com.attinix.coronatus.server.dao.MovimentoEmpresaDao;
import com.attinix.coronatus.server.dao.PagamentoCartaoDao;

/**
 * @author Itamar
 * @version 1.0
 */
public class Conciliacao {
	
	private PagamentoCartaoDao pcDao;

	private MovimentoEmpresaDao meDao;
	
	public void Conciliar(List<Empresa> empresas, List<Cartao> cartoes) throws Exception {
		pcDao = new PagamentoCartaoDao();
		meDao = new MovimentoEmpresaDao();
		
		// Criando um List com objetos que contenham ID de Empresa e ID de Cartao
		List<Object> lstEmpresasCartoes = new ArrayList<Object>();
		for (Empresa empresa : empresas) {
			EmpresaCartao empresaCartao = new EmpresaCartao();
			empresaCartao.setEmpresa(empresa.getId());
			
			lstEmpresasCartoes.add(empresaCartao);
		}
		// Verificando se cartoes é maior do que empresas 
		//  Se "restante" for positivo (>0), é porque tem mais cartoes que empresas
		Integer restante = cartoes.size() - empresas.size();
		for (int i = 0; i < cartoes.size(); i++) {
			Cartao cartao = cartoes.get(i);
			// Se i for maior que "restante" é cartoes tem mais registro que empresas
			//  Entao tem que incluir umo novo objeto 
			if(i > restante) {
				EmpresaCartao empresaCartaoNovo = new EmpresaCartao();
				lstEmpresasCartoes.add(empresaCartaoNovo);
			}
			EmpresaCartao empresaCartao = (EmpresaCartao) lstEmpresasCartoes.get(i); 
			empresaCartao.setCartao(cartao.getId());
		}
		
		// Aqui ainda tem que enviar para o metodo os cartoes
		List<PagamentoCartao> pagamentosCartoes = pcDao.consultarPorSituacoesDif4Empresas(lstEmpresasCartoes);
		
		// Aqui ainda tem que enviar para o metodo os cartoes
		List<MovimentoEmpresa> movimentosEmpresas = meDao.consultarPorSituacoesDif4Empresas(lstEmpresasCartoes);
		
		// Avaliando os regristos
		avaliarRegistro(pagamentosCartoes, movimentosEmpresas);
		
	}
	
	protected void avaliarRegistro(List<PagamentoCartao> pagamentosCartoes, List<MovimentoEmpresa> movimentosEmpresas) throws Exception {
		List<MovimentoEmpresa> movimentosEmpresasAvaliadas = new ArrayList<MovimentoEmpresa>();
		PagamentoCartao pc = new PagamentoCartao();
		
		for (int i = 0; i < pagamentosCartoes.size(); i++) {
			pc = pagamentosCartoes.get(i);
			// Mudando para 5 - Sem venda
			pc.setSituacao(5);

			// indexOf usa o equals para compara dois objetos. Para saber mais verifique PagamentoCartao.equals()
			Integer posicao = movimentosEmpresas.indexOf(pc);
			if(posicao >= 0) {
				MovimentoEmpresa me = movimentosEmpresas.get(posicao);

				// TODO: Aqui, ainda tem que avaliar as taxas e o desconto
				
				// Se forem iguais
				if(pc.getValorBruto().equals(me.getValorBruto())) {
					// Mudando para 4 - Consistente
					pc.setSituacao(4);
					me.setSituacao(4);
				} else {
					// Mudando para 6 - Pago inconsistente
					pc.setSituacao(6);
					me.setSituacao(6);
				}
				
				// Movendo o  de um list pra outro
				movimentosEmpresasAvaliadas.add(me);
				movimentosEmpresas.remove(me);
			}
		}
		
		// Mudando o restante dos registros de MovimentoEmpresa para 3 - Sem pagamento
		MovimentoEmpresa me = new MovimentoEmpresa();
		for (int i = 0; i < movimentosEmpresas.size(); i++) {
			me = movimentosEmpresas.get(i);
			// Mudando para 3 - Sem pagamento
			me.setSituacao(3);
			
			// Adicionando o  de um list pra outro
			movimentosEmpresasAvaliadas.add(me);
		}
		
		// Atualizando PagamentoCartao
		atualizarPagamentoCartao(pagamentosCartoes);
		
		// Atualizando MovimentoEmpresa
		atualizarMovimentoEmpresa(movimentosEmpresasAvaliadas);
	}
	
	protected void atualizarPagamentoCartao(List<PagamentoCartao> pagamentosCartoesAvaliados) throws Exception {
		pcDao = new PagamentoCartaoDao();
		
		for (PagamentoCartao pagamentoCartao : pagamentosCartoesAvaliados) {
			pcDao.excluir(pagamentoCartao.getId());
			pcDao.excluir(pagamentoCartao);
		}
	}

	protected void atualizarMovimentoEmpresa(List<MovimentoEmpresa> movimentosEmpresasAvaliadas) throws Exception {
		meDao = new MovimentoEmpresaDao();
		
		for (MovimentoEmpresa movimentoEmpresa : movimentosEmpresasAvaliadas) {
			meDao.excluir(movimentoEmpresa.getId());
			meDao.excluir(movimentoEmpresa);
		}
	}
	
}

/**
 * 
 * @author Itamar
 * @version 1.0
 * 
 * Classe para usar como List. Contendo os atributos empresa (Empresa.ID) e cartao (Cartao.ID) 
 */
class EmpresaCartao {
	
	private Integer empresa = 0;
	private Integer cartao = 0;

	public Integer getEmpresa() {
		return empresa;
	}
	public void setEmpresa(Integer empresa) {
		this.empresa = empresa;
	}
	public Integer getCartao() {
		return cartao;
	}
	public void setCartao(Integer cartao) {
		this.cartao = cartao;
	}
	
}