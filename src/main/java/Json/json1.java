package Json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ken
 * @date 2018-11-24  10:48
 * @description
 */
public class json1 {
    @Test
    public void test()
    {
        Student studnet= new Student("sun","1");
        Student studnet2= new Student("小明","2");
        Student studnet3= new Student("小刚","3");
        Student studnet4=  new Student("小红","4");
        //转化对象成jsonstr
        String string = JSON.toJSONString(studnet);
        System.out.println(string);
        //把集合转换成jsonstr
        List<Student> list=new ArrayList<Student>();
        list.add(studnet);
        list.add(studnet2);
        list.add(studnet3);
        list.add(studnet4);
        String string2=JSON.toJSONString(list);
        System.out.println(string2);

        //从jsonstr 到集合对象
        List<Student> students = JSONArray.parseArray(string2, Student.class);
        System.out.println(students);

        //转换普通json字符串成josnarray，在遍历jsonarray
        JSONArray parse = (JSONArray) JSON.parse(string2);
        for(int i=0;i<parse.size();i++)
        {
            JSONObject jb= (JSONObject) parse.get(i);
            System.out.println(jb.getString("id")+jb.getString("name"));
        }

    }
}
