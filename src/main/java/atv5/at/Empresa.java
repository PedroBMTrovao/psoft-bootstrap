package atv5.at;

public class Empresa {
  private Central central;
  public Empresa() {
    Central central = Central.central();
    this.central = central;
  }
  public int makePedido(String client, String origem, String dest, double peso, double dist) {
    return central.makePedido(client, origem, dest, peso, dist);
  }
  public int solicitarEntregaConv(int id) {
    return central.solicitarEntregaConv(id);
  }
  public int solicitarEntregaExp(int id) {
    return central.solicitarEntregaExp(id);
  }
  public int solicitarEntregaEco(int id) {
    return central.solicitarEntregaEco(id);
  }
  public void changeToConv(int id) {
    return central.changeToConv(id);
  }
  public void changeToExp(int id) {
    return central.changeToExp(id);
  }
  public void changeToEco(int id) {
    return central.changeToEco(id);
  }
  public String acompany(int id) {
    return central.acompany(id);
  }
  public void batch(int quant) {
    return central.batch(quant);
  }
}
