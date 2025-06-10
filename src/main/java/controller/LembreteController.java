package controller;

import model.Anotacao;
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

        String descricaoLembrete = menu.lerDescricaoAnotacao();
        LocalDateTime dataHora = menu.lerDataHoraLembrete();

        Lembrete lembrete = new Lembrete(cliente.getId(), descricaoLembrete, dataHora);

        lembreteDAO.criarLembrete(lembrete);
    }

    public void buscarLembretesCliente(Menu menu, ClienteController clienteController) {
        //Instância de cliente para o idCliente dos objetos lembrete
        Cliente cliente = clienteController.buscarClientePorId(menu.lerIdCliente());

        if (cliente == null) {
            System.err.println("Cliente não encontrado.\n");
            return;
        }

        System.out.println("\nCliente selecionado: ");
        System.out.println("ID: " + cliente.getId());
        System.out.println("Nome: " + cliente.getNome());

        //Cria um ArrayList para armazenar as anotações do cliente escolhido
        ArrayList<Anotacao> lembretes = lembreteDAO.buscarLembretesCliente(cliente);

        //Exibe todas as anotações
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


}
