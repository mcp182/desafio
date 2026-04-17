package br.com.antlia.desafio.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class MovimentoResponseDTO {

    private Integer mes;
    private Integer ano;
    private Integer numeroLancamento;
    private String codProduto;
    private String codCosif;
    private String descricao;
    private BigDecimal valor;

}
