package com.example.lojaunitpe.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.lojaunitpe.modelos.Produto;

public interface ProdutoRepositorio extends JpaRepository<Produto,Long>	{

}
