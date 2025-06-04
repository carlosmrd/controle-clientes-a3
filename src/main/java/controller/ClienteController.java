package controller;

import model.Cliente;
import model.ClienteDAO;

public class ClienteController {

    private ClienteDAO clienteDAO;

    public ClienteController(ClienteDAO clienteDAO) {
        this.clienteDAO = clienteDAO;
    }

    public void inserirCliente(Cliente cliente) {
        clienteDAO.inserirCliente(cliente);
    }
}
