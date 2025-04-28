public class Casa extends Imovel {
    private double taxaImobiliaria;


    @Override
    public void inputBeneficios() {
        super.inputBeneficios();
        taxaImobiliaria = valorDeAluguel * 0.12;// Calculo para a taxa a receber
        valorDeAluguel -= taxaImobiliaria;
    }

    @Override
    public double getTaxaImobiliaria() {
        return taxaImobiliaria;
    }

    protected void aplicarDesconto(){
        valorDeAluguel -= (valorDeAluguel * taxaDesconto);
        taxaDesconto += 0.1;
        idadeImovel -= 5;
    }
    public Casa(double valorDeVenda, String endereco, int anoDeConstrucao) {
        super(valorDeVenda, endereco, anoDeConstrucao);
        valorDeAluguel = valorDeVenda * 0.05;
        idadeImovel = 2025 - anoDeConstrucao;
        while(idadeImovel >= 5 && taxaDesconto <= MAX_DESCONTO) {
            aplicarDesconto();
        }
    }
}
