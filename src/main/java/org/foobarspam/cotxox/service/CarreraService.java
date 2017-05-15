package org.foobarspam.cotxox.service;

import org.foobarspam.cotxox.domain.Conductor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarreraService {
	
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


	
	
	
}
