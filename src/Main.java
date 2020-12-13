
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, CloneNotSupportedException {
        Map map = Map.readInstance();
        Player player = new Player(map);

        do {
            player.showMap();
            player.move();
        }while(!map.getEndPoint().equals(player.position)
                && !map.getStartPoint().equals(player.position));

        player.showMap();
    }
}
