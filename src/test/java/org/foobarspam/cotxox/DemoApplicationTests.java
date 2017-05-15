package org.foobarspam.cotxox;

import static org.junit.Assert.*;

import org.foobarspam.cotxox.service.CarreraService;
import org.foobarspam.cotxox.service.TarifaService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Test
	public void contextLoads() {
		
		String tarjetaCredito = "4916119711304546";
		String origen = "Aeroport Son Sant Joan";
		String destino= "Magaluf";
		double distancia = 7.75;
		int tiempoEsperadoMinutos = 10;
		
		TarifaService tarifa = new TarifaService();
		tarifa.setDistancia(distancia);
		tarifa.setMinutos(tiempoEsperadoMinutos);
		
		CarreraService carrera = new CarreraService();
		carrera.setTarjetaCredito(tarjetaCredito);
		carrera.setOrigen(origen);
		carrera.setDestino(destino);
		carrera.setDistancia(distancia);
		carrera.setTiempoEsperadoMinutos(tiempoEsperadoMinutos);
		
		//System.out.println("\n#####" + "\t Set Pickup: \t" + "#####\n" );
		assertEquals(carrera.getTarjetaCredito(), tarjetaCredito);
		assertEquals(carrera.getOrigen(), "Aeroport Son Sant Joan");
		assertEquals(carrera.getDestino(), "Magaluf");
		assertEquals(carrera.getDistancia(), 7.75, 0);
	}

}
