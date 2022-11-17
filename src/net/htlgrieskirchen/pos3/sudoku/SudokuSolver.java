package net.htlgrieskirchen.pos3.sudoku;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

/* Please enter here an answer to task four between the tags:
 * <answerTask4>
 *    Hier sollte die Antwort auf die Aufgabe 4 stehen.
 * </answerTask4>
 */
public class SudokuSolver implements ISodukoSolver {
    public SudokuSolver() {
        //initialize if necessary
    }

    @Override
    public final int[][] readSudoku(File file) throws IOException {
        int[][] readSudoko = new int[9][9];
        final int[] line = {0};

        Files.lines(Path.of(file.getPath())).forEach( s ->{
            for (int i = 0; i < s.split(";").length; i++) {
                System.out.println(s);
                readSudoko[line[0]][i] = Integer.parseInt(s.split(";")[i]);
            }
            line[0]++;
        } );
        return readSudoko;
    }

    @Override
    public boolean checkSudoku(int[][] rawSudoku) {
        for (int i = 0; i < rawSudoku.length; i++) {
            for (int j = 0; j < rawSudoku.length; j++) {
                if (rawSudoku[i][j] == 0) {
                    return false;
                }
            }
        }

        for (int i = 0; i < rawSudoku.length; i++) {
            HashSet<Integer> set = new HashSet();
            HashSet<Integer> set2 = new HashSet();
            for (int j = 0; j < rawSudoku.length; j++) {
                set.add(rawSudoku[i][j]);
                set2.add(rawSudoku[j][i]);
            }
            if (9 != set.size()) {
                return false;
            }
            if (9 != set2.size()) {
                return false;
            }
        }


     return true;
    }


    @Override
    public int[][] solveSudoku(int[][] rawSudoku) {
        // implement this method
        return new int[0][0]; // delete this line!
    }
    
    @Override
    public int[][] solveSudokuParallel(int[][] rawSudoku) {
        // implement this method
        return new int[0][0]; // delete this line!
    }

    // add helper methods here if necessary
}
