package model;

import java.util.ArrayList;

public class Equipe {
  private final String nome;
  private final ArrayList<Jogador> jogadores;

  public Equipe(String nome) {
    this.nome = nome;
    this.jogadores =  new ArrayList();
  }

  public String getNome() {
    return this.nome;
  }

  public int getNumeroJogadores() {
    return this.jogadores.size();
  }

  public void inscrever(Jogador jogador) {
    if (!this.jogadores.contains(jogador)) {
      this.jogadores.add(jogador);
    }
  }

  public Jogador getJogador(int i) {
    if (i <= jogadores.size()) {
      return jogadores.get(i - 1);
    } else {
      return null;
    }
  }
}
