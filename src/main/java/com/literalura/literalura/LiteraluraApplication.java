package com.literalura.literalura;

import com.literalura.literalura.service.LibroService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Scanner;

@SpringBootApplication
public class LiteraluraApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(LiteraluraApplication.class, args);


		//instancia de libro service creo el objeto de esa clase
		LibroService servicio = context.getBean(LibroService.class);

		Scanner teclado = new Scanner(System.in);
		int opcion = -1;

		while (opcion != 0) {
			try {
				System.out.println("\n MENÚ");
				System.out.println("1 - Registrar libro por título");
				System.out.println("2 - Listar libros registrados");
				System.out.println("0 - Salir");

				opcion = Integer.parseInt(teclado.nextLine());

				switch (opcion) {
					case 1:
						System.out.println("Ingresá el título del libro:");
						String titulo = teclado.nextLine();
						servicio.registrarLibro(titulo);
						break;
					case 2:
						servicio.listarLibros();
						break;
					case 0:
						System.out.println(" Chau,  Hasta pronto. ");
						break;
					default:
						System.out.println(" Opción no válida.");
				}

			} catch (Exception e) {
				System.out.println(" Entrada inválida.");
			}
		}

		teclado.close();
	}
}