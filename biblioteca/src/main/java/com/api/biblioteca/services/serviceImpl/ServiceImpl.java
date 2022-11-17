package com.api.biblioteca.services.serviceImpl;

import com.api.biblioteca.entity.LivrosEntity;

import java.util.Optional;

public interface ServiceImpl {
    LivrosEntity save(LivrosEntity entity);

    Optional<LivrosEntity> getById(Long id);
}

