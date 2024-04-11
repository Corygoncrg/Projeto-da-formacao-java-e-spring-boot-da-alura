package med.voll.api.domain.dto.listagem;

import med.voll.api.domain.model.Medico;
import med.voll.api.domain.model.EspecialidadeEnum;

public record DadosListagemMedicoDTO(Long id, String nome, String email, String crm, EspecialidadeEnum especialidade) {

    public DadosListagemMedicoDTO(Medico medico) {
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }

}
