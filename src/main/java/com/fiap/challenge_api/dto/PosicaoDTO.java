package com.fiap.challenge_api.dto;

import lombok.*;
import org.springframework.boot.convert.DataSizeUnit;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PosicaoDTO {

    private Long idPosicao;
    private Float xPos;
    private Float yPos;
    private LocalDateTime dataHora;
    private Long idMoto;
    private Long idPatio;

    public Long getIdPosicao() {
        return idPosicao;
    }

    public void setIdPosicao(Long idPosicao) {
        this.idPosicao = idPosicao;
    }

    public Long getIdPatio() {
        return idPatio;
    }

    public void setIdPatio(Long idPatio) {
        this.idPatio = idPatio;
    }

    public Long getIdMoto() {
        return idMoto;
    }

    public void setIdMoto(Long idMoto) {
        this.idMoto = idMoto;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public Float getyPos() {
        return yPos;
    }

    public void setyPos(Float yPos) {
        this.yPos = yPos;
    }

    public Float getxPos() {
        return xPos;
    }

    public void setxPos(Float xPos) {
        this.xPos = xPos;
    }
}
