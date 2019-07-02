package sistbancario.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppSistBancario {

	public static void main(String[] args ) {
		System.out.println("cargando APP Sist Bancario");
		SpringApplication.run(AppSistBancario.class, args);
		System.out.println("APP Sist Bancario listo");
	}
}
