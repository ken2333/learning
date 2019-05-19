package combination;

import java.util.Iterator;

/**
 * @author ken
 * @date 2019/5/19  0:17
 * @description
 */
public class test {
    public static void main(String[] args) {
        Company company=new Company("总公司");
        company.add(new Department("人事部"));
        company.add(new Department("中南事业部"));
        company.add(new Department("研发部"));

        Company company1 = new Company("分公司");
        company.add(company1);
        company1.add(new Department("人事部"));

        /*for (Root root : company.list) {
            root.show();
        }*/

        Iterator<Root> iterator = company.iterator();
        for (Root root : company) {
            root.show();
        }
    }
}
