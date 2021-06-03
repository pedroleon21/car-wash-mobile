package br.com.carwash.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;


@Entity
public class Agendamento implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_AGENDAMENTO")
	private long id;

//	@ManyToOne
	@JoinColumn(name = "FK_CLIENTE", nullable = false)
	private Cliente cliente;

//	@ManyToOne
	@Column(name = "FK_JAVA_JATO", nullable = false)
	private Loja javaJato;

	@Column(name = "DTH_LAVAGEM", nullable = false)
	private LocalDate dataLavagem;

	@JoinColumn(name = "DTH_AGENDAMENTO", nullable = false)
	private LocalDate dataAgendamento;

	public Loja getJavaJato() {
		return javaJato;
	}

	public void setJavaJato(Loja javaJato) {
		this.javaJato = javaJato;
	}

	public LocalDate getDataAgendamento() {
		return dataAgendamento;
	}

	public void setDataAgendamento(LocalDate dataAgendamento) {
		this.dataAgendamento = dataAgendamento;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}
