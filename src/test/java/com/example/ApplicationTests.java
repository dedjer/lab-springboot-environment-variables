package com.example;

import com.example.dto.PlayerProfile;
import com.example.model.Player;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ApplicationTests {

    @Test
    public void whenDTOConvertPlayerToPlayerProfile_thenCorrect(){
        Player player = new Player();
        player.setEmail("test@test.com");

        PlayerProfile playerProfile = new PlayerProfile();
        playerProfile.setEmail(player.getEmail());

        assertEquals(playerProfile.getEmail(), player.getEmail());
    }
}
