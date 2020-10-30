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
public class NegadoControle {
	
	
	@GetMapping ("/negado")
    public ModelAndView negadoAdministrativo ()	{
		ModelAndView mv = new ModelAndView ("/negadoAdministrativo");
		return mv;
		
	}
	@GetMapping ("/negadoCliente")
    public ModelAndView negadoCliente ()	{
		ModelAndView mv = new ModelAndView ("/negadoCliente");
		return mv;
		
	}	
}