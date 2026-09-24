// Os tipos de alguns atributos e argumentos foram substituídos
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class Venda {
  private int numero;
  private Cliente cliente;
  private boolean pagamento;
  private ArrayList<ItemVenda> itens;
  public Venda(int number, Cliente client) {
    this.numero = number;
    this.cliente = client;
    this.pagamento = false;
    this.itens = new ArrayList<>();
  }
  public void addItem(Produto product, int quant) {
    ItemVenda item = new ItemVenda(product, quant);
    itens.add(item);
  }
  public BigDecimal pagamento() {
    if (itens.isEmpty()) {
      throw new IllegalArgumentException("Compra vazia");
    }
    BigDecimal total = new BigDecimal("0.00"); 
    for (ItemVenda item : itens) {
      total = total.add(item.subtotal());
    }
    if (cliente.isPremium()) {
      total = total.multiply(new BigDecimal("0.95"));
    }
    this.pagamento = true;
    return total.setScale(2, RoundingMode.HALF_UP);
  }
}
