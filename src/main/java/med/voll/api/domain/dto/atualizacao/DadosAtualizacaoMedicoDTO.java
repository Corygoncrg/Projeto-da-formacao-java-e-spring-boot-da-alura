package med.voll.api.domain.dto.atualizacao;

import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.dto.DadosEnderecoDTO;

public record DadosAtualizacaoMedicoDTO(
        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEnderecoDTO endereco) {
}
