// Os tipos de alguns atributos e argumentos foram substituídos
import java.util.ArrayList;

public class Mercado {
  private ArrayList<Venda> vendas;
  private ArrayList<Cliente> clientes;
  private ArrayList<Produto> produtos;
  private int noVenda;
  public Mercado() {
    this.vendas = new ArrayList<>();
    this.clientes = new ArrayList<>();
    this.produtos = new ArrayList<>();
    this.noVenda = 1;
  }
  public void createCliente(String name, boolean status) {
    for (Cliente client : clientes) {
      if (name.equals(client.getName())) {
        throw new IllegalArgumentException("Já existe");
      }
    }
    cliente = new Cliente(name, status);
    clientes.add(cliente);
  }
  public boolean changeUserStatus(String name) {
    for (Cliente client : clientes) {
      if (name.equals(client.getName())) {
        client.changeStatus();
        break;
      }
    }
    throw new IllegalArgumentException("Não existe");
  }
  public void addProduto(String name, String price) {
    for (Produto prod : produtos) {
      if (name.equals(prod.getName())) {
        throw new IllegalArgumentException("Já existe");
      }
    }
    produto = new Produto(name, price);
    produtos.add(produto);
  }
}
