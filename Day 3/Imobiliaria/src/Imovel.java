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

    public void inputBeneficios() {
        teclado = new Scanner(System.in);
        System.out.println("Digite quantos beneficios o imovel possui: ");
        int quantidadeBeneficios = teclado.nextInt();
        if (quantidadeBeneficios > MAX_BENEFICIOS) {
            System.out.println("O número máximo de benefícios é " + MAX_BENEFICIOS);
            quantidadeBeneficios = MAX_BENEFICIOS;
        }
        arrayBeneficios = new String[quantidadeBeneficios];
        System.out.println("Digite os beneficios do imovel: ");
        for (int i = 0; i < quantidadeBeneficios; i++) {
            arrayBeneficios[i] = teclado.next();
        }
        while(quantidadeBeneficios > 0) {
            System.out.println("Digite o valor do beneficio: ");
            double valorBeneficio = teclado.nextDouble();
            gerarValorBeneficios(valorBeneficio);
            quantidadeBeneficios--;
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
