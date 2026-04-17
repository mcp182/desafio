package br.com.antlia.desafio.repository;

import br.com.antlia.desafio.model.MovimentoId;
import br.com.antlia.desafio.model.MovimentoManualEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovimentoRepository extends JpaRepository<MovimentoManualEntity, MovimentoId> {


    @Query(value = """
    SELECT MAX(cod_classificacao)
    FROM MovimentoManualEntity
    WHERE mes = :mes AND ano = :ano
""", nativeQuery = true)
    Integer buscarUltimoLancamento(@Param("mes") Integer mes,
                                   @Param("ano") Integer ano);



    @Query("SELECT m FROM MovimentoManualEntity m WHERE m.id.datMes = :mes AND m.id.datAno = :ano")
    List<MovimentoManualEntity> buscar(@Param("mes") Integer mes,
                                       @Param("ano") Integer ano);
}
