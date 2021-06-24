package com.example;

import com.example.config.EnvironmentConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
public class Application {

    @Value("${MYENVVAR:NoValue}")
    private static String myEnvVar;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

        // You'll get a NULLPOINTEREXCEPTION if you try to make this a static variable in this class
        EnvironmentConfig environmentConfig = new EnvironmentConfig();

        // This is the system level PATH environment variable
        System.out.println("This is the value of PATH using getEnv(): " + System.getenv("PATH"));

        // Can't pull environment variables in the main method, they return null
        System.out.println("This is the value of PATH from the app.props file: " + environmentConfig.getMyPath());

        // This is the environment variable created in IntelliJ > "Edit Configurations"
        System.out.println("This is the value of MYENVVAR using getEnv(): " + System.getenv("MYENVVAR"));

        // Can't pull environment variables in the main method, they return null
        // @Value and the @Configuration are returning NULL
        System.out.println("This is the value of MYENVVAR from the app.props file: " + environmentConfig.getMyEnvVariable());
        System.out.println("This is the value of MYENVVAR from the @Value local variable: " + myEnvVar);

    }

}
