package med.voll.api.domain.dto.cadastro;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.domain.dto.DadosEnderecoDTO;
import med.voll.api.domain.model.EspecialidadeEnum;

public record DadosCadastroMedicoDTO(
        @NotBlank String nome,
        @NotBlank @Email String email,
        @NotNull @Pattern(regexp = "\\d{4,6}") String crm,
        @NotBlank String telefone,

        @NotNull EspecialidadeEnum especialidade,
        @NotNull @Valid DadosEnderecoDTO endereco) {
}
