package com.unisinos.tcc.crudapi.service;

import com.unisinos.tcc.crudapi.dto.PessoaDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PessoaService {

    private final List<PessoaDTO> pessoas = new ArrayList<>();
    private long id = 1;


    public PessoaService() {
        pessoas.add(new PessoaDTO(id++, "04000440444", "Pablo Kleim", 22));
    }

    public void cadastrarLivro(PessoaDTO pessoa) {
        pessoas.stream()
                .filter(it -> it.getDocumento().equals(pessoa.getDocumento()))
                .findAny()
                .ifPresentOrElse(it -> {
                            throw new RuntimeException("Já existe uma pessoa cadastrada com essas informações.");
                        },
                        () -> {
                            pessoa.setId(id++);
                            pessoas.add(pessoa);
                        });
    }

    public PessoaDTO consultarPessoaPorDocumento(String documento) {
        return pessoas.stream()
                .filter(it -> it.getDocumento().equals(documento))
                .findAny()
                .orElseThrow(() -> new RuntimeException("Nenhuma pessoa encontrada."));
    }
}