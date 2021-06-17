package application;

public class Mapa {
    private char[][] mapa = new char[3][3];

    public int sortear(int inicio, int fim){
        String valorTexto = String.valueOf((Math.random() * fim) - inicio);
        int posicaoPonto = valorTexto.indexOf(".");
        String valorInteiroTexto = valorTexto.substring(0, posicaoPonto);
        return Integer.parseInt(valorInteiroTexto);
    }
    public void limpar(){
        for(int coluna = 0; coluna < 3; coluna++){
            for(int linha = 0; linha < 3; linha++){
                this.mapa[coluna][linha] = ' ';
            }
        }
    }
    public void desenhar(int jogada){        
        System.out.println("------------- .. jogador: "+jogada);
        for(int linha = 0 ; linha<3; linha++){
            for(int coluna = 0; coluna<3;coluna++){
                System.out.print("| "+this.mapa[coluna][linha]+" ");
            }
            System.out.println("|");
            if(linha == 2){
                System.out.print("-------------");
            }
            System.out.println("-------------");
        }

    }
    public boolean jogar(int l, int c, char jogador){
        if (mapa[c][l] == ' ') {
            mapa[c][l] = jogador;
        }
    }
    public boolean verificarGanhador(char jogador){
        
    }
}
