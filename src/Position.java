import javafx.geometry.Pos;

import java.util.Objects;

public class Position implements Cloneable{

    public int x;
    public int y;

    public Position(String pos) {
        x = Integer.parseInt(pos.split(":")[0]);
        y = Integer.parseInt(pos.split(":")[1]);
    }

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    void moveBy(int x, int y){
        this.x += x;
        this.y += y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return x == position.x &&
                y == position.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "Позиция " +
                "x=" + x +
                ", y=" + y;
    }

    @Override
    protected Position clone() throws CloneNotSupportedException {
        return (Position) super.clone();
    }
}
