package learn.mastery;

import learn.mastery.data.DataException;
import learn.mastery.ui.Controller;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
@ComponentScan
@PropertySource("classpath:data.properties")
public class App {
    public static void main(String[] args) throws DataException {
        configureWithAnnotationsAndRun();
    }
    private static void configureWithAnnotationsAndRun() throws DataException {
        ApplicationContext container = new AnnotationConfigApplicationContext(App.class);
        Controller controller = container.getBean(Controller.class);
        controller.run();
    }

    private static void configureWithXMLAndRun() {
        ApplicationContext container = new ClassPathXmlApplicationContext("dependency-configuration.xml");
        Controller controller = container.getBean(Controller.class);
//        controller.run();
    }
}
