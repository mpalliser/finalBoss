package org.foobarspam.cotxox;

import org.foobarspam.cotxox.domain.Conductor;
import org.foobarspam.cotxox.service.CarreraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by mariano.palliser on 24/05/2017.
 */
@Component
public class DataLoader {


	CarreraService carrera;

	@Autowired
	public DataLoader(CarreraService carrera) {
		this.carrera = carrera;
	}

	public CarreraService getCarrera() {
		return carrera;
	}

	public void setCarrera(CarreraService carrera) {
		this.carrera = carrera;
	}

	@PostConstruct
	public void inyectarConductores() {
		carrera.getConductores().save(new Conductor("Samantha", "4ABC123", "Chevy Malibu"));
		carrera.getConductores().save(new Conductor("Fox", "SDHJ44", "Toyota Prius"));
		carrera.getConductores().save(new Conductor("Mola", "7JKK555", "Mercedes A"));
		carrera.setValoracion();
	}
}
