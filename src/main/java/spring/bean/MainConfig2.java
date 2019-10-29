package spring.bean;

import org.springframework.context.annotation.*;

/**
 * @author ken
 * @date 2019/3/20  19:51
 * @description
 */
@PropertySource("classpath:property.properties")
@Configuration
public class MainConfig2 {


    @Bean
    public  Student student()

    {
        return  new Student();
    }


}
