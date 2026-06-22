package com.gamingroom;

public class GameServiceTest {
    public static void main(String[] args) {
        GameService service = GameService.getInstance();
        service.addGame("Halo");
        service.addGame("Halo");
        service.addGame("DOOM");

        System.out.println("Total games: " + service.getGameCount());
        System.out.println("Get by name (Halo): " + service.getGame("Halo"));
        System.out.println("Get by ID (1): " + service.getGame(1));
        System.out.println("Get by ID (99): " + service.getGame(99));
    }
}


// Compare this snippet from src/com/gamingroom/GameService.java:
// Use this and the Game class to test your code.
// May not end up being used.