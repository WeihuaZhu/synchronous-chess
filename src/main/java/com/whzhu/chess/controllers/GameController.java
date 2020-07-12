package com.whzhu.chess.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameController {

  @GetMapping("/game")
  public String index() {
    return "Play a new chess game!";
  }


}
