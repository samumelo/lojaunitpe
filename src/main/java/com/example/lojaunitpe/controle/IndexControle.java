package com.example.lojaunitpe.controle;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class IndexControle {
	
	@Autowired
	private ProdutoRepositorio produtoRepositorio;
	
	@GetMapping ("/")
    public ModelAndView index()	{
		ModelAndView mv = new ModelAndView ("/index");
		mv.addObject("listaProdutos", produtoRepositorio.findAll());
		return mv;
		
	}
	
}