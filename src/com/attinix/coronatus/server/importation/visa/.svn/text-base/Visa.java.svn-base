/**
 * @author Jair
 * @version 1.0
 *
 */
package com.attinix.coronatus.server.importation.visa;

import java.util.Date;

import com.attinix.coronatus.client.model.Administradora;
import com.attinix.coronatus.client.model.Cartao;
import com.attinix.coronatus.client.model.Estabelecimento;
import com.attinix.coronatus.client.model.EstabelecimentoCartao;
import com.attinix.coronatus.client.model.EstabelecimentoCartaoTaxa;
import com.attinix.coronatus.client.model.PagamentoCartao;
import com.attinix.coronatus.client.model.Terminal;
import com.attinix.coronatus.server.importation.TratarLinha;
import com.attinix.util.DataBR;

public class Visa extends TratarLinha {

	/**
	 * Cria um objeto com metodos utilzados para tratar os registros da bandeira
	 * da <b>Visa</b>.<br>
	 * Utilize esta classe para fazer o tratamento de uma string e poder gravar
	 * na tabela de <b>pagamentocartao</b>.
	 * */
	public Visa() {
	}

	/**
	 * Este metodo chamar outros metodos dependendo do tipo da linha.<br>
	 * Este eh o metodo principal desta classe.
	 * 
	 * @param linha
	 *            contendo os dados a serem tratados.
	 * @throws Exception
	 * 
	 * @see #cabecalho(String linha)
	 * @see #comprovanteVenda(String linha)
	 * */
	public Integer montaRegistro(String linha) throws Exception {
		String tipoRegistro = linha.substring(0, 1);

		PagamentoCartao pagamentoCartao = new PagamentoCartao();

		if ("0".equalsIgnoreCase(tipoRegistro)) {
			cabecalho(linha);

			// Verifica se deve ser feito Inclussao, Alteracao ou Exclussao
			Integer acao = super.verificaAcao();

			// Atualiza para 002 só quando exclussao
			if (acao == 2) {
				super.atualizarCabecalhoPagamentoCartao(acao);
			}
			// Incluir
			super.atualizarCabecalhoPagamentoCartao(1);
		}

		/*
		 * Falta fazer a leitura deste tipo de registro para guardar ou
		 * atualizar o deposito(pagamento) da compra registrado no tipo 02.
		 * Importante: Podem existirem registros do tipo 1 sem um registro do
		 * tipo 2 Nesse caso o registro ser� incluido e seu status ficar como 4
		 * - Sem Venda.
		 */
		if ("1".equalsIgnoreCase(tipoRegistro)) {
			pagamentoCartao = resumoOperacao(linha);
			// super.atualizarCartao(pagamentoCartao);
		}

		if ("2".equalsIgnoreCase(tipoRegistro)) {
			pagamentoCartao = comprovanteVenda(linha);
			if (pagamentoCartao.getEstabelecimentoCartaoTaxa() != null && pagamentoCartao.getTerminal() != null) {
				super.atualizarPagamentoCartao(pagamentoCartao);
			}
			System.out.println(pagamentoCartao);
			System.out.println("-----------------------------------------------------------------------");
		}

		if ("5".equalsIgnoreCase(tipoRegistro)) {
			pagamentoCartao = trailler(linha);
			super.atualizarPagamentoCartao(pagamentoCartao);
		}
		return 0;
	}

	/**
	 * Metodo utilizado para tratar dos registro do tipo <b>cabecalho</b>.<br>
	 * Veja no arquivo de layout o registro do tipo zero(0).
	 * 
	 * @param linha
	 *            contendo os dados a serem tratados.
	 * @throws Exception
	 * 
	 * @see #montaRegistro(String linha)
	 * @see #comprovanteVenda(String linha)
	 * */
	public void cabecalho(String linha) throws Exception {
		this.getCabecalhoPagamentoCartao().setSequencia(linha.substring(38, 45));

		// Administradora VISANET
		Administradora administradora = super.buscarAdministradoraPorCodigo("VISANET");
		// Tipo de cartao: 1 - Credito
		Cartao cartao = super.buscarCartaoPorAdministradoraETipo(administradora, 1);

		this.getCabecalhoPagamentoCartao().setCartao(cartao);

		// Numero do estabelecimento é o mesmo que numero de ponto de venda
		Estabelecimento estabelecimento = super.buscarEstabelecimentoPorCodigo(linha.substring(1, 11));
		this.getCabecalhoPagamentoCartao().setEstabelecimento(estabelecimento);
	}

