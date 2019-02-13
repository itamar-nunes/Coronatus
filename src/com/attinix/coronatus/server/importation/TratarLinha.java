package com.attinix.coronatus.server.importation;

import com.attinix.coronatus.client.model.Administradora;
import com.attinix.coronatus.client.model.CabecalhoPagamentoCartao;
import com.attinix.coronatus.client.model.Cartao;
import com.attinix.coronatus.client.model.Empresa;
import com.attinix.coronatus.client.model.Estabelecimento;
import com.attinix.coronatus.client.model.EstabelecimentoCartao;
import com.attinix.coronatus.client.model.EstabelecimentoCartaoTaxa;
import com.attinix.coronatus.client.model.MovimentoEmpresa;
import com.attinix.coronatus.client.model.PagamentoCartao;
import com.attinix.coronatus.client.model.Terminal;
import com.attinix.coronatus.server.dao.AdminsitradoraDao;
import com.attinix.coronatus.server.dao.CabecalhoPagamentoCartaoDao;
import com.attinix.coronatus.server.dao.CartaoDao;
import com.attinix.coronatus.server.dao.EmpresaDao;
import com.attinix.coronatus.server.dao.EstabelecimentoCartaoDao;
import com.attinix.coronatus.server.dao.EstabelecimentoCartaoTaxaDao;
import com.attinix.coronatus.server.dao.EstabelecimentoDao;
import com.attinix.coronatus.server.dao.MovimentoEmpresaDao;
import com.attinix.coronatus.server.dao.PagamentoCartaoDao;
import com.attinix.coronatus.server.dao.TerminalDao;

public class TratarLinha {

	// 1 - Importado
	private Integer situacao = 1;

	private CabecalhoPagamentoCartao cabecalhoPagamentoCartao = new CabecalhoPagamentoCartao();

	public TratarLinha() {
	}

	public Integer getSituacao() {
		return situacao;
	}

	public void setSituacao(Integer situacao) {
		this.situacao = situacao;
	}

	public CabecalhoPagamentoCartao getCabecalhoPagamentoCartao() {
		return cabecalhoPagamentoCartao;
	}

	public void setCabecalhoPagamentoCartao(CabecalhoPagamentoCartao cabecalhoPagamentoCartao) {
		this.cabecalhoPagamentoCartao = cabecalhoPagamentoCartao;
	}

	protected Integer verificaAcao() throws Exception {
		// Verificando se ja ha resgistros no banco
		CabecalhoPagamentoCartao existeSequencia = null;
		/**
		 * 1 - Inclussao, 2 - Exclusao / Inclussao
		 */
		Integer acao;
		CabecalhoPagamentoCartaoDao cabecalhoDao = new CabecalhoPagamentoCartaoDao();
		existeSequencia = cabecalhoDao.consultaPorCartaoEstabelecimentoSequencia(this.getCabecalhoPagamentoCartao());

		if (existeSequencia == null) {
			// Inclussao
			acao = 1;
		} else {
			// Exclusao / Inclussao
			acao = 2;
			this.getCabecalhoPagamentoCartao().setId(existeSequencia.getId());
		}

		return acao;
	}

	protected void atualizarPagamentoCartao(PagamentoCartao pc) throws Exception {
		// Inclussao
		PagamentoCartaoDao dao = new PagamentoCartaoDao();
		dao.incluir(pc);
	}

	protected void atualizarCabecalhoPagamentoCartao(Integer acao) throws Exception {

		switch (acao) {

		// Inclussao
		case 1:
			CabecalhoPagamentoCartaoDao dao = new CabecalhoPagamentoCartaoDao();
			dao.incluir(this.getCabecalhoPagamentoCartao());
			break;

		// Exclusao
		case 2:

			PagamentoCartaoDao daoPagamento = new PagamentoCartaoDao();
			daoPagamento.excluirTodosPagamentoCartao(this.getCabecalhoPagamentoCartao().getId());

			break;

		default:
			throw new Exception("Não foi obtida nenhuma 'AÇÃO' a ser executada.");
		}
	}

	// Aqui, preparar para update e delete
	public void atualizarSistemaAutomacao(MovimentoEmpresa movimentoEmpresa) throws Exception {
		MovimentoEmpresaDao dao = new MovimentoEmpresaDao();
		dao.incluir(movimentoEmpresa);
	}

	public Empresa buscarEmpresaPorCodigo(Integer empresaExterna) throws Exception {
		Empresa empresa = new Empresa();
		EmpresaDao empresaDao = new EmpresaDao();
		empresa = empresaDao.consultarPorCodigo(empresaExterna);
		if (empresa == null) {
			throw new Exception("Empresa não cadastrada. Empresa: " + empresaExterna);
		}
		return empresa;
	}

	public Cartao buscarCartaoPorCodigo(Integer cartaoExterno) throws Exception {
		Cartao cartao = new Cartao();
		/* Pesquisa na tabela de empresa pela codigo externo */
		CartaoDao cartaoDao = new CartaoDao();
		cartao = cartaoDao.consultarPorCodigo(cartaoExterno);
		if (cartao == null) {
			throw new Exception("Cartão não cadastrado. Cartão: " + cartaoExterno);
		}
		return cartao;
	}

