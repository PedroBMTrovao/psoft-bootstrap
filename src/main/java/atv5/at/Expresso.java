package atv5.at;

import java.math.BigDecimal;

public class Expresso implements Modalidade {
  @Override
  public String check() {
    return "Expresso";
  }
  @Override
  public double recalcularTempo(double dist) {
    double r = 6 + (dist * 0.4);
    return r;
  }
  BigDecimal recalcularPreco(double dist, double peso) {
    BigDecimal base = BigDecimal.valueOf(150);
    BigDecimal custoPeso = BigDecimal.valueOf(peso).multiply(BigDecimal.valueOf(5));
    BigDecimal custoDist = BigDecimal.valueOf(dist).multiply(BigDecimal.valueOf(6));
    return base.add(custoPeso).add(custoDist);;
  }
}
