package lombok;

/**
 * @author ken
 * @date 2018-11-26  9:25
 * @description
 */
@Builder
public class Entity {

    private String  s1;
    private String  s2;
    private boolean isture;
    private int intcount;

    public static void main(String[] args) {
        EntityBuilder builder = Entity.builder().s1("sun").s2("23").isture(false).intcount(12);
        System.out.println(builder.s2);
        System.out.println(builder.toString());
    }
}
