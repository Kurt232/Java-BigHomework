package com.company;
import java.util.Scanner;
import java.lang.String;
import java.lang.StringBuilder;
// a:[97,123) A:[65,91)
public class textEncode {

    public static String encodeText(String s, int key){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            if(97<=s.charAt(i)&&s.charAt(i)<123){
                //System.out.println(s.charAt(i));
                int c=s.charAt(i)+key;
                if(c>=123) c=97+c%123;
                sb.append((char)c);
            }
            else if(65<=s.charAt(i)&&s.charAt(i)<91){
                int c=s.charAt(i)+key;
                if(c>=91) c=65+c%123;
                sb.append((char)c);
            }
        }
        String encodeTextString =sb.toString();
        return encodeTextString;
    }

    public static String decodeText(String s, int key){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            if(97<=s.charAt(i)&&s.charAt(i)<123){
                //System.out.println(s.charAt(i));
                int c=s.charAt(i)-key;
                if(c>=123) c=97+c%123;
                sb.append((char)c);
            }
            else if(65<=s.charAt(i)&&s.charAt(i)<91){
                int c=s.charAt(i)-key;
                if(c>=91) c=65+c%123;
                sb.append((char)c);
            }
        }
        String decodeTextString =sb.toString();
        return decodeTextString;
    }
    public static void main (String[] args){
        System.out.println("请输入加密文本: ");
        Scanner inPut= new Scanner(System.in);
        String es=inPut.nextLine();
        System.out.println("请输入加密Key: ");
        inPut= new Scanner(System.in);
        int key=inPut.nextInt();
        String encodeString= new String(encodeText(es, key));
        System.out.println("最终加密结果: "+encodeString);

        System.out.println("解密文本为: "+encodeString);
        System.out.println("解密Key: "+key);
        String decodeString= new String(decodeText(encodeString, key));
        System.out.println("解密结果: "+decodeString);
    }
}
