import java.util.HashMap;
import java.util.Map;

public class Snake {
    private Map<Integer, Integer> map;

    Snake(){
        map = new HashMap<>();
    }

    public Map<Integer,Integer> getMap() {
        return this.map;
    }

    public void setMap(Map<Integer,Integer> map) {
        this.map = map;
    }

}