	/**
	 * Metodo utilizado para tratar dos registros do tipo detalhe do resumo de
	 * operacao (RO).<br>
	 * Veja no arquivo de layout os registros do tipo um(1).
	 * 
	 * @param linha
	 *            contendo os dados a serem tratados.
	 * 
	 * @see #montaRegistro(String linha)
	 * @see #comprovanteVenda(String linha)
	 * */
	public PagamentoCartao resumoOperacao(String linha) {
		/*
		 * Este método deve procurar, na tabela de PAGAMENTOCARTAO pelos
		 * registros já incluidos. Caso os mesmos não existam, deverá ser feita
		 * uma inclusão com o status do tipo 4.
		 */

		return new PagamentoCartao();
	}

	/**
	 * Metodo utilizado para tratar dos registros do tipo comprovante de
	 * venda(CV).<br>
	 * Veja no arquivo de layout os registros do tipo dois(2).
	 * 
	 * @param linha
	 *            contendo os dados a serem tratados.
	 * @throws Exception
	 * 
	 * @see #montaRegistro(String linha)
	 * @see #comprovanteVenda(String linha)
	 * */
	public PagamentoCartao comprovanteVenda(String linha) throws Exception {
		PagamentoCartao pagamentoCartao = new PagamentoCartao();
		/*
		 * Obs: importante, os numeros de inicio da substring eh sempre o numero
		 * indicado no layout menos 1.
		 */

		/* Soh faz para registros que forem vendas a creditos */
		if ("+".equalsIgnoreCase(linha.substring(45, 46))) {
			pagamentoCartao.setNumeroResumo(linha.substring(11, 18));
			pagamentoCartao.setParcela(Integer.parseInt(linha.substring(59, 61)));
			pagamentoCartao.setTotalParcela(Integer.parseInt(linha.substring(61, 63)));
			pagamentoCartao.setRejeicao(linha.substring(63, 93).trim());
			String dia = linha.substring(43, 45);
			String mes = linha.substring(41, 43);
			String ano = linha.substring(37, 41);
			DataBR dataMovimentoBR = new DataBR(dia + mes + ano);
			Date dataMovimentacao = dataMovimentoBR.date();
			pagamentoCartao.setDataMovimentacao(dataMovimentacao);
			pagamentoCartao.setValorLiquido(Double.parseDouble(linha.substring(46, 59)) / 100);
			pagamentoCartao.setNumeroAutorizacao(linha.substring(93, 100));
			pagamentoCartao.setNumeroCVNSU(linha.substring(139, 145));
			pagamentoCartao.setCabecalhoPagamentoCartao(this.getCabecalhoPagamentoCartao());

			/*
			 * Localizar o ID do terminal na tabela de terminal pelo campo
			 * numero
			 */
			Terminal terminal = super.buscarTerminalPorCodigo(linha.substring(199, 207));

			/*
			 * Localizar na tabela Estabelecimento, no campo numero, o codigo do
			 * mesmo do campo ID
			 */
			Estabelecimento estabelecimento = super.buscarEstabelecimentoPorCodigo(linha.substring(1, 11));

			// Para buscar o EstabelecimentoCartaoTaxa. Com a taxa vigente
			// conforme a data do pagamentoCartao
			// Venda a Credito parcelado.
			EstabelecimentoCartao estabelecimentoCartao = new EstabelecimentoCartao();
			estabelecimentoCartao.setCartao(this.getCabecalhoPagamentoCartao().getCartao());
			estabelecimentoCartao.setEstabelecimento(estabelecimento);
			// Data de venda eh a data de vigencia do cartao
			estabelecimentoCartao.setDataVigente(pagamentoCartao.getDataMovimentacao());
			// EstabelecimentoCartao.Tipo = 2 - Credito parcelado sem juros
			estabelecimentoCartao.setTipo(2);

			EstabelecimentoCartaoTaxa estabelecimentoCartaoTaxa = new EstabelecimentoCartaoTaxa();
			estabelecimentoCartaoTaxa.setEstabelecimentoCartao(estabelecimentoCartao);
			// Credito parcelado. Verificar qual a faixa de parcelamento. Total do parcelamento eh o parcelamento de ocorrencia
			estabelecimentoCartaoTaxa.setTotalParcelamento(pagamentoCartao.getTotalParcela());
			estabelecimentoCartaoTaxa = super.buscarEstabelecimentoCartaoTaxaPorParceladoEDataDeAte(estabelecimentoCartaoTaxa);
			
			pagamentoCartao.setEstabelecimentoCartaoTaxa(estabelecimentoCartaoTaxa);

			pagamentoCartao.setTerminal(terminal);
			pagamentoCartao.setSituacao(1);
		}
		return pagamentoCartao;
	}

	/**
	 * Metodo utilizado para tratar dos registros do tipo informativo de
	 * Trailler.<br>
	 * Veja no arquivo de layout o tipo nove(9).
	 * 
	 * @param linha
	 *            contendo os dados a serem tratados.
	 * 
	 * @see #montaRegistro(String linha)
	 * @see #comprovanteVenda(String linha)
	 * */
	public PagamentoCartao trailler(String linha) {
		return new PagamentoCartao();
	}
}