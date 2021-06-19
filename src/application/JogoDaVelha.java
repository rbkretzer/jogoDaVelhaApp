
package application;

import java.util.Scanner;

public class JogoDaVelha {
	
	private Mapa jogoMapa;
	private Jogador jogoJogador;
	private PC jogoPC;

	private JogoDaVelha() {
		Scanner teclado = new Scanner(System.in);
		jogoMapa = new Mapa();
		jogoJogador = new Jogador(jogoMapa);
		jogoPC = new PC(jogoMapa);
		char resposta;
		do {
			jogar(teclado);
			do{
				System.out.print("Deseja jogar novamente (s/n)?");
				resposta = teclado.next().trim().toLowerCase().charAt(0);
				if (resposta!='n' || resposta!='s'){
					System.out.println("Resposta inválida!");
				}
				jogoMapa.limpar();
			}while(resposta!='n' || resposta!='s');

		} while (resposta != 'n');
		
		teclado.close();
	}

	private void jogar(Scanner teclado) {

	}

	public static void main(String[] args) {
		new JogoDaVelha();
	}


}
