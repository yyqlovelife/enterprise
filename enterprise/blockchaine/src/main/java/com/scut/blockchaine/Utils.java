package com.scut.blockchaine;

import org.fisco.bcos.web3j.abi.datatypes.Int;

import java.util.Random;

public class Utils {
    public static int geneId() {
        Random random = new Random(System.currentTimeMillis());
        int temp1 = (random.nextInt(8000) + 1000);
        Random random1 = new Random(System.currentTimeMillis());
        int temp2 = (random.nextInt(8000) + 1000);
        String res = String.valueOf(temp1) + String.valueOf(temp2);
        return Integer.valueOf(res);
    }
}
