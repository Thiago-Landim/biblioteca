package com.api.biblioteca.dto;

import lombok.*;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LivrosDto {
    private Long id;
    private String titulo;
    private boolean lancamento;
}
