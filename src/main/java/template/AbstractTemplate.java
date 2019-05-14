package template;

/**
 * @author ken
 * @date 2019/5/13  21:15
 * @description 模板模式主要用在一下重复代码比较多的地方，把一些固定的代码抽到模板类中，
 * 把需要子类实现的方法，抽象成抽象类，这样可以最大程度的减少重复的代码。
 */
public  abstract  class AbstractTemplate {



    public  abstract   String test1();
    public  abstract   String test2();
    public  abstract   String test3();

    public void resutl()
    {
        System.out.println("第一题答案："+test1());
        System.out.println("第二题答案"+test2());
        System.out.println("第三题答案"+test3());
    }


}
