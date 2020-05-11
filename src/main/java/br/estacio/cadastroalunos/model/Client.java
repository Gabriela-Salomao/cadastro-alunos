package br.estacio.cadastroalunos.model;

import java.sql.Date;

/**
 *
 * @author Gabi
 */
public class Client{
    private Integer nucontrato;
    private String nome;
    private String dtnascimento;
    private String rg;
    private String cpf;
    private String curso;
    private String dtmatricula;
    private String observacoes;
    private String genero;
    private String foto;
    
    public Client(Integer nucontrato, String nome, String dtnascimento, String rg, String cpf, String curso, String dtmatricula, String observacoes, String genero, String foto) {
        this.nucontrato = nucontrato;
        this.nome = nome;
        this.dtnascimento = dtnascimento;
        this.rg = rg;
        this.cpf = cpf;
        this.curso = curso;
        this.dtmatricula = dtmatricula;
        this.observacoes = observacoes;
        this.genero = genero;
        this.foto = foto;
    }

    public Client() {
    }

    public Integer getNucontrato() {
        return nucontrato;
    }

    public void setNucontrato(Integer nucontrato) {
        this.nucontrato = nucontrato;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDtnascimento() {
        return dtnascimento;
    }

    public void setDtnascimento(String dtnascimento) {
        this.dtnascimento = dtnascimento;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getDtmatricula() {
        return dtmatricula;
    }

    public void setDtmatricula(String dtmatricula) {
        this.dtmatricula = dtmatricula;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    @Override
    public String toString() {
        return "Client{" + "nucontrato=" + nucontrato + ", nome=" + nome + ", dtnascimento=" + dtnascimento + ", rg=" + rg + ", cpf=" + cpf + ", curso=" + curso + ", dtmatricula=" + dtmatricula + ", observacoes=" + observacoes + ", genero=" + genero + ", foto=" + foto + '}';
    }
}
