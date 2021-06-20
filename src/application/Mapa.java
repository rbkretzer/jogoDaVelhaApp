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
        System.out.println("------------- .. jogada: "+jogada);
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
        boolean jogadorVenceu = verificarGanhador('X');
        boolean pcVenceu = verificarGanhador('O');
        if (jogada == 9 && !jogadorVenceu && !pcVenceu) {
            System.out.println(" ... EMPATOU!");
        }
    }

    public boolean jogar(int l, int c, char jogador){
        if (mapa[c][l] == ' ') {
            mapa[c][l] = jogador;
            return false;
        }
        return true; // retorna true para repetir a jogada

    }
    public boolean verificarGanhador(char jogador){
        int qtdDaLetra = 0;
        for(int linha = 0; linha<3; linha++){ //for para verificar as linhas
            for(int coluna = 0; coluna < 3; coluna++) {
                if(this.mapa[linha][coluna] == jogador){
                    qtdDaLetra ++;
                }
                if(qtdDaLetra == 3){
                    return true;
                }
            }
            qtdDaLetra = 0;
        }
        for(int coluna = 0; coluna<3; coluna++){//for para verificar as colunas
            for(int linha = 0; linha < 3; linha++) {
                if(this.mapa[linha][coluna] == jogador){
                    qtdDaLetra ++;
                }
                if(qtdDaLetra == 3){
                    return true;
                }
            }
            qtdDaLetra = 0;
        }
        boolean temNaDiagonal = this.mapa[1][1] == jogador && ((this.mapa[0][0] == jogador && this.mapa[2][2] == jogador) || (this.mapa[0][2] == jogador && this.mapa[2][0] == jogador));
        if(temNaDiagonal){
            return true;
        }
        return false;
    }
}
