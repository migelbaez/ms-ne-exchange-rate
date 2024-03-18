package pe.com.fintech.expose;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.com.fintech.business.IJwtService;

import java.util.Map;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

  private final IJwtService jwtService;

  @PostMapping(path = "/token", consumes = APPLICATION_JSON_VALUE)
  public String getToken(@RequestBody Map<String, Object> claims) {
    return jwtService.generateJWT(claims);
  }

}