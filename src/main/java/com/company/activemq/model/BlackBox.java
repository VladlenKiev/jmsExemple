package com.company.activemq.model;

import java.util.Iterator;
import java.util.List;

/**
 * Class {@code BlackBox} is example for hashcode&equels.
 *
 * @author V.Mankivskiy
 * @see com.company.activemq.model.BlackBox
 * @since 0.0.2
 * @date 11.09.2017
 */
public class BlackBox {
    private int varA;
    private int varB;
    private List<Integer> integerList;


    public BlackBox(int varA, int varB, List<Integer> integerList){
        this.varA = varA;
        this.varB = varB;
        this.integerList = integerList;
    }

    @Override
    public boolean equals(Object object){
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        BlackBox blackBox = (BlackBox) object;

        if (varA !=blackBox.varA) return false;
        if (varB !=blackBox.varB) return false;
        if (integerList !=blackBox.integerList) return false;
        return true;
    }



    @Override
    public int hashCode(){
        int result = varA;
        Iterator i = integerList.iterator();
        while (i.hasNext()) {
            Object object = i.next();
            result = 31 * result + varB + (object == null ? 0: object.hashCode());
            System.out.println("result="+result);
        }
        return result;
    }

}
