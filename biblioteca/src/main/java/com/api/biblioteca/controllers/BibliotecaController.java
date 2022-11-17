package com.api.biblioteca.controllers;

import com.api.biblioteca.dto.LivrosDto;
import com.api.biblioteca.entity.LivrosEntity;
import com.api.biblioteca.exceptions.ApiErrors;
import com.api.biblioteca.exceptions.BusinessException;
import com.api.biblioteca.mapper.LivrosMapper;
import com.api.biblioteca.services.BibliotecaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class BibliotecaController {

    @Autowired
    BibliotecaService bibliotecaService;

    @GetMapping
    public ResponseEntity<List<LivrosDto>> findAllBooks(){
        List<LivrosEntity> todos = bibliotecaService.toList();
        List<LivrosDto>todosDto =new ArrayList<>();

        for (LivrosEntity entity: todos){
            todosDto.add(LivrosMapper.livrosToDto(entity));

        }
        return ResponseEntity.status(HttpStatus.OK).body(todosDto);


    }
    @GetMapping("/{id}")
    public ResponseEntity<LivrosDto> trazPeloID(@PathVariable Long id) {
        LivrosEntity entity =bibliotecaService.buscaID(id);
        return ResponseEntity.status(HttpStatus.OK).body(LivrosMapper.livrosToDto(entity));


    }
    @PostMapping("/save")
    public ResponseEntity<LivrosDto> salvarCadastroCLiente(@RequestBody @Valid LivrosDto livrosDto) {
        LivrosEntity entity = bibliotecaService.salvarLivro(LivrosMapper.DtoToLivros(livrosDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(LivrosMapper.livrosToDto(entity));


    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrors handleValidationExceptions(MethodArgumentNotValidException exception){
        BindingResult bindingResult = exception.getBindingResult();


        return new ApiErrors(bindingResult);


    }

    @ExceptionHandler(BusinessException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrors handleBusinessException(BusinessException exception){
        return new ApiErrors(exception);


    }
}

