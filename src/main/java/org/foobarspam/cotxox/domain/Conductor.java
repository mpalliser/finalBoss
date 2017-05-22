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

	@OneToMany(fetch = FetchType.EAGER)
	private List<Valoracion> valoraciones;

	//necesario JPA
	public Conductor() {
	}

	public Conductor(String nombre, String matricula, String modelo) {
		this.nombre = nombre;
		this.matricula = matricula;
		this.modelo = modelo;
		this.valoraciones = new ArrayList<>();
	}

	public String getNombre() {
		return nombre;
	}

	public boolean isOcupado() {
		return ocupado;
	}

	public Integer getId() {
		return id;
	}

}
