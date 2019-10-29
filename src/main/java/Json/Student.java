package Json;

import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author ken
 * @date 2018-11-24  10:54
 * @description
 */
@EqualsAndHashCode
@ToString
public class Student {
        private String name;
        private String id;

    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public Student(String name, String id) {
        this.name = name;
        this.id = id;
    }
    public void setId(String id) {
        this.id = id;
    }

}
