/**
 * Created by W
 * Date: 2020-05-14 01:31
 * Description
 */
public class Run {
    public static void main(String[] args) {
        String s = "ADOBECOBAC";
        String t1 = "ABC";
        String t2 = "abc";
        String t3 = "AABC";

        MinimumWindowSubstring solution = new MinimumWindowSubstring();
        String r1 = solution.method(s,t1);
        String r2 = solution.method(s,t2);
        String r3 = solution.method(s,t3);

    }
}
