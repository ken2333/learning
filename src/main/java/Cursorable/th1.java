package Cursorable;

import org.apache.commons.collections4.list.CursorableLinkedList;

/**
 * @author ken
 * @date 2018-11-27  10:44
 * @description
 */
public class th1 {

    public static void main(String[] args) {
        CursorableLinkedList<String> list=new CursorableLinkedList();
        for(String tem:args)
        {
            System.out.println(tem);
        }

    }
}
