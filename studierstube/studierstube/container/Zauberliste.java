package studierstube.container;

import java.util.ArrayList;

public class Zauberliste {
  private static ArrayList liste = new ArrayList(270);
  
  public void add(Zauber z) {
    liste.add(z);
  }
}
