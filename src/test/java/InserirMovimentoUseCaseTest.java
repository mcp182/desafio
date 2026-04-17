import br.com.antlia.desafio.model.MovimentoId;
import br.com.antlia.desafio.model.MovimentoManualEntity;
import br.com.antlia.desafio.repository.MovimentoRepository;
import br.com.antlia.desafio.usecase.InserirMovimentoUseCase;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

//Teste Incompleto
class InserirMovimentoUseCaseTest {

    @Mock
    MovimentoRepository repository;

    @InjectMocks
    InserirMovimentoUseCase useCase;

    @Test
    void deveGerarLancamentoCorretamente() {

        MovimentoManualEntity mov = new MovimentoManualEntity();
        MovimentoId id = new MovimentoId();
        id.setDatMes(2);
        id.setDatAno(2024);

        mov.setId(id);

        when(repository.buscarUltimoLancamento(2, 2024)).thenReturn(10);

        useCase.executar(mov);

        assertEquals(11, mov.getId().getNumLancamento());
        assertEquals("TESTE", mov.getCodUsuario());
    }
}
