import java.util.Scanner;
import java.util.ArrayList;

public class input {
    public static void main(String args[]){
        Scanner scan1=new Scanner(System.in);
        String ayam=scan1.next();
        System.out.println("how many input do you want to add?");
        int scan2=scan1.nextInt();
        scan1.close();
        ArrayList <String> alin=new ArrayList<String>();
        alin.add("bmw");
        alin.add("volvo");
        
        for (String item : alin){
            if (ayam.equals(item)){
                System.out.println("i found it");
            }else{
                System.out.println("ican't found it");
            }

        }
        for(int i=0;i<scan2;i++){
            int ak=i*2;
            System.out.println(ak);
        }

        
    }
    
}
