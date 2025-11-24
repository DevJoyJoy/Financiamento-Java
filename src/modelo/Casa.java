package modelo;

import util.DescontoMaiorDoQueJurosException;

public class Casa extends Financiamento{
    private double areaConstruida;
    private double areaTerreno;

    public Casa(double valorImovel, int prazoFinanciamento, double taxaJurosAnual, double areaConstruida, double areaTerreno) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
        this.areaConstruida = areaConstruida;
        this.areaTerreno = areaTerreno;
    }

    public double getAreaConstruida() {
        return areaConstruida;
    }

    public double getAreaTerreno() {
        return areaTerreno;
    }

   
    public void ValidarDescontoMaiorQueJuros(double jurosMensal) throws DescontoMaiorDoQueJurosException{
        if (80 > jurosMensal) {
            throw new DescontoMaiorDoQueJurosException("O desconto dado é maior do que o juros mensal\n");
        }
    }
    @Override
    public double CalcularPagamentoMensal() {
        double pagamentoMensal = (this.valorImovel / (this.prazoFinanciamento * 12)) * (1 + (this.taxaJurosAnual / 100 / 12));
        double jurosMensal = pagamentoMensal - (this.valorImovel / (this.prazoFinanciamento * 12));
        try {
            ValidarDescontoMaiorQueJuros(jurosMensal);
        } catch (DescontoMaiorDoQueJurosException e) {
            return pagamentoMensal + jurosMensal;
        }
        return pagamentoMensal + 80;
    } 

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("\n");
        builder.append("[FINANCIAMENTO]     (CASA)\n");
        builder.append(String.format("Valor imóvel:       R$ %,.2f%n", valorImovel));
        builder.append("Prazo:              " + prazoFinanciamento + " anos\n");
        builder.append("Taxa Juros Anual:   " + taxaJurosAnual + "%\n");
        builder.append("Area do terreno:    " + getAreaTerreno() + " m²\n");
        builder.append("Area contruída:     " + getAreaConstruida() + " m²\n");
        builder.append(String.format("Valor mensal:       R$ %,.2f%n", CalcularPagamentoMensal()));
        builder.append(String.format("Valor total:        R$ %,.2f%n", CalcularTotal()));

        return builder.toString();
    }

    public void ImprimirDados(int posicao) {
        System.out.println();
        System.out.println("[" + posicao + "º FINANCIAMENTO]  (CASA)");
        System.out.printf("Valor imóvel:       R$ %,.2f%n", valorImovel);
        System.out.println("Prazo:              " + prazoFinanciamento + " anos");
        System.out.println("Taxa Juros Anual:   " + taxaJurosAnual + "%");
        System.out.println("Area do terreno:    " + getAreaTerreno() + " m²");
        System.out.println("Area contruída:     " + getAreaConstruida() + " m²");
        System.out.printf("Valor mensal:       R$ %,.2f%n", CalcularPagamentoMensal());
        System.out.printf("Valor total:        R$ %,.2f%n", CalcularTotal());
        System.out.println();
    }

}
