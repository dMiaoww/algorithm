import java.util.HashMap;
import java.util.Map;

/**
 * Created by W
 * Date: 2020-05-14 02:00
 * Description 给你一个 S 和一个 T，请问你 S 中是否存在一个子串，包含 T 中所有字符且不包含其他字符？
 */
public class PermutationInString {
    public boolean method(String s, String t) {
        Map<Character, Integer> need = new HashMap<>(), window = new HashMap<>();
        int left = 0, right = 0;
        int valid = 0; //记录窗口与目标中具有相同数量的字符个数

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
                if (window.get(c).equals(need.get(c))){
                    valid++;
                }
            }

            //缩小窗口
            while (right - left >= t.length()) {
                //更新结果
                if(valid == need.size()){
                    return true;
                }
                char d = s.charAt(left);//将要移出窗口的字符
                left++;
                //2、修改窗口内容和valid
                //与 1 处对称
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))){
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }

        return false;
    }
}
