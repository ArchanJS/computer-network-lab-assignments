import java.util.*;
class CheckSumEnc{
    private char ans[];
    private char[][] data;
    private String dataStr;
    private int seg;
    public CheckSumEnc(String data,int seg){
        this.dataStr=data;
        this.seg=seg;
        int n=dataStr.length();
        if(n%seg!=0){
            String temp="";
            for(int i=0;i<seg-(n%seg);i++){
                temp+='0';
            }
            this.dataStr=temp+data;
        }
        this.ans=new char[this.seg];
        for(int i=0;i<this.seg;i++){
            this.ans[i]='0';
        }
        int idx=0;
        int m=this.dataStr.length()/this.seg;
        this.data=new char[m][this.seg];
        for(int i=0;i<m;i++){
            for(int j=0;j<this.seg;j++){
                this.data[i][j]=dataStr.charAt(idx);
                idx++;
            }
        }
    }
    public void encode(){
        int n=this.data.length;
        int m=this.data[0].length;
        for(int i=0;i<n;i++){
            char carry='0';
            for(int j=m-1;j>=0;j--){
                if((this.ans[j]=='0' && this.data[i][j]=='0')) {
                    if(carry=='1') this.ans[j]='1';
                    carry='0';
                }
                else if((this.ans[j]=='0' && this.data[i][j]=='1') || (this.ans[j]=='1' && this.data[i][j]=='0')) {
                    if(carry=='0') this.ans[j]='1';
                    else{
                        this.ans[j]='0';
                        carry='1';
                    }
                }
                else{
                    if(carry=='1'){
                        this.ans[j]='1';
                        carry='1';
                    }
                    else{
                        this.ans[j]='0';
                        carry='1';
                    }
                }
            }
            if(carry=='1'){
                while(carry!='0'){
                    for(int j=m-1;j>=0;j--){
                        if(carry=='0') break;
                        else{
                            if(this.ans[j]=='0'){
                                this.ans[j]='1';
                                carry='0';
                                break;
                            }
                            else{
                                this.ans[j]='0';
                                carry='1';
                            }
                        }
                    }
                }
            }
        }
        for(int i=0;i<seg;i++){
            if(this.ans[i]=='0') this.dataStr+='1';
            else this.dataStr+='0';
        }
        for(int i=0;i<this.dataStr.length();i++){
            System.out.print(this.dataStr.charAt(i));
        }
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        String dataStr=sc.next();
        int seg=sc.nextInt();
        sc.close();
        CheckSumEnc dataObj=new CheckSumEnc(dataStr,seg);
        dataObj.encode();
    }
}