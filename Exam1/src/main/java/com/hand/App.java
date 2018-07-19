package com.hand;

/**
 * 判断101-200之间有多少个素数，并输出所有素数。
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        int [] prime = new int[50];
        int count = 0;
        for(int l=101;l<200;l++){
            if(isPrime(l)){
                count ++;
                prime[count-1] = l;
            }
        }
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<count;i++){
            sb.append(prime[i]);
            sb.append(",");
        }
        sb.replace(sb.length()-1,sb.length(),". ");
        System.out.println("101-200间总共有"+count+"个素数，分别是:"+sb);
    }

    static boolean isPrime(int i){
        for (int j=2; j<=Math.sqrt(i); j++){
            if(i%j == 0){
                return false;
            }
        }
        return true;
    }
}
