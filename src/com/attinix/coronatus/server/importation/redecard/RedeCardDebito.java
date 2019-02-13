package com.attinix.coronatus.server.importation.redecard;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import com.attinix.coronatus.client.model.Administradora;
import com.attinix.coronatus.client.model.Cartao;
import com.attinix.coronatus.client.model.Estabelecimento;
import com.attinix.coronatus.client.model.EstabelecimentoCartao;
import com.attinix.coronatus.client.model.EstabelecimentoCartaoTaxa;
import com.attinix.coronatus.client.model.PagamentoCartao;
import com.attinix.coronatus.client.model.Terminal;
import com.attinix.util.DataBR;

/**
 * @author Itamar
 * @version 1.0
 */
public class RedeCardDebito extends RedeCard {

	private List<PagamentoCartao> lstPcs = new ArrayList<PagamentoCartao>();

	public RedeCardDebito() {
	}

	public boolean TratarLinha(String linha) throws Exception {
		String tipoRegistro;
		if (linha == null || "".equalsIgnoreCase(linha.trim())) {
			return false;
		}

		tipoRegistro = linha.substring(0, 2);

		// Cabecalho do arquivo
		if ("00".equalsIgnoreCase(tipoRegistro)) {
			registro00(linha);

			// Verifica se deve ser feito Inclussao, Alteracao ou Exclussao
			Integer acao = super.verificaAcao();

			// Excluir
			if (acao == 2) {
				super.atualizarCabecalhoPagamentoCartao(acao);
			}
			// Incluir
			super.atualizarCabecalhoPagamentoCartao(1);

			return true;
		}

		// Total da Matriz (para nos, Filial)
		if ("03".equalsIgnoreCase(tipoRegistro)) {
			// Buscando o Estabalecimento do momento
			Estabelecimento estabelecimentoFilial = registro03(linha);

			// Atualizacao os beans
			for (PagamentoCartao pagamentoCartao : this.lstPcs) {
				// Para buscar o EstabelecimentoCartaoTaxa. Com a taxa vigente conforme a data do pagamentoCartao
				// Venda a Debito nao tem parcela. Entao nao eh necessario procurar com EstabelecimentoCartao.De - Ate.
				EstabelecimentoCartao estabelecimentoCartao = new EstabelecimentoCartao();
				estabelecimentoCartao.setCartao(this.getCabecalhoPagamentoCartao().getCartao());
				estabelecimentoCartao.setEstabelecimento(estabelecimentoFilial);
				// Data de venda eh a data de vigencia do cartao
				estabelecimentoCartao.setDataVigente(pagamentoCartao.getDataMovimentacao());
				// EstabelecimentoCartao.Tipo = 3 - Debito
				estabelecimentoCartao.setTipo(3);
				
				EstabelecimentoCartaoTaxa estabelecimentoCartaoTaxa = new EstabelecimentoCartaoTaxa();
				estabelecimentoCartaoTaxa.setEstabelecimentoCartao(estabelecimentoCartao);
				// Debito eh sempre parcelado de 1 ate 1. Total do parcelamento eh o parcelamento de ocorrencia
				estabelecimentoCartaoTaxa.setTotalParcelamento(1);
				estabelecimentoCartaoTaxa = super.buscarEstabelecimentoCartaoTaxaPorParceladoEDataDeAte(estabelecimentoCartaoTaxa);
				
				pagamentoCartao.setEstabelecimentoCartaoTaxa(estabelecimentoCartaoTaxa);
				
				super.atualizarPagamentoCartao(pagamentoCartao);
			}

			this.lstPcs = new ArrayList<PagamentoCartao>();
		}

		// Detalhamento dos comprovantes de vendas
		if ("05".equalsIgnoreCase(tipoRegistro)) {
			PagamentoCartao pagamentoCartao = registro05(linha);

			this.lstPcs.add(pagamentoCartao);
		}

		return true;
	}

	// Cabecalho do arquivo
	protected void registro00(String linha) throws Exception {
		StringTokenizer st = new StringTokenizer(linha, ",");
		Integer cont = 1;
		String aux;

		while (st.hasMoreTokens()) {
			aux = st.nextToken();

			switch (cont) {
			case 2:
				Estabelecimento estabelecimentoGrupo = super.buscarEstabelecimentoPorCodigo(aux);
				this.getCabecalhoPagamentoCartao().setEstabelecimento(estabelecimentoGrupo);

				// Administradora REDECARD
				Administradora administradora = super.buscarAdministradoraPorCodigo("REDECARD");
				
				// Tipo de cartao: 2 - Debito
				Cartao cartao = super.buscarCartaoPorAdministradoraETipo(administradora, 2);
				this.getCabecalhoPagamentoCartao().setCartao(cartao);

				break;

			case 8:
				this.getCabecalhoPagamentoCartao().setSequencia(aux);

				break;
			}

			cont++;
		}
	}

	// Total da Matriz
	protected Estabelecimento registro03(String linha) throws Exception {
		Estabelecimento estabelecimentoFilial = new Estabelecimento();
		StringTokenizer st = new StringTokenizer(linha, ",");
		Integer cont = 1;
		String aux;

		while (st.hasMoreTokens()) {
			aux = st.nextToken();

			switch (cont) {
			case 2:
				estabelecimentoFilial = super.buscarEstabelecimentoPorCodigo(aux);

				break;
			}

			cont++;
		}

		return estabelecimentoFilial;
	}

	// CV / NSU Rotativo (Resumos/transacoes Rotativos. Vendas com juros).
	protected PagamentoCartao registro05(String linha) throws Exception {
		StringTokenizer st = new StringTokenizer(linha, ",");
		PagamentoCartao pagamentoCartao = new PagamentoCartao();
		Integer cont = 1;
		String aux = "";
		Double valor = new Double(0);
		String dataCV = "";
		String horaTransacao = "";

		// Padrao
		pagamentoCartao.setSituacao(this.getSituacao());
		pagamentoCartao.setCabecalhoPagamentoCartao(this.getCabecalhoPagamentoCartao());

		while (st.hasMoreTokens()) {
			aux = st.nextToken();

			switch (cont) {
			case 3:
				pagamentoCartao.setNumeroResumo(aux);
				break;

			case 4:
				// Data
				dataCV = aux;
				break;

			case 5:
				// Valor bruto
				valor = Double.parseDouble(aux) / 100;
				pagamentoCartao.setValorBruto(valor);
				break;
				
			case 6:
				// Valor desconto
				valor = Double.parseDouble(aux) / 100;
				pagamentoCartao.setValorDesconto(valor);
				break;

			case 7:
				// Valor liquido
				valor = Double.parseDouble(aux) / 100;
				pagamentoCartao.setValorLiquido(valor);
				break;

			case 10:
				pagamentoCartao.setNumeroCVNSU(aux);
				break;

			case 12:
				pagamentoCartao.setRejeicao(aux);
				break;

			case 13:
				// Hora
				horaTransacao = aux;
				break;

			case 14:
				Terminal terminal = super.buscarTerminalPorCodigo(aux);
				pagamentoCartao.setTerminal(terminal);
				break;
			}

			cont++;
		}

		// Data
		// Hora
		// Aqui verificar hora
		// dataDoCV = dataDoCV + horaTransacao
		pagamentoCartao.setDataMovimentacao(new DataBR(dataCV));

		// Debito nao tem parcela - padrao zero (0)
		pagamentoCartao.setParcela(0);
		pagamentoCartao.setTotalParcela(0);

		return pagamentoCartao;
	}

}
