public class Apartamento extends Imovel {
    private double taxaCondominio = 0.02; //Nao informado valor no enunciado mas cobrado funcionalidade, coloquei 2% como valor qualquer
    private double taxaImobiliaria;

    private void aplicarTaxaCondominio() {
        valorDeAluguel += (valorDeAluguel * taxaCondominio);
        valorDeAluguel -= taxaImobiliaria;
    }

    @Override
    public void inputBeneficios() {
        super.inputBeneficios();
        taxaImobiliaria = valorDeAluguel * 0.12;
        aplicarTaxaCondominio();
    }

    @Override
    public double getTaxaImobiliaria() {
        return taxaImobiliaria;
    }

    public Apartamento(double valorDeVenda, String endereco, int anoDeConstrucao) {
        super(valorDeVenda, endereco, anoDeConstrucao);
        idadeImovel = 2025 - anoDeConstrucao;
        valorDeAluguel = valorDeVenda * 0.04;
        while(idadeImovel >= 5 && taxaDesconto <= MAX_DESCONTO) {
            aplicarDesconto();
        }
    }

    protected void aplicarDesconto(){
        valorDeAluguel -= (valorDeAluguel * taxaDesconto);
        taxaDesconto += 0.04;
        idadeImovel -= 5;
    }
}
