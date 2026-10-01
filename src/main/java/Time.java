import java.util.ArrayList;
import java.util.List;

public class Time {
  private String teamproduct;
  private Pessoa gerente;
  private Pessoa lider;
  private List<Pessoa> devs;
  public Time(String prodname, Pessoa manager) {
    this.teamproduct = prodname;
    this.gerente = manager;
    this.devs = new ArrayList<>();
  }
  public String getTeamProd() {
    return teamproduct;
  }
  public void changeManager(Pessoa manager, boolean promotion) {
    if (this.gerente == null) {
      this.gerente = manager;
      return;
    }
    String tasks = this.gerente.getTasks();
    if (tasks != null && !tasks.isEmpty()) {
      String[] tasklist = tasks.split(", ");
      for (String task : tasklist) {
        manager.addTask(task, false);
      }
    }
    this.gerente.removeRole(false);
    this.gerente = manager;
    if (promotion) {
      if (this.lider != null && this.lider.equals(manager)) {
        int i = this.devs.indexOf(manager);
        if (this.devs.size() > 1) {
          int next = (i == this.devs.size() - 1) ? 0 : i + 1;
          this.lider = this.devs.get(next);
        } else {
          this.lider = null;
        }
      }
      this.devs.remove(manager);
    }
  }
  public void addDev(Pessoa dev) {
    if (this.devs.isEmpty()) {
      dev.Lider("");
      this.lider = dev;
    }
    this.devs.add(dev);
  }
  public void newSprint() {
    if (this.devs.isEmpty()) { 
      return; 
    }
    if (this.devs.size() == 1) { 
      return; 
    }
    String tasks = this.lider.getTasks();
    int i = this.devs.indexOf(this.lider);
    if (i != -1) {
      int next = (i == this.devs.size() - 1) ? 0 : i + 1;
      this.lider = this.devs.get(next);
    } else { 
      this.lider = this.devs.get(0); 
    }
    this.lider.Lider(tasks);
  }
  public Pessoa promote() {
    if (this.gerente == null) {
      throw new IllegalArgumentException("Não existe");
    }
    Pessoa old = this.gerente;
    if (this.lider != null) {
      this.changeManager(this.lider, true);
    } else {
      this.gerente = null; 
    }
    return old;
  }
  public Pessoa promoteManager(String cpf) {
    for (Pessoa dev : devs) {
      if (dev.getCPF().equals(cpf)) {
        String tasks = dev.getTasks();
        boolean wasLeader = dev.equals(lider);
        if (wasLeader) {
          int i = devs.indexOf(dev);
          if (devs.size() > 1) {
            int next = (i == devs.size() - 1) ? 0 : i + 1;
            lider = devs.get(next);
            lider.Lider(tasks);
          } else {
            lider = null;
          }
        }
        dev.promotion(tasks);
        devs.remove(dev);
        gerente = dev;
        return dev;
      }
    }
    throw new IllegalArgumentException("Não existe");
  }
}
