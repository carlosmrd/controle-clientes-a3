package controller;

import model.Anotacao;
import model.AnotacaoDAO;
import model.Cliente;
import view.Menu;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class AnotacaoController {

    private AnotacaoDAO anotacaoDAO;
    private ClienteController clienteController;

    //Construtor para o Controller
    public AnotacaoController(AnotacaoDAO anotacaoDAO) {
        this.anotacaoDAO = anotacaoDAO;
    }

    //Insere nova anotação no banco de dados
    public void criarAnotacao(Menu menu, ClienteController clienteController) {
        //Instância de cliente para o idCliente do objeto anotacao
        Cliente cliente = clienteController.buscarClientePorId(menu.lerIdCliente());

        if (cliente == null) {
            System.err.println("Cliente não encontrado.\n");
            return;
        }

        System.out.println("\nCliente selecionado: ");
        System.out.println("ID: " + cliente.getId());
        System.out.println("Nome: " + cliente.getNome() + "\n");

        String descricaoAnotacao = menu.lerDescricaoAnotacao();

        Anotacao anotacao = new Anotacao(cliente.getId(), descricaoAnotacao);

        anotacaoDAO.criarAnotacao(anotacao);
    }

    public void buscarAnotacoes(Menu menu, ClienteController clienteController) {
        //Instância de cliente para o idCliente dos objetos anotacao
        Cliente cliente = clienteController.buscarClientePorId(menu.lerIdCliente());

        if (cliente == null) {
            System.err.println("Cliente não encontrado.\n");
            return;
        }

        System.out.println("\nCliente selecionado: ");
        System.out.println("ID: " + cliente.getId());
        System.out.println("Nome: " + cliente.getNome());

        //Cria um ArrayList para armazenar as anotações do cliente escolhido
        ArrayList<Anotacao> anotacoes = anotacaoDAO.buscarAnotacoes(cliente);

        //Exibe todas as anotações
        for (Anotacao anotacao : anotacoes) {
            System.out.println("\nID da anotação: " + anotacao.getId());
            System.out.println(anotacao.getDescricaoAnotacao());

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
            System.out.println("Data da anotação: " + anotacao.getDataHora().format(formatter));
        }

        //Mensagem a ser exibida se o ArrayList estiver vazio
        if (anotacoes.isEmpty()) {
            System.out.println("\nNenhuma anotação encontrada para esse cliente.");
        }
    }

    public void alterarAnotacao(Menu menu, ClienteController clienteController) {
        int id = menu.lerIdAnotacao();

        //Instância de anotação para ser alterada
        Anotacao anotacao = anotacaoDAO.buscarAnotacaoId(id);

        if (anotacao == null) {
            System.err.println("Anotação não encontrada.\n");
            return;
        }

        System.out.println("\nAnotação atual: ");
        System.out.println(anotacao.getDescricaoAnotacao()+"\n");

        //Redefine a descricaoAnotaçao do objeto
        anotacao.setDescricaoAnotacao(menu.lerNovaDescricaoAnotacao());

        anotacaoDAO.alterarAnotacao(anotacao);
    }

    public void deletarAnotacao(Menu menu, ClienteController clienteController) {
        int id = menu.lerIdAnotacao();

        //Instância de anotação para ser deletada
        Anotacao anotacao = anotacaoDAO.buscarAnotacaoId(id);

        if (anotacao == null) {
            System.err.println("Anotação não encontrada.\n");
            return;
        }

        System.out.println("\nAnotação ID " + id + ": ");
        System.out.println(anotacao.getDescricaoAnotacao());

        if (menu.confirmacaoDesejaContinuar()) {
            anotacaoDAO.deletarAnotacao(anotacao);
        }
    }
}
