package pe.com.fintech.utils;
public class ExchangeNotFoundException extends RuntimeException{
  public ExchangeNotFoundException(String message){
    super(message);
  }
}
