package org.segundoteste;

import java.util.Random;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

  public static void main(String[] args) throws Exception {
//    Segundo teste1 = new Segundo();
//    int teste1Id = teste1.iniciarProcesso("Lua");
//    System.out.println(teste1Id);
    Segundo teste2 = new Segundo();
    int teste2Id = teste2.iniciarProcesso("Luiza");
    System.out.println(teste2Id);
    teste2.marcarEntrevista(teste2Id);
//    teste.iniciarProcesso("Luciana");
//    System.out.println("Id do estudante 1: " + teste.getId());
//    Segundo teste2 = new Segundo();
//    teste2.iniciarProcesso("Luciane");
//    System.out.println("Id do estudante 2: " + teste2.getId());
  }
}