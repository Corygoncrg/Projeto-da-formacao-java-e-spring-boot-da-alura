package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.domain.dto.atualizacao.DadosAtualizacaoMedicoDTO;
import med.voll.api.domain.dto.cadastro.DadosCadastroMedicoDTO;
import med.voll.api.domain.dto.detalhamento.DadosDetalhadosMedicoDTO;
import med.voll.api.domain.dto.listagem.DadosListagemMedicoDTO;
import med.voll.api.domain.model.Medico;
import med.voll.api.domain.repository.MedicoRepository;
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
@RequestMapping("medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroMedicoDTO dados, UriComponentsBuilder uribuilder){
        Medico medico = new Medico(dados);
        repository.save(medico);
        URI uri = uribuilder.path("/medicos/{id}").buildAndExpand(medico.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhadosMedicoDTO(medico));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemMedicoDTO>> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
    Page<DadosListagemMedicoDTO> page = repository.findByAtivoTrue(paginacao).map(DadosListagemMedicoDTO::new);
    return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar (@RequestBody @Valid DadosAtualizacaoMedicoDTO dados){
        Medico medico = repository.getReferenceById(dados.id());
        medico.atualizarInformacoes(dados);
        return ResponseEntity.ok(new DadosDetalhadosMedicoDTO(medico));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deletar(@PathVariable Long id){
        Medico medico = repository.getReferenceById(id);
        medico.excluir();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity listar (@PathVariable Long id){
    Medico medico = repository.getReferenceById(id);
    return ResponseEntity.ok(new DadosDetalhadosMedicoDTO(medico));
    }
}
