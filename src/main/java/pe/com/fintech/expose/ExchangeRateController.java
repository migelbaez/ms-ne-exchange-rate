package pe.com.fintech.expose;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pe.com.fintech.business.IExchangeRateService;
import pe.com.fintech.expose.request.ExchangeRateRequest;
import pe.com.fintech.expose.response.ExchangeRateResponse;
import reactor.core.publisher.Mono;

import java.util.Map;

@RestController
@RequestMapping("/exchange")
@Slf4j
@RequiredArgsConstructor
public class ExchangeRateController {

  private final IExchangeRateService exchangeRateService;

  @GetMapping(value = "/calculates", produces = MediaType.APPLICATION_JSON_VALUE)
  @PreAuthorize("hasAuthority('SCOPE_GUEST')")
  public Mono<ResponseEntity<ExchangeRateResponse>> calculates(ExchangeRateRequest request){
    return  exchangeRateService.calculates(request).map(response
        -> new ResponseEntity<>(response, HttpStatus.OK));
  }
}
