package com.attinix.coronatus.server.importation;

import java.util.StringTokenizer;

import com.attinix.util.Arquivo;

/**
 * @author Itamar
 * @version 1.0
 */
public class VerificaArquivo {

	public String verificaCartao(Arquivo arquivo, String linha) {
		String aux;
		String nomeArquivo;
		StringTokenizer st = new StringTokenizer(linha, ",");

		if (st.countTokens() > 0) {
			while (st.hasMoreTokens()) {
				aux = st.nextToken();

				if (aux != null) {
					// Se for Redecard
					if (aux.equalsIgnoreCase("REDECARD")) {
						// Verificando se eh igual a "DEBIT"
						nomeArquivo = arquivo.getName().substring(0, 5);

						if ("DEBIT".equalsIgnoreCase(nomeArquivo)) {
							return "REDECARD-DEBITO";
						}

						return null;
					}
				}
			}
		} else {
			// Se for Redecard
			aux = linha.substring(11, 19);
			if (aux.equalsIgnoreCase("REDECARD")) {
				// Verificando se eh igual a "VENDA" ou "PAGTO"
				nomeArquivo = arquivo.getName().substring(0, 5);
				
				if ("VENDA".equalsIgnoreCase(nomeArquivo)) {
					return "REDECARD-CREDITO";
				}
				if ("PAGTO".equalsIgnoreCase(nomeArquivo)) {
					return "REDECARD-PAGAMENTO";
				}

				return null;
			}
			
			// Se for da Visa
			aux = linha.substring(45, 53);
			if (aux.equalsIgnoreCase("VISANET")) {
				return "VISANET";
			}
		}
		
		// Se nao for nenhuma Administradora, eh arquivo do cliente
		return "SISTEMAAUTOMACAO";
	}
}
