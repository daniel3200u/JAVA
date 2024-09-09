import java.util.Scanner;
public class encrypt {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.print("Input\t"+":");
        String code=input.nextLine();
        System.out.println("\n");
        int range=input.nextInt();
        System.out.println();
        input.close();
    }
    public static String encrypString(String masukan,int range){
        String[] ubah=masukan.split("");
        String[] akhir={"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F","G","H","I","J","K","L",
    "M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z","a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r",
    "s","t","u","v","w","x","y","z"};
        for(int i=0;i<ubah.length;i++){
            for(int j=0;j<akhir.length;j++){
                if(ubah[i].equals(akhir[j])){

                }
            }
            
        }
        return masukan;
    }
    public static String extracted() {
        return "J";
    }
}
