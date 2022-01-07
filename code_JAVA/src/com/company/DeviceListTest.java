package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static java.lang.Byte.parseByte;

public class DeviceListTest {
    static public void main(String[] args) throws Exception {
        //read file
        DeviceList test=new DeviceList("C:\\Users\\Karl\\Desktop\\JAVA\\code_JAVA\\src\\com\\company\\scanlist.txt");
        System.out.println("test print all information:");
        System.out.println(test.printAllAddress());
        System.out.println(test.printAllEssid());
        System.out.println(test.printAllChannel());
        System.out.println("test query methods:");
        System.out.println("fit address 90:2B:D2:C5:3C:41");
        Vector<String> t1=test.queryAddress("90:2B:D2:C5:3C:41");
        for(String i:t1)
            System.out.println(i);
        System.out.println("fit address 00:00:00:00:00:00");
        Vector<String> t2=test.queryAddress("00:00:00:00:00:00");
        for(String i:t2)
            System.out.println(i);
        System.out.println("fit essid: unknown");
        Vector<String> t3=test.queryEssid("unknown");
        for(String i:t3)
            System.out.println(i);
        System.out.println("fit essid: \"WirelessAP-01\"");
        Vector<String> t4=test.queryEssid("\"WirelessAP-01\"");
        for(String i:t4)
            System.out.println(i);
        System.out.println("fit essid: \"error\"");
        Vector<String> t5=test.queryEssid("\"error\"");
        System.out.println("fit channel: 6");
        Vector<String> t6=test.queryChannel(Byte.parseByte("6"));
        for(String i:t6)
            System.out.println(i);
        System.out.println("fit channel: 99");
        Vector<String> t7=test.queryChannel(Byte.parseByte("99"));
        for(String i: t7)
            System.out.println(i);
        System.out.println("higher than signal: 0");
        Vector<String> t8=test.queryAboveSignal(Byte.parseByte("0"));
        for(String i:t8)
            System.out.println(i);
        System.out.println("higher than signal: -98");
        Vector<String> t9=test.queryAboveSignal(Byte.parseByte("-98"));
        for(String i:t9)
            System.out.println(i);
    }
}

class DeviceList {
    private Vector<WifiDevice> WifiDeviceList=new Vector();
    //构造函数
    public DeviceList(String filePath) throws Exception{
        try(BufferedReader fileIn=new BufferedReader(new FileReader(filePath))){
            String address;
            String essid;
            String mode;
            String quality;
            String encryption;
            Byte channel;
            Byte signal;
            //正则表达式
            String addRegx="[A-Z0-9]{2}:[A-Z0-9]{2}:[A-Z0-9]{2}:[A-Z0-9]{2}:[A-Z0-9]{2}:[A-Z0-9]{2}";//right
            Pattern addPattern=Pattern.compile(addRegx);
            String essidRegx="\"[a-zA-Z]+\"|(unknow)";//right
            Pattern essidPattern=Pattern.compile(essidRegx);
            String modeRegx="([a-zA-z]+\\s)";//right
            Pattern modePattern=Pattern.compile(modeRegx);
            String channelRegx= "[0-9]+";
            Pattern channelPattern=Pattern.compile(channelRegx);
            String signalRegx="(-[0-9]+)|(0-9]+)";
            Pattern signalPattern=Pattern.compile(signalRegx);
            String qualityRegx="[0-9]+/[0-9]+";
            Pattern qualityPattern=Pattern.compile(qualityRegx);
            //使用split()方法
            String encryptionRegx="\\s+";
            //匹配
            Matcher addMatcher;
            Matcher essidMatcher;
            Matcher modeMathcher;
            Matcher channelMathcher;
            Matcher signalMathcher;
            Matcher qualityMatcher;
            //
            String s;
            while((s=fileIn.readLine())!=null){
                address="";
                essid="";
                mode="";
                quality="";
                encryption="";
                channel=0;
                signal=0;
                //address
                //已经读入
                addMatcher=addPattern.matcher(s);
                if(addMatcher.find()) address=addMatcher.group();
                //essid
                s=fileIn.readLine();
                essidMatcher=essidPattern.matcher(s);
                if(essidMatcher.find()) essid=essidMatcher.group();
                //mode and channel
                s=fileIn.readLine();
                modeMathcher=modePattern.matcher(s);
                if(modeMathcher.find()) mode=modeMathcher.group();
                channelMathcher=channelPattern.matcher(s);
                if(channelMathcher.find()) channel=Byte.parseByte(channelMathcher.group(),10);
                //signal and quality
                s=fileIn.readLine();
                signalMathcher=signalPattern.matcher(s);
                if(signalMathcher.find()) signal=Byte.parseByte(signalMathcher.group(),10);
                qualityMatcher=qualityPattern.matcher(s);
                if(qualityMatcher.find()) quality=qualityMatcher.group();
                //encryption 使用split方法
                s=fileIn.readLine();
                String[] ss=s.split(encryptionRegx);
                for(int i=1; i<ss.length; i++) encryption+=ss[i]+" ";
                //构造
                WifiDeviceList.addElement(new WifiDevice(address, essid, mode, quality, encryption, channel, signal));
                //吃掉空行
                s=fileIn.readLine();
            }
        }
    }

//    private String printDeviceInf(WifiDevice i){
//        String s="Address: "+ i.getAddress();
//        s+="\nEssid: "+i.getEssid();
//        s+="\nMode: "+i.getMode();
//        s+="\nChannel: "+i.getChannel();
//        s+="\nSignal: "+i.getSignal();
//        s+="\nQuality: "+i.getQuality();
//        s+="\nEncryption: "+i.getEncryption();
//        s+="\n";
//        return s;
//    }

