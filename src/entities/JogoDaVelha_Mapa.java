package src.entities;

public class JogoDaVelha_Mapa {
  private char[][] mapa = new char[3][3];

  public int sortear(int inicio, int fim) {
    return (int) (Math.random() * fim) + inicio;
  }

  public void limpaMapa() {
    for (int i = 0; i < mapa.length; i++) {
      for (int j = 0; j < mapa[i].length; j++) {
        mapa[i][j] = ' ';
      }
    }
  }

  public void desenha(int jogada) {
    System.out.println("-------------");
    System.out.println("  Jogada: " + jogada);
    System.out.println("-------------");
    for (int i = 0; i < mapa.length; i++) {
      System.out.print(i + " ");
      for (int j = 0; j < mapa[i].length; j++) {
        System.out.print(mapa[i][j]);
        if (j < mapa[i].length - 1) {
          System.out.print("|");
        }
      }
      System.out.println();
      if (i < mapa.length - 1) {
        System.out.println("  -----");
      }
    }
    System.out.println();
  }

  public boolean jogar(int l, int c, char jogador) {
    if (mapa[l][c] == ' ') {
      mapa[l][c] = jogador;
      return true;
    } else {
      return false;
    }
  }

  public boolean ganhou(char jogador) {
    for (int i = 0; i < mapa.length; i++) {
      if (mapa[i][0] == jogador && mapa[i][1] == jogador && mapa[i][2] == jogador) {
        return true;
      }
    }
    for (int i = 0; i < mapa.length; i++) {
      if (mapa[0][i] == jogador && mapa[1][i] == jogador && mapa[2][i] == jogador) {
        return true;
      }
    }
    if (mapa[0][0] == jogador && mapa[1][1] == jogador && mapa[2][2] == jogador) {
      return true;
    }
    if (mapa[0][2] == jogador && mapa[1][1] == jogador && mapa[2][0] == jogador) {
      return true;
    }
    return false;
  }

}