package com.example.lojaunitpe.controle;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.lojaunitpe.modelos.Permissao;
import com.example.lojaunitpe.repositorios.PermissaoRepositorio;
import com.example.lojaunitpe.repositorios.EstadoRepositorio;
import com.example.lojaunitpe.repositorios.FucionarioRepositorio;
import com.example.lojaunitpe.repositorios.PapelRepositorio;

@Controller
public class PermissaoControle {
	
	@Autowired
	private PermissaoRepositorio permissaoRepositorio;
	
	@Autowired
	private FucionarioRepositorio funcionarioRepositorio;
	
	@Autowired
	private PapelRepositorio papelRepositorio;
	
	
	@GetMapping ("/admintrativo/permissoes/cadastrar")
    public ModelAndView cadastrar (Permissao permissao)	{
		ModelAndView mv = new ModelAndView ("administrativo/permissoes/cadastro");
		mv.addObject("permissao", permissao);
		mv.addObject("listaFuncionarios", funcionarioRepositorio.findAll());
		mv.addObject("listaPapeis", papelRepositorio.findAll());
		return mv;
		
	}
	
	@GetMapping ("/admintrativo/permissoes/listar")
    public ModelAndView listar ()	{
		ModelAndView mv = new ModelAndView ("administrativo/permissoes/lista");
		mv.addObject("listaPermissoes", permissaoRepositorio.findAll());
		return mv;
		
	}
	
	@GetMapping ("/admintrativo/permissoes/editar/{id}")
	public ModelAndView editar (@PathVariable("id") Long id ) {
		Optional<Permissao> permissao = permissaoRepositorio.findById(id);
		return cadastrar(permissao.get());
	}
	
	@GetMapping ("/admintrativo/permissoes/remover/{id}")
	public ModelAndView remover (@PathVariable("id") Long id ) {
		Optional<Permissao> permissao = permissaoRepositorio.findById(id);
		permissaoRepositorio.delete(permissao.get());
		return listar();
	}
	
	@PostMapping ("/administrativo/permissoes/salvar")
	public ModelAndView salvar (@Valid Permissao permissao, BindingResult result) {
		if (result.hasErrors()) {
			return cadastrar(permissao);
		}
		permissaoRepositorio.saveAndFlush(permissao);
		return cadastrar(new Permissao ());
	}
	
	

}
