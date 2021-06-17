package application;

public class PC {
    
    private char letra = 'O';

    public PC(Mapa mapa) {
        int linha = mapa.sortear(0, 3);
        int coluna = mapa.sortear(0, 3);
        boolean temQueJogarDeNovo = false;

            temQueJogarDeNovo = mapa.jogar(linha, coluna, this.letra);
    }

    public boolean jogar() {

    }

}
