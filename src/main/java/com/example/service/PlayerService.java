package com.example.service;

import com.example.dto.PlayerProfile;
import com.example.model.Player;

import java.util.List;
import java.util.Optional;

public interface PlayerService
{
    public Player addPlayer(Player player);

    public List<Player> getPlayers();

    public void deletePlayer(int id);

    public Optional<Player> getPlayer(int id);

    public PlayerProfile getPlayerProfile(int id);
}

