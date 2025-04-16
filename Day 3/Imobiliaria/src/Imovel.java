import java.util.Scanner;

public class Imovel {
    protected double valorDeVenda;
    protected double valorDeAluguel;
    protected String endereco;
    protected int anoDeConstrucao;
    protected double taxaDesconto = 0.05;
    protected final int MAX_DESCONTO = 30;
    protected final int MAX_BENEFICIOS = 100;
    protected String[] arrayBeneficios;
    Scanner teclado;

    public Imovel(double valorDeVenda, double valorDeAluguel, String endereco, int anoDeConstrucao) {
        this.valorDeVenda = valorDeVenda;
        this.valorDeAluguel = valorDeAluguel;
        this.endereco = endereco;
        this.anoDeConstrucao = anoDeConstrucao;
    }

    public Imovel(double valorDeVenda, String endereco, int anoDeConstrucao) {
        this.valorDeVenda = valorDeVenda;
        this.endereco = endereco;
        this.anoDeConstrucao = anoDeConstrucao;
    }

    protected void gerarValorBeneficios(double valorBeneficio) {
        valorDeAluguel += valorBeneficio;
    }

    private boolean verificarNegativo(double valor) {
        if (valor < 0) {
            System.out.println("O valor não pode ser negativo.");
            return false;
        }
        return true;
    }

    public void inputBeneficios() {
        teclado = new Scanner(System.in);
        System.out.print("Digite quantos benefícios o imóvel possui: ");
        int quantidadeBeneficios = teclado.nextInt();
        teclado.nextLine(); // limpar o buffer

        if (!verificarNegativo(quantidadeBeneficios)) return;

        if (quantidadeBeneficios == 0) {
            System.out.println("Nenhum benefício registrado.");
            return;
        } else if (quantidadeBeneficios > MAX_BENEFICIOS) {
            System.out.println("O número máximo de benefícios é " + MAX_BENEFICIOS);
            quantidadeBeneficios = MAX_BENEFICIOS;
        }

        arrayBeneficios = new String[quantidadeBeneficios];
        for (int i = 0; i < quantidadeBeneficios; i++) {
            System.out.printf("Digite o nome do benefício %d: ", i + 1);
            arrayBeneficios[i] = teclado.nextLine();

            System.out.print("Digite o valor do benefício: ");
            double valorBeneficio = teclado.nextDouble();
            teclado.nextLine(); // limpar buffer

            if (!verificarNegativo(valorBeneficio)) return;

            gerarValorBeneficios(valorBeneficio);
        }
    }


    public String relatorio() {
        StringBuilder sb = new StringBuilder();
        sb.append("===== Detalhes do Imóvel =====\n");
        sb.append("Endereço: ").append(endereco).append("\n");
        sb.append("Ano de Construção: ").append(anoDeConstrucao).append("\n");
        sb.append(String.format("Valor de Venda: R$ %.2f\n", valorDeVenda));
        sb.append(String.format("Valor de Aluguel: R$ %.2f\n", valorDeAluguel));

        if (arrayBeneficios != null && arrayBeneficios.length > 0) {
            sb.append("Benefícios do imóvel:\n");
            for (int i = 0; i < arrayBeneficios.length; i++) {
                sb.append("  - ").append(arrayBeneficios[i]).append("\n");
            }
        } else {
            sb.append("Nenhum benefício registrado.\n");
        }

        return sb.toString();
    }
}
