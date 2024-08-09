package model;

import java.util.ArrayList;

public class Jogo {
  private final Equipe[] equipes = new Equipe[2];
  private final ArrayList<Integer> vencedoresSets;
  private int vencedorJogo = -1;

  public Jogo(Equipe equipe1, Equipe equipe2) {
    equipes[0] = equipe1;
    equipes[1] = equipe2;
    this.vencedoresSets = new ArrayList();
  }

  public Equipe getMandante() {
    return equipes[0];
  }

  public Equipe getVisitante() {
    return equipes[1];
  }

  private void setVencedorJogo(int vencedorJogo) {
    this.vencedorJogo = vencedorJogo;
  }

  public Equipe getVencedorJogo() {
    if (vencedorJogo == -1) {
      return null;
    } else {
      return equipes[vencedorJogo];
    }
  }

  public Equipe getVencedorSet(int i) {
    if (i <= vencedoresSets.size()) {
      return equipes[vencedoresSets.get(i - 1)];
    } else {
      return null;
    }
  }

  public void fecharSet(int pontosMandante, int pontosVisitante) {
    int vencedor;

    if (pontosMandante > pontosVisitante) {
      vencedor = 0;
    } else {
      vencedor = 1;
    }

    int setsGanhos = 1;
    for (int vencedorSet : vencedoresSets) {
      if (vencedor == vencedorSet) {
        setsGanhos++;
        if (setsGanhos == 3) {
          this.setVencedorJogo(vencedor);
        }
      }
    }

    vencedoresSets.add(vencedor);
  }
}
