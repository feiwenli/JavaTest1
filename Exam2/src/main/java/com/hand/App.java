package com.hand;

/**
 * 编程实现工资个人所得税计算程序。
 * 使用单例模式。
 *
 */

class Shui{
    private double money;
    boolean isForeigner;
    int level;
    double afterMoney = 0;

    Shui(double money, boolean isForeigner){
        this.money = money;
        this.isForeigner = isForeigner;
    }

    public void setLevel() {
        if(isForeigner){
            if(this.money<=4800){
                this.level = 0;
            }else{
                this.money -= 4800;
            }
        }else {
            if(this.money<=3500){
                this.level = 0;
            }else {
                this.money -=3500;
            }
        }

        if(this.money<=1500){
            this.level = 1;
        }else {
            this.money -= 1500;
            if(this.money<=3000){
                this.level = 2;
            }else {
                this.money -= 3000;
                if(this.money <= 4500){
                    this.level = 3;
                }else {
                    this.money -= 4500;
                    if(this.money <= 26000){
                        this.level = 4;
                    }else{
                        this.money -= 26000;
                        if(this.money<=20000){
                            this.level = 5;
                        }else {
                            this.money -= 20000;
                            if(this.money<=25000){
                                this.level = 6;
                            }else {
                                this.money -= 2500;
                                this.level = 7;
                            }
                        }
                    }
                }
            }
        }
    }

    public double getAfterMoney() {
        this.setLevel();
        switch(this.level){
            case 7:
                afterMoney += this.money*0.45 + 25000*0.35 + 20000*0.3 + 26000*0.25 + 4500*0.2 + 3000*0.1 + 1500*0.03;
                break;
            case 6:
                afterMoney += this.money*0.35 +20000*0.3 + 26000*0.25 + 4500*0.2 + 3000*0.1 + 1500*0.03;
                break;
            case 5:
                afterMoney += this.money*0.3 + 26000*0.25 + 4500*0.2 + 3000*0.1 + 1500*0.03;
                break;
            case 4:
                afterMoney += this.money*0.25 + 4500*0.2 + 3000*0.1 + 1500*0.03;
                break;
            case 3:
                afterMoney += this.money*0.2 + 3000*0.1 + 1500*0.03;
                break;
            case 2:
                afterMoney += this.money*0.1 + 1500*0.03;
                break;
            case 1:
                afterMoney = this.money*0.03;
                break;
            case 0:
                afterMoney = this.money;

        }

        return afterMoney;
    }
}

public class App 
{
    public static void main( String[] args )
    {
        Shui [] s = new Shui[4];
        s[0] = new Shui(5000, false);
        s[1] = new Shui(10000, false);
        s[2] = new Shui(15000,false);
        s[3] = new Shui(60000,false);

        System.out.println("userA: "+ s[0].getAfterMoney()+
                            " userB: "+s[1].getAfterMoney()+
                            " userC: "+s[2].getAfterMoney()+
                            " userD: "+s[3].getAfterMoney());
    }
}
