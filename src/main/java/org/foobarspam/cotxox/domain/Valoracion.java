package org.foobarspam.cotxox.domain;

import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Generated;
import javax.persistence.*;

/**
 * Created by palliser on 18/05/2017.
 */
@Entity
public class Valoracion {

	@Id @GeneratedValue
	private Long id;

	private double valoracion;

	@ManyToOne(fetch = FetchType.EAGER)
	private Conductor conductor;

	public Valoracion() {
	}

	public Valoracion(double valoracion, Conductor conductor) {
		this.valoracion = valoracion;
		this.conductor = conductor;
	}

	public double getValoracion() {
		return valoracion;
	}
}
