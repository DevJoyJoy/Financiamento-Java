package modelo;

public class Terreno extends Financiamento{
    private String zona;

    public Terreno(double valorImovel, int prazoFinanciamento, double taxaJurosAnual, String zona) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
        this.zona = zona;
    }

    public String getZona() {
        return zona;
    }
    
    @Override
    public double CalcularPagamentoMensal() {
        double pagamentoMensal = (this.valorImovel / (this.prazoFinanciamento * 12)) * (1 + (this.taxaJurosAnual / 100 / 12));
        return pagamentoMensal*1.02;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("\n");
        builder.append("[FINANCIAMENTO]     (TERRENO)\n");
        builder.append(String.format("Valor imóvel:       R$ %,.2f%n", valorImovel));
        builder.append("Prazo:              " + prazoFinanciamento + " anos\n");
        builder.append("Taxa Juros Anual:   " + taxaJurosAnual + "%\n");
        builder.append("Tipo de zona:       " + getZona()+"\n");
        builder.append(String.format("Valor mensal:       R$ %,.2f%n", CalcularPagamentoMensal()));
        builder.append(String.format("Valor total:        R$ %,.2f%n", CalcularTotal()));

        return builder.toString();
    }

    public void ImprimirDados(int posicao) {
        System.out.println();
        System.out.println("[" + posicao + "º FINANCIAMENTO]  (TERRENO)");
        System.out.printf("Valor imóvel:       R$ %,.2f%n", valorImovel);
        System.out.println("Prazo:              " + prazoFinanciamento + " anos");
        System.out.println("Taxa Juros Anual:   " + taxaJurosAnual + "%");
        System.out.println("Tipo de zona:       " + getZona());
        System.out.printf("Valor mensal:       R$ %,.2f%n", CalcularPagamentoMensal());
        System.out.printf("Valor total:        R$ %,.2f%n", CalcularTotal());
        System.out.println();
    }
}
