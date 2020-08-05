package protobuf;

import com.google.protobuf.Descriptors;
import com.google.protobuf.InvalidProtocolBufferException;
import com.googlecode.protobuf.format.JsonFormat;
import org.apache.commons.codec.Charsets;

/**
 * describe:
 *
 * @author syh
 * @date 2020/07/28
 */
public class TestExplan {

    public static void main(String[] args) {
        AddressBookProtos.Person person = AddressBookProtos.Person.newBuilder()
                //设置id
                .setId(1111)
                //设置email
           //     .setEmail("1176479634@qq.com")
                .setName("小赵")
                //添加PhoneType
                .addPhone(AddressBookProtos.Person.PhoneNumber.newBuilder().setNumber("13138133198").setType(AddressBookProtos.Person.PhoneType.HOME).build())
                .build();
        System.out.println("是否都被序列化"+person.isInitialized());
        JsonFormat jsonFormat = new JsonFormat();
        System.out.println(jsonFormat.printToString(person));
        byte[] bytes = person.toByteArray();
        try {
            //反序列化
            AddressBookProtos.Person person1 = AddressBookProtos.Person.parseFrom(bytes);
            System.out.println(person1.getName());
            System.out.println(new String(person1.toString().getBytes(), Charsets.UTF_8));

        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
        }

    }
}
