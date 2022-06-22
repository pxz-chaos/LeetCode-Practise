package ArraySort;

import java.util.*;

/**
 * @ClassName Demo01ArraySort
 * @Description TODO
 * @Author Zhang Peixin
 * @Date 2021/11/1 9:49
 * @Version 1.0
 */
/*

 */
public class Demo01ArraySort {
    public static void main(String[] args) {
        int [] arr={10,10,20,50,60,50,50,50,30};
        Map<Integer,Integer> map1 = new HashMap<>();
        map1.put(0, 11);
        map1.put(1, 22);
        Set<Integer> set1 = map1.keySet();
        boolean contains = set1.contains(1);
        System.out.println(contains);
        System.out.println(set1);

        int[] arrCopy = arr.clone(); // clone克隆，生成一个复本
        Map<Integer,Integer> map = new HashMap<>();
        Arrays.sort(arrCopy);
        int k =1;
        for (int i = 0; i < arr.length; i++) {
            Set<Integer> set = map.keySet();//将key保存至set集合中
            if(!set.contains(arrCopy[i])){ // keySet() -> [key,value]
                // 如果键值对不存在，put
        /*
        if(map.get(temp[i])==null){  //有这个判断之后，重复的数据就不会被放到哈希表中
*/
                map.put(arrCopy[i],k);
                k++;
            }
        }
        System.out.println(Arrays.toString(arrCopy));
        System.out.println(map);
        for(int i = 0; i< arrCopy.length; i++){
            arr[i] = map.get(arr[i]); // get(a[i]); key=a[i]时对应的value；
        }
        System.out.println(Arrays.toString(arr));
    }
}
