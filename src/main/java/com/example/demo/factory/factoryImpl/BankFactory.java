package com.example.demo.factory.factoryImpl;

import com.example.demo.enumFactory.BankType;
import com.example.demo.factory.Bank;

public class BankFactory {

    public BankFactory() {
    }

    public static final Bank getBank(BankType bankType) {
        switch (bankType) {
            case TPBANK:
                return new TPBank();
            case VIETCOMBANK:
                return new VietcomBank();
            default:
                throw new IllegalArgumentException("This bank type is unsupported");
        }
    }


}
