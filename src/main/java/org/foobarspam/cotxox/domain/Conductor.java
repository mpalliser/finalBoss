package org.foobarspam.cotxox.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

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
	
	private boolean ocupado = false;

	private double valoracionMedia;

	@ElementCollection(fetch = FetchType.EAGER)
	private List<Double> valoraciones= new ArrayList<>();

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

	public boolean isOcupado() {
		return ocupado;
	}
	
	public void setOcupado(boolean ocupado) {
		this.ocupado = ocupado;
	}

	public Integer getId() {
		return id;
	}

	public double getValoracionMedia() {

		double valoracion = 0;
		for (int i = 0; i < valoraciones.size(); i++) {
			valoracion += valoraciones.get(i);
		}
		return valoracion / valoraciones.size();

	}

	public void setValoracionMedia(double valoracionMedia) {
		this.valoracionMedia = valoracionMedia;
	}

	public List<Double> getValoraciones() {
		return valoraciones;
	}

	public void setValoracion(double valoracion) {
		this.valoraciones.add(valoracion);
	}
}
