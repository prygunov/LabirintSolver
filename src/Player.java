public class Player {

    enum Direction{Up, Right, Down, Left};

    Position position;
    Map map;
    Direction direction;

    public Player(Map map) throws CloneNotSupportedException {
        this.position = map.getStartPoint().clone();
        this.map = map;
        defineDirection();
    }

    private void defineDirection() {
        if (!map.isWall(position.x-1, position.y))
            direction = Direction.Left;
        else if (!map.isWall(position.x+1, position.y))
            direction = Direction.Right;
        else if (!map.isWall(position.x, position.y-1))
            direction = Direction.Up;
        else if (!map.isWall(position.x, position.y+1))
            direction = Direction.Down;
    }

    void showMap(){
        System.out.println("---------------------");
        System.out.println(position + " " + direction);
        for (int i = 0; i < map.getHeight(); i++) {
            for (int j = 0; j < map.getWidth(); j++) {
                if (position.y == i && position.x == j) {
                    switch (direction){
                        case Up:
                            System.out.print("↑");
                            break;
                        case Left:
                            System.out.print("←");
                            break;
                        case Right:
                            System.out.print("→");
                            break;
                        case Down:
                            System.out.print("↓");
                            break;
                    }
                }
                else if (map.getStartPoint().x == j && map.getStartPoint().y == i)
                    System.out.print("Н");
                else if (map.getEndPoint().x == j && map.getEndPoint().y == i)
                    System.out.print("К");
                else if (map.isWall(j,i))
                    System.out.print("■");
                else
                    System.out.print(" ");
            }
            System.out.println();
        }
    }

    void move(){
        if(isNextWall() && isRightWall()) {
            left();
            System.out.println("turn left");
        }else if(!isNextWall() && isRightWall()) {
            step();
            System.out.println("step");
        } else if (!isRightWall()){
            right();
            step();
            System.out.println("turn right, step");
        }
    }

    void left(){
        if (direction == Direction.Left)
            direction = Direction.Down;
        else if (direction == Direction.Right)
            direction = Direction.Up;
        else if (direction == Direction.Up)
            direction = Direction.Left;
        else
            direction = Direction.Right;
    }

    void right(){
        if (direction == Direction.Left)
            direction = Direction.Up;
        else if (direction == Direction.Right)
            direction = Direction.Down;
        else if (direction == Direction.Up)
            direction = Direction.Right;
        else
            direction = Direction.Left;
    }

    void step(){
        if (direction == Direction.Left)
            position.moveBy(-1, 0);
        else if (direction == Direction.Right)
            position.moveBy(1, 0);
        else if (direction == Direction.Up)
            position.moveBy(0, -1);
        else
            position.moveBy(0, 1);
    }


    boolean isNextWall(){
        if (direction == Direction.Left)
            return map.isWall(position.x-1, position.y);
        else if (direction == Direction.Right)
            return map.isWall(position.x+1, position.y);
        else if (direction == Direction.Up)
            return map.isWall(position.x, position.y-1);
        else
            return map.isWall(position.x, position.y+1);
    }

    boolean isRightWall(){
        if (direction == Direction.Left)
            return map.isWall(position.x, position.y-1);
        else if (direction == Direction.Right)
            return map.isWall(position.x, position.y+1);
        else if (direction == Direction.Up)
            return map.isWall(position.x+1, position.y);
        else
            return map.isWall(position.x-1, position.y);
    }

}
