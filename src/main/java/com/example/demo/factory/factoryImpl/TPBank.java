package com.example.demo.factory.factoryImpl;

import com.example.demo.factory.Bank;

public class TPBank implements Bank {
    @Override
    public String getBankName() {
        return "TPBank";
    }
}
