import java.util.*;

public class HammingEnc{
    private char[] data;
    public HammingEnc(String data){
        int idx=0;
        this.data=new char[7];
        for(int i=0;i<7;i++){
            if(i!=3&&i!=5&&i!=6){
                this.data[i]=data.charAt(idx);
                idx++;
            }
        }
    }
    public char xor(char ch1,char ch2,char ch3){
        int cnt=0;
        if (ch1=='1') cnt++;
        if (ch2=='1') cnt++;
        if (ch3=='1') cnt++;
        if(cnt%2==0) return '0';
        return '1';
    }
    public void encode(){
        char p1=xor(this.data[4],this.data[2],this.data[0]),p2=xor(this.data[4],this.data[1],this.data[0]),p3=xor(this.data[2],this.data[1],this.data[0]);
        this.data[6]=p1;
        this.data[5]=p2;
        this.data[3]=p3;
        for(int i=0;i<7;i++) System.out.print(this.data[i]);
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        String data=sc.next();
        System.out.println("Enter data: ");
        HammingEnc dataObj=new HammingEnc(data);
        dataObj.encode();
        sc.close();
    }
}