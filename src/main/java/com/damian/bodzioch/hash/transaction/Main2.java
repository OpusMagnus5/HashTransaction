package com.damian.bodzioch.hash.transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;

public class Main2 {
    static int mineFactor;
    static String hash = null;
        public static void main(String[] args) {

        List<Thread> threads = new ArrayList<>();
        final int threadsNumber = 8;
        final int maxInteger = 2147483647;
        final int x = 8;

        long startTime = System.currentTimeMillis();

        for(int i = 0; i < threadsNumber; i++){
            int startIndex = (int) (((long) i) * ((long) maxInteger) / threadsNumber);
            int endIndex = (int) (((long) (i + 1)) * ((long) maxInteger) / threadsNumber);
            Thread t = new Thread(new mineFactorFinder(x, startIndex, endIndex));
            t.start();
            threads.add(t);
        }

        try {
            for(Thread t : threads) {
                t.join();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        long endTime = System.currentTimeMillis();

        System.out.println("czas: " + (endTime - startTime));
        System.out.println("mineFactor: " + mineFactor);
        System.out.println("Hash: " + hash);
    }
}
