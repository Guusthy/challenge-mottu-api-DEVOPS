package com.fiap.challenge_api.service;

import com.fiap.challenge_api.dto.PatioDTO;
import com.fiap.challenge_api.mapper.PatioMapper;
import com.fiap.challenge_api.model.Patio;
import com.fiap.challenge_api.repository.PatioRepository;
import com.fiap.challenge_api.service.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatioService {

    @Autowired
    private PatioRepository repository;

    @Autowired
    private PatioMapper mapper;

    public List<PatioDTO> findAll(){
        return repository.findAll()
                .stream()
                .map(mapper::toDTO)
                .toList();
    }

    public PatioDTO findById(Long id){
        return repository.findById(id)
                .map(mapper::toDTO)
                .orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public List<PatioDTO> findPatiosComMotos(){
        return repository.findPatiosComMotos()
                .stream()
                .map(mapper::toDTO)
                .toList();
    }

    public PatioDTO insert(PatioDTO dto){
        Patio patio = mapper.toEntity(dto);
        return mapper.toDTO(repository.save(patio));
    }

    public PatioDTO update(Long id, PatioDTO dto){
        Patio patioExist = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
        patioExist.setNome(dto.getNome());
        patioExist.setLocalizacao(dto.getLocalizacao());
        patioExist.setDescricao(dto.getDescricao());

        Patio patioAtt = repository.save(patioExist);
        return mapper.toDTO(patioAtt);
    }

    public void delete(Long id){
        Patio patio = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
        repository.delete(patio);
    }


}
