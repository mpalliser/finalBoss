package org.foobarspam.cotxox.service;

import javafx.scene.canvas.GraphicsContext;
import org.foobarspam.cotxox.domain.Conductor;
import org.foobarspam.cotxox.domain.Valoracion;
import org.foobarspam.cotxox.repository.ConductorRepository;
import org.foobarspam.cotxox.repository.ValoracionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class CarreraService {

	private ConductorRepository poolConductores;
	private ValoracionRepository valoraciones;

	private String origen;
	private String destino;
	private String tarjetaCredito;

	private TarifaService tarifa;

	private Conductor conductor;

	private double costeTotal;
	
	public CarreraService() {
	}

	@Autowired
	public CarreraService(ConductorRepository poolConductores, ValoracionRepository valoraciones) {
		this.poolConductores = poolConductores;
		this.valoraciones = valoraciones;
	}

	public void setValoracion(double valoracion) {
		valoraciones.save(new Valoracion(valoracion, this.conductor));
	}

	public String getOrigen() {
		return origen;
	}
	
	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	//TODO: carrera depende de tarifa para calcular el precio de la carrera.
	// eliminados distancia/minutos de carrera, parametros duplicados.
	public double getDistancia() {
		return tarifa.getDistancia();
	}

	public void setDistancia(double distancia) {
		tarifa.setDistancia(distancia);
	}

	public void setTiempoEsperadoMinutos(int tiempoEsperadoMinutos) {
		this.tarifa.setMinutos(tiempoEsperadoMinutos);
	}

	public String getTarjetaCredito() {
		return tarjetaCredito;
	}

	public void setTarjetaCredito(String tarjetaCredito) {
		this.tarjetaCredito = tarjetaCredito;
	}

	@Autowired
	public void setTarifa(TarifaService tarifa) {
		this.tarifa = tarifa;
	}

	public Conductor getConductor() {
		return conductor;
	}

	public void setConductor(Conductor conductor) {
		this.conductor = conductor;
	}

	
	//-----------------------------------------------------------------------------
	
	public double getCosteEsperado() {
		return tarifa.getCosteTotalEsperado();
	}

	public Conductor asignarConductor() {
		//TODO: añadir try catch para gestionar si no existen conductores libres
		 setConductor(getConductores().findFirstByOcupado(false));
		 return this.conductor;
	}

	private boolean conductorIsOcupado(int conductor) {
		return poolConductores.findOne(conductor).isOcupado();
	}

	public ValoracionRepository getValoraciones() {
		return valoraciones;
	}

	public ConductorRepository getConductores() {
		return this.poolConductores;
	}

	public double valoracionMediaConductor() {
		double valoracionMedia = 0.0d;
		for (Valoracion valoracion : valoraciones.findAllByConductor(this.conductor)) {
			valoracionMedia += valoracion.getValoracion();
		}
		return valoracionMedia / valoraciones.findAllByConductor(this.conductor).size();
	}
}
