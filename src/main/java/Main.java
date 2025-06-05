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
        int id;
        do {
            opcao = menu.exibirMenuClientes();

            switch (opcao) {
                case 1:
                    //Obrigatórios
                    String nome = menu.lerNomeCliente();
                    String telefone = menu.lerTelefoneCliente();
                    String uf = menu.lerUfCliente();

                    Cliente cliente = new Cliente(nome, telefone, uf);

                    //Opcionais
                    boolean opcionais = menu.inserirDadosOpcionais();

                    if (opcionais) {
                        String cep = menu.lerCepCliente();
                        String complemento = menu.lerComplementoCliente();
                        String cpf = menu.lerCpfCliente();
                        cliente.setCep(cep);
                        cliente.setComplemento(complemento);
                        cliente.setCpf(cpf);
                    }

                    //Número do processo, nem sempre existe
                    boolean opcionalProcesso = menu.inserirNumeroProcesso();

                    if (opcionalProcesso) {
                        String numeroProcesso = menu.lerNumeroProcesso();
                        cliente.setNumeroProcesso(numeroProcesso);
                    }

                    clienteController.inserirCliente(cliente);
                    break;

                case 2:

                    break;

                case 3:
                    id = menu.lerIdCliente();
                    //TODO
                    break;

                case 4:
                    id = menu.lerIdCliente();
                    menuAlterarClientes(menu, clienteController, id);
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

    private static void menuAlterarClientes(Menu menu, ClienteController clienteController, int id) {
        int opcao;
        
        do {
            opcao = menu.exibirMenuAlterarCliente();

            switch (opcao) {
                case 1:
                    Cliente cliente = clienteController.buscarClientePorId(id);

                    //Obrigatórios
                    String nome = menu.lerNovoNomeCliente();
                    if (!nome.equals("0")){
                        cliente.setNome(nome);
                    }

                    String telefone = menu.lerNovoTelefoneCliente();
                    if (!telefone.equals("0")){
                        cliente.setTelefone(telefone);
                    }

                    String uf = menu.lerNovoUfCliente();
                    if (!uf.equals("0")){
                        cliente.setUf(uf);
                    }

                    //Opcionais
                    String cep = menu.lerNovoCepCliente();
                    if (!cep.equals("0")){
                        cliente.setCep(cep);
                    }

                    String complemento = menu.lerNovoComplementoCliente();
                    if (!complemento.equals("0")){
                        cliente.setComplemento(complemento);
                    }

                    String cpf = menu.lerNovoCpfCliente();
                    if (!cpf.equals("0")){
                        cliente.setCpf(cpf);
                    }

                    //Número do processo, nem sempre existe
                    String numeroProcesso = menu.lerNovoNumeroProcesso();
                    if (!numeroProcesso.equals("0")){
                        cliente.setNumeroProcesso(numeroProcesso);
                    }

                    //Situação do cliente, sempre um entre os pré-estabelecidos
                    int statusCliente = menu.lerNovoStatusCliente();
                    if (statusCliente != -1) {
                        cliente.setStatusCliente(statusCliente);
                    }

                    clienteController.atualizarCliente(cliente);
                    break;

                case 2:
                    menuSelecionarCampo(menu, clienteController, id);
                    break;

                case 0:
                    break;

                default:
                    System.out.println("Opção inválida, tente novamente.");
            }
        } while (opcao != 0);
    }

    private static void menuSelecionarCampo(Menu menu, ClienteController clienteController, int id) {
        int opcao;
        do {
            opcao = menu.exibirMenuSelecionarCampo();
            Cliente cliente = clienteController.buscarClientePorId(id);

            switch (opcao) {
                case 1:
                    String nome = menu.lerNovoNomeCliente();
                    if (!nome.equals(0)){
                        cliente.setNome(nome);
                        clienteController.atualizarCliente(cliente);
                    }
                    break;

                case 2:
                    String telefone = menu.lerNovoTelefoneCliente();
                        if (!telefone.equals("0")){
                            cliente.setTelefone(telefone);
                            clienteController.atualizarCliente(cliente);
                        }
                    break;
                case 3:
                    String uf = menu.lerNovoUfCliente();
                    if (!uf.equals("0")){
                        cliente.setUf(uf);
                        clienteController.atualizarCliente(cliente);
                    }

                    break;

                case 4:
                    String cep = menu.lerNovoCepCliente();
                    if (!cep.equals("0")){
                        cliente.setCep(cep);
                        clienteController.atualizarCliente(cliente);
                    }

                    break;

                case 5:
                    String complemento = menu.lerNovoComplementoCliente();
                    if (!complemento.equals("0")){
                        cliente.setComplemento(complemento);
                        clienteController.atualizarCliente(cliente);
                    }
                    
                    break;

                case 6:
                    String cpf = menu.lerNovoCpfCliente();
                    if (!cpf.equals("0")){
                        cliente.setCpf(cpf);
                        clienteController.atualizarCliente(cliente);
                    }

                    break;

                case 7:
                    String numeroProcesso = menu.lerNovoNumeroProcesso();
                    if (!numeroProcesso.equals("0")){
                        cliente.setNumeroProcesso(numeroProcesso);
                        clienteController.atualizarCliente(cliente);
                    }
                    break;

                case 8:
                    int statusCliente = menu.lerNovoStatusCliente();
                    if (statusCliente != -1) {
                        cliente.setStatusCliente(statusCliente);
                        clienteController.atualizarCliente(cliente);
                    }
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
