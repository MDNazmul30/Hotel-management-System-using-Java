
package newpro;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.*;
import java.util.Calendar;
import java.util.Date;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Formatter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.ArrayList;
import java.util.Scanner;




  class Hospital{
      private  String Hname;
      private  String Haddress;
      private  Medicineshop medicine;
      private int numberOfperson;
      private  Person[]personlist;
      private  Calendar datecreated;
       Hospital(){
       
   }
   Hospital(String Hname ,String Haddress){
       this.Hname=Hname;
       this.Haddress=Haddress;
       datecreated= Calendar.getInstance();
   }
       public void setHname(String Hname){
           this.Hname=Hname;
       }
       public void setHaddress(String Haddress){
           this.Haddress=Haddress;
       }
 
       public void setpersonlist(Person[]personlist){
           this.personlist=personlist;
       }
       public void setMedicine(Medicineshop medicine){
           this.medicine=medicine;
       }
       public String getHname(){
           return Hname;
       }
       public String getHaddress(){
           return Haddress;
       }
       public Person[] getpersonlist(){
           return personlist;
       }
       public Date getdate()
       {
           return datecreated.getTime();
       }
       public Medicineshop getmedicine(){
           return medicine;
       }
       public String toString(){
           return "Hospital Name:"+Hname+" , "+Haddress;
       }
           public void addPerson(Person person) {
        this.numberOfperson += 1;
        this.personlist[this.numberOfperson] = person;
        System.out.println("Person added!!");
    }
           
    public void dropperson(int personID) {
        boolean dropped = false;

        for (int i = 0; i < this.numberOfperson; i++) {
            if (this.personlist[i].getpid() == personID) {
                Person [] temp = new Person[this.numberOfperson - 1];

                for (int y = 0; y < this.numberOfperson; y++) {
                    if (y == i) {
                        continue;
                    }

                    else
                        temp[y] = this.personlist[y];
                }

                this.personlist = temp;

                System.out.println("Student with ID " + personID + " successfully dropped!!");
                dropped = true;

                this.numberOfperson = this.numberOfperson - 1;

                break;
            }
        }

        if (dropped == false) {
            System.out.println("Sorry! This Person either does not exist or has already been deleted!");
        }
    }
        public void addmedicine(Medicineshop medicine)
    {
     
    }

    public void dropmedicine() {
        this.medicine = null;
    }

  }
   class Person{
       int pid;
       String pname;
       String address;
       int age;
       String gender;
       String phonnumber;
   Person()
    {
        
    }
    
   Person(int pid,String pname,String address,String gender,int age,String phonenumber){
        this.pid=pid;
       this.pname=pname;
        this.address=address;
        this.age=age;
        this.gender=gender;
        this.phonnumber=phonenumber;
      }  
     public void setpid(int pid){
        this.address=address;
    }
     public void setpname(String pname){
        this.pname=pname;
    }
    public void setaddress(String address){
        this.address=address;
    }
    public void setgender(String gender){
        this.gender=gender;
    }
    public void setage(int age){
        this.age=age;
    }
     public void setphonnumber(String phonnumber){
        this.phonnumber=phonnumber;
    }
     public int getpid(){
        return pid;
    }
    public String getpname(){
        return pname;
    }
    public String getaddress(){
        return address;
    }
    public String getgender(){
        return gender;
    }
     public int getage(){
        return age;
    }
     public String getphonnumber(){
        return phonnumber;
    }
    public String toString(){
        return"person id"+pid+"Person name"+pname+"Person address"+address+"person age"+age+"person gender"+gender +"Person phonnumber"+phonnumber;
    }
}
class Medicineshop{
   private   String medid;
   private   String medname;
   private  String medcomp;
   private  double medcost;
        Medicineshop(String medid,String medname,String medcomp,double medcost){
        this.medid=medid;
        this.medname=medname;
        this.medcomp=medcomp;
        this.medcost=medcost;
      
        }     
    
