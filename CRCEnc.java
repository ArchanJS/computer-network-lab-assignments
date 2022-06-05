import java.util.*;

public class CRCEnc {
    private char divident[];
    private String dividentrStr;
    private String divisor;
    public CRCEnc(String data,String key){
        this.divident=new char[data.length()+key.length()-1];
        this.divisor=key;
        this.dividentrStr=data;
        for(int i=0;i<data.length();i++){
            this.divident[i]=data.charAt(i);
        }
        for(int i=data.length();i<this.divident.length;i++){
            this.divident[i]='0';
        }
    }
    public String xor(String a,String b){
        String ans="";
        for(int i=1;i<a.length();i++){
            if(a.charAt(i)==b.charAt(i)) ans+='0';
            else ans+='1';
        }
        return ans;
    }
    public void encode(){
        int pick=this.divisor.length(),n=this.divident.length;
        String ans="";
        for(int i=0;i<pick;i++) ans+=this.divident[i];
        while(pick<n){
            if(ans.charAt(0)=='0'){
                String temp="";
                for(int i=0;i<this.divisor.length();i++) temp+='0';
                ans=(xor(temp,ans)+this.divident[pick]);
            }
            else{
                ans=(xor(ans,this.divisor)+this.divident[pick]);
            }
            pick++;
        }
        int i=0;
        for(;i<ans.length();i++){
            if(ans.charAt(i)!='0') break;
        }
        ans=this.dividentrStr+ans.substring(i);
        System.out.println(ans);
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter data: ");
        String data=sc.next();
        System.out.println("Enter key: ");
        String key=sc.next();
        CRCEnc dataObj=new CRCEnc(data, key);
        dataObj.encode();
        sc.close();
    }
}
