package spring;

import org.ansj.domain.Result;
import org.ansj.domain.Term;
import org.ansj.splitWord.analysis.ToAnalysis;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

/**
 * @author ken
 * @date 2019/4/17  23:09
 * @description
 */
public class test1 {

    public static void main(String[] args) {
        ApplicationContext context=new AnnotationConfigApplicationContext();
        context.getBean("123");

    }
   @Test
   public void test()
   {
       Result result = ToAnalysis.parse("我是一个帅哥");
       List<Term> terms = result.getTerms();
       for (Term term : terms) {
           System.out.println(term);
       }
       System.out.println(result);
   }
}
