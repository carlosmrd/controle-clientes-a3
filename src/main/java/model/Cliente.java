package model;

import java.time.LocalDateTime;

public class Cliente {

    private int id;
    private String nome;
    private String telefone;
    private String uf;
    private String cidade;
    private String endereco;
    private String cpf;
    private String numeroProcesso;
    private int statusCliente;
    private LocalDateTime dataCadastro;

    public Cliente() {}

    public Cliente(int id, String nome, String telefone, String uf, String cidade,
                   String endereco, String cpf, String numeroProcesso, int statusCliente,
                   LocalDateTime dataCadastro) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.uf = uf;
        this.cidade = cidade;
        this.endereco = endereco;
        this.cpf = cpf;
        this.numeroProcesso = numeroProcesso;
        this.statusCliente = statusCliente;
        this.dataCadastro = dataCadastro;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNumeroProcesso() {
        return numeroProcesso;
    }

    public void setNumeroProcesso(String numeroProcesso) {
        this.numeroProcesso = numeroProcesso;
    }

    public int getStatusCliente() {
        return statusCliente;
    }

    public void setStatusCliente(int statusCliente) {
        this.statusCliente = statusCliente;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
}