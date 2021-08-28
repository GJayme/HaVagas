package br.edu.ifsp.havagas.model;

import androidx.annotation.NonNull;

import java.util.Objects;

public class Formulario {
    private final String nome;
    private final String sexo;
    private final String email;
    private final boolean recebeEmail;
    private final String telefone;
    private final String tipoTelefone;
    private final boolean addCelular;
    private final String celular;
    private final String nascimento;
    private final String formacao;
    private final String anoDeFormatura;
    private final String anoGraduacao;
    private final String anoMestrado;
    private final String instituicao;
    private final String monografia;
    private final String orientador;
    private final String vagas;

    public Formulario(String nome, String sexo, String email, boolean recebeEmail,
                      String telefone, String tipoTelefone, boolean addCelular, String celular, String nascimento,
                      String formacao, String anoDeFormatura, String anoGraduacao, String anoMestrado,
                      String instituicao, String monografia,String orientador, String vagas) {
        this.nome = nome;
        this.sexo = sexo;
        this.email = email;
        this.recebeEmail = recebeEmail;
        this.telefone = telefone;
        this.tipoTelefone = tipoTelefone;
        this.addCelular = addCelular;
        this.celular = celular;
        this.nascimento = nascimento;
        this.formacao = formacao;
        this.anoDeFormatura = anoDeFormatura;
        this.anoGraduacao = anoGraduacao;
        this.anoMestrado = anoMestrado;
        this.instituicao = instituicao;
        this.monografia = monografia;
        this.orientador = orientador;
        this.vagas = vagas;
    }

    public String getNome() {
        return nome;
    }

    public String getSexo() {
        return sexo;
    }

    public String getEmail() {
        return email;
    }

    public boolean isRecebeEmail() {
        return recebeEmail;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getTipoTelefone() {
        return tipoTelefone;
    }

    public boolean isAddCelular() {
        return addCelular;
    }

    public String getCelular() {
        return celular;
    }

    public String getNascimento() {
        return nascimento;
    }

    public String getFormacao() {
        return formacao;
    }

    public String getAnoDeFormatura() {
        return anoDeFormatura;
    }

    public String getAnoGraduacao() {
        return anoGraduacao;
    }

    public String getAnoMestrado() {
        return anoMestrado;
    }

    public String getInstituicao() {
        return instituicao;
    }

    public String getMonografia() {
        return monografia;
    }

    public String getOrientador() {
        return orientador;
    }

    public String getVagas() {
        return vagas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Formulario that = (Formulario) o;
        return recebeEmail == that.recebeEmail && addCelular == that.addCelular && Objects.equals(nome, that.nome) && Objects.equals(sexo, that.sexo) && Objects.equals(email, that.email) && Objects.equals(telefone, that.telefone) && Objects.equals(tipoTelefone, that.tipoTelefone) && Objects.equals(celular, that.celular) && Objects.equals(nascimento, that.nascimento) && Objects.equals(formacao, that.formacao) && Objects.equals(anoDeFormatura, that.anoDeFormatura) && Objects.equals(anoGraduacao, that.anoGraduacao) && Objects.equals(anoMestrado, that.anoMestrado) && Objects.equals(instituicao, that.instituicao) && Objects.equals(monografia, that.monografia) && Objects.equals(orientador, that.orientador) && Objects.equals(vagas, that.vagas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, sexo, email, recebeEmail, telefone, tipoTelefone, addCelular, celular, nascimento, formacao, anoDeFormatura, anoGraduacao, anoMestrado, instituicao, monografia, orientador, vagas);
    }

    private String msgCelular() {
        if (addCelular) {
            return "Tem celular?: " + addCelular + '\n' +
                    "Celular: "+ celular + '\n';
        } else {
            return "Tem celular?: " + addCelular + '\n';
        }
    }

    private String msgFormacao() {
        if (formacao.equals("Fundamental") || formacao.equals("Médio")) {
            return "Formação: " + formacao + '\n' +
                    "Ano de formatura: " + anoDeFormatura + '\n';
        }
        else if (formacao.equals("Graduação") || formacao.equals("Especialização")) {
            return "Formação: " + formacao + '\n' +
                    "Ano de conclusão: " + anoGraduacao + '\n' +
                    "Instituição: " + instituicao + '\n';
        } else {
            return "Formação: " + formacao + '\n' +
                    "Ano de conclusão: " + anoMestrado + '\n' +
                    "Instituição: " + instituicao + '\n' +
                    "Título de monografia: " + monografia + '\n' +
                    "Orientador: " + orientador + '\n';
        }
    }

    @NonNull
    @Override
    public String toString() {
        return "Nome: " + nome + '\n'+
                "Sexo: " + sexo + '\n' +
                "Data de nascimento: " + nascimento + '\n' +
                "E-mail: " + email + '\n' +
                "Recebe e-mail?: " + recebeEmail + '\n' +
                "Telefone: " + telefone + '\n' +
                "Tipo de telefone: " + tipoTelefone + '\n' +
                msgCelular() +
                msgFormacao() +
                "Vagas: " + vagas;
    }
}
