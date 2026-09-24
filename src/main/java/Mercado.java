// Os tipos de alguns atributos e argumentos foram substituídos
import java.util.ArrayList;
import java.math.BigDecimal;
import java.math.RoundingMode;

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
    Cliente cliente = new Cliente(name, status);
    clientes.add(cliente);
  }
  public boolean changeUserStatus(String name) {
    for (Cliente client : clientes) {
      if (name.equals(client.getName())) {
        return client.changeStatus();
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
    Produto produto = new Produto(name, price);
    produtos.add(produto);
  }
  public int addSale(String user) {
    for (Cliente client : clientes) {
      if (user.equals(client.getName())) {
        Venda sale = new Venda(noVenda, client);
        vendas.add(sale);
        return noVenda++;
      }
    }
    throw new IllegalArgumentException("Não existe");
  }
  public void addItemSale(int saleNo, String product, int quantity) {
    if (saleNo <= 0 || saleNo >= noVenda) {
      throw new IllegalArgumentException("Não existe");
    }
    boolean check = false;
    for (Produto prod : produtos) {
      if (product.equals(prod.getName())) {
        vendas.get(saleNo - 1).addItem(prod, quantity);
        check = true;
        break;
      }
    }
    if (!check) {
      throw new IllegalArgumentException("Produto não existe");
    }
  }
  public BigDecimal addPayment(int saleNo) {
    if (saleNo <= 0 || saleNo >= noVenda) {
      throw new IllegalArgumentException("Não existe");
    }
    return vendas.get(saleNo - 1).pagamento();
  }
}