	public Terminal buscarTerminalPorCodigo(String codigo) throws Exception {
		Terminal terminal = new Terminal();
		/* Pesquisa na tabela de terminal pelo codigo */
		TerminalDao terminalDao = new TerminalDao();
		terminal = terminalDao.consultarPorCodigo(codigo);
		if (terminal == null) {
			throw new Exception("Terminal não cadastrado. Terminal: " + codigo);
		}
		return terminal;
	}

	public Estabelecimento buscarEstabelecimentoPorCodigo(String codigo) throws Exception {
		Estabelecimento estabelecimento = new Estabelecimento();
		/* Pesquisa na tabela de estabelecimento pelo codigo */
		EstabelecimentoDao estabelecimentoDao = new EstabelecimentoDao();
		estabelecimento = estabelecimentoDao.consultarPorCodigo(codigo);
		if (estabelecimento == null) {
			throw new Exception("Estabelecimento não cadastrado. Estabelecimento: " + codigo);
		}
		return estabelecimento;
	}

	public Estabelecimento buscarEstabelecimentoPorEmpresaCodigo(Integer codigo) throws Exception {
		Estabelecimento estabelecimento  = new Estabelecimento();
		/* Pesquisa na tabela de estabelecimento pelo codigo da empresa */
		EstabelecimentoDao estabelecimentoDao = new EstabelecimentoDao();
		estabelecimento = estabelecimentoDao.consultarPorEmpresaCodigo(codigo);
		if (estabelecimento == null) {
			throw new Exception("Estabelecimento não cadastrado. Estabelecimento: " + codigo);
		}
		return estabelecimento;
	}
	
	public Administradora buscarAdministradoraPorCodigo(String codigo) throws Exception {
		Administradora administradora = new Administradora();
		/* Pesquisa na tabela de administradora pelo codigo */
		AdminsitradoraDao administradoraDao = new AdminsitradoraDao();
		administradora = administradoraDao.consultarPorCodigo(codigo);
		if (administradora == null) {
			throw new Exception("Administradora não cadastrado. Administradora: " + codigo);
		}
		return administradora;
	}

	public Cartao buscarCartaoPorAdministradoraETipo(Administradora administradora, Integer tipoCartao)
			throws Exception {
		Cartao cartao = new Cartao();
		cartao.setAdministradora(administradora);
		cartao.setTipo(tipoCartao);
		/*
		 * Pesquisa na tabela de cartao pela administradora e tipo de cartao
		 * Tipo de cartao: 1 - Credito, 2 - Debito
		 */
		CartaoDao cartaoDao = new CartaoDao();
		cartao = cartaoDao.consultarPorAdministradoraETipo(cartao);
		if (cartao == null) {
			throw new Exception("Cartao nao cadastrado." + "" + "/nAdm. id: " + administradora.getId()
					+ "/nAdm. codigo: " + administradora.getCodigo() + "/nAdm. nome: " + administradora.getNome()
					+ "/nTipo cartao: " + tipoCartao);
		}
		return cartao;
	}

	public EstabelecimentoCartaoTaxa buscarEstabelecimentoCartaoTaxaPorParceladoDeAte(
			EstabelecimentoCartaoTaxa estabelecimentoCartaoTaxa) throws Exception {
		EstabelecimentoCartaoTaxaDao estabelecimentoCartaoTaxaDao = new EstabelecimentoCartaoTaxaDao();

		estabelecimentoCartaoTaxa = estabelecimentoCartaoTaxaDao
				.buscarEstabelecimentoCartaoTaxaPorParceladoDeAte(estabelecimentoCartaoTaxa);

		if (estabelecimentoCartaoTaxa == null) {
			throw new Exception(
					"Não foi encontrada o registro de taxa com estes parcelamentos. EstabalecimentoCartaoTaxa");
		}

		return estabelecimentoCartaoTaxa;
	}

	public EstabelecimentoCartao buscarEstabelecimentoCartaoPorDataDeAte(
			EstabelecimentoCartao estabelecimentoCartao) throws Exception {
		EstabelecimentoCartaoDao estabelecimentoCartaoDao = new EstabelecimentoCartaoDao();

		estabelecimentoCartao = estabelecimentoCartaoDao.buscarEstabelecimentoCartaoPorDataDeAte(estabelecimentoCartao);

		if (estabelecimentoCartao == null) {
			throw new Exception(
					"Não foi encontrada o registro de parcelamento do cartão com estas datas vigentes. EstabalecimentoCartaoTaxa");
		}

		return estabelecimentoCartao;
	}

	public EstabelecimentoCartaoTaxa buscarEstabelecimentoCartaoTaxaPorParceladoEDataDeAte(
			EstabelecimentoCartaoTaxa estabelecimentoCartaoTaxa) throws Exception {
		EstabelecimentoCartaoTaxaDao dao = new EstabelecimentoCartaoTaxaDao();

		estabelecimentoCartaoTaxa = dao.buscarEstabelecimentoCartaoTaxaPorParceladoEDataDeAte(estabelecimentoCartaoTaxa);

		if (estabelecimentoCartaoTaxa == null) {
			throw new Exception(
					"Não foi encontrada o registro de parcelamento do cartão com estes parcelamentos e datas vigentes. EstabalecimentoCartaoTaxa");
		}

		return estabelecimentoCartaoTaxa;
	}

}