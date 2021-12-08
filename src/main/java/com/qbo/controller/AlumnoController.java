package com.qbo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qbo.service.CursoNotaService;
import com.qbo.service.EspecialidadService;
import com.qbo.model.bd.*;
import com.qbo.model.sp.CursoNota;

@Controller
@RequestMapping("/Alumno")
public class AlumnoController {

	@Autowired
	private EspecialidadService especialidadService;
	
	@Autowired
	private CursoNotaService cursoNotaService;
	
	@GetMapping("/frmListAlumno")
	public String frmListarAlumnos(Model model) {
		model.addAttribute("listespecialidad", especialidadService.listarEspecialidades());
		model.addAttribute("title", "Nota x Alumno");
		return "Alumno/frmListAlumno";
	}
	
	@GetMapping("/listarAlumnosxEspecialidad")
	@ResponseBody
	public List<Alumno> listarCursos(@RequestParam("idesp") String idEspecialidad){
		return especialidadService.listarAlumnosxEspecialidad(idEspecialidad);
	}
	
	@GetMapping("/listarCursosNotasxAlumno")
	@ResponseBody
	public List<CursoNota> listarCursosNota(@RequestParam("idalumno") 
				String idAlumno){
		return cursoNotaService.listarCursoNotaxAlumno(idAlumno);
	}
	
	
	
}
