import hot100.Stack20;

import java.util.Stack;

/**
 * Created by W
 * Date: 2020-05-14 01:31
 * Description
 */
public class Run {
    public static void main(String[] args) {
        String s = "(((((";
        String t1 = "{{{{";
        String t2 = "[[[[";
        String t3 = "({[]})";
        String t4 = "]})";

        Stack20 stack20 = new Stack20();
        boolean x1 = stack20.isValid(s);
        boolean x2 = stack20.isValid(t1);
        boolean x3 = stack20.isValid(t2);
        boolean x4 = stack20.isValid(t3);
        boolean x5 = stack20.isValid(t4);

    }
}
