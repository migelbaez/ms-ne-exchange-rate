package pe.com.fintech.business;

import pe.com.fintech.expose.request.ExchangeRateRequest;
import pe.com.fintech.expose.response.ExchangeRateResponse;
import reactor.core.publisher.Mono;

import java.util.Map;

public interface IExchangeRateService {
  Mono<ExchangeRateResponse> calculates(ExchangeRateRequest request);
}
