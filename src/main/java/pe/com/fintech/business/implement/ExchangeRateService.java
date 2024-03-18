package pe.com.fintech.business.implement;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pe.com.fintech.business.IExchangeRateService;
import pe.com.fintech.expose.request.ExchangeRateRequest;
import pe.com.fintech.expose.response.ExchangeRateResponse;
import pe.com.fintech.model.ExchangeModel;
import pe.com.fintech.repository.IExchangeRepository;
import pe.com.fintech.utils.ExchangeNotFoundException;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class ExchangeRateService implements IExchangeRateService {

  private final IExchangeRepository exchangeRepository;
  @Override
  public Mono<ExchangeRateResponse> calculates(ExchangeRateRequest request) {
    var result = exchangeRepository.findBySourceCurrencyAndTargetCurrency(request.getSourceCurrency(), request.getTargetCurrency());
    return result.map(exchangeModel ->
        calculate(request.getSourceAmount(), exchangeModel.getRate())
            .map(exchangeResult -> ExchangeRateResponse
                .builder()
                .exchange(exchangeResult)
                .rate(exchangeModel.getRate())
                .build())).orElseThrow(() -> new ExchangeNotFoundException("Exchange not found"));
  }

  private Mono<BigDecimal> calculate(BigDecimal sourceAmount, BigDecimal rate){
    return Mono.just(sourceAmount.multiply(rate));
  }
}
