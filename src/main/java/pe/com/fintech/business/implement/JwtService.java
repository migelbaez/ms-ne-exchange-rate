package pe.com.fintech.business.implement;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pe.com.fintech.business.IJwtService;
import pe.com.fintech.config.AppJwtProperties;

import java.time.Instant;
import java.util.Date;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class JwtService implements IJwtService {

  private final AppJwtProperties appJwtProperties;


  public String generateJWT(Map<String, Object> claims) {
    var key = appJwtProperties.getKey();
    var algorithm = appJwtProperties.getAlgorithm();

    var header = new JWSHeader(algorithm);
    var claimsSet = buildClaimsSet(claims);

    var jwt = new SignedJWT(header, claimsSet);

    try {
      var signer = new MACSigner(key);
      jwt.sign(signer);
    } catch (JOSEException e) {
      throw new RuntimeException("Unable to generate JWT", e);
    }

    return jwt.serialize();
  }

  private JWTClaimsSet buildClaimsSet(Map<String, Object> claims) {
    var issuer = appJwtProperties.getIssuer();
    var issuedAt = Instant.now();
    var expirationTime = issuedAt.plus(appJwtProperties.getExpiresIn());

    var builder = new JWTClaimsSet.Builder()
        .issuer(issuer)
        .issueTime(Date.from(issuedAt))
        .expirationTime(Date.from(expirationTime));

    claims.forEach(builder::claim);

    return builder.build();
  }

}