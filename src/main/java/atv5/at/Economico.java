package atv5.at;

import java.math.BigDecimal;

public class Economico implements Modalidade {
  @Override
  public String check() {
    return "Economico";
  }
  @Override
  public double recalcularTempo(double dist) {
    double r = 15 + (dist * 1.2);
    return r;
  }
  BigDecimal recalcularPreco(double dist, double peso) {
    BigDecimal base = BigDecimal.valueOf(80);
    BigDecimal custoPeso = BigDecimal.valueOf(peso).multiply(BigDecimal.valueOf(4));
    BigDecimal custoDist = BigDecimal.valueOf(dist).multiply(BigDecimal.valueOf(2));
    return base.add(custoPeso).add(custoDist);;
  }
}
