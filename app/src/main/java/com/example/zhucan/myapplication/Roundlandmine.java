package com.example.zhucan.myapplication;

/**
 * Created by zhucan on 2016/11/23.
 */

public class Roundlandmine {
    // 点击的位置
    int ld;
    // 点击处四周位置
    int[] roundld;
    // 计算的点击处四周的地雷数量
    int count;
    // 布局列数
    int column;
    // 总格子数量
    int all;

    //构造函数
    public Roundlandmine(int ld,int column,int all){
        this.ld=ld;
        this.column=column;
        this.all=all;
    };

    // 计算roundld
    public void setroundld() {

        if (ld == 1) {
            roundld = new int[] { 2, column + 1, column + 2 };
        } else if (ld == column) {
            roundld = new int[] { column - 1, column * 2 - 1, column * 2 };
        } else if (ld == all - column + 1) {
            roundld = new int[] { all - column * 2 + 1, all - column * 2 + 2, all - column + 2 };
        } else if (ld == all) {
            roundld = new int[] { all - column - 1, all - column, all - 1 };
        } else if (ld <= column) {
            roundld = new int[] { ld - 1, ld + 1, ld + column - 1, ld + column, ld + column + 1 };
        } else if (ld > all - column) {
            roundld = new int[] { ld - 1, ld + 1, ld - column + 1, ld - column, ld - column - 1 };
        } else if (ld % column == 1) {
            roundld = new int[] { ld - column, ld - column + 1, ld + 1, ld + column, ld + column + 1 };
        } else if (ld % column == 0) {
            roundld = new int[] { ld - column - 1, ld - column, ld - 1, ld + column - 1, ld + column };
        } else {
            roundld = new int[] { ld - column - 1, ld - column, ld - column + 1, ld - 1, ld + 1, ld + column - 1,
                    ld + column, ld + column + 1 };
        }
    }

    // 计算count 的值
    public int getnum(int[] random) {
        count = 0;
        for (int i = 0; i < random.length; i++) {
            for (int j = 0; j < roundld.length; j++) {

                if (random[i] == roundld[j]) {
                    count++;
                }
            }
        }
        return count;

    }

}


