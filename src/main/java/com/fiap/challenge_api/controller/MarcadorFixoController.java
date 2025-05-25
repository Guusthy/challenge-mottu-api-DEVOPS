package com.fiap.challenge_api.controller;

import com.fiap.challenge_api.dto.MarcadorFixoDTO;
import com.fiap.challenge_api.service.MarcadorFixoService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/marcadores-fixos")
public class MarcadorFixoController {

    @Autowired
    private MarcadorFixoService service;

    @Operation(summary = "Listar todos os marcadores fixos",
            description = "Retorna uma lista com todos os marcadores ArUco fixos cadastrados")
    @GetMapping
    public ResponseEntity<List<MarcadorFixoDTO>> findALl(){
        return ResponseEntity.ok(service.findAll());
    }

    @Operation(summary = "Listar marcadores fixos por pátio",
            description = "Retorna todos os marcadores fixos associados a um pátio específico")
    @GetMapping("/por-patio/{patioId}")
    public ResponseEntity<List<MarcadorFixoDTO>> findByPatioId(@PathVariable Long patioId) {
        return ResponseEntity.ok(service.findByPatioId(patioId));
    }

    @Operation(summary = "Buscar marcador fixo por código ArUco",
            description = "Retorna um marcador fixo a partir do código ArUco fornecido")
    @GetMapping("/por-codigo")
    public ResponseEntity<MarcadorFixoDTO> findByCodigoAruco(@RequestParam String codigoAruco) {
        return ResponseEntity.ok(service.findByCodigoAruco(codigoAruco));
    }

    @Operation(summary = "Cadastrar novo marcador fixo",
            description = "Cria um novo marcador ArUco fixo no sistema")
    @PostMapping
    public ResponseEntity<MarcadorFixoDTO> insert(@RequestBody @Valid MarcadorFixoDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.insert(dto));
    }

    @Operation(summary = "Excluir marcador fixo",
            description = "Remove um marcador fixo com base no ID informado")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
