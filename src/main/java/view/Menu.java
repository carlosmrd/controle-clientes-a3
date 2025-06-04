package view;

import java.util.Scanner;

public class Menu {
    static Scanner scanner = new Scanner(System.in);

    public int exibirMenuPrincipal() {
        System.out.println("\n----- MENU -----");
        System.out.println("1. Clientes");
        System.out.println("2. Anotações");
        System.out.println("3. Lembretes");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");

        int opcao = scanner.nextInt();
        scanner.nextLine();
        return opcao;
    }

    public int exibirMenuClientes() {
        System.out.println("\n--- CLIENTES ---");
        System.out.println("1. Cadastrar cliente");
        System.out.println("2. Listar clientes");
        System.out.println("3. Buscar cliente");
        System.out.println("4. Alterar cliente");
        System.out.println("5. Excluir cliente");
        System.out.println("0. Voltar");
        System.out.print("Escolha uma opção: ");

        int opcao = scanner.nextInt();
        scanner.nextLine();
        return opcao;
    }

    public int lerIdCliente() {
        System.out.print("Insira o ID do cliente: ");

        int id = scanner.nextInt();
        scanner.nextLine();
        return id;
    }

    public String lerNomeCliente() {
        System.out.print("Insira o nome do cliente: ");

        String nome = scanner.nextLine();
        return nome;
    }

    public String lerNovoNomeCliente() {
        System.out.print("Insira o nome do cliente (0 para não alterar): ");

        String nome = scanner.nextLine();

        if (nome.equals("0")){
            return "0";
        }

        return nome;
    }

    public String lerTelefoneCliente() {
        System.out.print("Insira o telefone do cliente: ");

        String telefone = scanner.nextLine();
        return telefone;
    }

    public String lerNovoTelefoneCliente() {
        System.out.print("Insira o telefone do cliente (0 para não alterar): ");

        String telefone = scanner.nextLine();

        if (telefone.equals("0")){
            return "0";
        }

        return telefone;
    }

    public String lerUfCliente() {
        System.out.print("Insira a UF de residência do cliente: ");

        String uf = scanner.nextLine();
        return uf;
    }

    public String lerNovoUfCliente() {
        System.out.print("Insira a UF de residência do cliente (0 para não alterar): ");

        String uf = scanner.nextLine();

        if (uf.equals("0")){
            return "0";
        }

        return uf;
    }

    public boolean inserirDadosOpcionais() {


            System.out.println("\nDeseja inserir dados opcionais?");
            System.out.println("1. Sim");
            System.out.println("2. Não");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    return true;

                case 2:
                    return false;

                default:
                    System.out.println("Opção inválida, tente novamente.");
                    return inserirDadosOpcionais();
            }
    }

    public boolean inserirNumeroProcesso() {

            System.out.println("\nDeseja inserir o número do processo do cliente?");
            System.out.println("1. Sim");
            System.out.println("2. Não");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    return true;

                case 2:
                    return false;

                default:
                    System.out.println("Opção inválida, tente novamente.");
                    return inserirNumeroProcesso();
            }
    }

    public String lerCepCliente() {
        System.out.print("Insira o CEP do cliente (0 para deixar em branco): ");

        String cep = scanner.nextLine();

        if (cep.equals("0")){
            return "0";
        }

        return cep;
    }

    public String lerComplementoCliente() {
        System.out.print("Insira o complemento do endereço (0 para deixar em branco): ");

        String complemento = scanner.nextLine();

        if (complemento.equals("0")){
            return "0";
        }

        return complemento;
    }

    public String lerCpfCliente() {
        System.out.print("Insira o CPF do cliente (0 para não alterar): ");

        String cpf = scanner.nextLine();

        if (cpf.equals("0")){
            return "0";
        }

        return cpf;
    }

    public String lerNumeroProcesso() {
        System.out.print("Insira o número do processo do cliente (0 para não alterar): ");

        String numeroProcesso = scanner.nextLine();

        if (numeroProcesso.equals("0")){
            return "0";
        }

        return numeroProcesso;
    }

    public int lerStatusCliente() {
        System.out.println("Insira o status do atendimento do cliente:");
        System.out.println("1. Atendimento inicial");
        System.out.println("2. Agendar reunião");
        System.out.println("3. Realizar reunião");
        System.out.println("4. Negociar honorários");
        System.out.println("5. Honorários acordados");
        System.out.println("0. Não alterar");
        System.out.print("Escolha uma opção: ");

        int statusCliente = scanner.nextInt();
        scanner.nextLine();

        if (statusCliente == 0){
            return -1;
        }

        return statusCliente;
    }

    public int exibirMenuAlterarCliente() {
        System.out.println("\n-- ALTERAR CLIENTE --");
        System.out.println("1. Alterar todos os campos");
        System.out.println("2. Selecionar um campo para alterar");
        System.out.println("0. Voltar");
        System.out.print("Escolha uma opção: ");

        int opcao = scanner.nextInt();
        scanner.nextLine();
        return opcao;
    }

    public int exibirMenuSelecionarCampoAlterar() {
        System.out.println("\n-- ALTERAR CLIENTE --");
        System.out.println("1. Nome");
        System.out.println("0. Voltar");
        System.out.print("Escolha uma opção: ");

        int opcao = scanner.nextInt();
        scanner.nextLine();
        return opcao;
    }

    public int exibirMenuAnotacoes() {
        System.out.println("\n--- ANOTAÇÕES ---");
        System.out.println("1. Criar anotação");
        System.out.println("2. Buscar anotações");
        System.out.println("3. Alterar anotação");
        System.out.println("4. Excluir anotação");
        System.out.println("0. Voltar");
        System.out.print("Escolha uma opção: ");

        int opcao = scanner.nextInt();
        scanner.nextLine();
        return opcao;
    }

    public int exibirMenuLembretes() {
        System.out.println("\n--- LEMBRETES ---");
        System.out.println("1. Criar lembrete");
        System.out.println("2. Listar lembretes");
        System.out.println("3. Buscar lembretes");
        System.out.println("4. Alterar lembrete");
        System.out.println("5. Excluir lembrete");
        System.out.println("0. Voltar");
        System.out.print("Escolha uma opção: ");

        int opcao = scanner.nextInt();
        scanner.nextLine();
        return opcao;
    }
}
