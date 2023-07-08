package org.segundoteste;
import java.util.List;

public class Main {

  public static void main(String[] args) throws Exception {
    Segundo teste = new Segundo();
    Segundo teste2 = new Segundo();
    Segundo teste3 = new Segundo();
    Segundo teste4 = new Segundo();

    teste.iniciarProcesso("Luciana");

    teste.marcarEntrevista(teste.getId());

    teste.aprovarCandidato(teste.getId());

    teste2.iniciarProcesso("Pedro");
    System.out.println(teste2.getId());

    teste2.marcarEntrevista(teste2.getId());

    teste2.aprovarCandidato(teste2.getId());



    System.out.println(teste3.verificarStatusCandidato(1));
    teste3.iniciarProcesso("Joana");
    teste3.desqualificarCandidato(2);
    teste4.iniciarProcesso("Ja");


    List<String> candidatosAprovados = teste2.obterAprovados();
    System.out.println(candidatosAprovados);
  }
}