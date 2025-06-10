package controller;

import model.Lembrete;
import model.LembreteDAO;
import model.Cliente;
import view.Menu;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class LembreteController {

    private LembreteDAO lembreteDAO;
    private ClienteController clienteController;

    //Construtor para o Controller
    public LembreteController(LembreteDAO lembreteDAO) {
        this.lembreteDAO = lembreteDAO;
    }

    //Insere novo lembrete no banco de dados
    public void criarLembrete(Menu menu, ClienteController clienteController) {
        //Instância de cliente para o idCliente do objeto lembrete
        Cliente cliente = clienteController.buscarClientePorId(menu.lerIdCliente());

        if (cliente == null) {
            System.err.println("Cliente não encontrado.\n");
            return;
        }

        System.out.println("\nCliente selecionado: ");
        System.out.println("ID: " + cliente.getId());
        System.out.println("Nome: " + cliente.getNome() + "\n");

        String descricaoLembrete = menu.lerDescricaoLembrete();
        LocalDateTime dataHora = menu.lerDataHoraLembrete();

        Lembrete lembrete = new Lembrete(cliente.getId(), descricaoLembrete, dataHora);

        lembreteDAO.criarLembrete(lembrete);
    }

    public void listarLembretes(Menu menu, ClienteController clienteController) {

        //Cria um ArrayList para armazenar os lembretes
        ArrayList<Lembrete> lembretes = lembreteDAO.listarLembretes();

        //Exibe os lembretes dentro do ArrayList
        for (Lembrete lembrete : lembretes) {
            System.out.println("\nID do cliente: " + lembrete.getIdCliente());

            //Instância de cliente para exibir o nome do cliente associado ao lembrete
            Cliente cliente = clienteController.buscarClientePorId(lembrete.getIdCliente());
            System.out.println("Nome do cliente: " + cliente.getNome());

            System.out.println("ID do lembrete: " + lembrete.getId());
            System.out.println(lembrete.getDescricaoLembrete());

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
            System.out.println("Data e hora: " + lembrete.getDataHora().format(formatter));
        }

        //Mensagem a ser exibida se o ArrayList estiver vazio
        if (lembretes.isEmpty()) {
            System.out.println("\nNenhuma lembrete encontrado para esse cliente.");
        }
    }

    public void buscarLembretes(Menu menu, ClienteController clienteController) {
        //Instância de cliente para o idCliente dos objetos lembrete
        Cliente cliente = clienteController.buscarClientePorId(menu.lerIdCliente());

        if (cliente == null) {
            System.err.println("Cliente não encontrado.\n");
            return;
        }

        System.out.println("\nCliente selecionado: ");
        System.out.println("ID: " + cliente.getId());
        System.out.println("Nome: " + cliente.getNome());

        //Cria um ArrayList para armazenar os lembretes do cliente escolhido
        ArrayList<Lembrete> lembretes = lembreteDAO.buscarLembretes(cliente);

        //Exibe todos os lembretes
        for (Lembrete lembrete : lembretes) {
            System.out.println("\nID do lembrete: " + lembrete.getId());
            System.out.println(lembrete.getDescricaoLembrete());

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
            System.out.println("Data e hora: " + lembrete.getDataHora().format(formatter));
        }

        //Mensagem a ser exibida se o ArrayList estiver vazio
        if (lembretes.isEmpty()) {
            System.out.println("\nNenhuma lembrete encontrado para esse cliente.");
        }
    }

    public void alterarLembrete(Menu menu, ClienteController clienteController) {
        int id = menu.lerIdLembrete();

        //Instância de lembrete para ser alterado
        Lembrete lembrete = lembreteDAO.buscarLembreteId(id);

        if (lembrete == null) {
            System.err.println("Lembrete não encontrado.\n");
            return;
        }

        System.out.println("\nLembrete atual: ");
        System.out.println(lembrete.getDescricaoLembrete()+"\n");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        System.out.println("Data e hora: " + lembrete.getDataHora().format(formatter) + "\n");

        //Redefine a descricaoLembrete e a dataHora do objeto
        lembrete.setDescricaoLembrete(menu.lerNovaDescricaoLembrete());
        lembrete.setDataHora(menu.lerNovaDataHoraLembrete());

        lembreteDAO.alterarLembrete(lembrete);
    }

    public void deletarLembrete(Menu menu, ClienteController clienteController) {
        int id = menu.lerIdLembrete();

        //Instância de lembrete para ser deletada
        Lembrete lembrete = lembreteDAO.buscarLembreteId(id);

        if (lembrete == null) {
            System.err.println("Lembrete não encontrado.\n");
            return;
        }

        System.out.println("\nLembrete ID " + id + ": ");
        System.out.println(lembrete.getDescricaoLembrete());

        if (menu.confirmacaoDesejaContinuar()) {
            lembreteDAO.deletarLembrete(lembrete);
        }
    }
}
