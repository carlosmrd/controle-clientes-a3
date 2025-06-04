import controller.ClienteController;
import database.ConexaoDB;
import database.InicializadorDB;
import model.Cliente;
import model.ClienteDAO;
import view.Menu;

import java.sql.Connection;

public class Main {

    public static void main(String[] args) {

        InicializadorDB.inicializar();
        Connection conexao = ConexaoDB.conectar();

        Menu menu = new Menu();

        ClienteDAO clienteDAO = new ClienteDAO(conexao);
        ClienteController clienteController =  new ClienteController(clienteDAO);

        int opcao;

        do {
            opcao = menu.exibirMenuPrincipal();

            switch (opcao) {
                case 1:
                    menuClientes(menu, clienteController);
                    break;

                case 2:
                    menuAnotacoes(menu);
                    break;

                case 3:
                    menuLembretes(menu);
                    break;

                case 0:
                    System.out.println("Encerrando o sistema.");
                    break;

                default:
                    System.out.println("Opção inválida, tente novamente.");
            }
        } while (opcao != 0);

        ConexaoDB.desconectar(conexao);
    }

    private static void menuClientes(Menu menu, ClienteController clienteController) {
        int opcao;
        do {
            opcao = menu.exibirMenuClientes();

            switch (opcao) {
                case 1:
                    System.out.println("\n-- CADASTRAR CLIENTE --");
                    String nome = menu.lerNomeCliente();
                    String telefone = menu.lerTelefoneCliente();
                    String uf = menu.lerUfCliente();

                    Cliente cliente = new Cliente(nome, telefone, uf);

                    clienteController.inserirCliente(cliente);
                    break;

                case 2:

                    break;

                case 3:

                    break;

                case 4:
                    menuAlterarClientes(menu);
                    break;

                case 5:

                    break;

                case 0:
                    break;

                default:
                    System.out.println("Opção inválida, tente novamente.");
            }
        } while (opcao != 0);
    }

    private static void menuAlterarClientes(Menu menu) {
        int opcao;
        do {
            opcao = menu.exibirMenuAlterarCliente();

            switch (opcao) {
                case 1:

                    break;

                case 2:

                    break;

                case 0:
                    break;

                default:
                    System.out.println("Opção inválida, tente novamente.");
            }
        } while (opcao != 0);
    }

    private static void menuAnotacoes(Menu menu) {
        int opcao;
        do {
            opcao = menu.exibirMenuAnotacoes();

            switch (opcao) {
                case 1:

                    break;

                case 2:

                    break;

                case 3:

                    break;

                case 4:

                    break;

                case 5:

                    break;

                case 0:
                    break;

                default:
                    System.out.println("Opção inválida, tente novamente.");
            }
        } while (opcao != 0);
    }

    private static void menuLembretes(Menu menu) {
        int opcao;
        do {
            opcao = menu.exibirMenuLembretes();

            switch (opcao) {
                case 1:

                    break;

                case 2:

                    break;

                case 3:

                    break;

                case 4:

                    break;

                case 5:

                    break;

                case 0:
                    break;

                default:
                    System.out.println("Opção inválida, tente novamente.");
            }
        } while (opcao != 0);
    }
}
