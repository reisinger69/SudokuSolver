package net.htlgrieskirchen.pos3.sudoku;


import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        SudokuSolver ss = new SudokuSolver();
        int[][] input = ss.readSudoku(new File("1_sudoku_level1.csv"));

        System.out.println(">--- ORIGINAL ---");
        soutArray(input);
        int[][] output = ss.solveSudoku(input);
        System.out.println(">--- SOLUTION ---");
        System.out.println(ss.checkSudoku(input));
        System.out.println(">----------------");
        System.out.println("SOLVED    = " + ss.checkSudoku(output));
        System.out.println(">----------------");
    }

    public static void soutArray(int[][] input) {
        Arrays.stream(input).forEach(s -> {Arrays.stream(s).forEach(s2 -> System.out.print(s2 + " | "));
            System.out.println();
        });
    }
}
