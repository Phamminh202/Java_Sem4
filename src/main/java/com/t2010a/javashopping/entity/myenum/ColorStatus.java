package com.t2010a.javashopping.entity.myenum;

public enum ColorStatus {
    ACTIVE(1),DEACTIVE(0),DELETE(-1) ,UNDEFINE(-2);

    private int value;
    ColorStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static ColorStatus of(int value){
        for (ColorStatus status :
                ColorStatus.values()){
            if (status.getValue() == value){
                return status;
            }
        }
        return UNDEFINE;
    }
}
