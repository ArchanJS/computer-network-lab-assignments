import java.util.*;

public class CRCDec {
    private char[] data;
    private String dataStr;
    private String divisor;
    public CRCDec(String data,String divisor){
        this.dataStr=data;
        this.data=new char[data.length()];
        for(int i=0;i<data.length();i++){
            this.data[i]=data.charAt(i);
        }
        this.divisor=divisor;
    }
    public String xor(String a,String b){
        String ans="";
        for(int i=1;i<a.length();i++){
            if(a.charAt(i)==b.charAt(i)) ans+='0';
            else ans+='1';
        }
        return ans;
    }
    public void decode(){
        int pick=this.divisor.length(),n=this.data.length;
        String ans=this.dataStr.substring(0,pick);
        while(pick<n){
            if(ans.charAt(0)=='0'){
                String temp="";
                for(int i=0;i<this.divisor.length();i++) temp+='0';
                ans=xor(temp,ans)+dataStr.charAt(pick);
            }
            else{
                ans=xor(ans,this.divisor)+dataStr.charAt(pick);
            }
            pick++;
        }
        boolean f=false;
        for(int i=0;i<ans.length();i++){
            if(ans.charAt(i)=='1'){
                f=true;
                break;
            }
        }
        if(f==true) System.out.println("Error detected!");
        else System.out.println(this.dataStr.substring(0,dataStr.length()+1-divisor.length()));
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter data: ");
        String data=sc.next();
        System.out.println("Enter divisor:");
        String divisor=sc.next();
        CRCDec dataObj=new CRCDec(data, divisor);
        dataObj.decode();
        sc.close();
    }
}
