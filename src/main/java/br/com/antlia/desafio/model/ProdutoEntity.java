package br.com.antlia.desafio.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "PRODUTO")
@Data
public class ProdutoEntity {

    @Id
    private String codProduto;

    private String desProduto;

    private String staStatus;

    @OneToMany(mappedBy = "produto")
    private List<ProdutoCosifEntity> cosifs;
}
