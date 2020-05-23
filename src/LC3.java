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
        char[] chars = s.toCharArray();
        int left = 0;
        int right = 0;
        int length = 0;
        int count;

        while(right < chars.length){
            //窗口扩大
            char c = chars[right];
            right++;
            count = window.getOrDefault(c, 0);
            window.put(c, count + 1);

            while(window.get(c) > 1){
                //结束条件
                length = Math.max(right - left - 1, length);
                //窗口缩小
                window.put(chars[left], window.get(chars[left])-1);
                left++;
            }
        }
        return Math.max(right - left, length);
    }

}
