import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by W
 * Date: 2020-05-13 22:28
 * Description 要在 S(source) 中找到包含 T(target) 中全部字母的一个子串，且这个子串一定是所有可能子串中最短的。
 */
public class MinimumWindowSubstring {
    public String method(String s, String t) {
        Map<Character, Integer> need = new HashMap<>(), window = new HashMap<>();
        int valid = 0;
        int left = 0, right = 0;
        int start = 0, len = Integer.MAX_VALUE;

        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        while (right < s.length()) {
            //扩大窗口
            char c = s.charAt(right);//将要移入窗口的字符
            right++;
            //1、修改窗口内容和valid
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }

            //缩小窗口
            while (valid == need.size()) {
                //更新最小覆盖子串
                if ((right - left) < len) {
                    len = right - left;
                    start = left;
                }
                char d = s.charAt(left);//将要移出窗口的字符
                left++;
                //2、修改窗口内容和valid
                //与 1 处对称
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }

        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);//左闭右开
    }

}
