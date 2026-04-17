package br.com.antlia.desafio.controller;

import br.com.antlia.desafio.dto.MovimentoRequestDTO;
import br.com.antlia.desafio.dto.MovimentoResponseDTO;
import br.com.antlia.desafio.mapper.MovimentoMapper;
import br.com.antlia.desafio.usecase.BuscarMovimentosUseCase;
import br.com.antlia.desafio.usecase.InserirMovimentoUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movimentos")
@RequiredArgsConstructor
public class MovimentoController {

    private final InserirMovimentoUseCase inserir;
    private final BuscarMovimentosUseCase buscar;
    private final MovimentoMapper mapper;

    @PostMapping
    public ResponseEntity<MovimentoResponseDTO> inserir(
            @RequestBody MovimentoRequestDTO dto) {

        var domain = mapper.toDomain(dto);

        var salvo = inserir.executar(domain);

        return ResponseEntity.ok(mapper.toResponse(salvo));
    }

    @GetMapping
    public ResponseEntity<List<MovimentoResponseDTO>> buscar(
            @RequestParam Integer mes,
            @RequestParam Integer ano) {

        var lista = buscar.executar(mes, ano)
                .stream()
                .map(mapper::toResponse)
                .toList();

        return ResponseEntity.ok(lista);
    }

    @GetMapping(value = "/teste")
    public ResponseEntity<String> teste() {
        return ResponseEntity.ok("TESTE mario");
    }

}
