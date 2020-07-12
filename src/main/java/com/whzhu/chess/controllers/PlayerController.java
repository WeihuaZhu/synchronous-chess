package com.whzhu.chess.controllers;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import com.whzhu.chess.models.Player;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlayerController {
  private final AtomicLong idAllocator = new AtomicLong();
  private static Map<Long, Player> playerMemoryStorage = new HashMap<Long, Player>();


  @PostMapping("/player/create")
  public Player createPlayer(@RequestParam(value = "userName") String userName) {
    Player player = new Player(idAllocator.incrementAndGet(), userName);
    playerMemoryStorage.put(player.getId(), player);
    return player;
  }

  @GetMapping("/player/")
  public Player getPlayerById(@RequestParam(value = "id") Long id) {
    return playerMemoryStorage.get(id);
  }

}
