public class Cliente {
  private String nome;
  private boolean status;
  public Cliente(String name, boolean status) {
    this.nome = name;
    this.status = status;
  }
  public String getName() {
    return nome;
  }
  public boolean isPremium() {
    return status;
  }
  public boolean changeStatus() {
    this.status = !this.status;
    return this.status;
  }
}
