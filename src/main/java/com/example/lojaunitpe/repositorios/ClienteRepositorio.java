package com.example.lojaunitpe.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.lojaunitpe.modelos.Cliente;

public interface ClienteRepositorio extends JpaRepository<Cliente,Long>	{

}
