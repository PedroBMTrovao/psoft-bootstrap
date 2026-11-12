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
        pedidos.set(i, pedido);
        return i + 1;
      }
    }
    Pedido pedido = new Pedido(pedidos.size() + 1, client, origem, dest, peso, dist);
    pedidos.add(pedido);
    return pedidos.size() + 1;
  }
  public int solicitarEntregaConv(int id) {
    if (id > pedidos.size()) {
      throw new IllegalArgumentException();
    }
    for (int i = 0; i < pedidos.size(); i++) {
      if (pedidos.get(i) != null && pedidos.get(i).getID() == id) {
        Modalidade mod = new Convencional();
        Entrega ent = new Entrega(entregas.size() + 1, pedidos.get(i), mod);
        pedidos.set(i, null);
        return entregas.size();
      }
    }
    throw new IllegalArgumentException();
  }
  public int solicitarEntregaExp(int id) {
    if (id > pedidos.size()) {
      throw new IllegalArgumentException();
    }
    for (int i = 0; i < pedidos.size(); i++) {
      if (pedidos.get(i) != null && pedidos.get(i).getID() == id) {
        Modalidade mod = new Expresso();
        Entrega ent = new Entrega(entregas.size() + 1, pedidos.get(i), mod);
        pedidos.set(i, null);
        return entregas.size();
      }
    }
    throw new IllegalArgumentException();
  }
  public int solicitarEntregaEco(int id) {
    if (id > pedidos.size()) {
      throw new IllegalArgumentException();
    }
    for (int i = 0; i < pedidos.size(); i++) {
      if (pedidos.get(i) != null && pedidos.get(i).getID() == id) {
        Modalidade mod = new Economico();
        Entrega ent = new Entrega(entregas.size() + 1, pedidos.get(i), mod);
        pedidos.set(i, null);
        return entregas.size();
      }
    }
    throw new IllegalArgumentException();
  }
  public void changeToConv(int id) {
    if (id > entregas.size()) {
      throw new IllegalArgumentException();
    }
    for (int i = 0; i < entregas.size(); i++) {
      if (entregas.get(i).getID() == id) {
        if (!entregas.get(i).getStatus().equals("SOLICITADO")) {
          throw new IllegalArgumentException();
        }
        entregas.get(i).convSwitch();
        return;
      }
    }
    throw new IllegalArgumentException();
  }
  public void changeToExp(int id) {
    if (id > entregas.size()) {
      throw new IllegalArgumentException();
    }
    for (int i = 0; i < entregas.size(); i++) {
      if (entregas.get(i).getID() == id) {
        if (!entregas.get(i).getStatus().equals("SOLICITADO")) {
          throw new IllegalArgumentException();
        }
        entregas.get(i).expSwitch();
        return;
      }
    }
    throw new IllegalArgumentException();
  }
  public void changeToEco(int id) {
    if (id > entregas.size()) {
      throw new IllegalArgumentException();
    }
    for (int i = 0; i < entregas.size(); i++) {
      if (entregas.get(i).getID() == id) {
        if (!entregas.get(i).getStatus().equals("SOLICITADO")) {
          throw new IllegalArgumentException();
        }
        entregas.get(i).ecoSwitch();
        return;
      }
    }
    throw new IllegalArgumentException();
  }
  public String acompany(int id) {
    if (id > entregas.size()) {
      throw new IllegalArgumentException();
    }
    for (int i = 0; i < entregas.size(); i++) {
      if (entregas.get(i).getID() == id) {
        return entregas.get(i).acompany();
      }
    }
    throw new IllegalArgumentException();
  }
  public void batch(int quant) {
    
  }
}
