package org.segundoteste;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Segundo {
  private static List<Candidato> candidatos = new ArrayList<>();
  private static List<String> aprovados = new ArrayList<>();

  private int id;

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
      this.id = novoCandidato.getId();
      System.out.println("ID DO CANDIDATO: " + novoCandidato.getId());
      return novoCandidato.getId();
    }

  public void marcarEntrevista(int codCandidato) throws Exception {
    boolean encontrado = false;

    System.out.println("Tamanho da lista de candidatos: " + candidatos.size());

    for (Candidato candidato : candidatos) {
      if (candidato.getId() == codCandidato) {
        System.out.println(candidato.getId() + " " + candidato.getNome());
        candidato.setStatus("Qualificado");
        encontrado = true;
        break;
      }
    }

    if (!encontrado) {
      throw new Exception("Candidato não encontrado");
    }
  }

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
      boolean notFound = false;
    for (Candidato candidato : candidatos) {
      if (Objects.equals(candidato.getId(), codCandidato)) {
        if (Objects.equals(candidato.getStatus(), "Qualificado")) {
          candidato.setStatus("Aprovado");
          notFound = false;
          break;
        }
      }
      notFound = true;
    }

    if (notFound) {
      throw new Exception("Candidato não encontrado");
    }
  }

  public List<String> obterAprovados() {
    for (Candidato candidato : candidatos) {
        if (Objects.equals(candidato.getStatus(), "Aprovado")) {
          System.out.println(candidato);
          aprovados.add(candidato.getNome());
      }
    }

    return aprovados;
  }

  public int getId() {
    return id;
  }
}
