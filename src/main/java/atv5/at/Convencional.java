package atv5.at;

import java.math.BigDecimal;

public class Convencional implements Modalidade {
  @Override
  public String check() {
    return "Convencional";
  }
  @Override
  public double recalcularTempo(double dist) {
    double r = 10 + (dist * 0.6);
    return r;
  }
  @Override
  public BigDecimal recalcularPreco(double dist, double peso) {
    BigDecimal base = BigDecimal.valueOf(100);
    BigDecimal custoPeso = BigDecimal.valueOf(peso).multiply(BigDecimal.valueOf(5));
    BigDecimal custoDist = BigDecimal.valueOf(dist).multiply(BigDecimal.valueOf(4));
    return base.add(custoPeso).add(custoDist);;
  }
}
