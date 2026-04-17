package br.com.antlia.desafio.repository;

import br.com.antlia.desafio.model.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoEntity, Long> {

    @Query("SELECT p FROM ProdutoEntity p WHERE p.staStatus = 'A'")
    List<ProdutoEntity> listarAtivos();

    @Query("SELECT p FROM ProdutoEntity p WHERE p.codProduto = :codigo")
    Optional<ProdutoEntity> buscarPorCodigo(@Param("codigo") String codigo);
}
