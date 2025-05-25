package com.fiap.challenge_api.repository;

import com.fiap.challenge_api.model.MarcadorArucoMovel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MarcadorArucoMovelRepository extends JpaRepository<MarcadorArucoMovel, Long> {

    Optional<MarcadorArucoMovel> findByMoto_IdMoto(Long motoId);

    Optional<MarcadorArucoMovel> findByCodigoAruco(String codigoAruco);
}
