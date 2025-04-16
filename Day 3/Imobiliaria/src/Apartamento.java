public class Apartamento extends Imovel {
    private double taxaDesconto = 0.05;
    private double taxaCondominio = 0.02; //Nao informado valor no enunciado mas cobrado funcionalidade, coloquei 2% como valor qualquer
    private double taxaImobiliaria;

    private void aplicarTaxaCondominio() {
        valorDeAluguel += (valorDeAluguel * taxaCondominio);
    }

    @Override
    public void inputBeneficios() {
        super.inputBeneficios();
        taxaImobiliaria = valorDeAluguel * 0.12;
        aplicarTaxaCondominio();
    }

    public double getTaxaImobiliaria() {
        return taxaImobiliaria;
    }

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
