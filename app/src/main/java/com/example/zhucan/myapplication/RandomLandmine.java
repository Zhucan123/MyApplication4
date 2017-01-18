package com.example.zhucan.myapplication;

/**
 * Created by zhucan on 2016/11/19.
 */

public class RandomLandmine {
    // 所有布局的总格数
    private int lmcount;
    // 总布局的数组
    private int[] landmine;
    // 地雷数组
    private int[] randomLM;
    //构造方法
    public RandomLandmine(int lmcount) {
        this.lmcount=lmcount;
    };
    //通过随机的方法获取randomLM
    public int[] setrandomLM() {
        landmine = new int[lmcount];

        for (int i = 0; i < lmcount; i++) {
            landmine[i] = i + 1;
        }
        for (int a = 0; a < landmine.length; a++) {
            int b = (int) (Math.random() * landmine.length - 1);
            if (a != b) {
                int temp = landmine[a];
                landmine[a] = landmine[b];
                landmine[b] = temp;

            }

        }
        randomLM = new int[20];
        for (int j = 0; j < 20; j++) {
            randomLM[j] = landmine[j];
        }
        return randomLM;

    }

}
