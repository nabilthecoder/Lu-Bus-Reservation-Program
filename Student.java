package lubusreservation;
import java.util.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;

public class Student {
    public void student() throws FileNotFoundException{
        System.out.println("\n\n\t\t\tSTUDENTS PAGE");
        System.out.println("\t\t______________________________");
        System.out.println("\n\n\t\t1. Login.");
        System.out.println("\t\t2. Registration.");
        System.out.println("\t\t3. Back.");
        System.out.println("\t\t_________________");
        System.out.print("\t\tEnter your choice: ");
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        switch (n) {
            case 1:
                login1();
                break;
            case 2:
                register() ;
                break;
            case 3:
                FirstPage fp = new FirstPage();
                fp.firstpage();
                break;
        }
    }
    public void login1(){
        Scanner sc=new Scanner(System.in);

        System.out.println("\n\nEnter User Name: ");
        String Uname=sc.nextLine();


        System.out.println("\nEnter Password: ");
        String Pass=sc.nextLine();

        Uname=Uname.trim();
        Pass=Pass.trim();
        String x= Uname+" "+Pass;


        try {

            File f = new File("StudentRegistration1.txt");
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
                seatBooking();
            }
            else if(flag==0)
            {
                System.out.println("\n\nLogin Failed");
                System.out.println("\n\n1. Registration. ");
                System.out.println("\t\t\t2. Login. ");

                System.out.print("\nEnter your Choice: ");
                int choice=sc.nextInt();
                if(choice==1)
                {
                    this.register();
                }
                else if(choice==2)
                {
                    this.login1();
                }
                else
                {
                    System.out.println("\n\t\t\tChoose Proper Option");
                }
            }

            content.close();
        }
        catch (FileNotFoundException e) {


            System.out.println("Error.");
            e.printStackTrace();
        }

