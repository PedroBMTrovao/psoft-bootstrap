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
  public void convSwitch() {
    if (modalidade.check().equals("Convencional")) {
      return;
    }
    this.modalidade = new Convencional();
    this.tempo = modalidade.recalcularTempo(pedido.getDistancia());
    this.preco = modalidade.recalcularPreco(pedido.getDistancia(), pedido.getPeso());
  }
  public void expSwitch() {
    if (modalidade.check().equals("Expresso")) {
      return;
    }
    this.modalidade = new Expresso();
    this.tempo = modalidade.recalcularTempo(pedido.getDistancia());
    this.preco = modalidade.recalcularPreco(pedido.getDistancia(), pedido.getPeso());
  }
  public void ecoSwitch() {
    if (modalidade.check().equals("Economico")) {
      return;
    }
    this.modalidade = new Economico();
    this.tempo = modalidade.recalcularTempo(pedido.getDistancia());
    this.preco = modalidade.recalcularPreco(pedido.getDistancia(), pedido.getPeso());
  }
  public String getStatus() {
    return status;
  }
  public void change() {
    this.status = "ENTREGANDO/ENTREGUE"
  }
  public String acompany() {
    return "ENTREGA: " + id + "\nMODALIDADE DE ENTREGA: " + modalidade.check() + "\nTEMPO ESTIMADO: " + tempo +
      "\nPRECO: " + preco + "\nSTATUS: " + status;
  }
  public int getID() {
    return id;
  }
}
