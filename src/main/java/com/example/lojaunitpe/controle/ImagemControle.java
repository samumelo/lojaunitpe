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
public class ImagemControle {
	
	private static String caminhoImagens = "C:\\Users\\Acer\\Documents\\imagens";
	
	
	
	@GetMapping ("/mostrarImagem/{imagem}")
	@ResponseBody
	public byte[] retornarImagem (@PathVariable("imagem") String imagem ) throws IOException{
		File imagemArquivo = new File (caminhoImagens+imagem); 
		if(imagem!=null || imagem.trim().length()>0) {
		return Files.readAllBytes(imagemArquivo.toPath());
	}
		return null;
	}
	
	
	
	

}
