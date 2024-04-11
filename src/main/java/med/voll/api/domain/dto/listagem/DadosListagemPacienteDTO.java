package med.voll.api.domain.dto.listagem;

import med.voll.api.domain.model.Paciente;

public record DadosListagemPacienteDTO(Long id, String nome, String email, String cpf, String telefone) {

    public DadosListagemPacienteDTO(Paciente paciente){
        this(paciente.getId(), paciente.getNome(), paciente.getEmail(), paciente.getCpf(), paciente.getTelefone());
    }
}
