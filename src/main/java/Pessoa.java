import java.util.Collections;
import java.util.ArrayList;

public class Pessoa {
  private String name;
  private String cpf;
  private Collections<Papel> papeis;
  public Pessoa(String name, String cpf, Papel role) {
    this.nome = name;
    this.cpf = cpf;
    this.papeis = new ArrayList<>();
    papeis.add(role);
  }
  
}
