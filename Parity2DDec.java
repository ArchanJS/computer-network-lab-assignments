import java.util.*;

//Even 2D parity (Decoding)
public class Parity2DDec {
    private char data[][];
    public Parity2DDec(String s){
        data=new char[5][5];
        int idx=0;
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                data[i][j]=s.charAt(idx);
                idx++;
            }
        }
    }
    public void decode(){
        Boolean flag=false;
        for(int j=0;j<this.data[0].length;j++){
            int cnt=0;
            for(int i=0;i<this.data.length;i++){
                if(data[i][j]=='1') cnt++;
            }
            if(cnt%2!=0){
                flag=true;
                break;
            }
        }
        if(flag==true) System.out.println("Error!");
        else{
            for(int i=0;i<this.data.length-1;i++){
                for(int j=0;j<this.data[0].length-1;j++){
                    System.out.print(this.data[i][j]);
                }
            }
        }
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter data:");
        String data=sc.next();
        sc.close();
        Parity2DDec dataObj=new Parity2DDec(data);
        dataObj.decode();
    }
}
