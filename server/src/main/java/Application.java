import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by rpbrehm on 11/28/15.
 */
@SpringBootApplication
@ComponentScan("com.mycompany")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
