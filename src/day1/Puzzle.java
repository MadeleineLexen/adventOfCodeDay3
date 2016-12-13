import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.lang.String;

/**
 * Created by madeleine on 2016-12-02.
 */
public class Puzzle {
    private int x = 0;
    private int y = 0;
    private String[] path;
    private List<Position> coordinates = new ArrayList<>();
    private Position intersection;

    public Puzzle(String fileName) {
        coordinates.add(new Position(0, 0));
        this.path = readFile(fileName);
    }

    private String[] readFile(String fileName) {
        String fileContent = "";
        File file = new File(fileName);
        try {
            Scanner sc = new Scanner(file);

            while (sc.hasNextLine()) {
                String i = sc.nextLine();
                fileContent = fileContent + i;
            }
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        this.path = turnToArray(fileContent);
        //this.path = turnToArray("R5, L5, R5, R3");

        return path;
    }


    public String[] getPath() {
        return path;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public Position getIntersection() {
        return intersection;
    }

    private String[] turnToArray(String fileContent) {
        return fileContent.split(", ");
    }

    private boolean isInArray() {

        return coordinates.contains(new Position(this.x, this.y));
    }

    private void addToCoordinates(int steps, int changeX, int changeY) {
        int newX = this.x;
        int newY = this.y;
        while (steps > 0) {
            newX += changeX;
            newY += changeY;

            Position newPos = new Position(newX, newY);
            if(intersection == null && coordinates.contains(newPos)){
                intersection = newPos;
            }
            coordinates.add(newPos);
            steps--;
        }
    }

    // 0 = north, 1 = east, 2 = south, 3 = west

    public void position() {
        int currentDirection = 0;
        int steps;

        for (int i = 0; i < path.length; i++) {
            System.out.println("Current: x= " + this.x + " y= " + this.y);
            String nextMove = this.path[i];
            steps = Integer.parseInt(nextMove.substring(1));

            if (nextMove.substring(0, 1).equals("R")) {
                currentDirection = (currentDirection + 1) % 4;
            } else {
                currentDirection = (currentDirection + 3) % 4;
            }

            int changeX = 0;
            int changeY = 0;

            if (currentDirection == 0) {
                changeY = -1;
            } else if (currentDirection == 1) {
                changeX = 1;
            } else if (currentDirection == 2) {
                changeY = 1;
            } else if (currentDirection == 3) {
                changeX = -1;
            }
            addToCoordinates(steps, changeX, changeY);
            this.x = this.x + changeX * steps;
            this.y = this.y + changeY * steps;
        }
    }

    public static int distance(Position position) {
        return Math.abs(position.getX()) + Math.abs(position.getY());
    }




    private class Position {

        private final int x;
        private final int y;


        private Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        @Override
        public String toString() {
            return "Position{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Position position = (Position) o;

            if (x != position.x) return false;
            return y == position.y;

        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }
    }

}
