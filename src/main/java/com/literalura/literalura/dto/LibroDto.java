package com.literalura.literalura.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public record LibroDto(
        @JsonProperty("title") String titulo,
        @JsonProperty("authors") List<AutorDTO> autores,
        @JsonProperty("languages") List<String> idiomas,
        @JsonProperty("download_count") int numeroDeDescargas
) {
}

