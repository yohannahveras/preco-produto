package entities;

public class ProdutoImportado extends Produto{
    private Double taxaAlfandega;

    public ProdutoImportado(String nome, Double preco, Double taxaAlfandega) {
        super(nome, preco);
        this.taxaAlfandega = taxaAlfandega;
    }

    public Double getTaxaAlfandega() {
        return taxaAlfandega;
    }

    public void setTaxaAlfandega(Double taxaAlfandega) {
        this.taxaAlfandega = taxaAlfandega;
    }

    public Double precoFinal(){
        return getPreco() + taxaAlfandega;
    }
    @Override
    public String tagPreco(){
        return getNome()
                + " R$ "
                + String.format("%.2f", precoFinal())
                + " (Taxa de Alfândega: R$ "
                + String.format("%.2f", taxaAlfandega)
                + ")";
    }
}
