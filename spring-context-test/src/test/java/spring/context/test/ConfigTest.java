package spring.context.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.context.test.library.CommonService;

class ConfigTest {

  @Test
  void testLibraryXML() {
    ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/lib-config.xml");
    CommonService commonService = context.getBean("commonService", CommonService.class);
    assertEquals("Message: Hello!", commonService.service());
  }

  @Test
  void testLibraryAnnotation() {
    ApplicationContext context =
        new AnnotationConfigApplicationContext("spring.context.test.library");
    CommonService commonService = context.getBean("commonService", CommonService.class);
    assertEquals("Message: Annotated Hello!", commonService.service());
  }

  @Test
  void testApplicationXML_FIXME() {
    ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/app-config.xml");
    CommonService commonService = context.getBean("service", CommonService.class);
    assertEquals("Overridden: Message: Hello!", commonService.service());
  }

  /**
   * This version is working but not sufficient, since commonService2 is used --> library will use
   * original commonService. Note different config file and bean id.
   */
  @Test
  void testApplicationXML_HACK() {
    ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/app-config2.xml");
    CommonService commonService = context.getBean("commonService2", CommonService.class);
    assertEquals("Overridden: Message: Hello!", commonService.service());
  }

  @Test
  void testApplicationAnnotation() {
    ApplicationContext context =
        new AnnotationConfigApplicationContext("spring.context.test.application");
    CommonService commonService = context.getBean("commonService", CommonService.class);
    assertEquals("Overridden: Message: Annotated Hello!", commonService.service());
  }

}
