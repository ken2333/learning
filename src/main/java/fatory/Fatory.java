package fatory;




/*
*
*   工厂模式和简单工厂模式的区别是，在简单工厂的判断已到客户端里。
*   什么意思呢？就是在简单工厂扩展的时候，除了要写扩展类，还需要修改简单
*   工厂的判断方法，这样违背了开放-封闭原则，开发了扩展，但是修改了工厂的代码。
*   而工厂模式，只需要在New工厂的时候换成其他类即可。不需要修改工程的代码。
*
* */

public interface Fatory<T> {


    public Calculate<T> getFatory(int a,int b);
}
