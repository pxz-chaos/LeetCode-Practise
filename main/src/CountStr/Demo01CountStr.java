package CountStr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

/**
 * @ClassName Demo01CountStr
 * @Description TODO
 * @Author Zhang Peixin
 * @Date 2021/10/20 9:03
 * @Version 1.0
 */
/*

 */
public class Demo01CountStr {
    public static void main(String[] args) {
        System.out.println(numberOf2sInRange(12));
    }

    public static int numberOf2sInRange(int n) {


        long pre=n,cur=n%10,post=0,bit=1;
        int count=0;
        while(pre>0){
            pre/=10;
            if(cur==2){
                count+=pre*bit+post+1;
            }
            else if(cur>2){
                count+=(pre+1)*bit;
            }
            else count+=pre*bit;
            post+=bit*cur;
            bit*=10;
            cur=pre%10;
        }
        return count;

    }
}
