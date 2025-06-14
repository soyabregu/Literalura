package com.literalura.literalura.service;
import com.literalura.literalura.dto.LibroDto;
import com.literalura.literalura.model.Libro;
import com.literalura.literalura.repository.LibroRepositoryI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class LibroService {

    private RestTemplate clienteApiGutendex;//Restemplate hace solicitudes htp


    public LibroService(RestTemplate clienteApiGutendex) {
        this.clienteApiGutendex = clienteApiGutendex;
    }

    public RespuestaApi buscarLibroPorTitulo(String titulo) {//traigo respuesta como string
        String url = "https://gutendex.com/books/?search=" + titulo;
        return clienteApiGutendex.getForObject(url, RespuestaApi.class);

    }

    @Autowired
    private LibroRepositoryI libroRepository;

        public void registrarLibro(String titulo) {
            RespuestaApi respuesta = buscarLibroPorTitulo(titulo); // hace el request a la API
            List<LibroDto> resultados = respuesta.results(); // obtiene la lista de libros encontrados

            // 👇 Primero se comprueba si hay resultados
            if (!resultados.isEmpty()) {
                LibroDto dto = resultados.get(0); // toma el primer resultado de la lista

                // 👇 Creamos una instancia de nuestra entidad Libro
                Libro libro = new Libro();
                libro.setTitulo(dto.titulo()); // Setea el título
                libro.setAutor(dto.autores().get(0).name()); // Setea el nombre del primer autor
                libro.setIdioma(dto.idiomas().get(0)); // Setea el idioma
                libro.setNumeroDeDescargas(dto.numeroDeDescargas()); // Setea descargas

                libroRepository.save(libro); // Lo guarda en la base de datos
                System.out.println(" Libro guardado: " + libro.getTitulo());
            } else {
                System.out.println(" No se encontraron libros con ese título.");
            }
        }
}