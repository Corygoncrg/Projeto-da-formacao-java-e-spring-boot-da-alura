package med.voll.api.domain.dto.detalhamento;

import med.voll.api.domain.model.Endereco;
import med.voll.api.domain.model.EspecialidadeEnum;
import med.voll.api.domain.model.Medico;

public record DadosDetalhadosMedicoDTO(Long id, String nome, String email, String telefone, String crm, EspecialidadeEnum especialidadeEnum, Endereco endereco) {

    public DadosDetalhadosMedicoDTO(Medico medico){
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getTelefone(), medico.getCrm(), medico.getEspecialidade(), medico.getEndereco());
    }
}
