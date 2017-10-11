package com.company.activemq.reciever.app;

import com.company.activemq.model.BlackBox;

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
        BlackBox obj1 = new BlackBox(5,10);
        BlackBox obj2 = new BlackBox(5,10);

        System.out.println(obj1.equals(obj2));
        System.out.println(obj1.hashCode() == obj2.hashCode());
    }
}
