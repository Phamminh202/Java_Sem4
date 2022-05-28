package com.t2010a.javashopping.entity.myenum;

public enum ShoppingCartStatus {
    APPROVED(1),UNAPPROVED(0),UNDEFINE(-2);

    private int value;
    ShoppingCartStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
    public static ShoppingCartStatus of(int value){
        for (ShoppingCartStatus status :
                ShoppingCartStatus.values()){
            if (status.getValue() == value){
                return status;
            }
        }
        return UNDEFINE;
    }
}
