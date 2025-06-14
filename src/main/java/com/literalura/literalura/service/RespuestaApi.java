package com.literalura.literalura.service;

import com.literalura.literalura.dto.LibroDto;

import java.util.List;

public record RespuestaApi(List<LibroDto> results) {//este campo viene en el json

}

