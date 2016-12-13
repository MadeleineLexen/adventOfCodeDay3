import java.util.ArrayList;
import java.util.List;

/**
 * Created by madeleine on 2016-12-12.
 */
public class NewKeypad {
    private final char[][] keypad = {
            {0, 0, '1', 0, 0},
            {0, '2', '3', '4', 0},
            {'5', '6', '7', '8', '9'},
            {0, 'A', 'B', 'C', 0},
            {0, 0, 'D', 0, 0}};

    private int posx;
    private int posy;

    public NewKeypad(int posx, int posy) {
        this.posx = posx;
        this.posy = posy;
    }

    public void move(char p) {
        int newX = this.posx;
        int newY = this.posy;

        if (p == 'L' && this.posx != 0) {
            newX -= 1;
        } else if (p == 'U' && this.posy != 0) {
            newY -= 1;
        } else if (p == 'R' && this.posx != 4) {
            newX += 1;
        } else if (p == 'D' && this.posy != 4) {
            newY += 1;
        }

        if(isAllowed(newX, newY)){
            this.posx = newX;
            this.posy = newY;
        }

    }

    public char getCodeAtCurrent() {
        return keypad[this.posy][this.posx];
    }

    private boolean isAllowed(int newX, int newY){
        if (keypad[newX][newY] == 0) {
            return false;
        }
        return true;
    }
}
