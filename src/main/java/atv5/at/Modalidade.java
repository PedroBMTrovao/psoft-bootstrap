package atv5.at;

import java.math.BigDecimal;

public interface Modalidade {
  String check();
  double recalcularTempo(double dist);
  BigDecimal recalcularPreco(double dist, double peso);
}
