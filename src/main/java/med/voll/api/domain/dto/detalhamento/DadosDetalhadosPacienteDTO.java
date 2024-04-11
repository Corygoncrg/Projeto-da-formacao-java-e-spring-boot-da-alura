package med.voll.api.domain.dto.detalhamento;

import med.voll.api.domain.model.Paciente;
import med.voll.api.domain.model.Endereco;

public record DadosDetalhadosPacienteDTO(Long id, String nome, String email, String cpf, String telefone, Endereco endereco) {
    public DadosDetalhadosPacienteDTO(Paciente paciente){
        this(paciente.getId(), paciente.getNome(), paciente.getEmail(), paciente.getCpf(), paciente.getTelefone(), paciente.getEndereco());
    }
}
