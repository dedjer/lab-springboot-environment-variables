package com.example.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

//---------------------------------------------------------------------------------
// This is one way of pulling properties from the application.properties file
// that has value from an environment variable.
//
// A @Configuration is also a @Component, but a @Component cannot act like a @Configuration
//---------------------------------------------------------------------------------
@Configuration
@ConfigurationProperties("env")
public class EnvironmentConfig {
    private String myPath;
    private String myEnvVariable;

    public String getMyPath() { return myPath; }

    public String getMyEnvVariable() {
        return myEnvVariable;
    }

    public void setMyPath(String myPath) { this.myPath = myPath; }

    public void setMyEnvVariable(String myEnvVariable) {
        this.myEnvVariable = myEnvVariable;
    }

}
