package org.segundoteste;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Segundo {
//  private int id;
  private static List<Candidato> candidatos = new ArrayList<>();
//  private String status;
//  private static List<String> aprovados = new ArrayList<>();

//  public Segundo() {
//    int newNumber = new IdGenerator().random();
//    this.id = newNumber;
//  }

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
//  public void desqualificarCandidato(int codCandidato)
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
//  public void aprovarCandidato(int codCandidato)
//
//  public List<String> obterAprovados()

//  public int getId() {
//    return id;
//  }
//
//  public void setId(int id) {
//    this.id = id;
//  }
}
