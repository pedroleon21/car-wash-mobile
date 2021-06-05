package br.com.carwash.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import br.com.carwash.dto.LavaJatoDTO;

@Entity
public class Loja implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID_LAVA_JATO")
	private long id;
	
	@Column(name="CNPJ",unique=true)
	private String cnpj;
	
	@Column(name = "NOME_LOJA")
	private String nome;
	
	@Column(name = "DS_EMAIL")
	private String email;
	
	@Column(name = "DATA_CADASTRO")
	private LocalDate dataCadastro;

	@OneToMany(fetch = FetchType.LAZY)
	private Set<Agendamento> agendamentos;
	
	public Loja() {
		
	}
	public Loja(LavaJatoDTO loja) {
		id = loja.getId();
		cnpj = loja.getCnpj();
		nome = loja.getNomeLoja();
		email = loja.getEmail();
		dataCadastro = loja.getDataCadastro();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	
	public Loja toEtity(LavaJatoDTO lavajato) {
		if (Objects.nonNull(lavajato.getNomeLoja())) this.nome = lavajato.getNomeLoja();
		if (Objects.nonNull(lavajato.getCnpj())) this.cnpj = lavajato.getCnpj();
		if (Objects.nonNull(lavajato.getDataCadastro())) this.dataCadastro = lavajato.getDataCadastro();
		if (Objects.nonNull(lavajato.getEmail())) this.email = lavajato.getEmail();
		return this;
	}	
}
