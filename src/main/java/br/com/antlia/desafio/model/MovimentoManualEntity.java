package br.com.antlia.desafio.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "MOVIMENTO_MANUAL")
@Data
public class MovimentoManualEntity {

    @EmbeddedId
    private MovimentoId id;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "cod_produto"),
            @JoinColumn(name = "cod_cosif")
    })
    private ProdutoCosifEntity cosif;

    @Column(name = "des_descricao")
    private String desDescricao;

    @Column(name = "dat_movimento")
    private LocalDateTime datMovimento;

    @Column(name = "cod_usuario")
    private String codUsuario;

    @Column(name = "val_valor")
    private BigDecimal valValor;
}