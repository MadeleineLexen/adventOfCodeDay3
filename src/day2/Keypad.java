/**
 * Created by madeleine on 2016-12-09.
 */
public class Keypad {

    private final int[][] keypad = {
            {1,2,3},
            {4,5,6},
            {7,8,9}};

    private int posx;
    private int posy;

    public Keypad(int posx, int posy) {
        this.posx = posx;
        this.posy = posy;
    }

    public void move(char p){
        if(p == 'L' && this.posx != 0){
            this.posx -= 1;
        }
        else if(p == 'U' && this.posy != 0){
            this.posy -= 1;
        }
        else if(p == 'R' && this.posx != 2){
            this.posx += 1;
        }
        else if(p == 'D' && this.posy != 2){
            this.posy += 1;
        }
    }

    public int getCodeAtCurrent(){
        return keypad[this.posy][this.posx];
    }

}
