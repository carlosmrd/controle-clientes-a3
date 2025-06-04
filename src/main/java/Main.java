import database.InicializadorDB;
import view.Menu;

public class Main {

    public static void main(String[] args) {

        InicializadorDB.inicializar();

        Menu menu = new Menu();
        int opcao;

        do {
            opcao = menu.exibirMenuPrincipal();

            switch (opcao) {
                case 1:
                    menuClientes(menu);
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
    }

    private static void menuClientes(Menu menu) {
        int opcao;
        do {
            opcao = menu.exibirMenuClientes();

            switch (opcao) {
                case 1:

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
