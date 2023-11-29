package com.example.vinofind;

        import com.example.vinofind.service.OverpassQuery;
        import org.springframework.boot.SpringApplication;
        import org.springframework.boot.autoconfigure.SpringBootApplication;
        import org.springframework.context.ConfigurableApplicationContext;

        import java.io.IOException;

@SpringBootApplication
public class VinoFindApplication {

    public static void main(String[] args) {

        //SpringApplication.run(VinoFindApplication.class, args);


        try (ConfigurableApplicationContext context = SpringApplication.run(VinoFindApplication.class, args)) {
            OverpassQuery overpassQuery = context.getBean(OverpassQuery.class);
            overpassQuery.execute();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
