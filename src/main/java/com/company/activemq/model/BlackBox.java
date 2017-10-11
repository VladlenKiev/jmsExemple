package com.company.activemq.model;

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


    public BlackBox(int varA, int varB){
        this.varA = varA;
        this.varB = varB;
    }

    @Override
    public boolean equals(Object object){
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        BlackBox blackBox = (BlackBox) object;

        if (varA !=blackBox.varA) return false;
        if (varB !=blackBox.varB) return false;
        return true;
    }



    @Override
    public int hashCode(){
        int result = varA;
        result = 31*result + varB;
        return result;
    }

}
