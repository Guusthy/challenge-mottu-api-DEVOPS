package com.fiap.challenge_api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "marcador_fixo")
public class MarcadorFixo {

    @Id
    private Long idMarcadorArucoFixo;

    private String codigoAruco;

    @NotNull
    private Float xPos;

    @NotNull
    private Float yPos;

    @ManyToOne
    @JoinColumn(name = "patio_id_patio")
    private Patio patio;

    @OneToMany(mappedBy = "marcadorFixo")
    private List<MedicaoPosicao> medicoes;

    public Long getidMarcadorArucoFixo() {
        return idMarcadorArucoFixo;
    }

    public void setidMarcadorArucoFixo(Long idMarcadorArucoFixo) {
        this.idMarcadorArucoFixo = idMarcadorArucoFixo;
    }

    public Float getxPos() {
        return xPos;
    }

    public void setxPos(Float xPos) {
        this.xPos = xPos;
    }

    public String getCodigoAruco() {
        return codigoAruco;
    }

    public void setCodigoAruco(String codigoAruco) {
        this.codigoAruco = codigoAruco;
    }

    public Patio getPatio() {
        return patio;
    }

    public void setPatio(Patio patio) {
        this.patio = patio;
    }

    public Float getyPos() {
        return yPos;
    }

    public void setyPos(Float yPos) {
        this.yPos = yPos;
    }

    public List<MedicaoPosicao> getMedicoes() {
        return medicoes;
    }

    public void setMedicoes(List<MedicaoPosicao> medicoes) {
        this.medicoes = medicoes;
    }
}
