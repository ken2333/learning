package client;

import fe.dao.Dao;
import fe.dao.DataTable;
import fe.dao.FieldSet;
import fe.dao.WebFieldSet;
import fe.document.pof.util.DateUtils;
import fe.service.BasicService;
import fe.util.DateUtil;
import fe.util.LogUtils;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static com.ibm.icu.lang.UCharacter.JoiningGroup.FE;

/**
 * @author ken
 * @date 2019-4-18  14:40
 * @description 定时更新节假日的数据
 */
public class VacationService {
     public  Dao dao;


    public Dao getDao() {
        return dao;
    }

    public void setDao(Dao dao) {
        this.dao = dao;
    }
    //api
    private static String apiUrl="http://timor.tech/api/holiday/year/";

    private  static  String tableName="VACATIONS";
    /*获取节假日json数据,date参数格式是:yyyy-mm*/
    public String getVacations(String date) throws IOException {
        InputStreamReader content=null;
        StringBuffer result=new StringBuffer();
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet get=new HttpGet(apiUrl+date);
        try {
            CloseableHttpResponse execute = client.execute(get);
            int count=0;
            char [] chars=new char[1024];
            if (execute.getStatusLine().getStatusCode()==200) {
                  content = new InputStreamReader(execute.getEntity().getContent());
                  while((count=content.read(chars))!=-1)
                  {
                      result.append(chars,0,count);
                  }
            }
            else
            {
                LogUtils.error(DateUtil.getCurDateTime()+
                        "，节假日接口返回的状态码不正确!statusCode="+execute.getStatusLine().getStatusCode());
            }

        } catch (IOException e) {
            e.printStackTrace();
            LogUtils.error(DateUtil.getCurDateTime()+"，节假日接口发生错误.");
        }
        finally {
           client.close();
        }

        return   result.toString();
    }
    /*解析数据更新到服务器上面*/
    public static void  update(String date,int year) throws IOException {

        //调用接口获取数据
        String vacations = getVacations(date);
        //解析并且存储数据
        JSONObject jsonObject=JSONObject.fromObject(vacations);
        int  code=   jsonObject.getInt("code");
        if(code==0) //0表示状态正常,1表示服务器异常
        {
            JSONObject holidays=jsonObject.getJSONObject("holiday");
            Iterator keys = holidays.keys();
            while(keys.hasNext())
            {
                String key= (String) keys.next();
                JSONObject tem = holidays.getJSONObject(key);
                boolean holiday = tem.getBoolean("holiday");
                String name = tem.getString("name");
                String datetime = year+"-"+key;
                FieldSet vacation = dao.getFieldSetByFilter(tableName, "  VA01=?  ", new Object[]{datetime});
                if(vacation==null)
                {
                    vacation=new WebFieldSet(tableName);
                    vacation.setValue("VA01",datetime);
                }
                if(holiday)
                {
                    vacation.setValue("VA02","1");
                    vacation.setValue("VA03","true");
                }
                else
                {
                    vacation.setValue("VA02","2");
                    vacation.setValue("VA03","false");
                }
                //更新时间
                vacation.setValue("VA04",DateUtil.getCurDateTime());
                vacation.setValue("VA05",name);
                dao.saveFieldSet(vacation);
            }
        }
    }

    //定时执行的函数,会更新本月和下个月的数据
    public void execute() throws IOException {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM");
        Calendar calendar=Calendar.getInstance();
        String date = simpleDateFormat.format(calendar.getTime());
        update(date,calendar.get(Calendar.YEAR));

        //下个月的数据
        calendar.add(Calendar.MONTH,1);
        date = simpleDateFormat.format(calendar.getTime());
        update(date,calendar.get(Calendar.YEAR));
    }



}
