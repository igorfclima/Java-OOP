import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        //Codigo de forma dinamica com menu interativo(nao sabia se era para fazer assim ou de forma estatica)
        Imobiliaria imobiliaria = new Imobiliaria(100);

        int opcao = 0;
        do {
            Imobiliaria.cabecalho();
            Imobiliaria.menu();

            try {
                opcao = Integer.parseInt(teclado.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Digite uma opção válida.");
                continue;
            }

            switch (opcao) {
                case 1:
                    imobiliaria.adicionarImovel();
                    break;
                case 2:
                    imobiliaria.listarImoveis();
                    System.out.println("\nPressione Enter para continuar...");
                    teclado.nextLine();
                    break;
                case 3:
                    int ano = imobiliaria.lerInt("Digite o ano desejado: ");
                    imobiliaria.listarImoveisPorAno(ano);
                    System.out.println("\nPressione Enter para continuar...");
                    teclado.nextLine();
                    break;
                case 4:
                    imobiliaria.listarValorTotalImoveis();
                    System.out.println("\nPressione Enter para continuar...");
                    teclado.nextLine();
                    break;
                case 5:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 5);

        teclado.close();

        //Codigo de forma estatica para a alternativa B
        System.out.println("=== Cálculo de Aluguel de Apartamento ===");


        Apartamento apto = new Apartamento(500000.0, "Rua das Flores, 123", 2010);


        System.out.printf("Valor de aluguel inicial (com descontos de idade aplicados): R$ %.2f%n", apto.getValorDeAluguel());


        apto.inputBeneficios();


        System.out.printf("Valor de aluguel final (após benefícios e taxas): R$ %.2f%n", apto.getValorDeAluguel());
    }
}
