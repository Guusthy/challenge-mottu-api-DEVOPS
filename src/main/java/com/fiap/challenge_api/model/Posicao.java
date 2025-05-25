package com.fiap.challenge_api.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Posicao {

    @Id
    private Long idPosicao;

    private Float xPos;

    private Float yPos;

    private LocalDateTime dataHora;

    @ManyToOne
    @JoinColumn(name = "moto_id_moto")
    private Moto moto;


    @ManyToOne
    @JoinColumn(name = "patio_id_patio")
    private Patio patio;

    @OneToMany(mappedBy = "posicao")
    private List<MedicaoPosicao> medicoes;

    public Long getIdPosicao() {
        return idPosicao;
    }

    public void setIdPosicao(Long idPosicao) {
        this.idPosicao = idPosicao;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public Moto getMoto() {
        return moto;
    }

    public void setMoto(Moto moto) {
        this.moto = moto;
    }

    public Patio getPatio() {
        return patio;
    }

    public void setPatio(Patio patio) {
        this.patio = patio;
    }

    public List<MedicaoPosicao> getMedicoes() {
        return medicoes;
    }

    public void setMedicoes(List<MedicaoPosicao> medicoes) {
        this.medicoes = medicoes;
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
