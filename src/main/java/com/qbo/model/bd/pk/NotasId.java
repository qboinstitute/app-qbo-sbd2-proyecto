package com.qbo.model.bd.pk;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Embeddable
public class NotasId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String idalumno;	
	public String idcurso;
}
