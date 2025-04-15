public class Casa extends Imovel {
    private double taxaDesconto = 0.05;

    protected void aplicarDesconto(){
        valorDeAluguel -= (valorDeAluguel * taxaDesconto);
        taxaDesconto += 0.1;
        anoDeConstrucao += 5;
    }
    public Casa(double valorDeVenda, String endereco, int anoDeConstrucao) {
        super(valorDeVenda, endereco, anoDeConstrucao);
        valorDeAluguel = valorDeVenda * 0.05;
        while((2025 - anoDeConstrucao) >= 5 && taxaDesconto < MAX_DESCONTO) {
            aplicarDesconto();
        }
    }
}
