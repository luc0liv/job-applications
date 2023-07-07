package org.segundoteste;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Segundo {
  private static List<Candidato> candidatos = new ArrayList<>();
  private static List<Candidato> aprovados = new ArrayList<>();

    public int iniciarProcesso(String nome) throws Exception {
      if (nome == "" || nome == null) {
        throw new Exception("Nome inválido.");
      }
      for (Candidato candidato : candidatos) {
        if (candidato.getNome().equals(nome)) {
          throw new Exception("Candidato já participa do processo.");
        }
      }

      Candidato novoCandidato = new Candidato(new IdGenerator().random(), nome, "Recebido");
      candidatos.add(novoCandidato);
      System.out.println(candidatos);
      return novoCandidato.getId();
    }

  public void marcarEntrevista(int codCandidato) throws Exception {
    for (Candidato candidato : candidatos) {
      if (Objects.equals(candidato.getId(), codCandidato)) {
        if (Objects.equals(candidato.getStatus(), "Recebido")) {
//          System.out.println("Antigo status: " + candidato.getStatus());
          candidato.setStatus("Qualificado");
//          System.out.println("Novo Status: " + candidato.getStatus());
        }
      } else {
        throw new Exception("Candidato não encontrado");
      }
    }
  }
//
  public void desqualificarCandidato(int codCandidato) throws Exception {
    for (int i = 0; i < candidatos.size(); i++) {
      if (Objects.equals(candidatos.get(i).getId(), codCandidato)) {
          candidatos.remove(i);
      } else {
        throw new Exception("Candidato não encontrado");
      }
    }
  }
//
  public String verificarStatusCandidato(int codCandidato) throws Exception {
      String statusDoCandidato = "";
      for (Candidato candidato : candidatos) {
        if (Objects.equals(candidato.getId(), codCandidato)) {
          statusDoCandidato = candidato.getStatus();
        } else {
          throw new Exception("Candidato não encontrado");
        }
      }
      return statusDoCandidato;
  }
//
  public void aprovarCandidato(int codCandidato) throws Exception {
    for (Candidato candidato : candidatos) {
      if (Objects.equals(candidato.getId(), codCandidato)) {
        if (Objects.equals(candidato.getStatus(), "Qualificado")) {
          candidato.setStatus("Aprovado");
        }
      } else {
        throw new Exception("Candidato não encontrado");
      }
    }
  }
//
  public List<Candidato> obterAprovados() {
//    List<Candidato> candidatosAprovados = new ArrayList<>();
    for (Candidato candidato : candidatos) {
        if (Objects.equals(candidato.getStatus(), "Aprovado")) {
          System.out.println(candidato);
          aprovados.add(candidato);
      }
    }

    return aprovados;
  }
}
