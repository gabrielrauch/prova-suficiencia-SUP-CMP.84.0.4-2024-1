package src.entities;

import java.util.Scanner;

public class JogoDaVelha_Jogador {
  private JogoDaVelha_Mapa mapa = new JogoDaVelha_Mapa();

  private char letra = 'X';

  public JogoDaVelha_Jogador(JogoDaVelha_Mapa mapa) {
    this.mapa = mapa;
  }

  public boolean joga(Scanner teclado) {
    int l, c;
    do {
      System.out.println("Digite a linha e a coluna que deseja jogar (0 a 2): ");
      l = teclado.nextInt();
      c = teclado.nextInt();

      if (l < 0 || l > 2 || c < 0 || c > 2) {
        System.out.println("Jogada inválida! Digite valores entre 0 e 2.");
      }
    } while (!mapa.jogar(l, c, letra));
    if (mapa.ganhou(letra)) {
      mapa.desenha(0);
      System.out.println(" ... Jogador GANHOU!");
      return true;
    }
    return false;
  }
}
