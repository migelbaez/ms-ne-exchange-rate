package pe.com.fintech.expose.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@AllArgsConstructor
@Builder
@Getter
@NoArgsConstructor
@Setter
@ToString
public class ExchangeRateRequest {

  private BigDecimal sourceAmount;

  @NotBlank(message = "Source Currency ISO code cannot be blank")
  private String sourceCurrency;
  @NotBlank(message = "Target Currency ISO code cannot be blank")
  private String targetCurrency;
}
