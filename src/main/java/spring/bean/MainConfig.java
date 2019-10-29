package spring.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @author ken
 * @date 2019/3/20  19:51
 * @description
 */
@Configuration
@ComponentScan(value = "spring" )
public class MainConfig {

    @Bean
    @Scope(value = "prototype")
    public Student student()
    {
        return  new Student("sun","man",22);
    }

}
