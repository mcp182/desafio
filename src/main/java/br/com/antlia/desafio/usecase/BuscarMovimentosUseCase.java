package br.com.antlia.desafio.usecase;

import br.com.antlia.desafio.model.MovimentoManualEntity;
import br.com.antlia.desafio.repository.MovimentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuscarMovimentosUseCase {

    @Autowired
    private MovimentoRepository repository;

    public List<MovimentoManualEntity> executar(Integer mes, Integer ano) {
        return repository.buscar(mes, ano);
    }
}
