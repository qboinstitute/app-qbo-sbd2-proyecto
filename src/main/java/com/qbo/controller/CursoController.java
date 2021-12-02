package com.qbo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qbo.model.bd.Curso;
import com.qbo.model.response.ResultadoResponse;
import com.qbo.service.CursoService;

@Controller
@RequestMapping("/Curso")
public class CursoController {

	@Autowired
	private CursoService cursoService;
	
	@GetMapping("/frmMantCurso")
	public String frmMantCurso(Model model) {
		model.addAttribute("listcursos", cursoService.listarCursos());
		model.addAttribute("title", "Mantenimiento Curso");
		return "Curso/frmMantCurso";
	}
	
	@PostMapping("/registrarCurso")
	@ResponseBody
	public ResultadoResponse registrarCurso(@RequestBody Curso objcurso) {
		String mensaje = "Curso registrado correctamente";
		Boolean respuesta = true;
		try {
			cursoService.registrarCurso(objcurso);
		}catch(Exception ex) {
			mensaje ="Curso no registrado.";
			respuesta = false;
		}
		return new ResultadoResponse(respuesta, mensaje);
	}
	
	@DeleteMapping("/eliminarCurso")
	@ResponseBody
	public ResultadoResponse eliminarCurso(@RequestBody Curso objcurso) {
		String mensaje = "Curso eliminado correctamente";
		Boolean respuesta = true;
		try {
			cursoService.eliminarCurso(objcurso);
		}catch(Exception ex) {
			mensaje = "El curso no fue eliminado.";
			respuesta = false;
		}
		return new ResultadoResponse(respuesta, mensaje);
	}
	
}
