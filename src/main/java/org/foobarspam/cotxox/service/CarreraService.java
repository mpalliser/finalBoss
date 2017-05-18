package org.foobarspam.cotxox.service;

import javafx.scene.canvas.GraphicsContext;
import org.foobarspam.cotxox.domain.Conductor;
import org.foobarspam.cotxox.domain.Valoracion;
import org.foobarspam.cotxox.repository.ConductorRepository;
import org.foobarspam.cotxox.repository.ValoracionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;

@Service
public class CarreraService {

	private ConductorRepository poolConductores;
	private ValoracionRepository valoraciones;

	private String origen;
	private String destino;
	private double distancia;
	private int tiempoEsperadoMinutos;
	private String tarjetaCredito;
	private TarifaService tarifa;
	private Conductor conductor;
	private double costeTotal;
	private int totalPropinas;

	
	public CarreraService() {
	}

	@Autowired
	public CarreraService(ConductorRepository poolConductores, ValoracionRepository valoraciones) {
		this.poolConductores = poolConductores;
		this.valoraciones = valoraciones;
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

	public double getDistancia() {
		return distancia;
	}

	public void setDistancia(double distancia) {
		this.distancia = distancia;
	}

	public int getTiempoEsperadoMinutos() {
		return tiempoEsperadoMinutos;
	}

	public void setTiempoEsperadoMinutos(int tiempoEsperadoMinutos) {
		this.tiempoEsperadoMinutos = tiempoEsperadoMinutos;
	}

	public String getTarjetaCredito() {
		return tarjetaCredito;
	}

	public void setTarjetaCredito(String tarjetaCredito) {
		this.tarjetaCredito = tarjetaCredito;
	}
	
	
	public TarifaService getTarifa() {
		return tarifa;
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

	public double getCosteTotal() {
		return costeTotal;
	}

	public void setCosteTotal(double costeTotal) {
		this.costeTotal = costeTotal;
	}

	public int getTotalPropinas() {
		return totalPropinas;
	}

	public void setTotalPropinas(int totalPropinas) {
		this.totalPropinas = totalPropinas;
	}
	
	//-----------------------------------------------------------------------------
	
	public double getCosteEsperado() {
		return tarifa.getCosteTotalEsperado();
	}

	public Conductor asignarConductor() {
		Conductor conductorAsignado = null;
		boolean asignado = false;
		int posicionConsulta = ThreadLocalRandom.current().nextInt(1,(int)poolConductores.count()+1);
		if (hayConductoresLibres() == false) {
			System.out.println("En este momento no queda ningún conductor disponible. Disculpe las molestias ");
			return conductorAsignado;
		}
		while (asignado == false) {
			if (conductorIsOcupado(posicionConsulta) == false) {
				conductorAsignado = poolConductores.findOne(posicionConsulta);
				asignado = true;
				conductorAsignado.setOcupado(true);
			}
			posicionConsulta = ThreadLocalRandom.current().nextInt(1,(int)poolConductores.count()+1);
		}
		return conductorAsignado;
	}

	private boolean hayConductoresLibres() {
		for (Conductor conductor : poolConductores.findAll()) {
			if (conductor.isOcupado() == false) {
				return true;
			}
		}
		return false;
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

	public String nm(){
		String s = "";
		for (Conductor c : poolConductores.findAll()) {
			s += c.getNombre() + " ,";
		}
		return s;
	}
	public double valoracionMedia() {
		double valoracionMedia = 0.0d;
		for (Valoracion valoracion : valoraciones.findAllByConductor(this.conductor)) {
			valoracionMedia += valoracion.getValoracion();
		}
		return valoracionMedia;
	}
}
