import java.util.HashMap;
import java.util.Map;

/**
 * Created by W
 * Date: 2020-05-14 20:34
 * Description 找出字符串中不含有重复字符的最长子串的长度
 */
public class LC3 {
    public int method(String s) {
        Map<Character, Integer> window = new HashMap<>();
        int left = 0, right = 0;
        int length = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;

            //扩大窗口时对窗口数据进行更新
            window.put(c, window.getOrDefault(c, 0) + 1);

            //缩小窗口
            while ((right - left) > window.size()) {
                //更新结果
                length = Math.max(length,window.size());

                char d = s.charAt(left);
                left++;

                //更新窗口数据
                window.put(d, window.get(d) - 1);
                if (window.get(d) == 0) {
                    window.remove(d);
                }
            }
        }

        return length < window.size() ? window.size() : length;
    }
}
