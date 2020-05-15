package hot100;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by W
 * Date: 2020-05-15 23:12
 * Description
 */
public class Stack20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');

        for (char c : s.toCharArray()) {
            //左括号
            if (map.containsKey(c)) {
                stack.push(c);
            } else {
                //右括号
                if (stack.empty() || c != map.get(stack.peek())) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }

        return stack.empty();
    }

}
