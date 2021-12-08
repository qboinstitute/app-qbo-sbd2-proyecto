$(document).ready(function() {
	$("#tblalumno").hide();
});

$(document).on("change", "#cboespecialidad", function() {
	var idespecialidad = $("#cboespecialidad").val();
	//alert(idespecialidad);
	if (idespecialidad === "0") {
		$("#tblalumno").hide();
		$("#tblalumno").html("");
	} else {
		$.ajax({
			type: 'GET',
			url: '/Alumno/listarAlumnosxEspecialidad',
			data: {
				idesp: idespecialidad
			},
			success: function(resultado) {
				$("#tblalumno").html("");
				if (resultado.length > 0) {
					$.each(resultado, function(index, value) {
						procedencia = value.proce == "P" ? "Particular" : "Estatal";
						$("#tblalumno").append("<div class='col'>" +
							"<div class='card h-100'>" +
							"<img src='/img/silueta.jpg' class='card-img-top' alt='...'>" +
							"<div class='card-body'>" +
							"<h5 class='card-title'><b>Codigo: " + value.idalumno + "</b></h5>" +
							"<p class='card-text'>" + value.apealumno + " " + value.nomalumno + "</p>" +
							"<p class='card-text'>Colegio: " + procedencia + "</p>" +
							"<button type='button' data-codalumno='" + value.idalumno + "' class='btn btn-primary btnvernotas'>Ver Notas</button>" +
							"</div></div></div>");
					});
					$("#tblalumno").show();
				} else {
					$("#tblalumno").hide();
				}
			}
		});

	}

});

$(document).on("click", ".btnvernotas", function() {
	$("#modalcursosnotas").modal("show");
	$.ajax({
		type: 'GET',
		url: '/Alumno/listarCursosNotasxAlumno',
		data: {
			idalumno: $(this).attr("data-codalumno")
		},
		success: function(resultado) {
			$("#tblcursonota > tbody").html("");
			$.each(resultado, function(index, value){
				$("#tblcursonota > tbody").append("<tr>"+
					"<td>"+value.nomcurso+"</td>"+
					"<td class='text-center'>"+value.credito+"</td>"+
					"<td class='text-center'>"+value.exaparcial+"</td>"+
					"<td class='text-center'>"+value.exafinal+"</td>"+
				"</tr>");
			});
			
		}
	});

});