        sc.close();
    }

    private void register() throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);

        System.out.println("\n\nEnter User Name: ");
        String Uname = sc.nextLine();

        System.out.println("\nEnter Password: ");
        String Pass = sc.nextLine();

        System.out.println("\nConfirm Password: ");
        String ConPass = sc.nextLine();
        Uname = Uname.trim();
        Pass = Pass.trim();
        ConPass = ConPass.trim();

        String x = Uname + " " + Pass;
        if (Pass.equals(ConPass)) {

            File f = new File("StudentRegistration1.txt");
            Scanner content = new Scanner(f);


            int flag = 0;
            while (content.hasNextLine()) {
                String data = content.nextLine();
                if (data.equals(x)) {
                    System.out.println("\n\n\t\t\tAlready Registered");
                    flag = 1;
                    System.out.println("\n\n\t\t\t1. Registration. ");
                    System.out.println("\t\t\t2. Login. ");

                    System.out.print("\n\t\t\tEnter your Choice: ");
                    int choice = sc.nextInt();
                    if (choice == 1) {
                        this.register();
                    } else if (choice == 2) {
                        this.login1();
                    } else {
                        System.out.println("Choose Proper Option");
                    }
                    break;
                }
                //content.close();
            }
            if (flag == 0) {
                try {
                    BufferedWriter out = new BufferedWriter(new FileWriter("StudentRegistration1.txt", true));
                    out.write(Uname + " " + Pass + "\n");
                    out.close();
                } catch (IOException e) {
                    System.out.println("exception occoured" + e);
                }

                System.out.println("\n\n\t\t\tSuccessfully Registered");
                System.out.println("\n\n\t\t\tPlease login");
                this.login1();
            }


        } else {
            System.out.println("Recheck");
            System.out.println("1. Registration. ");
            System.out.println("2. Login. ");

            System.out.print("Enter your Choice: ");
            int choice = sc.nextInt();
            if (choice == 1) {
                this.register();
            } else if (choice == 2) {
                this.login1();
            } else {
                System.out.println("Choose Proper Option");
            }
        }
        //content.close()
        sc.close();
    }


    public void seatBooking(){

        System.out.println("\n\n\n\t\t\t=====Reserve your seat=====");
        System.out.println("1. Route 1");
        System.out.println("2. Route 2");
        System.out.println("3. Route 3");
        System.out.println("4. Route 4");
        System.out.println("5. See seat vaccancy");
        System.out.println("6. Go back");
        System.out.println("------------------------");
        System.out.print("Choose your option: ");
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        switch (n){
            case 1:
                System.out.println("\n\n\n\t\t\t===Choose your schedule===");
                System.out.println("1. 12.00 pm ");
                System.out.println("2. 2.00 pm ");
                System.out.println("3. 2.45 pm ");
                System.out.println("4. 4.00 pm ");
                System.out.println("5. Back ");
                System.out.println("------------------");
                System.out.print("Choose your option: ");
                int u = input.nextInt();

                switch (u){
                    case 1:
                        System.out.print("\n\n\nEnter your student id: ");
                        int p1 = input.nextInt();
                        try{ BufferedWriter out = new BufferedWriter(new FileWriter("rootOne/12pm.txt", true));
                            out.write(p1 + "\n");
                            out.close();
                            System.out.println("\n\nReserved successfully.\nPress 1 to go back: ");
                            int p = input.nextInt();
                            if (p==1){seatBooking();}
                        } catch (IOException e) {
                            System.out.println("exception occoured" + e);
                        }

                        break;
                    case 2:
                        System.out.print("\n\n\nEnter your student id: ");
                        int p2 = input.nextInt();
                        try{ BufferedWriter out = new BufferedWriter(new FileWriter("rootOne/2pm.txt", true));
                            out.write(p2 + "\n");
                            out.close();
                            System.out.println("\n\nReserved successfully.\nPress 1 to go back: ");
                            int p = input.nextInt();
                            if (p==1){seatBooking();}
                        } catch (IOException e) {
                            System.out.println("exception occoured" + e);
                        }

                        break;
                    case 3:
                        System.out.print("\n\n\nEnter your student id: ");
                        int p3 = input.nextInt();
                        try{ BufferedWriter out = new BufferedWriter(new FileWriter("rootOne/2.45pm.txt", true));
                            out.write(p3 + "\n");
                            out.close();
                            System.out.println("\n\nReserved successfully.\nPress 1 to go back: ");
                            int p = input.nextInt();
                            if (p==1){seatBooking();}
                        } catch (IOException e) {
                            System.out.println("exception occoured" + e);
                        }

                        break;
                    case 4:
                        System.out.print("\n\n\nEnter your student id: ");
                        int n4 = input.nextInt();
                        try{ BufferedWriter out = new BufferedWriter(new FileWriter("rootOne/4pm.txt", true));
                            out.write(n4 + "\n");
                            out.close();
                            System.out.println("\n\nReserved successfully.\nPress 1 to go back: ");
                            int p = input.nextInt();
                            if (p==1){seatBooking();}
                        } catch (IOException e) {
                            System.out.println("exception occoured" + e);
                        }

                        break;
                    case 5:
                        try{student();}
                        catch (IOException e) {
                            System.out.println("exception occoured" + e);
                        }
                        break;
                }
                break;

            //for route 2
            case 2:
                System.out.println("\n\n\n\t\t\t===Choosee your schedule===");
                System.out.println("1. 12.00 pm ");
                System.out.println("2. 2.00 pm ");
                System.out.println("3. 2.45 pm ");
                System.out.println("4. 4.00 pm ");
                System.out.println("5. Back ");
                System.out.println("------------------");
                System.out.print("Choose your option: ");
                int r = input.nextInt();
                switch (r){
                    case 1:
                        System.out.print("\n\n\nEnter your student id: ");
                        int p1 = input.nextInt();
                        try{ BufferedWriter out = new BufferedWriter(new FileWriter("rootTwo/12pm.txt", true));
                            out.write(p1 + "\n");
                            out.close();
                            System.out.println("\n\nReserved successfully.\nPress 1 to go back: ");
                            int p = input.nextInt();
                            if (p==1){seatBooking();}
                        } catch (IOException e) {
                            System.out.println("exception occoured" + e);
                        }

                        break;
                    case 2:
                        System.out.print("\n\n\nEnter your student id: ");
                        int p2 = input.nextInt();
                        try{ BufferedWriter out = new BufferedWriter(new FileWriter("rootTwo/2pm.txt", true));
                            out.write(p2 + "\n");
                            out.close();
                            System.out.println("\n\nReserved successfully.\nPress 1 to go back: ");
                            int p = input.nextInt();
                            if (p==1){seatBooking();}
                        } catch (IOException e) {
                            System.out.println("exception occoured" + e);
                        }

                        break;
                    case 3:
                        System.out.print("\n\n\nEnter your student id: ");
                        int p3 = input.nextInt();
                        try{ BufferedWriter out = new BufferedWriter(new FileWriter("rootTwo/2.45pm.txt", true));
                            out.write(p3 + "\n");
                            out.close();
                            System.out.println("\n\nReserved successfully.\nPress 1 to go back: ");
                            int p = input.nextInt();
                            if (p==1){seatBooking();}
                        } catch (IOException e) {
                            System.out.println("exception occoured" + e);
                        }

                        break;
                    case 4:
                        System.out.print("\n\n\nEnter your student id: ");
                        int n4 = input.nextInt();
                        try{ BufferedWriter out = new BufferedWriter(new FileWriter("rootTwo/4pm.txt", true));
                            out.write(n4 + "\n");
                            out.close();
                            System.out.println("\n\nReserved successfully.\nPress 1 to go back: ");
                            int p = input.nextInt();
                            if (p==1){seatBooking();}
                        } catch (IOException e) {
                            System.out.println("exception occoured" + e);
                        }

                        break;
                    case 5:
                        try{student();}
                        catch (IOException e) {
                            System.out.println("exception occoured" + e);
                        }
                        break;
                }
                break;

            //For route 3
            case 3:
                System.out.println("\n\n\n\t\t\t===Choose your schedule===");
                System.out.println("1. 12.00 pm ");
                System.out.println("2. 2.00 pm ");
                System.out.println("3. 2.45 pm ");
                System.out.println("4. 4.00 pm ");
                System.out.println("5. Back ");
                System.out.println("------------------");
                System.out.print("Choose your option: ");
                int s = input.nextInt();
                switch (s){
                    case 1:
                        System.out.print("\n\n\nEnter your student id: ");
                        int p1 = input.nextInt();
                        try{ BufferedWriter out = new BufferedWriter(new FileWriter("rootThree/12pm.txt", true));
                            out.write(p1 + "\n");
                            out.close();
                            System.out.println("\n\nReserved successfully.\nPress 1 to go back: ");
                            int p = input.nextInt();
                            if (p==1){seatBooking();}
                        } catch (IOException e) {
                            System.out.println("exception occoured" + e);
                        }

                        break;

                    case 2:
                        System.out.print("\n\n\nEnter your student id: ");
                        int p2 = input.nextInt();
                        try{ BufferedWriter out = new BufferedWriter(new FileWriter("rootThree/2pm.txt", true));
                            out.write(p2 + "\n");
                            out.close();
                            System.out.println("\n\nReserved successfully.\nPress 1 to go back: ");
                            int p = input.nextInt();
                            if (p==1){seatBooking();}
                        } catch (IOException e) {
                            System.out.println("exception occoured" + e);
                        }

                        break;
                    case 3:
                        System.out.print("\n\n\nEnter your student id: ");
                        int p3 = input.nextInt();
                        try{ BufferedWriter out = new BufferedWriter(new FileWriter("rootThree/2.45pm.txt", true));
                            out.write(p3 + "\n");
                            out.close();
                            System.out.println("\n\nReserved successfully.\nPress 1 to go back: ");
                            int p = input.nextInt();
                            if (p==1){seatBooking();}
                        } catch (IOException e) {
                            System.out.println("exception occoured" + e);
                        }

                        break;
                    case 4:
                        System.out.print("\n\n\nEnter your student id: ");
                        int n4 = input.nextInt();
                        try{ BufferedWriter out = new BufferedWriter(new FileWriter("rootThree/4pm.txt", true));
                            out.write(n4 + "\n");
                            out.close();
                            System.out.println("\n\nReserved successfully.\nPress 1 to go back: ");
                            int p = input.nextInt();
                            if (p==1){seatBooking();}
                        } catch (IOException e) {
                            System.out.println("exception occoured" + e);
                        }

                        break;
                    case 5:
                        try{student();}
                        catch (IOException e) {
                            System.out.println("exception occoured" + e);
                        }
                        break;
                }
                break;

            //for route 4
            case 4:
                System.out.println("\n\n\n\t\t\t===Choose your schedule===");
                System.out.println("1. 12.00 pm ");
                System.out.println("2. 2.00 pm ");
                System.out.println("3. 2.45 pm ");
                System.out.println("4. 4.00 pm ");
                System.out.println("5. Back ");
                System.out.println("------------------");
                System.out.print("Choose your option: ");
                int t = input.nextInt();

                switch (t){
                    case 1:
                        System.out.print("\n\n\nEnter your student id: ");
                        int p1 = input.nextInt();
                        try{ BufferedWriter out = new BufferedWriter(new FileWriter("rootFour/12pm.txt", true));
                            out.write(p1 + "\n");
                            out.close();
                            System.out.println("\n\nReserved successfully.\nPress 1 to go back: ");
                            int p = input.nextInt();
                            if (p==1){seatBooking();}
                        } catch (IOException e) {
                            System.out.println("exception occoured" + e);
                        }

                        break;
                    case 2:
                        System.out.print("\n\n\nEnter your student id: ");
                        int p2 = input.nextInt();
                        try{ BufferedWriter out = new BufferedWriter(new FileWriter("rootFour/2pm.txt", true));
                            out.write(p2 + "\n");
                            out.close();
                            System.out.println("\n\nReserved successfully.\nPress 1 to go back: ");
                            int p = input.nextInt();
                            if (p==1){seatBooking();}
                        } catch (IOException e) {
                            System.out.println("exception occoured" + e);
                        }

                        break;
                    case 3:
                        System.out.print("\n\n\nEnter your student id: ");
                        int p3 = input.nextInt();
                        try{ BufferedWriter out = new BufferedWriter(new FileWriter("rootFour/2.45pm.txt", true));
                            out.write(p3 + "\n");
                            out.close();
                            System.out.println("\n\nReserved successfully.\nPress 1 to go back: ");
                            int p = input.nextInt();
                            if (p==1){seatBooking();}
                        } catch (IOException e) {
                            System.out.println("exception occoured" + e);
                        }

                        break;
                    case 4:
                        System.out.print("\n\n\nEnter your student id: ");
                        int n4 = input.nextInt();
                        try{ BufferedWriter out = new BufferedWriter(new FileWriter("rootFour/4pm.txt", true));
                            out.write(n4 + "\n");
                            out.close();
                            System.out.println("\n\nReserved successfully.\nPress 1 to go back: ");
                            int p = input.nextInt();
                            if (p==1){seatBooking();}
                        } catch (IOException e) {
                            System.out.println("exception occoured" + e);
                        }

                        break;
                    case 5:
                        try{student();}
                        catch (IOException e) {
                            System.out.println("exception occoured" + e);
                        }
                        break;
                }
                break;


            case 5:
                seatvacant();
                break;


            case 6:
                try{student();}
                catch (IOException e) {
                    System.out.println("exception occoured" + e);
                }
                break;
        }

    }

    //method for checking seat vaccancy
    public void seatvacant(){
        System.out.println("\n\n\n\t\t\t====Seat vaccancy====");
        System.out.println("1. Route 1");
        System.out.println("2. Route 2");
        System.out.println("3. Route 3");
        System.out.println("4. Route 4");
        System.out.println("5. Go back");
        System.out.println("------------------------");
        System.out.print("Choose your option: ");
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        switch (n){

            case 1:
                System.out.println("\n\n\n\t\t\t===Select time===");
                System.out.println("1. 8.00 am");
                System.out.println("2. 9.00 am");
                System.out.println("3. 10.00 am");
                System.out.println("4. 11.00 am");
                System.out.println("5. 12.45 pm");
                System.out.println("6. Go back.");
                System.out.println("-----------------------");
                System.out.print("Choose your option: ");
                int p1 = input.nextInt();

                switch (p1){
                    case 1:
                        List l = readFileInList("route1/8am.txt");

                        Iterator<String> itr1 = l.iterator();
                        while (itr1.hasNext())
                            System.out.println("\n\n"+itr1.next());
                        System.out.print("\n\nEnter 1 to go back: ");
                        int b = input.nextInt();
                        if(b==1){seatvacant();}
                        break;

                    case 2:
                        List k = readFileInList("route1/9am.txt");

                        Iterator<String> itr2 = k.iterator();
                        while (itr2.hasNext())
                            System.out.println("\n\n"+itr2.next());
                        System.out.print("\n\nEnter 1 to go back: ");
                        int c = input.nextInt();
                        if(c==1){seatvacant();}
                        break;

                    case 3:
                        List m = readFileInList("route1/10am.txt");

                        Iterator<String> itr3 = m.iterator();
                        while (itr3.hasNext())
                            System.out.println("\n\n"+itr3.next());
                        System.out.print("\n\nEnter 1 to go back: ");
                        int d = input.nextInt();
                        if(d==1){seatvacant();}
                        break;

                    case 4:
                        List o = readFileInList("route1/11am.txt");

                        Iterator<String> itr4 = o.iterator();
                        while (itr4.hasNext())
                            System.out.println("\n\n"+itr4.next());
                        System.out.print("\n\nEnter 1 to go back: ");
                        int f = input.nextInt();
                        if(f==1){seatvacant();}
                        break;

                    case 5:
                        List q = readFileInList("route1/12.45pm.txt");

                        Iterator<String> itr5 = q.iterator();
                        while (itr5.hasNext())
                            System.out.println("\n\n"+itr5.next());
                        System.out.print("\n\nEnter 1 to go back: ");
                        int g = input.nextInt();
                        if(g==1){seatvacant();}
                        break;

                    case 6:
                        seatvacant();
                        break;
                }

             //for route two
            case 2:
                System.out.println("\n\n\n\t\t\t===Select time===");
                System.out.println("1. 8.00 am");
                System.out.println("2. 9.00 am");
                System.out.println("3. 10.00 am");
                System.out.println("4. 11.00 am");
                System.out.println("5. 12.45 pm");
                System.out.println("6. Go back.");
                System.out.println("-----------------------");
                System.out.print("Choose your option: ");
                int p2 = input.nextInt();

                switch (p2){
                    case 1:
                        List l = readFileInList("route2/8am.txt");

                        Iterator<String> itr1 = l.iterator();
                        while (itr1.hasNext())
                            System.out.println("\n\n"+itr1.next());
                        System.out.print("\n\nEnter 1 to go back: ");
                        int b = input.nextInt();
                        if(b==1){seatvacant();}
                        break;

                    case 2:
                        List k = readFileInList("route2/9am.txt");

                        Iterator<String> itr2 = k.iterator();
                        while (itr2.hasNext())
                            System.out.println("\n\n"+itr2.next());
                        System.out.print("\n\nEnter 1 to go back: ");
                        int c = input.nextInt();
                        if(c==1){seatvacant();}
                        break;

                    case 3:
                        List m = readFileInList("route2/10am.txt");

                        Iterator<String> itr3 = m.iterator();
                        while (itr3.hasNext())
                            System.out.println("\n\n"+itr3.next());
                        System.out.print("\n\nEnter 1 to go back: ");
                        int d = input.nextInt();
                        if(d==1){seatvacant();}
                        break;

                    case 4:
                        List o = readFileInList("route2/11am.txt");

                        Iterator<String> itr4 = o.iterator();
                        while (itr4.hasNext())
                            System.out.println("\n\n"+itr4.next());
                        System.out.print("\n\nEnter 1 to go back: ");
                        int f = input.nextInt();
                        if(f==1){seatvacant();}
                        break;

                    case 5:
                        List q = readFileInList("route2/12.45pm.txt");

                        Iterator<String> itr5 = q.iterator();
                        while (itr5.hasNext())
                            System.out.println("\n\n"+itr5.next());
                        System.out.print("\n\nEnter 1 to go back: ");
                        int g = input.nextInt();
                        if(g==1){seatvacant();}
                        break;

                    case 6:
                        seatvacant();
                        break;
                }

            //for route three
            case 3:
                System.out.println("\n\n\n\t\t\t===Select time===");
                System.out.println("1. 8.00 am");
                System.out.println("2. 9.00 am");
                System.out.println("3. 10.00 am");
                System.out.println("4. 11.00 am");
                System.out.println("5. 12.45 pm");
                System.out.println("6. Go back.");
                System.out.println("-----------------------");
                System.out.print("Choose your option: ");
                int p3 = input.nextInt();

                switch (p3){
                    case 1:
                        List l = readFileInList("route3/8am.txt");

                        Iterator<String> itr1 = l.iterator();
                        while (itr1.hasNext())
                            System.out.println("\n\n"+itr1.next());
                        System.out.print("\n\nEnter 1 to go back: ");
                        int b = input.nextInt();
                        if(b==1){seatvacant();}
                        break;

                    case 2:
                        List k = readFileInList("route3/9am.txt");

                        Iterator<String> itr2 = k.iterator();
                        while (itr2.hasNext())
                            System.out.println("\n\n"+itr2.next());
                        System.out.print("\n\nEnter 1 to go back: ");
                        int c = input.nextInt();
                        if(c==1){seatvacant();}
                        break;

                    case 3:
                        List m = readFileInList("route3/10am.txt");

                        Iterator<String> itr3 = m.iterator();
                        while (itr3.hasNext())
                            System.out.println("\n\n"+itr3.next());
                        System.out.print("\n\nEnter 1 to go back: ");
                        int d = input.nextInt();
                        if(d==1){seatvacant();}
                        break;

                    case 4:
                        List o = readFileInList("route3/11am.txt");

                        Iterator<String> itr4 = o.iterator();
                        while (itr4.hasNext())
                            System.out.println("\n\n"+itr4.next());
                        System.out.print("\n\nEnter 1 to go back: ");
                        int f = input.nextInt();
                        if(f==1){seatvacant();}
                        break;

                    case 5:
                        List q = readFileInList("route3/12.45pm.txt");

                        Iterator<String> itr5 = q.iterator();
                        while (itr5.hasNext())
                            System.out.println("\n\n"+itr5.next());
                        System.out.print("\n\nEnter 1 to go back: ");
                        int g = input.nextInt();
                        if(g==1){seatvacant();}
                        break;

                    case 6:
                        seatvacant();
                        break;
                }

            //for route four
            case 4:
                System.out.println("\n\n\n\t\t\t===Select time===");
                System.out.println("1. 8.00 am");
                System.out.println("2. 9.00 am");
                System.out.println("3. 10.00 am");
                System.out.println("4. 11.00 am");
                System.out.println("5. 12.45 pm");
                System.out.println("6. Go back.");
                System.out.println("-----------------------");
                System.out.print("Choose your option: ");
                int p4 = input.nextInt();

                switch (p4){
                    case 1:
                        List l = readFileInList("route4/8am.txt");

                        Iterator<String> itr1 = l.iterator();
                        while (itr1.hasNext())
                            System.out.println("\n\n"+itr1.next());
                        System.out.print("\n\nEnter 1 to go back: ");
                        int b = input.nextInt();
                        if(b==1){seatvacant();}
                        break;

                    case 2:
                        List k = readFileInList("route4/9am.txt");

                        Iterator<String> itr2 = k.iterator();
                        while (itr2.hasNext())
                            System.out.println("\n\n"+itr2.next());
                        System.out.print("\n\nEnter 1 to go back: ");
                        int c = input.nextInt();
                        if(c==1){seatvacant();}
                        break;

                    case 3:
                        List m = readFileInList("route4/10am.txt");

                        Iterator<String> itr3 = m.iterator();
                        while (itr3.hasNext())
                            System.out.println("\n\n"+itr3.next());
                        System.out.print("\n\nEnter 1 to go back: ");
                        int d = input.nextInt();
                        if(d==1){seatvacant();}
                        break;

                    case 4:
                        List o = readFileInList("route4/11am.txt");

                        Iterator<String> itr4 = o.iterator();
                        while (itr4.hasNext())
                            System.out.println("\n\n"+itr4.next());
                        System.out.print("\n\nEnter 1 to go back: ");
                        int f = input.nextInt();
                        if(f==1){seatvacant();}
                        break;

                    case 5:
                        List q = readFileInList("route4/12.45pm.txt");

                        Iterator<String> itr5 = q.iterator();
                        while (itr5.hasNext())
                            System.out.println("\n\n"+itr5.next());
                        System.out.print("\n\nEnter 1 to go back: ");
                        int g = input.nextInt();
                        if(g==1){seatvacant();}
                        break;

                    case 6:
                        seatvacant();
                        break;
                }


            case 5:
                seatBooking();

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
