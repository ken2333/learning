package builder;

/**
 * @author ken
 * @date 2019/5/14  20:25
 * @description
 */
public class PersonDiretor {

    PersonBuilder builder;

    public PersonDiretor(PersonBuilder builder) {
        this.builder = builder;
    }
    public  PersonBuilder  build()
    {
        builder.body();
        builder.hand();
        builder.head();
        builder.leg();
        return builder;
    }
}
