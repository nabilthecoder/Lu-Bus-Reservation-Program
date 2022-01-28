package lubusreservation;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileWriter;

public class BusDriver
{
    public void busDriver() throws FileNotFoundException
    {
        System.out.println("\n\n\t\t\tDRIVERS PAGE");
        System.out.println("\t\t______________________________");
        System.out.println("\n\n\t\t1. Sign in.");
        System.out.println("\t\t2. Sign up.");
        System.out.println("\t\t3. Back.");
        System.out.println("\t\t_________________");
        System.out.print("\t\tEnter your choice: ");
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        switch (n)
        {
        case 1:
            login();
            break;
        case 2:
            register();
            break;
        case 3:
            FirstPage fp = new FirstPage();
            fp.firstpage();
            break;
        }
    }
    public void login()
    {
        Scanner sc=new Scanner(System.in);

        System.out.println("\n\nEnter User Name: ");
        String Uname=sc.nextLine();


        System.out.println("\nEnter Password: ");
        String Pass=sc.nextLine();

        Uname=Uname.trim();
        Pass=Pass.trim();
        String x= Uname+" "+Pass;


        try
        {

            File f = new File("DriverRegistration.txt");
            Scanner content = new Scanner(f);
            int flag=0;
            while (content.hasNextLine())
            {
                String data = content.nextLine();
                if(data.equals(x))
                {
                    System.out.println("\n\n\t\t\tLogin Successful");
                    System.out.println("\n\n\t\t\tWelcome to the Lu Bus Reservation Program.");
                    flag=1;
                    break;

                }
            }
            if(flag==1)
            {
                seatUpdate();
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
                    this.login();
                }
                else
                {
                    System.out.println("\n\t\t\tChoose Proper Option");
                }
            }

            content.close();
        }
        catch (FileNotFoundException e)
        {


            System.out.println("Error.");
            e.printStackTrace();
        }

