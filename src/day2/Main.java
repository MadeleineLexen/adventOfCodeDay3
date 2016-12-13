/**
 * Created by madeleine on 2016-12-09.
 */
public class Main {
    public static void main(String[] args) {

        Decoder santa = new Decoder();
        String[] instructions = santa.readFile("puzzle.txt");
        Keypad keypad = new Keypad(1, 1);
        int[] code = new int[5];

        for( int i = 0; i < code.length; i++){
            for(int j = 0; j < instructions[i].length(); j++){
                keypad.move(instructions[i].charAt(j));
                code[i] = keypad.getCodeAtCurrent();
            }
        }

        for(int i = 0; i < code.length; i++){
            System.out.print(code[i]);
        }

        System.out.println();

        NewKeypad keypad1 = new NewKeypad(0, 2);
        char[] nextCode = new char[5];

        for(int i = 0; i < code.length; i++){
            for ( int j = 0; j < instructions[i].length(); j++){
                keypad1.move(instructions[i].charAt(j));

            }
            nextCode[i] = keypad1.getCodeAtCurrent();
        }

        for( int i = 0; i < nextCode.length; i++){
            System.out.print( nextCode[i]);
        }
    }
}
