package com.example.demo.factory.factoryImpl;

import com.example.demo.factory.Bank;

public class VietcomBank implements Bank {
    @Override
    public String getBankName() {
        return "VietcomBank";
    }
}
