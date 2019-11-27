package application;

import market.Market;
import util.Teclado;

public class App {

    public static void main(String[] args) {
        System.out.println("\n###                             Mercadinho do Raul                      ###");
        menu();
    }

    private static void menu(){
        int op;
        System.out.println("\n       ===================================================================");
        System.out.println("      | Realizar Troca Por:                                               |");
        System.out.println("      |    1. Prateleira preferencial do produto                          |");
        System.out.println("      |    2. Prateleira que está com um produto a mais tempo (FIFO)      |");
        System.out.println("      |    3. Prateleira que está com produto menos recentemente comprado |");
        System.out.println("      |    4. Prateleira que está com um produto de lote menos distante   |");
        System.out.println("      |    5. Relatório final                                             |");
        System.out.println("      |    0. Sair                                                        |");
        System.out.println("       ===================================================================\n");

        System.out.print("Informe uma opcão: ");
        op = Teclado.readInt();
        System.out.print("\n");
        switch (op) {
            case 1:
                new Market().changeBy("bestShelfIdByPreference");
                menu();
                break;
            case 2:
                new Market().changeBy("bestShelfIdByFIFO");
                menu();
                break;
            case 3:
                new Market().changeBy("bestShelfIdByNotReacentlyBought");
                menu();
                break;
            case 4:
                new Market().changeBy("bestShelfIdByDistance");
                menu();
                break;
            case 5:
                System.out.println("**** Relatório Final *****");
                System.out.println("\nTroca por: Prateleira preferencial do produto");
                new Market().changeBy("bestShelfIdByPreference");
                System.out.println("\nTroca por: Primeiro produto vendido sera o primeiro a ser removido");
                new Market().changeBy("bestShelfIdByFIFO");
                System.out.println("\nTroca por: Produto que nao foi vendido recentemente");
                new Market().changeBy("bestShelfIdByNotReacentlyBought");
                System.out.println("\nTroca por: Prateleira que está com um produto de lote menos distante");
                new Market().changeBy("bestShelfIdByDistance");
                System.out.println();
                menu();
                break;
            case 0:
                System.out.println("Finalizando sistema.");
                break;
            default:
                System.out.println("Por favor informe uma opcao válida.");
                menu();
                break;
        }
    }
}