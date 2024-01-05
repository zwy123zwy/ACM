package main;

public class Main {
    public static void main(String[] args) {
        System.out.println(getRes("11111111111111111111" , "12"));

    }
    public static String getRes(String a,String b){
        int len1=a.length();
        int len2=b.length();
        int [] num=new int[len1+len2];
        for (int i = len1-1; i >=0 ; i--) {
            for(int j = len2-1; j>=0 ; j--) {
                int val=(a.charAt(i)-'0')*(b.charAt(j)-'0');
                val+=num[i+j+1];//保留相较于之前的数据，累加
                num[i+j]+=val/10;//进位加入之前的位数
                num[i+j+1]=val%10;//最后位
            }
        }
        StringBuilder sb = new StringBuilder();
        int i=0;
        while(i<num.length-1&& num[i]==0){
            i++;
        }
        while(i<num.length){
            sb.append(num[i]);
            i++;
        }
        return sb.toString();
    }

}
