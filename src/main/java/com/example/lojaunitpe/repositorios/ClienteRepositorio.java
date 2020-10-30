package com.example.lojaunitpe.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.lojaunitpe.modelos.Cliente;

public interface ClienteRepositorio extends JpaRepository<Cliente,Long>	{
	@Query("from cliente where email=?1" )
	public List<Cliente> buscarClienteEmail(String email);
}
