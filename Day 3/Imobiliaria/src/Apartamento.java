public class Apartamento extends Imovel {
    private double taxaDesconto = 0.05;

    public Apartamento(double valorDeVenda, String endereco, int anoDeConstrucao) {
        super(valorDeVenda, endereco, anoDeConstrucao);
        valorDeAluguel = valorDeVenda * 0.04;
        while((2025 - anoDeConstrucao) >= 5 && taxaDesconto < MAX_DESCONTO) {
            aplicarDesconto();
        }
    }

    protected void aplicarDesconto(){
        valorDeAluguel -= (valorDeAluguel * taxaDesconto);
        taxaDesconto += 0.04;
        anoDeConstrucao += 5;
    }
}
