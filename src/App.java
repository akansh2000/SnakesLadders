import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        Player player1 = new Player("Akansh", 0, true);
        Player player2 = new Player("Sahaj", 0, false);
        Player player3 = new Player("Chirag", 0, false);

        Game game = new Game();
        game.getPlayers().add(player1);
        game.getPlayers().add(player2);
        game.getPlayers().add(player3);

        Snake snake = new Snake();
        Map<Integer, Integer> snakesMap = snake.getMap();
        snakesMap.put(25, 10);
        snakesMap.put(40, 20);
        snakesMap.put(65, 5);
        snakesMap.put(85, 40);
        snakesMap.put(95, 70);

        game.setSnakes(snake);

        Ladder ladder = new Ladder();
        Map<Integer, Integer> laddersMap = ladder.getMap();
        laddersMap.put(6, 25);
        laddersMap.put(40, 65);
        laddersMap.put(80, 98);

        game.setLadders(ladder);
        game.chance();
    }
}
