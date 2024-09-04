import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Game {
    private Snake snakes;
    private Ladder ladders;
    private List<Player> players;

    Game(){
        snakes = new Snake();
        ladders = new Ladder();
        players = new ArrayList<>();
    }

    public Snake getSnakes() {
        return this.snakes;
    }

    public void setSnakes(Snake snakes) {
        this.snakes = snakes;
    }

    public Ladder getLadders() {
        return this.ladders;
    }

    public void setLadders(Ladder ladders) {
        this.ladders = ladders;
    }    

    public List<Player> getPlayers() {
        return this.players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public void chance() throws Exception{
        Random random = new Random();
        do{
            int number = 1 + random.nextInt(6);
            Player activePlayer = null;
            for(int i=0; i<players.size(); i++){
                if(players.get(i).getChance()){
                    System.out.println(players.get(i).getName()+"'s chance");
                    activePlayer = players.get(i);
                    players.get(i).setChance(false);
                    players.get((i+1)%players.size()).setChance(true);
                    break;
                }
            }
            System.out.println(number);
            delay();
            boolean validMove = validateMove(activePlayer, number);
            if(validMove){
                System.out.println("Valid Move!");
                int finalPos = activePlayer.getPosition() + number;
                // Check for ladder
                // Check for snake
                // Else set finalPos as player's position
                if(snakes.getMap().get(finalPos) != null){
                    System.out.println("Oops! Snake caught you.");
                    finalPos = snakes.getMap().get(finalPos);
                }else if(ladders.getMap().get(finalPos) != null){
                    System.out.println("Great! Ladder found");
                    finalPos = ladders.getMap().get(finalPos);
                }
                if(finalPos == 100){
                    System.out.println(activePlayer.getName()+" won the game.");
                    activePlayer.setPosition(100);
                }else{
                    activePlayer.setPosition(finalPos);
                    System.out.println(activePlayer.getName()+" is on "+activePlayer.getPosition()+" position.");
                }
            }
        }while(players.stream().noneMatch(val -> val.getPosition() == 100));
    }

    private boolean validateMove(Player activePlayer, int number){
        int initialPos = activePlayer.getPosition();
        if(initialPos + number > 100) 
            return false;
        return true;
    }

    private void delay() throws Exception{
        try{
            Thread.sleep(2000);
        }catch(Exception e){
            throw new Exception("Error in delay");
        }
    }

}
