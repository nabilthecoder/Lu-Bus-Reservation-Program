package lubusreservation;
import java.util.Scanner;
import java.io.IOException;
import java.io.FileNotFoundException;
public class FirstPage {
    void firstpage() throws FileNotFoundException{
        System.out.println("\n\n\t\t\tWELCOME TO LU BUS RESERVATION PROGRAM");
        System.out.println("\t\t______________________________________________");
        System.out.println("\n\t\t1. Student.");
        System.out.println("\t\t2. Bus driver.");
        System.out.println("\t\t3. Admin.");
        System.out.println("\t\t4. Exit the program.");
        System.out.println("\t\t----------------------------");
        System.out.print("\n\t\tPlease enter your choice: ");
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        switch (n){
            case 1:
                Student st = new Student();
                st.student();
                break;
            case 2:
                BusDriver bd = new BusDriver();
                bd.busDriver();
                break;
            case 3:
                Admin admin = new Admin();
                admin.admin();
                break;
            case 4:
                System.out.println("\n\t\tThank you for using this program...");
                System.exit(0);
                break;
        }
    }
}
