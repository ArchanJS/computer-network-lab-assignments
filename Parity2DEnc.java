import java.util.*;

public class Parity2DEnc{
    private char[][] data;
    private int seg;
    public Parity2DEnc(String s,int seg){
        this.seg=seg;
        int m=seg+1,n=(s.length()/seg)+1;
        this.data=new char[n][m];
        int idx=0;
        for(int i=0;i<n-1;i++){
            for(int j=0;j<m-1;j++){
                this.data[i][j]=s.charAt(idx);
                idx++;
            }
        }
    }
    public void encode(){
        int n=this.data.length,m=this.data[0].length;
        for(int i=0;i<n-1;i++){
            int cnt=0;
            for(int j=0;j<m-1;j++){
                if(this.data[i][j]=='1') cnt++;
            }
            if(cnt%2==0) this.data[i][m-1]='0';
            else this.data[i][m-1]='1';
        }
        for(int j=0;j<m;j++){
            int cnt=0;
            for(int i=0;i<n-1;i++){
                if(this.data[i][j]=='1') cnt++;
            }
            if(cnt%2==0) this.data[n-1][j]='0';
            else this.data[n-1][j]='1';
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(this.data[i][j]);
            }
            System.out.println();
        }
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        int seg=sc.nextInt();
        sc.close();
        Parity2DEnc dataObj=new Parity2DEnc(s, seg);
        dataObj.encode();
    }
}