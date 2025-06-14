package com.literalura.literalura.dto;
import com.fasterxml.jackson.annotation.JsonProperty;

public record AutorDTO(
        @JsonProperty("name") String name,
        @JsonProperty("birth_year") int birthYear,
        @JsonProperty("death_year") int deathYear
) {
}
