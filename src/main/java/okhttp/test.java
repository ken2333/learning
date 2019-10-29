package okhttp;

import okhttp3.*;
import org.junit.Test;

import java.io.*;

/**
 * @author ken
 * @date 2019-5-25  15:41
 * @description
 */
public class test {
    public static void main(String[] args) {
        String url = "http://www.bai2du.com";
        OkHttpClient httpClient = new OkHttpClient();
        Request build = new Request.Builder().url(url).get().build();
        Call call = httpClient.newCall(build);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

                System.out.println("123321");

                System.out.println("请求失败!");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                System.out.println("123321");
                String string = response.body().string();
                //FileOutputStream outputStream=new FileOutputStream(new File("F:\\supports\\apache-tomcat-8.0.24\\temp\\test.txt"));
                Writer writer=new FileWriter("F:\\tem\\tem.txt");
                writer.write(string);
                writer.flush();
                if(writer!=null)
                {
                    writer.close();
                }
            }
        });
    }

    @Test
    public void test2() {
        String url = "https://www.jianshu.com/p/da4a806e599b";
        OkHttpClient okHttpClient = new OkHttpClient();
        final Request request = new Request.Builder()
                .url(url)
                .build();
        final Call call = okHttpClient.newCall(request);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Response response = call.execute();
                    System.out.println(response.body().string());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }

    @Test
    public void test3() {

        MediaType mediaType = MediaType.parse("text/x-markdown; charset=utf-8");
        String requestBody = "I am Jdqm.";
        Request request = new Request.Builder()
                .url("https://www.baidu.com")
                .post(RequestBody.create(mediaType, requestBody))
                .build();
        OkHttpClient okHttpClient = new OkHttpClient();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                System.out.println("onFailure: " + e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                System.out.println((response.protocol() + " " + response.code() + " " + response.message()));
                Headers headers = response.headers();
                for (int i = 0; i < headers.size(); i++) {
                    System.out.println(headers.name(i) + ":" + headers.value(i));
                }
                System.out.println("onResponse: " + response.body().string());
            }
        });
    }

     public static   Request.Builder addHeaders() {
        Request.Builder builder = new Request.Builder()
                //addHeader，可添加多个请求头  header，唯一，会覆盖
                .addHeader("Connection", "keep-alive")
                .addHeader("platform", "2")
                .addHeader("appVersion", "3.2.0")
                .header("sid", "eyJhZGRDaGFubmVsIjoiYXBwIiwiYWRkUHJvZHVjdCI6InFia3BsdXMiLCJhZGRUaW1lIjoxNTAzOTk1NDQxOTEzLCJyb2xlIjoiUk9MRV9VU0VSIiwidXBkYXRlVGltZSI6MTUwMzk5NTQ0MTkxMywidXNlcklkIjoxNjQxMTQ3fQ==.b0e5fd6266ab475919ee810a82028c0ddce3f5a0e1faf5b5e423fb2aaf05ffbf");
        return builder;
    }
    @Test
    public void test4()
    {
        //1.创建OkHttpClient对象
        OkHttpClient okHttpClient = new OkHttpClient();
        //2.创建Request对象，设置一个url地址（百度地址）,设置请求方式。
        Request request = addHeaders().url("http://www.baidu.com").method("GET",null).build();
        //3.创建一个call对象,参数就是Request请求对象
        try {
            Response response = okHttpClient.newCall(request).execute();
            System.out.println(response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @Test
    public void test5()
    {
        //1.创建OkHttpClient对象
        OkHttpClient okHttpClient = new OkHttpClient();
        //2.创建Request对象，设置一个url地址（百度地址）,设置请求方式。
        Request request = new Request.Builder().url("htt").get().build();
        //3.创建一个call对象,参数就是Request请求对象
        Call call = okHttpClient.newCall(request);
        //4.请求加入调度，重写回调方法
        call.enqueue(new Callback() {
            //请求失败执行的方法
            @Override
            public void onFailure(Call call, IOException e) {
                System.out.println("qing");
            }
            //请求成功执行的方法
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                System.out.println(response.isSuccessful());

            }
        });

    }

}
