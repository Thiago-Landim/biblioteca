package com.api.biblioteca.repositories;

import com.api.biblioteca.entity.LivrosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface BibliotecaRepository extends JpaRepository<LivrosEntity, Long> {


}
