import java.awt.Color;
import java.awt.geom.Rectangle2D;

public class Tile {
    
    Rectangle2D tile;
    Color color;

    Tile(Rectangle2D tile, Color color) {
        this.tile = tile;
        this.color = color;
    }

    public Rectangle2D getTile() {
        return this.tile;
    }

    public Color getColor() {
        return this.color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

}
