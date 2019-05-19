package ChainofResponsibility;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * @author ken
 * @date 2019/5/19  20:49
 * @description 处理者的实现
 */
public class Handler2 extends  Handler {
    public Handler2(String name) {
        super(name);
    }

    @Override
    public int handle(Request request) {
        String jsonDate = request.getJsonDate();
        JSONArray objects = JSON.parseArray(jsonDate);
        JSONObject jsonObject=new JSONObject();
        jsonObject.put(this.name+"意见","22222");
        objects.add( jsonObject);
        request.setJsonDate(objects.toJSONString());
        System.out.println("handl2:"+objects.toJSONString());
        if(this.nextHandle!=null)
        {
            this.nextHandle.handle(request);
        }
        return Handler.SUCESS;
    }
}
