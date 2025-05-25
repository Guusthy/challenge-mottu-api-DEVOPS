package com.fiap.challenge_api.service;

import com.fiap.challenge_api.dto.MotoDTO;
import com.fiap.challenge_api.mapper.MotoMapper;
import com.fiap.challenge_api.model.Moto;
import com.fiap.challenge_api.repository.MotoRepository;
import com.fiap.challenge_api.service.exception.PlacaInvalidaException;
import com.fiap.challenge_api.service.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class MotoService {

    @Autowired
    private MotoRepository repository;

    @Autowired
    private MotoMapper mapper;

    public List<MotoDTO> findAll(){
        return repository.findAll()
                .stream()
                .map(mapper::toDTO)
                .toList();
    }

    public Page<MotoDTO> findAllPage(Pageable pageable) {
        return repository.findAll(pageable)
                .map(mapper::toDTO);
    }

    public MotoDTO findById(Long id){
        return repository.findById(id)
                .map(mapper::toDTO)
                .orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public List<MotoDTO> findByPlaca(String placa){
        return repository.findByPlacaStartsWithIgnoreCase(placa)
                .stream()
                .map(mapper::toDTO)
                .toList();
    }

    public List<MotoDTO> findByStatus(String status){
        return repository.findByStatusIgnoreCase(status)
                .stream()
                .map(mapper::toDTO)
                .toList();
    }

    public List<MotoDTO> findMotosPorHistoricoDePosicaoNoPatio(Long patioId) {
        return repository.findMotosQuePassaramPorPatio(patioId)
                .stream()
                .map(mapper::toDTO)
                .toList();
    }

    public MotoDTO insert(MotoDTO dto){
        Moto moto = mapper.toEntity(dto);
        moto.setDataCadastro(LocalDate.now());
        return mapper.toDTO(repository.save(moto));
    }

    public MotoDTO update(Long id, MotoDTO dto){
        Moto motoExist = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));

        if(!dto.getPlaca().matches("[A-Z]{3}[0-9][A-Z0-9][0-9]{2}")){
            throw new PlacaInvalidaException("Placa inválida. O padrão deve ser ABC1D23.");
        }

        motoExist.setPlaca(dto.getPlaca());
        motoExist.setModelo(dto.getModelo());
        motoExist.setStatus(dto.getStatus());

        Moto motoAtt = repository.save(motoExist);
        return mapper.toDTO(motoAtt);
    }

    public void delete(Long id){
        Moto moto = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
        repository.delete(moto);
    }

}
