import database.InicializadorDB;
import view.Menu;

public class Main {
    public static void main(String[] args) {

        InicializadorDB.inicializar();
        Menu menu = new Menu();

        int escolha;

        do {
            escolha = menu.exibirMenuPrincipal();

            switch (escolha) {
                case 1:

                    break;

                case 2:

                    break;

                case 0:
                    System.out.println("Encerrando");
                    break;

                default:
                    System.out.println("Opção inválida, tente novamente.");
            }
        } while (escolha != 0);

    }
}
