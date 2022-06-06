import java.util.*;

public class HammingDec {
    private char[] data;
    public HammingDec(String data){
        this.data=new char[data.length()];
        for(int i=0;i<data.length();i++){
            this.data[i]=data.charAt(i);
        }
    }
    public boolean check(char c1,char c2,char c3, char c4){
        int cnt=0;
        if(c1=='1') cnt++;
        if(c2=='1') cnt++;
        if(c3=='1') cnt++;
        if(c4=='1') cnt++;
        if(cnt%2==0) return true;
        return false;
    }
    public void decode(){
        boolean f1=check(this.data[6],this.data[4],this.data[2],this.data[0]),f2=check(this.data[5],this.data[4],this.data[1],this.data[0]),f3=check(this.data[3],this.data[2],this.data[1],this.data[0]);
        if(f1&&f2&&f3){
            System.out.print(this.data[0]);
            System.out.print(this.data[1]);
            System.out.print(this.data[2]);
            System.out.print(this.data[4]);
        }
        else System.out.println("Error detected!");
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter data: ");
        String data=sc.next();
        sc.close();
        HammingDec dataObj=new HammingDec(data);
        dataObj.decode();
    }
}
