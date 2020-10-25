package com.example.lojaunitpe.controle;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.example.lojaunitpe.modelos.Produto;
import com.example.lojaunitpe.repositorios.FucionarioRepositorio;
import com.example.lojaunitpe.repositorios.ProdutoRepositorio;

@Controller
public class CarrinhoControle {

	private List<ItensCompra> itensCompra = new ArrayList<ItensCompra>();
	
	@Autowired
	private ProdutoRepositorio repositorioProduto;
	
	@GetMapping("/carrinho")
	public ModelAndView chamarCarrinho() {
		ModelAndView mv = new ModelAndView("cliente/carrinho");
		mv.addObject("listaItens", itensCompra);
		return mv;

	}
	
	@GetMapping("/adicionarCarrinho/{id}")
	public ModelAndView adicionarCarrinho(@PathVariable Long id) {
		ModelAndView mv = new ModelAndView("cliente/carrinho");
		
		Optional<Produto> prod = repositorioProduto.findById(id);
		Produto produto = prod.get();
		
		int controle = 0;
		for(ItensCompra it:itensCompra) {
			if(it.getProduto().getId().equals(produto.getId())) {
				it.setQuantidade(it.getQuantidade()+1);
				controle = 1;
				break;
			}
		}
		if(controle == 0) {
		ItensCompra item = new ItensCompra();
		ietm.setProduto(produto);
		item.setValorUnitario(produto.getValorVenda());
		item.setQuantidade(item.getQuantidade()+1);
		item.setValorTotal(item.getQuantidade()*item.getValorUnitario());
		itensCompra.add(item);
		}
		
		mv.addObject("listaItens", itensCompra);
		return mv;

	}

}
