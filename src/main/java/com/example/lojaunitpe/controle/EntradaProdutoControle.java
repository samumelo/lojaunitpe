package com.example.lojaunitpe.controle;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.lojaunitpe.modelos.EntradaItens;
import com.example.lojaunitpe.modelos.EntradaProduto;
import com.example.lojaunitpe.modelos.Estado;
import com.example.lojaunitpe.modelos.Produto;
import com.example.lojaunitpe.repositorios.EntradaItensRepositorio;
import com.example.lojaunitpe.repositorios.EntradaProdutoRepositorio;
import com.example.lojaunitpe.repositorios.FucionarioRepositorio;
import com.example.lojaunitpe.repositorios.ProdutoRepositorio;

@Controller
public class EntradaProdutoControle {
	
	private List<EntradaItens> listaEntrada = new ArrayList<EntradaItens>();
	
	@Autowired
	private EntradaProdutoRepositorio entradaProdutoRepositorio;
	
	@Autowired
	private EntradaItensRepositorio entradaItensRepositorio;
	
	@Autowired
	private FucionarioRepositorio funcionarioRepositorio;
	
	@Autowired
	private ProdutoRepositorio produtoRepositorio;
	
	@GetMapping ("/admintrativo/entrada/cadastrar")
    public ModelAndView cadastrar (EntradaProduto entrada,
    		EntradaItens entradaItens)	{
		ModelAndView mv = new ModelAndView ("administrativo/entrada/cadastro");
		mv.addObject("entrada", entrada);
		mv.addObject("listaEntradaItens", this.listaEntrada);
		mv.addObject("entradaItens", entradaItens);
		mv.addObject("listaFuncionarios", funcionarioRepositorio.findAll());
		mv.addObject("listaProdutos", produtoRepositorio.findAll());
		return mv;
		
	}
	
	// @GetMapping ("/admintrativo/estados/listar")
	// public ModelAndView listar ()	{
	//	ModelAndView mv = new ModelAndView ("administrativo/estados/lista");
	//	mv.addObject("listaEstados", estadoRepositorio.findAll());
	//	return mv;
		
	// }
	
	// @GetMapping ("/admintrativo/estados/editar/{id}")
	// public ModelAndView editar (@PathVariable("id") Long id ) {
	//	Optional<Estado> estado = estadoRepositorio.findById(id);
	//	return cadastrar(estado.get());
	// }
	
	// @GetMapping ("/admintrativo/estados/remover/{id}")
	// public ModelAndView remover (@PathVariable("id") Long id ) {
	//	Optional<Estado> estado = estadoRepositorio.findById(id);
	//	estadoRepositorio.delete(estado.get());
	//	return listar();
	// }
	
	@PostMapping ("/administrativo/entrada/salvar")
	public ModelAndView salvar (String acao, EntradaProduto entrada, EntradaItens entradaItens) {
		
		if(acao.equals("itens")) {
			this.listaEntrada.add(entradaItens);
		}else if (acao.equals("salvar")) {
			entradaProdutoRepositorio.saveAndFlush(entrada);
			for (EntradaItens it:listaEntrada) {
				it.setEntrada(entrada);
				entradaItensRepositorio.saveAndFlush(it);
				Optional<Produto> prod = produtoRepositorio.findById(it.getProduto().getId());
				Produto produto = prod.get ();
				produto.setQuantidadeEstoque(produto.getQuantidadeEstoque() + it.getQuantidade() );
				produto.setValorVenda(it.getValorVenda()); 
				produtoRepositorio.saveAndFlush(produto);
				this.listaEntrada = new ArrayList <> ();		 
			}
			return cadastrar (new EntradaProduto (), new EntradaItens ());
		}
		
		return cadastrar(entrada, new EntradaItens());
	}
	
	

}
