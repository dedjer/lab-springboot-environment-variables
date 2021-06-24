package com.example.controller;

import com.example.config.EnvironmentConfig;
import com.example.dto.PlayerProfile;
import com.example.model.Player;
import com.example.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PlayerController {
    @Autowired
    PlayerService playerService;

    @Autowired
    private EnvironmentConfig environmentConfig;

    @Value("${MYENVVAR:NoValue}")
    private String myEnvVar;

    @GetMapping("/env")
    public void getEnvVariable() {
        // This is the system level PATH environment variable
        System.out.println("This is the value of PATH using getEnv(): " + System.getenv("PATH"));
        System.out.println("This is the value of PATH from app.props file: " + environmentConfig.getMyPath());

        // This is the environment variable created in IntelliJ > "Edit Configurations"
        System.out.println("This is the value of MYENVVAR using getEnv(): " + System.getenv("MYENVVAR"));

        // @Value and the @Configuration will return a environment variable value when used in the @Controller
        System.out.println("This is the value of MYENVVAR from the app.props file: " + environmentConfig.getMyEnvVariable());
        System.out.println("This is the value of MYENVVAR from the @Value local variable: " + myEnvVar);
    }

    @GetMapping("/players")
    public ResponseEntity<List<Player>> getAllPlayers() {
        try
        {
            List<Player> list = playerService.getPlayers();

            if (list.isEmpty() || list.size() == 0)
            {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(list, HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/players/profile/{id}")
    public ResponseEntity<PlayerProfile> getPlayerDTO(@PathVariable int id) {
        PlayerProfile playerProfile = playerService.getPlayerProfile(id);

        if (playerProfile != null)
        {
            return new ResponseEntity<PlayerProfile>(playerProfile, HttpStatus.OK);
        }

        return new ResponseEntity<PlayerProfile>(HttpStatus.NOT_FOUND);
    }

}
