
import java.util.Scanner;

public class App {
    public static void main(String[] args){
        int escolhaPrimeiroMenu = 0;
        boolean sair = false;
        ListaDispositivos eletroLista = new ListaDispositivos();
        TratamentoDeErro tratando = new TratamentoDeErro();

            

        try (Scanner scan = new Scanner(System.in)) {
            System.out.println("|Casa Inteligente|\n");

        do {
            System.out.println("\t***Menu***\n");
            System.out.println("[1] - Cadastrar Eletrodomestico\n"     +
                               "[2] - Remover Eletrodomestico\n"       +
                               "[3] - Interagir com Eletrodomestico\n" + 
                               "[4] - Sair\n");
            System.out.println("Digite sua escolha com um numero inteiro de 1 à 4 -> ");
            try {
                escolhaPrimeiroMenu = scan.nextInt();
                tratando.entradaIncorretaMenu1(escolhaPrimeiroMenu);
            } catch (ExceptionsClasse e) {
                // TODO: handle exception
                System.out.println();
                System.out.println("¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨");
                System.out.println(e.getMessage());
                System.out.println("¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨");
                System.out.println();
            }
            
            switch (escolhaPrimeiroMenu) {
                case 1:
                    System.out.println();
                    eletroLista.addDispositivo();
                    System.out.println();
                        break;
                case 2:
                    System.out.println();
                    eletroLista.menuRemove();
                    System.out.println();
                case 3:
                    System.out.println();
                    eletroLista.menuIteracao();
                    System.out.println();
                    break;
                case 4:
                    System.out.println("Ate a proxima !");
                    System.exit(0);
                        break;
            
                default:
                    break;
            }
            
        } while (sair != true);

        }
    }
}
