package util;

import java.util.Scanner;

public class InterfaceUsuario {
    Scanner scanner = new Scanner(System.in);

    public double SolicitarValorImovel() {
        double valorSolicitado = 0;
        boolean condicao = false;
        do {
            System.out.print("Valor do imóvel: ");
            try {
            valorSolicitado = scanner.nextDouble();
                if (valorSolicitado > 0) {
                    condicao = true;
                } else {
                    System.out.println("O valor deve ser positivo. Tente novamente.\n");
                    condicao = false;
                }
            } catch (Exception e) { 
                System.out.println("Este valor não é válido. Tente novamente.\n");
                scanner.next();
                condicao = false;
            }
        } while (!condicao);
        return valorSolicitado;
    }

    public int SolicitarPrazoFinanciamento() {
        int prazoSolicitado = 0;
        boolean condicao;
        do {
            System.out.print("Prazo em anos para o financiamento: ");
            try {
                prazoSolicitado = scanner.nextInt();
                if ((prazoSolicitado > 0) && (prazoSolicitado < 50)) {
                    condicao = true;
                }
                else {
                    System.out.println("Este prazo não é valido, insira um prazo entre 1 a 50 anos.\n");
                    condicao = false;
                }
            } catch (Exception e) {
                System.out.println("Este prazo não é válido. Tente novamente.\n");
                scanner.next();
                condicao = false;
            }
        } while (!condicao);
        return prazoSolicitado;
    }
    public double SolicitarTaxaJuros() {    
        double taxaSolicitada = 0;
        boolean condicao;
        do {
            System.out.print("Taxa de juros anual: ");
            try {
                taxaSolicitada = scanner.nextDouble();
                if ((taxaSolicitada > 0) && (taxaSolicitada < 50)) {
                    condicao = true;
                }
                else {
                    System.out.println("Esta taxa não é válida, insira um valor entre 1 a 50.\n");
                    condicao = false;
                }
            } catch (Exception e) {
                System.out.println("Esta taxa não é válida. Tente novamente.\n");
                scanner.next();
                condicao = false;
            }
        } while (!condicao);
        return taxaSolicitada;
    }
    
}