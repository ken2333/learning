package ChainofResponsibility;


/*
* 请求内容,这里的jsonDate是表示请求体的具体参数，是json格式
* */
public abstract class Request {

    protected String jsonDate;


    public Request() {
    }

    public Request(String jsonDate) {

        this.jsonDate = jsonDate;
    }


    public String getJsonDate() {
        return jsonDate;
    }

    public void setJsonDate(String jsonDate) {
        this.jsonDate = jsonDate;
    }
}
