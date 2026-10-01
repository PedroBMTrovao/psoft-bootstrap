import java.util.List;
import java.util.ArrayList;

public class Pessoa {
  private String nome;
  private String cpf;
  private List<Papel> papeis;
  public Pessoa(String name, String cpf, Papel role) {
    this.nome = name;
    this.cpf = cpf;
    this.papeis = new ArrayList<>();
    papeis.add(role);
  }
  public void Lider(String tasks) {
    if (papeis.get(0).getRole().equals("Dev")) {
      String[] tasklist = tasks.split(", ");
      Papel lider = new Lider();
      for (String task : tasklist) {
        lider.addTask(task);
      }
      papeis.add(lider);
    }
  }
  public void promotion(String tasks) {
    if (papeis.get(0).getRole().equals("Dev")) {
      String[] tasklist = tasks.split(", ");
      Papel manager = new Gerente();
      for (String task : tasklist) {
        manager.addTask(task);
      }
      if (papeis.size() > 1) {
        papeis.remove(1);
      }
      papeis.set(0, manager);
    } else if (papeis.get(0).getRole().equals("Man")) {
      String[] tasklist = tasks.split(", ");
      Papel PO = new ProductOwner();
      for (String task : tasklist) {
        PO.addTask(task);
      }
      papeis.set(0, PO);
    }
  }
  public String getCPF() {
    return cpf;
  }
  public void removeRole(boolean lider) {
    if (lider && papeis.size() > 1) {
      papeis.remove(1); 
    } else if (lider) {
      throw new IllegalArgumentException("Não lider");
    } else {
      this.papeis = new ArrayList<>();
    }
  }
  public String getTasks() {
    if (papeis.size() > 1) {
      return papeis.get(1).getTasks(); 
    }
    return papeis.get(0).getTasks()
  }
  public void addTask(String task, boolean lider) {
    if (lider && papeis.size() > 1) {
      papeis.get(1).addTask(task); 
    } else if (lider) {
      throw new IllegalArgumentException("Não lider");
    } else {
      papeis.get(0).addTask(task);
    }
  }
}
