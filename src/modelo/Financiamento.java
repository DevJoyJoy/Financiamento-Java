package modelo;

import java.io.Serializable;

public abstract class Financiamento implements Serializable{

    protected double valorImovel;
    protected int prazoFinanciamento;
    protected double taxaJurosAnual;

    public double getValorImovel() {
        return this.valorImovel;
    }
    public int getPrazoFinanciamento() {
        return this.prazoFinanciamento;
    }
    public double getTaxaJurosAnual() {
        return this.taxaJurosAnual;
    }

    public Financiamento(double valorImovel, int prazoFinanciamento, double taxaJurosAnual) {
        this.valorImovel = valorImovel;
        this.prazoFinanciamento = prazoFinanciamento;
        this.taxaJurosAnual = taxaJurosAnual;
    }

    public abstract String toString();

    public abstract double CalcularPagamentoMensal();

    public double CalcularTotal() {
        double pagamentoTotal = this.CalcularPagamentoMensal() * this.prazoFinanciamento * 12;
        return pagamentoTotal;
    }

    public abstract void ImprimirDados(int posicao);


}