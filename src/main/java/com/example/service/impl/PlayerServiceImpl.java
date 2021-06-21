package com.example.service.impl;

import com.example.dto.PlayerProfile;
import com.example.model.Player;
import com.example.repository.PlayerRepository;
import com.example.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerServiceImpl implements PlayerService
{
    @Autowired
    private PlayerRepository playerRepository;

    @Override
    public Player addPlayer(Player player)
    {
        return playerRepository.save(player);
    }

    @Override
    public List<Player> getPlayers()
    {
        return playerRepository.findAll();
    }

    @Override
    public Optional<Player> getPlayer(int id)
    {
        return playerRepository.findById(id);
    }

    @Override
    public void deletePlayer(int id)
    {
        if (this.getPlayer(id).isPresent())
        {
            playerRepository.delete((Player) this.getPlayer(id).get());
        }
    }

    @Override
    public PlayerProfile getPlayerProfile(int id)
    {
        PlayerProfile playerProfile = new PlayerProfile();

        playerProfile.setEmail(playerRepository.findById(id).get().getEmail());

        return playerProfile;
    }
}

