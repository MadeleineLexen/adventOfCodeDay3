package day3;

import java.util.Scanner;

/**
 * Created by madeleine on 2016-12-13.
 */
public class Triangle {
    private int sideA;
    private int sideB;
    private int sideC;

    public Triangle(String input){
        Scanner sc = new Scanner(input);
        this.sideA = sc.nextInt();
        this.sideB = sc.nextInt();
        this.sideC = sc.nextInt();
    }

    public boolean isValid(){
        return sideA + sideB > sideC && sideA + sideC > sideB && sideC + sideB > sideA;
    }
}
