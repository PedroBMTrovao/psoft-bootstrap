package atv5.at;

import java.math.BigDecimal;

public class Entrega {
  private int id;
  private Pedido pedido;
  private Modalidade modalidade;
  private double tempo;
  private BigDecimal preco;
  private String status;
  public Entrega(int id, Pedido pedido, Modalidade mod) {
    this.id = id;
    this.pedido = pedido;
    this.modalidade = mod;
    this.tempo = mod.recalcularTempo(pedido.getDistancia());
    this.preco = mod.recalcularPreco(pedido.getDistancia(), pedido.getPeso());
    this.status = "SOLICITADO";
  }
  
}
