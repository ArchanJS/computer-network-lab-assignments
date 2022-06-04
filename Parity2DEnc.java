import java.util.*;

//Even 2D parity (Encoding)
public class Parity2DEnc {
    private char data[][];
    public Parity2DEnc(String data){
        this.data=new char[5][5];
        int charIdx=0;
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                if(j==4 || i==4) this.data[i][j]='0';
                else {
                    this.data[i][j]=data.charAt(charIdx);
                    charIdx++;
                }
            }
        }
    }
    public void encode(){
        for(int i=0;i<4;i++){
            int cnt1=0;
            for(int j=0;j<4;j++){
                if(this.data[i][j]=='1') cnt1++;
            }
            if(cnt1%2!=0) this.data[i][4]='1';
        }
        for(int j=0;j<5;j++){
            int cnt1=0;
            for(int i=0;i<4;i++){
                if(this.data[i][j]=='1') cnt1++;
            }
            if(cnt1%2!=0) this.data[4][j]='1';
        }
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                System.out.print(this.data[i][j]);
            }
        }
    }

    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter data:");
        String data=sc.next();
        sc.close();
        Parity2DEnc dataObj=new Parity2DEnc(data);
        dataObj.encode();
    }

}
