package br.com.antlia.desafio.mapper;

import br.com.antlia.desafio.dto.MovimentoRequestDTO;
import br.com.antlia.desafio.dto.MovimentoResponseDTO;
import br.com.antlia.desafio.model.MovimentoId;
import br.com.antlia.desafio.model.MovimentoManualEntity;
import br.com.antlia.desafio.model.ProdutoCosifEntity;
import br.com.antlia.desafio.repository.ProdutoCosifRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MovimentoMapper {

    private final ProdutoCosifRepository cosifRepository;

    public MovimentoManualEntity toEntity(MovimentoManualEntity domain) {

        MovimentoManualEntity entity = new MovimentoManualEntity();

        MovimentoId id = new MovimentoId();
        id.setDatMes(domain.getId().getDatMes());
        id.setDatAno(domain.getId().getDatAno());
        id.setNumLancamento(domain.getId().getNumLancamento());

        entity.setId(id);

        ProdutoCosifEntity cosif = cosifRepository
                .findByCodProdutoAndCodCosif(
                        domain.getCosif().getProduto().getCodProduto(),
                        domain.getCosif().getCodCosif()
                )
                .orElseThrow(() -> new RuntimeException("COSIF não encontrado"));

        entity.setCosif(cosif);

        entity.setDesDescricao(domain.getDesDescricao());
        entity.setValValor(domain.getValValor());
        entity.setDatMovimento(domain.getDatMovimento());
        entity.setCodUsuario(domain.getCodUsuario());

        return entity;
    }

    public MovimentoManualEntity toDomain(MovimentoManualEntity entity) {

        MovimentoManualEntity domain = new MovimentoManualEntity();

        domain.getId().setDatMes(entity.getId().getDatMes());
        domain.getId().setDatAno(entity.getId().getDatAno());
        domain.getId().setNumLancamento(entity.getId().getNumLancamento());

        domain.getCosif().getProduto().setCodProduto(entity.getCosif().getProduto().getCodProduto());
        domain.getCosif().setCodCosif(entity.getCosif().getCodCosif());

        domain.setDesDescricao(entity.getDesDescricao());
        domain.setValValor(entity.getValValor());
        domain.setDatMovimento(entity.getDatMovimento());
        domain.setCodUsuario(entity.getCodUsuario());

        return domain;
    }

    public MovimentoManualEntity toDomain(MovimentoRequestDTO dto) {
        MovimentoManualEntity m = new MovimentoManualEntity();
        m.getId().setDatMes(dto.getMes());
        m.getId().setDatAno(dto.getAno());
        m.getCosif().setProduto(dto.getCodProduto());
        m.setCosif(dto.getCodCosif());
        m.setDesDescricao(dto.getDescricao());
        m.setValValor(dto.getValor());
        return m;
    }

    public MovimentoResponseDTO toResponse(MovimentoManualEntity m) {
        MovimentoResponseDTO dto = new MovimentoResponseDTO();
        dto.setMes(m.getId().getDatMes());
        dto.setAno(m.getId().getDatAno());
        dto.setNumeroLancamento(m.getId().getNumLancamento());
        dto.setCodProduto(m.getCosif().getProduto().getCodProduto());
        dto.setCodCosif(m.getCosif().getCodCosif());
        dto.setDescricao(m.getDesDescricao());
        dto.setValor(m.getValValor());
        return dto;
    }

}
