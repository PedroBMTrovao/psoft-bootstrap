// Os tipos de alguns atributos foram substituídos
import java.math.BigDecimal;

public class Produto {
  private String nome;
  private BigDecimal preco;
  public Produto(String name, String price) {
      this.nome = name;
      this.preco = new BigDecimal(price);
  }
  public BigDecimal getPrice() {
      return preco;
  }
  public String getName() {
      return nome;
  }
}
