package br.com.antlia.desafio.dto;

import br.com.antlia.desafio.model.ProdutoCosifEntity;
import br.com.antlia.desafio.model.ProdutoEntity;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class MovimentoRequestDTO {

    private Integer mes;
    private Integer ano;
    private ProdutoEntity codProduto;
    private ProdutoCosifEntity codCosif;
    private String descricao;
    private BigDecimal valor;

}
