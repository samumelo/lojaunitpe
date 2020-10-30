package com.example.lojaunitpe.controle;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.lojaunitpe.modelos.Cidade;
import com.example.lojaunitpe.modelos.Cliente;
import com.example.lojaunitpe.repositorios.CidadeRepositorio;
import com.example.lojaunitpe.repositorios.ClienteRepositorio;
import com.example.lojaunitpe.repositorios.EstadoRepositorio;
import com.example.lojaunitpe.repositorios.FucionarioRepositorio;

@Controller
public class ClienteControle {
	
	@Autowired
	private ClienteRepositorio clienteRepositorio;
	
	@Autowired
	private CidadeRepositorio cidadeRepositorio;
	
	@GetMapping ("/cliente/cadastrar")
    public ModelAndView cadastrar (Cliente cliente)	{
		ModelAndView mv = new ModelAndView ("cliente/cadastrar");
		mv.addObject("cliente", cliente);
		mv.addObject("listaCidades", cidadeRepositorio.findAll());
		return mv;
		
	}
	
	@GetMapping ("/cliente/editar/{id}")
	public ModelAndView editar (@PathVariable("id") Long id ) {
		Optional<Cliente> cliente = clienteRepositorio.findById(id);
		return cadastrar(cliente.get());
	}
	
	
	@PostMapping ("/cliente/salvar")
	public ModelAndView salvar (@Valid Cidade cliente, BindingResult result) {
		if (result.hasErrors()) {
			return cadastrar(cliente);
		}
		cliente.setSenha(new BCryptPasswordEncorder().encorder(cliente.getSenha()));
		clienteRepositorio.saveAndFlush(cliente);
		return cadastrar(new Cliente ());
	}
	
	

}
