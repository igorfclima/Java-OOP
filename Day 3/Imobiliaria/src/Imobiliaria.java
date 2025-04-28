import java.util.Scanner;

public class Imobiliaria {
    private Imovel[] imoveis;
    private int contadorImoveis = 0;
    private static final int MAX_IMOVEIS = 100;
    Scanner teclado;

    public Imobiliaria(int quantImoveis) {
        if(quantImoveis <= MAX_IMOVEIS) {
            imoveis = new Imovel[quantImoveis];
        } else {
            System.out.println("Número máximo de imóveis excedido. Usando o valor padrão de " + MAX_IMOVEIS);
            imoveis = new Imovel[MAX_IMOVEIS];
        }
    }
    static void menu() {
        System.out.println("1 - Cadastrar Imóvel");
        System.out.println("2 - Listar Imóveis");
        System.out.println("3 - Listar Imóveis por Ano de Construção");
        System.out.println("4 - Valor Total dos Imóveis");
        System.out.println("5 - Sair");
        System.out.print("Escolha uma opção: ");
    }

    static void cabecalho() {
        limparTela();
        System.out.println("GESTAO DE IMÓVEIS v0.1\n================");
    }

    static void limparTela() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public double lerDouble(String mensagem) {
        teclado = new Scanner(System.in);
        double valor;
        while (true) {
            System.out.print(mensagem);
            try {
                valor = Double.parseDouble(teclado.nextLine().replace(',', '.'));
                return valor;
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Digite um número decimal.");
            }
        }
    }


    public int lerInt(String mensagem) {
        teclado = new Scanner(System.in);
        int valor;
        while (true) {
            System.out.print(mensagem);
            try {
                valor = Integer.parseInt(teclado.nextLine());
                return valor;
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Digite um número inteiro.");
            }
        }
    }


    public String lerString(String mensagem) {
        teclado = new Scanner(System.in);
        System.out.print(mensagem);
        return teclado.nextLine();
    }

    private Imovel inputCasa(){
        teclado = new Scanner(System.in);
        cabecalho();
        double valorVenda = lerDouble("Digite o valor de venda: ");
        String endereco = lerString("Digite o endereço: ");
        int ano = lerInt("Digite o ano de contrução: ");
        Casa casa = new Casa(valorVenda, endereco, ano);
        casa.inputBeneficios();
        return casa;
    }

    private Imovel inputApartamento(){
        teclado = new Scanner(System.in);
        cabecalho();
        double valorVenda = lerDouble("Digite o valor de venda: ");
        String endereco = lerString("Digite o endereço: ");
        int ano = lerInt("Digite o ano de contrução: ");
        Apartamento apartamento = new Apartamento(valorVenda, endereco, ano);
        apartamento.inputBeneficios();
        return apartamento;
    }

    private Imovel cadastrarImovel(){
        Imovel imovel = null;
        teclado = new Scanner(System.in);
        System.out.println("O imovel sera casa ou apartamento?");
        String escolha = teclado.nextLine();
        if (escolha.equalsIgnoreCase("casa")) {
            imovel = inputCasa();
        } else if(escolha.equalsIgnoreCase("apartamento")) {
            imovel = inputApartamento();
        } else{
            System.out.println("Escreva casa ou apartamento.");
            return cadastrarImovel();
        }
        return imovel;
    }

    public void listarImoveis() {
        cabecalho();
        System.out.println("Lista de Imóveis:");
        for (int i = 0; i < contadorImoveis; i++) {
            System.out.println(imoveis[i].relatorio());
        }
    }

    public void listarImoveisPorAno(int ano) {
        cabecalho();
        System.out.println("Lista de Imóveis:");
        for (int i = 0; i < contadorImoveis; i++) {
            if(imoveis[i].getAnoDeConstrucao() == ano){
                System.out.println(imoveis[i].relatorio());
            }
        }
    }

    public void listarValorTotalImoveis() {
        cabecalho();
        System.out.println("Valor solido dos imóveis:");
        double valorTotal = 0.0;
        double taxaImobiliaria = 0.0;
        for (int i = 0; i < contadorImoveis; i++) {
            valorTotal += imoveis[i].getValorSolido();
            taxaImobiliaria += imoveis[i].getTaxaImobiliaria();
        }
        System.out.println(String.format("Valor sólido: R$ %.2f", valorTotal));
        System.out.println(String.format("Valor liquido: R$ %.2f", valorTotal - taxaImobiliaria));
    }

    public void adicionarImovel() {
        limparTela();
        cabecalho();
        Imovel imovel = cadastrarImovel();

        if (contadorImoveis < imoveis.length) {
            imoveis[contadorImoveis] = imovel;
            contadorImoveis++;
        } else {
            System.out.println("Limite de imóveis atingido.");
        }
    }
}
