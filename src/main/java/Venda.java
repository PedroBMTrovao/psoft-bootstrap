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
    
  }
}
