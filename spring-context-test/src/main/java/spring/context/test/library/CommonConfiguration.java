package spring.context.test.library;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommonConfiguration {

  @Bean("commonService")
  public CommonService service1() {
    CommonServiceImpl commonService1 = new CommonServiceImpl();
    commonService1.setMessage("Annotated Hello!");
    return commonService1;
  }
}
