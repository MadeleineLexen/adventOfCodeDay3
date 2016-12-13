package day3;

/**
 * Created by madeleine on 2016-12-13.
 */
public class Main {
    public static  void main(String[] args) {

        Decoder santa = new Decoder();
        String[] input = santa.readFile("Puzzle.txt");

        int amountOfValid = 0;


        for(int i = 0 ; i < input.length ; i++){
            Triangle triangle = new Triangle(input[i]);
            if(triangle.isValid()){
                amountOfValid++;
            }
        }


        System.out.println("" + amountOfValid);
    }
    }

