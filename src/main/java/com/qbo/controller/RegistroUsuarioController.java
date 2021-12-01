package com.qbo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.qbo.model.bd.Usuario;
import com.qbo.service.UsuarioService;

@Controller
public class RegistroUsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("/registrar")
	public String registrarUsuario(Model model) {
		model.addAttribute("title", "Registrar usuario");
		model.addAttribute("usuario", new Usuario());
		model.addAttribute("visualizar", false);
		return "registrarusuario";
	}
	
}
