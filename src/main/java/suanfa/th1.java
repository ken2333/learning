package suanfa;

import org.junit.Test;

import java.util.HashSet;
import java.util.LinkedList;

/**
 * @author ken
 * @date 2019-4-8  10:36
 * @description
 */
public class th1 {

    @Test
    public void test() {

        for (int i = 0; i < 10; i++) {
            for (int k = 0; k < 10; k++) {
                for (int j = 0; j < 10; j++) {
                    double tem = i * 100 + k * 10 + j;
                    double count = Math.pow(k, 3) + Math.pow(i, 3) + Math.pow(j, 3);
                    if (tem == count) {
                        System.out.println(i * 100 + k * 10 + j);
                    }
                }
            }
        }

    }

    @Test
    public void test2() {
        String s = revStr("abc孙也好123456");
        System.out.println(s);
    }

    public String revStr(String str) {

        StringBuffer buffer = new StringBuffer();

        for (int i = str.length() - 1; i >= 0; i--) {
            buffer.append(str.charAt(i));
        }
        return buffer.toString();
    }


 /*给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次
 。找出那个只出现了一次的元素。*/
    @Test
    public void test3() {
        HashSet<Integer> set=new HashSet<>();
        HashSet<Integer> set1=new HashSet<>();
        int [] i ={1,3,3,4,4,5,5,6,6,2,9};

        for(int k=0;k<i.length;k++)
        {
            boolean add = set.add(i[k]);
            if(!add)
            {
                set1.add(i[k]);
            }
        }
        System.out.println(set);
        System.out.println(set1);
        set.removeAll(set1);
        System.out.println(set);
    }

    @Test
    public void test4()
    {
        int [] t=new int[]{2, 7, 11, 15};
        int[] arr = arr(t, 13);
        for (int i : arr) {
            System.out.println(i);
        }

    }

    public  int [ ] arr(int [] arr,int target)
    {
        for(int i=0;i<arr.length;i++)
        {
            for(int k=i+1;k<arr.length;k++)
            {
                if(target==(arr[i]+arr[k]))
                {
                    int [] tem={i,k};
                    return  tem;
                }
            }
        }
        return  null;
    }

    /*给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。

如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。

您可以假设除了数字 0 之外，这两个数都不会以 0 开头。*/

    @Test
    public void test5()
    {
        LinkedList<Integer> linkedList=new LinkedList<>();
        linkedList.add(1);
        linkedList.add(3);
        System.out.println(linkedList.poll());
        System.out.println(linkedList.poll());
        System.out.println(linkedList.peek());

    }

    public Integer add(LinkedList<Integer> list,LinkedList<Integer>list2) throws Exception {


        if(list.isEmpty()||list2.isEmpty())
        {
            throw  new Exception("不能为空!");
        }
        int flag=1;
        int result=0;
        boolean jinwei=false;
        while(list.peek()!=null||list2.peek()!=null)
        {
            Integer poll1 = list.poll();
            Integer poll2 = list2.poll();
            if(poll1==null)
                poll1=0;
            if(poll2==null)
                poll2=0;

            int tem= poll1+poll2;
            if(jinwei)
            {
                tem+=1;
                jinwei=false;
            }
           if(tem>=10)
           {
               tem-=10;
               jinwei=true;
           }
            result+=tem*flag;
            flag*=10;
        }
        return  result;
    }

    @Test
    public void test6() throws Exception {
        LinkedList<Integer> list1=new LinkedList<>();
        list1.add(1);
        list1.add(3);

        LinkedList<Integer> list2=new LinkedList<>();
        list2.add(5);
        list2.add(6);
        list2.add(4);
        list2.add(4);
        Integer add = add(list1, list2);
        System.out.println(add);
    }

        /*给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。*/
    public int  lengh(String s)
    {
        int result=0;
        if(s==null||s.trim()=="\"\"")
            return  1;
        for(int i=0;i<s.length();i++)
        {
            HashSet<String> set=new HashSet<>();
            for(int k=i;k<s.length();k++)
            {

                boolean add = set.add(s.substring(k, k+1));
                if(!add)
                {
                    int size=set.size();
                    if(size>result)
                        result =size;
                    break;
                }
            }
        }
        return result;
    }
    @Test
    public void test7()
    {
        int abcabcbb = lengh("");
        System.out.println(abcabcbb);
        String s="12331";

    }

    /*z子回*/
    @Test
    public void test8()
    {

    }

    public String zWords(String s,int i)
    {

        return null;
    }
}
