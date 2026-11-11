package atv5.at;

public class Pedido {
  private int id;
  private String cliente;
  private String origem;
  private String destino;
  private double peso;
  private double distancia;
  public Pedido(int id, String cliente, String origem, String destino, double peso, double distancia) {
    this.id = id;
    this.cliente = cliente;
    this.origem = origem;
    this.destino = destino;
    this.peso = peso;
    this.distancia = distancia;
  }
  public int getID() {
    return id;
  }
  public double getPeso() {
    return peso;
  }
  public double getDistancia() {
    return distancia;
  }
}
