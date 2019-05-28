package jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import org.junit.Test;

import javax.crypto.SecretKey;
import java.io.*;
import java.security.Key;

/**
 * @author ken
 * @date 2019/5/28  22:34
 * @description
 */
public class JwtUtils {

    public static  String keys="12ssssssssssssssssssadassssssssssssssssssssssssssssssssssssssssssssssssssssdasdasds3456";

    @Test
    public void test() throws IOException {
        //自动生成秘钥
        Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
        //输出保存秘钥
        OutputStream writer=new FileOutputStream("E:\\IdeaProject\\learning\\src\\main\\java\\test\\text.txt");
        byte[] encoded = key.getEncoded();
        writer.write(encoded,0, encoded.length);
        writer.close();

        InputStream in=new FileInputStream(new File("E:\\IdeaProject\\learning\\src\\main\\java\\test\\text.txt"));
        byte [] bytes=new byte[in.available()];
        in.read(bytes);

        SecretKey secretKey1=Keys.hmacShaKeyFor(bytes);


        String jws = Jwts.builder().setSubject("Joe").signWith(key).compact();

        System.out.println("subjet"+Jwts.parser().setSigningKey(secretKey1).parseClaimsJws(jws).getBody().getSubject());
        //  Jwts.parser().setSigningKey(key2).parseClaimsJws(jws2).getBody().getSubject().equals("Joe");

        SecretKey secretKey = Keys.hmacShaKeyFor(keys.getBytes());
        String json="{\"sites\":{\"site\":[{\"id\":\"1\",\"name\":\"菜鸟教程\",\"url\":\"www.runoob.com\"},{\"id\":\"2\",\"name\":\"菜鸟工具\",\"url\":\"c.runoob.com\"},{\"id\":\"3\",\"name\":\"Google\",\"url\":\"www.google.com\"}]}}";
        String payload = Jwts.builder().setPayload(json).signWith(secretKey).compact();

        Jwt subject = Jwts.parser().setSigningKey(secretKey).parse(payload);
        System.out.println(subject.getBody());
    }

    @Test
    public void test2()
    {
        //自动生成秘钥m
        Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
        //获取秘钥的字节码,可以通过存储这个字节数组来进行各种校验
        byte[] encoded = key.getEncoded();
        //通过秘钥来加密
        String jws = Jwts.builder().setSubject("Joe").signWith(key).compact();
        //解密成声明类型，然后获取指定的内容subjet
        String parse = Jwts.parser().setSigningKey(key).parseClaimsJws(jws).getBody().getSubject();
        System.out.println(parse);
    }

    @Test
    public void test3()
    {
        //设置私钥
        String key="aslkdjklasjdlasjdkljaskldjaslkdjlkasjdlkajslkdjklasdjlkasjlkdjklw";
        String json="{\"name\":\"sun\",\"age\":23,\"sex\":\"man\"}";
        SecretKey secretKey = Keys.hmacShaKeyFor(key.getBytes());
        //签名
        String compact = Jwts.builder().setPayload(json).signWith(secretKey).compact();
        System.out.println(compact);
        //解析
        boolean result=true;
        try {
            //在解析的时候故意传入错误的key，可以使用try catch的方法来捕捉SignatureException,来达到校验的目的
            Jwt parse = Jwts.parser().setSigningKey("aslkdjklasjdlasjdkljaskldjaslkdjlkasjdlkajslkdjklas1djlkasjlkdjklw".getBytes()).parse(compact);
            System.out.println(parse.getBody());
            System.out.println(parse.getHeader());
        }catch (SignatureException e)
        {
            System.out.println(e.toString());
            result=false;
        }
        System.out.println(result);


    }
}
