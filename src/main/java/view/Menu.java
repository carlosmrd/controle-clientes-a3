package view;

import java.util.Scanner;

public class Menu {
    static Scanner scanner = new Scanner(System.in);

    public int exibirMenuPrincipal() {
            System.out.println("\n----- MENU -----");
            System.out.println("1. Cadastrar cliente");
            System.out.println("3. Buscar cliente");
            System.out.println("4. Listar clientes");
            System.out.println("5. Editar cliente");
            System.out.println("6. Adicionar lembrete");
            System.out.println("7. Adicionar anotação");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            return scanner.nextInt();
    }
}
