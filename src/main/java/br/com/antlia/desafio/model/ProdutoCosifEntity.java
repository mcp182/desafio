package br.com.antlia.desafio.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "PRODUTO_COSIF")
@IdClass(ProdutoCosifId.class)
@Data
public class ProdutoCosifEntity {

    @Id
    @Column(name = "cod_produto")
    private String codProduto;

    @Id
    @Column(name = "cod_cosif")
    private String codCosif;

    @Column(name = "cod_classificacao")
    private String codClassificacao;

    @Column(name = "sta_status")
    private String staStatus;

    @ManyToOne
    @JoinColumn(name = "cod_produto", insertable = false, updatable = false)
    private ProdutoEntity produto;
}