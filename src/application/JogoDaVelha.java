
package application;

import java.util.Scanner;

public class JogoDaVelha {
	
	private Mapa jogoMapa;
	private Jogador jogoJogador;
	private PC jogoPC;

	private JogoDaVelha() {
		Scanner teclado = new Scanner(System.in);
		this.jogoMapa = new Mapa();
		this.jogoJogador = new Jogador(this.jogoMapa);
		this.jogoPC = new PC(this.jogoMapa);
		char resposta;
		do {
			jogar(teclado);
			do{
				System.out.print("Deseja jogar novamente (s/n)? ");
				resposta = teclado.next().trim().toLowerCase().charAt(0);
				if (resposta!='n' && resposta!='s'){
					System.out.println("Resposta inválida!");
				}
			}while(resposta!='n' && resposta!='s');

		} while (resposta != 'n');
		
		teclado.close();
	}

	private void jogar(Scanner teclado) {
		int numeroJogadas = 0;
		boolean alguemVenceu = false;

		this.jogoMapa.limpar();
		int quemComeca = this.jogoMapa.sortear(0, 2);
		
		do{
			this.jogoMapa.desenhar(numeroJogadas);
			if(quemComeca%2 == 0){
				alguemVenceu = this.jogoPC.jogar();

			}else{
				alguemVenceu = this.jogoJogador.jogar(teclado);

			}

			quemComeca ++;
			numeroJogadas ++;
		}while(numeroJogadas <= 9 && !alguemVenceu);

	}

	public static void main(String[] args) {
		new JogoDaVelha();
	}
}