    public Vector<String> queryAddress(String address){
        Vector<String> ss=new Vector<>();
        String s="the information of this address fit device:";
        int num=0;
        for(WifiDevice i : WifiDeviceList){
            if(address.equals(i.getAddress())){
                if(num==0) ss.addElement(new String(s));
                s=i.toString();
                ss.addElement(new String(s));
                num++;
            }
        }
        if(num==0) ss.addElement(new String("no device fit this address"));
        return ss;
    }
    public Vector<String> queryEssid(String essid){
        Vector<String> ss=new Vector<>();
        String s="the information of this essid fit device:";
        int num=0;
        for(WifiDevice i : WifiDeviceList){
            if(essid.equals(i.getEssid())){
                if(num==0) ss.addElement(new String(s));
                s=i.toString();
                ss.addElement(new String(s));
                num++;
            }
        }
        if(num==0) ss.addElement(new String("no device fit this essid"));
        return ss;
    }

    public Vector<String> queryChannel(Byte channel){
        Vector<String> ss=new Vector<>();
        String s="the information of this channel fit device:";
        int num=0;
        for(WifiDevice i : WifiDeviceList){
            if(channel.equals(i.getChannel())){
                if(num==0) ss.addElement(new String(s));
                s=i.toString();
                ss.addElement(new String(s));
                num++;
            }
        }
        if(num==0) ss.addElement(new String("no device fit this channel"));
        return ss;
    }

    public Vector<String> queryAboveSignal(Byte signal){
        Vector<String> ss=new Vector<>();
        String s="the information of device's signal higher than the signal:";
        int num=0;
        for(WifiDevice i : WifiDeviceList){
            if(signal.byteValue()<i.getSignal().byteValue()){
                if(num==0) ss.addElement(new String(s));
                s=i.toString();
                ss.addElement(new String(s));
                num++;
            }
        }
        if(num==0) ss.addElement(new String("no device's signal higher than the signal"));
        return ss;
    }

    public String printAllAddress(){
        if(WifiDeviceList.size()==0){
            return "this is no device";
        }
        String s="";
        for(Integer i=0; i<WifiDeviceList.size(); i++){
            s+="Device:"+ i.toString() +" address: "+WifiDeviceList.get(i).getAddress()+"\n";
        }
        return s;
    }

    public String printAllEssid(){
        if(WifiDeviceList.size()==0){
            return "this is no device";
        }
        String s="";
        for(Integer i=0; i<WifiDeviceList.size(); i++){
            s+="Device:"+ i.toString() +" address: "+WifiDeviceList.get(i).getEssid()+"\n";
        }
        return s;
    }

    public String printAllChannel(){
        if(WifiDeviceList.size()==0){
            return "this is no device";
        }
        String s="";
        for(Integer i=0; i<WifiDeviceList.size(); i++){
            s+="Device:"+ i.toString() +" address: "+WifiDeviceList.get(i).getChannel().toString()+"\n";
        }
        return s;
    }
}

class WifiDevice{
    private String address;
    private String essid;
    private String mode;
    private String quality;
    private String encryption;
    private Byte channel;
    private Byte signal;

    @Override
    public String toString() {
        return "WifiDevice{" +
                "address='" + address + '\'' +
                ", essid='" + essid + '\'' +
                ", mode='" + mode + '\'' +
                ", quality='" + quality + '\'' +
                ", encryption='" + encryption + '\'' +
                ", channel=" + channel +
                ", signal=" + signal +
                '}';
    }
//构造

    public WifiDevice(String address, String essid, String mode, String quality, String encryption, Byte channel, Byte signal) {
        this.address = address;
        this.essid = essid;
        this.mode = mode;
        this.quality = quality;
        this.encryption = encryption;
        this.channel = channel;
        this.signal = signal;
    }

    //get
    public String getAddress(){
        return address;
    }

    public String getEssid() {
        return essid;
    }

    public String getMode() {
        return mode;
    }

    public Byte getChannel(){
        return channel;
    }

    public Byte getSignal() {
        return signal;
    }

    public String getQuality() {
        return quality;
    }

    public String getEncryption() {
        return encryption;
    }

}