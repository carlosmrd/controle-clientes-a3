package model;

import java.time.LocalDateTime;

public class Lembrete {

    private int id;
    private int idCliente;
    private String descricaoLembrete;
    private LocalDateTime dataHora;

    //Construtor de Lembrete sem ID e dataHora, usada para inserir no banco de dados
    public Lembrete (int idCliente, String descricaoLembrete, LocalDateTime dataHora) {
        this.idCliente = idCliente;
        this.descricaoLembrete = descricaoLembrete;
        this.dataHora = dataHora;
    }

    //Construtor de Lembrete com todos os dados
    public Lembrete (int id, int idCliente, String descricaoLembrete, LocalDateTime dataHora) {
        this.id = id;
        this.idCliente = idCliente;
        this.descricaoLembrete = descricaoLembrete;
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

    public String getDescricaoLembrete() {
        return descricaoLembrete;
    }

    public void setDescricaoLembrete(String descricaoLembrete) {
        this.descricaoLembrete = descricaoLembrete;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }
}
