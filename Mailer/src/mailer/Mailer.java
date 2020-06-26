package mailer;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
public class Mailer 
{
    
    private static Scanner sc=new Scanner(System.in);
    private MailReader m;
    private String email,password;
    public Mailer()
    {
        System.out.println("Mailer is Starting....");
        System.out.println("Enter your Email:");
        email=sc.nextLine();
        System.out.println("Enter your Password:");
        password=sc.nextLine();
        m=new MailReader(email,password);
        System.out.println("Mailer is Running...");
    }
    private void showHelp()
    {
        System.out.println();
        System.out.println("Syntax of Command: Mailer --EMAIL --SUBJECT --FROMMAIL --FROMNAME");
	System.out.println("--EMAIL/--EMAIL64               To Show Their Email/Encrypted Emails with Base64");
	System.out.println("--SUBJECT            		To Show Subject");
	System.out.println("--FROMMAIL           		To Show From Mail");
        System.out.println("--FROMNAME           		To Show From Name");
	System.out.println("--RANDOMIP           		To Random IP");
        System.out.println("--USERNAME           		To Show The Email Username");
	System.out.println("--EMAILCENSORED      		To Show Email Censored");
	System.out.println("--DOMAINFULL         		To Show The Domain");
        System.out.println("--DOMAINNAME        		To Show The Domain Without Extention");
	System.out.println("--randstring         		To Show Random String in Lowercase");
	System.out.println("--RANDSTRING         		To Show Random String in Uppercase");
	System.out.println("--COUNTRY            		To Show Random Country");
	System.out.println("--DATE            	 	To Show Date");
	System.out.println("--DATETOMORROW		 	To Show Date Tomorrow");
	System.out.println("--TIME			        To Show Time");
	System.out.println("--NUMBER1-NUMBER10       	To Randomize Number as Many as 1-10 Piece");
	System.out.println("--char1-char10         	 	To Randomize Char in Lowercase as Many as 1-10 Piece");
	System.out.println("--CHAR1-CHAR10           	To Randomize Char in Uppercase as Many as 1-10 Piece");
	System.out.println("--PC_OS              		To Show Random PC OS");
	System.out.println("--PC_Browser         		To Show Random PC Browsers");
	System.out.println("--COUNTRYCITY       		To Show Random Country and City");
	System.out.println("--ANDROID_OS         		To Show Random Android OS");
	System.out.println("--ANDROID_Browser    		To Show Random Android Browsers");
	System.out.println("--UA              	 	To Show Random User Agents");
	System.out.println("--APPLEAPPS          		To Show Random Apple Apps");
	System.out.println("--APPLEPC            		To Show Random Apple Laptops");
	System.out.println("--APPLEPHONES        		To Show Random Apple Phones");
	System.out.println("--UNIVERSAL_Browser  		To Show Random Universal Broswers");
        System.out.println();
        System.out.println("----------------------------------------------------------------------");
        System.out.println("********************GUIDE TO USE**************************************");
        System.out.println("First of all you have to provide the email and password of your gmail account");
        System.out.println("The Email and Password must be correct if they are wrong you need to exit the program by typing Mailer --EXIT and then start it");
        System.out.println("The Syntax of Commands is very simple you just need to Write the name of Program and then the arguments");
        System.out.println("For Example: Mailer --EMAIL               To Display Emails in your inbox");
         System.out.println("----------------------------------------------------------------------");
        
    }
    public void startMailer()
    {
        
        while(true)
        {
            String input=sc.nextLine();
            String args[];
            if(input.equalsIgnoreCase("Mailer Exit") || input.equalsIgnoreCase("Exit"))
            {
                break;
            }
            else 
            {
                args=input.split(" ");
                //mailer --help or mailer --h to show Help
                if(args.length==2 && (args[0].equalsIgnoreCase("Mailer") && (args[1].equalsIgnoreCase("--help") || args[1].equalsIgnoreCase("--h"))))
                {
                    System.out.print("Executing: ");
                    for(int i=0;i<args.length;i++)
                        System.out.print(args[i]+" ");
                    showHelp();
                }
                else if(args.length>=2)
                {
                    System.out.print("Command Entered: ");
                    for(int i=0;i<args.length;i++)
                        System.out.print(args[i]+" ");
                    m.readMails(args);
                }
                else if(!args[0].equalsIgnoreCase("mailer"))
                {
                    System.out.println("Invalid Syntax Open Help to see syntax of command");
                }
                else
                {
                    System.out.println("Invalid Command");
                } 
            }
        }
        
	
    }
    
    public static void main(String[] args) 
    {               
	Mailer mailer=new Mailer();
        mailer.startMailer();
      
    }
}
