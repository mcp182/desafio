package br.com.antlia.desafio.usecase;

import br.com.antlia.desafio.model.MovimentoManualEntity;
import br.com.antlia.desafio.repository.MovimentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class InserirMovimentoUseCase {

    @Autowired
    private MovimentoRepository repository;

    public MovimentoManualEntity executar(MovimentoManualEntity movimento) {

        Integer ultimo = repository.buscarUltimoLancamento(
                movimento.getId().getDatMes(),
                movimento.getId().getDatAno()
        );

        movimento.getId().setNumLancamento(ultimo + 1);
        movimento.setDatMovimento(LocalDateTime.now());
        movimento.setCodUsuario("TESTE");

        return repository.save(movimento);
    }
}
