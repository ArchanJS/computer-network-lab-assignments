import java.util.*;

//Even parity (Decoding)
public class Parity1DDec {
    private String data;
    public Parity1DDec(String data){
        this.data=data;
    }
    public int binaryToDecimal(){
        int ans=0,n=this.data.length(),p=1;
        for(int i=n-1;i>0;i--){
            ans+=((this.data.charAt(i)-'0')*p);
            p*=2;
        }
        return ans;
    }
    public void decode(){
        int cnt1=0;
        for(int i=0;i<this.data.length();i++){
            if(this.data.charAt(i)=='1') cnt1++;
        }
        if(cnt1%2!=0) System.out.println("Error!");
        else{
            int ans=binaryToDecimal();
            System.out.println(ans);
        }
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter data:");
        String data=sc.next();
        sc.close();
        Parity1DDec dataObj=new Parity1DDec(data);
        dataObj.decode();
    }
}
