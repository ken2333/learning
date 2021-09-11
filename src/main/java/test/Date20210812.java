package test;

public class Date20210812 {

      static  int  i=0;

    /**
     * 修饰符
     * @param args
     */
    public static void main(String[] args) {

        int  t1=111;
        int t2=t1&1;
        System.out.println(t2);
        System.out.println(true&&false);
        System.out.println(Math.round(11.5f));
        System.out.println(Math.round(-11.6f));
        System.out.println(8<<2);
        String [] s1=new String[]{"1","2"};
        String join = String.join(",","1","2");
        System.out.println(join);
        char c='汉';

    }

  class  Father{

        public  Father(String s)
        {

        }

  }

  class  Son extends  Father{

      public Son(String s) {
          super(s);
      }
  }
}
