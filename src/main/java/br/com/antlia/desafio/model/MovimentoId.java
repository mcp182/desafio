package br.com.antlia.desafio.model;

import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

@Embeddable
@Data
public class MovimentoId implements Serializable {
    private Integer datMes;
    private Integer datAno;
    private Integer numLancamento;
}
