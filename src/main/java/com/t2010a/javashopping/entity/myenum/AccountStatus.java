package com.t2010a.javashopping.entity.myenum;

public enum AccountStatus {
    ACTIVE(1),DEACTIVE(0),DELETE(-1),UNDEFINE(2);

    private int value;
    AccountStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
    public static AccountStatus of(int value){
        for (AccountStatus accountStatus :
                AccountStatus.values()){
            if (accountStatus.getValue() == value){
                return accountStatus;
            }
        }
        return AccountStatus.UNDEFINE;
    }
}
