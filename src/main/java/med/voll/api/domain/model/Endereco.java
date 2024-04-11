package med.voll.api.domain.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.domain.dto.DadosEnderecoDTO;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {
    private String logradouro;
    private String bairro;
    private String cep;
    private String cidade;
    private String uf;
    private String complemento;
    private String numero;

    public Endereco(DadosEnderecoDTO dados) {
        this.logradouro = dados.logradouro();
        this.bairro = dados.bairro();
        this.cep = dados.cep();
        this.cidade = dados.cidade();
        this.uf = dados.uf();
        this.complemento = dados.complemento();
        this.numero = dados.numero();
    }

    public void atualizarInformacoes(DadosEnderecoDTO endereco) {
        if (this.logradouro != null) {
            this.logradouro = endereco.logradouro();
        }
        if (this.bairro != null) {
            this.bairro = endereco.bairro();

        } if (this.cep != null) {
            this.cep = endereco.cep();

        } if (this.cidade != null) {
            this.cidade = endereco.cidade();

        } if (this.uf != null) {
            this.uf = endereco.uf();

        } if (this.complemento != null) {
            this.complemento = endereco.complemento();

        } if (this.numero != null) {
            this.numero = endereco.numero();
        }
    }
}
