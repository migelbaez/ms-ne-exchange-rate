package pe.com.fintech.business;

import java.util.Map;

public interface IJwtService {

  String generateJWT(Map<String, Object> claims);
}
