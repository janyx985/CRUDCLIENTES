package sistbancario.main;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestEliminar.class, TestInsercion.class, TestListarTodos.class, TestModificar.class,
		TestObtenerUno.class })
public class AllTests {

}
