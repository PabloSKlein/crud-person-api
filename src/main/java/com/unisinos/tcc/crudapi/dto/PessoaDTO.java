package com.unisinos.tcc.crudapi.dto;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class PessoaDTO {
    private long id;
    private String documento;
    private String nome;
    private int idade;
}
