package com.attinix.coronatus.client.model;

import com.google.gwt.user.client.rpc.IsSerializable;

public class Empresa implements IsSerializable {

	private static final long serialVersionUID = 8582564338697711874L;

	private Integer id;

	private GrupoEmpresa grupo = new GrupoEmpresa();

	private Endereco endereco = new Endereco();

	private String razaoSocial;

	private String nomeFantasia;

	private String responsavel;

	private String cnpj;

	private Integer matriz;

	private Integer codigo;

	private Estabelecimento estabelecimento;

	private Telefone[] telefone;

	public Empresa() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public GrupoEmpresa getGrupo() {
		return grupo;
	}

	public void setGrupo(GrupoEmpresa grupo) {
		this.grupo = grupo;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public Integer getMatriz() {
		return matriz;
	}

	public void setMatriz(Integer matriz) {
		this.matriz = matriz;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}

	public void setEstabelecimento(Estabelecimento estabelecimento) {
		this.estabelecimento = estabelecimento;
	}

	public Telefone[] getTelefone() {
		return telefone;
	}

	public void setTelefone(Telefone[] telefone) {
		this.telefone = telefone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Empresa))
			return false;
		Empresa other = (Empresa) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public String toString() {
		String retorno;

		retorno = "\nId: " + this.getId() + "\nExterno: " + this.getCodigo()
				+ "\nCNPJ: " + this.getCnpj() + "\nRazao: "
				+ this.getRazaoSocial() + "\nFantasia: "
				+ this.getNomeFantasia();

		if (this.getEndereco() != null) {
			retorno += "\nEndereco: " + this.getEndereco().getId() + " - "
					+ this.endereco.getNumero();
		}
		if (this.getGrupo() != null) {
			retorno += "\nGrupo: " + this.getGrupo().getId() + " - "
					+ this.getGrupo().getNome();
		}

		return retorno;
	}
}
