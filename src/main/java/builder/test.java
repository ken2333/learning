package builder;

/**
 * @author ken
 * @date 2019/5/14  20:27
 * @description
 */
public class test {
    public static void main(String[] args) {
        PersonBuilder builder=new FatPersonBuilder();
        PersonDiretor diretor=new PersonDiretor(builder);
        PersonBuilder build = diretor.build();


    }
}
