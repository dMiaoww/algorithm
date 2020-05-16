import hot100.LC64;
import hot100.Stack20;

import java.util.Stack;

/**
 * Created by W
 * Date: 2020-05-14 01:31
 * Description
 */
public class Run {
    public static void main(String[] args) {
        int[][] gird = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        LC64 solution = new LC64();
        solution.minPathSum(gird);

    }
}
