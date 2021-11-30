package com.qbo.controller;

import java.util.ArrayList;
import java.util.List;

import com.qbo.model.Persona;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.qbo.model.LoginUsuario;

@Controller
public class LoginController {

	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute("usuario", new LoginUsuario());
		return "login";
	}
	
	@PostMapping("/login")
	public String login(@ModelAttribute("usuario")LoginUsuario objusuario,
			Model model) {
		model.addAttribute("nomusuario", objusuario.getNomusuario());
		List<Persona> listapersonas = new ArrayList<Persona>();
		listapersonas.add(new Persona("Luis", "Salvatierra", 33));
		listapersonas.add(new Persona("Miguel", "Salvatierra", 32));
		listapersonas.add(new Persona("Julia", "Salvatierra", 45));
		listapersonas.add(new Persona("Gabriela", "Salvatierra", 22));
		listapersonas.add(new Persona("Juan", "Salvatierra", 17));
		model.addAttribute("lstpersonas", listapersonas);
		return "home";
	}
	
	
}
