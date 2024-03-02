package src.main;

import java.util.Scanner;

import src.entities.JogoDaVelha_Jogador;
import src.entities.JogoDaVelha_Mapa;
import src.entities.JogoDaVelha_PC;

public class JogoDaVelha {
  private void jogar() {

    int jogadas = 0;
    int vez = (int) (Math.random() * 2);

    final JogoDaVelha_Mapa jogoMapa = new JogoDaVelha_Mapa();
    final JogoDaVelha_PC jogoPC = new JogoDaVelha_PC(jogoMapa);
    final JogoDaVelha_Jogador jogoJogador = new JogoDaVelha_Jogador(jogoMapa);

    jogoMapa.limpaMapa();

    if (vez == 0) {
      System.out.println("Você começa!");
    } else {
      System.out.println("PC começa!");
    }

    while (jogadas < 9) {
      jogoMapa.desenha(jogadas);
      if (vez == 0) {
        if (jogoJogador.joga(new Scanner(System.in))) {
          break;
        }
      } else {
        if (jogoPC.joga()) {
          break;
        }
      }
      vez = (vez + 1) % 2;
      jogadas++;
      if (jogadas == 9) {
        jogoMapa.desenha(jogadas);
        System.out.println("Deu velha!");
      }

    }

  }

  public static void main(String[] args) {
    Scanner teclado = new Scanner(System.in);

    boolean jogarNovamente = true;

    while (jogarNovamente) {
      new JogoDaVelha().jogar();
      System.out.println("Deseja jogar novamente? (s/n)");
      jogarNovamente = teclado.next().equalsIgnoreCase("s");
    }

    teclado.close();
  }

}