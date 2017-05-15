package org.foobarspam.cotxox.domain;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Conductor {
	
	@Id @GeneratedValue
	private Integer id;
	
	@NotEmpty
	private String nombre;
	
	@NotNull
	private String matricula;
	
	@NotEmpty
	private String modelo;

	private double mediaValoraciones;
	
	private boolean ocupado = false;

	//lo pide JPA
	public Conductor() {
	}

	public Conductor(String nombre, String matricula, String modelo) {
		this.nombre = nombre;
		this.matricula = matricula;
		this.modelo = modelo;
	}

	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getMatricula() {
		return matricula;
	}
	
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
	public String getModelo() {
		return modelo;
	}
	
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	public double getMediaValoraciones() {
		return mediaValoraciones;
	}

	public boolean isOcupado() {
		return ocupado;
	}
	
	public void setOcupado(boolean ocupado) {
		this.ocupado = ocupado;
	}

	public Integer getId() {
		return id;
	}
}
