package spring.context.test.application;

import org.springframework.context.annotation.Configuration;
import spring.context.test.library.CommonConfiguration;
import spring.context.test.library.CommonService;
import spring.context.test.library.CommonServiceImpl;

@Configuration
public class OverriddenConfiguration extends CommonConfiguration {

  @Override
  public CommonService service1() {
    CommonServiceImpl superService1 = (CommonServiceImpl) super.service1();
    OverriddenServiceImpl service1 = new OverriddenServiceImpl();
    service1.setMessage(superService1.getMessage());
    return service1;
  }

}
