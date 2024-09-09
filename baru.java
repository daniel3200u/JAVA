import java.util.Scanner;

public class baru {
    public static void main(String[] args) {
        Scanner input=new Scanner(baru.class.getResourceAsStream("ken.txt"));
        int n=Integer.parseInt(input.nextLine());
        String[] nama=new String[n];
        String[] tambahan=new String[n];
        for(int i=0;i<n;i++){
            String[] splitter=input.nextLine().split(";");
            double gpa=Double.parseDouble(splitter[3]);
            int anime=Integer.parseInt(splitter[1]);
            int manga=Integer.parseInt(splitter[2]);
            if(gpa==4.0||anime>100||manga>100){
                nama[i]=splitter[0];
                tambahan[i]="Nihongo Zouzou";
            }else if(gpa<1||anime<10||manga<10){
                nama[i]=splitter[0];
                tambahan[i]="Expelled";
            }else{
                nama[i]=splitter[0];
                tambahan[i]="Normie";
            }
        }
        for(int y=0;y<n;y++){
            System.out.println(nama[y]+" "+tambahan[y]);
        }
    }
}
