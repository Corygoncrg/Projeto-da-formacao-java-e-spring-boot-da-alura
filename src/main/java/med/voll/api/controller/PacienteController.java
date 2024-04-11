package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.domain.dto.atualizacao.DadosAtualizacaoMedicoDTO;
import med.voll.api.domain.dto.cadastro.DadosCadastroPacienteDTO;
import med.voll.api.domain.dto.detalhamento.DadosDetalhadosPacienteDTO;
import med.voll.api.domain.dto.listagem.DadosListagemPacienteDTO;
import med.voll.api.domain.model.Paciente;
import med.voll.api.domain.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;


@RestController
@RequestMapping("pacientes")
public class PacienteController {

    @Autowired
    private PacienteRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroPacienteDTO dados, UriComponentsBuilder uribuilder) {
        Paciente paciente = new Paciente(dados);
        URI uri = uribuilder.path("/pacientes/{id}").buildAndExpand(paciente.getId()).toUri();
        repository.save(new Paciente(dados));
        return ResponseEntity.created(uri).body(new DadosDetalhadosPacienteDTO(paciente));
    }

    @GetMapping
    public ResponseEntity <Page<DadosListagemPacienteDTO>> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        Page<DadosListagemPacienteDTO> page = repository.findByAtivoTrue(paginacao).map(DadosListagemPacienteDTO::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar (@RequestBody @Valid DadosAtualizacaoMedicoDTO dados){
        Paciente paciente = repository.getReferenceById(dados.id());
        paciente.atualizarInformacoes(dados);
        return ResponseEntity.ok(new DadosDetalhadosPacienteDTO(paciente));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletar(@PathVariable Long id){
        Paciente paciente = repository.getReferenceById(id);
        paciente.excluir();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity listar (@PathVariable Long id){
        Paciente paciente = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhadosPacienteDTO(paciente));
    }
}


