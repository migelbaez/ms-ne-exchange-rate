package pe.com.fintech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.com.fintech.model.ExchangeModel;

import java.util.Optional;


@Repository
public interface IExchangeRepository extends JpaRepository<ExchangeModel, Long> {
 Optional<ExchangeModel> findBySourceCurrencyAndTargetCurrency(String sourceCurrency, String targetCurrency);
}
