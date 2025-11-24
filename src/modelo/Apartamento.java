package modelo;

public class Apartamento extends Financiamento {
    private int vagasGaragem;
    private int numeroAndar;

    public Apartamento(double valorImovel, int prazoFinanciamento, double taxaJurosAnual, int vagasGaragem, int numeroAndar) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
        this.vagasGaragem = vagasGaragem;
        this.numeroAndar = numeroAndar;
    }

    public int getVagasGaragem() {
        return this.vagasGaragem;
    }

    public int getNumeroAndar() {
        return this.numeroAndar;
    }
    
    @Override
    public double CalcularPagamentoMensal() {
        double taxaJurosMensal = (taxaJurosAnual / 100) / 12;
        int prazoEmMeses = prazoFinanciamento * 12;
        double denominador = 1 - Math.pow((1 + taxaJurosMensal), -prazoEmMeses);

        return (valorImovel * taxaJurosMensal) / denominador;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("\n");
        builder.append("[FINANCIAMENTO]     (APARTAMENTO)\n");
        builder.append(String.format("Valor imóvel:       R$ %,.2f%n", valorImovel));
        builder.append("Prazo:              " + prazoFinanciamento + " anos\n");
        builder.append("Taxa Juros Anual:   " + taxaJurosAnual + "%\n");
        builder.append("Vagas na Garagem:   " + getVagasGaragem() + " vagas\n");
        builder.append("Andar do prédio:    " + getNumeroAndar() + "º andar\n");
        builder.append(String.format("Valor mensal:       R$ %,.2f%n", CalcularPagamentoMensal()));
        builder.append(String.format("Valor total:        R$ %,.2f%n", CalcularTotal()));

        return builder.toString();
    }

    public void ImprimirDados(int posicao) {
        System.out.println();
        System.out.println("[" + posicao + "º FINANCIAMENTO]  (APARTAMENTO)");
        System.out.printf("Valor imóvel:       R$ %,.2f%n", valorImovel);
        System.out.println("Prazo:              " + prazoFinanciamento + " anos");
        System.out.println("Taxa Juros Anual:   " + taxaJurosAnual + "%");
        System.out.println("Vagas na Garagem:   " + getVagasGaragem() + " vagas");
        System.out.println("Andar do prédio:    " + getNumeroAndar() + "º andar");
        System.out.printf("Valor mensal:       R$ %,.2f%n", CalcularPagamentoMensal());
        System.out.printf("Valor total:        R$ %,.2f%n", CalcularTotal());
        System.out.println();
    }
}
