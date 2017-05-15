package org.foobarspam.cotxox.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class TarifaService {
	
	private double COSTEMILLA = 1.35;
	private double COSTEMINUTO = 0.35;
	private double 	COSTEMINIMO = 5.00;
	private double distancia;
	private double minutos;
	
	
	public TarifaService() {
	}

	public void setDistancia(double distancia) {
		this.distancia = distancia;
	}

	public void setMinutos(double minutos) {
		this.minutos = minutos;
	}

	public double getCosteDistancia(double distancia){
		return distancia * COSTEMILLA;
	}
	
	public double getCosteTiempo(double minutos){
		return minutos * COSTEMINUTO;
	}
	
	public double getCosteTotalEsperado(){
		double costeTotal = getCosteDistancia(distancia) + getCosteTiempo(minutos);
		if (costeTotal > COSTEMINIMO){
			return costeTotal;
		}
		return COSTEMINIMO;
	}
	
}
