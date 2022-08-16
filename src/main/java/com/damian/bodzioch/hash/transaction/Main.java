package com.damian.bodzioch.hash.transaction;

import org.apache.commons.codec.digest.DigestUtils;

public class Main {
    public static void main(String[] args) {
        final int x = 6;
        Transaction transaction;
        String hash;

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < 2147483647; i++) {
            transaction = new Transaction(i);
            hash = DigestUtils.md5Hex(transaction.toString());
            if (hash.substring(hash.length() - x).equals((Integer.toString((int)Math.pow(10, x))).substring(1 ))){
                System.out.println("mineFactor: " + i);
                System.out.println("Hash: " + hash);
                break;
            }
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Czas: " + (endTime - startTime));
    }
}
