package br.com.antlia.desafio.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class ProdutoCosifId implements Serializable {
    private Long codProduto;
    private Long codCosif;
}
