import java.util.List;
import java.util.ArrayList;

public class Empresa {
  private List<Time> times;
  private List<Pessoa> pessoas;
  private Pessoa productOwner;
  public Empresa(String nome, String cpf) {
    this.times = new ArrayList<>();
    this.pessoas = new ArrayList<>();
    this.productOwner = new Pessoa(nome, cpf, "PO");
    this.pessoas.add(this.productOwner);
  }
  public void addTeam(String teamprod, String nome, String cpf) {
    for (Pessoa p : pessoas) {
      if (p.getCPF().equals(cpf)) {
        throw new IllegalArgumentException("Já existe");
      }
    }
    for (Time t : times) {
      if (t.getTeamProd().equals(teamprod)) {
        throw new IllegalArgumentException("Já existe");
      }
    }
    Pessoa manager = new Pessoa(nome, cpf, "Man");
    Time time = new Time(teamprod, manager);
    times.add(time);
    pessoas.add(manager);
  }
  public void addDev(String teamprod, String nome, String cpf) {
    for (Pessoa p : pessoas) {
      if (p.getCPF().equals(cpf)) {
        throw new IllegalArgumentException("Já existe");
      }
    }
    for (Time t : times) {
      if (t.getTeamProd().equals(teamprod)) {
        Pessoa dev = new Pessoa(nome, cpf, "Dev");
        pessoas.add(dev);
        t.addDev(dev);
        return;
      }
    }
    throw new IllegalArgumentException("Não existe");
  }
  public void changeProdOwner(String nome, String cpf) {
    for (Pessoa p : pessoas) {
      if (p.getCPF().equals(cpf)) {
        throw new IllegalArgumentException("Já existe");
      }
    }
    Pessoa po = new Pessoa(nome, cpf, "PO");
    pessoas.add(po);
    String tasks = this.productOwner.getTasks();
    if (tasks != null && !tasks.isEmpty()) {
      String[] tasklist = tasks.split(", ");
      for (String task : tasklist) {
        po.addTask(task, false);
      }
    }
    this.productOwner.removeRole(false);
    this.productOwner = po;
  }
  public void changeManager(String teamprod, String nome, String cpf) {
    for (Pessoa p : pessoas) {
      if (p.getCPF().equals(cpf)) {
        throw new IllegalArgumentException("Já existe");
      }
    }
    for (Time t : times) {
      if (t.getTeamProd().equals(teamprod)) {
        Pessoa man = new Pessoa(nome, cpf, "Man"); 
        pessoas.add(man);
        String[] tasklist = this.productOwner.getTasks().split(", "); 
        if (tasklist.length > 1 || tasklist[0] != "") {
          for (String task : tasklist) {
            po.addTask(task); 
          } 
        } 
        this.productOwner.removeRole(false); 
        this.productOwner = po;
        return;
      }
    }
    throw new IllegalArgumentException("Não existe");
  }
  public void promoteProdOwner(String teamprod) {
    for (Time t : times) {
      if (t.getTeamProd().equals(teamprod)) {
        Pessoa promovida = t.promote();
        String tasks = this.productOwner.getTasks();
        if (tasks != null && !tasks.isEmpty()) {
          String[] tasklist = tasks.split(", ");
          for (String task : tasklist) {
            promovida.addTask(task, false);
          }
        }
        this.productOwner.removeRole(false);
        this.productOwner = promovida;
        return;
      }
    }
    throw new IllegalArgumentException("Não existe");
  }
  public void promoteManager(String teamprod, String cpf) {
    for (Time t : times) {
      if (t.getTeamProd().equals(teamprod)) {
        t.promoteManager(cpf);
        return;
      }
    }
    throw new IllegalArgumentException("Não existe");
  }
  public void newSprint() {
    for (Time t : times) {
      t.newSprint();
    }
  }
  public void addTask(String cpf, String task) {
    for (Pessoa p : pessoas) {
      if (p.getCPF().equals(cpf)) {
        p.addTask(task, false);
        return;
      }
    }
    throw new IllegalArgumentException("Não existe");
  }
  public void addTaskLider(String teamprod, String task) {
    for (Time t : times) {
      if (t.getTeamProd().equals(teamprod)) {
        t.addTaskLider(task);
        return;
      }
    }
    throw new IllegalArgumentException("Não existe");
  }
}
