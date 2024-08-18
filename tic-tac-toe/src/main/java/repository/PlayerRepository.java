package repository;

import java.util.HashMap;
import java.util.Map;
import models.Player;

public class PlayerRepository {

  private Map<String, Player> players = new HashMap<>();

  public void add(Player player) {
    players.put(player.getId(), player);
  }

  public Player get(String id) {
    return players.get(id);
  }
}
