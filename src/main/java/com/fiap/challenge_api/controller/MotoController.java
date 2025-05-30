package com.fiap.challenge_api.controller;

import com.fiap.challenge_api.dto.MotoDTO;
import com.fiap.challenge_api.dto.PosicaoDTO;
import com.fiap.challenge_api.service.MotoService;
import com.fiap.challenge_api.service.PosicaoService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/motos")
public class MotoController {

    @Autowired
    private MotoService service;

    @Autowired
    private PosicaoService posicaoService;

    @Operation(summary = "Listar todas as motos",
            description = "Retorna uma lista com todas as motos cadastradas")
    @GetMapping
    public ResponseEntity<List<MotoDTO>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @Operation(summary = "Listar motos com paginação",
            description = "Retorna uma lista paginada de motos usando os parâmetros do Pageable")
    @GetMapping("/paginado")
    public ResponseEntity<Page<MotoDTO>> findAllPage(Pageable pageable) {
        return ResponseEntity.ok(service.findAllPage(pageable));
    }

    @Operation(summary = "Buscar moto por ID",
            description = "Retorna os dados de uma moto com base no ID fornecido")
    @GetMapping("/{id}")
    public ResponseEntity<MotoDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }

    @Operation(summary = "Buscar moto por placa",
            description = "Retorna as motos que correspondem à placa informada")
    @GetMapping("/buscar")
    public ResponseEntity<List<MotoDTO>> findByPlaca(@RequestParam String placa){
        return ResponseEntity.ok(service.findByPlaca(placa));
    }

    @Operation(summary = "Listar motos por status",
            description = "Retorna as motos que possuem o status informado (ex: ATIVA, INDISPONÍVEL)")
    @GetMapping("/status/{status}")
    public ResponseEntity<List<MotoDTO>> findByStatus(@PathVariable String status){
        return ResponseEntity.ok(service.findByStatus(status));
    }

    @Operation(summary = "Listar posições da moto",
            description = "Retorna todas as posições registradas associadas a uma moto específica")
    @GetMapping("/{id}/posicoes")
    public ResponseEntity<List<PosicaoDTO>> findPosicoesPorMoto(@PathVariable Long id) {
        return ResponseEntity.ok(posicaoService.findByMotoId(id));
    }


    @Operation(summary = "Cadastrar nova moto",
            description = "Cria uma nova moto com os dados fornecidos")
    @PostMapping
    public ResponseEntity<MotoDTO> insert(@RequestBody @Valid MotoDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.insert(dto));
    }

    @Operation(summary = "Atualizar moto",
            description = "Atualiza os dados de uma moto existente com base no ID fornecido")
    @PutMapping("/{id}")
    public ResponseEntity<MotoDTO> update(@PathVariable Long id, @RequestBody @Valid MotoDTO dto){
        return ResponseEntity.ok(service.update(id, dto));
    }

    @Operation(summary = "Excluir moto",
            description = "Remove uma moto do sistema com base no ID informado")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
