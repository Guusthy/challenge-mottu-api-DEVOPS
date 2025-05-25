package com.fiap.challenge_api.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class MedicaoPosicao {

    @Id
    private Long idMedicao;

    @Column(name = "distancia_m")
    private Double distanciaM;

    @ManyToOne
    @JoinColumn(name = "posicao_id_posicao")
    private Posicao posicao;

    @ManyToOne
    @JoinColumn(name = "marcador_fixo_id_marcador_aruco_fixo")
    private MarcadorFixo marcadorFixo;

    public Long getIdMedicao() {
        return idMedicao;
    }

    public void setIdMedicao(Long idMedicao) {
        this.idMedicao = idMedicao;
    }

    public Double getDistanciaM() {
        return distanciaM;
    }

    public void setDistanciaM(Double distanciaM) {
        this.distanciaM = distanciaM;
    }

    public Posicao getPosicao() {
        return posicao;
    }

    public void setPosicao(Posicao posicao) {
        this.posicao = posicao;
    }

    public MarcadorFixo getMarcadorFixo() {
        return marcadorFixo;
    }

    public void setMarcadorFixo(MarcadorFixo marcadorFixo) {
        this.marcadorFixo = marcadorFixo;
    }
}
