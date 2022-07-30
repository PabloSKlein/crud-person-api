package com.unisinos.tcc.crudapi.controller;

import com.unisinos.tcc.crudapi.dto.PessoaDTO;
import com.unisinos.tcc.crudapi.service.PessoaService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@AllArgsConstructor
@RequestMapping("pessoas")
public class PessoasController {

    private final PessoaService service;

    @PostMapping
    @ResponseStatus(CREATED)
    public void cadastrarPessoa(@RequestBody PessoaDTO pessoa) {
        service.cadastrarLivro(pessoa);
    }

    @GetMapping
    @ResponseBody
    @ResponseStatus(OK)
    public PessoaDTO consultarPessoa(@RequestParam String documento) {
        return service.consultarPessoaPorDocumento(documento);
    }
}
