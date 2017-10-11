package com.company.activemq.reciever.app;

import com.company.activemq.model.BlackBox;

import java.util.ArrayList;
import java.util.List;

/**
 * Class {@code DemoBlackBox} demonstrate hashcode&equals.
 *
 * @author V.Mankivskiy
 * @see com.company.activemq.reciever.app.DemoBlackBox
 * @since 0.0.1
 * @date 11.09.2017
 */
public class DemoBlackBox {
    public static void main(String[] args) {
        List<Integer> integerList0 = new ArrayList<Integer>();
        integerList0.add(50);
        integerList0.add(90);
        integerList0.add(90);

        List<Integer> integerList1 = new ArrayList<Integer>();
        integerList1.add(50);
        integerList1.add(90);
        integerList1.add(90);
        BlackBox obj1 = new BlackBox(5,10,integerList0);
        BlackBox obj2 = new BlackBox(5,10,integerList1);

        System.out.println(obj1.equals(obj2));
        System.out.println(obj1.hashCode() == obj2.hashCode());
    }
}
