package res15;

/**
 * @author ken
 * @date 2019-4-1  11:41
 * @description
 */
public class generaleLeader extends   Leader {
    @Override
    public void handle(Request request) {
        System.out.println(name+"处理请求："+request.getName());
    }

    @Override
    public void nextLeader(Leader leader) {
            this.leader=leader;
    }

    public generaleLeader(String name) {
              super(name);
    }
}
