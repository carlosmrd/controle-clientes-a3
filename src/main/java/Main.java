import controller.ClienteController;
import database.ConexaoDB;
import database.InicializadorDB;
import model.ClienteDAO;
import view.Menu;

import java.sql.Connection;


public class Main {
    
    public static void main(String[] args) {

        //Estabelece uma conexão e cria o banco de dados caso ele ainda não exista.
        InicializadorDB.inicializar();
        //Estabelece uma conexão com o banco de dados.
        Connection conexao = ConexaoDB.conectar();
        //Cria uma instância do menu para ser chamado durante a navegação no Main.
        Menu menu = new Menu();
        //Cria uma instância dos DAO de Cliente, Lembrete e Anotacão, com a
        //conexão como parâmetro, para acesso a cada tabela do banco de dados.
        ClienteDAO clienteDAO = new ClienteDAO(conexao);
        //Cria uma instância dos Controller de Cliente, Lembrete e Anotacão, com os
        //DAO como parâmetro, para as funções relacionadas a cada tabela.
        ClienteController clienteController =  new ClienteController(clienteDAO);

        int opcao;

        do {
            //Exibe o menu principal
            opcao = menu.exibirMenuPrincipal();

            switch (opcao) {
                case 1:
                    //1. Clientes
                    menuClientes(menu, clienteController);
                    break;

                case 2:
                    //2. Anotações
                    menuAnotacoes(menu);
                    break;

                case 3:
                    //3. Lembretes
                    menuLembretes(menu);
                    break;

                case 0:
                    //0. Voltar
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
            //Exibe o menu "1. Clientes"
            opcao = menu.exibirMenuClientes();

            switch (opcao) {
                case 1:
                    //1. Cadastrar cliente
                    clienteController.cadastrarCliente(menu);
                    break;

                case 2:
                    //2. Listar clientes
                    //TODO
                    break;

                case 3:
                    //3. Buscar cliente
                    try {
                        clienteController.buscarCliente(menu);
                    } catch (Exception e) {
                        System.err.println("Erro ao buscar o cliente especificado: " + e + "\n");
                    }
                    //TODO
                    break;

                case 4:
                    //4. Alterar cliente
                    menuAlterarClientes(menu, clienteController);
                    break;

                case 5:
                    //5. Excluir cliente
                    menuDeletarClientes(menu, clienteController);
                    break;

                case 0:
                    //0. Voltar
                    break;

                default:
                    System.out.println("Opção inválida, tente novamente.");
            }
        } while (opcao != 0);
    }

    private static void menuAlterarClientes(Menu menu, ClienteController clienteController) {
        //Recebe o id que será usado para selecionar o cliente para a atualização
        int id = menu.lerIdCliente();

        int opcao;

        do {
            //Exibe o submenu "4. Alterar cliente"
            opcao = menu.exibirMenuAlterarCliente();

            switch (opcao) {
                case 1:
                    //1. Alterar todos os campos
                    clienteController.alterarCliente01(menu, id);
                    break;

                case 2:
                    //2. Selecionar um campo para alterar
                    clienteController.alterarCliente02(menu, id);
                    break;

                case 0:
                    //0. Voltar
                    break;

                default:
                    System.out.println("Opção inválida, tente novamente.");
            }
        } while (opcao != 0);
    }
    
    private static void menuDeletarClientes(Menu menu, ClienteController clienteController){
        int id = menu.lerIdCliente();

        int opcao;

        //Exibe o submenu "Deseja mesmo prosseguir?"
        opcao = menu.exibirMenuDeletarCliente();
        switch (opcao) {
            case 1:
                //1. Prosseguir
                clienteController.deletarCliente(id);
                break;
            case 0 :
                //0. Voltar
                break;
            default:
                System.out.println("Opção inválida, tente novamente.");
                break;
        }
    }

    private static void menuAnotacoes(Menu menu) {
        //TODO
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
        //TODO
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
