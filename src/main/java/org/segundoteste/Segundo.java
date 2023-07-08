package org.segundoteste;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Segundo {
  private static List<Candidato> candidatos = new ArrayList<>();
  private static List<String> aprovados = new ArrayList<>();

  static int id;

    public int iniciarProcesso(String nome) throws Exception {
      if (nome == null || nome.isEmpty()) {
        throw new Exception("Nome inválido.");
      }
      for (Candidato candidato : candidatos) {
        if (candidato.getNome().equals(nome)) {
          throw new Exception("Candidato já participa do processo.");
        }
      }

      Candidato novoCandidato = new Candidato(nome, "Recebido");

      candidatos.add(novoCandidato);

      int novoId = candidatos.size();

      for (int i = 0; i < candidatos.size(); i++) {
        if (candidatos.get(i).getId() == novoId) {
          novoId++;
          i = -1;
        }
      }

      novoCandidato.setId(novoId);
      this.id = novoCandidato.getId();

      return novoCandidato.getId();
    }

  public void marcarEntrevista(int codCandidato) throws Exception {
    boolean encontrado = false;

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
    boolean encontrado = false;
    for (int i = 0; i < candidatos.size(); i++) {
      if (Objects.equals(candidatos.get(i).getId(), codCandidato)) {
          candidatos.remove(i);
          encontrado = true;
          break;
      }
    }

    if (!encontrado) {
      throw new Exception("Candidato não encontrado");
    }
  }

  public String verificarStatusCandidato(int codCandidato) throws Exception {
      boolean encontrado = false;
      String statusDoCandidato = "";
      for (Candidato candidato : candidatos) {
        if (Objects.equals(candidato.getId(), codCandidato)) {
          statusDoCandidato = candidato.getStatus();
          encontrado = true;
        }
      }
      if (!encontrado) {
        throw new Exception("Candidato não encontrado");
      }
      return statusDoCandidato;
  }

  public void aprovarCandidato(int codCandidato) throws Exception {
      boolean encontrado = false;
      for (Candidato candidato : candidatos) {
        if (Objects.equals(candidato.getId(), codCandidato)) {
          if (Objects.equals(candidato.getStatus(), "Qualificado")) {
            candidato.setStatus("Aprovado");
            encontrado = true;
            break;
          }
        }
    }

    if (!encontrado) {
      throw new Exception("Candidato não encontrado");
    }
  }

  public List<String> obterAprovados() {
    for (Candidato candidato : candidatos) {
      System.out.println("CANDIDATOS: " + candidato.getId());
        if (Objects.equals(candidato.getStatus(), "Aprovado")) {
          aprovados.add(candidato.getNome());
      }
    }

    return aprovados;
  }

  public int getId() {
    return id;
  }
}
