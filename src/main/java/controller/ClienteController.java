package controller;

import model.Cliente;
import model.ClienteDAO;
import view.Menu;

import java.time.format.DateTimeFormatter;

public class ClienteController {

    private ClienteDAO clienteDAO;

    //Construtor para o Controller
    public ClienteController(ClienteDAO clienteDAO) {
        this.clienteDAO = clienteDAO;
    }

    //Insere cliente novo no banco de dados
    public void cadastrarCliente(Menu menu) {
        //Dados obrigatórios
        String nome = menu.lerNomeCliente();
        String telefone = menu.lerTelefoneCliente();
        String uf = menu.lerUfCliente();

        //Construtor somente com dados obrigatórios.
        Cliente cliente = new Cliente(nome, telefone, uf);

        //Caso o usuário queira, ele pode inserir dados opcionais
        //e número do processo.

        //Dados opcionais
        if (menu.inserirDadosOpcionais()) {
            String cep = menu.lerCepCliente();
            String complemento = menu.lerComplementoCliente();
            String cpf = menu.lerCpfCliente();
            cliente.setCep(cep);
            cliente.setComplemento(complemento);
            cliente.setCpf(cpf);
        }

        //Número do processo, nem sempre existe
        if (menu.inserirNumeroProcesso()) {
            String numeroProcesso = menu.lerNumeroProcesso();
            cliente.setNumeroProcesso(numeroProcesso);
        }
        clienteDAO.cadastrarCliente(cliente);
    }

    public void buscarCliente(Menu menu) {
        Cliente cliente = buscarClientePorId(menu.lerIdCliente());

        System.out.println("\nID: " + cliente.getId());
        System.out.println("Nome: " + cliente.getNome());
        System.out.println("Telefone: " + cliente.getTelefone());
        System.out.println("UF: " +  cliente.getUf());
        System.out.println("CEP: " + (cliente.getCep() != null ? cliente.getCep() : "N/A"));
        System.out.println("Complemento: " + (cliente.getComplemento() != null ? cliente.getComplemento() : "N/A"));
        System.out.println("CPF: " + (cliente.getCpf() != null ? cliente.getCpf() : "N/A"));
        System.out.println("Número do processo: " + (cliente.getNumeroProcesso() != null ? cliente.getNumeroProcesso() : "N/A"));
        System.out.println("Status do atendimento: " + cliente.getDescricaoStatus());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        System.out.println("Data do cadastro: " + cliente.getDataCadastro().format(formatter));
    }

    //Alterar dados em todos os campos
    public void alterarCliente01(Menu menu, int id) {

        //Instância de Cliente para receber novos dados.
        Cliente cliente = buscarClientePorId(id);

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
        if (menu.lerNovoStatusCliente() != -1) {
            cliente.setStatusCliente(statusCliente);
        }

        clienteDAO.atualizarCliente(cliente);
    }

    //Selecionar campo de cliente para alterar dados
    public void alterarCliente02(Menu menu, int id) {
        int opcao;

        do {
            //2. Exibe o submenu "2. Selecionar um campo para alterar"
            opcao = menu.exibirMenuSelecionarCampo();

            //Instância de Cliente para receber novos dados.
            Cliente cliente = buscarClientePorId(id);

            switch (opcao) {
                case 1:
                    String nome = menu.lerNovoNomeCliente();
                    if (!nome.equals("0")){
                        cliente.setNome(nome);
                        clienteDAO.atualizarCliente(cliente);
                    }
                    break;

                case 2:
                    String telefone = menu.lerNovoTelefoneCliente();
                    if (!telefone.equals("0")){
                        cliente.setTelefone(telefone);
                        clienteDAO.atualizarCliente(cliente);
                    }
                    break;

                case 3:
                    String uf = menu.lerNovoUfCliente();
                    if (!uf.equals("0")){
                        cliente.setUf(uf);
                        clienteDAO.atualizarCliente(cliente);
                    }
                    break;

                case 4:
                    String cep = menu.lerNovoCepCliente();
                    if (!cep.equals("0")){
                        cliente.setCep(cep);
                        clienteDAO.atualizarCliente(cliente);
                    }
                    break;

                case 5:
                    String complemento = menu.lerNovoComplementoCliente();
                    if (!complemento.equals("0")){
                        cliente.setComplemento(complemento);
                        clienteDAO.atualizarCliente(cliente);
                    }
                    break;

                case 6:
                    String cpf = menu.lerNovoCpfCliente();
                    if (!cpf.equals("0")){
                        cliente.setCpf(cpf);
                        clienteDAO.atualizarCliente(cliente);
                    }
                    break;

                case 7:
                    String numeroProcesso = menu.lerNovoNumeroProcesso();
                    if (!numeroProcesso.equals("0")){
                        cliente.setNumeroProcesso(numeroProcesso);
                        clienteDAO.atualizarCliente(cliente);
                    }
                    break;

                case 8:
                    int statusCliente = menu.lerNovoStatusCliente();
                    if (statusCliente != -1) {
                        cliente.setStatusCliente(statusCliente);
                        clienteDAO.atualizarCliente(cliente);
                    }
                    break;

                case 0:
                    break;

                default:
                    System.out.println("Opção inválida, tente novamente.");
            }
        } while (opcao != 0);
    }

    //Retorna cliente específico, localizado pelo ID no banco de dados
    public Cliente buscarClientePorId(int id) {
        return clienteDAO.buscarClientePorId(id);
        //TODO tratamento de exceção caso o cliente retorne null
    }

    //Deleta cliente específico, localizado pelo ID no banco de dados
    public void deletarCliente(int id) {
        try {
            //Instância de Cliente para ser excluído.
            Cliente cliente = buscarClientePorId(id);
            clienteDAO.deletarCliente(cliente);
        } catch (Exception e) {
            System.err.println("Erro ao deletar o cliente especificado: " + e);
        }
    }

    //Atualiza cliente específico no banco, localizado pelo ID no banco de dados
    //Acho que não vamos precisar usar
    public void atualizarCliente(Cliente cliente) {
        clienteDAO.atualizarCliente(cliente);
    }

}
