package model;

import java.util.ArrayList;

public class Torneio {
  private final String nome;
  private final ArrayList<Equipe> equipes;
  private final ArrayList<Jogo> jogos;
  private int vencedorTorneio = -1;

  public Torneio(String nome) {
    this.nome = nome;
    this.equipes =  new ArrayList();
    this.jogos = new ArrayList();
  }

  public String getNome() {
    return this.nome;
  }

  public int getNumeroEquipes() {
    return this.equipes.size();
  }

  public int getNumeroJogos() {
    return this.jogos.size();
  }

  public void inscrever(Equipe equipe) {
    if (!this.equipes.contains(equipe)) {
      this.equipes.add(equipe);

      if (this.equipes.size() > 1) {
        criarNovosJogos();
      }
    }
  }

  public Equipe getEquipe(int i) {
    if (i <= equipes.size()) {
      return equipes.get(i-1);
    } else {
      return null;
    }
  }

  public Jogo getJogo(int i) {
    if (i <= jogos.size()) {
      return jogos.get(i-1);
    } else {
      return null;
    }
  }

  public Equipe getVencedorTorneio() {
    int[] pontosEquipe = new int[equipes.size()];
    int indexEquipeVencedora = 0;

    if (vencedorTorneio == -1) {
      if (jogos.size() == 0) {
        return null;
      }

      for (Jogo jogo : jogos) {
        if (jogo.getVencedorJogo() == null) {
          return null;
        } else {
          pontosEquipe[equipes.indexOf(jogo.getVencedorJogo())]++;
        }
      }

      for (int i = 0; i < equipes.size(); i++) {
        if (pontosEquipe[i] > pontosEquipe[indexEquipeVencedora]) {
          vencedorTorneio = i;
        }
      }

      setVencedorTorneio(indexEquipeVencedora);
      return getVencedorTorneio();
    } else {
      return equipes.get(vencedorTorneio);
    }
  }

  private void setVencedorTorneio(int i) {
    this.vencedorTorneio = i;
  }

  private void criarNovosJogos() {
    Equipe equipeVisitante = this.equipes.get(this.equipes.size()-1);

    for (int i = 0; i < this.equipes.size()-1; i++) {
      addJogo(new Jogo(this.equipes.get(i), equipeVisitante));
    }
  }

  private void addJogo(Jogo jogo) {
    jogos.add(jogo);
  }
}
