package com.attinix.coronatus.server.importation.sistemaautomacao;

import java.util.StringTokenizer;

import com.attinix.coronatus.client.model.Cartao;
import com.attinix.coronatus.client.model.Estabelecimento;
import com.attinix.coronatus.client.model.MovimentoEmpresa;
import com.attinix.coronatus.client.model.Terminal;
import com.attinix.coronatus.server.importation.TratarLinha;
import com.attinix.util.DataBR;

public class SistemaAutomacao extends TratarLinha {
	
	private MovimentoEmpresa movimentoEmpresa;
	
	private Estabelecimento estabelecimento;
	
	private Cartao cartao;
	
	private Terminal terminal;

	public SistemaAutomacao() throws Exception {
		super();
	}

	public boolean TratarLinha(String linha) throws NumberFormatException, Exception {
		movimentoEmpresa = new MovimentoEmpresa();
		StringTokenizer linhaInteira = new StringTokenizer(linha, ";");
		Integer campo = 1;
		String conteudo;

		while (linhaInteira.hasMoreTokens()) {
			conteudo = linhaInteira.nextToken();
			switch (campo) {
			case 1:
				estabelecimento = super.buscarEstabelecimentoPorEmpresaCodigo(Integer.parseInt(conteudo));
				movimentoEmpresa.setEstabelecimento(estabelecimento);
				break;
				
			case 2:
				cartao = super.buscarCartaoPorCodigo(Integer.parseInt(conteudo));
				movimentoEmpresa.setCartao(cartao);
				break;
				
			case 3:
				terminal = super.buscarTerminalPorCodigo(conteudo);
				movimentoEmpresa.setTerminal(terminal);
				break;
				
			case 4:
				movimentoEmpresa.setAutorizacao(conteudo);
				break;
				
			case 5:
				// Valor bruto
				/* Faz a troca da virgula pelo ponto */
				movimentoEmpresa.setValorBruto(Double.parseDouble(conteudo.replace(',', '.')));
				break;
				
			case 6:
				// Valor desconto
				/* Faz a troca da virgula pelo ponto */
				movimentoEmpresa.setValorDesconto(Double.parseDouble(conteudo
						.replace(',', '.')));
				break;
				
			case 7:
				// Valor liquido
				/* Faz a troca da virgula pelo ponto */
				movimentoEmpresa.setValorLiquido(Double.parseDouble(conteudo
						.replace(',', '.')));
				break;
				
			case 8:
				movimentoEmpresa.setParcela(Integer.parseInt(conteudo));
				break;
				
			case 9:
				movimentoEmpresa.setTotalParcela(Integer.parseInt(conteudo));
				break;
				
			case 10:
				DataBR dataTemp = new DataBR(conteudo);
				movimentoEmpresa.setDataMovimentacao(dataTemp.date());
				break;
				
			case 11:
				movimentoEmpresa.setNumeroCVNSU(conteudo);
				break;
				
			}
			movimentoEmpresa.setSituacao(1);
			
			campo++;
		}

		
		super.atualizarSistemaAutomacao(movimentoEmpresa);
		
		return true;
	}

//	public MovimentoEmpresa getMovimentoEmpresa() {
//		return movimentoEmpresa;
//	}
//
//	public void setMovimentoEmpresa(MovimentoEmpresa movimentoEmpresa) {
//		this.movimentoEmpresa = movimentoEmpresa;
//	}

}