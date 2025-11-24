
package main;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import modelo.*;
import util.InterfaceUsuario;


public class Main {
    public static void main(String[] args) {
        
        var financiamentos = new ArrayList<Financiamento>();

        System.out.println("\n-----------{SIMULADOR DE FINANCIAMENTOS}-----------\n");

        System.out.println("Para simular os financiamentos, insira seus respectivos dados.\n");

        InterfaceUsuario interfaceUsuario = new InterfaceUsuario();

        double valorSolicitado = interfaceUsuario.SolicitarValorImovel();
        int prazoSolicitado = interfaceUsuario.SolicitarPrazoFinanciamento();
        double taxaSolicitada = interfaceUsuario.SolicitarTaxaJuros();

        financiamentos.add(new Casa(valorSolicitado, prazoSolicitado, taxaSolicitada, 32, 40));
        financiamentos.add(new Casa(350000, 30, 6, 50, 60));
        financiamentos.add(new Apartamento(valorSolicitado, prazoSolicitado, taxaSolicitada, 8, 8));
        financiamentos.add(new Apartamento(350000, 30, 6, 2, 5));
        financiamentos.add(new Terreno(valorSolicitado, prazoSolicitado, taxaSolicitada, "Residencial"));

        System.out.println("\n---------RESULTADO FINANCIAMENTOS---------\n");

        double valorTotal = 0;  
        int posicao2 = 0; 

        for (Financiamento financ : financiamentos) {
            posicao2 ++;
            financ.ImprimirDados(posicao2);
            valorTotal = valorTotal + financ.CalcularTotal();
        }
        System.out.printf("TOTAL DE TODOS OS IMÓVEIS: R$ %,.2f%n", valorTotal);

        FileWriter escritor = null;
        
            try {
            escritor = new FileWriter("financiamentos.txt"); 
            for (Financiamento financiamento : financiamentos) {
                escritor.write(financiamento.toString()); 
            } 
            escritor.write(String.format("\nTOTAL DE TODOS OS IMÓVEIS: R$ %,.2f%n", valorTotal));
            escritor.flush(); 
            escritor.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        


        ObjectOutputStream outputStream = null;
        try {
            outputStream = new ObjectOutputStream (new FileOutputStream("ObjetosFinanciamentos.txt"));
            for (Financiamento financiamento : financiamentos) {
                outputStream.writeObject(financiamento);
            }
            outputStream.flush();
            outputStream.close();
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } 

        System.out.println("\n-----------LEITURA DO ARQUIVO-----------");
        ObjectInputStream inputStream = null;
        try {
            inputStream = new ObjectInputStream (new FileInputStream("ObjetosFinanciamentos.txt"));
            Object objeto = null;
            while ((objeto = inputStream.readObject()) != null) {
                if (objeto instanceof Financiamento)
                    System.out.println(((Financiamento)objeto).toString());
            }
            inputStream.close();
        } catch (EOFException ex) {
            System.out.println("Fim de arquivo alcançado.");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}