    public void setmedid(String medid){
        this.medid=medid;
    }
    public void setmedname(String medname){
        this.medname=medname;
    }
    public void setmedcomp(String medcomp){
        this.medcomp=medcomp;
    }
    public void setmedcost(double medcost){
        this.medcost=medcost;
    }
    public String getmedid(){
        return medid;
    }
    public String getmedname(){
        return medname;
    }
    public String getmedcomp(){
        return medcomp;
    }
     public double getmedcost(){
        return medcost;
    }
}
    class Staff extends Person {
          private String profname;
        Staff(int pid,String pname,String address,String gender,int age,String phonenumber,String profname){
        super(pid,pname,address,gender,age,phonenumber);
        this.profname=profname;
        
    }
         public String getprofname(){
        return profname;
    }
      
     public String toString(){
        return"staff id"+pid+"Staff name"+pname+"Staff address"+address+"Staff age"+age+"Staff gender"+gender +"Staff phonnumber"+phonnumber+
                "Staff profation name "+profname;
 
     }
}
    class Doctor extends Person{
      
        int droom;
        String degree;
        String speacialist;
       Doctor(int pid,String pname,String address,String gender,int age,String phonenumber,int droom,String degree,String speacialist){
        super(pid,pname,address,gender,age,phonenumber);
        
           this.droom=droom;
           this.degree=degree;
           this.speacialist=speacialist;
       }
       public int getdroom(){
        return droom;
    }
        public String getdegree(){
        return degree;
    }
         public String getspeacialist(){
        return speacialist;
    }
        public String toString(){
        return"Doctor id "+pid+"Doctor room"+droom+"Doctor degree"+degree+"speacialist"+speacialist+"Doctor name"+pname+"Doctor address"+
                address+"Doctor age"+age+"Doctor gender"+gender +"Doctor phonnumber"+phonnumber;
              
    }
    }
        
 abstract class Patient extends Person{
   
    protected String diseasename;
    protected int labfee,medicinefee;
     Calendar dateCreated;
    
Patient(int pid,String pname,String address,String gender,int age,String phonenumber,
        String diseasename,int labfee,int medicinefee ){
   super(pid,pname,address,gender,age,phonenumber);
     
       this.diseasename=diseasename;
       this.labfee=labfee;
       this.medicinefee=medicinefee;
       this.dateCreated = Calendar.getInstance();

      
}

  public void scheduleAppointment(List<Doctor> doctors, int pid, String appointmentDate,String appointmentTime) {
    for (Doctor doctor : doctors) {
      if (doctor.getpid() == pid) {
        // schedule appointment with selected doctor
        System.out.println("Appointment scheduled with doctor " + doctor.getpname() + " on :" + appointmentDate+
                " And The Time is:"+appointmentTime);
        break;
      }
    }
  }

  public Calendar getate() {
    return this.dateCreated;
  }
public abstract int totalfee();

} 
 class  Indoorpatient extends Patient{
    int bedfee,foodfee, visitingfee;
   Indoorpatient(int pid,String pname,String address,String gender,int age,String phonenumber,
        String diseasename,int labfee,int medicinefee,int visitingfee,int bedfee,int foodfee ){
        super(pid,pname,address,gender,age,phonenumber,diseasename,labfee,medicinefee);
        this.bedfee=bedfee;
        this.foodfee=foodfee;
        this.visitingfee=visitingfee;
   
   }
    @Override
public int totalfee(){
    int totalfee=labfee+medicinefee+visitingfee+bedfee+foodfee;
    return totalfee;
}
}
class Outdoorpatient extends Patient{
    int visitingfee;
    Outdoorpatient(int pid,String pname,String address,String gender,int age,String phonenumber,
        String diseasename,int labfee,int medicinefee,int visitingfee){
        super(pid,pname,address,gender,age,phonenumber,diseasename,labfee,medicinefee);

        this.visitingfee=visitingfee;
    }
      @Override
public int totalfee(){
    int totalfee=labfee+medicinefee+visitingfee;
    return totalfee;
}
    
}
public class Newpro {

   
    public static void main(String[] args) throws IOException {
       ArrayList<Doctor> doctors = new ArrayList<>();
       ArrayList<Staff> stf = new ArrayList<>();
       ArrayList<Indoorpatient > indp = new ArrayList<>();
       ArrayList<Outdoorpatient > outp = new ArrayList<>();
       ArrayList<Hospital > hos = new ArrayList<>();




 Scanner inp = new Scanner(System.in);
        int input;

                      Hospital c= new Hospital();
                      c.setHname("Square Hospital");
                      c.setHaddress("afftabnogor,Rampura.");

 System.out.print("\n**********Hospital Management System**********\n");
        System.out.println(c.toString());
int passCount = 1;
while (passCount < 4) {
System.out.print("\nLOG IN AS ADMIN\n"); 
System.out.println("\n(Username: admin\tPassword: 1234)\n");

System.out.print("Enter Username: ");
String user = inp.nextLine();
System.out.print("Password: ");
String password = inp.nextLine();
if (user.equalsIgnoreCase("admin") && password.equals("1234")) {      
        while(true)
        {
           System.out.println("Press 1 for add Doctor information:");
           System.out.println("Press 2 for add staff information:");
           System.out.println("Press 3 for show doctor  information:");
           System.out.println("Press 4 for add  patient information:");
           System.out.println("Press 5 for show patient infermation:");
           System.out.println("Press 6 for patipent bill");
           System.out.println("press 7 For  appointment:");

           System.out.println("Enter Option:");
            input= inp.nextInt();      
               if(input==1)
           {
        doctors.add(new Doctor(1, "Dr.jahangir kobir", "123 Main St", "Male   ", 30,"123-456-7890",101, "M.B.B.s", "Cardiology"));
        doctors.add(new Doctor(2, "   Dr.Abul kalam  ", "456 Park Ave", "Male", 35, "456-789-0123", 102, "M.b.b.s", "Pediatrics"));
        doctors.add(new Doctor(3, "  Dr.Ruhul amin   ", "789 Maple St", "Male  ", 40, "789-012-3456", 103, "M.B.B.S", "  Surgery  "));
               System.out.println("Doctor added");
        
        // Write the information of each Doctor object to a file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Doctor.txt"))) {
          writer.write( " id .....\"     name     \"........\"   address   \".........\" Gender \".......\"Age\"........\"   phonenumber   \".......\"room\".......\"Degree\"........\"Specialist\" ");

            for (Doctor doctor : doctors) {
                writer.write("\n");
                writer.write(doctor.getpid() +"------");
                writer.write(doctor.getpname()+"------");
                writer.write(doctor.getaddress()+"------" );
                writer.write(doctor.getgender() + "-------");
                writer.write(doctor.getage() + "------");
                writer.write(doctor.getphonnumber() + "------");
                writer.write(doctor.getdroom() + "-------");
                writer.write(doctor.getdegree() + "-------");
                writer.write(doctor.getspeacialist() + " ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
     } 

            
               if (input==2){
                       {
        stf.add(new Staff(1, " Md.Hasan", "cumilla,debidwar ", "Male", 30,"01572095325", " Accountent"));
        stf.add(new Staff(2, " Md.Habib ", "11 mirpur,Dhaka", "Male", 35, "01572095327",  "  word boy  "));
        stf.add(new Staff(3, " Md.kamal ", " uttara sector:8 ", "Male",40, "01572095326", "  cleaner  "));
                       System.out.println("Staff added");

        
        // Write the information of each Staff object to a file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Staff.txt"))) {
              writer.write( " id .....\"     name     \"........\"   address   \".........\" Gender \".......\"Age\"........\"   phonenumber   \".......\"profetionname\"");

            for (Staff stfs : stf) {
                 writer.write("\n");
                writer.write(stfs.getpid() +" -------");
                writer.write(stfs.getpname()+" -------");
                writer.write(stfs.getaddress()+" -------" );
                writer.write(stfs.getgender() +" -------");
                writer.write(stfs.getage() + " -------");
                writer.write(stfs.getphonnumber() +" -------");               
                writer.write(stfs.getprofname() + " ");
            }
        } 
    }
  }                      
        if(input==3){
          try {
      // Open the file for reading
      BufferedReader reader = new BufferedReader(new FileReader("Person.txt"));

      // Read the contents of the file line by line
      String line = reader.readLine();
      while (line != null) {
        System.out.println(line);
        line = reader.readLine();
      }

      // Close the reader when we're done
      reader.close();
    } catch (IOException e) {
      System.out.println("An error occurred while reading the file: " + e.getMessage());
    }
  }
         if(input==4){
int input1;
System.out.print("\n Where do you want to enroll....press 1 for Indoor press 2 for outdoor: ");
 input1 = inp.nextInt();
if(input1==1){
try {

java.io.File file = new java.io.File("Indoorpatient.txt");     
java.io.FileWriter fw = new FileWriter(file, true);   
try (java.io.BufferedWriter bw = new java.io.BufferedWriter(fw)) {

int exitCount = 1;
while (exitCount == 1) {

System.out.print("\nHow many patient you want to add: ");
Scanner inp1 = new Scanner(System.in);
int n = inp1.nextInt(); 
fw.write( " id ....name....address.....gender.....age.....phonenumber......diseadename.....labfee.....Medicinefee......Bedfee.....foodfee.....Visitingfee\n");

for (int i = 1; i <= n; i++) {

 Scanner sc=new Scanner(System.in);
                    System.out.print("Enter id:");
          int pid =  sc.nextInt();
                    System.out.print("Enter Name:");
        String pname = sc.next();
                  System.out.print("Enter Address:");
        String address = sc.next();
                  System.out.print("Enter Gender:");
        String gender = sc.next();
                  System.out.print("Enter Age:");
        int age = sc.nextInt();
                  System.out.print("Enter Phonenumber:");
        String phonenumber = sc.next();
                  System.out.print("Enter diseadename:");
        String diseasename = sc.next();
                  System.out.print("Enter labfee:");
        int labfee =sc.nextInt();
                  System.out.print("Enter Medicinefee:");
        int medicinefee =sc.nextInt();
                  System.out.print("Enter Bedfee:");
        int bedfee =sc.nextInt();
                  System.out.print("Enter foodfee:");
        int foodfee =sc.nextInt();
                  System.out.print("Enter Visitingfee:");
        int visitingfee =sc.nextInt();

              
             Indoorpatient f= new Indoorpatient(pid,pname,address,gender,age,phonenumber,diseasename,
                      labfee,medicinefee,bedfee,foodfee, visitingfee); 
              indp.add(f);
              bw.write(pid+"     "+pname+"     "+address+"     "+gender+"     "+
                      age+"     "+phonenumber+"     "+diseasename+"     "+labfee+"     "+
                      medicinefee+"     "+bedfee+"     "+foodfee+"     "+visitingfee+"\t\t\n"); // writing the above given data to the text file
bw.newLine();

}

bw.close();
System.out.println("\nPress '1' to exit\t Press any other key to continue");
exitCount = inp.nextInt();
    switch (exitCount) {
        
        case 1 -> {
           System.exit(0);
        }
      default ->{;
      }
    }

}
}

} catch (IOException e) { 
System.out.println("\nINVALID INPUT, Please Enter an Integer\n");


          }

        }
if(input1==2){
    try {

java.io.File file = new java.io.File("Outdoorpatient.txt");     
java.io.FileWriter fw = new FileWriter(file, true);   
try (java.io.BufferedWriter bw = new java.io.BufferedWriter(fw)) {

int exitCount = 1;
while (exitCount == 1) {

System.out.print("\nHow many patient you want to add: ");
Scanner inp1 = new Scanner(System.in);
int n = inp1.nextInt(); //gets an integer as number of students
fw.write( " id ....name....address.....gender.....age.....phonenumber......diseadename.....labfee.....Medicinefee......Visitingfee\n");
for (int i = 1; i <= n; i++) {

 Scanner sc=new Scanner(System.in);
                    System.out.print("Enter id:");
          int pid =  sc.nextInt();
                    System.out.print("Enter Name:");
        String pname = sc.next();
                  System.out.print("Enter Address:");
        String address = sc.next();
                  System.out.print("Enter Gender:");
        String gender = sc.next();
                  System.out.print("Enter Age:");
        int age = sc.nextInt();
                  System.out.print("Enter Phonenumber:");
        String phonenumber = sc.next();
                  System.out.print("Enter diseadename:");
        String diseasename = sc.next();
                  System.out.print("Enter labfee:");
        int labfee =sc.nextInt();
                  System.out.print("Enter Medicinefee:");
        int medicinefee =sc.nextInt();
                  System.out.print("Enter Visitingfee:");
        int visitingfee =sc.nextInt();
              
   Outdoorpatient g=new Outdoorpatient(pid,pname,address,gender,age,phonenumber,diseasename,
                     labfee,medicinefee,visitingfee);
              outp.add(g);
              
   bw.write(pid+ "     " +pname + "     "+address+"     "+gender+"     "+
                      age+"     "+phonenumber+"     "+diseasename+"     "+labfee+"     "+
                      medicinefee+"      "+visitingfee+"\t\t\n"); 
bw.newLine();

}

bw.close();
System.out.println("\nPress '1' to exit\t Press any other key to continue");
exitCount = inp.nextInt();
    switch (exitCount) {
        
        case 1 -> {
           System.exit(0);
        }
      default ->{;
      }
    }

}
}

} catch (IOException e) { 
System.out.println("\nINVALID INPUT, Please Enter an Integer\n");


          }

        }
  
 }
                       if(input==5){//Press 5 for show patient infermation:
                           
             int input1;
System.out.print("\n What kind of patientlist do you want to see: press 1 for Indoor press 2 for outdoor: ");
             input1 = inp.nextInt();
       if(input1==1){
             try {
      // Open the file for reading
      BufferedReader reader = new BufferedReader(new FileReader("Indoorpatient.txt"));

      // Read the contents of the file line by line
      String line = reader.readLine();
      while (line != null) {
        System.out.println(line);
        line = reader.readLine();
      }

      // Close the reader when we're done
      reader.close();
    } catch (IOException e) {
      System.out.println("An error occurred while reading the file: " + e.getMessage());
    }
    }
    if(input1==2){
             try {
      // Open the file for reading
      BufferedReader reader = new BufferedReader(new FileReader("Outdoorpatient.txt"));

      // Read the contents of the file line by line
      String line = reader.readLine();
      while (line != null) {
        System.out.println(line);
        line = reader.readLine();
      }

      // Close the reader when we're done
      reader.close();
    } catch (IOException e) {
      System.out.println("An error occurred while reading the file: " + e.getMessage());
    }
    }
    else{
        System.out.println("YOU ENTER WRONG KEY");
    }
    }
                     if(input==6){
                         
                     
    int input1;
    System.out.print("\n The type of patientbill you want to see: press 1 for Indoor press 2 for outdoor: ");
    input1 = inp.nextInt();
    if(input1==1){
    // Prompt the user for the patient's ID
    System.out.print("Enter the patient's ID: ");
    int patientId = inp.nextInt();

                        for(int j=0;j<indp.size();j++)
                        {
                            if(indp.get(j).getpid()==patientId)
                            {
                                System.out.println(indp.get(j).getpid()+ ": " + "Totalbill: "+indp.get(j).totalfee());
                }else{
                                System.out.println("Don't match id");
                            }

                        
                        try {
  FileWriter fw = new FileWriter("Indoorpatient_bills.txt", true);
  BufferedWriter bw = new BufferedWriter(fw);
  bw.write("Total bill for patient with ID " + indp.get(j).getpid()+ ": " + indp.get(j).totalfee()+ "\n");
  bw.close();
  fw.close();
} catch (IOException e) {
  System.out.println("An error occurred while writing to the file: " + e.getMessage());
}
                        }
    }
    if(input1==2){
        System.out.print("Enter the patient's ID: ");
    int patientId = inp.nextInt();

                        for(int j=0;j<outp.size();j++)
                        {
                            if(outp.get(j).getpid()==patientId)
                            {
                                System.out.println(outp.get(j).getpid()+ " Id patient  " + "Totalbill: "+outp.get(j).totalfee());
                }else{
                                System.out.println("Don't match id");
                            }

                        
                        try {
  FileWriter fw = new FileWriter("Outdoorpatient_bills.txt", true);
  BufferedWriter bw = new BufferedWriter(fw);
  bw.write("Total bill for patient with ID " + outp.get(j).getpid()+ ": " + outp.get(j).totalfee()+ "\n");
  bw.close();
  fw.close();
} catch (IOException e) {
  System.out.println("An error occurred while writing to the file: " + e.getMessage());
    }
                     }
    }
   
                     }          
                       if (input==7){ 
                       int input1;
    System.out.print("\n Where do you want to enroll....press 1 for Indoor press 2 for outdoor: ");
    input1 = inp.nextInt();
    if(input1==1){     
   Calendar calendar = Calendar.getInstance();
   Date currentDate = calendar.getTime();
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    String formattedDate = dateFormat.format(currentDate);
    SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
    String formattedTime = timeFormat.format(currentDate);
 doctors.add(new Doctor(1, "John", "123 Main St", "Male   ", 30,"123-456-7890",101, "M.B.B.s", "Cardiology"));
        doctors.add(new Doctor(2, "Jane", "456 Park Ave", "Female", 35, "456-789-0123", 102, "M.b.b.s", "Pediatrics"));
        doctors.add(new Doctor(3, "Bob", "789 Maple St", "Male  ", 40, "789-012-3456", 103, "M.B.B.S", "  Surgery  "));
Indoorpatient patient = new Indoorpatient(1, "forhad", "789 Main St", "Male", 45, "555-555-1214", "Cold", 100, 200, 300, 400, 500);

patient.scheduleAppointment(doctors, 1, formattedDate, formattedTime);
   }
                       
                    if(input1==2){
                          Calendar calendar = Calendar.getInstance();
    Date currentDate = calendar.getTime();
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    String formattedDate = dateFormat.format(currentDate);
    SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
    String formattedTime = timeFormat.format(currentDate);
 doctors.add(new Doctor(1, "Dr.John", "123 Main St", "Male   ", 30,"123-456-7890",101, "M.B.B.s", "Cardiology"));
        doctors.add(new Doctor(2, "Dr.kamal", "456 Park Ave", "Male", 35, "456-789-0123", 102, "M.b.b.s", "Pediatrics"));
        doctors.add(new Doctor(3, "Dr.Ramim", "789 Maple St", "Male  ", 40, "789-012-3456", 103, "M.B.B.S", "  Surgery  "));
Outdoorpatient patient = new Outdoorpatient(1, "Bob Smith", "789 Main St", "Male", 45, "555-555-1214", "Cold", 100, 400, 500);

patient.scheduleAppointment(doctors, 1, formattedDate, formattedTime);
                    } 
                       }

}
}
}
}

}


    
  
