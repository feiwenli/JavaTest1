package com.hand;

import java.util.*;

/**
 * 随机生成50个小于100的整数，放入List中，将List中的数据除以10，以结果的整数值作为key放入Map中，得到
 * 如{1=>[11,10,12],2=>[21,24,23]}的Map，再将Map中key对应的数组进行排序，得到如{1=>
 * [10,11,12],2=>[21,23,24]}。排序不能使用List.sort() 方法。必须自己写排序方法。
 *
 */
interface Cre{
    void create();
}

class AMap implements Cre{

    @Override
    public void create(){
        System.out.println("Hi~");
    }

}

class AList implements Cre{
    @Override
    public void create(){
        System.out.println("Hi~");
    }
}


class CreFactory{

    public Cre getCre(String CreType){
        if(CreType == null){
            return null;
        }
        if(CreType.equalsIgnoreCase("AMAP")){
            return new AMap();
        } else if(CreType.equalsIgnoreCase("ALIST")){
            return new AList();
        }
        return null;
    }
}

public class App 
{
    public static void main( String[] args )
    {
//        Set<Integer> set = new HashSet<>();
//        List<Integer> list = new ArrayList<>();
//        for(int i=0;i<50;i++) {
//            Integer value = (int) (Math.random() * 100);
//            set.add(value/10);
//            list.add(value);
//        }

        CreFactory cc = new CreFactory();

        Cre l1 = cc.getCre("AList");
        l1.create();

        Cre m1 = cc.getCre("AMap");
        m1.create();

    }
}
