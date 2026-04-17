package br.com.antlia.desafio.repository;

import br.com.antlia.desafio.model.ProdutoCosifEntity;
import br.com.antlia.desafio.model.ProdutoCosifId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface ProdutoCosifRepository
        extends JpaRepository<ProdutoCosifEntity, ProdutoCosifId> {

    List<ProdutoCosifEntity> findByCodProduto(String codProduto);

    Optional<ProdutoCosifEntity> findByCodProdutoAndCodCosif(
            String codProduto,
            String codCosif
    );
}
