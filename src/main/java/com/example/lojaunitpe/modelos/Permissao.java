package com.example.lojaunitpe.modelos;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.Id;

@Entity
@Table(name = "permissoes")
public class Permissao implements Serializable {

	public Permissao() {
		super();
	}

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private Long id;
	@Temporal(TemporalType.DATE)
	private Date dataCadastro = new Date();
	
	@ManyToOne
	private Funcionario funcionario;
	
	@ManyToOne
	private Papel papel;

	private Long getId() {
		return id;
	}

	private void setId(Long id) {
		this.id = id;
	}

	private Date getDataCadastro() {
		return dataCadastro;
	}

	private void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	private Funcionario getFuncionario() {
		return funcionario;
	}

	private void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	private Papel getPapel() {
		return papel;
	}

	private void setPapel(Papel papel) {
		this.papel = papel;
	}

	private static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
