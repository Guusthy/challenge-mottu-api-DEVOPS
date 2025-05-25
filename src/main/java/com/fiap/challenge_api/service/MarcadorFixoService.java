package com.fiap.challenge_api.service;

import com.fiap.challenge_api.dto.MarcadorFixoDTO;
import com.fiap.challenge_api.mapper.MarcadorFixoMapper;
import com.fiap.challenge_api.model.MarcadorFixo;
import com.fiap.challenge_api.repository.MarcadorFixoRepository;
import com.fiap.challenge_api.service.exception.MarcadorNotFoundException;
import com.fiap.challenge_api.service.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarcadorFixoService {

    @Autowired
    private MarcadorFixoRepository repository;

    @Autowired
    private MarcadorFixoMapper mapper;

    public List<MarcadorFixoDTO> findAll(){
        return repository.findAll()
                .stream()
                .map(mapper::toDTO)
                .toList();
    }

    public List<MarcadorFixoDTO> findByPatioId(Long patioId) {
        return repository.findByPatioIdPatio(patioId)
                .stream()
                .map(mapper::toDTO)
                .toList();
    }

    public MarcadorFixoDTO findByCodigoAruco(String codigoAruco) {
        MarcadorFixo marcador = repository.findByCodigoAruco(codigoAruco)
                .orElseThrow(() -> new MarcadorNotFoundException(codigoAruco));
        return mapper.toDTO(marcador);
    }

    public MarcadorFixoDTO insert(MarcadorFixoDTO dto){
        MarcadorFixo marcadorFixo = mapper.toEntity(dto);
        return mapper.toDTO(repository.save(marcadorFixo));
    }

    public void delete(Long id){
        MarcadorFixo marcadorFixo = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
        repository.delete(marcadorFixo);
    }


}
