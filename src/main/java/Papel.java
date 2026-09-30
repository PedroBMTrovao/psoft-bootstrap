import java.util.ArrayList;
import java.util.List;

public interface Papel {
  public void addTask(String task);
  public String getTasks();
  public String getRole();
}
public class Dev implements Papel {
  private List<String> tasks = new ArrayList<>();
  public void addTask(String task) {
    if (task == null || task.trim().isEmpty()) {
      throw new IllegalArgumentException("Tarefa inválida");
    }
    tasks.add(task);
  }
  public String getTasks() {
    return String.join(", ", tasks);
  }
  public String getRole() {
    return "Dev";
  }
}
public class Gerente implements Papel {
  private List<String> tasks = new ArrayList<>();
  public void addTask(String task) {
    if (task == null || task.trim().isEmpty()) {
      throw new IllegalArgumentException("Tarefa inválida");
    }
    tasks.add(task);
  }
  public String getTasks() {
    return String.join(", ", tasks);
  }
  public String getRole() {
    return "Man";
  }
}
public class Lider implements Papel {
  private List<String> tasks = new ArrayList<>();
  public void addTask(String task) {
    if (task == null || task.trim().isEmpty()) {
      throw new IllegalArgumentException("Tarefa inválida");
    }
    tasks.add(task);
  }
  public String getTasks() {
    return String.join(", ", tasks);
  }
  public String getRole() {
    return "Lid";
  }
}
public class ProductOwner implements Papel {
  private List<String> tasks = new ArrayList<>();
  public void addTask(String task) {
    if (task == null || task.trim().isEmpty()) {
      throw new IllegalArgumentException("Tarefa inválida");
    }
    tasks.add(task);
  }
  public String getTasks() {
    return String.join(", ", tasks);
  }
  public String getRole() {
    return "PO";
  }
}
