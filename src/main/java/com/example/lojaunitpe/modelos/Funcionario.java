package com.example.lojaunitpe.modelos;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.Id;

@Entity
@Table(name = "funcionario")
public class Funcionario implements Serializable {

	public Funcionario() {
		super();
	}

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nome;
	private Double salarioBruto;
	@Temporal (TemporalType.DATE)
	private Date dataEntrada;
	@Temporal (TemporalType.DATE)
	private Date dataSaida;
	private String cargo;
	private String cidade;
	private String logadouro;
	private String numero;
	private String complemento;
	private String bairro;
	private String uf;
	private String cep;
	private Long getId() {
		return id;
	}
	private void setId(Long id) {
		this.id = id;
	}
	private String getNome() {
		return nome;
	}
	private void setNome(String nome) {
		this.nome = nome;
	}
	private Double getSalarioBruto() {
		return salarioBruto;
	}
	private void setSalarioBruto(Double salarioBruto) {
		this.salarioBruto = salarioBruto;
	}
	private Date getDataEntrada() {
		return dataEntrada;
	}
	private void setDataEntrada(Date dataEntrada) {
		this.dataEntrada = dataEntrada;
	}
	private Date getDataSaida() {
		return dataSaida;
	}
	private void setDataSaida(Date dataSaida) {
		this.dataSaida = dataSaida;
	}
	private String getCargo() {
		return cargo;
	}
	private void setCargo(String cargo) {
		this.cargo = cargo;
	}
	private String getCidade() {
		return cidade;
	}
	private void setCidade(String cidade) {
		this.cidade = cidade;
	}
	private String getLogadouro() {
		return logadouro;
	}
	private void setLogadouro(String logadouro) {
		this.logadouro = logadouro;
	}
	private String getNumero() {
		return numero;
	}
	private void setNumero(String numero) {
		this.numero = numero;
	}
	private String getComplemento() {
		return complemento;
	}
	private void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	private String getBairro() {
		return bairro;
	}
	private void setBairro(String bairro) {
		this.bairro = bairro;
	}
	private String getUf() {
		return uf;
	}
	private void setUf(String uf) {
		this.uf = uf;
	}
	private String getCep() {
		return cep;
	}
	private void setCep(String cep) {
		this.cep = cep;
	}
	private static long getSerialversionuid() {
		return serialVersionUID;
	}

}
