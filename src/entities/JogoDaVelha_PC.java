package src.entities;

public class JogoDaVelha_PC {
  private JogoDaVelha_Mapa mapa = new JogoDaVelha_Mapa();

  private char letra = 'O';

  public JogoDaVelha_PC(JogoDaVelha_Mapa mapa) {
    this.mapa = mapa;
  }

  public boolean joga() {
    int l, c;
    do {
      l = mapa.sortear(0, 3);
      c = mapa.sortear(0, 3);
    } while (!mapa.jogar(l, c, letra));
    if (mapa.ganhou(letra)) {
      mapa.desenha(0);
      System.out.println(" ... PC GANHOU!");
      return true;
    }
    return false;
  }
}