        sc.close();
    }

    private void register() throws FileNotFoundException
    {
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
        if (Pass.equals(ConPass))
        {

            File f = new File("DriverRegistration.txt");
            Scanner content = new Scanner(f);


            int flag = 0;
            while (content.hasNextLine())
            {
                String data = content.nextLine();
                if (data.equals(x))
                {
                    System.out.println("\n\n\t\t\tAlready Registered");
                    flag = 1;
                    System.out.println("\n\n\t\t\t1. Registration. ");
                    System.out.println("\t\t\t2. Login. ");

                    System.out.print("\n\t\t\tEnter your Choice: ");
                    int choice = sc.nextInt();
                    if (choice == 1)
                    {
                        this.register();
                    }
                    else if (choice == 2)
                    {
                        this.login();
                    }
                    else
                    {
                        System.out.println("Choose Proper Option");
                    }
                    break;
                }
                //content.close();
            }
            if (flag == 0)
            {
                try
                {
                    BufferedWriter out = new BufferedWriter(new FileWriter("DriverRegistration.txt", true));
                    out.write(Uname + " " + Pass + "\n");
                    out.close();
                }
                catch (IOException e)
                {
                    System.out.println("exception occoured" + e);
                }

                System.out.println("\n\n\t\t\tSuccessfully Registered");
                System.out.println("\n\n\t\t\tPlease login");
                this.login();
            }


        }
        else {
            System.out.println("Recheck");
            System.out.println("1. Registration. ");
            System.out.println("2. Login. ");

            System.out.print("Enter your Choice: ");
            int choice = sc.nextInt();
            if (choice == 1)
            {
                this.register();
            }
            else if (choice == 2)
            {
                this.login();
            }
            else {
                System.out.println("Choose Proper Option");
            }
        }
        sc.close();
    }


    public void seatUpdate()
    {

        System.out.println("\n\n\n\t\t\t====Select Route====");
        System.out.println("1. Route 1");
        System.out.println("2. Route 2");
        System.out.println("3. Route 3");
        System.out.println("4. Route 4");
        System.out.println("5. Go back");
        System.out.println("------------------------");
        System.out.print("Choose your option: ");
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        switch (n)
        {

        case 1:
            System.out.println("\n\n\n\t\t\t===Select Time===");
            System.out.println("1. 8.00 am");
            System.out.println("2. 9.00 am");
            System.out.println("3. 10.00 am");
            System.out.println("4. 11.00 am");
            System.out.println("5. 12.45 pm");
            System.out.println("6. Go back.");
            System.out.println("----------------------");
            System.out.print("Choose your option: ");
            int p1 = input.nextInt();

            switch (p1)
            {
            case 1:
                System.out.print("\n\n\nHow many seat vacant? : ");
                int n1 = input.nextInt();
                //System.out.print("Enter time: ");
                //int t1 = input.nextInt();
                try
                {
                    BufferedWriter out = new BufferedWriter(new FileWriter("route1/8am.txt", true));
                    out.write("Seat vacant: "+n1 + "\n");
                    out.close();
                    System.out.println("\n\nUpdated successfully.\nPress 1 to go back: ");
                    int p = input.nextInt();
                    if (p==1)
                    {
                        seatUpdate();
                    }
                }
                catch (IOException e)
                {
                    System.out.println("exception occoured" + e);
                }

                break;

            case 2:
                System.out.print("\n\n\nHow many seat vacant? : ");
                int n2 = input.nextInt();
                // System.out.print("Enter time: ");
                // int t2 = input.nextInt();
                try
                {
                    BufferedWriter out = new BufferedWriter(new FileWriter("route1/9am.txt", true));
                    out.write("Seat vacant: "+n2 + "\n");
                    out.close();
                    System.out.println("\n\nUpdated successfully.\nPress 1 to go back: ");
                    int p = input.nextInt();
                    if (p==1)
                    {
                        seatUpdate();
                    }
                }
                catch (IOException e)
                {
                    System.out.println("exception occoured" + e);
                }
                break;

            case 3:
                System.out.print("\n\n\nHow many seat vacant? : ");
                int n3 = input.nextInt();
                //System.out.print("Enter time: ");
                //int t3 = input.nextInt();
                try
                {
                    BufferedWriter out = new BufferedWriter(new FileWriter("route1/10am.txt", true));
                    out.write("Seat vacant: "+n3 + "\n");
                    out.close();
                    System.out.println("\n\nUpdated successfully.\nPress 1 to go back: ");
                    int p = input.nextInt();
                    if (p==1)
                    {
                        seatUpdate();
                    }
                }
                catch (IOException e)
                {
                    System.out.println("exception occoured" + e);
                }
                break;
            case 4:
                System.out.print("\n\n\nHow many seat vacant? : ");
                int n4 = input.nextInt();
                //System.out.print("Enter time: ");
                try
                {
                    BufferedWriter out = new BufferedWriter(new FileWriter("route1/11am.txt", true));
                    out.write("Seat vacant: "+n4 + "\n");
                    out.close();
                    System.out.println("\n\nUpdated successfully.\nPress 1 to go back: ");
                    int p = input.nextInt();
                    if (p==1)
                    {
                        seatUpdate();
                    }
                }
                catch (IOException e)
                {
                    System.out.println("exception occoured" + e);
                }
                break;

            case 5:
                System.out.print("\n\n\nHow many seat vacant? : ");
                int n5 = input.nextInt();
                //System.out.print("Enter time: ");
                try
                {
                    BufferedWriter out = new BufferedWriter(new FileWriter("route1/12.45pm.txt", true));
                    out.write("Seat vacant: "+n5 + "\n");
                    out.close();
                    System.out.println("\n\nUpdated successfully.\nPress 1 to go back: ");
                    int p = input.nextInt();
                    if (p==1)
                    {
                        seatUpdate();
                    }
                }
                catch (IOException e)
                {
                    System.out.println("exception occoured" + e);
                }
                break;

            case 6:
                seatUpdate();
                break;
            }
            break;

        //for route two
        case 2:
            System.out.println("\n\n\n\t\t\t===Select Route===");
            System.out.println("1. 8.00 am");
            System.out.println("2. 9.00 am");
            System.out.println("3. 10.00 am");
            System.out.println("4. 11.00 am");
            System.out.println("5. 12.45 pm");
            System.out.println("6. Go back.");
            System.out.println("----------------------");
            System.out.print("Choose your option: ");
            int p2 = input.nextInt();

            switch (p2)
            {
            case 1:
                System.out.print("\n\n\nHow many seat vacant? : ");
                int n1 = input.nextInt();
                //System.out.print("Enter time: ");
                //int t1 = input.nextInt();
                try
                {
                    BufferedWriter out = new BufferedWriter(new FileWriter("route2/8am.txt", true));
                    out.write("Seat vacant: "+n1 + "\n");
                    out.close();
                    System.out.println("\n\nUpdated successfully.\nPress 1 to go back: ");
                    int p = input.nextInt();
                    if (p==1)
                    {
                        seatUpdate();
                    }
                }
                catch (IOException e)
                {
                    System.out.println("exception occoured" + e);
                }

                break;

            case 2:
                System.out.print("\n\n\nHow many seat vacant? : ");
                int n2 = input.nextInt();
                // System.out.print("Enter time: ");
                // int t2 = input.nextInt();
                try
                {
                    BufferedWriter out = new BufferedWriter(new FileWriter("route2/9am.txt", true));
                    out.write("Seat vacant: "+n2 + "\n");
                    out.close();
                    System.out.println("\n\nUpdated successfully.\nPress 1 to go back: ");
                    int p = input.nextInt();
                    if (p==1)
                    {
                        seatUpdate();
                    }
                }
                catch (IOException e)
                {
                    System.out.println("exception occoured" + e);
                }
                break;

            case 3:
                System.out.print("\n\n\nHow many seat vacant? : ");
                int n3 = input.nextInt();
                //System.out.print("Enter time: ");
                //int t3 = input.nextInt();
                try
                {
                    BufferedWriter out = new BufferedWriter(new FileWriter("route2/10am.txt", true));
                    out.write("Seat vacant: "+n3 + "\n");
                    out.close();
                    System.out.println("\n\nUpdated successfully.\nPress 1 to go back: ");
                    int p = input.nextInt();
                    if (p==1)
                    {
                        seatUpdate();
                    }
                }
                catch (IOException e)
                {
                    System.out.println("exception occoured" + e);
                }
                break;
            case 4:
                System.out.print("\n\n\nHow many seat vacant? : ");
                int n4 = input.nextInt();
                //System.out.print("Enter time: ");
                try
                {
                    BufferedWriter out = new BufferedWriter(new FileWriter("route2/11am.txt", true));
                    out.write("Seat vacant: "+n4 + "\n");
                    out.close();
                    System.out.println("\n\nUpdated successfully.\nPress 1 to go back: ");
                    int p = input.nextInt();
                    if (p==1)
                    {
                        seatUpdate();
                    }
                }
                catch (IOException e)
                {
                    System.out.println("exception occoured" + e);
                }
                break;

            case 5:
                System.out.print("\n\n\nHow many seat vacant? : ");
                int n5 = input.nextInt();
                //System.out.print("Enter time: ");
                try
                {
                    BufferedWriter out = new BufferedWriter(new FileWriter("route2/12.45pm.txt", true));
                    out.write("Seat vacant: "+n5 + "\n");
                    out.close();
                    System.out.println("\n\nUpdated successfully.\nPress 1 to go back: ");
                    int p = input.nextInt();
                    if (p==1)
                    {
                        seatUpdate();
                    }
                }
                catch (IOException e)
                {
                    System.out.println("exception occoured" + e);
                }
                break;

            case 6:
                seatUpdate();
                break;
            }
            break;

        //for route three
        case 3:
            System.out.println("\n\n\n\t\t\t===Select Route===");
            System.out.println("1. 8.00 am");
            System.out.println("2. 9.00 am");
            System.out.println("3. 10.00 am");
            System.out.println("4. 11.00 am");
            System.out.println("5. 12.45 pm");
            System.out.println("6. Go back.");
            System.out.println("----------------------");
            System.out.print("Choose your option: ");
            int p3 = input.nextInt();

            switch (p3)
            {
            case 1:
                System.out.print("\n\n\nHow many seat vacant? : ");
                int n1 = input.nextInt();
                //System.out.print("Enter time: ");
                //int t1 = input.nextInt();
                try
                {
                    BufferedWriter out = new BufferedWriter(new FileWriter("route3/8am.txt", true));
                    out.write("Seat vacant: "+n1 + "\n");
                    out.close();
                    System.out.println("\n\nUpdated successfully.\nPress 1 to go back: ");
                    int p = input.nextInt();
                    if (p==1)
                    {
                        seatUpdate();
                    }
                }
                catch (IOException e)
                {
                    System.out.println("exception occoured" + e);
                }

                break;

            case 2:
                System.out.print("\n\n\nHow many seat vacant? : ");
                int n2 = input.nextInt();
                // System.out.print("Enter time: ");
                // int t2 = input.nextInt();
                try
                {
                    BufferedWriter out = new BufferedWriter(new FileWriter("route3/9am.txt", true));
                    out.write("Seat vacant: "+n2 + "\n");
                    out.close();
                    System.out.println("\n\nUpdated successfully.\nPress 1 to go back: ");
                    int p = input.nextInt();
                    if (p==1)
                    {
                        seatUpdate();
                    }
                }
                catch (IOException e)
                {
                    System.out.println("exception occoured" + e);
                }
                break;

            case 3:
                System.out.print("\n\n\nHow many seat vacant? : ");
                int n3 = input.nextInt();
                //System.out.print("Enter time: ");
                //int t3 = input.nextInt();
                try
                {
                    BufferedWriter out = new BufferedWriter(new FileWriter("route3/10am.txt", true));
                    out.write("Seat vacant: "+n3 + "\n");
                    out.close();
                    System.out.println("\n\nUpdated successfully.\nPress 1 to go back: ");
                    int p = input.nextInt();
                    if (p==1)
                    {
                        seatUpdate();
                    }
                }
                catch (IOException e)
                {
                    System.out.println("exception occoured" + e);
                }
                break;
            case 4:
                System.out.print("\n\n\nHow many seat vacant? : ");
                int n4 = input.nextInt();
                //System.out.print("Enter time: ");
                try
                {
                    BufferedWriter out = new BufferedWriter(new FileWriter("route3/11am.txt", true));
                    out.write("Seat vacant: "+n4 + "\n");
                    out.close();
                    System.out.println("\n\nUpdated successfully.\nPress 1 to go back: ");
                    int p = input.nextInt();
                    if (p==1)
                    {
                        seatUpdate();
                    }
                }
                catch (IOException e)
                {
                    System.out.println("exception occoured" + e);
                }
                break;

            case 5:
                System.out.print("\n\n\nHow many seat vacant? : ");
                int n5 = input.nextInt();
                //System.out.print("Enter time: ");
                try
                {
                    BufferedWriter out = new BufferedWriter(new FileWriter("route3/12.45pm.txt", true));
                    out.write("Seat vacant: "+n5 + "\n");
                    out.close();
                    System.out.println("\n\nUpdated successfully.\nPress 1 to go back: ");
                    int p = input.nextInt();
                    if (p==1)
                    {
                        seatUpdate();
                    }
                }
                catch (IOException e)
                {
                    System.out.println("exception occoured" + e);
                }
                break;

            case 6:
                seatUpdate();
                break;
            }
            break;

        //for route four
        case 4:
            System.out.println("\n\n\n\t\t\t===Select Route===");
            System.out.println("1. 8.00 am");
            System.out.println("2. 9.00 am");
            System.out.println("3. 10.00 am");
            System.out.println("4. 11.00 am");
            System.out.println("5. 12.45 pm");
            System.out.println("6. Go back.");
            System.out.println("----------------------");
            System.out.print("Choose your option: ");
            int p4 = input.nextInt();

            switch (p4)
            {
            case 1:
                System.out.print("\n\n\nHow many seat vacant? : ");
                int n1 = input.nextInt();
                //System.out.print("Enter time: ");
                //int t1 = input.nextInt();
                try
                {
                    BufferedWriter out = new BufferedWriter(new FileWriter("route4/8am.txt", true));
                    out.write("Seat vacant: "+n1 + "\n");
                    out.close();
                    System.out.println("\n\nUpdated successfully.\nPress 1 to go back: ");
                    int p = input.nextInt();
                    if (p==1)
                    {
                        seatUpdate();
                    }
                }
                catch (IOException e)
                {
                    System.out.println("exception occoured" + e);
                }

                break;

            case 2:
                System.out.print("\n\n\nHow many seat vacant? : ");
                int n2 = input.nextInt();
                // System.out.print("Enter time: ");
                // int t2 = input.nextInt();
                try
                {
                    BufferedWriter out = new BufferedWriter(new FileWriter("route4/9am.txt", true));
                    out.write("Seat vacant: "+n2 + "\n");
                    out.close();
                    System.out.println("\n\nUpdated successfully.\nPress 1 to go back: ");
                    int p = input.nextInt();
                    if (p==1)
                    {
                        seatUpdate();
                    }
                }
                catch (IOException e)
                {
                    System.out.println("exception occoured" + e);
                }
                break;

            case 3:
                System.out.print("\n\n\nHow many seat vacant? : ");
                int n3 = input.nextInt();
                //System.out.print("Enter time: ");
                //int t3 = input.nextInt();
                try
                {
                    BufferedWriter out = new BufferedWriter(new FileWriter("route4/10am.txt", true));
                    out.write("Seat vacant: "+n3 + "\n");
                    out.close();
                    System.out.println("\n\nUpdated successfully.\nPress 1 to go back: ");
                    int p = input.nextInt();
                    if (p==1)
                    {
                        seatUpdate();
                    }
                }
                catch (IOException e)
                {
                    System.out.println("exception occoured" + e);
                }
                break;
            case 4:
                System.out.print("\n\n\nHow many seat vacant? : ");
                int n4 = input.nextInt();
                //System.out.print("Enter time: ");
                try
                {
                    BufferedWriter out = new BufferedWriter(new FileWriter("route4/11am.txt", true));
                    out.write("Seat vacant: "+n4 + "\n");
                    out.close();
                    System.out.println("\n\nUpdated successfully.\nPress 1 to go back: ");
                    int p = input.nextInt();
                    if (p==1)
                    {
                        seatUpdate();
                    }
                }
                catch (IOException e)
                {
                    System.out.println("exception occoured" + e);
                }
                break;

            case 5:
                System.out.print("\n\n\nHow many seat vacant? : ");
                int n5 = input.nextInt();
                //System.out.print("Enter time: ");
                try
                {
                    BufferedWriter out = new BufferedWriter(new FileWriter("route4/12.45pm.txt", true));
                    out.write("Seat vacant: "+n5 + "\n");
                    out.close();
                    System.out.println("\n\nUpdated successfully.\nPress 1 to go back: ");
                    int p = input.nextInt();
                    if (p==1)
                    {
                        seatUpdate();
                    }
                }
                catch (IOException e)
                {
                    System.out.println("exception occoured" + e);
                }
                break;

            case 6:
                seatUpdate();
                break;
            }
            break;

        case 5:
            try
            {
                busDriver();
            }
            catch (IOException e)
            {
                System.out.println("exception occoured" + e);
            }
            break;

        }

    }
}
