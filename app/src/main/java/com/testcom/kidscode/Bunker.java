package com.testcom.kidscode;


public class Bunker {
private int life=0;
private int score=0;
private String result="";

    public void test(int a, int b){
        this.life=a-1;
        this.score=b-7;

    }

    public void test(int a){

        this.score=a+15;
    }

    public void Arr(String a, int b, int c){
        if (a.equalsIgnoreCase("24579")|| a.equalsIgnoreCase("zebra")){
            this.result="perfect";
            test(c);
            this.life=b;
        }
        else {
            this.result="wrong";
            test(b,c);
        }
    }

    public void Arr(String a, String b, int c, int d){
        int e=Integer.valueOf(a)+Integer.valueOf(b);
        if (e==10){
            this.result="perfect";
            test(d);
            this.life=c;
        }

        else {
            this.result="wrong";
            test(c,d);
        }
    }

    public int getLife() {
        return life;
    }

    public int getScore() {
        return score;
    }



    public String getResult() {
        return result;
    }
}
