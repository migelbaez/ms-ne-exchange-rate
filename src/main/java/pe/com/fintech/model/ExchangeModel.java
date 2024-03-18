package pe.com.fintech.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "exchange")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExchangeModel implements Serializable {

  @Id
  @GeneratedValue(strategy = IDENTITY)
  private Long id;
  @Column
  private String sourceCurrency;
  @Column
  private String targetCurrency;
  @Column
  private BigDecimal rate;
}
