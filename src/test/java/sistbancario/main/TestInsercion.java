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

public class TestInsercion {
	
	@Autowired
	TestEntityManager entityManager;
	@Autowired
	IClienteDAO dao;

	@Before
	public void setUp() throws Exception {
	}
	
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void cuandoInserta1EntoncesRetorna1() {
		this.dao.save(new Cliente("11111111-1","Cutito","Muñoz","negro@perro.cl","12345678"));
		int largo = this.dao.findAll().size();
		assertTrue("\n*****1- Es de largo 1 pero retorna " + largo, largo == 1);
	}
	
	

}
