package qa.kurs.sandbox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Collections {
  public static void main(String[] args) {
    String[] langs = {"Java", "C#", "python", "PHP"};

    List<String> languages = Arrays.asList("Java", "C#", "python", "PHP");

    for (String l : languages){
      System.out.println("Chcę nauczyć się " + l);
    }
  }
}
