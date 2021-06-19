package application;

public class PC {
    
    private char letra = 'O';

    private Mapa mapa;

    public PC(Mapa mapa) {
        this.mapa = mapa;
    }

    public boolean jogar() {
        boolean repetir = false;
        do{
            int linha = this.mapa.sortear(0, 3);
            int coluna = this.mapa.sortear(0, 3);
            repetir = this.mapa.jogar(linha, coluna, this.letra);
        }while(repetir);

        boolean venceu = this.mapa.verificarGanhador(this.letra);
        if(venceu){
            System.out.println(" ... PC GANHOU!");
            return true;
        }
        return false;
    }
}
