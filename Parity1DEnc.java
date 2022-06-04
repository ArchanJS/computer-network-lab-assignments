import java.util.*;

//Even parity (Encoding)
// public class Parity1DEnc{
//     private  char[] data;
//     public Parity1DEnc(String data){
//         int n=data.length();
//         this.data=new char[n+1];
//         this.data[n]='0';
//         for(int i=0;i<n;i++){
//             this.data[i]=data.charAt(i);
//         }
//     }
//     public char[] encode(){
//         int n=this.data.length;
//         int cnt1=0;
//         for(int i=0;i<n;i++){
//             if(data[i]=='1') cnt1++;
//         }
//         if(cnt1%2!=0) this.data[n-1]='1';
//         return this.data;
//     }
//     public static String decimalToBinary(int n){
//         String s="",ans="";
//         while(n>0){
//             int temp=n%2;
//             if(temp==1) s+='1';
//             else s+='0';
//             n/=2;
//         }
//         for(int i=s.length()-1;i>=0;i--){
//             ans+=s.charAt(i);
//         }
//         System.out.println(s);
//         return ans;
//     }
//     public static void main(String args[]){
//         Scanner sc=new Scanner(System.in);
//         System.out.println("Enter data:");
//         int n=sc.nextInt();
//         sc.close();
//         String data=decimalToBinary(n);
//         Parity1DEnc dataObj=new Parity1DEnc(data);
//         char[] encData=dataObj.encode();
//         for(int i=0;i<encData.length;i++){
//             System.out.print(encData[i]);
//         }
//     }
// }

//Odd parity (Encoding)
public class Parity1DEnc{
    private  char[] data;
    public Parity1DEnc(String data){
        int n=data.length();
        this.data=new char[n+1];
        this.data[n]='0';
        for(int i=0;i<n;i++){
            this.data[i]=data.charAt(i);
        }
    }
    public char[] encode(){
        int n=this.data.length;
        int cnt1=0;
        for(int i=0;i<n;i++){
            if(data[i]=='1') cnt1++;
        }
        if(cnt1%2==0) this.data[n-1]='1';
        return this.data;
    }
    public static String decimalToBinary(int n){
        String s="",ans="";
        while(n>0){
            int temp=n%2;
            if(temp==1) s+='1';
            else s+='0';
            n/=2;
        }
        for(int i=s.length()-1;i>=0;i--){
            ans+=s.charAt(i);
        }
        System.out.println(s);
        return ans;
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter data:");
        int n=sc.nextInt();
        sc.close();
        String data=decimalToBinary(n);
        Parity1DEnc dataObj=new Parity1DEnc(data);
        char[] encData=dataObj.encode();
        for(int i=0;i<encData.length;i++){
            System.out.print(encData[i]);
        }
    }
}