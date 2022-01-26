package lubusreservation;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileWriter;

public class Admin {
    public void admin() throws FileNotFoundException {
        System.out.println("\n\n\t\t\tADMINS PAGE");
        System.out.println("\t\t______________________________");
        System.out.println("\n\n\t\t1. Sign in.");
        System.out.println("\t\t2. Back.");
        System.out.println("\t\t_________________");
        System.out.print("\t\tEnter your choice: ");
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        switch (n) {
            case 1:
                login();
                break;

            case 2:
                FirstPage fp = new FirstPage();
                fp.firstpage();
                break;
        }
    }
    public void login(){
        Scanner sc=new Scanner(System.in);

        System.out.println("\n\nEnter User Name: ");
        String Uname=sc.nextLine();


        System.out.println("\nEnter Password: ");
        String Pass=sc.nextLine();

        Uname=Uname.trim();
        Pass=Pass.trim();
        String x= Uname+" "+Pass;


        try {

            File f = new File("AdminRegistration.txt");
            Scanner content = new Scanner(f);
            int flag=0;
            while (content.hasNextLine()) {
                String data = content.nextLine();
                if(data.equals(x))
                {
                    System.out.println("\n\n\t\t\tLogin Successful");
                    System.out.println("\n\n\t\t\tWelcome to the Lu Bus Reservation Program.");
                    flag=1;
                    break;

                }
            }
            if(flag==1){
                adminPannel();
            }
            else if(flag==0)
            {
                System.out.println("\n\nLogin Failed");
                System.out.println("\n\n1. Login. ");


                System.out.print("\nEnter your Choice: ");
                int choice=sc.nextInt();
                if(choice==1)
                {
                    this.login();
                }

                else
                {
                    System.out.println("\n\t\t\tChoose Proper Option");
                }
            }

            //content.close();
        }
        catch (FileNotFoundException e) {


            System.out.println("Error.");
            e.printStackTrace();
        }

        sc.close();
    }


    public void adminPannel(){

        System.out.println("\n\n\n\t\t\t===Admin Pannel===\n\n");
        System.out.println("1. Check seat reservation update.");
        System.out.println("2. Off schedule reservation update.");
        System.out.println("3. Go back.");
        System.out.println("----------------------------------------");
        System.out.print("Choose your option: ");
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        switch (n){

            case 1:
               sru();
               break;

            case 2:
                List k = readFileInList("offschedule.txt");

                Iterator<String> itr = k.iterator();
                while (itr.hasNext())
                    System.out.println("\n\n"+itr.next());
                System.out.print("\n\nEnter 1 to go back: ");
                int c = input.nextInt();
                if(c==1){adminPannel();}
                break;

            case 3:
                try{admin();}catch (IOException e){
                    System.out.println("exception");
                }
                break;

                }
        }

