// Os tipos de alguns atributos e argumentos foram substituídos
import java.math.BigDecimal;
import java.math.RoundingMode;

public class ItemVenda {
  private Produto produto;
  private int quantidade;
  private boolean desconto;
  public ItemVenda(Produto prod, int quant) {
    this.produto = prod;
    this.quantidade = quant;
    this.desconto = quant >= 20;
  }
  public BigDecimal subtotal() {
    BigDecimal sub = produto.getPrice().multiply(new BigDecimal(quantidade));
    if (desconto) {
      sub.multiply(new BigDecimal("0.90"));
    }
    return sub.setScale(2, RoundingMode.HALF_UP);
  }
}
