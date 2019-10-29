package pro;

import lombok.Builder;
import lombok.Data;

/**
 * @author ken
 * @date 2018-11-25  20:22
 * @description
 */
@Data
@Builder
public class Student {

    private long id;

    private String name;

    private int age;


}
