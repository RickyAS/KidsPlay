package com.testcom.kidscode;

import java.util.ArrayList;
import java.util.Random;

public class Dom {
    private ArrayList<Integer > gg = new ArrayList<>();
    private String stage1="";
    private String stage2="";
    private String stage3="";
    private String stage4="";
    private String stage5="";

    public void rand(){
        Random randomGenerator = new Random();
        while (gg.size() < 5) {

            int random = randomGenerator.nextInt(5);
            if (!gg.contains(random)) {
                gg.add(random);}

        }
        for (int i = 0; i < gg.size(); i++) {

            if (i==0){
                String ab = String.valueOf(gg.get(i));
                this.stage1= rand2(ab);
            }

            else if (i==1){
                String ab = String.valueOf(gg.get(i));
                this.stage2= rand2(ab);
            }

            else if (i==2){
                String ab = String.valueOf(gg.get(i));
                this.stage3= rand2(ab);
            }

            else if (i==3){
                String ab = String.valueOf(gg.get(i));
                this.stage4= rand2(ab);
            }

            else if (i==4){
                String ab = String.valueOf(gg.get(i));
                this.stage5= rand2(ab);
            }


        }

    }

    public String rand2(String as){
        String a="";
        System.out.println("NUMBER :"+as);
        System.out.println(gg.size());
        if(as.equalsIgnoreCase("0")){
            a="com.testcom.kidscode.Puzzle";
        }

        else if (as.equalsIgnoreCase("1")){
            a="com.testcom.kidscode.Arrange";
        }

        else if (as.equalsIgnoreCase("2")){
            a="com.testcom.kidscode.NameGuess";
        }

        else if (as.equalsIgnoreCase("3")){
            a="com.testcom.kidscode.Quiz";
        }

        else if (as.equalsIgnoreCase("4")){
            a="com.testcom.kidscode.Math";
        }
        return a;
    }

    public String getStage1() {
        return stage1;
    }

    public String getStage2() {
        return stage2;
    }

    public String getStage3() {
        return stage3;
    }

    public String getStage4() {
        return stage4;
    }

    public String getStage5() {
        return stage5;
    }
}
