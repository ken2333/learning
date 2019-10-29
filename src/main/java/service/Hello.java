package service;

import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ken
 * @date 2018-11-26  16:00
 * @description
 */
@WebService
public interface Hello {

    public String hello();

    public List<String> getList();


}
