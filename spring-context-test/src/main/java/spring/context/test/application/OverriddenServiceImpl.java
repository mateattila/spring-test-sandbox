package spring.context.test.application;

import spring.context.test.library.CommonServiceImpl;

public class OverriddenServiceImpl extends CommonServiceImpl {

  @Override
  public String service() {
    return "Overridden: " + super.service();
  }
}
