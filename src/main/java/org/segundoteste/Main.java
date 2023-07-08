package org.segundoteste;
import java.util.List;

public class Main {

  public static void main(String[] args) throws Exception {
    Segundo teste = new Segundo();
    Segundo teste2 = new Segundo();
    Segundo teste3 = new Segundo();
    Segundo teste4 = new Segundo();

    int candidato1 = teste.iniciarProcesso("Luciana");
    int candidato2 = teste2.iniciarProcesso("Pedro");
    int candidato3 = teste3.iniciarProcesso("Maria");
    int candidato4 = teste4.iniciarProcesso("Laura");

    teste.marcarEntrevista(candidato1);
    teste.aprovarCandidato(candidato1);

    teste2.marcarEntrevista(candidato2);
    teste2.aprovarCandidato(candidato2);

    teste3.marcarEntrevista(candidato3);
    teste3.desqualificarCandidato(candidato3);

    teste4.marcarEntrevista(candidato4);
    teste4.aprovarCandidato(candidato4);

    List<String> candidatosAprovados = teste4.obterAprovados();
    System.out.println(candidatosAprovados);
    System.out.println(teste3.verificarStatusCandidato(2));
  }
}