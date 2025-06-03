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

        return scanner.nextInt();
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

        return scanner.nextInt();
    }

    public int exibirMenuAnotacoes() {
        System.out.println("\n--- ANOTAÇÕES ---");
        System.out.println("1. Criar anotação");
        System.out.println("2. Buscar anotações");
        System.out.println("3. Alterar anotação");
        System.out.println("4. Excluir anotação");
        System.out.println("0. Voltar");
        System.out.print("Escolha uma opção: ");

        return scanner.nextInt();
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

        return scanner.nextInt();
    }
}
