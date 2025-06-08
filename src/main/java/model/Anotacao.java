package model;

import java.time.LocalDateTime;

public class Anotacao {

    private int id;
    private int idCliente;
    private String descricaoAnotacao;
    private LocalDateTime dataHora;

    //Construtor de Anotação sem ID e dataHora, usada para inserir no banco de dados
    public Anotacao (int idCliente, String descricaoAnotacao) {
        this.idCliente = idCliente;
        this.descricaoAnotacao = descricaoAnotacao;
    }

    //Construtor de Anotação com todos os dados
    public Anotacao (int id, int idCliente, String descricaoAnotacao, LocalDateTime dataHora) {
        this.id = id;
        this.idCliente = idCliente;
        this.descricaoAnotacao = descricaoAnotacao;
        this.dataHora = dataHora;
    }

    //Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int id) {
        this.idCliente = idCliente;
    }

    public String getDescricaoAnotacao() {
        return descricaoAnotacao;
    }

    public void setDescricaoAnotacao(String descricaoAnotacao) {
        this.descricaoAnotacao = descricaoAnotacao;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }
}
