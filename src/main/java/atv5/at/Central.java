package atv5.at;

import java.util.ArrayList;

public class Central {
  private static Central instance = null;
  private ArrayList<Pedido> pedidos;
  private ArrayList<Entrega> entregas;
  private Central() {
    this.pedidos = new ArrayList<>();
    this.entregas = new ArrayList<>();
  }
  public static Central getInstance() {
    if (instance == null) {
      this.instance = new Central();
    }
    return instance;
  }
  public int makePedido(String client, String origem, String dest, double peso, double dist) {
    if (pedidos.isEmpty()) {
      Pedido pedido = new Pedido(1, client, origem, dest, peso, dist);
      pedidos.add(pedido);
      return 1;
    }
    for (int i = 0; i < pedidos.size(); i++) {
      if (pedidos.get(i) == null) {
        Pedido pedido = new Pedido(i + 1, client, origem, dest, peso, dist);
        pedidos.get(i) = pedido;
        return i + 1;
      }
    }
    Pedido pedido = new Pedido(pedidos.size() + 1, client, origem, dest, peso, dist);
    pedidos.add(pedido);
    return pedidos.size() + 1;
  }
}
