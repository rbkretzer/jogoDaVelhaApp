package application;

public class PC {
    
    private char letra = 'O';

    private Mapa mapa;

    public PC(Mapa mapa) {
        this.mapa = mapa;
    }

    public boolean jogar() {
        boolean repetir = false;
        int linha = 0;
        int coluna = 0;
        do{
             linha = this.mapa.sortear(0, 3);
             coluna = this.mapa.sortear(0, 3);
            repetir = this.mapa.jogar(linha, coluna, this.letra);
        }while(repetir);
        System.out.println("PC["+ linha +","+ coluna +"]");

        boolean venceu = this.mapa.verificarGanhador(this.letra);
        if(venceu){
            System.out.println(" ... PC GANHOU!");
            return true;
        }
        return false;
    }
}
