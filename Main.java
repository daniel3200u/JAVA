/**
 * ES234211 - Basic Programming
 * Computing Lab. Work
 * Coursework No.   : 03
 * Student ID       : .......................
 * Student Name     : .......................
 * Class            : ...
 * Cohort           : ...
 */
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Do not change
        
        task1();
        task2();
        task3();
    }
    
    public static void task1(){
        System.out.println("===========================================");
        System.out.println("<b> Alpro Medical Diagnostic Centre</b>");
        System.out.println("-------------------------------------------");
        
        //getting user input
        Scanner sc = new Scanner(System.in);
        System.out.print("Please input your name : ");
        String name = sc.nextLine();

        System.out.print("Please input your sex ( m / f ) : ");
        String sex = sc.nextLine();
        
        System.out.print("Please input your height ( cm ) : ");
        int height = sc.nextInt();
        sc.nextLine();
        
        System.out.print("Please input your weight ( kg ) : ");
        int weight = sc.nextInt();
        sc.nextLine();
        
        //generating output
        System.out.println("-------------------------------------------");
        
        
        String salutation;
        if(sex.equals("m"))
        {
            salutation = "Mr";
        } else {
            salutation = "Ms";
        }
        
        //computing Body Mass Index (BMI)
        double heightInMeter = height/100.0;
        double bmi = weight/(heightInMeter*heightInMeter);
        String bmiCategory;
        
        // Based on https://www.siloamhospitals.com/en/informasi-siloam/artikel/cara-menghitung-bmi
        if(bmi<18.5)
        {
            bmiCategory = "underweight";
        } else if (bmi>=18.5 && bmi<=24.9)
        {
            bmiCategory = "normal";
        } else if (bmi>=25 && bmi<=29.9)
        {
            bmiCategory = "overweight";
        } else {
            bmiCategory = "obesity";
        }
        
        System.out.println("Customer Name\t: "+salutation + " " + name );
        System.out.println("BMI\t\t: "+bmi);
        System.out.println("Category\t: <b><font color='b'>"+bmiCategory+"</b></font>");
        System.out.println("===========================================");
         
    }
    
    public static void task2(){
        //getting user input
        Scanner sc = new Scanner(System.in);
        System.out.println("Please input your full name \t:");
        String fullName = sc.nextLine();
        System.out.print("Please input your student id \t: ");
        String studentId=sc.nextLine();
        
        //generating output
        System.out.println();
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("<b>Academic Report</b>");
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("Student Id.:"+studentId+"\t\tFullname:"+fullName);
        System.out.println("===============================================================================");
        System.out.println("<b>No.\tCode\tName\t\t\t\tCredit\tGrade\tScore\tW.Score</b>");
        
        //creating a variable of type Scanner
        Scanner scFile = new Scanner(Main.class.getResourceAsStream("transcript.csv"));
        //declare variable to read file per line
        String line;
        //declare array variable of String
        String[] lineSplit;
        
        //initialize varibles to store credits, total credits, and total to 0
        int credit = 0;
        int totalCredit = 0;
        double totalScore = 0;
        
        //declare and initialize the variables
        int no=1;
        String code;
        String course;
        String grade;
        double score;
        double wscore;
        
        // read the file from beginning to the end
        
        while(scFile.hasNext()){
            //read the current line
            line = scFile.nextLine();
            //split the current line by comma and save to an array variables
            lineSplit = line.split(",");
            
            code=lineSplit[0];
            course=lineSplit[1];
            credit =Integer.parseInt(lineSplit[2]);
            grade=lineSplit[3];
            
            //update the total credit by adding the current line credit
            totalCredit = totalCredit+credit;
            
            score= convertGradeToNumeric(grade);
            wscore= score*credit;
            //update the total score by adding the current line weighted score
            totalScore =  totalScore+wscore;
            
            //print out the current line
            System.out.println(no+"\t"+code +"\t"+course+"\t\t"+credit+"\t"+grade+"\t"+score+"\t"+wscore);
            //update varible no by 1
            no+=1;
            
        }
        System.out.println("-------------------------------------------------------------------------------");
        
        double cgpa=totalScore/totalCredit;
        String category="";
        if (cgpa>2.0)  category="passed";
        else category="failed";
        
        System.out.println("\t\t\t CGPA \t:<b>"+cgpa+" ("+category+")</b>");
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println();
    }
     public static double convertGradeToNumeric(String grade){
        switch(grade){
            case "A":
                return 4.0;
            //complete the code here
            case "AB":
                return 3.5;
            case "B":
                return 3.0;
            case "BC":
                return 2.5;
            case "C":
                return 2.0;
            case "D":
                return 1.0;
        }
        return 0.0;
    }
    
    public static void task3(){
        Scanner newIn=new Scanner(Main.class.getResourceAsStream("scores.csv"));
        int loop=newIn.nextInt();
        newIn.nextLine();
        int[] banyak=new int[loop];
        for(int i=0;i<loop;i++){
            banyak[i]=newIn.nextInt();
            newIn.nextLine();
            String[] a=new String[banyak[i]];
            double accumulation=0;
            int LookingFor=0;
            for(int j=0;j<banyak[i];j++){
                a[j]=newIn.nextLine();
                String[] many=a[j].split(",");
                double[] nilai=new double[4];
                //masukkin nilai ke variable baru
                for(int y=2;y<many.length;y++){
                    if(many[y].equals("")){
                        many[y]="0";
                    }
                    nilai[y-2]=Double.parseDouble(many[y]);
                }
                //ngecek nilai yang kosong
                for(int ju=0;ju<nilai.length;ju++){
                    if(nilai[ju]==0){
                        double[] urutan=Arrays.copyOf(nilai,nilai.length);
                        int x=Integer.parseInt(many[0]);
                        if(x%2==0){
                            Arrays.sort(urutan);
                            nilai[ju]=(urutan[1]+urutan[2])/2;
                        }else if(x%2==1){
                            double sum=0;
                            for (int ol=0;ol<nilai.length;ol++){
                                sum+=nilai[ol];
                            }
                            String tellw=Double.toString(sum/3);
                            String olah=tellw.substring(0,4);
                            nilai[ju]=Double.parseDouble(olah);
                        }
                    }
                }
                double accumul=0;
                for(int op=0;op<nilai.length;op++){
                    accumul+=nilai[op];
                }
                double nValue=accumul/4;
                if(nValue>accumulation){
                    accumulation=nValue;
                    LookingFor=j;
                }
                for(int io=2;io<many.length;io++){
                    many[io]=Double.toString(nilai[io-2]);
                }
                a[j]=many[0]+","+many[1]+","+many[2]+","+many[3]+","+many[4]+","+many[5];
            }
            System.out.println("ID Number\t"+"|"+"\tStudent Name\t\t"+"|"+"\tMathematics\t\t"+"|"+"\t\tPhysics\t\t"+"|"+"\tChemistry\t\t"+"|"+"\t\tBiology\t"+"\t|");
            System.out.println("=======================================================================================================================================================================================================");
            for(int as=0;as<a.length;as++){
                String[]splitting=a[as].split(",");
                System.out.println(splitting[0]+"\t\t"+"|"+"\t\t"+splitting[1]+"\t\t"+"|"+"\t\t"+splitting[2]+"\t\t"+"|"+"\t\t"+splitting[3]+"\t\t"+"|"+"\t\t"+splitting[4]+"\t\t"+"|"+"\t\t"+splitting[5]+"\t\t"+"|");
            }
            String[] Splitter=a[LookingFor].split(",");
            System.out.println("====================");
            System.out.println("BEST STUDENT");
            System.out.println("ID Number\t"+"="+Splitter[0]);
            System.out.println("Name\t"+"="+Splitter[1]);
            System.out.println("Average Score\t"+"="+accumulation);
            System.out.println("====================");
        }
    }
}