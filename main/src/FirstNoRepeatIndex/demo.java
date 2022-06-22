package FirstNoRepeatIndex;

/**
 * @ClassName demo
 * @Description TODO
 * @Author Zhang Peixin
 * @Date 2021/10/22 10:44
 * @Version 1.0
 */
/*
找到第一个不重复的字符下标
 */
public class demo {
    public static void main(String[] args) {
        String str = "goobdffbbbbgle";
        System.out.println(FirstNotRepeatingChar(str));

    }

    public static int FirstNotRepeatingChar(String str) {

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            int i1 = str.indexOf(c);
            int i2 = str.lastIndexOf(c);
            if (i1 != i2)
                continue;
            else
                return i;
        }
        return -1;
    }
}

