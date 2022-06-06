import java.util.*;

public class CheckSumDec {
    private char[][] data;
    private char[] ans;
    private int seg;
    CheckSumDec(String data,int seg){
        this.seg=seg;
        int n=data.length()/this.seg;
        int m=this.seg;
        int idx=0;
        this.data=new char[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                this.data[i][j]=data.charAt(idx);
                idx++;
            }
        }
        this.ans=new char[this.seg];
        for(int i=0;i<this.seg;i++){
            this.ans[i]='0';
        }
    }

    public void decode(){
        int carry='0';
        int n=this.data.length;
        int m=this.data[0].length;
        for(int i=0;i<n;i++){
            for(int j=m-1;j>=0;j--){
                if(this.ans[j]=='0'&&this.data[i][j]=='0'){
                    if(carry=='1') this.ans[j]='1';
                    carry='0';
                }
                else if((this.ans[j]=='0'&&this.data[i][j]=='1')||(this.ans[j]=='1'&&this.data[i][j]=='0')){
                    if(carry=='0'){
                        this.ans[j]='1';
                    }
                    else{
                        this.ans[j]='0';
                        carry='1';
                    }
                }
                else{
                    if(carry=='1'){
                        this.ans[j]='1';
                    }
                    else{
                        this.ans[j]='0';
                        carry='1';
                    }
                }
            }
        }
        if(carry=='1'){
            while(carry!='0'){
                for(int i=m-1;i>=0;i--){
                    if(carry=='0') break;
                    else{
                        if(this.ans[i]=='0'){
                            this.ans[i]='1';
                            carry='0';
                        }
                        else this.ans[i]='0';
                    }
                }
            }
        }
        String temp="";
        for(int i=0;i<n-1;i++){
            for(int j=0;j<m;j++){
                if(ans[j]=='0'){
                    System.out.println("Error detected!");
                    return;
                }
                temp+=this.data[i][j];
            }
        }
        System.out.println(temp);
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter data: ");
        String data=sc.next();
        System.out.println("Enter segment length: ");
        int seg=sc.nextInt();
        sc.close();
        CheckSumDec dataObj=new CheckSumDec(data, seg);
        dataObj.decode();
    }
}
