package org.foobarspam.cotxox.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Conductor {
	
	@Id @GeneratedValue
	private Integer id;
	
	private String nombre;
	
	@NotNull
	private String matricula;
	
	private String modelo;
	
	private boolean ocupado = false;

	private double valoracionMedia;

	@OneToMany(fetch = FetchType.EAGER)
	private List<Valoracion> valoraciones;

	//lo pide JPA
	public Conductor() {
	}

	public Conductor(String nombre, String matricula, String modelo) {
		this.nombre = nombre;
		this.matricula = matricula;
		this.modelo = modelo;
		this.valoraciones = new ArrayList<>();
		this.valoracionMedia = 0.0d;
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

	public void setValoracion(double valoracion) {
		this.valoraciones.add(new Valoracion(valoracion, this));
	}

	public List<Valoracion> getValoraciones() {
		return valoraciones;
	}


}
