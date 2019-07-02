package sistbancario.main;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import sistbancario.main.dao.IClienteDAO;
import sistbancario.main.modelo.Cliente;


@RunWith(SpringRunner.class)
@DataJpaTest

public class TestEliminar {
	
	@Autowired
	TestEntityManager entityManager;
	@Autowired
	IClienteDAO dao;


	@Before
	public void setUp() throws Exception {
		Cliente cliente = new Cliente("16014814-4","Alejandra","Muñoz","ale@holi.cl","12345678");
		this.entityManager.persist(cliente);
		cliente = new Cliente("10123456-7","Piru","Muñoz","perro@lala.cl","87654321");
		this.entityManager.persist(cliente);
		cliente = new Cliente("11222333-4","Cutito","Muñoz","negro@perro.cl","12345678");
		this.entityManager.persist(cliente);
	}
	
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void cuandoElimina1Quedan2Registros() {
		this.dao.deleteById("16014814-4");
		int largo = this.dao.findAll().size();
		assertTrue("\n*****1- Es de largo 2 pero retorna " + largo, largo == 2);
	}

}
