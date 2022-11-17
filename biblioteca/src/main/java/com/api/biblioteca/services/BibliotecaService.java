package com.api.biblioteca.services;

import com.api.biblioteca.entity.LivrosEntity;
import com.api.biblioteca.exceptions.BusinessException;
import com.api.biblioteca.repositories.BibliotecaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class BibliotecaService {

    @Autowired
    BibliotecaRepository bibliotecaRepository;

    public List<LivrosEntity> toList() {
        return bibliotecaRepository.findAll();


    }

    public LivrosEntity findByIdorThrowBadRequestException(Long id) {
        return bibliotecaRepository.findById(id)

                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Livro Não Encontrado"));


    }
    public LivrosEntity buscaID(Long id) {
        return findByIdorThrowBadRequestException(id);

    }
    public LivrosEntity salvarLivro(LivrosEntity entity) {


        return bibliotecaRepository.save(entity);


    }
}
