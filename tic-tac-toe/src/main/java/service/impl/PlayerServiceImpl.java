package service.impl;

import models.Player;
import repository.PlayerRepository;
import service.PlayerService;

public class PlayerServiceImpl implements PlayerService {

  private final PlayerRepository playerRepository;

  public PlayerServiceImpl(PlayerRepository playerRepository) {
    this.playerRepository = playerRepository;
  }

  @Override
  public void addPlayer(Player player) {
    playerRepository.add(player);
  }
}
