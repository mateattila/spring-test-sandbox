package spring.context.test.library;

public class CommonServiceImpl implements CommonService {

  private String message;

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  @Override
  public String service() {
    return "Message: " + getMessage();
  }

}
