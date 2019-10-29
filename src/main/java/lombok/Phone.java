package lombok;

import org.junit.Test;

/**
 * @author ken
 * @date 2018-11-25  21:18
 * @description
 */
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Phone {

    @NonNull
    private String  name;

    private  String brank;

    private double price;

    private  boolean isTrue;

    public static void main(String[] args) {
        Phone phone=new Phone();
        phone.setBrank("apple");
        phone.setName("iphonex");
        phone.setPrice(999);
        Phone phone2=new Phone();
        phone2.setBrank("apple");
        phone2.setName("iphonex");
        phone2.setPrice(999);
        System.out.println(phone.equals(phone2));
    }

}
