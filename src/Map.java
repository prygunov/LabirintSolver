import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Map {

    int width;
    int height;
    boolean[][] map;
    Position startPoint;
    Position endPoint;

    public Map(int width, int height, boolean[][] map, Position startPoint, Position endPoint) {
        this.width = width;
        this.height = height;
        this.map = map;
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    public static Map readInstance() throws IOException {
        FileReader fileReader = new FileReader("labyrinth.map");
        Scanner scanner = new Scanner(fileReader);
        String size = scanner.nextLine();
        int x = Integer.parseInt(size.split(":")[0]);
        int y = Integer.parseInt(size.split(":")[1]);
        String point = scanner.nextLine();
        Position start = new Position(point);
        point = scanner.nextLine();
        Position end = new Position(point);
        boolean[][] map = new boolean[y][x];
        for (int i = 0; i<y; i++){
            String line = scanner.nextLine().substring(0, x);
            for (int j = 0; j<x; j++)
                map[i][j] = line.charAt(j)!=' ';
        }
        return new Map(x, y, map, start, end);
    }

    public Position getStartPoint() {
        return startPoint;
    }

    public Position getEndPoint() {
        return endPoint;
    }

    public boolean isWall(int x, int y){
        if (x < getWidth() && x >= 0 && y < getHeight() && y >= 0)
            return map[y][x];
        else return true;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }


}
