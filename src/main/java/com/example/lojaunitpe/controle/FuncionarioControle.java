package com.example.lojaunitpe.controle;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.lojaunitpe.modelos.Funcionario;
import com.example.lojaunitpe.repositorios.FucionarioRepositorio;

@Controller
public class FuncionarioControle {
	
	@Autowired
	private FucionarioRepositorio funcionarioRepositorio;
	
	@GetMapping ("/admintrativo/funcionrio/cadastrar")
    public ModelAndView cadastrar (Funcionario funcionario)	{
		ModelAndView mv = new ModelAndView ("administrativo/funcionarios/cadastro");
		mv.addObject("funcionario", funcionario);
		return mv;
		
	}
	
	@GetMapping ("/admintrativo/funcionrio/cadastrar")
    public ModelAndView listar ()	{
		ModelAndView mv = new ModelAndView ("administrativo/funcionarios/lista");
		mv.addObject("listaFuncionarios", funcionarioRepositorio.findAll());
		return mv;
		
	}
	
	@GetMapping ("/admintrativo/funcionrio/editar/{id}")
	public ModelAndView editar (@PathVariable("id") Long id ) {
		Optional<Funcionario> funcionario = funcionarioRepositorio.findById(id);
		return cadastrar(funcionario.get());
	}
	
	@PostMapping ("/administrativo/funcionarios/salvar")
	public ModelAndView salvar (@Valid Funcionario funcionario, BindingResult result) {
		if (result.hasErrors()) {
			return cadastrar(funcionario);
		}
		funcionarioRepositorio.saveAndFlush(funcionario);
		return cadastrar(new Funcionario ());
	}
	
	

}
