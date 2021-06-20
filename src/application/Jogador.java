package application;

import java.util.Scanner;

public class Jogador {
    private Mapa mapa;
    
    private char letra = 'X';
    
    public Jogador(Mapa mapa) {
        this.mapa = mapa;
    }
    
    public boolean jogar(Scanner teclado) {
        boolean repetir = false;
        int linha = 0;
        int coluna = 0;
        do{
            do{
                System.out.print("Jogador ..\n  linha: ");
                linha = teclado.nextInt();
                System.out.print("  coluna: ");
                coluna = teclado.nextInt();       
            }while(linha>2 || linha<0 || coluna>2 || coluna<0);

            repetir = this.mapa.jogar(linha, coluna, this.letra);
        }while(repetir);
        
        boolean venceu = this.mapa.verificarGanhador(this.letra);
        if(venceu){
            System.out.println(" ... Jogador GANHOU!");
            return true;
        }
        return false;
    }
    
}