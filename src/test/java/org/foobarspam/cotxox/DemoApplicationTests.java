package org.foobarspam.cotxox;

import static org.junit.Assert.*;

import org.foobarspam.cotxox.domain.Conductor;
import org.foobarspam.cotxox.domain.Valoracion;
import org.foobarspam.cotxox.service.CarreraService;
import org.foobarspam.cotxox.service.TarifaService;
import org.junit.Before;
import org.junit.BeforeClass;
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


	//TODO: recordar que Before se ejecuta antes de cada caso test
	@Before
	public void setUp(){

		//fijamos los parametros de carrera
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

		carrera.setDistancia(5.00);
		carrera.setTiempoEsperadoMinutos(5);
		assertEquals( 8.5, carrera.getCosteEsperado(), 0 );
	}

	@Test
	public void testPool() {
		//Creamos 3 conductores
		carrera.getConductores().save(new Conductor("Samantha", "4ABC123", "Chevy Malibu"));
		carrera.getConductores().save(new Conductor("Fox", "SDHJ44", "Toyota Prius"));
		carrera.getConductores().save(new Conductor("Mola", "7JKK555", "Mercedes A"));

		assertEquals("Samantha", carrera.getConductores().findOne(1).getNombre());
		//Crea 6 conductores por los loles
		assertEquals(3,carrera.getConductores().count());
		//assertEquals(4.00, poolConductores.findOne(1).getmediaValoraciones(), 0);

	}

	@Test
	public void testAsignarConductor() {

		//Creamos 3 conductores
		carrera.getConductores().save(new Conductor("Samantha", "4ABC123", "Chevy Malibu"));
		carrera.getConductores().save(new Conductor("Fox", "SDHJ44", "Toyota Prius"));
		carrera.getConductores().save(new Conductor("Mola", "7JKK555", "Mercedes A"));


		assertTrue(carrera.getConductores().exists(carrera.asignarConductor().getId()));
		//assertEquals("Mola", carrera.asignarConductor().getNombre());

	}

	@Test
	public void testValoraciones() {

		carrera.getConductores().save(new Conductor("Samantha", "4ABC123", "Chevy Malibu"));
		carrera.getConductores().save(new Conductor("Fox", "SDHJ44", "Toyota Prius"));
		carrera.getConductores().save(new Conductor("Mola", "7JKK555", "Mercedes A"));

		//TODO: no es posible acceder a valoraciones desde conductor
		//Añadimos valoraciones
		carrera.setConductor(carrera.getConductores().findOne(1));
		carrera.setValoracion(5);
		carrera.setValoracion(3);
		carrera.setValoracion(4);

		//TODO: equals peta al comprobar el mismo conductor de la bbdd y desde la carrera.
		//no peta al comprobar sus propiedades :s
		assertEquals(carrera.getConductor().getId(), carrera.getConductores().findOne(1).getId());
		assertEquals(3,carrera.getConductores().count());

		assertEquals(5, carrera.getValoraciones().findFirstByConductor(carrera.getConductor()).getValoracion(), 0);
		assertEquals(3, carrera.getValoraciones().findAllByConductor(carrera.getConductor()).size());
		assertEquals(carrera.valoracionMediaConductor(), 4.00, 0);
	}

}
