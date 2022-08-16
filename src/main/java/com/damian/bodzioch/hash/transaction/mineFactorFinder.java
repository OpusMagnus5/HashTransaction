package com.damian.bodzioch.hash.transaction;

import org.apache.commons.codec.digest.DigestUtils;

public class mineFactorFinder implements Runnable{
    int x;
    int startRange;
    int endRange;

    public mineFactorFinder(){
    }

    public mineFactorFinder(int x, int startRange, int endRange){
        this.x = x;
        this.startRange = startRange;
        this.endRange = endRange;
    }

    @Override
    public void run(){
        findMineFactor();
    }

    public void findMineFactor(){
        for (int i = this.startRange; i < this.endRange; i++) {
            Transaction transaction = new Transaction(i);
            String hash = DigestUtils.md5Hex(transaction.toString());
            if (hash.substring(hash.length() - this.x).equals((Integer.toString((int)Math.pow(10, this.x))).substring(1 ))){
                Main2.mineFactor = i;
                Main2.hash = hash;
                break;
            }else if (Main2.hash != null){
                break;
            }
        }
    }
}