        public void sru(){

            System.out.println("\n\n\n\t\t\t===Reserved seat===");
            System.out.println("1. Route 1");
            System.out.println("2. Route 2");
            System.out.println("3. Route 3");
            System.out.println("4. Route 4");
            System.out.println("5. Go back");
            System.out.println("------------------------");
            System.out.print("Choose your option: ");
            Scanner input = new Scanner(System.in);
            int n1 = input.nextInt();

            switch (n1){

                case 1:
                    System.out.println("\n\n\n\t\t\t===Select Time===");
                    System.out.println("1. 12.00 pm ");
                    System.out.println("2. 2.00 pm ");
                    System.out.println("3. 2.45 pm ");
                    System.out.println("4. 4.00 pm ");
                    System.out.println("5. Back ");
                    System.out.println("----------------------");
                    System.out.print("Choose your option: ");
                    int p1 = input.nextInt();

                    switch (p1){

                        case 1:
                            List l = readFileInList("rootOne/12pm.txt");

                            Iterator<String> itr1 = l.iterator();
                            while (itr1.hasNext())
                                System.out.println("\n\n"+itr1.next());
                            System.out.print("\n\nEnter 1 to go back: ");
                            int b = input.nextInt();
                            if(b==1){sru();}
                            break;

                        case 2:
                            List k = readFileInList("rootOne/2pm.txt");

                            Iterator<String> itr2 = k.iterator();
                            while (itr2.hasNext())
                                System.out.println("\n\n"+itr2.next());
                            System.out.print("\n\nEnter 1 to go back: ");
                            int c = input.nextInt();
                            if(c==1){sru();}
                            break;

                        case 3:
                            List m = readFileInList("rootOne/2.45pm.txt");

                            Iterator<String> itr3 = m.iterator();
                            while (itr3.hasNext())
                                System.out.println("\n\n"+itr3.next());
                            System.out.print("\n\nEnter 1 to go back: ");
                            int d = input.nextInt();
                            if(d==1){sru();}
                            break;

                        case 4:
                            List o = readFileInList("rootOne/4pm.txt");

                            Iterator<String> itr4 = o.iterator();
                            while (itr4.hasNext())
                                System.out.println("\n\n"+itr4.next());
                            System.out.print("\n\nEnter 1 to go back: ");
                            int f = input.nextInt();
                            if(f==1){sru();}
                            break;

                        case 5:
                            sru();
                            break;
                    }


                case 2:
                    System.out.println("\n\n\n\t\t\t===Select Time===");
                    System.out.println("1. 12.00 pm ");
                    System.out.println("2. 2.00 pm ");
                    System.out.println("3. 2.45 pm ");
                    System.out.println("4. 4.00 pm ");
                    System.out.println("5. Back ");
                    System.out.println("----------------------");
                    System.out.print("Choose your option: ");
                    int p2 = input.nextInt();

                    switch (p2){

                        case 1:
                            List l = readFileInList("rootTwo/12pm.txt");

                            Iterator<String> itr1 = l.iterator();
                            while (itr1.hasNext())
                                System.out.println("\n\n"+itr1.next());
                            System.out.print("\n\nEnter 1 to go back: ");
                            int b = input.nextInt();
                            if(b==1){sru();}
                            break;

                        case 2:
                            List k = readFileInList("rootTwo/2pm.txt");

                            Iterator<String> itr2 = k.iterator();
                            while (itr2.hasNext())
                                System.out.println("\n\n"+itr2.next());
                            System.out.print("\n\nEnter 1 to go back: ");
                            int c = input.nextInt();
                            if(c==1){sru();}
                            break;

                        case 3:
                            List m = readFileInList("rootTwo/2.45pm.txt");

                            Iterator<String> itr3 = m.iterator();
                            while (itr3.hasNext())
                                System.out.println("\n\n"+itr3.next());
                            System.out.print("\n\nEnter 1 to go back: ");
                            int d = input.nextInt();
                            if(d==1){sru();}
                            break;

                        case 4:
                            List o = readFileInList("rootTwo/4pm.txt");

                            Iterator<String> itr4 = o.iterator();
                            while (itr4.hasNext())
                                System.out.println("\n\n"+itr4.next());
                            System.out.print("\n\nEnter 1 to go back: ");
                            int f = input.nextInt();
                            if(f==1){sru();}
                            break;

                        case 5:
                            sru();
                            break;
                    }

                case 3:
                    System.out.println("\n\n\n\t\t\t===Select Time===");
                    System.out.println("1. 12.00 pm ");
                    System.out.println("2. 2.00 pm ");
                    System.out.println("3. 2.45 pm ");
                    System.out.println("4. 4.00 pm ");
                    System.out.println("5. Back ");
                    System.out.println("----------------------");
                    System.out.print("Choose your option: ");
                    int p3 = input.nextInt();

                    switch (p3){

                        case 1:
                            List l = readFileInList("rootThree/12pm.txt");

                            Iterator<String> itr1 = l.iterator();
                            while (itr1.hasNext())
                                System.out.println("\n\n"+itr1.next());
                            System.out.print("\n\nEnter 1 to go back: ");
                            int b = input.nextInt();
                            if(b==1){sru();}
                            break;

                        case 2:
                            List k = readFileInList("rootThree/2pm.txt");

                            Iterator<String> itr2 = k.iterator();
                            while (itr2.hasNext())
                                System.out.println("\n\n"+itr2.next());
                            System.out.print("\n\nEnter 1 to go back: ");
                            int c = input.nextInt();
                            if(c==1){sru();}
                            break;

                        case 3:
                            List m = readFileInList("rootThree/2.45pm.txt");

                            Iterator<String> itr3 = m.iterator();
                            while (itr3.hasNext())
                                System.out.println("\n\n"+itr3.next());
                            System.out.print("\n\nEnter 1 to go back: ");
                            int d = input.nextInt();
                            if(d==1){sru();}
                            break;

                        case 4:
                            List o = readFileInList("rootThree/4pm.txt");

                            Iterator<String> itr4 = o.iterator();
                            while (itr4.hasNext())
                                System.out.println("\n\n"+itr4.next());
                            System.out.print("\n\nEnter 1 to go back: ");
                            int f = input.nextInt();
                            if(f==1){sru();}
                            break;

                        case 5:
                            sru();
                            break;
                    }

                case 4:
                    System.out.println("\n\n\n\t\t\t===Select Time===");
                    System.out.println("1. 12.00 pm ");
                    System.out.println("2. 2.00 pm ");
                    System.out.println("3. 2.45 pm ");
                    System.out.println("4. 4.00 pm ");
                    System.out.println("5. Back ");
                    System.out.println("----------------------");
                    System.out.print("Choose your option: ");
                    int p4 = input.nextInt();

                    switch (p4){

                        case 1:
                            List l = readFileInList("rootFour/12pm.txt");

                            Iterator<String> itr1 = l.iterator();
                            while (itr1.hasNext())
                                System.out.println("\n\n"+itr1.next());
                            System.out.print("\n\nEnter 1 to go back: ");
                            int b = input.nextInt();
                            if(b==1){sru();}
                            break;

                        case 2:
                            List k = readFileInList("rootFour/2pm.txt");

                            Iterator<String> itr2 = k.iterator();
                            while (itr2.hasNext())
                                System.out.println("\n\n"+itr2.next());
                            System.out.print("\n\nEnter 1 to go back: ");
                            int c = input.nextInt();
                            if(c==1){sru();}
                            break;

                        case 3:
                            List m = readFileInList("rootFour/2.45pm.txt");

                            Iterator<String> itr3 = m.iterator();
                            while (itr3.hasNext())
                                System.out.println("\n\n"+itr3.next());
                            System.out.print("\n\nEnter 1 to go back: ");
                            int d = input.nextInt();
                            if(d==1){sru();}
                            break;

                        case 4:
                            List o = readFileInList("rootFour/4pm.txt");

                            Iterator<String> itr4 = o.iterator();
                            while (itr4.hasNext())
                                System.out.println("\n\n"+itr4.next());
                            System.out.print("\n\nEnter 1 to go back: ");
                            int f = input.nextInt();
                            if(f==1){sru();}
                            break;

                        case 5:
                            sru();
                            break;
                    }

                case 5:
                    adminPannel();
                    break;

            }
    }

    //method for read file.
    public static List<String> readFileInList(String fileName)
    {

        List<String> lines = Collections.emptyList();
        try
        {
            lines =
                    Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
        }

        catch (IOException e)
        {
            System.out.println("exception");
            e.printStackTrace();
        }
        return lines;
    }
}
