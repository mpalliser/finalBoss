package org.foobarspam.cotxox;

import static org.junit.Assert.*;

import org.foobarspam.cotxox.domain.Conductor;
import org.foobarspam.cotxox.repository.ConductorRepository;
import org.foobarspam.cotxox.service.CarreraService;
import org.foobarspam.cotxox.service.TarifaService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Autowired
	CarreraService carrera;
	@Autowired
	TarifaService tarifa;
	@Autowired
	ConductorRepository poolConductores;

	@Before
	public void setUp(){

		tarifa.setDistancia(7.75);
		tarifa.setMinutos(10);

		carrera.setTarjetaCredito("4916119711304546");
		carrera.setOrigen("Aeroport Son Sant Joan");
		carrera.setDestino("Magaluf");
		carrera.setDistancia(7.75);
		carrera.setTiempoEsperadoMinutos(10);


	}
	@Test
	public void inicializarServicios() {

		//Set Pickup
		assertEquals(carrera.getTarjetaCredito(), "4916119711304546");
		assertEquals(carrera.getOrigen(), "Aeroport Son Sant Joan");
		assertEquals(carrera.getDestino(), "Magaluf");
		assertEquals(carrera.getDistancia(), 7.75, 0);
	}

	@Test
	public void getCosteEsperado(){

		//See your Cost
		assertEquals(13.9625, carrera.getCosteEsperado(), 0);
	}

	@Test
	public void testPool() {

		assertEquals(3,poolConductores.count());
		assertEquals("Samantha", poolConductores.findOne(1).getNombre());
		//assertEquals(4.00, poolConductores.findOne(1).getmediaValoraciones(), 0);

	}

	@Test
	public void testAsignarConductor() {

		assertTrue(poolConductores.exists(carrera.asignarConductor().getId()));
		//assertEquals("Mola", carrera.asignarConductor().getNombre());

	}

	@Test
	public void testValoracionMedia() {

		assertEquals(4.50, poolConductores.findOne(1).getValoracionMedia(), 0);
		assertEquals(4.00, poolConductores.findOne(2).getValoracionMedia(), 0);
		assertEquals(2.50, poolConductores.findOne(3).getValoracionMedia(), 0);

	}
}
