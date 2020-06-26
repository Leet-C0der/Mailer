import java.util.Scanner;


//Paackages for MailReader Class
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.Random;
import javax.mail.Address;
import javax.mail.AuthenticationFailedException;
import javax.mail.BodyPart;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Flags.Flag;
import javax.mail.search.FlagTerm;







//Mailer Class
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




//MailReader Class

class MailReader 
{
    Properties properties = null;
    private Session session = null;
    private Store store = null;
    private Folder inbox = null;
    private String userName;
    private String password;
    public MailReader(final String userName,final String password)
    {
        this.userName=userName;
        this.password=password;
        properties = new Properties();
        properties.setProperty("mail.host", "imap.gmail.com");
        properties.setProperty("mail.port", "995");
        properties.setProperty("mail.transport.protocol", "imaps");
        session = Session.getInstance(properties,
        new javax.mail.Authenticator() 
        {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(userName, password);
        }});
    }
    
    public void readMails(String[] commands)
    {
        //String commands[]=command.split(" ");
        switch(commands.length)
        {
            //Case 2 For length=2
            case 2:
                switchCase2(commands);
            break;    
            //Case 3 for length 3
            case 3:
                switchCase3(commands);
            break;
            //Case 4 For Length==4
            case 4:
                switchCase4(commands);
            break;
            //Case 4 For length=5
            case 5:
                switchCase5(commands);
            break;
            case 6:
                switchCase6(commands);
            break;
            case 7:
                switchCase7(commands);
            break;
            case 8:
                switchCase8(commands);
            break;
            case 9:
                switchCase9(commands);
            break;
            case 10:
                switchCase10(commands);
            break;
            default:
                System.out.println("The Maximum 10 commands can be used at a time");
            
        }
    }
    public String processMessageBody(Message message) 
    { 
        String mail="";
        try 
        {
            Object content = message.getContent(); // check for string // then check for multipart 
            if (content instanceof Multipart) 
            {
                Multipart multiPart = (Multipart) content; 
                mail+=procesMultiPart(multiPart); 
            }
            else if (content instanceof InputStream) 
            {
                InputStream inStream = (InputStream) content; 
                int ch; 
                BufferedInputStream bis=new BufferedInputStream(inStream);
                
                while ((ch = inStream.read()) != -1) 
                {
                    String m="";
                    while((ch=inStream.read())!='\n')
                    {
                        m+=ch;
                    }
                        mail+=m; 
                } 
            }
        }
        catch (IOException e) 
        {
            System.out.println("Error Occured: Check Credentials"); 
        } 
        catch (MessagingException e) 
        {
            System.out.println("Error Occured: Check Credentials"); 
        } 
        return mail;
    }
    
    public String procesMultiPart(Multipart content) 
    { 
        String message="";
        try 
        { 
            int multiPartCount = content.getCount(); 
            for (int i = 0; i < multiPartCount; i++) 
            {
                BodyPart bodyPart = content.getBodyPart(i); 
                Object o; 
                o = bodyPart.getContent(); 
                if (o instanceof String) 
                {
                    return o.toString(); 
                } 
                else if (o instanceof Multipart) 
                { 
                    procesMultiPart((Multipart) o); 
                } 
            }    
        }
        catch (IOException e) 
        { 
            System.out.println("Error Occured: Check Credentials"); 
        } catch (MessagingException e) 
        {
            System.out.println("Error Occured: Check Credentials"); 
        } 
        return message;
    }
    
    public boolean containsEqualsIgnoreCase(String[] args,String command)
    {
        for(int i=0;i<args.length;i++)
        {
            if(args[i].equalsIgnoreCase(command))
                return true;
        }
        return false;
    }
    
    public boolean containsStartWith(String[] args,String command)
    {
        for(int i=0;i<args.length;i++)
        {
            if(args[i].startsWith(command))
                return true;
        }
        return false;
    }
    public boolean containsEquals(String args[],String command)
    {
        for(int i=0;i<args.length;i++)
        {
            if(args[i].equals(command))
                return true;
        }
        return false;
    }
    
    public String getFromName(String from)
    {
        String fromInfo[]=from.split(" ");
        String fromName="";
        for(int i=0;i<fromInfo.length;i++)
        {
            if(fromInfo[i].startsWith("<"))
                break;
            fromName+=fromInfo[i]+" ";
        }
        return fromName;
    }
    
    public String getFromEmail(String from)
    {
        String fromInfo[]=from.split(" ");
        return fromInfo[fromInfo.length-1];
    }
    
    public String getDomainFull(String email)
    {
        String emailInfo[]=email.split("@");
        String domainFull="<";
        for(int i=0;i<emailInfo[1].length();i++)
        {
            if(i==0)
            {
                domainFull+=emailInfo[1].charAt(i);
                domainFull=domainFull.toUpperCase();
            }
            else
            {
                domainFull+=emailInfo[1].charAt(i);
            }
        }
        return domainFull;
    }
    
    public String getDomainName(String email)
    {
        String domainFull=getDomainFull(email);
        String domainName="";
        for(int i=0;i<domainFull.length();i++)
        {
            if(domainFull.charAt(i)=='.')
            {
                break;
            }
            domainName+=domainFull.charAt(i);
        }
            
        return domainName+">";
    }
    
    public String getEmailCensored(String email)
    {
        String emailInfo[]=email.split("@");
        String emailCensor="";
        if(emailInfo.length==2)
        {
            String user=emailInfo[0];
            String domain=emailInfo[1];
            for(int i=0;i<user.length();i++)
            {
                if(i<3)
                    emailCensor+=user.charAt(i);
                else
                    emailCensor+='*';
            }
            emailCensor+=('@'+domain);
        }
        return emailCensor;   
    }
   
    public String getUserName(String email)
    {
        String emailInfo[]=email.split("@");
        return emailInfo[0]+">";
    }
    
    public String getRandomIP()
    {
        Random r = new Random();
        return r.nextInt(256) + "." + r.nextInt(256) + "." + r.nextInt(256) + "." + r.nextInt(256);
    }
    
    
    public static String getDate()
    {
        String date="";
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MMM/yyyy");  
        Date currentDate = new Date();  
        date=formatter.format(currentDate);  
        return date;
    }
    
    public static String getTomorrowDate()
    {
        String tomorrowDate="";
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        Date tomorrow=calendar.getTime();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MMM/yyyy");
        tomorrowDate = formatter.format(tomorrow);
    return tomorrowDate;
    }
    
    
    public static String getTime()
    {
        String time="";
        SimpleDateFormat formatter = new SimpleDateFormat("HH:MM:SS");  
        Date currentDate = new Date();  
        time=formatter.format(currentDate);
        return time;
    }
    
    public static String getRandomCountry()
    {
        Random random=new Random();
    String countries[]={"Afghanistan","China","Egypt","Pakistan","Iran","Saudi Arabia","Turkey","India","USA"};

        return countries[random.nextInt(countries.length-1)];
    }
    
    public static String getRandomPCOS()
    {
        Random random=new Random();
        String[] operatingSystems={"Linux","Ubuntu","Windows","MAC OS",
        "Fedora","Soalris","Free BSD","Chrome OS","CentOS","Debian","Deepin"};
        return operatingSystems[random.nextInt(operatingSystems.length-1)];
    }
    
    public static String getRandomPCBrowser()
    {
        Random random=new Random();
        String[] pcBrowsers={"Google Chrome","Mozilla Firefox","Opera","Microsoft Edge"
        ,"Brave Browser","Vivaldi","Chromium","Tor","Maxthon","Comodo IceDragon"
        ,"UC Browser"};
        return pcBrowsers[random.nextInt(pcBrowsers.length-1)];
    }
    
    public static String getRandomCity()
    {
        Random random=new Random();
    String cities[]={"New York","New Delhi","Islamabad","Kabul","Mexico","Abu Dhabi","Cairo","Beijing","Tokyo"};

    return cities[random.nextInt(cities.length-1)];
    }
    
    public static String getRandomAndroidOS()
    {
        Random random=new Random();
        String[] androidOS={"Generic System Image","Amazfit OS","AOKP","MarisolOS",
        "JLopezX","EvolutionX","Revenge Os","ConquerOS","Fire OS","Indus OS","Smartisan OS"};

        return androidOS[random.nextInt(androidOS.length-1)];
    }
    
    public static String getRandomAndroidBrowser()
    {
        Random random=new Random();
        String[] androidBrowsers={"Google Chrome","Mozilla Firefox","Opera Mini",
        "DuckDuckgo","Dolphin","Brave","Chromium","Tor","Maxthon 5","Puffin"
        ,"CM","Flynx","UC Browser"};

        return androidBrowsers[random.nextInt(androidBrowsers.length-1)];
    }
    
    public static String getRandomUserAgent()
    {
        Random random=new Random();
    String userAgent[]={"Facebook App (10,551,548)","Chrome (9,816,651)"," Android (21,229,931)","Apple iPhone (1,100,524)"};
        
        return userAgent[random.nextInt(userAgent.length-1)];
    }
    
    public static String getRandomAppleApps()
    {
        Random random=new Random();
        String appleApps[]={"Safari","iMovies","iBook Author","Key Note","Music Memo"};

        return appleApps[random.nextInt(appleApps.length-1)];
    }
    
    public static String getRandomAppleLaptops()
    {
        Random random=new Random();
    String appleLaptops[]={"Apple II,","Apple III","Apple Lisa","Classic MAC OS","Newton","iOS"};

        return appleLaptops[random.nextInt(appleLaptops.length-1)];
    }
    
    public static String getRandomApplePhones()
    {
        Random random=new Random();
        String[] applePhones={"Apple Apple iPhone 5s","iPad mini 2",
        "Apple iPhone a1332","Apple iPhone 5c","Apple iPad Pro 9.7","Apple iPad mini Wi-Fi",
        "Apple iPhone SE","Apple iPad mini Wi-Fi + Cellular","Apple iPhone 6s Plus",
        "Apple iPad 4 Wi-Fi","Apple iPhone 6s","Apple iPad 4 Wi-Fi + Cellular",
        "Apple iPad Pro Apple iPhone 5","Apple iPad mini 4","Apple iPad 3 Wi-Fi + Cellular"
        ,"Apple Watch Edition 42mm","Apple iPad 3 Wi-Fi","Apple Watch Edition 38mm",
        "Apple iPhone 4s","Apple Watch 42mm","Apple iPad 2 Wi-Fi + 3G","Apple Watch 38mm",
        "Apple iPad 2 Wi-Fi","Apple Watch Sport 42mm","Apple iPad 2 CDMA","Apple Watch Sport 38mm",
        "Apple iPhone 4","Apple iPad Air 2","Apple iPhone 4 CDMA","Apple iPad mini 3",
        "Apple iPad Wi-Fi + 3G","Apple iPhone 6 Plus","Apple iPad Wi-Fi","Apple iPhone 6",
        "Apple iPhone 3GS","Apple iPad Air","Apple iPhone 3G","Apple iPhone"};

    return applePhones[random.nextInt(applePhones.length-1)];
    }
    
    public static String getRandomUniversalBrowser()
    {
        Random random=new Random();
    String[] universalBrowsers={"Google Chrome","Mozilla Firefox","Opera","Microsoft Edge"
        ,"Brave Browser","Vivaldi","Chromium","Tor","Maxthon","Comodo IceDragon"
        ,"UC Browser"};
    
        return universalBrowsers[random.nextInt(universalBrowsers.length-1)];
    }
    
    public String getCharLowerCase(int n)
    {
        Random random=new Random();
        String alphabets="abcdefghijklmnopqrstuvwxyz";
        String chars="";
        for(int i=0;i<n;i++)
            chars+=alphabets.charAt(random.nextInt(alphabets.length()));
        return chars;
    }
    
    public String getCharUpperCase(int n)
    {
        Random random=new Random();
        String alphabets="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String chars="";
        for(int i=0;i<n;i++)
            chars+=alphabets.charAt(random.nextInt(alphabets.length()));
        return chars;
    }
    
    public String getNumbers(int n)
    {
        Random random=new Random();
        String nums="";
        for(int i=0;i<n;i++)
            nums+=random.nextInt(9);
        return nums;
    }
    
    public String getRandomStringLowerCase()
    {
        Random random=new Random();
        String alphabets="abcdefghijklmnopqrstuvwxyz";
        String str="";
        int n=random.nextInt(15);
        for(int i=0;i<n;i++)
            str+=alphabets.charAt(random.nextInt(alphabets.length()-1));
        return str;
    }
    
    public String getRandomStringUpperCase()
    {
        Random random=new Random();
        String alphabets="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String str="";
        int n=random.nextInt(15);
        for(int i=0;i<n;i++)
            str+=alphabets.charAt(random.nextInt(alphabets.length()-1));
        return str;
    }
    
    //Test Sucessful
    public void switchCase2(String[] commands)
    {
        //FOR EMAIL 
        if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL"))
                {
                    try
                    {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (MessagingException e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
                //FOR ENCODED EMAIL
                else if(this.containsEqualsIgnoreCase(commands, "Mailer") && this.containsEqualsIgnoreCase(commands,"--EMAIL64"))
                {
                    try
                    {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate());
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString((processMessageBody(message)).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
                else
                {
                    System.out.println("Invalid Syntax/Command!");
                }
    }
    
    //Test Sucessful
    public void switchCase3(String[] commands)
    {
        //For Simple Email
                if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
                && this.containsEqualsIgnoreCase(commands,"--FROMMAIL"))
                {
                    try
                    {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0 ; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("From Mail: " + getFromEmail(from[0].toString())); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
                else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
                && this.containsEqualsIgnoreCase(commands,"--FROMNAME"))
                {
                    try
                    {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0 ; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("From Name: " + getFromName(from[0].toString())); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
                else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
                && this.containsEqualsIgnoreCase(commands,"--SUBJECT"))
                {
                    try
                    {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Subject: " + message.getSubject()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
                else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
                && this.containsEqualsIgnoreCase(commands,"--RANDOMIP"))
                {
                    try
                    {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0 ; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random IP: " + getRandomIP()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
                else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
                && this.containsEqualsIgnoreCase(commands,"--USERNAME"))
                {
                    try
                    {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0 ; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("User Name: " + getUserName(getFromEmail(from[0].toString()))); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
                else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
                && this.containsEqualsIgnoreCase(commands,"--EMAILCENSORED"))
                {
                    try
                    {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0 ; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Email Censored: " + getEmailCensored(getFromEmail(from[0].toString()))); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
                else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
                && this.containsEqualsIgnoreCase(commands,"--DOMAINFULL"))
                {
                    try
                    {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0 ; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Doamin Full: " + getDomainFull(getFromEmail(from[0].toString()))); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
                else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
                && this.containsEqualsIgnoreCase(commands,"--DOMAINNAME"))
                {
                    try
                    {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0 ; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Domain Name: " + getDomainName(getFromEmail(from[0].toString()))); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
                else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
                && this.containsEqualsIgnoreCase(commands,"--COUNTRY"))
                {
                    try
                    {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1; i >=0 ; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random Country: " + getRandomCountry()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
                else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
                && this.containsEqualsIgnoreCase(commands,"--DATE"))
                {
                    try
                    {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1; i >=0 ; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Today's Date: " + getDate()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
                else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
                && this.containsEqualsIgnoreCase(commands,"--DATETOMORROW"))
                {
                    try
                    {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1; i >=0 ; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Date Tomorrow: " + getTomorrowDate()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
                else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
                && this.containsEqualsIgnoreCase(commands,"--TIME"))
                {
                    try
                    {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1; i >=0 ; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Time: " + getTime()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
                else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
                && this.containsEqualsIgnoreCase(commands,"--PC_OS"))
                {
                    try
                    {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1; i >=0 ; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random PC OS: " + getRandomPCOS()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
                else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
                && this.containsEqualsIgnoreCase(commands,"--PC_BROWSER"))
                {
                    try
                    {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1; i >=0 ; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random PC Browser: " + getRandomPCBrowser()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
                else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
                && this.containsEqualsIgnoreCase(commands,"--COUNTRYCITY"))
                {
                    try
                    {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1; i >=0 ; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random Country City: " + getRandomCity()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
                else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
                && this.containsEqualsIgnoreCase(commands,"--ANDROID_OS"))
                {
                    try
                    {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1; i >=0 ; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random Android OS: " + getRandomAndroidOS()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
                else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
                && this.containsEqualsIgnoreCase(commands,"--ANDROID_BROWSER"))
                {
                    try
                    {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1; i >=0 ; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random Android Browser: " + getRandomAndroidBrowser()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
                else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
                && this.containsEqualsIgnoreCase(commands,"--UA"))
                {
                    try
                    {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1; i >=0 ; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random User Agent: " + getRandomUserAgent()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
                else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
                && this.containsEqualsIgnoreCase(commands,"--APPLEAPPS"))
                {
                    try
                    {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1; i >=0 ; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random Apple App: " + getRandomAppleApps()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
                else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
                && this.containsEqualsIgnoreCase(commands,"--APPLEPC"))
                {
                    try
                    {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1; i >=0 ; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random Apple PC: " + getRandomAppleLaptops()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
                else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
                && this.containsEqualsIgnoreCase(commands,"--APPLEPHONES"))
                {
                    try
                    {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1; i >=0 ; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random Apple Phone: " + getRandomApplePhones()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
                else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
                && this.containsEqualsIgnoreCase(commands,"--UNIVERSAL_BROWSER"))
                {
                    try
                    {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1; i >=0 ; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random Universal Browser: " + getRandomUniversalBrowser()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
                else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
                && this.containsEqualsIgnoreCase(commands,"--RANDSTRING"))
                {
                    try
                    {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            if(this.containsEquals(commands,"--randstring"))
                                System.out.println("Random String in lowercase: " + getRandomStringLowerCase()); 
                            else if(this.containsEquals(commands,"--RANDSTRING"))
                                System.out.println("Random String in UpperCase : " + getRandomStringUpperCase()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
                else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
                && this.containsStartWith(commands,"--NUMBER"))
                {
                    try
                    {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            if(this.containsStartWith(commands,"--NUMBER1"))
                                System.out.println("Random Number: " + getNumbers(1)); 
                            else if(this.containsStartWith(commands,"--NUMBER2"))
                                System.out.println("Random Number: " + getNumbers(2));
                            else if(this.containsStartWith(commands,"--NUMBER3"))
                                System.out.println("Random Number: " + getNumbers(3));
                            else if(this.containsStartWith(commands,"--NUMBER4"))
                                System.out.println("Random Number: " + getNumbers(4));
                            else if(this.containsStartWith(commands,"--NUMBER5"))
                                System.out.println("Random Number: " + getNumbers(5));
                            else if(this.containsStartWith(commands,"--NUMBER6"))
                                System.out.println("Random Number: " + getNumbers(6));
                            else if(this.containsStartWith(commands,"--NUMBER7"))
                                System.out.println("Random Number: " + getNumbers(7));
                            else if(this.containsStartWith(commands,"--NUMBER8"))
                                System.out.println("Random Number: " + getNumbers(8));
                            else if(this.containsStartWith(commands,"--NUMBER9"))
                                System.out.println("Random Number: " + getNumbers(9));
                            else if(this.containsStartWith(commands,"--NUMBER10"))
                                System.out.println("Random Number: " + getNumbers(10));
                            
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
                else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
                && this.containsStartWith(commands,"--CHAR"))
                {
                    try
                    {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-2 ; i < messages.length; i++)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            if(this.containsStartWith(commands,"--CHAR1"))
                                System.out.println("Random Characters in Upper Case: " + getCharUpperCase(1)); 
                            else if(this.containsStartWith(commands,"--CHAR2"))
                                System.out.println("Random Characters in Upper Case: " + getCharUpperCase(2));
                            else if(this.containsStartWith(commands,"--CHAR3"))
                                System.out.println("Random Characters in Upper Case: " + getCharUpperCase(3)); 
                            else if(this.containsStartWith(commands,"--CHAR4"))
                                System.out.println("Random Characters in Upper Case: " + getCharUpperCase(4)); 
                            else if(this.containsStartWith(commands,"--CHAR5"))
                                System.out.println("Random Characters in Upper Case: " + getCharUpperCase(5)); 
                            else if(this.containsStartWith(commands,"--CHAR6"))
                                System.out.println("Random Characters in Upper Case: " + getCharUpperCase(6)); 
                            else if(this.containsStartWith(commands,"--CHAR7"))
                                System.out.println("Random Characters in Upper Case: " + getCharUpperCase(7)); 
                            else if(this.containsStartWith(commands,"--CHAR8"))
                                System.out.println("Random Characters in Upper Case: " + getCharUpperCase(8)); 
                            else if(this.containsStartWith(commands,"--CHAR9"))
                                System.out.println("Random Characters in Upper Case: " + getCharUpperCase(9)); 
                            else if(this.containsStartWith(commands,"--CHAR10"))
                                System.out.println("Random Characters in Upper Case: " + getCharUpperCase(10));
                            else if(this.containsStartWith(commands,"--char1"))
                                System.out.println("Random Characters in Lower Case: " + getCharLowerCase(1)); 
                            else if(this.containsStartWith(commands,"--char2"))
                                System.out.println("Random Characters in Lower Case: " + getCharLowerCase(2)); 
                            else if(this.containsStartWith(commands,"--char3"))
                                System.out.println("Random Characters in Lower Case: " + getCharLowerCase(3)); 
                            else if(this.containsStartWith(commands,"--char4"))
                                System.out.println("Random Characters in Lower Case: " + getCharLowerCase(4)); 
                            else if(this.containsStartWith(commands,"--char5"))
                                System.out.println("Random Characters in Lower Case: " + getCharLowerCase(5)); 
                            else if(this.containsStartWith(commands,"--char6"))
                                System.out.println("Random Characters in Lower Case: " + getCharLowerCase(6)); 
                            else if(this.containsStartWith(commands,"--char7"))
                                System.out.println("Random Characters in Lower Case: " + getCharLowerCase(7)); 
                            else if(this.containsStartWith(commands,"--char8"))
                                System.out.println("Random Characters in Lower Case: " + getCharLowerCase(8)); 
                            else if(this.containsStartWith(commands,"--char9"))
                                System.out.println("Random Characters in Lower Case: " + getCharLowerCase(9)); 
                            else if(this.containsStartWith(commands,"--char10"))
                                System.out.println("Random Characters in Lower Case: " + getCharLowerCase(10)); 
                            
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
                
                
                
                
                
                
                
                
                //For Simple Email64
                else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
                && this.containsEqualsIgnoreCase(commands,"--FROMMAIL"))
                {
                    try
                    {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i>=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("From Mail: " + Base64.getEncoder().encodeToString((getFromEmail(from[0].toString()).getBytes()))); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString((processMessageBody(message)).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
                else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
                && this.containsEqualsIgnoreCase(commands,"--FROMNAME"))
                {
                    try
                    {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i>=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("From Name: " + Base64.getEncoder().encodeToString(getFromName((from[0].toString())).getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString((processMessageBody(message)).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
                else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
                && this.containsEqualsIgnoreCase(commands,"--SUBJECT"))
                {
                    try
                    {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i>=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Subject: " + Base64.getEncoder().encodeToString((message.getSubject()).getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString((processMessageBody(message)).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
                else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
                && this.containsEqualsIgnoreCase(commands,"--RANDOMIP"))
                {
                    try
                    {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i>=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random IP: " + Base64.getEncoder().encodeToString((getRandomIP()).getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString((processMessageBody(message)).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
                else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
                && this.containsEqualsIgnoreCase(commands,"--USERNAME"))
                {
                    try
                    {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i>=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("User Name: " + Base64.getEncoder().encodeToString(getUserName(getFromEmail(from[0].toString())).getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
                else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
                && this.containsEqualsIgnoreCase(commands,"--EMAILCENSORED"))
                {
                    try
                    {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i>=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Email Censored: " + Base64.getEncoder().encodeToString(getEmailCensored(getFromEmail(from[0].toString())).getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
                else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
                && this.containsEqualsIgnoreCase(commands,"--DOMAINFULL"))
                {
                    try
                    {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i>=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Doamin Full: " + Base64.getEncoder().encodeToString(getDomainFull(getFromEmail(from[0].toString())).getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
                else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
                && this.containsEqualsIgnoreCase(commands,"--DOMAINNAME"))
                {
                    try
                    {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i>=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Domain Name: " + Base64.getEncoder().encodeToString(getDomainName(getFromEmail(from[0].toString())).getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
                else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
                && this.containsEqualsIgnoreCase(commands,"--COUNTRY"))
                {
                    try
                    {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i>=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random Country: " + Base64.getEncoder().encodeToString(getRandomCountry().getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
                else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
                && this.containsEqualsIgnoreCase(commands,"--DATE"))
                {
                    try
                    {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i>=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Today's Date: " + Base64.getEncoder().encodeToString(getDate().getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
                else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
                && this.containsEqualsIgnoreCase(commands,"--DATETOMORROW"))
                {
                    try
                    {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i>=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Date Tomorrow: " + Base64.getEncoder().encodeToString(getTomorrowDate().getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
                else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
                && this.containsEqualsIgnoreCase(commands,"--TIME"))
                {
                    try
                    {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i>=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Time: " + Base64.getEncoder().encodeToString(getTime().getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
                else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
                && this.containsEqualsIgnoreCase(commands,"--PC_OS"))
                {
                    try
                    {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i>=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random PC OS: " + Base64.getEncoder().encodeToString(getRandomPCOS().getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
                else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
                && this.containsEqualsIgnoreCase(commands,"--PC_BROWSER"))
                {
                    try
                    {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i>=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random PC Browser: " + Base64.getEncoder().encodeToString(getRandomPCBrowser().getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
                else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
                && this.containsEqualsIgnoreCase(commands,"--COUNTRYCITY"))
                {
                    try
                    {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i>=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random Country City: " + Base64.getEncoder().encodeToString(getRandomCity().getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
                else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
                && this.containsEqualsIgnoreCase(commands,"--ANDROID_OS"))
                {
                    try
                    {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i>=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random Android OS: " + Base64.getEncoder().encodeToString(getRandomAndroidOS().getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
                else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
                && this.containsEqualsIgnoreCase(commands,"--ANDROID_BROWSER"))
                {
                    try
                    {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i>=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random Android Browser: " + Base64.getEncoder().encodeToString(getRandomAndroidBrowser().getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
                else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
                && this.containsEqualsIgnoreCase(commands,"--UA"))
                {
                    try
                    {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i>=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random User Agent: " + Base64.getEncoder().encodeToString(getRandomUserAgent().getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
                else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
                && this.containsEqualsIgnoreCase(commands,"--APPLEAPPS"))
                {
                    try
                    {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i>=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random Apple App: " + Base64.getEncoder().encodeToString(getRandomAppleApps().getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
                else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
                && this.containsEqualsIgnoreCase(commands,"--APPLEPC"))
                {
                    try
                    {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i>=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random Apple PC: " + Base64.getEncoder().encodeToString(getRandomAppleLaptops().getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
                else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
                && this.containsEqualsIgnoreCase(commands,"--APPLEPHONES"))
                {
                    try
                    {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i>=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random Apple Phone: " + Base64.getEncoder().encodeToString(getRandomApplePhones().getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
                else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
                && this.containsEqualsIgnoreCase(commands,"--UNIVERSAL_BROWSER"))
                {
                    try
                    {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i>=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random Universal Browser: " + Base64.getEncoder().encodeToString(getRandomUniversalBrowser().getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
                else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
                && this.containsEqualsIgnoreCase(commands,"--RANDSTRING"))
                {
                    try
                    {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i>=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            if(this.containsEquals(commands,"--randstring"))
                                System.out.println("Random String in lowercase: " + Base64.getEncoder().encodeToString(getRandomStringLowerCase().getBytes())); 
                            else if(this.containsEquals(commands,"--RANDSTRING"))
                                System.out.println("Random String in UpperCase : " + Base64.getEncoder().encodeToString(getRandomStringUpperCase().getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
                else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
                && this.containsStartWith(commands,"--NUMBER"))
                {
                    try
                    {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i>=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            
                            if(this.containsStartWith(commands,"--NUMBER1"))
                                System.out.println("Random Number: " + Base64.getEncoder().encodeToString(getNumbers(1).getBytes())); 
                            else if(this.containsStartWith(commands,"--NUMBER2"))
                                System.out.println("Random Number: " + Base64.getEncoder().encodeToString(getNumbers(2).getBytes()));
                            else if(this.containsStartWith(commands,"--NUMBER3"))
                                System.out.println("Random Number: " + Base64.getEncoder().encodeToString(getNumbers(3).getBytes()));
                            else if(this.containsStartWith(commands,"--NUMBER4"))
                                System.out.println("Random Number: " + Base64.getEncoder().encodeToString(getNumbers(4).getBytes()));
                            else if(this.containsStartWith(commands,"--NUMBER5"))
                                System.out.println("Random Number: " + Base64.getEncoder().encodeToString(getNumbers(5).getBytes()));
                            else if(this.containsStartWith(commands,"--NUMBER6"))
                                System.out.println("Random Number: " + Base64.getEncoder().encodeToString(getNumbers(6).getBytes()));
                            else if(this.containsStartWith(commands,"--NUMBER7"))
                                System.out.println("Random Number: " + Base64.getEncoder().encodeToString(getNumbers(7).getBytes()));
                            else if(this.containsStartWith(commands,"--NUMBER8"))
                                System.out.println("Random Number: " + Base64.getEncoder().encodeToString(getNumbers(8).getBytes()));
                            else if(this.containsStartWith(commands,"--NUMBER9"))
                                System.out.println("Random Number: " +Base64.getEncoder().encodeToString( getNumbers(9).getBytes()));
                            else if(this.containsStartWith(commands,"--NUMBER10"))
                                System.out.println("Random Number: " + Base64.getEncoder().encodeToString(getNumbers(10).getBytes()));
                            
                            
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
                else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
                && this.containsStartWith(commands,"--CHAR"))
                {
                    try
                    {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i>=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            
                            if(this.containsStartWith(commands,"--CHAR1"))
                                System.out.println("Random Characters in Upper Case: " + Base64.getEncoder().encodeToString(getCharUpperCase(1).getBytes())); 
                            else if(this.containsStartWith(commands,"--CHAR2"))
                                System.out.println("Random Characters in Upper Case: " + Base64.getEncoder().encodeToString(getCharUpperCase(2).getBytes()));
                            else if(this.containsStartWith(commands,"--CHAR3"))
                                System.out.println("Random Characters in Upper Case: " + Base64.getEncoder().encodeToString(getCharUpperCase(3).getBytes())); 
                            else if(this.containsStartWith(commands,"--CHAR4"))
                                System.out.println("Random Characters in Upper Case: " + Base64.getEncoder().encodeToString(getCharUpperCase(4).getBytes())); 
                            else if(this.containsStartWith(commands,"--CHAR5"))
                                System.out.println("Random Characters in Upper Case: " + Base64.getEncoder().encodeToString(getCharUpperCase(5).getBytes())); 
                            else if(this.containsStartWith(commands,"--CHAR6"))
                                System.out.println("Random Characters in Upper Case: " + Base64.getEncoder().encodeToString(getCharUpperCase(6).getBytes())); 
                            else if(this.containsStartWith(commands,"--CHAR7"))
                                System.out.println("Random Characters in Upper Case: " + Base64.getEncoder().encodeToString(getCharUpperCase(7).getBytes())); 
                            else if(this.containsStartWith(commands,"--CHAR8"))
                                System.out.println("Random Characters in Upper Case: " + Base64.getEncoder().encodeToString(getCharUpperCase(8).getBytes())); 
                            else if(this.containsStartWith(commands,"--CHAR9"))
                                System.out.println("Random Characters in Upper Case: " + Base64.getEncoder().encodeToString(getCharUpperCase(9).getBytes())); 
                            else if(this.containsStartWith(commands,"--CHAR10"))
                                System.out.println("Random Characters in Upper Case: " + Base64.getEncoder().encodeToString(getCharUpperCase(10).getBytes()));
                            else if(this.containsStartWith(commands,"--char1"))
                                System.out.println("Random Characters in Lower Case: " + Base64.getEncoder().encodeToString(getCharLowerCase(1).getBytes())); 
                            else if(this.containsStartWith(commands,"--char2"))
                                System.out.println("Random Characters in Lower Case: " +Base64.getEncoder().encodeToString( getCharLowerCase(2).getBytes())); 
                            else if(this.containsStartWith(commands,"--char3"))
                                System.out.println("Random Characters in Lower Case: " + Base64.getEncoder().encodeToString(getCharLowerCase(3).getBytes())); 
                            else if(this.containsStartWith(commands,"--char4"))
                                System.out.println("Random Characters in Lower Case: " + Base64.getEncoder().encodeToString(getCharLowerCase(4).getBytes())); 
                            else if(this.containsStartWith(commands,"--char5"))
                                System.out.println("Random Characters in Lower Case: " + Base64.getEncoder().encodeToString(getCharLowerCase(5).getBytes())); 
                            else if(this.containsStartWith(commands,"--char6"))
                                System.out.println("Random Characters in Lower Case: " + Base64.getEncoder().encodeToString(getCharLowerCase(6).getBytes())); 
                            else if(this.containsStartWith(commands,"--char7"))
                                System.out.println("Random Characters in Lower Case: " + Base64.getEncoder().encodeToString(getCharLowerCase(7).getBytes())); 
                            else if(this.containsStartWith(commands,"--char8"))
                                System.out.println("Random Characters in Lower Case: " +Base64.getEncoder().encodeToString( getCharLowerCase(8).getBytes())); 
                            else if(this.containsStartWith(commands,"--char9"))
                                System.out.println("Random Characters in Lower Case: " + Base64.getEncoder().encodeToString(getCharLowerCase(9).getBytes())); 
                            else if(this.containsStartWith(commands,"--char10"))
                                System.out.println("Random Characters in Lower Case: " + Base64.getEncoder().encodeToString(getCharLowerCase(10).getBytes())); 
                            
                            
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
                else
                {
                    System.out.println("Invalid Syntax/Command!");
                }
                
    }
    
    //Test Sucessful 
    public void switchCase4(String[] commands)
    {
        //For Email
                if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
                && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL"))
                {
                    try
                    {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("From Email: "+ getFromEmail(from[0].toString()));
                            System.out.println("Subject: " + message.getSubject()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
                else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
                && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMNAME"))
                {
                    try
                    {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("From Name: "+ getFromName(from[0].toString()));
                            System.out.println("Subject: " + message.getSubject()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
                else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
                && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--RANDOMIP"))
                {
                    try
                    {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random IP : "+ getRandomIP());
                            System.out.println("Subject: " + message.getSubject()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
                else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
                && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--USERNAME"))
                {
                    try
                    {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("User Name : "+ getUserName(this.getFromEmail(from[0].toString())));
                            System.out.println("Subject: " + message.getSubject()); 
                            System.out.println("Email :");  
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }    
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
                else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
                && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--EMAILCENSORED"))
                {
                    try
                    {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Email Censored: "+ getEmailCensored(getFromEmail(from[0].toString())));
                            System.out.println("Subject: " + message.getSubject()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
                else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
                && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--DOMAINFULL"))
                {
                    try
                    {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Domain Full : "+ getDomainFull(getFromEmail(from[0].toString())));
                            System.out.println("Subject: " + message.getSubject()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
                else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
                && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--DOMAINNAME"))
                {
                    try
                    {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Domain Name: "+ getDomainName(getFromEmail(from[0].toString())));
                            System.out.println("Subject: " + message.getSubject()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
                else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
                && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--COUNTRY"))
                {
                    try
                    {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random Country : "+ getRandomCountry());
                            System.out.println("Subject: " + message.getSubject()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
                else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
                && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--DATE"))
                {
                    try
                    {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Today's Date: "+ getDate());
                            System.out.println("Subject: " + message.getSubject()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
                else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
                && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--DATETOMORROW"))
                {
                    try
                    {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Date Tomorrow : "+ getTomorrowDate());
                            System.out.println("Subject: " + message.getSubject()); 
                            System.out.println("Email:"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
                else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
                && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--TIME"))
                {
                    try
                    {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Time: "+ getTime());
                            System.out.println("Subject: " + message.getSubject()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
                else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
                && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--PC_OS"))
                {
                    try
                    {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random PC OS: "+ getRandomPCOS());
                            System.out.println("Subject: " + message.getSubject()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
                else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
                && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--PC_BROWSER"))
                {
                    try
                    {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random PC Browser: "+ getRandomPCBrowser());
                            System.out.println("Subject: " + message.getSubject()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
                else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
                && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--COUNTRYCITY"))
                {
                    try
                    {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random Country City: "+ getRandomCity());
                            System.out.println("Subject: " + message.getSubject()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
                else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
                && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--ANDROID_OS"))
                {
                    try
                    {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random Android OS: "+ getRandomAndroidOS());
                            System.out.println("Subject: " + message.getSubject()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
                && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--ANDROID_BROWSER"))
                {
                    try
                    {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random Android Browser: "+ getRandomAndroidBrowser());
                            System.out.println("Subject: " + message.getSubject()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
                else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
                && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--UA"))
                {
                    try
                    {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random User Agent: "+getRandomUserAgent());
                            System.out.println("Subject: " + message.getSubject()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
                else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
                && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--APPLEAPPS"))
                {
                    try
                    {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random Apple App: "+ getRandomAppleApps());
                            System.out.println("Subject: " + message.getSubject()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
                else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
                && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--APPLEPC"))
                {
                    try
                    {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random Apple PC: "+ getRandomAppleLaptops());
                            System.out.println("Subject: " + message.getSubject()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
                else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
                && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--APPLEPHONES"))
                {
                    try
                    {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random Apple Phone: "+ getRandomApplePhones());
                            System.out.println("Subject: " + message.getSubject()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
                else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
                && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--UNIVERSAL_BROWSER"))
                {
                    try
                    {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random Universal Browser: "+ getRandomUniversalBrowser());
                            System.out.println("Subject: " + message.getSubject()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
                else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
                && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--RANDSTRING"))
                {
                    try
                    {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate());
                            System.out.println("Subject: "+message.getSubject());
                            if(this.containsEquals(commands,"--randstring"))
                                System.out.println("Random String in lowercase: " + getRandomStringLowerCase()); 
                            else if(this.containsEquals(commands,"--RANDSTRING"))
                                System.out.println("Random String in UpperCase : " + getRandomStringUpperCase()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
                else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
                && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsStartWith(commands,"--NUMBER"))
                {
                    try
                    {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Subject: "+message.getSubject());
                            if(this.containsStartWith(commands,"--NUMBER1"))
                                System.out.println("Random Number: " + getNumbers(1)); 
                            else if(this.containsStartWith(commands,"--NUMBER2"))
                                System.out.println("Random Number: " + getNumbers(2));
                            else if(this.containsStartWith(commands,"--NUMBER3"))
                                System.out.println("Random Number: " + getNumbers(3));
                            else if(this.containsStartWith(commands,"--NUMBER4"))
                                System.out.println("Random Number: " + getNumbers(4));
                            else if(this.containsStartWith(commands,"--NUMBER5"))
                                System.out.println("Random Number: " + getNumbers(5));
                            else if(this.containsStartWith(commands,"--NUMBER6"))
                                System.out.println("Random Number: " + getNumbers(6));
                            else if(this.containsStartWith(commands,"--NUMBER7"))
                                System.out.println("Random Number: " + getNumbers(7));
                            else if(this.containsStartWith(commands,"--NUMBER8"))
                                System.out.println("Random Number: " + getNumbers(8));
                            else if(this.containsStartWith(commands,"--NUMBER9"))
                                System.out.println("Random Number: " + getNumbers(9));
                            else if(this.containsStartWith(commands,"--NUMBER10"))
                                System.out.println("Random Number: " + getNumbers(10));
                            
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
                else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
                && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsStartWith(commands,"--CHAR"))
                {
                    try
                    {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-2 ; i < messages.length; i++)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Subject: "+message.getSubject());
                            if(this.containsStartWith(commands,"--CHAR1"))
                                System.out.println("Random Characters in Upper Case: " + getCharUpperCase(1)); 
                            else if(this.containsStartWith(commands,"--CHAR2"))
                                System.out.println("Random Characters in Upper Case: " + getCharUpperCase(2));
                            else if(this.containsStartWith(commands,"--CHAR3"))
                                System.out.println("Random Characters in Upper Case: " + getCharUpperCase(3)); 
                            else if(this.containsStartWith(commands,"--CHAR4"))
                                System.out.println("Random Characters in Upper Case: " + getCharUpperCase(4)); 
                            else if(this.containsStartWith(commands,"--CHAR5"))
                                System.out.println("Random Characters in Upper Case: " + getCharUpperCase(5)); 
                            else if(this.containsStartWith(commands,"--CHAR6"))
                                System.out.println("Random Characters in Upper Case: " + getCharUpperCase(6)); 
                            else if(this.containsStartWith(commands,"--CHAR7"))
                                System.out.println("Random Characters in Upper Case: " + getCharUpperCase(7)); 
                            else if(this.containsStartWith(commands,"--CHAR8"))
                                System.out.println("Random Characters in Upper Case: " + getCharUpperCase(8)); 
                            else if(this.containsStartWith(commands,"--CHAR9"))
                                System.out.println("Random Characters in Upper Case: " + getCharUpperCase(9)); 
                            else if(this.containsStartWith(commands,"--CHAR10"))
                                System.out.println("Random Characters in Upper Case: " + getCharUpperCase(10));
                            else if(this.containsStartWith(commands,"--char1"))
                                System.out.println("Random Characters in Lower Case: " + getCharLowerCase(1)); 
                            else if(this.containsStartWith(commands,"--char2"))
                                System.out.println("Random Characters in Lower Case: " + getCharLowerCase(2)); 
                            else if(this.containsStartWith(commands,"--char3"))
                                System.out.println("Random Characters in Lower Case: " + getCharLowerCase(3)); 
                            else if(this.containsStartWith(commands,"--char4"))
                                System.out.println("Random Characters in Lower Case: " + getCharLowerCase(4)); 
                            else if(this.containsStartWith(commands,"--char5"))
                                System.out.println("Random Characters in Lower Case: " + getCharLowerCase(5)); 
                            else if(this.containsStartWith(commands,"--char6"))
                                System.out.println("Random Characters in Lower Case: " + getCharLowerCase(6)); 
                            else if(this.containsStartWith(commands,"--char7"))
                                System.out.println("Random Characters in Lower Case: " + getCharLowerCase(7)); 
                            else if(this.containsStartWith(commands,"--char8"))
                                System.out.println("Random Characters in Lower Case: " + getCharLowerCase(8)); 
                            else if(this.containsStartWith(commands,"--char9"))
                                System.out.println("Random Characters in Lower Case: " + getCharLowerCase(9)); 
                            else if(this.containsStartWith(commands,"--char10"))
                                System.out.println("Random Characters in Lower Case: " + getCharLowerCase(10)); 
                            
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
                            
                //Email64
                
                
                if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
                && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL"))
                {
                    try
                    {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0 ; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("From Email: "+ Base64.getEncoder().encodeToString(getFromEmail(from[0].toString()).getBytes()));
                            System.out.println("Subject: " + Base64.getEncoder().encodeToString(message.getSubject().getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
                else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
                && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMNAME"))
                {
                    try
                    {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0 ; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("From Name: "+ Base64.getEncoder().encodeToString(getFromName(from[0].toString()).getBytes()));
                            System.out.println("Subject: " + Base64.getEncoder().encodeToString(message.getSubject().getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
                else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
                && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--RANDOMIP"))
                {
                    try
                    {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0 ; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random IP : "+ Base64.getEncoder().encodeToString(getRandomIP().getBytes()));
                            System.out.println("Subject: " + Base64.getEncoder().encodeToString(message.getSubject().getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
                else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
                && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--USERNAME"))
                {
                    try
                    {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0 ; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("User Name : "+ Base64.getEncoder().encodeToString(getUserName(this.getFromEmail(from[0].toString())).getBytes()));
                            System.out.println("Subject: " + Base64.getEncoder().encodeToString(message.getSubject().getBytes())); 
                            System.out.println("Email :");  
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }    
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
                else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
                && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--EMAILCENSORED"))
                {
                    try
                    {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0 ; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Email Censored: "+ Base64.getEncoder().encodeToString(getEmailCensored(getFromEmail(from[0].toString())).getBytes()));
                            System.out.println("Subject: " + Base64.getEncoder().encodeToString(message.getSubject().getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
                else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
                && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--DOMAINFULL"))
                {
                    try
                    {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0 ; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Domain Full : "+ Base64.getEncoder().encodeToString(getDomainFull(getFromEmail(from[0].toString())).getBytes()));
                            System.out.println("Subject: " + Base64.getEncoder().encodeToString(message.getSubject().getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
                else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
                && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--DOMAINNAME"))
                {
                    try
                    {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0 ; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Domain Name: "+ Base64.getEncoder().encodeToString(getDomainName(getFromEmail(from[0].toString())).getBytes()));
                            System.out.println("Subject: " + Base64.getEncoder().encodeToString(message.getSubject().getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
                else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
                && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--COUNTRY"))
                {
                    try
                    {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0 ; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random Country : "+ Base64.getEncoder().encodeToString(getRandomCountry().getBytes()));
                            System.out.println("Subject: " +Base64.getEncoder().encodeToString( message.getSubject().getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
                else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
                && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--DATE"))
                {
                    try
                    {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0 ; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Today's Date: "+Base64.getEncoder().encodeToString( getDate().getBytes()));
                            System.out.println("Subject: " +Base64.getEncoder().encodeToString( message.getSubject().getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
                else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
                && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--DATETOMORROW"))
                {
                    try
                    {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0 ; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Date Tomorrow : "+ Base64.getEncoder().encodeToString(getTomorrowDate().getBytes()));
                            System.out.println("Subject: " + Base64.getEncoder().encodeToString(message.getSubject().getBytes())); 
                            System.out.println("Email:"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
                else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
                && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--TIME"))
                {
                    try
                    {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0 ; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Time: "+ Base64.getEncoder().encodeToString(getTime().getBytes()));
                            System.out.println("Subject: " +Base64.getEncoder().encodeToString( message.getSubject().getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
                else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
                && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--PC_OS"))
                {
                    try
                    {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0 ; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random PC OS: "+Base64.getEncoder().encodeToString( getRandomPCOS().getBytes()));
                            System.out.println("Subject: " + Base64.getEncoder().encodeToString(message.getSubject().getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
                else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
                && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--PC_BROWSER"))
                {
                    try
                    {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0 ; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random PC Browser: "+ Base64.getEncoder().encodeToString(getRandomPCBrowser().getBytes()));
                            System.out.println("Subject: " +Base64.getEncoder().encodeToString( message.getSubject().getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
                else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
                && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--COUNTRYCITY"))
                {
                    try
                    {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0 ; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random Country City: "+ Base64.getEncoder().encodeToString(getRandomCity().getBytes()));
                            System.out.println("Subject: " + Base64.getEncoder().encodeToString(message.getSubject().getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
                else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
                && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--ANDROID_OS"))
                {
                    try
                    {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0 ; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random Android OS: "+ Base64.getEncoder().encodeToString(getRandomAndroidOS().getBytes()));
                            System.out.println("Subject: " + Base64.getEncoder().encodeToString(message.getSubject().getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
                && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--ANDROID_BROWSER"))
                {
                    try
                    {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0 ; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random Android Browser: "+ Base64.getEncoder().encodeToString(getRandomAndroidBrowser().getBytes()));
                            System.out.println("Subject: " + Base64.getEncoder().encodeToString(message.getSubject().getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
                else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
                && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--UA"))
                {
                    try
                    {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0 ; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random User Agent: "+ Base64.getEncoder().encodeToString(getRandomUserAgent().getBytes()));
                            System.out.println("Subject: " + Base64.getEncoder().encodeToString(message.getSubject().getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
                else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
                && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--APPLEAPPS"))
                {
                    try
                    {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0 ; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random Apple App: "+ Base64.getEncoder().encodeToString(getRandomAppleApps().getBytes()));
                            System.out.println("Subject: " + Base64.getEncoder().encodeToString(message.getSubject().getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
                else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
                && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--APPLEPC"))
                {
                    try
                    {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0 ; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random Apple PC: "+Base64.getEncoder().encodeToString(getRandomAppleLaptops().getBytes()));
                            System.out.println("Subject: " + Base64.getEncoder().encodeToString(message.getSubject().getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
                else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
                && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--APPLEPHONES"))
                {
                    try
                    {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0 ; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random Apple Phone: "+ Base64.getEncoder().encodeToString(getRandomApplePhones().getBytes()));
                            System.out.println("Subject: " + Base64.getEncoder().encodeToString(message.getSubject().getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
                else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
                && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--UNIVERSAL_BROWSER"))
                {
                    try
                    {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0 ; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random Universal Browser: "+ Base64.getEncoder().encodeToString(getRandomUniversalBrowser().getBytes()));
                            System.out.println("Subject: " + Base64.getEncoder().encodeToString(message.getSubject().getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
             
                 else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
                && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--RANDSTRING"))
                {
                    try
                    {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate());
                            System.out.println("Subject: "+Base64.getEncoder().encodeToString(message.getSubject().getBytes()));
                            if(this.containsEquals(commands,"--randstring"))
                                System.out.println("Random String in lowercase: " + Base64.getEncoder().encodeToString(getRandomStringLowerCase().getBytes())); 
                            else if(this.containsEquals(commands,"--RANDSTRING"))
                                System.out.println("Random String in UpperCase : " + Base64.getEncoder().encodeToString(getRandomStringUpperCase().getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
                else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
                && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsStartWith(commands,"--NUMBER"))
                {
                    try
                    {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Subject: "+Base64.getEncoder().encodeToString(message.getSubject().getBytes()));
                            if(this.containsStartWith(commands,"--NUMBER1"))
                                System.out.println("Random Number: " + Base64.getEncoder().encodeToString(getNumbers(1).getBytes())); 
                            else if(this.containsStartWith(commands,"--NUMBER2"))
                                System.out.println("Random Number: " + Base64.getEncoder().encodeToString(getNumbers(2).getBytes()));
                            else if(this.containsStartWith(commands,"--NUMBER3"))
                                System.out.println("Random Number: " + Base64.getEncoder().encodeToString(getNumbers(3).getBytes()));
                            else if(this.containsStartWith(commands,"--NUMBER4"))
                                System.out.println("Random Number: " + Base64.getEncoder().encodeToString(getNumbers(4).getBytes()));
                            else if(this.containsStartWith(commands,"--NUMBER5"))
                                System.out.println("Random Number: " + Base64.getEncoder().encodeToString(getNumbers(5).getBytes()));
                            else if(this.containsStartWith(commands,"--NUMBER6"))
                                System.out.println("Random Number: " + Base64.getEncoder().encodeToString(getNumbers(6).getBytes()));
                            else if(this.containsStartWith(commands,"--NUMBER7"))
                                System.out.println("Random Number: " + Base64.getEncoder().encodeToString(getNumbers(7).getBytes()));
                            else if(this.containsStartWith(commands,"--NUMBER8"))
                                System.out.println("Random Number: " + Base64.getEncoder().encodeToString(getNumbers(8).getBytes()));
                            else if(this.containsStartWith(commands,"--NUMBER9"))
                                System.out.println("Random Number: " + Base64.getEncoder().encodeToString(getNumbers(9).getBytes()));
                            else if(this.containsStartWith(commands,"--NUMBER10"))
                                System.out.println("Random Number: " + Base64.getEncoder().encodeToString(getNumbers(10).getBytes()));
                            
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
                else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
                && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsStartWith(commands,"--CHAR"))
                {
                    try
                    {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-2 ; i < messages.length; i++)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Subject: "+Base64.getEncoder().encodeToString(message.getSubject().getBytes()));
                            if(this.containsStartWith(commands,"--CHAR1"))
                                System.out.println("Random Characters in Upper Case: " + Base64.getEncoder().encodeToString(getCharUpperCase(1).getBytes())); 
                            else if(this.containsStartWith(commands,"--CHAR2"))
                                System.out.println("Random Characters in Upper Case: " +Base64.getEncoder().encodeToString( getCharUpperCase(2).getBytes()));
                            else if(this.containsStartWith(commands,"--CHAR3"))
                                System.out.println("Random Characters in Upper Case: " + Base64.getEncoder().encodeToString(getCharUpperCase(3).getBytes())); 
                            else if(this.containsStartWith(commands,"--CHAR4"))
                                System.out.println("Random Characters in Upper Case: " + Base64.getEncoder().encodeToString(getCharUpperCase(4).getBytes())); 
                            else if(this.containsStartWith(commands,"--CHAR5"))
                                System.out.println("Random Characters in Upper Case: " + Base64.getEncoder().encodeToString(getCharUpperCase(5).getBytes())); 
                            else if(this.containsStartWith(commands,"--CHAR6"))
                                System.out.println("Random Characters in Upper Case: " + Base64.getEncoder().encodeToString(getCharUpperCase(6).getBytes())); 
                            else if(this.containsStartWith(commands,"--CHAR7"))
                                System.out.println("Random Characters in Upper Case: " + Base64.getEncoder().encodeToString(getCharUpperCase(7).getBytes())); 
                            else if(this.containsStartWith(commands,"--CHAR8"))
                                System.out.println("Random Characters in Upper Case: " + Base64.getEncoder().encodeToString(getCharUpperCase(8).getBytes())); 
                            else if(this.containsStartWith(commands,"--CHAR9"))
                                System.out.println("Random Characters in Upper Case: " + Base64.getEncoder().encodeToString(getCharUpperCase(9).getBytes())); 
                            else if(this.containsStartWith(commands,"--CHAR10"))
                                System.out.println("Random Characters in Upper Case: " + Base64.getEncoder().encodeToString(getCharUpperCase(10).getBytes()));
                            else if(this.containsStartWith(commands,"--char1"))
                                System.out.println("Random Characters in Lower Case: " + Base64.getEncoder().encodeToString(getCharLowerCase(1).getBytes())); 
                            else if(this.containsStartWith(commands,"--char2"))
                                System.out.println("Random Characters in Lower Case: " + Base64.getEncoder().encodeToString(getCharLowerCase(2).getBytes())); 
                            else if(this.containsStartWith(commands,"--char3"))
                                System.out.println("Random Characters in Lower Case: " + Base64.getEncoder().encodeToString(getCharLowerCase(3).getBytes())); 
                            else if(this.containsStartWith(commands,"--char4"))
                                System.out.println("Random Characters in Lower Case: " + Base64.getEncoder().encodeToString(getCharLowerCase(4).getBytes())); 
                            else if(this.containsStartWith(commands,"--char5"))
                                System.out.println("Random Characters in Lower Case: " + Base64.getEncoder().encodeToString(getCharLowerCase(5).getBytes())); 
                            else if(this.containsStartWith(commands,"--char6"))
                                System.out.println("Random Characters in Lower Case: " + Base64.getEncoder().encodeToString(getCharLowerCase(6).getBytes())); 
                            else if(this.containsStartWith(commands,"--char7"))
                                System.out.println("Random Characters in Lower Case: " + Base64.getEncoder().encodeToString(getCharLowerCase(7).getBytes())); 
                            else if(this.containsStartWith(commands,"--char8"))
                                System.out.println("Random Characters in Lower Case: " + Base64.getEncoder().encodeToString(getCharLowerCase(8).getBytes())); 
                            else if(this.containsStartWith(commands,"--char9"))
                                System.out.println("Random Characters in Lower Case: " + Base64.getEncoder().encodeToString(getCharLowerCase(9).getBytes())); 
                            else if(this.containsStartWith(commands,"--char10"))
                                System.out.println("Random Characters in Lower Case: " + Base64.getEncoder().encodeToString(getCharLowerCase(10).getBytes())); 
                            
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
            
                }
                else
                {
                    System.out.println("Invalid Syntax/Command!");
                }
    }
    
    //Test Sucessful
    public void switchCase5(String[] commands)
    {
        //For Simple Email
                if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
                && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
                && this.containsEqualsIgnoreCase(commands,"--FROMNAME"))
                {
                    try
                    {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("From Name: " + getFromName(from[0].toString()));
                            System.out.println("From Email: "+ getFromEmail(from[0].toString()));
                            System.out.println("Subject: " + message.getSubject()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
                else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
                && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
                && this.containsEqualsIgnoreCase(commands,"--RANDOMIP"))
                {
                    try
                    {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random IP: " + getRandomIP());
                            System.out.println("From Email: "+ getFromEmail(from[0].toString()));
                            System.out.println("Subject: " + message.getSubject()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
                else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
                && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
                && this.containsEqualsIgnoreCase(commands,"--USERNAME"))
                {
                    try
                    {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("User Name: " + getUserName(getFromEmail(from[0].toString())));
                            System.out.println("From Email: "+ getFromEmail(from[0].toString()));
                            System.out.println("Subject: " + message.getSubject()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
                else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
                && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
                && this.containsEqualsIgnoreCase(commands,"--EMAILCENSORED"))
                {
                    try
                    {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Email Censored: " + getEmailCensored(getFromEmail(from[0].toString())));
                            System.out.println("From Email: "+ getFromEmail(from[0].toString()));
                            System.out.println("Subject: " + message.getSubject()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
                else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
                && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
                && this.containsEqualsIgnoreCase(commands,"--DOMAINFULL"))
                {
                    try
                    {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Domain Full: " + getDomainFull(getFromEmail(from[0].toString())));
                            System.out.println("From Email: "+ getFromEmail(from[0].toString()));
                            System.out.println("Subject: " + message.getSubject()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
                else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
                && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
                && this.containsEqualsIgnoreCase(commands,"--DOMAINNAME"))
                {
                    try
                    {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Domain Name: " + getDomainName(getFromEmail(from[0].toString())));
                            System.out.println("From Email: "+ getFromEmail(from[0].toString()));
                            System.out.println("Subject: " + message.getSubject()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
                else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
                && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
                && this.containsEqualsIgnoreCase(commands,"--COUNTRY"))
                {
                    try
                    {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random Country: "+ getRandomCountry());
                            System.out.println("From Email: "+ getFromEmail(from[0].toString()));
                            System.out.println("Subject: " + message.getSubject()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
                else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
                && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
                && this.containsEqualsIgnoreCase(commands,"--DATE"))
                {
                    try
                    {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Today's Date: " + getDate());
                            System.out.println("From Email: "+ getFromEmail(from[0].toString()));
                            System.out.println("Subject: " + message.getSubject()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
                else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
                && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
                && this.containsEqualsIgnoreCase(commands,"--DATETOMORROW"))
                {
                    try
                    {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Date Tomorrow: " + getTomorrowDate());
                            System.out.println("From Email: "+ getFromEmail(from[0].toString()));
                            System.out.println("Subject: " + message.getSubject()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
                else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
                && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
                && this.containsEqualsIgnoreCase(commands,"--TIME"))
                {
                    try
                    {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Time: " + getTime());
                            System.out.println("From Email: "+ getFromEmail(from[0].toString()));
                            System.out.println("Subject: " + message.getSubject()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
                else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
                && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
                && this.containsEqualsIgnoreCase(commands,"--PC_OS"))
                {
                    try
                    {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random PC OS: " + getRandomPCOS());
                            System.out.println("From Email: "+ getFromEmail(from[0].toString()));
                            System.out.println("Subject: " + message.getSubject()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
                else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
                && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
                && this.containsEqualsIgnoreCase(commands,"--PC_BROWSER"))
                {
                    try
                    {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random PC Browser: " + getRandomPCBrowser());
                            System.out.println("From Email: "+ getFromEmail(from[0].toString()));
                            System.out.println("Subject: " + message.getSubject()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
                else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
                && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
                && this.containsEqualsIgnoreCase(commands,"--COUNTRYCITY"))
                {
                    try
                    {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random Country City: " + getRandomCity());
                            System.out.println("From Email: "+ getFromEmail(from[0].toString()));
                            System.out.println("Subject: " + message.getSubject()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
                else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
                && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
                && this.containsEqualsIgnoreCase(commands,"--ANDROID_OS"))
                {
                    try
                    {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random Android OS: " + getRandomAndroidOS());
                            System.out.println("From Email: "+ getFromEmail(from[0].toString()));
                            System.out.println("Subject: " + message.getSubject()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
                else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
                && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
                && this.containsEqualsIgnoreCase(commands,"--ANDROID_BROWSER"))
                {
                    try
                    {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random Android Browser: " + getRandomAndroidBrowser());
                            System.out.println("From Email: "+ getFromEmail(from[0].toString()));
                            System.out.println("Subject: " + message.getSubject()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
                else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
                && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
                && this.containsEqualsIgnoreCase(commands,"--UA"))
                {
                    try
                    {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("User Agent: " + getRandomUserAgent());
                            System.out.println("From Email: "+ getFromEmail(from[0].toString()));
                            System.out.println("Subject: " + message.getSubject()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
                else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
                && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
                && this.containsEqualsIgnoreCase(commands,"--APPLEAPPS"))
                {
                    try
                    {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random Apple Apps: " + getRandomAppleApps());
                            System.out.println("From Email: "+ getFromEmail(from[0].toString()));
                            System.out.println("Subject: " + message.getSubject()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
                else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
                && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
                && this.containsEqualsIgnoreCase(commands,"--APPLEPC"))
                {
                    try
                    {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random Apple PC: " + getRandomAppleLaptops());
                            System.out.println("From Email: "+ getFromEmail(from[0].toString()));
                            System.out.println("Subject: " + message.getSubject()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
                else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
                && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
                && this.containsEqualsIgnoreCase(commands,"--APPLEPHONES"))
                {
                    try
                    {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random Apple Phone: " + getRandomApplePhones());
                            System.out.println("From Email: "+ getFromEmail(from[0].toString()));
                            System.out.println("Subject: " + message.getSubject()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
                else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
                && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
                && this.containsEqualsIgnoreCase(commands,"--UNIVERSAL_BROWSER"))
                {
                    try
                    {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random Universal Browser: " + getRandomUniversalBrowser());
                            System.out.println("From Email: "+ getFromEmail(from[0].toString()));
                            System.out.println("Subject: " + message.getSubject()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
                else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
                && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
                && this.containsEqualsIgnoreCase(commands,"--RANDSTRING"))
                {
                    try
                    {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            if(this.containsEquals(commands,"--randstring"))
                                System.out.println("Random String in lowercase: " + getRandomStringLowerCase()); 
                            else if(this.containsEquals(commands,"--RANDSTRING"))
                                System.out.println("Random String in UpperCase : " + getRandomStringUpperCase());
                            
                            System.out.println("From Email: "+ getFromEmail(from[0].toString()));
                            System.out.println("Subject: " + message.getSubject()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
                else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
                && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
                && this.containsStartWith(commands,"--CHAR"))
                {
                    try
                    {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            if(this.containsStartWith(commands,"--CHAR1"))
                                System.out.println("Random Characters in Upper Case: " + getCharUpperCase(1)); 
                            else if(this.containsStartWith(commands,"--CHAR2"))
                                System.out.println("Random Characters in Upper Case: " + getCharUpperCase(2));
                            else if(this.containsStartWith(commands,"--CHAR3"))
                                System.out.println("Random Characters in Upper Case: " + getCharUpperCase(3)); 
                            else if(this.containsStartWith(commands,"--CHAR4"))
                                System.out.println("Random Characters in Upper Case: " + getCharUpperCase(4)); 
                            else if(this.containsStartWith(commands,"--CHAR5"))
                                System.out.println("Random Characters in Upper Case: " + getCharUpperCase(5)); 
                            else if(this.containsStartWith(commands,"--CHAR6"))
                                System.out.println("Random Characters in Upper Case: " + getCharUpperCase(6)); 
                            else if(this.containsStartWith(commands,"--CHAR7"))
                                System.out.println("Random Characters in Upper Case: " + getCharUpperCase(7)); 
                            else if(this.containsStartWith(commands,"--CHAR8"))
                                System.out.println("Random Characters in Upper Case: " + getCharUpperCase(8)); 
                            else if(this.containsStartWith(commands,"--CHAR9"))
                                System.out.println("Random Characters in Upper Case: " + getCharUpperCase(9)); 
                            else if(this.containsStartWith(commands,"--CHAR10"))
                                System.out.println("Random Characters in Upper Case: " + getCharUpperCase(10));
                            else if(this.containsStartWith(commands,"--char1"))
                                System.out.println("Random Characters in Lower Case: " + getCharLowerCase(1)); 
                            else if(this.containsStartWith(commands,"--char2"))
                                System.out.println("Random Characters in Lower Case: " + getCharLowerCase(2)); 
                            else if(this.containsStartWith(commands,"--char3"))
                                System.out.println("Random Characters in Lower Case: " + getCharLowerCase(3)); 
                            else if(this.containsStartWith(commands,"--char4"))
                                System.out.println("Random Characters in Lower Case: " + getCharLowerCase(4)); 
                            else if(this.containsStartWith(commands,"--char5"))
                                System.out.println("Random Characters in Lower Case: " + getCharLowerCase(5)); 
                            else if(this.containsStartWith(commands,"--char6"))
                                System.out.println("Random Characters in Lower Case: " + getCharLowerCase(6)); 
                            else if(this.containsStartWith(commands,"--char7"))
                                System.out.println("Random Characters in Lower Case: " + getCharLowerCase(7)); 
                            else if(this.containsStartWith(commands,"--char8"))
                                System.out.println("Random Characters in Lower Case: " + getCharLowerCase(8)); 
                            else if(this.containsStartWith(commands,"--char9"))
                                System.out.println("Random Characters in Lower Case: " + getCharLowerCase(9)); 
                            else if(this.containsStartWith(commands,"--char10"))
                                System.out.println("Random Characters in Lower Case: " + getCharLowerCase(10)); 
                            
                            System.out.println("From Email: "+ getFromEmail(from[0].toString()));
                            System.out.println("Subject: " + message.getSubject()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
                else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
                && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
                && this.containsStartWith(commands,"--NUMBER"))
                {
                    try
                    {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            if(this.containsStartWith(commands,"--NUMBER1"))
                                System.out.println("Random Number: " + getNumbers(1)); 
                            else if(this.containsStartWith(commands,"--NUMBER2"))
                                System.out.println("Random Number: " + getNumbers(2));
                            else if(this.containsStartWith(commands,"--NUMBER3"))
                                System.out.println("Random Number: " + getNumbers(3));
                            else if(this.containsStartWith(commands,"--NUMBER4"))
                                System.out.println("Random Number: " + getNumbers(4));
                            else if(this.containsStartWith(commands,"--NUMBER5"))
                                System.out.println("Random Number: " + getNumbers(5));
                            else if(this.containsStartWith(commands,"--NUMBER6"))
                                System.out.println("Random Number: " + getNumbers(6));
                            else if(this.containsStartWith(commands,"--NUMBER7"))
                                System.out.println("Random Number: " + getNumbers(7));
                            else if(this.containsStartWith(commands,"--NUMBER8"))
                                System.out.println("Random Number: " + getNumbers(8));
                            else if(this.containsStartWith(commands,"--NUMBER9"))
                                System.out.println("Random Number: " + getNumbers(9));
                            else if(this.containsStartWith(commands,"--NUMBER10"))
                                System.out.println("Random Number: " + getNumbers(10));
                            
                            System.out.println("From Email: "+ getFromEmail(from[0].toString()));
                            System.out.println("Subject: " + message.getSubject()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
                
                
                //EMAIL64
                else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
                && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
                && this.containsEqualsIgnoreCase(commands,"--FROMNAME"))
                {
                    try
                    {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0 ; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("From Name: " + Base64.getEncoder().encodeToString(getFromName(from[0].toString()).getBytes()));
                            System.out.println("From Email: "+ Base64.getEncoder().encodeToString(getFromEmail(from[0].toString()).getBytes()));
                            System.out.println("Subject: " +Base64.getEncoder().encodeToString( message.getSubject().getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
                else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
                && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
                && this.containsEqualsIgnoreCase(commands,"--RANDOMIP"))
                {
                    try
                    {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0 ; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random IP: " + Base64.getEncoder().encodeToString(getRandomIP().getBytes()));
                            System.out.println("From Email: "+ Base64.getEncoder().encodeToString(getFromEmail(from[0].toString()).getBytes()));
                            System.out.println("Subject: " + Base64.getEncoder().encodeToString(message.getSubject().getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
                else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
                && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
                && this.containsEqualsIgnoreCase(commands,"--USERNAME"))
                {
                    try
                    {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0 ; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("User Name: " + Base64.getEncoder().encodeToString(getUserName(getFromEmail(from[0].toString())).getBytes()));
                            System.out.println("From Email: "+ Base64.getEncoder().encodeToString(getFromEmail(from[0].toString()).getBytes()));
                            System.out.println("Subject: " + Base64.getEncoder().encodeToString(message.getSubject().getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
                else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
                && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
                && this.containsEqualsIgnoreCase(commands,"--EMAILCENSORED"))
                {
                    try
                    {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0 ; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Email Censored: " + Base64.getEncoder().encodeToString(getEmailCensored(getFromEmail(from[0].toString())).getBytes()));
                            System.out.println("From Email: "+ Base64.getEncoder().encodeToString(getFromEmail(from[0].toString()).getBytes()));
                            System.out.println("Subject: " + Base64.getEncoder().encodeToString(message.getSubject().getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
                else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
                && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
                && this.containsEqualsIgnoreCase(commands,"--DOMAINFULL"))
                {
                    try
                    {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0 ; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Domain Full: " + getDomainFull(getFromEmail(from[0].toString())));
                            System.out.println("From Email: "+ Base64.getEncoder().encodeToString(getFromEmail(from[0].toString()).getBytes()));
                            System.out.println("Subject: " + Base64.getEncoder().encodeToString(message.getSubject().getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
                else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
                && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
                && this.containsEqualsIgnoreCase(commands,"--DOMAINNAME"))
                {
                    try
                    {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0 ; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Domain Name: " + Base64.getEncoder().encodeToString(getDomainName(getFromEmail(from[0].toString())).getBytes()));
                            System.out.println("From Email: "+ Base64.getEncoder().encodeToString(getFromEmail(from[0].toString()).getBytes()));
                            System.out.println("Subject: " + Base64.getEncoder().encodeToString(message.getSubject().getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
                else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
                && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
                && this.containsEqualsIgnoreCase(commands,"--COUNTRY"))
                {
                    try
                    {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0 ; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random Country: " + Base64.getEncoder().encodeToString(getRandomCountry().getBytes()));
                            System.out.println("From Email: "+ Base64.getEncoder().encodeToString(getFromEmail(from[0].toString()).getBytes()));
                            System.out.println("Subject: " + Base64.getEncoder().encodeToString(message.getSubject().getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
                else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
                && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
                && this.containsEqualsIgnoreCase(commands,"--DATE"))
                {
                    try
                    {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0 ; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Today's Date: " + Base64.getEncoder().encodeToString(getDate().getBytes()));
                            System.out.println("From Email: "+ Base64.getEncoder().encodeToString(getFromEmail(from[0].toString()).getBytes()));
                            System.out.println("Subject: " + Base64.getEncoder().encodeToString(message.getSubject().getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
                else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
                && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
                && this.containsEqualsIgnoreCase(commands,"--DATETOMORROW"))
                {
                    try
                    {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0 ; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Date Tomorrow: " + Base64.getEncoder().encodeToString(getTomorrowDate().getBytes()));
                            System.out.println("From Email: "+ Base64.getEncoder().encodeToString(getFromEmail(from[0].toString()).getBytes()));
                            System.out.println("Subject: " + Base64.getEncoder().encodeToString(message.getSubject().getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
                else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
                && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
                && this.containsEqualsIgnoreCase(commands,"--TIME"))
                {
                    try
                    {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0 ; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Time: " +Base64.getEncoder().encodeToString( getTime().getBytes()));
                            System.out.println("From Email: "+ Base64.getEncoder().encodeToString(getFromEmail(from[0].toString()).getBytes()));
                            System.out.println("Subject: " + Base64.getEncoder().encodeToString(message.getSubject().getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
                else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
                && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
                && this.containsEqualsIgnoreCase(commands,"--PC_OS"))
                {
                    try
                    {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0 ; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random PC OS: " + Base64.getEncoder().encodeToString(getRandomPCOS().getBytes()));
                            System.out.println("From Email: "+ Base64.getEncoder().encodeToString(getFromEmail(from[0].toString()).getBytes()));
                            System.out.println("Subject: " + Base64.getEncoder().encodeToString(message.getSubject().getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
                else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
                && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
                && this.containsEqualsIgnoreCase(commands,"--PC_BROWSER"))
                {
                    try
                    {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0 ; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random PC Browser: " + Base64.getEncoder().encodeToString(getRandomPCBrowser().getBytes()));
                            System.out.println("From Email: "+ Base64.getEncoder().encodeToString(getFromEmail(from[0].toString()).getBytes()));
                            System.out.println("Subject: " + Base64.getEncoder().encodeToString(message.getSubject().getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
                else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
                && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
                && this.containsEqualsIgnoreCase(commands,"--COUNTRY_CITY"))
                {
                    try
                    {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0 ; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random Country City: " + Base64.getEncoder().encodeToString(getRandomCity().getBytes()));
                            System.out.println("From Email: "+ Base64.getEncoder().encodeToString(getFromEmail(from[0].toString()).getBytes()));
                            System.out.println("Subject: " + Base64.getEncoder().encodeToString(message.getSubject().getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
                else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
                && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
                && this.containsEqualsIgnoreCase(commands,"--ANDROID_OS"))
                {
                    try
                    {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0 ; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random Android OS: " + Base64.getEncoder().encodeToString(getRandomAndroidOS().getBytes()));
                            System.out.println("From Email: "+ Base64.getEncoder().encodeToString(getFromEmail(from[0].toString()).getBytes()));
                            System.out.println("Subject: " + Base64.getEncoder().encodeToString(message.getSubject().getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
                else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
                && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
                && this.containsEqualsIgnoreCase(commands,"--ANDROID_BROWSER"))
                {
                    try
                    {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0 ; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random Android Browser: " + Base64.getEncoder().encodeToString(getRandomAndroidBrowser().getBytes()));
                            System.out.println("From Email: "+ Base64.getEncoder().encodeToString(getFromEmail(from[0].toString()).getBytes()));
                            System.out.println("Subject: " + Base64.getEncoder().encodeToString(message.getSubject().getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
                else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
                && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
                && this.containsEqualsIgnoreCase(commands,"--UA"))
                {
                    try
                    {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0 ; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("User Agent: " + Base64.getEncoder().encodeToString(getRandomUserAgent().getBytes()));
                            System.out.println("From Email: "+ Base64.getEncoder().encodeToString(getFromEmail(from[0].toString()).getBytes()));
                            System.out.println("Subject: " + Base64.getEncoder().encodeToString(message.getSubject().getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
                else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
                && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
                && this.containsEqualsIgnoreCase(commands,"--APPLEAPPS"))
                {
                    try
                    {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0 ; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random Apple Apps: " + Base64.getEncoder().encodeToString(getRandomAppleApps().getBytes()));
                            System.out.println("From Email: "+ Base64.getEncoder().encodeToString(getFromEmail(from[0].toString()).getBytes()));
                            System.out.println("Subject: " + Base64.getEncoder().encodeToString(message.getSubject().getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
                else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
                && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
                && this.containsEqualsIgnoreCase(commands,"--APPLEPC"))
                {
                    try
                    {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0 ; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random Apple PC: " + Base64.getEncoder().encodeToString(getRandomAppleLaptops().getBytes()));
                            System.out.println("From Email: "+ Base64.getEncoder().encodeToString(getFromEmail(from[0].toString()).getBytes()));
                            System.out.println("Subject: " + Base64.getEncoder().encodeToString(message.getSubject().getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
                else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
                && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
                && this.containsEqualsIgnoreCase(commands,"--APPLEPHONES"))
                {
                    try
                    {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0 ; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random Apple Phone: " + Base64.getEncoder().encodeToString(getRandomApplePhones().getBytes()));
                            System.out.println("From Email: "+ Base64.getEncoder().encodeToString(getFromEmail(from[0].toString()).getBytes()));
                            System.out.println("Subject: " + Base64.getEncoder().encodeToString(message.getSubject().getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
                else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
                && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
                && this.containsEqualsIgnoreCase(commands,"--UNIVERSAL_BROWSER"))
                {
                    try
                    {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0 ; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random Universal Browser: " + Base64.getEncoder().encodeToString(getRandomUniversalBrowser().getBytes()));
                            System.out.println("From Email: "+ Base64.getEncoder().encodeToString(getFromEmail(from[0].toString()).getBytes()));
                            System.out.println("Subject: " + Base64.getEncoder().encodeToString(message.getSubject().getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
                else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
                && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
                && this.containsEqualsIgnoreCase(commands,"--RANDSTRING"))
                {
                    try
                    {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0 ; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            if(this.containsEquals(commands,"--randstring"))
                                System.out.println("Random String in lowercase: " + Base64.getEncoder().encodeToString(getRandomStringLowerCase().getBytes())); 
                            else if(this.containsEquals(commands,"--RANDSTRING"))
                                System.out.println("Random String in UpperCase : " + Base64.getEncoder().encodeToString(getRandomStringUpperCase().getBytes())); 
                            
                            System.out.println("From Email: "+ Base64.getEncoder().encodeToString(getFromEmail(from[0].toString()).getBytes()));
                            System.out.println("Subject: " + Base64.getEncoder().encodeToString(message.getSubject().getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
                else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
                && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
                && this.containsStartWith(commands,"--CHAR"))
                {
                    try
                    {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0 ; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            if(this.containsStartWith(commands,"--CHAR1"))
                                System.out.println("Random Characters in Upper Case: " + Base64.getEncoder().encodeToString(getCharUpperCase(1).getBytes())); 
                            else if(this.containsStartWith(commands,"--CHAR2"))
                                System.out.println("Random Characters in Upper Case: " +Base64.getEncoder().encodeToString( getCharUpperCase(2).getBytes()));
                            else if(this.containsStartWith(commands,"--CHAR3"))
                                System.out.println("Random Characters in Upper Case: " + Base64.getEncoder().encodeToString(getCharUpperCase(3).getBytes())); 
                            else if(this.containsStartWith(commands,"--CHAR4"))
                                System.out.println("Random Characters in Upper Case: " + Base64.getEncoder().encodeToString(getCharUpperCase(4).getBytes())); 
                            else if(this.containsStartWith(commands,"--CHAR5"))
                                System.out.println("Random Characters in Upper Case: " + Base64.getEncoder().encodeToString(getCharUpperCase(5).getBytes())); 
                            else if(this.containsStartWith(commands,"--CHAR6"))
                                System.out.println("Random Characters in Upper Case: " + Base64.getEncoder().encodeToString(getCharUpperCase(6).getBytes())); 
                            else if(this.containsStartWith(commands,"--CHAR7"))
                                System.out.println("Random Characters in Upper Case: " + Base64.getEncoder().encodeToString(getCharUpperCase(7).getBytes())); 
                            else if(this.containsStartWith(commands,"--CHAR8"))
                                System.out.println("Random Characters in Upper Case: " + Base64.getEncoder().encodeToString(getCharUpperCase(8).getBytes())); 
                            else if(this.containsStartWith(commands,"--CHAR9"))
                                System.out.println("Random Characters in Upper Case: " + Base64.getEncoder().encodeToString(getCharUpperCase(9).getBytes())); 
                            else if(this.containsStartWith(commands,"--CHAR10"))
                                System.out.println("Random Characters in Upper Case: " + Base64.getEncoder().encodeToString(getCharUpperCase(10).getBytes()));
                            else if(this.containsStartWith(commands,"--char1"))
                                System.out.println("Random Characters in Lower Case: " + Base64.getEncoder().encodeToString(getCharLowerCase(1).getBytes())); 
                            else if(this.containsStartWith(commands,"--char2"))
                                System.out.println("Random Characters in Lower Case: " + Base64.getEncoder().encodeToString(getCharLowerCase(2).getBytes())); 
                            else if(this.containsStartWith(commands,"--char3"))
                                System.out.println("Random Characters in Lower Case: " + Base64.getEncoder().encodeToString(getCharLowerCase(3).getBytes())); 
                            else if(this.containsStartWith(commands,"--char4"))
                                System.out.println("Random Characters in Lower Case: " + Base64.getEncoder().encodeToString(getCharLowerCase(4).getBytes())); 
                            else if(this.containsStartWith(commands,"--char5"))
                                System.out.println("Random Characters in Lower Case: " + Base64.getEncoder().encodeToString(getCharLowerCase(5).getBytes())); 
                            else if(this.containsStartWith(commands,"--char6"))
                                System.out.println("Random Characters in Lower Case: " + Base64.getEncoder().encodeToString(getCharLowerCase(6).getBytes())); 
                            else if(this.containsStartWith(commands,"--char7"))
                                System.out.println("Random Characters in Lower Case: " + Base64.getEncoder().encodeToString(getCharLowerCase(7).getBytes())); 
                            else if(this.containsStartWith(commands,"--char8"))
                                System.out.println("Random Characters in Lower Case: " + Base64.getEncoder().encodeToString(getCharLowerCase(8).getBytes())); 
                            else if(this.containsStartWith(commands,"--char9"))
                                System.out.println("Random Characters in Lower Case: " + Base64.getEncoder().encodeToString(getCharLowerCase(9).getBytes())); 
                            else if(this.containsStartWith(commands,"--char10"))
                                System.out.println("Random Characters in Lower Case: " + Base64.getEncoder().encodeToString(getCharLowerCase(10).getBytes())); 
                            
                            
                            System.out.println("From Email: "+ Base64.getEncoder().encodeToString(getFromEmail(from[0].toString()).getBytes()));
                            System.out.println("Subject: " + Base64.getEncoder().encodeToString(message.getSubject().getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
                else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
                && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
                && this.containsStartWith(commands,"--NUMBER"))
                {
                    try
                    {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0 ; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            if(this.containsStartWith(commands,"--NUMBER1"))
                                System.out.println("Random Number: " + (Base64.getEncoder().encodeToString(getNumbers(1).getBytes()))); 
                            else if(this.containsStartWith(commands,"--NUMBER2"))
                                System.out.println("Random Number: " + (Base64.getEncoder().encodeToString(getNumbers(2).getBytes())));
                            else if(this.containsStartWith(commands,"--NUMBER3"))
                                System.out.println("Random Number: " + (Base64.getEncoder().encodeToString(getNumbers(3).getBytes())));
                            else if(this.containsStartWith(commands,"--NUMBER4"))
                                System.out.println("Random Number: " + Base64.getEncoder().encodeToString(getNumbers(4).getBytes()));
                            else if(this.containsStartWith(commands,"--NUMBER5"))
                                System.out.println("Random Number: " + Base64.getEncoder().encodeToString(getNumbers(5).getBytes()));
                            else if(this.containsStartWith(commands,"--NUMBER6"))
                                System.out.println("Random Number: " + Base64.getEncoder().encodeToString(getNumbers(6).getBytes()));
                            else if(this.containsStartWith(commands,"--NUMBER7"))
                                System.out.println("Random Number: " + Base64.getEncoder().encodeToString(getNumbers(7).getBytes()));
                            else if(this.containsStartWith(commands,"--NUMBER8"))
                                System.out.println("Random Number: " + Base64.getEncoder().encodeToString(getNumbers(8).getBytes()));
                            else if(this.containsStartWith(commands,"--NUMBER9"))
                                System.out.println("Random Number: " + Base64.getEncoder().encodeToString(getNumbers(9).getBytes()));
                            else if(this.containsStartWith(commands,"--NUMBER10"))
                                System.out.println("Random Number: " + Base64.getEncoder().encodeToString(getNumbers(10).getBytes()));
                            
                            
                            System.out.println("From Email: "+ Base64.getEncoder().encodeToString(getFromEmail(from[0].toString()).getBytes()));
                            System.out.println("Subject: " + Base64.getEncoder().encodeToString(message.getSubject().getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
                 else
                {
                    System.out.println("Invalid Syntax/Command!");
                }
                
                
    }
     
     //Test Sucessful
    public void switchCase6(String[] commands)
    {
        //FOR SIMPLE EMAIL
        
            if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--RANDOMIP"))
            {
                try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random IP: " + getRandomIP());
                            System.out.println("From Name: " + getFromName(from[0].toString()));
                            System.out.println("From Email: "+ getFromEmail(from[0].toString()));
                            System.out.println("Subject: " + message.getSubject()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
            else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--USERNAME"))
            {
                 try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate());
                            System.out.println("User Name: " + getUserName(getFromEmail(from[0].toString())));
                            System.out.println("From Name: " + getFromName(from[0].toString()));
                            System.out.println("From Email: "+ getFromEmail(from[0].toString()));
                            System.out.println("Subject: " + message.getSubject()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
            }
            else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--EMAILCENSORED"))
            {
                 try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate());
                            System.out.println("Email Censored: " + getEmailCensored(getFromEmail(from[0].toString())));
                            System.out.println("From Name: " + getFromName(from[0].toString()));
                            System.out.println("From Email: "+ getFromEmail(from[0].toString()));
                            System.out.println("Subject: " + message.getSubject()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
            }
            else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--DOMAINFULL"))
            {
                 try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("From Name: " + getFromName(from[0].toString()));
                            System.out.println("Domain Full: " + getDomainFull(getFromEmail(from[0].toString())));
                            System.out.println("From Email: "+ getFromEmail(from[0].toString()));
                            System.out.println("Subject: " + message.getSubject()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
            }
            else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--DOMAINNAME"))
            {
                 try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Domain Name: " + getDomainName(getFromName(from[0].toString())));
                            System.out.println("From Name: " + getFromName(from[0].toString()));
                            System.out.println("From Email: "+ getFromEmail(from[0].toString()));
                            System.out.println("Subject: " + message.getSubject()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
            }
            else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--COUNTRY"))
            {
                 try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random Country: " + getRandomCountry());
                            System.out.println("From Name: " + getFromName(from[0].toString()));
                            System.out.println("From Email: "+ getFromEmail(from[0].toString()));
                            System.out.println("Subject: " + message.getSubject()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
            }
            else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--DATE"))
            {
                 try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate());
                            System.out.println("Today's Date " + getDate());
                            System.out.println("From Name: " + getFromName(from[0].toString()));
                            System.out.println("From Email: "+ getFromEmail(from[0].toString()));
                            System.out.println("Subject: " + message.getSubject()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
            }
            else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--DATETOMORROW"))
            {
                 try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate());
                            System.out.println("Date Tomorrow: " +getTomorrowDate());
                            System.out.println("From Name: " + getFromName(from[0].toString()));
                            System.out.println("From Email: "+ getFromEmail(from[0].toString()));
                            System.out.println("Subject: " + message.getSubject()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
            }
            else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--TIME"))
            {
                 try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Time: " + getTime());
                            System.out.println("From Name: " + getFromName(from[0].toString()));
                            System.out.println("From Email: "+ getFromEmail(from[0].toString()));
                            System.out.println("Subject: " + message.getSubject()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
            }else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--PC_OS"))
            {
                 try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random PC OS: " + getRandomPCOS());
                            System.out.println("From Name: " + getFromName(from[0].toString()));
                            System.out.println("From Email: "+ getFromEmail(from[0].toString()));
                            System.out.println("Subject: " + message.getSubject()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
            }
            else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--PC_BROWSER"))
            {
                 try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random PC Browser: " + getRandomPCBrowser());
                            System.out.println("From Name: " + getFromName(from[0].toString()));
                            System.out.println("From Email: "+ getFromEmail(from[0].toString()));
                            System.out.println("Subject: " + message.getSubject()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
            }
            else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--COUNTRYCITY"))
            {
                 try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random Country City: " + getRandomCity());
                            System.out.println("From Name: " + getFromName(from[0].toString()));
                            System.out.println("From Email: "+ getFromEmail(from[0].toString()));
                            System.out.println("Subject: " + message.getSubject()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
            }
            else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--ANDROID_OS"))
            {
                 try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random Android OS: " + getRandomAndroidOS());
                            System.out.println("From Name: " + getFromName(from[0].toString()));
                            System.out.println("From Email: "+ getFromEmail(from[0].toString()));
                            System.out.println("Subject: " + message.getSubject()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
            }
            else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--ANDROID_BROWSER"))
            {
                 try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate());
                            System.out.println("Random Andoid Browser: " + getRandomAndroidBrowser());
                            System.out.println("From Name: " + getFromName(from[0].toString()));
                            System.out.println("From Email: "+ getFromEmail(from[0].toString()));
                            System.out.println("Subject: " + message.getSubject()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
            }else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--UA"))
            {
                 try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("From User Agnet: " + getRandomUserAgent());
                            System.out.println("From Email: "+ getFromEmail(from[0].toString()));
                            System.out.println("Subject: " + message.getSubject()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
            }
            else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--APPLEAPPS"))
            {
                 try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random Apple Apps: " + getRandomAppleApps());
                            System.out.println("From Name: " + getFromName(from[0].toString()));
                            System.out.println("From Email: "+ getFromEmail(from[0].toString()));
                            System.out.println("Subject: " + message.getSubject()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
            }
            else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--APPLEPC"))
            {
                 try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random Apple PC: " + getRandomAppleLaptops());
                            System.out.println("From Name: " + getFromName(from[0].toString()));
                            System.out.println("From Email: "+ getFromEmail(from[0].toString()));
                            System.out.println("Subject: " + message.getSubject()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
            }
            else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--APPLEPHONES"))
            {
                 try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random Apple Phone: " + getRandomApplePhones());
                            System.out.println("From Name: " + getFromName(from[0].toString()));
                            System.out.println("From Email: "+ getFromEmail(from[0].toString()));
                            System.out.println("Subject: " + message.getSubject()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
            }
            else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--UNIVERSAL_BROWSER"))
            {
                 try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate());
                            System.out.println("Random Universal Browser: " + getRandomUniversalBrowser());
                            System.out.println("From Name: " + getFromName(from[0].toString()));
                            System.out.println("From Email: "+ getFromEmail(from[0].toString()));
                            System.out.println("Subject: " + message.getSubject()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
            }
            else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--RANDSTRING"))
            {
                try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            if(this.containsEquals(commands,"--randstring"))
                                System.out.println("Random String in lowercase: " + getRandomStringLowerCase()); 
                            else if(this.containsEquals(commands,"--RANDSTRING"))
                                System.out.println("Random String in UpperCase : " + getRandomStringUpperCase());

                            
                            
                            System.out.println("From Name: " + getFromName(from[0].toString()));
                            System.out.println("From Email: "+ getFromEmail(from[0].toString()));
                            System.out.println("Subject: " + message.getSubject()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
            }
              
            else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsStartWith(commands,"--NUMBER"))
            {
                try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            if(this.containsStartWith(commands,"--NUMBER1"))
                                System.out.println("Random Number: " + getNumbers(1)); 
                            else if(this.containsStartWith(commands,"--NUMBER2"))
                                System.out.println("Random Number: " + getNumbers(2));
                            else if(this.containsStartWith(commands,"--NUMBER3"))
                                System.out.println("Random Number: " + getNumbers(3));
                            else if(this.containsStartWith(commands,"--NUMBER4"))
                                System.out.println("Random Number: " + getNumbers(4));
                            else if(this.containsStartWith(commands,"--NUMBER5"))
                                System.out.println("Random Number: " + getNumbers(5));
                            else if(this.containsStartWith(commands,"--NUMBER6"))
                                System.out.println("Random Number: " + getNumbers(6));
                            else if(this.containsStartWith(commands,"--NUMBER7"))
                                System.out.println("Random Number: " + getNumbers(7));
                            else if(this.containsStartWith(commands,"--NUMBER8"))
                                System.out.println("Random Number: " + getNumbers(8));
                            else if(this.containsStartWith(commands,"--NUMBER9"))
                                System.out.println("Random Number: " + getNumbers(9));
                            else if(this.containsStartWith(commands,"--NUMBER10"))
                                System.out.println("Random Number: " + getNumbers(10));
                            
                            System.out.println("From Name: " + getFromName(from[0].toString()));
                            System.out.println("From Email: "+ getFromEmail(from[0].toString()));
                            System.out.println("Subject: " + message.getSubject()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
            }
            else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsStartWith(commands,"--CHAR"))
            {
                try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-2 ; i < messages.length; i++)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            
if(this.containsStartWith(commands,"--CHAR1"))
                                System.out.println("Random Characters in Upper Case: " + getCharUpperCase(1)); 
                            else if(this.containsStartWith(commands,"--CHAR2"))
                                System.out.println("Random Characters in Upper Case: " + getCharUpperCase(2));
                            else if(this.containsStartWith(commands,"--CHAR3"))
                                System.out.println("Random Characters in Upper Case: " + getCharUpperCase(3)); 
                            else if(this.containsStartWith(commands,"--CHAR4"))
                                System.out.println("Random Characters in Upper Case: " + getCharUpperCase(4)); 
                            else if(this.containsStartWith(commands,"--CHAR5"))
                                System.out.println("Random Characters in Upper Case: " + getCharUpperCase(5)); 
                            else if(this.containsStartWith(commands,"--CHAR6"))
                                System.out.println("Random Characters in Upper Case: " + getCharUpperCase(6)); 
                            else if(this.containsStartWith(commands,"--CHAR7"))
                                System.out.println("Random Characters in Upper Case: " + getCharUpperCase(7)); 
                            else if(this.containsStartWith(commands,"--CHAR8"))
                                System.out.println("Random Characters in Upper Case: " + getCharUpperCase(8)); 
                            else if(this.containsStartWith(commands,"--CHAR9"))
                                System.out.println("Random Characters in Upper Case: " + getCharUpperCase(9)); 
                            else if(this.containsStartWith(commands,"--CHAR10"))
                                System.out.println("Random Characters in Upper Case: " + getCharUpperCase(10));
                            else if(this.containsStartWith(commands,"--char1"))
                                System.out.println("Random Characters in Lower Case: " + getCharLowerCase(1)); 
                            else if(this.containsStartWith(commands,"--char2"))
                                System.out.println("Random Characters in Lower Case: " + getCharLowerCase(2)); 
                            else if(this.containsStartWith(commands,"--char3"))
                                System.out.println("Random Characters in Lower Case: " + getCharLowerCase(3)); 
                            else if(this.containsStartWith(commands,"--char4"))
                                System.out.println("Random Characters in Lower Case: " + getCharLowerCase(4)); 
                            else if(this.containsStartWith(commands,"--char5"))
                                System.out.println("Random Characters in Lower Case: " + getCharLowerCase(5)); 
                            else if(this.containsStartWith(commands,"--char6"))
                                System.out.println("Random Characters in Lower Case: " + getCharLowerCase(6)); 
                            else if(this.containsStartWith(commands,"--char7"))
                                System.out.println("Random Characters in Lower Case: " + getCharLowerCase(7)); 
                            else if(this.containsStartWith(commands,"--char8"))
                                System.out.println("Random Characters in Lower Case: " + getCharLowerCase(8)); 
                            else if(this.containsStartWith(commands,"--char9"))
                                System.out.println("Random Characters in Lower Case: " + getCharLowerCase(9)); 
                            else if(this.containsStartWith(commands,"--char10"))
                                System.out.println("Random Characters in Lower Case: " + getCharLowerCase(10));

                            
                            System.out.println("From Name: " + getFromName(from[0].toString()));
                            System.out.println("From Email: "+ getFromEmail(from[0].toString()));
                            System.out.println("Subject: " + message.getSubject()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
            }
            //EMAIL64
            else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--RANDOMIP"))
            {
                try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random IP: " + Base64.getEncoder().encodeToString(getRandomIP().getBytes()));
                            System.out.println("From Name: " + Base64.getEncoder().encodeToString(getFromName(from[0].toString()).getBytes()));
                            System.out.println("From Email: "+ Base64.getEncoder().encodeToString(getFromEmail(from[0].toString()).getBytes()));
                            System.out.println("Subject: " + Base64.getEncoder().encodeToString(message.getSubject().getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
            else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--USERNAME"))
            {
                 try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate());
                            System.out.println("User Name: " + Base64.getEncoder().encodeToString(getUserName(getFromEmail(from[0].toString())).getBytes()));
                            System.out.println("From Name: " + Base64.getEncoder().encodeToString(getFromName(from[0].toString()).getBytes()));
                            System.out.println("From Email: "+ Base64.getEncoder().encodeToString(getFromEmail(from[0].toString()).getBytes()));
                            System.out.println("Subject: " + Base64.getEncoder().encodeToString(message.getSubject().getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
            }
            else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--EMAILCENSORED"))
            {
                 try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate());
                            System.out.println("Email Censored: " + Base64.getEncoder().encodeToString(getEmailCensored(getFromEmail(from[0].toString())).getBytes()));
                            System.out.println("From Name: " + Base64.getEncoder().encodeToString(getFromName(from[0].toString()).getBytes()));
                            System.out.println("From Email: "+ Base64.getEncoder().encodeToString(getFromEmail(from[0].toString()).getBytes()));
                            System.out.println("Subject: " + Base64.getEncoder().encodeToString(message.getSubject().getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
            }
            else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--DOMAINFULL"))
            {
                 try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("From Name: " + Base64.getEncoder().encodeToString(getFromName(from[0].toString()).getBytes()));
                            System.out.println("Domain Full: " + Base64.getEncoder().encodeToString(getDomainFull(getFromEmail(from[0].toString())).getBytes()));
                            System.out.println("From Email: "+ Base64.getEncoder().encodeToString(getFromEmail(from[0].toString()).getBytes()));
                            System.out.println("Subject: " + Base64.getEncoder().encodeToString(message.getSubject().getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
            }
            else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--DOMAINNAME"))
            {
                 try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Domain Name: " + Base64.getEncoder().encodeToString(getDomainName(getFromName(from[0].toString())).getBytes()));
                            System.out.println("From Name: " + Base64.getEncoder().encodeToString(getFromName(from[0].toString()).getBytes()));
                            System.out.println("From Email: "+ Base64.getEncoder().encodeToString(getFromEmail(from[0].toString()).getBytes()));
                            System.out.println("Subject: " + Base64.getEncoder().encodeToString(message.getSubject().getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
            }
            else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--COUNTRY"))
            {
                 try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random Country: " + Base64.getEncoder().encodeToString(getRandomCountry().getBytes()));
                            System.out.println("From Name: " + Base64.getEncoder().encodeToString(getFromName(from[0].toString()).getBytes()));
                            System.out.println("From Email: "+ Base64.getEncoder().encodeToString(getFromEmail(from[0].toString()).getBytes()));
                            System.out.println("Subject: " + Base64.getEncoder().encodeToString(message.getSubject().getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
            }
            else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--DATE"))
            {
                 try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate());
                            System.out.println("Today's Date " + Base64.getEncoder().encodeToString(getDate().getBytes()));
                            System.out.println("From Name: " + Base64.getEncoder().encodeToString(getFromName(from[0].toString()).getBytes()));
                            System.out.println("From Email: "+ Base64.getEncoder().encodeToString(getFromEmail(from[0].toString()).getBytes()));
                            System.out.println("Subject: " + Base64.getEncoder().encodeToString(message.getSubject().getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
            }
            else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--DATETOMORROW"))
            {
                 try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate());
                            System.out.println("Date Tomorrow: " +Base64.getEncoder().encodeToString(getTomorrowDate().getBytes()));
                            System.out.println("From Name: " + Base64.getEncoder().encodeToString(getFromName(from[0].toString()).getBytes()));
                            System.out.println("From Email: "+ Base64.getEncoder().encodeToString(getFromEmail(from[0].toString()).getBytes()));
                            System.out.println("Subject: " + Base64.getEncoder().encodeToString(message.getSubject().getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
            }
            else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--TIME"))
            {
                 try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Time: " + Base64.getEncoder().encodeToString(getTime().getBytes()));
                            System.out.println("From Name: " + Base64.getEncoder().encodeToString(getFromName(from[0].toString()).getBytes()));
                            System.out.println("From Email: "+ Base64.getEncoder().encodeToString(getFromEmail(from[0].toString()).getBytes()));
                            System.out.println("Subject: " + Base64.getEncoder().encodeToString(message.getSubject().getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
            }else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--PC_OS"))
            {
                 try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random PC OS: " + Base64.getEncoder().encodeToString(getRandomPCOS().getBytes()));
                            System.out.println("From Name: " + Base64.getEncoder().encodeToString(getFromName(from[0].toString()).getBytes()));
                            System.out.println("From Email: "+ Base64.getEncoder().encodeToString(getFromEmail(from[0].toString()).getBytes()));
                            System.out.println("Subject: " + Base64.getEncoder().encodeToString(message.getSubject().getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
            }
            else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--PC_BROWSER"))
            {
                 try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random PC Browser: " + Base64.getEncoder().encodeToString(getRandomPCBrowser().getBytes()));
                            System.out.println("From Name: " + Base64.getEncoder().encodeToString(getFromName(from[0].toString()).getBytes()));
                            System.out.println("From Email: "+ Base64.getEncoder().encodeToString(getFromEmail(from[0].toString()).getBytes()));
                            System.out.println("Subject: " + Base64.getEncoder().encodeToString(message.getSubject().getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
            }
            else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--COUNTRYCITY"))
            {
                 try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random Country City: " + Base64.getEncoder().encodeToString(getRandomCity().getBytes()));
                            System.out.println("From Name: " + Base64.getEncoder().encodeToString(getFromName(from[0].toString()).getBytes()));
                            System.out.println("From Email: "+ Base64.getEncoder().encodeToString(getFromEmail(from[0].toString()).getBytes()));
                            System.out.println("Subject: " + Base64.getEncoder().encodeToString(message.getSubject().getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
            }
            else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--ANDROID_OS"))
            {
                 try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random Android OS: " + Base64.getEncoder().encodeToString(getRandomAndroidOS().getBytes()));
                            System.out.println("From Name: " + Base64.getEncoder().encodeToString(getFromName(from[0].toString()).getBytes()));
                            System.out.println("From Email: "+ Base64.getEncoder().encodeToString(getFromEmail(from[0].toString()).getBytes()));
                            System.out.println("Subject: " + Base64.getEncoder().encodeToString(message.getSubject().getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
            }
            else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--ANDROID_BROWSER"))
            {
                 try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate());
                            System.out.println("Random Andoid: " + Base64.getEncoder().encodeToString(getRandomAndroidBrowser().getBytes()));
                            System.out.println("From Name: " + Base64.getEncoder().encodeToString(getFromName(from[0].toString()).getBytes()));
                            System.out.println("From Email: "+ Base64.getEncoder().encodeToString(getFromEmail(from[0].toString()).getBytes()));
                            System.out.println("Subject: " + Base64.getEncoder().encodeToString(message.getSubject().getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
            }else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--UA"))
            {
                 try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random User Agent: " + Base64.getEncoder().encodeToString(getRandomUserAgent().getBytes()));
                            System.out.println("From Email: "+ Base64.getEncoder().encodeToString(getFromEmail(from[0].toString()).getBytes()));
                            System.out.println("Subject: " + Base64.getEncoder().encodeToString(message.getSubject().getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
            }
            else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--APPLEAPPS"))
            {
                 try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random Apple Apps: " + Base64.getEncoder().encodeToString(getRandomAppleApps().getBytes()));
                            System.out.println("From Name: " + Base64.getEncoder().encodeToString(getFromName(from[0].toString()).getBytes()));
                            System.out.println("From Email: "+ Base64.getEncoder().encodeToString(getFromEmail(from[0].toString()).getBytes()));
                            System.out.println("Subject: " + Base64.getEncoder().encodeToString(message.getSubject().getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
            }
            else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--APPLEPC"))
            {
                 try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random Apple PC: " + Base64.getEncoder().encodeToString(getRandomAppleLaptops().getBytes()));
                            System.out.println("From Name: " + Base64.getEncoder().encodeToString(getFromName(from[0].toString()).getBytes()));
                            System.out.println("From Email: "+ Base64.getEncoder().encodeToString(getFromEmail(from[0].toString()).getBytes()));
                            System.out.println("Subject: " + Base64.getEncoder().encodeToString(message.getSubject().getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
            }
            else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--APPLEPHONES"))
            {
                 try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random Apple Phone: " + Base64.getEncoder().encodeToString(getRandomApplePhones().getBytes()));
                            System.out.println("From Name: " + Base64.getEncoder().encodeToString(getFromName(from[0].toString()).getBytes()));
                            System.out.println("From Email: "+ Base64.getEncoder().encodeToString(getFromEmail(from[0].toString()).getBytes()));
                            System.out.println("Subject: " + Base64.getEncoder().encodeToString(message.getSubject().getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
            }
            else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--UNIVERSAL_BROWSER"))
            {
                 try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate());
                            System.out.println("Random Universal Browser: " + Base64.getEncoder().encodeToString(getRandomUniversalBrowser().getBytes()));
                            System.out.println("From Name: " + Base64.getEncoder().encodeToString(getFromName(from[0].toString()).getBytes()));
                            System.out.println("From Email: "+ Base64.getEncoder().encodeToString(getFromEmail(from[0].toString()).getBytes()));
                            System.out.println("Subject: " + Base64.getEncoder().encodeToString(message.getSubject().getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
            }
            else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--RANDSTRING"))
            {
                try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate());
                            if(this.containsEquals(commands,"--randstring"))
                                System.out.println("Random String in lowercase: " + Base64.getEncoder().encodeToString(getRandomStringLowerCase().getBytes())); 
                            else if(this.containsEquals(commands,"--RANDSTRING"))
                                System.out.println("Random String in UpperCase : " + Base64.getEncoder().encodeToString(getRandomStringUpperCase().getBytes())); 
                 
                            System.out.println("From Name: " + Base64.getEncoder().encodeToString(getFromName(from[0].toString()).getBytes()));
                            System.out.println("From Email: "+ Base64.getEncoder().encodeToString(getFromEmail(from[0].toString()).getBytes()));
                            System.out.println("Subject: " + Base64.getEncoder().encodeToString(message.getSubject().getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
            }
              
            else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsStartWith(commands,"--CHAR"))
            {
                try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            if(this.containsStartWith(commands,"--CHAR1"))
                                System.out.println("Random Characters in Upper Case: " + Base64.getEncoder().encodeToString(getCharUpperCase(1).getBytes())); 
                            else if(this.containsStartWith(commands,"--CHAR2"))
                                System.out.println("Random Characters in Upper Case: " +Base64.getEncoder().encodeToString( getCharUpperCase(2).getBytes()));
                            else if(this.containsStartWith(commands,"--CHAR3"))
                                System.out.println("Random Characters in Upper Case: " + Base64.getEncoder().encodeToString(getCharUpperCase(3).getBytes())); 
                            else if(this.containsStartWith(commands,"--CHAR4"))
                                System.out.println("Random Characters in Upper Case: " + Base64.getEncoder().encodeToString(getCharUpperCase(4).getBytes())); 
                            else if(this.containsStartWith(commands,"--CHAR5"))
                                System.out.println("Random Characters in Upper Case: " + Base64.getEncoder().encodeToString(getCharUpperCase(5).getBytes())); 
                            else if(this.containsStartWith(commands,"--CHAR6"))
                                System.out.println("Random Characters in Upper Case: " + Base64.getEncoder().encodeToString(getCharUpperCase(6).getBytes())); 
                            else if(this.containsStartWith(commands,"--CHAR7"))
                                System.out.println("Random Characters in Upper Case: " + Base64.getEncoder().encodeToString(getCharUpperCase(7).getBytes())); 
                            else if(this.containsStartWith(commands,"--CHAR8"))
                                System.out.println("Random Characters in Upper Case: " + Base64.getEncoder().encodeToString(getCharUpperCase(8).getBytes())); 
                            else if(this.containsStartWith(commands,"--CHAR9"))
                                System.out.println("Random Characters in Upper Case: " + Base64.getEncoder().encodeToString(getCharUpperCase(9).getBytes())); 
                            else if(this.containsStartWith(commands,"--CHAR10"))
                                System.out.println("Random Characters in Upper Case: " + Base64.getEncoder().encodeToString(getCharUpperCase(10).getBytes()));
                            else if(this.containsStartWith(commands,"--char1"))
                                System.out.println("Random Characters in Lower Case: " + Base64.getEncoder().encodeToString(getCharLowerCase(1).getBytes())); 
                            else if(this.containsStartWith(commands,"--char2"))
                                System.out.println("Random Characters in Lower Case: " + Base64.getEncoder().encodeToString(getCharLowerCase(2).getBytes())); 
                            else if(this.containsStartWith(commands,"--char3"))
                                System.out.println("Random Characters in Lower Case: " + Base64.getEncoder().encodeToString(getCharLowerCase(3).getBytes())); 
                            else if(this.containsStartWith(commands,"--char4"))
                                System.out.println("Random Characters in Lower Case: " + Base64.getEncoder().encodeToString(getCharLowerCase(4).getBytes())); 
                            else if(this.containsStartWith(commands,"--char5"))
                                System.out.println("Random Characters in Lower Case: " + Base64.getEncoder().encodeToString(getCharLowerCase(5).getBytes())); 
                            else if(this.containsStartWith(commands,"--char6"))
                                System.out.println("Random Characters in Lower Case: " + Base64.getEncoder().encodeToString(getCharLowerCase(6).getBytes())); 
                            else if(this.containsStartWith(commands,"--char7"))
                                System.out.println("Random Characters in Lower Case: " + Base64.getEncoder().encodeToString(getCharLowerCase(7).getBytes())); 
                            else if(this.containsStartWith(commands,"--char8"))
                                System.out.println("Random Characters in Lower Case: " + Base64.getEncoder().encodeToString(getCharLowerCase(8).getBytes())); 
                            else if(this.containsStartWith(commands,"--char9"))
                                System.out.println("Random Characters in Lower Case: " + Base64.getEncoder().encodeToString(getCharLowerCase(9).getBytes())); 
                            else if(this.containsStartWith(commands,"--char10"))
                                System.out.println("Random Characters in Lower Case: " + Base64.getEncoder().encodeToString(getCharLowerCase(10).getBytes())); 
                            
                            
                            
                            System.out.println("From Name: " + Base64.getEncoder().encodeToString(getFromName(from[0].toString()).getBytes()));
                            System.out.println("From Email: "+ Base64.getEncoder().encodeToString(getFromEmail(from[0].toString()).getBytes()));
                            System.out.println("Subject: " + Base64.getEncoder().encodeToString(message.getSubject().getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
            }
            else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsStartWith(commands,"--NUMBER"))
            {
                try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            if(this.containsStartWith(commands,"--NUMBER1"))
                                System.out.println("Random Number: " + (Base64.getEncoder().encodeToString(getNumbers(1).getBytes()))); 
                            else if(this.containsStartWith(commands,"--NUMBER2"))
                                System.out.println("Random Number: " + (Base64.getEncoder().encodeToString(getNumbers(2).getBytes())));
                            else if(this.containsStartWith(commands,"--NUMBER3"))
                                System.out.println("Random Number: " + (Base64.getEncoder().encodeToString(getNumbers(3).getBytes())));
                            else if(this.containsStartWith(commands,"--NUMBER4"))
                                System.out.println("Random Number: " + Base64.getEncoder().encodeToString(getNumbers(4).getBytes()));
                            else if(this.containsStartWith(commands,"--NUMBER5"))
                                System.out.println("Random Number: " + Base64.getEncoder().encodeToString(getNumbers(5).getBytes()));
                            else if(this.containsStartWith(commands,"--NUMBER6"))
                                System.out.println("Random Number: " + Base64.getEncoder().encodeToString(getNumbers(6).getBytes()));
                            else if(this.containsStartWith(commands,"--NUMBER7"))
                                System.out.println("Random Number: " + Base64.getEncoder().encodeToString(getNumbers(7).getBytes()));
                            else if(this.containsStartWith(commands,"--NUMBER8"))
                                System.out.println("Random Number: " + Base64.getEncoder().encodeToString(getNumbers(8).getBytes()));
                            else if(this.containsStartWith(commands,"--NUMBER9"))
                                System.out.println("Random Number: " + Base64.getEncoder().encodeToString(getNumbers(9).getBytes()));
                            else if(this.containsStartWith(commands,"--NUMBER10"))
                                System.out.println("Random Number: " + Base64.getEncoder().encodeToString(getNumbers(10).getBytes()));
                            
                            
                            System.out.println("From Name: " + Base64.getEncoder().encodeToString(getFromName(from[0].toString()).getBytes()));
                            System.out.println("From Email: "+ Base64.getEncoder().encodeToString(getFromEmail(from[0].toString()).getBytes()));
                            System.out.println("Subject: " + Base64.getEncoder().encodeToString(message.getSubject().getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
            }
            else
            {
                   System.out.println("Invalid Syntax/Command!");
            }
    }
            
    
    //Test Sucessful
     public void switchCase7(String[] commands)
    {
         if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--RANDOMIP")
            && this.containsEqualsIgnoreCase(commands,"--USERNAME"))
            {
                try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0 ; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random IP: " + getRandomIP());
                             System.out.println("User Name: " + getUserName(getFromEmail(from[0].toString())));
                            System.out.println("From Name: " + getFromName(from[0].toString()));
                            System.out.println("From Email: "+ getFromEmail(from[0].toString()));
                            System.out.println("Subject: " + message.getSubject()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
         else  if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--RANDOMIP")
            && this.containsEqualsIgnoreCase(commands,"--EMAILCENSORED"))
            {
                try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0 ; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random IP: " + getRandomIP());
                            System.out.println("Email Censored: " + getEmailCensored(getFromEmail(from[0].toString())));
                            System.out.println("From Name: " + getFromName(from[0].toString()));
                            System.out.println("From Email: "+ getFromEmail(from[0].toString()));
                            System.out.println("Subject: " + message.getSubject()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
        else  if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--RANDOMIP")
                && this.containsEqualsIgnoreCase(commands,"--DOMAINFULL"))
            {
                try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0 ; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random IP: " + getRandomIP());
                            System.out.println("Domain Full: " + getDomainFull(getFromEmail(from[0].toString())));
                            System.out.println("From Name: " + getFromName(from[0].toString()));
                            System.out.println("From Email: "+ getFromEmail(from[0].toString()));
                            System.out.println("Subject: " + message.getSubject()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
         else  if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--RANDOMIP")
                 && this.containsEqualsIgnoreCase(commands,"--DOMAINNAME"))
            {
                try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0 ; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random IP: " + getRandomIP());
                            System.out.println("Domain Name: " + getDomainName(getFromEmail(from[0].toString())));
                            System.out.println("From Name: " + getFromName(from[0].toString()));
                            System.out.println("From Email: "+ getFromEmail(from[0].toString()));
                            System.out.println("Subject: " + message.getSubject()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
         else  if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--RANDOMIP")
                 &&  this.containsEqualsIgnoreCase(commands,"--COUNTRY"))
            {
                try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0 ; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random IP: " + getRandomIP());
                            System.out.println("Random Country: " + getRandomCountry());
                            System.out.println("From Name: " + getFromName(from[0].toString()));
                            System.out.println("From Email: "+ getFromEmail(from[0].toString()));
                            System.out.println("Subject: " + message.getSubject()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }else  if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--RANDOMIP")
                        && this.containsEqualsIgnoreCase(commands,"--DATE"))
            {
                try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0 ; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random IP: " + getRandomIP());
                            System.out.println("Today's Date: " + getDate());
                            System.out.println("From Name: " + getFromName(from[0].toString()));
                            System.out.println("From Email: "+ getFromEmail(from[0].toString()));
                            System.out.println("Subject: " + message.getSubject()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
         else  if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--RANDOMIP")
                 && this.containsEqualsIgnoreCase(commands,"--DATETOMORROW"))
            {
                try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0 ; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate());
                            System.out.println("Date Tomorrow: " +getTomorrowDate());
                            System.out.println("Random IP: " + getRandomIP());
                            System.out.println("From Name: " + getFromName(from[0].toString()));
                            System.out.println("From Email: "+ getFromEmail(from[0].toString()));
                            System.out.println("Subject: " + message.getSubject()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
         else  if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--RANDOMIP")
                 && this.containsEqualsIgnoreCase(commands,"--TIME"))
            {
                try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0 ; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random IP: " + getRandomIP());
                            System.out.println("Time: " + getTime());
                            System.out.println("From Name: " + getFromName(from[0].toString()));
                            System.out.println("From Email: "+ getFromEmail(from[0].toString()));
                            System.out.println("Subject: " + message.getSubject()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
         else  if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--RANDOMIP")
                 && this.containsEqualsIgnoreCase(commands,"--PC_OS"))
            {
                try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0 ; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random IP: " + getRandomIP());
                            System.out.println("Random PC OS: " + getRandomPCOS());
                            System.out.println("From Name: " + getFromName(from[0].toString()));
                            System.out.println("From Email: "+ getFromEmail(from[0].toString()));
                            System.out.println("Subject: " + message.getSubject()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
         else  if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--RANDOMIP")
                 && this.containsEqualsIgnoreCase(commands,"--PC_BROWSER"))
            {
                try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0 ; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate());
                            System.out.println("Random IP: " + getRandomIP());
                            System.out.println("Random PC Browser: " + getRandomPCBrowser());
                            System.out.println("From Name: " + getFromName(from[0].toString()));
                            System.out.println("From Email: "+ getFromEmail(from[0].toString()));
                            System.out.println("Subject: " + message.getSubject()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
         else  if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--RANDOMIP")
                 && this.containsEqualsIgnoreCase(commands,"--UA"))
            {
                try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0 ; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random IP: " + getRandomIP());
                            System.out.println("Random User Agent: " + getRandomUserAgent());
                            System.out.println("From Name: " + getFromName(from[0].toString()));
                            System.out.println("From Email: "+ getFromEmail(from[0].toString()));
                            System.out.println("Subject: " + message.getSubject()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
         else  if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--RANDOMIP")
                 && this.containsEqualsIgnoreCase(commands,"--APPLEAPPS"))
            {
                try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0 ; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random IP: " + getRandomIP());
                            System.out.println("Random Apple App: " + getRandomAppleApps());
                            System.out.println("From Name: " + getFromName(from[0].toString()));
                            System.out.println("From Email: "+ getFromEmail(from[0].toString()));
                            System.out.println("Subject: " + message.getSubject()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
         else  if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--RANDOMIP")
                 && this.containsEqualsIgnoreCase(commands,"--APPLEPC"))
            {
                try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0 ; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate());
                            System.out.println("Random IP: " + getRandomIP());
                            System.out.println("Random Apple PC: " + getRandomAppleLaptops());
                            System.out.println("From Name: " + getFromName(from[0].toString()));
                            System.out.println("From Email: "+ getFromEmail(from[0].toString()));
                            System.out.println("Subject: " + message.getSubject()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
         else  if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--RANDOMIP")
                 && this.containsEqualsIgnoreCase(commands,"--APPLEPHONES"))
            {
                try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0 ; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random IP: " + getRandomIP());
                            System.out.println("Random Apple Phone: " + getRandomApplePhones());
                            System.out.println("From Name: " + getFromName(from[0].toString()));
                            System.out.println("From Email: "+ getFromEmail(from[0].toString()));
                            System.out.println("Subject: " + message.getSubject()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
         else  if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--RANDOMIP")
                 && this.containsEqualsIgnoreCase(commands,"--UNIVERSAL_BROWSER"))
            {
                try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0 ; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random IP: " + getRandomIP());
                            System.out.println("Random Universal Browser: " + getRandomUniversalBrowser());
                            System.out.println("From Name: " + getFromName(from[0].toString()));
                            System.out.println("From Email: "+ getFromEmail(from[0].toString()));
                            System.out.println("Subject: " + message.getSubject()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
         else  if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--RANDOMIP")
                 && this.containsStartWith(commands,"--NUMBER"))
            {
                try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0 ; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate());
                            if(this.containsStartWith(commands,"--NUMBER1"))
                                System.out.println("Random Number: " + getNumbers(1)); 
                            else if(this.containsStartWith(commands,"--NUMBER2"))
                                System.out.println("Random Number: " + getNumbers(2));
                            else if(this.containsStartWith(commands,"--NUMBER3"))
                                System.out.println("Random Number: " + getNumbers(3));
                            else if(this.containsStartWith(commands,"--NUMBER4"))
                                System.out.println("Random Number: " + getNumbers(4));
                            else if(this.containsStartWith(commands,"--NUMBER5"))
                                System.out.println("Random Number: " + getNumbers(5));
                            else if(this.containsStartWith(commands,"--NUMBER6"))
                                System.out.println("Random Number: " + getNumbers(6));
                            else if(this.containsStartWith(commands,"--NUMBER7"))
                                System.out.println("Random Number: " + getNumbers(7));
                            else if(this.containsStartWith(commands,"--NUMBER8"))
                                System.out.println("Random Number: " + getNumbers(8));
                            else if(this.containsStartWith(commands,"--NUMBER9"))
                                System.out.println("Random Number: " + getNumbers(9));
                            else if(this.containsStartWith(commands,"--NUMBER10"))
                                System.out.println("Random Number: " + getNumbers(10));


                            
                            System.out.println("Random IP: " + getRandomIP());
                            System.out.println("From Name: " + getFromName(from[0].toString()));
                            System.out.println("From Email: "+ getFromEmail(from[0].toString()));
                            System.out.println("Subject: " + message.getSubject()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
         else  if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--RANDOMIP")
                 && this.containsStartWith(commands,"--CHAR"))
            {
                try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0 ; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            if(this.containsStartWith(commands,"--CHAR1"))
                                System.out.println("Random Characters in Upper Case: " + getCharUpperCase(1)); 
                            else if(this.containsStartWith(commands,"--CHAR2"))
                                System.out.println("Random Characters in Upper Case: " + getCharUpperCase(2));
                            else if(this.containsStartWith(commands,"--CHAR3"))
                                System.out.println("Random Characters in Upper Case: " + getCharUpperCase(3)); 
                            else if(this.containsStartWith(commands,"--CHAR4"))
                                System.out.println("Random Characters in Upper Case: " + getCharUpperCase(4)); 
                            else if(this.containsStartWith(commands,"--CHAR5"))
                                System.out.println("Random Characters in Upper Case: " + getCharUpperCase(5)); 
                            else if(this.containsStartWith(commands,"--CHAR6"))
                                System.out.println("Random Characters in Upper Case: " + getCharUpperCase(6)); 
                            else if(this.containsStartWith(commands,"--CHAR7"))
                                System.out.println("Random Characters in Upper Case: " + getCharUpperCase(7)); 
                            else if(this.containsStartWith(commands,"--CHAR8"))
                                System.out.println("Random Characters in Upper Case: " + getCharUpperCase(8)); 
                            else if(this.containsStartWith(commands,"--CHAR9"))
                                System.out.println("Random Characters in Upper Case: " + getCharUpperCase(9)); 
                            else if(this.containsStartWith(commands,"--CHAR10"))
                                System.out.println("Random Characters in Upper Case: " + getCharUpperCase(10));
                            else if(this.containsStartWith(commands,"--char1"))
                                System.out.println("Random Characters in Lower Case: " + getCharLowerCase(1)); 
                            else if(this.containsStartWith(commands,"--char2"))
                                System.out.println("Random Characters in Lower Case: " + getCharLowerCase(2)); 
                            else if(this.containsStartWith(commands,"--char3"))
                                System.out.println("Random Characters in Lower Case: " + getCharLowerCase(3)); 
                            else if(this.containsStartWith(commands,"--char4"))
                                System.out.println("Random Characters in Lower Case: " + getCharLowerCase(4)); 
                            else if(this.containsStartWith(commands,"--char5"))
                                System.out.println("Random Characters in Lower Case: " + getCharLowerCase(5)); 
                            else if(this.containsStartWith(commands,"--char6"))
                                System.out.println("Random Characters in Lower Case: " + getCharLowerCase(6)); 
                            else if(this.containsStartWith(commands,"--char7"))
                                System.out.println("Random Characters in Lower Case: " + getCharLowerCase(7)); 
                            else if(this.containsStartWith(commands,"--char8"))
                                System.out.println("Random Characters in Lower Case: " + getCharLowerCase(8)); 
                            else if(this.containsStartWith(commands,"--char9"))
                                System.out.println("Random Characters in Lower Case: " + getCharLowerCase(9)); 
                            else if(this.containsStartWith(commands,"--char10"))
                                System.out.println("Random Characters in Lower Case: " + getCharLowerCase(10));



                            
                            System.out.println("Random IP: " + getRandomIP());
                            System.out.println("From Name: " + getFromName(from[0].toString()));
                            System.out.println("From Email: "+ getFromEmail(from[0].toString()));
                            System.out.println("Subject: " + message.getSubject()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
         else  if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--RANDOMIP")
                 && this.containsEqualsIgnoreCase(commands,"--RANDSTRING"))
            {
                try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0 ; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            if(this.containsEquals(commands,"--randstring"))
                                System.out.println("Random String in lowercase: " + getRandomStringLowerCase()); 
                            else if(this.containsEquals(commands,"--RANDSTRING"))
                                System.out.println("Random String in UpperCase : " + getRandomStringUpperCase());

                            
                            System.out.println("Random IP: " + getRandomIP());
                            System.out.println("From Name: " + getFromName(from[0].toString()));
                            System.out.println("From Email: "+ getFromEmail(from[0].toString()));
                            System.out.println("Subject: " + message.getSubject()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
                //EMAIL 64
                
         else  if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--RANDOMIP")
            && this.containsEqualsIgnoreCase(commands,"--USERNAME"))
            {
                try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0 ; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random IP: " + Base64.getEncoder().encodeToString(getRandomIP().getBytes()));
                             System.out.println("User Name: " + Base64.getEncoder().encodeToString(getUserName(getFromEmail(from[0].toString())).getBytes()));
                            System.out.println("From Name: " + Base64.getEncoder().encodeToString(getFromName(from[0].toString()).getBytes()));
                            System.out.println("From Email: "+ Base64.getEncoder().encodeToString(getFromEmail(from[0].toString()).getBytes()));
                            System.out.println("Subject: " + Base64.getEncoder().encodeToString(message.getSubject().getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
         else  if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--RANDOMIP")
            && this.containsEqualsIgnoreCase(commands,"--EMAILCENSORED"))
            {
                try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0 ; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random IP: " + Base64.getEncoder().encodeToString(getRandomIP().getBytes()));
                            System.out.println("Email Censored: " + Base64.getEncoder().encodeToString(getEmailCensored(getFromEmail(from[0].toString())).getBytes()));
                            System.out.println("From Name: " + Base64.getEncoder().encodeToString(getFromName(from[0].toString()).getBytes()));
                            System.out.println("From Email: "+ Base64.getEncoder().encodeToString(getFromEmail(from[0].toString()).getBytes()));
                            System.out.println("Subject: " + Base64.getEncoder().encodeToString(message.getSubject().getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
        else  if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--RANDOMIP")
                && this.containsEqualsIgnoreCase(commands,"--DOMAINFULL"))
            {
                try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0 ; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random IP: " + Base64.getEncoder().encodeToString(getRandomIP().getBytes()));
                            System.out.println("Domain Full: " + Base64.getEncoder().encodeToString(getDomainFull(getFromEmail(from[0].toString())).getBytes()));
                            System.out.println("From Name: " + Base64.getEncoder().encodeToString(getFromName(from[0].toString()).getBytes()));
                            System.out.println("From Email: "+ Base64.getEncoder().encodeToString(getFromEmail(from[0].toString()).getBytes()));
                            System.out.println("Subject: " + Base64.getEncoder().encodeToString(message.getSubject().getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
         else  if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--RANDOMIP")
                 && this.containsEqualsIgnoreCase(commands,"--DOMAINNAME"))
            {
                try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0 ; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random IP: " + Base64.getEncoder().encodeToString(getRandomIP().getBytes()));
                            System.out.println("Domain Name: " + Base64.getEncoder().encodeToString(getDomainName(getFromEmail(from[0].toString())).getBytes()));
                            System.out.println("From Name: " + Base64.getEncoder().encodeToString(getFromName(from[0].toString()).getBytes()));
                            System.out.println("From Email: "+ Base64.getEncoder().encodeToString(getFromEmail(from[0].toString()).getBytes()));
                            System.out.println("Subject: " + Base64.getEncoder().encodeToString(message.getSubject().getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
         else  if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--RANDOMIP")
                 &&  this.containsEqualsIgnoreCase(commands,"--COUNTRY"))
            {
                try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0 ; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random IP: " + Base64.getEncoder().encodeToString(getRandomIP().getBytes()));
                            System.out.println("Random Country: " + Base64.getEncoder().encodeToString(getRandomCountry().getBytes()));
                            System.out.println("From Name: " + Base64.getEncoder().encodeToString(getFromName(from[0].toString()).getBytes()));
                            System.out.println("From Email: "+ Base64.getEncoder().encodeToString(getFromEmail(from[0].toString()).getBytes()));
                            System.out.println("Subject: " + Base64.getEncoder().encodeToString(message.getSubject().getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }else  if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--RANDOMIP")
                        && this.containsEqualsIgnoreCase(commands,"--DATE"))
            {
                try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0 ; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random IP: " + Base64.getEncoder().encodeToString(getRandomIP().getBytes()));
                            System.out.println("Today's Date: " + Base64.getEncoder().encodeToString(getDate().getBytes()));
                            System.out.println("From Name: " + Base64.getEncoder().encodeToString(getFromName(from[0].toString()).getBytes()));
                            System.out.println("From Email: "+ Base64.getEncoder().encodeToString(getFromEmail(from[0].toString()).getBytes()));
                            System.out.println("Subject: " + Base64.getEncoder().encodeToString(message.getSubject().getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
         else  if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--RANDOMIP")
                 && this.containsEqualsIgnoreCase(commands,"--DATETOMORROW"))
            {
                try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0 ; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate());
                            System.out.println("Date Tomorrow: " +Base64.getEncoder().encodeToString(getTomorrowDate().getBytes()));
                            System.out.println("Random IP: " + Base64.getEncoder().encodeToString(getRandomIP().getBytes()));
                            System.out.println("From Name: " + Base64.getEncoder().encodeToString(getFromName(from[0].toString()).getBytes()));
                            System.out.println("From Email: "+ Base64.getEncoder().encodeToString(getFromEmail(from[0].toString()).getBytes()));
                            System.out.println("Subject: " + Base64.getEncoder().encodeToString(message.getSubject().getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
         else  if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--RANDOMIP")
                 && this.containsEqualsIgnoreCase(commands,"--TIME"))
            {
                try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0 ; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random IP: " + Base64.getEncoder().encodeToString(getRandomIP().getBytes()));
                            System.out.println("Time: " + Base64.getEncoder().encodeToString(getTime().getBytes()));
                            System.out.println("From Name: " + Base64.getEncoder().encodeToString(getFromName(from[0].toString()).getBytes()));
                            System.out.println("From Email: "+ Base64.getEncoder().encodeToString(getFromEmail(from[0].toString()).getBytes()));
                            System.out.println("Subject: " + Base64.getEncoder().encodeToString(message.getSubject().getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
         else  if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--RANDOMIP")
                 && this.containsEqualsIgnoreCase(commands,"--PC_OS"))
            {
                try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0 ; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random IP: " + Base64.getEncoder().encodeToString(getRandomIP().getBytes()));
                            System.out.println("Random PC OS: " + Base64.getEncoder().encodeToString(getRandomPCOS().getBytes()));
                            System.out.println("From Name: " + Base64.getEncoder().encodeToString(getFromName(from[0].toString()).getBytes()));
                            System.out.println("From Email: "+ Base64.getEncoder().encodeToString(getFromEmail(from[0].toString()).getBytes()));
                            System.out.println("Subject: " + Base64.getEncoder().encodeToString(message.getSubject().getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
         else  if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--RANDOMIP")
                 && this.containsEqualsIgnoreCase(commands,"--PC_BROWSER"))
            {
                try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0 ; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate());
                            System.out.println("Random IP: " + Base64.getEncoder().encodeToString(getRandomIP().getBytes()));
                            System.out.println("Random PC Browser: " + Base64.getEncoder().encodeToString(getRandomPCBrowser().getBytes()));
                            System.out.println("From Name: " + Base64.getEncoder().encodeToString(getFromName(from[0].toString()).getBytes()));
                            System.out.println("From Email: "+ Base64.getEncoder().encodeToString(getFromEmail(from[0].toString()).getBytes()));
                            System.out.println("Subject: " + Base64.getEncoder().encodeToString(message.getSubject().getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
         else  if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--RANDOMIP")
                 && this.containsEqualsIgnoreCase(commands,"--UA"))
            {
                try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0 ; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random IP: " + Base64.getEncoder().encodeToString(getRandomIP().getBytes()));
                            System.out.println("Random User Agent: " + Base64.getEncoder().encodeToString(getRandomUserAgent().getBytes()));
                            System.out.println("From Name: " + Base64.getEncoder().encodeToString(getFromName(from[0].toString()).getBytes()));
                            System.out.println("From Email: "+Base64.getEncoder().encodeToString( getFromEmail(from[0].toString()).getBytes()));
                            System.out.println("Subject: " + Base64.getEncoder().encodeToString(message.getSubject().getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
         else  if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--RANDOMIP")
                 && this.containsEqualsIgnoreCase(commands,"--APPLEAPPS"))
            {
                try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0 ; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random IP: " + Base64.getEncoder().encodeToString(getRandomIP().getBytes()));
                            System.out.println("Random Apple App: " + Base64.getEncoder().encodeToString(getRandomAppleApps().getBytes()));
                            System.out.println("From Name: " + Base64.getEncoder().encodeToString(getFromName(from[0].toString()).getBytes()));
                            System.out.println("From Email: "+ Base64.getEncoder().encodeToString(getFromEmail(from[0].toString()).getBytes()));
                            System.out.println("Subject: " + Base64.getEncoder().encodeToString(message.getSubject().getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
         else  if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--RANDOMIP")
                 && this.containsEqualsIgnoreCase(commands,"--APPLEPC"))
            {
                try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0 ; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate());
                            System.out.println("Random IP: " + Base64.getEncoder().encodeToString(getRandomIP().getBytes()));
                            System.out.println("Random Apple PC: " + Base64.getEncoder().encodeToString(getRandomAppleLaptops().getBytes()));
                            System.out.println("From Name: " + Base64.getEncoder().encodeToString(getFromName(from[0].toString()).getBytes()));
                            System.out.println("From Email: "+ Base64.getEncoder().encodeToString(getFromEmail(from[0].toString()).getBytes()));
                            System.out.println("Subject: " + Base64.getEncoder().encodeToString(message.getSubject().getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
         else  if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--RANDOMIP")
                 && this.containsEqualsIgnoreCase(commands,"--APPLEPHONES"))
            {
                try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0 ; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random IP: " + Base64.getEncoder().encodeToString(getRandomIP().getBytes()));
                            System.out.println("Random Apple Phone: " + Base64.getEncoder().encodeToString(getRandomApplePhones().getBytes()));
                            System.out.println("From Name: " + Base64.getEncoder().encodeToString(getFromName(from[0].toString()).getBytes()));
                            System.out.println("From Email: "+ Base64.getEncoder().encodeToString(getFromEmail(from[0].toString()).getBytes()));
                            System.out.println("Subject: " + Base64.getEncoder().encodeToString(message.getSubject().getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (MessagingException e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
         else  if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--RANDOMIP")
                 && this.containsEqualsIgnoreCase(commands,"--UNIVERSAL_BROWSER"))
            {
                try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0 ; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random IP: " + Base64.getEncoder().encodeToString(getRandomIP().getBytes()));
                            System.out.println("Random Universal Browser: " + Base64.getEncoder().encodeToString(getRandomUniversalBrowser().getBytes()));
                            System.out.println("From Name: " + Base64.getEncoder().encodeToString(getFromName(from[0].toString()).getBytes()));
                            System.out.println("From Email: "+ Base64.getEncoder().encodeToString(getFromEmail(from[0].toString()).getBytes()));
                            System.out.println("Subject: " + Base64.getEncoder().encodeToString(message.getSubject().getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
         else  if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--RANDOMIP")
                 && this.containsStartWith(commands,"--NUMBER"))
            {
                try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0 ; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            if(this.containsStartWith(commands,"--NUMBER1"))
                                System.out.println("Random Number: " + (Base64.getEncoder().encodeToString(getNumbers(1).getBytes()))); 
                            else if(this.containsStartWith(commands,"--NUMBER2"))
                                System.out.println("Random Number: " + (Base64.getEncoder().encodeToString(getNumbers(2).getBytes())));
                            else if(this.containsStartWith(commands,"--NUMBER3"))
                                System.out.println("Random Number: " + (Base64.getEncoder().encodeToString(getNumbers(3).getBytes())));
                            else if(this.containsStartWith(commands,"--NUMBER4"))
                                System.out.println("Random Number: " + Base64.getEncoder().encodeToString(getNumbers(4).getBytes()));
                            else if(this.containsStartWith(commands,"--NUMBER5"))
                                System.out.println("Random Number: " + Base64.getEncoder().encodeToString(getNumbers(5).getBytes()));
                            else if(this.containsStartWith(commands,"--NUMBER6"))
                                System.out.println("Random Number: " + Base64.getEncoder().encodeToString(getNumbers(6).getBytes()));
                            else if(this.containsStartWith(commands,"--NUMBER7"))
                                System.out.println("Random Number: " + Base64.getEncoder().encodeToString(getNumbers(7).getBytes()));
                            else if(this.containsStartWith(commands,"--NUMBER8"))
                                System.out.println("Random Number: " + Base64.getEncoder().encodeToString(getNumbers(8).getBytes()));
                            else if(this.containsStartWith(commands,"--NUMBER9"))
                                System.out.println("Random Number: " + Base64.getEncoder().encodeToString(getNumbers(9).getBytes()));
                            else if(this.containsStartWith(commands,"--NUMBER10"))
                                System.out.println("Random Number: " + Base64.getEncoder().encodeToString(getNumbers(10).getBytes()));
                            
                            System.out.println("Random IP: " + Base64.getEncoder().encodeToString(getRandomIP().getBytes()));
                            System.out.println("From Name: " + getFromName(from[0].toString()));
                            System.out.println("From Email: "+ Base64.getEncoder().encodeToString(getFromEmail(from[0].toString()).getBytes()));
                            System.out.println("Subject: " + Base64.getEncoder().encodeToString(message.getSubject().getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
         else  if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--RANDOMIP")
                 && this.containsStartWith(commands,"--CHAR"))
            {
                try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0 ; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            if(this.containsStartWith(commands,"--CHAR1"))
                                System.out.println("Random Characters in Upper Case: " + Base64.getEncoder().encodeToString(getCharUpperCase(1).getBytes())); 
                            else if(this.containsStartWith(commands,"--CHAR2"))
                                System.out.println("Random Characters in Upper Case: " +Base64.getEncoder().encodeToString( getCharUpperCase(2).getBytes()));
                            else if(this.containsStartWith(commands,"--CHAR3"))
                                System.out.println("Random Characters in Upper Case: " + Base64.getEncoder().encodeToString(getCharUpperCase(3).getBytes())); 
                            else if(this.containsStartWith(commands,"--CHAR4"))
                                System.out.println("Random Characters in Upper Case: " + Base64.getEncoder().encodeToString(getCharUpperCase(4).getBytes())); 
                            else if(this.containsStartWith(commands,"--CHAR5"))
                                System.out.println("Random Characters in Upper Case: " + Base64.getEncoder().encodeToString(getCharUpperCase(5).getBytes())); 
                            else if(this.containsStartWith(commands,"--CHAR6"))
                                System.out.println("Random Characters in Upper Case: " + Base64.getEncoder().encodeToString(getCharUpperCase(6).getBytes())); 
                            else if(this.containsStartWith(commands,"--CHAR7"))
                                System.out.println("Random Characters in Upper Case: " + Base64.getEncoder().encodeToString(getCharUpperCase(7).getBytes())); 
                            else if(this.containsStartWith(commands,"--CHAR8"))
                                System.out.println("Random Characters in Upper Case: " + Base64.getEncoder().encodeToString(getCharUpperCase(8).getBytes())); 
                            else if(this.containsStartWith(commands,"--CHAR9"))
                                System.out.println("Random Characters in Upper Case: " + Base64.getEncoder().encodeToString(getCharUpperCase(9).getBytes())); 
                            else if(this.containsStartWith(commands,"--CHAR10"))
                                System.out.println("Random Characters in Upper Case: " + Base64.getEncoder().encodeToString(getCharUpperCase(10).getBytes()));
                            else if(this.containsStartWith(commands,"--char1"))
                                System.out.println("Random Characters in Lower Case: " + Base64.getEncoder().encodeToString(getCharLowerCase(1).getBytes())); 
                            else if(this.containsStartWith(commands,"--char2"))
                                System.out.println("Random Characters in Lower Case: " + Base64.getEncoder().encodeToString(getCharLowerCase(2).getBytes())); 
                            else if(this.containsStartWith(commands,"--char3"))
                                System.out.println("Random Characters in Lower Case: " + Base64.getEncoder().encodeToString(getCharLowerCase(3).getBytes())); 
                            else if(this.containsStartWith(commands,"--char4"))
                                System.out.println("Random Characters in Lower Case: " + Base64.getEncoder().encodeToString(getCharLowerCase(4).getBytes())); 
                            else if(this.containsStartWith(commands,"--char5"))
                                System.out.println("Random Characters in Lower Case: " + Base64.getEncoder().encodeToString(getCharLowerCase(5).getBytes())); 
                            else if(this.containsStartWith(commands,"--char6"))
                                System.out.println("Random Characters in Lower Case: " + Base64.getEncoder().encodeToString(getCharLowerCase(6).getBytes())); 
                            else if(this.containsStartWith(commands,"--char7"))
                                System.out.println("Random Characters in Lower Case: " + Base64.getEncoder().encodeToString(getCharLowerCase(7).getBytes())); 
                            else if(this.containsStartWith(commands,"--char8"))
                                System.out.println("Random Characters in Lower Case: " + Base64.getEncoder().encodeToString(getCharLowerCase(8).getBytes())); 
                            else if(this.containsStartWith(commands,"--char9"))
                                System.out.println("Random Characters in Lower Case: " + Base64.getEncoder().encodeToString(getCharLowerCase(9).getBytes())); 
                            else if(this.containsStartWith(commands,"--char10"))
                                System.out.println("Random Characters in Lower Case: " + Base64.getEncoder().encodeToString(getCharLowerCase(10).getBytes())); 
                            
                            

                            System.out.println("Random IP: " + Base64.getEncoder().encodeToString(getRandomIP().getBytes()));
                            System.out.println("From Name: " + Base64.getEncoder().encodeToString(getFromName(from[0].toString()).getBytes()));
                            System.out.println("From Email: "+ Base64.getEncoder().encodeToString(getFromEmail(from[0].toString()).getBytes()));
                            System.out.println("Subject: " + Base64.getEncoder().encodeToString(message.getSubject().getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
         else  if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--RANDOMIP")
                 && this.containsEqualsIgnoreCase(commands,"--RANDSTRING"))
            {
                try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0 ; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate());
                            if(this.containsEquals(commands,"--randstring"))
                                System.out.println("Random String in lowercase: " + Base64.getEncoder().encodeToString(getRandomStringLowerCase().getBytes())); 
                            else if(this.containsEquals(commands,"--RANDSTRING"))
                                System.out.println("Random String in UpperCase : " + Base64.getEncoder().encodeToString(getRandomStringUpperCase().getBytes())); 
                            
                            System.out.println("Random IP: " + Base64.getEncoder().encodeToString(getRandomIP().getBytes()));
                            System.out.println("From Name: " + Base64.getEncoder().encodeToString(getFromName(from[0].toString()).getBytes()));
                            System.out.println("From Email: "+ Base64.getEncoder().encodeToString(getFromEmail(from[0].toString()).getBytes()));
                            System.out.println("Subject: " + Base64.getEncoder().encodeToString(message.getSubject().getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
                else
                {
                    System.out.println("Invalid Syntax/Command!");
                }
    }
     
     
    public void switchCase8(String[] commands)
    {
        if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--RANDOMIP")
            && this.containsEqualsIgnoreCase(commands,"--USERNAME") && this.containsEqualsIgnoreCase(commands,"--EMAILCENSORED"))
            {
                try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random IP: " + getRandomIP());
                             System.out.println("User Name: " + getUserName(getFromEmail(from[0].toString())));
                             System.out.println("Email Censored: " + getEmailCensored(getFromEmail(from[0].toString())));
                            System.out.println("From Name: " + getFromName(from[0].toString()));
                            System.out.println("From Email: "+ getFromEmail(from[0].toString()));
                            System.out.println("Subject: " + message.getSubject()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
            }
        else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--RANDOMIP")
            && this.containsEqualsIgnoreCase(commands,"--USERNAME")&& this.containsEqualsIgnoreCase(commands,"--DOMAINFULL"))
            {
                try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random IP: " + getRandomIP());
                             System.out.println("User Name: " + getUserName(getFromEmail(from[0].toString())));
                             System.out.println("Domain Full: " + getDomainFull(getFromEmail(from[0].toString())));
                            System.out.println("From Name: " + getFromName(from[0].toString()));
                            System.out.println("From Email: "+ getFromEmail(from[0].toString()));
                            System.out.println("Subject: " + message.getSubject()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
        else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--RANDOMIP")
            && this.containsEqualsIgnoreCase(commands,"--USERNAME")&& this.containsEqualsIgnoreCase(commands,"--DOMAINNAME"))
            {
                try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random IP: " + getRandomIP());
                             System.out.println("User Name: " + getUserName(getFromEmail(from[0].toString())));
                             System.out.println("Domain Name: " + getDomainName(getFromEmail(from[0].toString())));
                            System.out.println("From Name: " + getFromName(from[0].toString()));
                            System.out.println("From Email: "+ getFromEmail(from[0].toString()));
                            System.out.println("Subject: " + message.getSubject()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
        else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--RANDOMIP")
            && this.containsEqualsIgnoreCase(commands,"--USERNAME") && this.containsEqualsIgnoreCase(commands,"--COUNTRY"))
            {
                try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random IP: " + getRandomIP());
                             System.out.println("User Name: " + getUserName(getFromEmail(from[0].toString())));
                             System.out.println("Random Country: " + getRandomCountry());
                            System.out.println("From Name: " + getFromName(from[0].toString()));
                            System.out.println("From Email: "+ getFromEmail(from[0].toString()));
                            System.out.println("Subject: " + message.getSubject()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
        else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--RANDOMIP")
            && this.containsEqualsIgnoreCase(commands,"--USERNAME") && this.containsEqualsIgnoreCase(commands,"--DATE"))
            {
                try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random IP: " + getRandomIP());
                             System.out.println("User Name: " + getUserName(getFromEmail(from[0].toString())));
                             System.out.println("Today's Date: " + getDate());
                            System.out.println("From Name: " + getFromName(from[0].toString()));
                            System.out.println("From Email: "+ getFromEmail(from[0].toString()));
                            System.out.println("Subject: " + message.getSubject()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
        else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--RANDOMIP")
            && this.containsEqualsIgnoreCase(commands,"--USERNAME") && this.containsEqualsIgnoreCase(commands,"--DATETOMORROW"))
            {
                try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random IP: " + getRandomIP());
                             System.out.println("User Name: " + getUserName(getFromEmail(from[0].toString())));
                             System.out.println("Date Tomorrow: " + getTomorrowDate());
                            System.out.println("From Name: " + getFromName(from[0].toString()));
                            System.out.println("From Email: "+ getFromEmail(from[0].toString()));
                            System.out.println("Subject: " + message.getSubject()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
        else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--RANDOMIP")
            && this.containsEqualsIgnoreCase(commands,"--USERNAME") && this.containsEqualsIgnoreCase(commands,"--TIME"))
            {
                try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random IP: " + getRandomIP());
                             System.out.println("User Name: " + getUserName(getFromEmail(from[0].toString())));
                             System.out.println("Time: " + getTime());
                            System.out.println("From Name: " + getFromName(from[0].toString()));
                            System.out.println("From Email: "+ getFromEmail(from[0].toString()));
                            System.out.println("Subject: " + message.getSubject()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
        else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--RANDOMIP")
            && this.containsEqualsIgnoreCase(commands,"--USERNAME") && this.containsEqualsIgnoreCase(commands,"--PC_OS"))
            {
                try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random IP: " + getRandomIP());
                             System.out.println("User Name: " + getUserName(getFromEmail(from[0].toString())));
                             System.out.println("Random PC OS: " + getRandomPCOS());
                            System.out.println("From Name: " + getFromName(from[0].toString()));
                            System.out.println("From Email: "+ getFromEmail(from[0].toString()));
                            System.out.println("Subject: " + message.getSubject()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
        else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--RANDOMIP")
            && this.containsEqualsIgnoreCase(commands,"--USERNAME") && this.containsEqualsIgnoreCase(commands,"--PC_BROWSER"))
            {
                try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random IP: " + getRandomIP());
                             System.out.println("User Name: " + getUserName(getFromEmail(from[0].toString())));
                             System.out.println("Random PC Browser: " + getRandomPCBrowser());
                            System.out.println("From Name: " + getFromName(from[0].toString()));
                            System.out.println("From Email: "+ getFromEmail(from[0].toString()));
                            System.out.println("Subject: " + message.getSubject()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
        else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--RANDOMIP")
            && this.containsEqualsIgnoreCase(commands,"--USERNAME") && this.containsEqualsIgnoreCase(commands,"--COUNTRYCITY"))
            {
                try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random IP: " + getRandomIP());
                             System.out.println("User Name: " + getUserName(getFromEmail(from[0].toString())));
                             System.out.println("Random Country City: " + getRandomCity());
                            System.out.println("From Name: " + getFromName(from[0].toString()));
                            System.out.println("From Email: "+ getFromEmail(from[0].toString()));
                            System.out.println("Subject: " + message.getSubject()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
        else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--RANDOMIP")
            && this.containsEqualsIgnoreCase(commands,"--USERNAME") && this.containsEqualsIgnoreCase(commands,"--ANDROID_OS"))
            {
                try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random IP: " + getRandomIP());
                             System.out.println("User Name: " + getUserName(getFromEmail(from[0].toString())));
                             System.out.println("Random Android OS: " + getRandomAndroidOS());
                            System.out.println("From Name: " + getFromName(from[0].toString()));
                            System.out.println("From Email: "+ getFromEmail(from[0].toString()));
                            System.out.println("Subject: " + message.getSubject()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
        else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--RANDOMIP")
            && this.containsEqualsIgnoreCase(commands,"--USERNAME") && this.containsEqualsIgnoreCase(commands,"--ANDROID_BROWSER"))
            {
                try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random IP: " + getRandomIP());
                             System.out.println("User Name: " + getUserName(getFromEmail(from[0].toString())));
                             System.out.println("Random Android Browser: " + getRandomAndroidBrowser());
                            System.out.println("From Name: " + getFromName(from[0].toString()));
                            System.out.println("From Email: "+ getFromEmail(from[0].toString()));
                            System.out.println("Subject: " + message.getSubject()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
        else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--RANDOMIP")
            && this.containsEqualsIgnoreCase(commands,"--USERNAME") && this.containsEqualsIgnoreCase(commands,"--UA"))
            {
                try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random IP: " + getRandomIP());
                             System.out.println("User Name: " + getUserName(getFromEmail(from[0].toString())));
                             System.out.println("Random User Agent: " + getRandomUserAgent());
                            System.out.println("From Name: " + getFromName(from[0].toString()));
                            System.out.println("From Email: "+ getFromEmail(from[0].toString()));
                            System.out.println("Subject: " + message.getSubject()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
        else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--RANDOMIP")
            && this.containsEqualsIgnoreCase(commands,"--USERNAME") && this.containsEqualsIgnoreCase(commands,"-APPLEAPPS"))
            {
                try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random IP: " + getRandomIP());
                             System.out.println("User Name: " + getUserName(getFromEmail(from[0].toString())));
                             System.out.println("Random Apple App: " + getRandomAppleApps());
                            System.out.println("From Name: " + getFromName(from[0].toString()));
                            System.out.println("From Email: "+ getFromEmail(from[0].toString()));
                            System.out.println("Subject: " + message.getSubject()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
        else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--RANDOMIP")
            && this.containsEqualsIgnoreCase(commands,"--USERNAME") && this.containsEqualsIgnoreCase(commands,"--APPLEPC"))
            {
                try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random IP: " + getRandomIP());
                             System.out.println("User Name: " + getUserName(getFromEmail(from[0].toString())));
                             System.out.println("Random Apple PC: " + getRandomAppleLaptops());
                            System.out.println("From Name: " + getFromName(from[0].toString()));
                            System.out.println("From Email: "+ getFromEmail(from[0].toString()));
                            System.out.println("Subject: " + message.getSubject()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
        else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--RANDOMIP")
            && this.containsEqualsIgnoreCase(commands,"--USERNAME") && this.containsEqualsIgnoreCase(commands,"--APPLE_PHONES"))
            {
                try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random IP: " + getRandomIP());
                             System.out.println("User Name: " + getUserName(getFromEmail(from[0].toString())));
                             System.out.println("Random Apple Phones: " + getRandomApplePhones());
                            System.out.println("From Name: " + getFromName(from[0].toString()));
                            System.out.println("From Email: "+ getFromEmail(from[0].toString()));
                            System.out.println("Subject: " + message.getSubject()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
        else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--RANDOMIP")
            && this.containsEqualsIgnoreCase(commands,"--USERNAME") && this.containsEqualsIgnoreCase(commands,"--UNIVERSAL_BROWSER"))
            {
                try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random IP: " + getRandomIP());
                             System.out.println("User Name: " + getUserName(getFromEmail(from[0].toString())));
                             System.out.println("Random Universal Browser: " + getRandomUniversalBrowser());
                            System.out.println("From Name: " + getFromName(from[0].toString()));
                            System.out.println("From Email: "+ getFromEmail(from[0].toString()));
                            System.out.println("Subject: " + message.getSubject()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
        else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--RANDOMIP")
            && this.containsEqualsIgnoreCase(commands,"--USERNAME") && this.containsEqualsIgnoreCase(commands,"--RANDSTRING"))
            {
                try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            if(this.containsEquals(commands,"--randstring"))
                                System.out.println("Random String in lowercase: " + getRandomStringLowerCase()); 
                            else if(this.containsEquals(commands,"--RANDSTRING"))
                                System.out.println("Random String in UpperCase : " + getRandomStringUpperCase());


                            System.out.println("Random IP: " + getRandomIP());
                             System.out.println("User Name: " + getUserName(getFromEmail(from[0].toString())));
                            System.out.println("From Name: " + getFromName(from[0].toString()));
                            System.out.println("From Email: "+ getFromEmail(from[0].toString()));
                            System.out.println("Subject: " + message.getSubject()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
        else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--RANDOMIP")
            && this.containsEqualsIgnoreCase(commands,"--USERNAME") && this.containsStartWith(commands,"--NUMBER"))
            {
                try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            
                            if(this.containsStartWith(commands,"--NUMBER1"))
                                System.out.println("Random Number: " + getNumbers(1)); 
                            else if(this.containsStartWith(commands,"--NUMBER2"))
                                System.out.println("Random Number: " + getNumbers(2));
                            else if(this.containsStartWith(commands,"--NUMBER3"))
                                System.out.println("Random Number: " + getNumbers(3));
                            else if(this.containsStartWith(commands,"--NUMBER4"))
                                System.out.println("Random Number: " + getNumbers(4));
                            else if(this.containsStartWith(commands,"--NUMBER5"))
                                System.out.println("Random Number: " + getNumbers(5));
                            else if(this.containsStartWith(commands,"--NUMBER6"))
                                System.out.println("Random Number: " + getNumbers(6));
                            else if(this.containsStartWith(commands,"--NUMBER7"))
                                System.out.println("Random Number: " + getNumbers(7));
                            else if(this.containsStartWith(commands,"--NUMBER8"))
                                System.out.println("Random Number: " + getNumbers(8));
                            else if(this.containsStartWith(commands,"--NUMBER9"))
                                System.out.println("Random Number: " + getNumbers(9));
                            else if(this.containsStartWith(commands,"--NUMBER10"))
                                System.out.println("Random Number: " + getNumbers(10));
                            
                            System.out.println("Random IP: " + getRandomIP());
                             System.out.println("User Name: " + getUserName(getFromEmail(from[0].toString())));
                            System.out.println("From Name: " + getFromName(from[0].toString()));
                            System.out.println("From Email: "+ getFromEmail(from[0].toString()));
                            System.out.println("Subject: " + message.getSubject()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
        else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--RANDOMIP")
            && this.containsEqualsIgnoreCase(commands,"--USERNAME") && this.containsStartWith(commands,"--CHAR"))
            {
                try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate());
                            
if(this.containsStartWith(commands,"--CHAR1"))
                                System.out.println("Random Characters in Upper Case: " + getCharUpperCase(1)); 
                            else if(this.containsStartWith(commands,"--CHAR2"))
                                System.out.println("Random Characters in Upper Case: " + getCharUpperCase(2));
                            else if(this.containsStartWith(commands,"--CHAR3"))
                                System.out.println("Random Characters in Upper Case: " + getCharUpperCase(3)); 
                            else if(this.containsStartWith(commands,"--CHAR4"))
                                System.out.println("Random Characters in Upper Case: " + getCharUpperCase(4)); 
                            else if(this.containsStartWith(commands,"--CHAR5"))
                                System.out.println("Random Characters in Upper Case: " + getCharUpperCase(5)); 
                            else if(this.containsStartWith(commands,"--CHAR6"))
                                System.out.println("Random Characters in Upper Case: " + getCharUpperCase(6)); 
                            else if(this.containsStartWith(commands,"--CHAR7"))
                                System.out.println("Random Characters in Upper Case: " + getCharUpperCase(7)); 
                            else if(this.containsStartWith(commands,"--CHAR8"))
                                System.out.println("Random Characters in Upper Case: " + getCharUpperCase(8)); 
                            else if(this.containsStartWith(commands,"--CHAR9"))
                                System.out.println("Random Characters in Upper Case: " + getCharUpperCase(9)); 
                            else if(this.containsStartWith(commands,"--CHAR10"))
                                System.out.println("Random Characters in Upper Case: " + getCharUpperCase(10));
                            else if(this.containsStartWith(commands,"--char1"))
                                System.out.println("Random Characters in Lower Case: " + getCharLowerCase(1)); 
                            else if(this.containsStartWith(commands,"--char2"))
                                System.out.println("Random Characters in Lower Case: " + getCharLowerCase(2)); 
                            else if(this.containsStartWith(commands,"--char3"))
                                System.out.println("Random Characters in Lower Case: " + getCharLowerCase(3)); 
                            else if(this.containsStartWith(commands,"--char4"))
                                System.out.println("Random Characters in Lower Case: " + getCharLowerCase(4)); 
                            else if(this.containsStartWith(commands,"--char5"))
                                System.out.println("Random Characters in Lower Case: " + getCharLowerCase(5)); 
                            else if(this.containsStartWith(commands,"--char6"))
                                System.out.println("Random Characters in Lower Case: " + getCharLowerCase(6)); 
                            else if(this.containsStartWith(commands,"--char7"))
                                System.out.println("Random Characters in Lower Case: " + getCharLowerCase(7)); 
                            else if(this.containsStartWith(commands,"--char8"))
                                System.out.println("Random Characters in Lower Case: " + getCharLowerCase(8)); 
                            else if(this.containsStartWith(commands,"--char9"))
                                System.out.println("Random Characters in Lower Case: " + getCharLowerCase(9)); 
                            else if(this.containsStartWith(commands,"--char10"))
                                System.out.println("Random Characters in Lower Case: " + getCharLowerCase(10));


                            
                            System.out.println("Random IP: " + getRandomIP());
                             System.out.println("User Name: " + getUserName(getFromEmail(from[0].toString())));
                            System.out.println("From Name: " + getFromName(from[0].toString()));
                            System.out.println("From Email: "+ getFromEmail(from[0].toString()));
                            System.out.println("Subject: " + message.getSubject()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
        
        
        //EMAIL64
        
        else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--RANDOMIP")
            && this.containsEqualsIgnoreCase(commands,"--USERNAME") && this.containsEqualsIgnoreCase(commands,"--EMAILCENSORED"))
            {
                try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random IP: " +Base64.getEncoder().encodeToString( getRandomIP().getBytes()));
                             System.out.println("User Name: " + Base64.getEncoder().encodeToString(getUserName(getFromEmail(from[0].toString())).getBytes()));
                             System.out.println("Email Censored: " + Base64.getEncoder().encodeToString(getEmailCensored(getFromEmail(from[0].toString())).getBytes()));
                            System.out.println("From Name: " + Base64.getEncoder().encodeToString(getFromName(from[0].toString()).getBytes()));
                            System.out.println("From Email: "+ Base64.getEncoder().encodeToString(getFromEmail(from[0].toString()).getBytes()));
                            System.out.println("Subject: " + Base64.getEncoder().encodeToString(message.getSubject().getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
            }
        else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--RANDOMIP")
            && this.containsEqualsIgnoreCase(commands,"--USERNAME")&& this.containsEqualsIgnoreCase(commands,"--DOMAINFULL"))
            {
                try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random IP: " + Base64.getEncoder().encodeToString(getRandomIP().getBytes()));
                             System.out.println("User Name: " + Base64.getEncoder().encodeToString(getUserName(getFromEmail(from[0].toString())).getBytes()));
                             System.out.println("Domain Full: " + Base64.getEncoder().encodeToString(getDomainFull(getFromEmail(from[0].toString())).getBytes()));
                            System.out.println("From Name: " + Base64.getEncoder().encodeToString(getFromName(from[0].toString()).getBytes()));
                            System.out.println("From Email: "+ Base64.getEncoder().encodeToString(getFromEmail(from[0].toString()).getBytes()));
                            System.out.println("Subject: " + Base64.getEncoder().encodeToString(message.getSubject().getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
        else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--RANDOMIP")
            && this.containsEqualsIgnoreCase(commands,"--USERNAME")&& this.containsEqualsIgnoreCase(commands,"--DOMAINNAME"))
            {
                try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random IP: " + Base64.getEncoder().encodeToString(getRandomIP().getBytes()));
                             System.out.println("User Name: " + Base64.getEncoder().encodeToString(getUserName(getFromEmail(from[0].toString())).getBytes()));
                             System.out.println("Domain Name: " + Base64.getEncoder().encodeToString(getDomainName(getFromEmail(from[0].toString())).getBytes()));
                            System.out.println("From Name: " + Base64.getEncoder().encodeToString(getFromName(from[0].toString()).getBytes()));
                            System.out.println("From Email: "+Base64.getEncoder().encodeToString( getFromEmail(from[0].toString()).getBytes()));
                            System.out.println("Subject: " + Base64.getEncoder().encodeToString(message.getSubject().getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
        else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--RANDOMIP")
            && this.containsEqualsIgnoreCase(commands,"--USERNAME") && this.containsEqualsIgnoreCase(commands,"--COUNTRY"))
            {
                try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random IP: " + Base64.getEncoder().encodeToString(getRandomIP().getBytes()));
                             System.out.println("User Name: " + Base64.getEncoder().encodeToString(getUserName(getFromEmail(from[0].toString())).getBytes()));
                             System.out.println("Random Country: " + Base64.getEncoder().encodeToString(getRandomCountry().getBytes()));
                            System.out.println("From Name: " + Base64.getEncoder().encodeToString(getFromName(from[0].toString()).getBytes()));
                            System.out.println("From Email: "+ Base64.getEncoder().encodeToString(getFromEmail(from[0].toString()).getBytes()));
                            System.out.println("Subject: " + Base64.getEncoder().encodeToString(message.getSubject().getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
        else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--RANDOMIP")
            && this.containsEqualsIgnoreCase(commands,"--USERNAME") && this.containsEqualsIgnoreCase(commands,"--DATE"))
            {
                try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random IP: " + Base64.getEncoder().encodeToString(getRandomIP().getBytes()));
                             System.out.println("User Name: " + Base64.getEncoder().encodeToString(getUserName(getFromEmail(from[0].toString())).getBytes()));
                             System.out.println("Today's Date: " + Base64.getEncoder().encodeToString(getDate().getBytes()));
                            System.out.println("From Name: " + Base64.getEncoder().encodeToString(getFromName(from[0].toString()).getBytes()));
                            System.out.println("From Email: "+ Base64.getEncoder().encodeToString(getFromEmail(from[0].toString()).getBytes()));
                            System.out.println("Subject: " + Base64.getEncoder().encodeToString(message.getSubject().getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
        else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--RANDOMIP")
            && this.containsEqualsIgnoreCase(commands,"--USERNAME") && this.containsEqualsIgnoreCase(commands,"--DATETOMORROW"))
            {
                try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random IP: " + Base64.getEncoder().encodeToString(getRandomIP().getBytes()));
                             System.out.println("User Name: " + Base64.getEncoder().encodeToString(getUserName(getFromEmail(from[0].toString())).getBytes()));
                             System.out.println("Date Tomorrow: " + Base64.getEncoder().encodeToString(getTomorrowDate().getBytes()));
                            System.out.println("From Name: " + Base64.getEncoder().encodeToString(getFromName(from[0].toString()).getBytes()));
                            System.out.println("From Email: "+ Base64.getEncoder().encodeToString(getFromEmail(from[0].toString()).getBytes()));
                            System.out.println("Subject: " + Base64.getEncoder().encodeToString(message.getSubject().getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
        else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--RANDOMIP")
            && this.containsEqualsIgnoreCase(commands,"--USERNAME") && this.containsEqualsIgnoreCase(commands,"--TIME"))
            {
                try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random IP: " + Base64.getEncoder().encodeToString(getRandomIP().getBytes()));
                             System.out.println("User Name: " + Base64.getEncoder().encodeToString(getUserName(getFromEmail(from[0].toString())).getBytes()));
                             System.out.println("Time: " + Base64.getEncoder().encodeToString(getTime().getBytes()));
                            System.out.println("From Name: " + Base64.getEncoder().encodeToString(getFromName(from[0].toString()).getBytes()));
                            System.out.println("From Email: "+ Base64.getEncoder().encodeToString(getFromEmail(from[0].toString()).getBytes()));
                            System.out.println("Subject: " + Base64.getEncoder().encodeToString(message.getSubject().getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
        else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--RANDOMIP")
            && this.containsEqualsIgnoreCase(commands,"--USERNAME") && this.containsEqualsIgnoreCase(commands,"--PC_OS"))
            {
                try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random IP: " + Base64.getEncoder().encodeToString(getRandomIP().getBytes()));
                             System.out.println("User Name: " + Base64.getEncoder().encodeToString(getUserName(getFromEmail(from[0].toString())).getBytes()));
                             System.out.println("Random PC OS: " + Base64.getEncoder().encodeToString(getRandomPCOS().getBytes()));
                            System.out.println("From Name: " + Base64.getEncoder().encodeToString(getFromName(from[0].toString()).getBytes()));
                            System.out.println("From Email: "+ Base64.getEncoder().encodeToString(getFromEmail(from[0].toString()).getBytes()));
                            System.out.println("Subject: " + Base64.getEncoder().encodeToString(message.getSubject().getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
        else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--RANDOMIP")
            && this.containsEqualsIgnoreCase(commands,"--USERNAME") && this.containsEqualsIgnoreCase(commands,"--PC_BROWSER"))
            {
                try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random IP: " + Base64.getEncoder().encodeToString(getRandomIP().getBytes()));
                             System.out.println("User Name: " + Base64.getEncoder().encodeToString(getUserName(getFromEmail(from[0].toString())).getBytes()));
                             System.out.println("Random PC Browser: " + Base64.getEncoder().encodeToString(getRandomPCBrowser().getBytes()));
                            System.out.println("From Name: " + Base64.getEncoder().encodeToString(getFromName(from[0].toString()).getBytes()));
                            System.out.println("From Email: "+ Base64.getEncoder().encodeToString(getFromEmail(from[0].toString()).getBytes()));
                            System.out.println("Subject: " + Base64.getEncoder().encodeToString(message.getSubject().getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
        else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--RANDOMIP")
            && this.containsEqualsIgnoreCase(commands,"--USERNAME") && this.containsEqualsIgnoreCase(commands,"--COUNTRYCITY"))
            {
                try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random IP: " + Base64.getEncoder().encodeToString(getRandomIP().getBytes()));
                             System.out.println("User Name: " + Base64.getEncoder().encodeToString(getUserName(getFromEmail(from[0].toString())).getBytes()));
                             System.out.println("Random Country City: " + Base64.getEncoder().encodeToString(getRandomCity().getBytes()));
                            System.out.println("From Name: " + Base64.getEncoder().encodeToString(getFromName(from[0].toString()).getBytes()));
                            System.out.println("From Email: "+ Base64.getEncoder().encodeToString(getFromEmail(from[0].toString()).getBytes()));
                            System.out.println("Subject: " + Base64.getEncoder().encodeToString(message.getSubject().getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
        else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--RANDOMIP")
            && this.containsEqualsIgnoreCase(commands,"--USERNAME") && this.containsEqualsIgnoreCase(commands,"--ANDROID_OS"))
            {
                try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random IP: " + Base64.getEncoder().encodeToString(getRandomIP().getBytes()));
                             System.out.println("User Name: " + Base64.getEncoder().encodeToString(getUserName(getFromEmail(from[0].toString())).getBytes()));
                             System.out.println("Random Android OS: " + Base64.getEncoder().encodeToString(getRandomAndroidOS().getBytes()));
                            System.out.println("From Name: " + Base64.getEncoder().encodeToString(getFromName(from[0].toString()).getBytes()));
                            System.out.println("From Email: "+ Base64.getEncoder().encodeToString(getFromEmail(from[0].toString()).getBytes()));
                            System.out.println("Subject: " +Base64.getEncoder().encodeToString( message.getSubject().getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
        else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--RANDOMIP")
            && this.containsEqualsIgnoreCase(commands,"--USERNAME") && this.containsEqualsIgnoreCase(commands,"--ANDROID_BROWSER"))
            {
                try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random IP: " + Base64.getEncoder().encodeToString(getRandomIP().getBytes()));
                             System.out.println("User Name: " + Base64.getEncoder().encodeToString(getUserName(getFromEmail(from[0].toString())).getBytes()));
                             System.out.println("Random Android Browser: " + Base64.getEncoder().encodeToString(getRandomAndroidBrowser().getBytes()));
                            System.out.println("From Name: " + Base64.getEncoder().encodeToString(getFromName(from[0].toString()).getBytes()));
                            System.out.println("From Email: "+ Base64.getEncoder().encodeToString(getFromEmail(from[0].toString()).getBytes()));
                            System.out.println("Subject: " + Base64.getEncoder().encodeToString(message.getSubject().getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
        else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--RANDOMIP")
            && this.containsEqualsIgnoreCase(commands,"--USERNAME") && this.containsEqualsIgnoreCase(commands,"--UA"))
            {
                try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random IP: " + Base64.getEncoder().encodeToString(getRandomIP().getBytes()));
                             System.out.println("User Name: " + Base64.getEncoder().encodeToString(getUserName(getFromEmail(from[0].toString())).getBytes()));
                             System.out.println("Random User Agent: " + Base64.getEncoder().encodeToString(getRandomUserAgent().getBytes()));
                            System.out.println("From Name: " + Base64.getEncoder().encodeToString(getFromName(from[0].toString()).getBytes()));
                            System.out.println("From Email: "+ Base64.getEncoder().encodeToString(getFromEmail(from[0].toString()).getBytes()));
                            System.out.println("Subject: " +Base64.getEncoder().encodeToString( message.getSubject().getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
        else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--RANDOMIP")
            && this.containsEqualsIgnoreCase(commands,"--USERNAME") && this.containsEqualsIgnoreCase(commands,"-APPLEAPPS"))
            {
                try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random IP: " + Base64.getEncoder().encodeToString(getRandomIP().getBytes()));
                             System.out.println("User Name: " + Base64.getEncoder().encodeToString(getUserName(getFromEmail(from[0].toString())).getBytes()));
                             System.out.println("Random Apple App: " + Base64.getEncoder().encodeToString(getRandomAppleApps().getBytes()));
                            System.out.println("From Name: " + Base64.getEncoder().encodeToString(getFromName(from[0].toString()).getBytes()));
                            System.out.println("From Email: "+Base64.getEncoder().encodeToString( getFromEmail(from[0].toString()).getBytes()));
                            System.out.println("Subject: " + Base64.getEncoder().encodeToString(message.getSubject().getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
        else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--RANDOMIP")
            && this.containsEqualsIgnoreCase(commands,"--USERNAME") && this.containsEqualsIgnoreCase(commands,"--APPLEPC"))
            {
                try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random IP: " + Base64.getEncoder().encodeToString(getRandomIP().getBytes()));
                             System.out.println("User Name: " + Base64.getEncoder().encodeToString(getUserName(getFromEmail(from[0].toString())).getBytes()));
                             System.out.println("Random Apple PC: " + Base64.getEncoder().encodeToString(getUserName(getFromEmail(from[0].toString())).getBytes()));
                            System.out.println("From Name: " + Base64.getEncoder().encodeToString(getFromName(from[0].toString()).getBytes()));
                            System.out.println("From Email: "+ Base64.getEncoder().encodeToString(getFromEmail(from[0].toString()).getBytes()));
                            System.out.println("Subject: " + Base64.getEncoder().encodeToString(message.getSubject().getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
        else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--RANDOMIP")
            && this.containsEqualsIgnoreCase(commands,"--USERNAME") && this.containsEqualsIgnoreCase(commands,"--APPLE_PHONES"))
            {
                try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random IP: " + Base64.getEncoder().encodeToString(getRandomIP().getBytes()));
                             System.out.println("User Name: " + Base64.getEncoder().encodeToString(getUserName(getFromEmail(from[0].toString())).getBytes()));
                             System.out.println("Random Apple Phones: " + Base64.getEncoder().encodeToString(getUserName(getFromEmail(from[0].toString())).getBytes()));
                            System.out.println("From Name: " + Base64.getEncoder().encodeToString(getFromName(from[0].toString()).getBytes()));
                            System.out.println("From Email: "+ Base64.getEncoder().encodeToString(getFromEmail(from[0].toString()).getBytes()));
                            System.out.println("Subject: " + Base64.getEncoder().encodeToString(message.getSubject().getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
        else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--RANDOMIP")
            && this.containsEqualsIgnoreCase(commands,"--USERNAME") && this.containsEqualsIgnoreCase(commands,"--UNIVERSAL_BROWSER"))
            {
                try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random IP: " + Base64.getEncoder().encodeToString(getRandomIP().getBytes()));
                             System.out.println("User Name: " + Base64.getEncoder().encodeToString(getUserName(getFromEmail(from[0].toString())).getBytes()));
                             System.out.println("Random Universal Browser: " + Base64.getEncoder().encodeToString(getRandomUniversalBrowser().getBytes()));
                            System.out.println("From Name: " + Base64.getEncoder().encodeToString(getFromName(from[0].toString()).getBytes()));
                            System.out.println("From Email: "+ Base64.getEncoder().encodeToString(getFromEmail(from[0].toString()).getBytes()));
                            System.out.println("Subject: " + Base64.getEncoder().encodeToString(message.getSubject().getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
        else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--RANDOMIP")
            && this.containsEqualsIgnoreCase(commands,"--USERNAME") && this.containsEqualsIgnoreCase(commands,"--RANDSTRING"))
            {
                try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate());
                            if(this.containsEquals(commands,"--randstring"))
                                System.out.println("Random String in lowercase: " + Base64.getEncoder().encodeToString(getRandomStringLowerCase().getBytes())); 
                            else if(this.containsEquals(commands,"--RANDSTRING"))
                                System.out.println("Random String in UpperCase : " + Base64.getEncoder().encodeToString(getRandomStringUpperCase().getBytes())); 
                            
                            
                            System.out.println("Random IP: " + Base64.getEncoder().encodeToString(getRandomIP().getBytes()));
                             System.out.println("User Name: " + Base64.getEncoder().encodeToString(getUserName(getFromEmail(from[0].toString())).getBytes()));
                            System.out.println("From Name: " + Base64.getEncoder().encodeToString(getFromName(from[0].toString()).getBytes()));
                            System.out.println("From Email: "+ Base64.getEncoder().encodeToString(getFromEmail(from[0].toString()).getBytes()));
                            System.out.println("Subject: " + Base64.getEncoder().encodeToString(message.getSubject().getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
        else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--RANDOMIP")
            && this.containsEqualsIgnoreCase(commands,"--USERNAME") && this.containsStartWith(commands,"--NUMBER"))
            {
                try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            if(this.containsStartWith(commands,"--NUMBER1"))
                                System.out.println("Random Number: " + (Base64.getEncoder().encodeToString(getNumbers(1).getBytes()))); 
                            else if(this.containsStartWith(commands,"--NUMBER2"))
                                System.out.println("Random Number: " + (Base64.getEncoder().encodeToString(getNumbers(2).getBytes())));
                            else if(this.containsStartWith(commands,"--NUMBER3"))
                                System.out.println("Random Number: " + (Base64.getEncoder().encodeToString(getNumbers(3).getBytes())));
                            else if(this.containsStartWith(commands,"--NUMBER4"))
                                System.out.println("Random Number: " + Base64.getEncoder().encodeToString(getNumbers(4).getBytes()));
                            else if(this.containsStartWith(commands,"--NUMBER5"))
                                System.out.println("Random Number: " + Base64.getEncoder().encodeToString(getNumbers(5).getBytes()));
                            else if(this.containsStartWith(commands,"--NUMBER6"))
                                System.out.println("Random Number: " + Base64.getEncoder().encodeToString(getNumbers(6).getBytes()));
                            else if(this.containsStartWith(commands,"--NUMBER7"))
                                System.out.println("Random Number: " + Base64.getEncoder().encodeToString(getNumbers(7).getBytes()));
                            else if(this.containsStartWith(commands,"--NUMBER8"))
                                System.out.println("Random Number: " + Base64.getEncoder().encodeToString(getNumbers(8).getBytes()));
                            else if(this.containsStartWith(commands,"--NUMBER9"))
                                System.out.println("Random Number: " + Base64.getEncoder().encodeToString(getNumbers(9).getBytes()));
                            else if(this.containsStartWith(commands,"--NUMBER10"))
                                System.out.println("Random Number: " + Base64.getEncoder().encodeToString(getNumbers(10).getBytes()));
                            
                            
                            System.out.println("Random IP: " + Base64.getEncoder().encodeToString(getRandomIP().getBytes()));
                             System.out.println("User Name: " + Base64.getEncoder().encodeToString(getUserName(getFromEmail(from[0].toString())).getBytes()));
                            System.out.println("From Name: " + Base64.getEncoder().encodeToString(getFromName(from[0].toString()).getBytes()));
                            System.out.println("From Email: "+ Base64.getEncoder().encodeToString(getFromEmail(from[0].toString()).getBytes()));
                            System.out.println("Subject: " + Base64.getEncoder().encodeToString(message.getSubject().getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
        else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--RANDOMIP")
            && this.containsEqualsIgnoreCase(commands,"--USERNAME") && this.containsStartWith(commands,"--CHAR"))
            {
                try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            if(this.containsStartWith(commands,"--CHAR1"))
                                System.out.println("Random Characters in Upper Case: " + Base64.getEncoder().encodeToString(getCharUpperCase(1).getBytes())); 
                            else if(this.containsStartWith(commands,"--CHAR2"))
                                System.out.println("Random Characters in Upper Case: " +Base64.getEncoder().encodeToString( getCharUpperCase(2).getBytes()));
                            else if(this.containsStartWith(commands,"--CHAR3"))
                                System.out.println("Random Characters in Upper Case: " + Base64.getEncoder().encodeToString(getCharUpperCase(3).getBytes())); 
                            else if(this.containsStartWith(commands,"--CHAR4"))
                                System.out.println("Random Characters in Upper Case: " + Base64.getEncoder().encodeToString(getCharUpperCase(4).getBytes())); 
                            else if(this.containsStartWith(commands,"--CHAR5"))
                                System.out.println("Random Characters in Upper Case: " + Base64.getEncoder().encodeToString(getCharUpperCase(5).getBytes())); 
                            else if(this.containsStartWith(commands,"--CHAR6"))
                                System.out.println("Random Characters in Upper Case: " + Base64.getEncoder().encodeToString(getCharUpperCase(6).getBytes())); 
                            else if(this.containsStartWith(commands,"--CHAR7"))
                                System.out.println("Random Characters in Upper Case: " + Base64.getEncoder().encodeToString(getCharUpperCase(7).getBytes())); 
                            else if(this.containsStartWith(commands,"--CHAR8"))
                                System.out.println("Random Characters in Upper Case: " + Base64.getEncoder().encodeToString(getCharUpperCase(8).getBytes())); 
                            else if(this.containsStartWith(commands,"--CHAR9"))
                                System.out.println("Random Characters in Upper Case: " + Base64.getEncoder().encodeToString(getCharUpperCase(9).getBytes())); 
                            else if(this.containsStartWith(commands,"--CHAR10"))
                                System.out.println("Random Characters in Upper Case: " + Base64.getEncoder().encodeToString(getCharUpperCase(10).getBytes()));
                            else if(this.containsStartWith(commands,"--char1"))
                                System.out.println("Random Characters in Lower Case: " + Base64.getEncoder().encodeToString(getCharLowerCase(1).getBytes())); 
                            else if(this.containsStartWith(commands,"--char2"))
                                System.out.println("Random Characters in Lower Case: " + Base64.getEncoder().encodeToString(getCharLowerCase(2).getBytes())); 
                            else if(this.containsStartWith(commands,"--char3"))
                                System.out.println("Random Characters in Lower Case: " + Base64.getEncoder().encodeToString(getCharLowerCase(3).getBytes())); 
                            else if(this.containsStartWith(commands,"--char4"))
                                System.out.println("Random Characters in Lower Case: " + Base64.getEncoder().encodeToString(getCharLowerCase(4).getBytes())); 
                            else if(this.containsStartWith(commands,"--char5"))
                                System.out.println("Random Characters in Lower Case: " + Base64.getEncoder().encodeToString(getCharLowerCase(5).getBytes())); 
                            else if(this.containsStartWith(commands,"--char6"))
                                System.out.println("Random Characters in Lower Case: " + Base64.getEncoder().encodeToString(getCharLowerCase(6).getBytes())); 
                            else if(this.containsStartWith(commands,"--char7"))
                                System.out.println("Random Characters in Lower Case: " + Base64.getEncoder().encodeToString(getCharLowerCase(7).getBytes())); 
                            else if(this.containsStartWith(commands,"--char8"))
                                System.out.println("Random Characters in Lower Case: " + Base64.getEncoder().encodeToString(getCharLowerCase(8).getBytes())); 
                            else if(this.containsStartWith(commands,"--char9"))
                                System.out.println("Random Characters in Lower Case: " + Base64.getEncoder().encodeToString(getCharLowerCase(9).getBytes())); 
                            else if(this.containsStartWith(commands,"--char10"))
                                System.out.println("Random Characters in Lower Case: " + Base64.getEncoder().encodeToString(getCharLowerCase(10).getBytes())); 
                            
                            
                            
                            System.out.println("Random IP: " + Base64.getEncoder().encodeToString(getRandomIP().getBytes()));
                             System.out.println("User Name: " + Base64.getEncoder().encodeToString(getUserName(getFromEmail(from[0].toString())).getBytes()));
                            System.out.println("From Name: " + Base64.getEncoder().encodeToString(getFromName(from[0].toString()).getBytes()));
                            System.out.println("From Email: "+ Base64.getEncoder().encodeToString(getFromEmail(from[0].toString()).getBytes()));
                            System.out.println("Subject: " + Base64.getEncoder().encodeToString(message.getSubject().getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
                }
                 else
                {
                    System.out.println("Invalid Syntax/Command!");
                }
        
        
        
    }
    
    //Test Sucessful
     public void switchCase9(String[] commands)
    {
        if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--RANDOMIP")
            && this.containsEqualsIgnoreCase(commands,"--USERNAME") && this.containsEqualsIgnoreCase(commands,"--EMAILCENSORED")
                && this.containsEqualsIgnoreCase(commands,"--DOMAINFULL"))
            {
                try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random IP: " + getRandomIP());
                             System.out.println("User Name: " + getUserName(getFromEmail(from[0].toString())));
                             System.out.println("Email Censored: " + getEmailCensored(getFromEmail(from[0].toString())));
                             System.out.println("Domain Full: " + getDomainFull(getFromEmail(from[0].toString())));
                            System.out.println("From Name: " + getFromName(from[0].toString()));
                            System.out.println("From Email: "+ getFromEmail(from[0].toString()));
                            System.out.println("Subject: " + message.getSubject()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
            }
        else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--RANDOMIP")
            && this.containsEqualsIgnoreCase(commands,"--USERNAME") && this.containsEqualsIgnoreCase(commands,"--EMAILCENSORED")
                && this.containsEqualsIgnoreCase(commands,"--DOMAINNAME"))
            {
                try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random IP: " + getRandomIP());
                             System.out.println("User Name: " + getUserName(getFromEmail(from[0].toString())));
                             System.out.println("Email Censored: " + getEmailCensored(getFromEmail(from[0].toString())));
                             System.out.println("Domain Name: " + getDomainName(getFromEmail(from[0].toString())));
                            System.out.println("From Name: " + getFromName(from[0].toString()));
                            System.out.println("From Email: "+ getFromEmail(from[0].toString()));
                            System.out.println("Subject: " + message.getSubject()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
            }
        else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--RANDOMIP")
            && this.containsEqualsIgnoreCase(commands,"--USERNAME") && this.containsEqualsIgnoreCase(commands,"--EMAILCENSORED")
                && this.containsEqualsIgnoreCase(commands,"--COUNTRY"))
            
            {
                try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random IP: " + getRandomIP());
                             System.out.println("User Name: " + getUserName(getFromEmail(from[0].toString())));
                             System.out.println("Email Censored: " + getEmailCensored(getFromEmail(from[0].toString())));
                             System.out.println("Random Country: " + getRandomCountry());
                            System.out.println("From Name: " + getFromName(from[0].toString()));
                            System.out.println("From Email: "+ getFromEmail(from[0].toString()));
                            System.out.println("Subject: " + message.getSubject()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
            }
        else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--RANDOMIP")
            && this.containsEqualsIgnoreCase(commands,"--USERNAME") && this.containsEqualsIgnoreCase(commands,"--EMAILCENSORED")
                && this.containsEqualsIgnoreCase(commands,"--DATE"))
            {
                try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random IP: " + getRandomIP());
                             System.out.println("User Name: " + getUserName(getFromEmail(from[0].toString())));
                             System.out.println("Email Censored: " + getEmailCensored(getFromEmail(from[0].toString())));
                             System.out.println("Today's Date" + getDate());
                            System.out.println("From Name: " + getFromName(from[0].toString()));
                            System.out.println("From Email: "+ getFromEmail(from[0].toString()));
                            System.out.println("Subject: " + message.getSubject()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
            }
        else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--RANDOMIP")
            && this.containsEqualsIgnoreCase(commands,"--USERNAME") && this.containsEqualsIgnoreCase(commands,"--EMAILCENSORED")
                && this.containsEqualsIgnoreCase(commands,"--DATETOMORROW"))
            {
                try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random IP: " + getRandomIP());
                             System.out.println("User Name: " + getUserName(getFromEmail(from[0].toString())));
                             System.out.println("Email Censored: " + getEmailCensored(getFromEmail(from[0].toString())));
                             System.out.println("Date Tomorrow: " + getTomorrowDate());
                            System.out.println("From Name: " + getFromName(from[0].toString()));
                            System.out.println("From Email: "+ getFromEmail(from[0].toString()));
                            System.out.println("Subject: " + message.getSubject()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
            }
        else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--RANDOMIP")
            && this.containsEqualsIgnoreCase(commands,"--USERNAME") && this.containsEqualsIgnoreCase(commands,"--EMAILCENSORED")
                && this.containsEqualsIgnoreCase(commands,"--TIME"))
            {
                try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random IP: " + getRandomIP());
                             System.out.println("User Name: " + getUserName(getFromEmail(from[0].toString())));
                             System.out.println("Email Censored: " + getEmailCensored(getFromEmail(from[0].toString())));
                             System.out.println("Time: " + getTime());
                            System.out.println("From Name: " + getFromName(from[0].toString()));
                            System.out.println("From Email: "+ getFromEmail(from[0].toString()));
                            System.out.println("Subject: " + message.getSubject()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
            }
        else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--RANDOMIP")
            && this.containsEqualsIgnoreCase(commands,"--USERNAME") && this.containsEqualsIgnoreCase(commands,"--EMAILCENSORED")
                && this.containsEqualsIgnoreCase(commands,"--PC_OS"))
            {
                try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random IP: " + getRandomIP());
                             System.out.println("User Name: " + getUserName(getFromEmail(from[0].toString())));
                             System.out.println("Email Censored: " + getEmailCensored(getFromEmail(from[0].toString())));
                             System.out.println("Random PC OS: " + getRandomPCOS());
                            System.out.println("From Name: " + getFromName(from[0].toString()));
                            System.out.println("From Email: "+ getFromEmail(from[0].toString()));
                            System.out.println("Subject: " + message.getSubject()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
            }
        else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--RANDOMIP")
            && this.containsEqualsIgnoreCase(commands,"--USERNAME") && this.containsEqualsIgnoreCase(commands,"--EMAILCENSORED")
                && this.containsEqualsIgnoreCase(commands,"--PC_BROWSER"))
            {
                try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random IP: " + getRandomIP());
                             System.out.println("User Name: " + getUserName(getFromEmail(from[0].toString())));
                             System.out.println("Email Censored: " + getEmailCensored(getFromEmail(from[0].toString())));
                             System.out.println("Random PC Browser: " + getRandomPCBrowser());
                            System.out.println("From Name: " + getFromName(from[0].toString()));
                            System.out.println("From Email: "+ getFromEmail(from[0].toString()));
                            System.out.println("Subject: " + message.getSubject()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
            }
        else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--RANDOMIP")
            && this.containsEqualsIgnoreCase(commands,"--USERNAME") && this.containsEqualsIgnoreCase(commands,"--EMAILCENSORED")
                && this.containsEqualsIgnoreCase(commands,"--COUNTRYCITY"))
            {
                try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random IP: " + getRandomIP());
                             System.out.println("User Name: " + getUserName(getFromEmail(from[0].toString())));
                             System.out.println("Email Censored: " + getEmailCensored(getFromEmail(from[0].toString())));
                             System.out.println("Random Country City: "/* + getRandomContryCity()*/);
                            System.out.println("From Name: " + getFromName(from[0].toString()));
                            System.out.println("From Email: "+ getFromEmail(from[0].toString()));
                            System.out.println("Subject: " + message.getSubject()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
            }
        else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--RANDOMIP")
            && this.containsEqualsIgnoreCase(commands,"--USERNAME") && this.containsEqualsIgnoreCase(commands,"--EMAILCENSORED")
                && this.containsEqualsIgnoreCase(commands,"--ANDROID_OS"))
            {
                try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random IP: " + getRandomIP());
                             System.out.println("User Name: " + getUserName(getFromEmail(from[0].toString())));
                             System.out.println("Email Censored: " + getEmailCensored(getFromEmail(from[0].toString())));
                             System.out.println("Random Android OS: " + getRandomAndroidOS());
                            System.out.println("From Name: " + getFromName(from[0].toString()));
                            System.out.println("From Email: "+ getFromEmail(from[0].toString()));
                            System.out.println("Subject: " + message.getSubject()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
            }
        else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--RANDOMIP")
            && this.containsEqualsIgnoreCase(commands,"--USERNAME") && this.containsEqualsIgnoreCase(commands,"--EMAILCENSORED")
                && this.containsEqualsIgnoreCase(commands,"--ANDROID_BROWSER"))
            {
                try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random IP: " + getRandomIP());
                             System.out.println("User Name: " + getUserName(getFromEmail(from[0].toString())));
                             System.out.println("Email Censored: " + getEmailCensored(getFromEmail(from[0].toString())));
                             System.out.println("Random Android Browser: " + getRandomAndroidBrowser());
                            System.out.println("From Name: " + getFromName(from[0].toString()));
                            System.out.println("From Email: "+ getFromEmail(from[0].toString()));
                            System.out.println("Subject: " + message.getSubject()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
            }
        else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--RANDOMIP")
            && this.containsEqualsIgnoreCase(commands,"--USERNAME") && this.containsEqualsIgnoreCase(commands,"--EMAILCENSORED")
                && this.containsEqualsIgnoreCase(commands,"--UA"))
            {
                try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random IP: " + getRandomIP());
                             System.out.println("User Name: " + getUserName(getFromEmail(from[0].toString())));
                             System.out.println("Email Censored: " + getEmailCensored(getFromEmail(from[0].toString())));
                             System.out.println("Random User Agent: " + getRandomUserAgent());
                            System.out.println("From Name: " + getFromName(from[0].toString()));
                            System.out.println("From Email: "+ getFromEmail(from[0].toString()));
                            System.out.println("Subject: " + message.getSubject()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
            }
        else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--RANDOMIP")
            && this.containsEqualsIgnoreCase(commands,"--USERNAME") && this.containsEqualsIgnoreCase(commands,"--EMAILCENSORED")
                && this.containsEqualsIgnoreCase(commands,"--APPLEAPPS"))
            {
                try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random IP: " + getRandomIP());
                             System.out.println("User Name: " + getUserName(getFromEmail(from[0].toString())));
                             System.out.println("Email Censored: " + getEmailCensored(getFromEmail(from[0].toString())));
                             System.out.println("Random Apple Apps: " + getRandomAppleApps());
                            System.out.println("From Name: " + getFromName(from[0].toString()));
                            System.out.println("From Email: "+ getFromEmail(from[0].toString()));
                            System.out.println("Subject: " + message.getSubject()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
            }
        else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--RANDOMIP")
            && this.containsEqualsIgnoreCase(commands,"--USERNAME") && this.containsEqualsIgnoreCase(commands,"--EMAILCENSORED")
                && this.containsEqualsIgnoreCase(commands,"--APPLE_PC"))
            {
                try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random IP: " + getRandomIP());
                             System.out.println("User Name: " + getUserName(getFromEmail(from[0].toString())));
                             System.out.println("Email Censored: " + getEmailCensored(getFromEmail(from[0].toString())));
                             System.out.println("Random Apple PC: " /*+ getRandomApplePC()*/);
                            System.out.println("From Name: " + getFromName(from[0].toString()));
                            System.out.println("From Email: "+ getFromEmail(from[0].toString()));
                            System.out.println("Subject: " + message.getSubject()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
            }
        else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--RANDOMIP")
            && this.containsEqualsIgnoreCase(commands,"--USERNAME") && this.containsEqualsIgnoreCase(commands,"--EMAILCENSORED")
                && this.containsEqualsIgnoreCase(commands,"--APPLE_PHONES"))
            {
                try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random IP: " + getRandomIP());
                             System.out.println("User Name: " + getUserName(getFromEmail(from[0].toString())));
                             System.out.println("Email Censored: " + getEmailCensored(getFromEmail(from[0].toString())));
                             System.out.println("Radom Apple Phone: " /*+ getRandomApplePhone()*/);
                            System.out.println("From Name: " + getFromName(from[0].toString()));
                            System.out.println("From Email: "+ getFromEmail(from[0].toString()));
                            System.out.println("Subject: " + message.getSubject()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
            }
        else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--RANDOMIP")
            && this.containsEqualsIgnoreCase(commands,"--USERNAME") && this.containsEqualsIgnoreCase(commands,"--EMAILCENSORED")
                && this.containsEqualsIgnoreCase(commands,"--UNIVERSAL_BROWSER"))
            {
                try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random IP: " + getRandomIP());
                             System.out.println("User Name: " + getUserName(getFromEmail(from[0].toString())));
                             System.out.println("Email Censored: " + getEmailCensored(getFromEmail(from[0].toString())));
                             System.out.println("Random Universal Browser: " + getRandomUniversalBrowser());
                            System.out.println("From Name: " + getFromName(from[0].toString()));
                            System.out.println("From Email: "+ getFromEmail(from[0].toString()));
                            System.out.println("Subject: " + message.getSubject()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
            }
        else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--RANDOMIP")
            && this.containsEqualsIgnoreCase(commands,"--USERNAME") && this.containsEqualsIgnoreCase(commands,"--EMAILCENSORED")
                && this.containsEqualsIgnoreCase(commands,"--RANDSTRING"))
            {
                try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            if(this.containsEquals(commands,"--randstring"))
                                System.out.println("Random String in lowercase: " + getRandomStringLowerCase()); 
                            else if(this.containsEquals(commands,"--RANDSTRING"))
                                System.out.println("Random String in UpperCase : " + getRandomStringUpperCase());


                            
                            System.out.println("Random IP: " + getRandomIP());
                             System.out.println("User Name: " + getUserName(getFromEmail(from[0].toString())));
                             System.out.println("Email Censored: " + getEmailCensored(getFromEmail(from[0].toString())));
                            System.out.println("From Name: " + getFromName(from[0].toString()));
                            System.out.println("From Email: "+ getFromEmail(from[0].toString()));
                            System.out.println("Subject: " + message.getSubject()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
            }
        else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--RANDOMIP")
            && this.containsEqualsIgnoreCase(commands,"--USERNAME") && this.containsEqualsIgnoreCase(commands,"--EMAILCENSORED")
                && this.containsStartWith(commands,"--NUMBER"))
            {
                try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            if(this.containsStartWith(commands,"--NUMBER1"))
                                System.out.println("Random Number: " + getNumbers(1)); 
                            else if(this.containsStartWith(commands,"--NUMBER2"))
                                System.out.println("Random Number: " + getNumbers(2));
                            else if(this.containsStartWith(commands,"--NUMBER3"))
                                System.out.println("Random Number: " + getNumbers(3));
                            else if(this.containsStartWith(commands,"--NUMBER4"))
                                System.out.println("Random Number: " + getNumbers(4));
                            else if(this.containsStartWith(commands,"--NUMBER5"))
                                System.out.println("Random Number: " + getNumbers(5));
                            else if(this.containsStartWith(commands,"--NUMBER6"))
                                System.out.println("Random Number: " + getNumbers(6));
                            else if(this.containsStartWith(commands,"--NUMBER7"))
                                System.out.println("Random Number: " + getNumbers(7));
                            else if(this.containsStartWith(commands,"--NUMBER8"))
                                System.out.println("Random Number: " + getNumbers(8));
                            else if(this.containsStartWith(commands,"--NUMBER9"))
                                System.out.println("Random Number: " + getNumbers(9));
                            else if(this.containsStartWith(commands,"--NUMBER10"))
                                System.out.println("Random Number: " + getNumbers(10));
                            
                            System.out.println("Random IP: " + getRandomIP());
                             System.out.println("User Name: " + getUserName(getFromEmail(from[0].toString())));
                             System.out.println("Email Censored: " + getEmailCensored(getFromEmail(from[0].toString())));
                            System.out.println("From Name: " + getFromName(from[0].toString()));
                            System.out.println("From Email: "+ getFromEmail(from[0].toString()));
                            System.out.println("Subject: " + message.getSubject()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
            }
        else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--RANDOMIP")
            && this.containsEqualsIgnoreCase(commands,"--USERNAME") && this.containsEqualsIgnoreCase(commands,"--EMAILCENSORED")
                && this.containsStartWith(commands,"--CHAR"))
            {
                try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            
                            if(this.containsStartWith(commands,"--CHAR1"))
                                System.out.println("Random Characters in Upper Case: " + getCharUpperCase(1)); 
                            else if(this.containsStartWith(commands,"--CHAR2"))
                                System.out.println("Random Characters in Upper Case: " + getCharUpperCase(2));
                            else if(this.containsStartWith(commands,"--CHAR3"))
                                System.out.println("Random Characters in Upper Case: " + getCharUpperCase(3)); 
                            else if(this.containsStartWith(commands,"--CHAR4"))
                                System.out.println("Random Characters in Upper Case: " + getCharUpperCase(4)); 
                            else if(this.containsStartWith(commands,"--CHAR5"))
                                System.out.println("Random Characters in Upper Case: " + getCharUpperCase(5)); 
                            else if(this.containsStartWith(commands,"--CHAR6"))
                                System.out.println("Random Characters in Upper Case: " + getCharUpperCase(6)); 
                            else if(this.containsStartWith(commands,"--CHAR7"))
                                System.out.println("Random Characters in Upper Case: " + getCharUpperCase(7)); 
                            else if(this.containsStartWith(commands,"--CHAR8"))
                                System.out.println("Random Characters in Upper Case: " + getCharUpperCase(8)); 
                            else if(this.containsStartWith(commands,"--CHAR9"))
                                System.out.println("Random Characters in Upper Case: " + getCharUpperCase(9)); 
                            else if(this.containsStartWith(commands,"--CHAR10"))
                                System.out.println("Random Characters in Upper Case: " + getCharUpperCase(10));
                            else if(this.containsStartWith(commands,"--char1"))
                                System.out.println("Random Characters in Lower Case: " + getCharLowerCase(1)); 
                            else if(this.containsStartWith(commands,"--char2"))
                                System.out.println("Random Characters in Lower Case: " + getCharLowerCase(2)); 
                            else if(this.containsStartWith(commands,"--char3"))
                                System.out.println("Random Characters in Lower Case: " + getCharLowerCase(3)); 
                            else if(this.containsStartWith(commands,"--char4"))
                                System.out.println("Random Characters in Lower Case: " + getCharLowerCase(4)); 
                            else if(this.containsStartWith(commands,"--char5"))
                                System.out.println("Random Characters in Lower Case: " + getCharLowerCase(5)); 
                            else if(this.containsStartWith(commands,"--char6"))
                                System.out.println("Random Characters in Lower Case: " + getCharLowerCase(6)); 
                            else if(this.containsStartWith(commands,"--char7"))
                                System.out.println("Random Characters in Lower Case: " + getCharLowerCase(7)); 
                            else if(this.containsStartWith(commands,"--char8"))
                                System.out.println("Random Characters in Lower Case: " + getCharLowerCase(8)); 
                            else if(this.containsStartWith(commands,"--char9"))
                                System.out.println("Random Characters in Lower Case: " + getCharLowerCase(9)); 
                            else if(this.containsStartWith(commands,"--char10"))
                                System.out.println("Random Characters in Lower Case: " + getCharLowerCase(10));

                            
                            System.out.println("Random IP: " + getRandomIP());
                             System.out.println("User Name: " + getUserName(getFromEmail(from[0].toString())));
                             System.out.println("Email Censored: " + getEmailCensored(getFromEmail(from[0].toString())));
                            System.out.println("From Name: " + getFromName(from[0].toString()));
                            System.out.println("From Email: "+ getFromEmail(from[0].toString()));
                            System.out.println("Subject: " + message.getSubject()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
            }
        
        
        //EMAIL 64
        
        
        if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--RANDOMIP")
            && this.containsEqualsIgnoreCase(commands,"--USERNAME") && this.containsEqualsIgnoreCase(commands,"--EMAILCENSORED")
                && this.containsEqualsIgnoreCase(commands,"--DOMAINFULL"))
            {
                try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random IP: " + Base64.getEncoder().encodeToString(getRandomIP().getBytes()));
                             System.out.println("User Name: " + Base64.getEncoder().encodeToString(getUserName(getFromEmail(from[0].toString())).getBytes()));
                             System.out.println("Email Censored: " + Base64.getEncoder().encodeToString(getEmailCensored(getFromEmail(from[0].toString())).getBytes()));
                             System.out.println("Domain Full: " + Base64.getEncoder().encodeToString(getDomainFull(getFromEmail(from[0].toString())).getBytes()));
                            System.out.println("From Name: " + Base64.getEncoder().encodeToString(getFromName(from[0].toString()).getBytes()));
                            System.out.println("From Email: "+ Base64.getEncoder().encodeToString(getFromEmail(from[0].toString()).getBytes()));
                            System.out.println("Subject: " + Base64.getEncoder().encodeToString(message.getSubject().getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
            }
        else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--RANDOMIP")
            && this.containsEqualsIgnoreCase(commands,"--USERNAME") && this.containsEqualsIgnoreCase(commands,"--EMAILCENSORED")
                && this.containsEqualsIgnoreCase(commands,"--DOMAINNAME"))
            {
                try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random IP: " + Base64.getEncoder().encodeToString(getRandomIP().getBytes()));
                             System.out.println("User Name: " + Base64.getEncoder().encodeToString(getUserName(getFromEmail(from[0].toString())).getBytes()));
                             System.out.println("Email Censored: " + Base64.getEncoder().encodeToString(getEmailCensored(getFromEmail(from[0].toString())).getBytes()));
                             System.out.println("Domain Name: " + Base64.getEncoder().encodeToString(getDomainName(getFromEmail(from[0].toString())).getBytes()));
                            System.out.println("From Name: " + Base64.getEncoder().encodeToString(getFromName(from[0].toString()).getBytes()));
                            System.out.println("From Email: "+ Base64.getEncoder().encodeToString(getFromEmail(from[0].toString()).getBytes()));
                            System.out.println("Subject: " +Base64.getEncoder().encodeToString( message.getSubject().getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
            }
        else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--RANDOMIP")
            && this.containsEqualsIgnoreCase(commands,"--USERNAME") && this.containsEqualsIgnoreCase(commands,"--EMAILCENSORED")
                && this.containsEqualsIgnoreCase(commands,"--COUNTRY"))
            
            {
                try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random IP: " + Base64.getEncoder().encodeToString(getRandomIP().getBytes()));
                             System.out.println("User Name: " + Base64.getEncoder().encodeToString(getUserName(getFromEmail(from[0].toString())).getBytes()));
                             System.out.println("Email Censored: " + Base64.getEncoder().encodeToString(getEmailCensored(getFromEmail(from[0].toString())).getBytes()));
                             System.out.println("Random Country: " +Base64.getEncoder().encodeToString( getRandomCountry().getBytes()));
                            System.out.println("From Name: " + Base64.getEncoder().encodeToString(getFromName(from[0].toString()).getBytes()));
                            System.out.println("From Email: "+ Base64.getEncoder().encodeToString(getFromEmail(from[0].toString()).getBytes()));
                            System.out.println("Subject: " +Base64.getEncoder().encodeToString( message.getSubject().getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
            }
        else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--RANDOMIP")
            && this.containsEqualsIgnoreCase(commands,"--USERNAME") && this.containsEqualsIgnoreCase(commands,"--EMAILCENSORED")
                && this.containsEqualsIgnoreCase(commands,"--DATE"))
            {
                try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random IP: " + Base64.getEncoder().encodeToString(getRandomIP().getBytes()));
                             System.out.println("User Name: " + Base64.getEncoder().encodeToString(getUserName(getFromEmail(from[0].toString())).getBytes()));
                             System.out.println("Email Censored: " + Base64.getEncoder().encodeToString(getEmailCensored(getFromEmail(from[0].toString())).getBytes()));
                             System.out.println("Today's Date" + Base64.getEncoder().encodeToString(getDate().getBytes()));
                            System.out.println("From Name: " + Base64.getEncoder().encodeToString(getFromName(from[0].toString()).getBytes()));
                            System.out.println("From Email: "+ Base64.getEncoder().encodeToString(getFromEmail(from[0].toString()).getBytes()));
                            System.out.println("Subject: " + Base64.getEncoder().encodeToString(message.getSubject().getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
            }
        else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--RANDOMIP")
            && this.containsEqualsIgnoreCase(commands,"--USERNAME") && this.containsEqualsIgnoreCase(commands,"--EMAILCENSORED")
                && this.containsEqualsIgnoreCase(commands,"--DATETOMORROW"))
            {
                try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random IP: " + Base64.getEncoder().encodeToString(getRandomIP().getBytes()));
                             System.out.println("User Name: " + Base64.getEncoder().encodeToString(getUserName(getFromEmail(from[0].toString())).getBytes()));
                             System.out.println("Email Censored: " + Base64.getEncoder().encodeToString(getEmailCensored(getFromEmail(from[0].toString())).getBytes()));
                             System.out.println("Date Tomorrow: " + Base64.getEncoder().encodeToString(getTomorrowDate().getBytes()));
                            System.out.println("From Name: " + Base64.getEncoder().encodeToString(getFromName(from[0].toString()).getBytes()));
                            System.out.println("From Email: "+ Base64.getEncoder().encodeToString(getFromEmail(from[0].toString()).getBytes()));
                            System.out.println("Subject: " + Base64.getEncoder().encodeToString(message.getSubject().getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
            }
        else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--RANDOMIP")
            && this.containsEqualsIgnoreCase(commands,"--USERNAME") && this.containsEqualsIgnoreCase(commands,"--EMAILCENSORED")
                && this.containsEqualsIgnoreCase(commands,"--TIME"))
            {
                try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random IP: " + Base64.getEncoder().encodeToString(getRandomIP().getBytes()));
                             System.out.println("User Name: " + Base64.getEncoder().encodeToString(getUserName(getFromEmail(from[0].toString())).getBytes()));
                             System.out.println("Email Censored: " + Base64.getEncoder().encodeToString(getEmailCensored(getFromEmail(from[0].toString())).getBytes()));
                             System.out.println("Time: " + Base64.getEncoder().encodeToString(getTime().getBytes()));
                            System.out.println("From Name: " + Base64.getEncoder().encodeToString(getFromName(from[0].toString()).getBytes()));
                            System.out.println("From Email: "+ Base64.getEncoder().encodeToString(getFromEmail(from[0].toString()).getBytes()));
                            System.out.println("Subject: " + Base64.getEncoder().encodeToString(message.getSubject().getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
            }
        else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--RANDOMIP")
            && this.containsEqualsIgnoreCase(commands,"--USERNAME") && this.containsEqualsIgnoreCase(commands,"--EMAILCENSORED")
                && this.containsEqualsIgnoreCase(commands,"--PC_OS"))
            {
                try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random IP: " + Base64.getEncoder().encodeToString(getRandomIP().getBytes()));
                             System.out.println("User Name: " +Base64.getEncoder().encodeToString( getUserName(getFromEmail(from[0].toString())).getBytes()));
                             System.out.println("Email Censored: " + Base64.getEncoder().encodeToString(getEmailCensored(getFromEmail(from[0].toString())).getBytes()));
                             System.out.println("Random PC OS: " + Base64.getEncoder().encodeToString(getRandomPCOS().getBytes()));
                            System.out.println("From Name: " + Base64.getEncoder().encodeToString(getFromName(from[0].toString()).getBytes()));
                            System.out.println("From Email: "+ Base64.getEncoder().encodeToString(getFromEmail(from[0].toString()).getBytes()));
                            System.out.println("Subject: " + Base64.getEncoder().encodeToString(message.getSubject().getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
            }
        else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--RANDOMIP")
            && this.containsEqualsIgnoreCase(commands,"--USERNAME") && this.containsEqualsIgnoreCase(commands,"--EMAILCENSORED")
                && this.containsEqualsIgnoreCase(commands,"--PC_BROWSER"))
            {
                try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random IP: " + Base64.getEncoder().encodeToString(getRandomIP().getBytes()));
                             System.out.println("User Name: " + Base64.getEncoder().encodeToString(getUserName(getFromEmail(from[0].toString())).getBytes()));
                             System.out.println("Email Censored: " + Base64.getEncoder().encodeToString(getEmailCensored(getFromEmail(from[0].toString())).getBytes()));
                             System.out.println("Random PC Browser: " +Base64.getEncoder().encodeToString( getRandomPCBrowser().getBytes()));
                            System.out.println("From Name: " + Base64.getEncoder().encodeToString(getFromName(from[0].toString()).getBytes()));
                            System.out.println("From Email: "+ Base64.getEncoder().encodeToString(getFromEmail(from[0].toString()).getBytes()));
                            System.out.println("Subject: " + Base64.getEncoder().encodeToString(message.getSubject().getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
            }
        else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--RANDOMIP")
            && this.containsEqualsIgnoreCase(commands,"--USERNAME") && this.containsEqualsIgnoreCase(commands,"--EMAILCENSORED")
                && this.containsEqualsIgnoreCase(commands,"--COUNTRYCITY"))
            {
                try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random IP: " + Base64.getEncoder().encodeToString(getRandomIP().getBytes()));
                             System.out.println("User Name: " + Base64.getEncoder().encodeToString(getUserName(getFromEmail(from[0].toString())).getBytes()));
                             System.out.println("Email Censored: " + Base64.getEncoder().encodeToString(getEmailCensored(getFromEmail(from[0].toString())).getBytes()));
                             System.out.println("Random Country City: "+ Base64.getEncoder().encodeToString(getRandomCity().getBytes()));
                            System.out.println("From Name: " + Base64.getEncoder().encodeToString(getFromName(from[0].toString()).getBytes()));
                            System.out.println("From Email: "+ Base64.getEncoder().encodeToString(getFromEmail(from[0].toString()).getBytes()));
                            System.out.println("Subject: " +Base64.getEncoder().encodeToString( message.getSubject().getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
            }
        else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--RANDOMIP")
            && this.containsEqualsIgnoreCase(commands,"--USERNAME") && this.containsEqualsIgnoreCase(commands,"--EMAILCENSORED")
                && this.containsEqualsIgnoreCase(commands,"--ANDROID_OS"))
            {
                try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random IP: " + Base64.getEncoder().encodeToString(getRandomIP().getBytes()));
                             System.out.println("User Name: " + Base64.getEncoder().encodeToString(getUserName(getFromEmail(from[0].toString())).getBytes()));
                             System.out.println("Email Censored: " + Base64.getEncoder().encodeToString(getEmailCensored(getFromEmail(from[0].toString())).getBytes()));
                             System.out.println("Random Android OS: " + Base64.getEncoder().encodeToString(getRandomAndroidOS().getBytes()));
                            System.out.println("From Name: " + Base64.getEncoder().encodeToString(getFromName(from[0].toString()).getBytes()));
                            System.out.println("From Email: "+ Base64.getEncoder().encodeToString(getFromEmail(from[0].toString()).getBytes()));
                            System.out.println("Subject: " + Base64.getEncoder().encodeToString(message.getSubject().getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
            }
        else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--RANDOMIP")
            && this.containsEqualsIgnoreCase(commands,"--USERNAME") && this.containsEqualsIgnoreCase(commands,"--EMAILCENSORED")
                && this.containsEqualsIgnoreCase(commands,"--ANDROID_BROWSER"))
            {
                try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random IP: " + Base64.getEncoder().encodeToString(getRandomIP().getBytes()));
                             System.out.println("User Name: " + Base64.getEncoder().encodeToString(getUserName(getFromEmail(from[0].toString())).getBytes()));
                             System.out.println("Email Censored: " + Base64.getEncoder().encodeToString(getEmailCensored(getFromEmail(from[0].toString())).getBytes()));
                             System.out.println("Random Android Browser: " + Base64.getEncoder().encodeToString(getRandomAndroidBrowser().getBytes()));
                            System.out.println("From Name: " + Base64.getEncoder().encodeToString(getFromName(from[0].toString()).getBytes()));
                            System.out.println("From Email: "+ Base64.getEncoder().encodeToString(getFromEmail(from[0].toString()).getBytes()));
                            System.out.println("Subject: " + Base64.getEncoder().encodeToString(message.getSubject().getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
            }
        else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--RANDOMIP")
            && this.containsEqualsIgnoreCase(commands,"--USERNAME") && this.containsEqualsIgnoreCase(commands,"--EMAILCENSORED")
                && this.containsEqualsIgnoreCase(commands,"--UA"))
            {
                try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random IP: " + Base64.getEncoder().encodeToString(getRandomIP().getBytes()));
                             System.out.println("User Name: " + Base64.getEncoder().encodeToString(getUserName(getFromEmail(from[0].toString())).getBytes()));
                             System.out.println("Email Censored: " + Base64.getEncoder().encodeToString(getEmailCensored(getFromEmail(from[0].toString())).getBytes()));
                             System.out.println("Random User Agent: " + Base64.getEncoder().encodeToString(getRandomUserAgent().getBytes()));
                            System.out.println("From Name: " + Base64.getEncoder().encodeToString(getFromName(from[0].toString()).getBytes()));
                            System.out.println("From Email: "+ Base64.getEncoder().encodeToString(getFromEmail(from[0].toString()).getBytes()));
                            System.out.println("Subject: " + Base64.getEncoder().encodeToString(message.getSubject().getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
            }
        else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--RANDOMIP")
            && this.containsEqualsIgnoreCase(commands,"--USERNAME") && this.containsEqualsIgnoreCase(commands,"--EMAILCENSORED")
                && this.containsEqualsIgnoreCase(commands,"--APPLEAPPS"))
            {
                try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random IP: " + Base64.getEncoder().encodeToString(getRandomIP().getBytes()));
                             System.out.println("User Name: " + Base64.getEncoder().encodeToString(getUserName(getFromEmail(from[0].toString())).getBytes()));
                             System.out.println("Email Censored: " + Base64.getEncoder().encodeToString(getEmailCensored(getFromEmail(from[0].toString())).getBytes()));
                             System.out.println("Random Apple Apps: " + Base64.getEncoder().encodeToString(getRandomAppleApps().getBytes()));
                            System.out.println("From Name: " + Base64.getEncoder().encodeToString(getFromName(from[0].toString()).getBytes()));
                            System.out.println("From Email: "+ Base64.getEncoder().encodeToString(getFromEmail(from[0].toString()).getBytes()));
                            System.out.println("Subject: " + Base64.getEncoder().encodeToString(message.getSubject().getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
            }
        else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--RANDOMIP")
            && this.containsEqualsIgnoreCase(commands,"--USERNAME") && this.containsEqualsIgnoreCase(commands,"--EMAILCENSORED")
                && this.containsEqualsIgnoreCase(commands,"--APPLE_PC"))
            {
                try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random IP: " + Base64.getEncoder().encodeToString(getRandomIP().getBytes()));
                             System.out.println("User Name: " + Base64.getEncoder().encodeToString(getUserName(getFromEmail(from[0].toString())).getBytes()));
                             System.out.println("Email Censored: " + Base64.getEncoder().encodeToString(getEmailCensored(getFromEmail(from[0].toString())).getBytes()));
                             System.out.println("Random Apple PC: " + Base64.getEncoder().encodeToString(getRandomAppleLaptops().getBytes()));
                            System.out.println("From Name: " + Base64.getEncoder().encodeToString(getFromName(from[0].toString()).getBytes()));
                            System.out.println("From Email: "+ Base64.getEncoder().encodeToString(getFromEmail(from[0].toString()).getBytes()));
                            System.out.println("Subject: " + Base64.getEncoder().encodeToString(message.getSubject().getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
            }
        else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--RANDOMIP")
            && this.containsEqualsIgnoreCase(commands,"--USERNAME") && this.containsEqualsIgnoreCase(commands,"--EMAILCENSORED")
                && this.containsEqualsIgnoreCase(commands,"--APPLE_PHONES"))
            {
                try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random IP: " + Base64.getEncoder().encodeToString(getRandomIP().getBytes()));
                             System.out.println("User Name: " + Base64.getEncoder().encodeToString(getUserName(getFromEmail(from[0].toString())).getBytes()));
                             System.out.println("Email Censored: " + Base64.getEncoder().encodeToString(getEmailCensored(getFromEmail(from[0].toString())).getBytes()));
                             System.out.println("Radom Apple Phone: " + Base64.getEncoder().encodeToString(getRandomApplePhones().getBytes()));
                            System.out.println("From Name: " + Base64.getEncoder().encodeToString(getFromName(from[0].toString()).getBytes()));
                            System.out.println("From Email: "+ Base64.getEncoder().encodeToString(getFromEmail(from[0].toString()).getBytes()));
                            System.out.println("Subject: " + Base64.getEncoder().encodeToString(message.getSubject().getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
            }
        else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--RANDOMIP")
            && this.containsEqualsIgnoreCase(commands,"--USERNAME") && this.containsEqualsIgnoreCase(commands,"--EMAILCENSORED")
                && this.containsEqualsIgnoreCase(commands,"--UNIVERSAL_BROWSER"))
            {
                try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random IP: " + Base64.getEncoder().encodeToString(getRandomIP().getBytes()));
                             System.out.println("User Name: " +Base64.getEncoder().encodeToString( getUserName(getFromEmail(from[0].toString())).getBytes()));
                             System.out.println("Email Censored: " + Base64.getEncoder().encodeToString(getEmailCensored(getFromEmail(from[0].toString())).getBytes()));
                             System.out.println("Random Universal Browser: " + Base64.getEncoder().encodeToString(getRandomUniversalBrowser().getBytes()));
                            System.out.println("From Name: " + Base64.getEncoder().encodeToString(getFromName(from[0].toString()).getBytes()));
                            System.out.println("From Email: "+ Base64.getEncoder().encodeToString(getFromEmail(from[0].toString()).getBytes()));
                            System.out.println("Subject: " + Base64.getEncoder().encodeToString(message.getSubject().getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
            }
        else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--RANDOMIP")
            && this.containsEqualsIgnoreCase(commands,"--USERNAME") && this.containsEqualsIgnoreCase(commands,"--EMAILCENSORED")
                && this.containsEqualsIgnoreCase(commands,"--RANDSTRING"))
            {
                try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            if(this.containsEquals(commands,"--randstring"))
                                System.out.println("Random String in lowercase: " + Base64.getEncoder().encodeToString(getRandomStringLowerCase().getBytes())); 
                            else if(this.containsEquals(commands,"--RANDSTRING"))
                                System.out.println("Random String in UpperCase : " + Base64.getEncoder().encodeToString(getRandomStringUpperCase().getBytes())); 
                            


                            
                            System.out.println("Random IP: " + Base64.getEncoder().encodeToString(getRandomIP().getBytes()));
                             System.out.println("User Name: " + Base64.getEncoder().encodeToString(getUserName(getFromEmail(from[0].toString())).getBytes()));
                             System.out.println("Email Censored: " + Base64.getEncoder().encodeToString(getEmailCensored(getFromEmail(from[0].toString())).getBytes()));
                            System.out.println("From Name: " + Base64.getEncoder().encodeToString(getFromName(from[0].toString()).getBytes()));
                            System.out.println("From Email: "+ Base64.getEncoder().encodeToString(getFromEmail(from[0].toString()).getBytes()));
                            System.out.println("Subject: " + Base64.getEncoder().encodeToString(message.getSubject().getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
            }
        else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--RANDOMIP")
            && this.containsEqualsIgnoreCase(commands,"--USERNAME") && this.containsEqualsIgnoreCase(commands,"--EMAILCENSORED")
                && this.containsEqualsIgnoreCase(commands,"--NUMBER"))
            {
                try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            if(this.containsStartWith(commands,"--NUMBER1"))
                                System.out.println("Random Number: " + (Base64.getEncoder().encodeToString(getNumbers(1).getBytes()))); 
                            else if(this.containsStartWith(commands,"--NUMBER2"))
                                System.out.println("Random Number: " + (Base64.getEncoder().encodeToString(getNumbers(2).getBytes())));
                            else if(this.containsStartWith(commands,"--NUMBER3"))
                                System.out.println("Random Number: " + (Base64.getEncoder().encodeToString(getNumbers(3).getBytes())));
                            else if(this.containsStartWith(commands,"--NUMBER4"))
                                System.out.println("Random Number: " + Base64.getEncoder().encodeToString(getNumbers(4).getBytes()));
                            else if(this.containsStartWith(commands,"--NUMBER5"))
                                System.out.println("Random Number: " + Base64.getEncoder().encodeToString(getNumbers(5).getBytes()));
                            else if(this.containsStartWith(commands,"--NUMBER6"))
                                System.out.println("Random Number: " + Base64.getEncoder().encodeToString(getNumbers(6).getBytes()));
                            else if(this.containsStartWith(commands,"--NUMBER7"))
                                System.out.println("Random Number: " + Base64.getEncoder().encodeToString(getNumbers(7).getBytes()));
                            else if(this.containsStartWith(commands,"--NUMBER8"))
                                System.out.println("Random Number: " + Base64.getEncoder().encodeToString(getNumbers(8).getBytes()));
                            else if(this.containsStartWith(commands,"--NUMBER9"))
                                System.out.println("Random Number: " + Base64.getEncoder().encodeToString(getNumbers(9).getBytes()));
                            else if(this.containsStartWith(commands,"--NUMBER10"))
                                System.out.println("Random Number: " + Base64.getEncoder().encodeToString(getNumbers(10).getBytes()));
                            
                            
                            System.out.println("Random IP: " + Base64.getEncoder().encodeToString(getRandomIP().getBytes()));
                             System.out.println("User Name: " + Base64.getEncoder().encodeToString(getUserName(getFromEmail(from[0].toString())).getBytes()));
                             System.out.println("Email Censored: " + Base64.getEncoder().encodeToString(getEmailCensored(getFromEmail(from[0].toString())).getBytes()));
                            System.out.println("From Name: " + Base64.getEncoder().encodeToString(getFromName(from[0].toString()).getBytes()));
                            System.out.println("From Email: "+ Base64.getEncoder().encodeToString(getFromEmail(from[0].toString()).getBytes()));
                            System.out.println("Subject: " + Base64.getEncoder().encodeToString(message.getSubject().getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
            }
        else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--RANDOMIP")
            && this.containsEqualsIgnoreCase(commands,"--USERNAME") && this.containsEqualsIgnoreCase(commands,"--EMAILCENSORED")
                && this.containsStartWith(commands,"--CHAR"))
            {
                try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            

                            if(this.containsStartWith(commands,"--CHAR1"))
                                System.out.println("Random Characters in Upper Case: " + Base64.getEncoder().encodeToString(getCharUpperCase(1).getBytes())); 
                            else if(this.containsStartWith(commands,"--CHAR2"))
                                System.out.println("Random Characters in Upper Case: " +Base64.getEncoder().encodeToString( getCharUpperCase(2).getBytes()));
                            else if(this.containsStartWith(commands,"--CHAR3"))
                                System.out.println("Random Characters in Upper Case: " + Base64.getEncoder().encodeToString(getCharUpperCase(3).getBytes())); 
                            else if(this.containsStartWith(commands,"--CHAR4"))
                                System.out.println("Random Characters in Upper Case: " + Base64.getEncoder().encodeToString(getCharUpperCase(4).getBytes())); 
                            else if(this.containsStartWith(commands,"--CHAR5"))
                                System.out.println("Random Characters in Upper Case: " + Base64.getEncoder().encodeToString(getCharUpperCase(5).getBytes())); 
                            else if(this.containsStartWith(commands,"--CHAR6"))
                                System.out.println("Random Characters in Upper Case: " + Base64.getEncoder().encodeToString(getCharUpperCase(6).getBytes())); 
                            else if(this.containsStartWith(commands,"--CHAR7"))
                                System.out.println("Random Characters in Upper Case: " + Base64.getEncoder().encodeToString(getCharUpperCase(7).getBytes())); 
                            else if(this.containsStartWith(commands,"--CHAR8"))
                                System.out.println("Random Characters in Upper Case: " + Base64.getEncoder().encodeToString(getCharUpperCase(8).getBytes())); 
                            else if(this.containsStartWith(commands,"--CHAR9"))
                                System.out.println("Random Characters in Upper Case: " + Base64.getEncoder().encodeToString(getCharUpperCase(9).getBytes())); 
                            else if(this.containsStartWith(commands,"--CHAR10"))
                                System.out.println("Random Characters in Upper Case: " + Base64.getEncoder().encodeToString(getCharUpperCase(10).getBytes()));
                            else if(this.containsStartWith(commands,"--char1"))
                                System.out.println("Random Characters in Lower Case: " + Base64.getEncoder().encodeToString(getCharLowerCase(1).getBytes())); 
                            else if(this.containsStartWith(commands,"--char2"))
                                System.out.println("Random Characters in Lower Case: " + Base64.getEncoder().encodeToString(getCharLowerCase(2).getBytes())); 
                            else if(this.containsStartWith(commands,"--char3"))
                                System.out.println("Random Characters in Lower Case: " + Base64.getEncoder().encodeToString(getCharLowerCase(3).getBytes())); 
                            else if(this.containsStartWith(commands,"--char4"))
                                System.out.println("Random Characters in Lower Case: " + Base64.getEncoder().encodeToString(getCharLowerCase(4).getBytes())); 
                            else if(this.containsStartWith(commands,"--char5"))
                                System.out.println("Random Characters in Lower Case: " + Base64.getEncoder().encodeToString(getCharLowerCase(5).getBytes())); 
                            else if(this.containsStartWith(commands,"--char6"))
                                System.out.println("Random Characters in Lower Case: " + Base64.getEncoder().encodeToString(getCharLowerCase(6).getBytes())); 
                            else if(this.containsStartWith(commands,"--char7"))
                                System.out.println("Random Characters in Lower Case: " + Base64.getEncoder().encodeToString(getCharLowerCase(7).getBytes())); 
                            else if(this.containsStartWith(commands,"--char8"))
                                System.out.println("Random Characters in Lower Case: " + Base64.getEncoder().encodeToString(getCharLowerCase(8).getBytes())); 
                            else if(this.containsStartWith(commands,"--char9"))
                                System.out.println("Random Characters in Lower Case: " + Base64.getEncoder().encodeToString(getCharLowerCase(9).getBytes())); 
                            else if(this.containsStartWith(commands,"--char10"))
                                System.out.println("Random Characters in Lower Case: " + Base64.getEncoder().encodeToString(getCharLowerCase(10).getBytes())); 
                            
                            

                            
                            
                            System.out.println("Random IP: " + Base64.getEncoder().encodeToString(getRandomIP().getBytes()));
                             System.out.println("User Name: " + Base64.getEncoder().encodeToString(getUserName(getFromEmail(from[0].toString())).getBytes()));
                             System.out.println("Email Censored: " + Base64.getEncoder().encodeToString(getEmailCensored(getFromEmail(from[0].toString())).getBytes()));
                            System.out.println("From Name: " + Base64.getEncoder().encodeToString(getFromName(from[0].toString()).getBytes()));
                            System.out.println("From Email: "+ Base64.getEncoder().encodeToString(getFromEmail(from[0].toString()).getBytes()));
                            System.out.println("Subject: " + Base64.getEncoder().encodeToString(message.getSubject().getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
            }
            else
            {
                    System.out.println("Invalid Syntax/Command!");
            }
        
    }
     
     //Test Sucessful
    public void switchCase10(String[] commands)
    {
        if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--RANDOMIP")
            && this.containsEqualsIgnoreCase(commands,"--USERNAME") && this.containsEqualsIgnoreCase(commands,"--EMAILCENSORED")
                && this.containsEqualsIgnoreCase(commands,"--DOMAINFULL") && this.containsEqualsIgnoreCase(commands,"--DOMAINNAME"))
            {
                try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0 ; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random IP: " + getRandomIP());
                             System.out.println("User Name: " + getUserName(getFromEmail(from[0].toString())));
                             System.out.println("Email Censored: " + getEmailCensored(getFromEmail(from[0].toString())));
                             System.out.println("Domain Full: " + getDomainFull(getFromEmail(from[0].toString())));
                             System.out.println("Domain Name: " + getDomainName(getFromEmail(from[0].toString())));
                            System.out.println("From Name: " + getFromName(from[0].toString()));
                            System.out.println("From Email: "+ getFromEmail(from[0].toString()));
                            System.out.println("Subject: " + message.getSubject()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
            }
        else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--RANDOMIP")
            && this.containsEqualsIgnoreCase(commands,"--USERNAME") && this.containsEqualsIgnoreCase(commands,"--EMAILCENSORED")
                && this.containsEqualsIgnoreCase(commands,"--DOMAINFULL") && this.containsEqualsIgnoreCase(commands,"--COUNTRY"))
            {
                try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0 ; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random IP: " + getRandomIP());
                             System.out.println("User Name: " + getUserName(getFromEmail(from[0].toString())));
                             System.out.println("Email Censored: " + getEmailCensored(getFromEmail(from[0].toString())));
                             System.out.println("Domain Full: " + getDomainFull(getFromEmail(from[0].toString())));
                             System.out.println("Random Country: " + getRandomCountry());
                            System.out.println("From Name: " + getFromName(from[0].toString()));
                            System.out.println("From Email: "+ getFromEmail(from[0].toString()));
                            System.out.println("Subject: " + message.getSubject()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
            }
        else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--RANDOMIP")
            && this.containsEqualsIgnoreCase(commands,"--USERNAME") && this.containsEqualsIgnoreCase(commands,"--EMAILCENSORED")
                && this.containsEqualsIgnoreCase(commands,"--DOMAINFULL") && this.containsEqualsIgnoreCase(commands,"--DATE"))
            {
                try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0 ; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random IP: " + getRandomIP());
                             System.out.println("User Name: " + getUserName(getFromEmail(from[0].toString())));
                             System.out.println("Email Censored: " + getEmailCensored(getFromEmail(from[0].toString())));
                             System.out.println("Domain Full: " + getDomainFull(getFromEmail(from[0].toString())));
                             System.out.println("Date: " + getDate());
                            System.out.println("From Name: " + getFromName(from[0].toString()));
                            System.out.println("From Email: "+ getFromEmail(from[0].toString()));
                            System.out.println("Subject: " + message.getSubject()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
            }
        
        else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--RANDOMIP")
            && this.containsEqualsIgnoreCase(commands,"--USERNAME") && this.containsEqualsIgnoreCase(commands,"--EMAILCENSORED")
                && this.containsEqualsIgnoreCase(commands,"--DOMAINFULL") && this.containsEqualsIgnoreCase(commands,"--DATETOMORROW"))
            {
                try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0 ; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random IP: " + getRandomIP());
                             System.out.println("User Name: " + getUserName(getFromEmail(from[0].toString())));
                             System.out.println("Email Censored: " + getEmailCensored(getFromEmail(from[0].toString())));
                             System.out.println("Domain Full: " + getDomainFull(getFromEmail(from[0].toString())));
                             System.out.println("Date Tomorrow: " + getTomorrowDate());
                            System.out.println("From Name: " + getFromName(from[0].toString()));
                            System.out.println("From Email: "+ getFromEmail(from[0].toString()));
                            System.out.println("Subject: " + message.getSubject()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
            }
        
        else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--RANDOMIP")
            && this.containsEqualsIgnoreCase(commands,"--USERNAME") && this.containsEqualsIgnoreCase(commands,"--EMAILCENSORED")
                && this.containsEqualsIgnoreCase(commands,"--DOMAINFULL") && this.containsEqualsIgnoreCase(commands,"--PC_OS"))
            {
                try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0 ; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random IP: " + getRandomIP());
                             System.out.println("User Name: " + getUserName(getFromEmail(from[0].toString())));
                             System.out.println("Email Censored: " + getEmailCensored(getFromEmail(from[0].toString())));
                             System.out.println("Domain Full: " + getDomainFull(getFromEmail(from[0].toString())));
                             System.out.println("Random PC OS: " + getRandomPCOS());
                            System.out.println("From Name: " + getFromName(from[0].toString()));
                            System.out.println("From Email: "+ getFromEmail(from[0].toString()));
                            System.out.println("Subject: " + message.getSubject()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
            }
        
        else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--RANDOMIP")
            && this.containsEqualsIgnoreCase(commands,"--USERNAME") && this.containsEqualsIgnoreCase(commands,"--EMAILCENSORED")
                && this.containsEqualsIgnoreCase(commands,"--DOMAINFULL") && this.containsEqualsIgnoreCase(commands,"--PC_BROWSER"))
            {
                try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0 ; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random IP: " + getRandomIP());
                             System.out.println("User Name: " + getUserName(getFromEmail(from[0].toString())));
                             System.out.println("Email Censored: " + getEmailCensored(getFromEmail(from[0].toString())));
                             System.out.println("Domain Full: " + getDomainFull(getFromEmail(from[0].toString())));
                             System.out.println("Random PC Browser: " + getRandomPCBrowser());
                            System.out.println("From Name: " + getFromName(from[0].toString()));
                            System.out.println("From Email: "+ getFromEmail(from[0].toString()));
                            System.out.println("Subject: " + message.getSubject()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
            }
        else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--RANDOMIP")
            && this.containsEqualsIgnoreCase(commands,"--USERNAME") && this.containsEqualsIgnoreCase(commands,"--EMAILCENSORED")
                && this.containsEqualsIgnoreCase(commands,"--DOMAINFULL") && this.containsEqualsIgnoreCase(commands,"--COUTRYCITY"))
            {
                try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0 ; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random IP: " + getRandomIP());
                             System.out.println("User Name: " + getUserName(getFromEmail(from[0].toString())));
                             System.out.println("Email Censored: " + getEmailCensored(getFromEmail(from[0].toString())));
                             System.out.println("Domain Full: " + getDomainFull(getFromEmail(from[0].toString())));
                             //System.out.println("Domain Full: " + getDomainFull(getFromEmail(from[0].toString())));
                            System.out.println("From Name: " + getFromName(from[0].toString()));
                            System.out.println("From Email: "+ getFromEmail(from[0].toString()));
                            System.out.println("Subject: " + message.getSubject()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
            }
        else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--RANDOMIP")
            && this.containsEqualsIgnoreCase(commands,"--USERNAME") && this.containsEqualsIgnoreCase(commands,"--EMAILCENSORED")
                && this.containsEqualsIgnoreCase(commands,"--DOMAINFULL") && this.containsEqualsIgnoreCase(commands,"--ANDROID_OS"))
            {
                try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0 ; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random IP: " + getRandomIP());
                             System.out.println("User Name: " + getUserName(getFromEmail(from[0].toString())));
                             System.out.println("Email Censored: " + getEmailCensored(getFromEmail(from[0].toString())));
                             System.out.println("Domain Full: " + getDomainFull(getFromEmail(from[0].toString())));
                             System.out.println("Random Android OS: " + getRandomAndroidOS());
                            System.out.println("From Name: " + getFromName(from[0].toString()));
                            System.out.println("From Email: "+ getFromEmail(from[0].toString()));
                            System.out.println("Subject: " + message.getSubject()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
            }
        else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--RANDOMIP")
            && this.containsEqualsIgnoreCase(commands,"--USERNAME") && this.containsEqualsIgnoreCase(commands,"--EMAILCENSORED")
                && this.containsEqualsIgnoreCase(commands,"--DOMAINFULL") && this.containsEqualsIgnoreCase(commands,"--ANDROID_BROWSER"))
            {
                try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0 ; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random IP: " + getRandomIP());
                             System.out.println("User Name: " + getUserName(getFromEmail(from[0].toString())));
                             System.out.println("Email Censored: " + getEmailCensored(getFromEmail(from[0].toString())));
                             System.out.println("Domain Full: " + getDomainFull(getFromEmail(from[0].toString())));
                             System.out.println("Rabdin Android Browser: " + getRandomAndroidBrowser());
                            System.out.println("From Name: " + getFromName(from[0].toString()));
                            System.out.println("From Email: "+ getFromEmail(from[0].toString()));
                            System.out.println("Subject: " + message.getSubject()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
            }
        
        else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--RANDOMIP")
            && this.containsEqualsIgnoreCase(commands,"--USERNAME") && this.containsEqualsIgnoreCase(commands,"--EMAILCENSORED")
                && this.containsEqualsIgnoreCase(commands,"--DOMAINFULL") && this.containsEqualsIgnoreCase(commands,"--UA"))
            {
                try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0 ; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random IP: " + getRandomIP());
                             System.out.println("User Name: " + getUserName(getFromEmail(from[0].toString())));
                             System.out.println("Email Censored: " + getEmailCensored(getFromEmail(from[0].toString())));
                             System.out.println("Domain Full: " + getDomainFull(getFromEmail(from[0].toString())));
                             System.out.println("Random User Agent: " + getRandomUserAgent());
                            System.out.println("From Name: " + getFromName(from[0].toString()));
                            System.out.println("From Email: "+ getFromEmail(from[0].toString()));
                            System.out.println("Subject: " + message.getSubject()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
            }
        else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--RANDOMIP")
            && this.containsEqualsIgnoreCase(commands,"--USERNAME") && this.containsEqualsIgnoreCase(commands,"--EMAILCENSORED")
                && this.containsEqualsIgnoreCase(commands,"--DOMAINFULL") && this.containsEqualsIgnoreCase(commands,"--APPLEAPPS"))
            {
                try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0 ; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random IP: " + getRandomIP());
                             System.out.println("User Name: " + getUserName(getFromEmail(from[0].toString())));
                             System.out.println("Email Censored: " + getEmailCensored(getFromEmail(from[0].toString())));
                             System.out.println("Domain Full: " + getDomainFull(getFromEmail(from[0].toString())));
                             System.out.println("Random Apple App: " /*+ getRandomAppleApps()*/);
                            System.out.println("From Name: " + getFromName(from[0].toString()));
                            System.out.println("From Email: "+ getFromEmail(from[0].toString()));
                            System.out.println("Subject: " + message.getSubject()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
            }
        else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--RANDOMIP")
            && this.containsEqualsIgnoreCase(commands,"--USERNAME") && this.containsEqualsIgnoreCase(commands,"--EMAILCENSORED")
                && this.containsEqualsIgnoreCase(commands,"--DOMAINFULL") && this.containsEqualsIgnoreCase(commands,"--APPLEPHONES"))
            {
                try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0 ; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random IP: " + getRandomIP());
                             System.out.println("User Name: " + getUserName(getFromEmail(from[0].toString())));
                             System.out.println("Email Censored: " + getEmailCensored(getFromEmail(from[0].toString())));
                             System.out.println("Domain Full: " + getDomainFull(getFromEmail(from[0].toString())));
                             System.out.println("Random Apple Phone: "/* + getRandomApplePhone()*/);
                            System.out.println("From Name: " + getFromName(from[0].toString()));
                            System.out.println("From Email: "+ getFromEmail(from[0].toString()));
                            System.out.println("Subject: " + message.getSubject()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
            }
        else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--RANDOMIP")
            && this.containsEqualsIgnoreCase(commands,"--USERNAME") && this.containsEqualsIgnoreCase(commands,"--EMAILCENSORED")
                && this.containsEqualsIgnoreCase(commands,"--DOMAINFULL") && this.containsEqualsIgnoreCase(commands,"--UNIVERSAL_BROWSER"))
            {
                try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0 ; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random IP: " + getRandomIP());
                             System.out.println("User Name: " + getUserName(getFromEmail(from[0].toString())));
                             System.out.println("Email Censored: " + getEmailCensored(getFromEmail(from[0].toString())));
                             System.out.println("Domain Full: " + getDomainFull(getFromEmail(from[0].toString())));
                             System.out.println("Random Universal Browser: " + getRandomUniversalBrowser());
                            System.out.println("From Name: " + getFromName(from[0].toString()));
                            System.out.println("From Email: "+ getFromEmail(from[0].toString()));
                            System.out.println("Subject: " + message.getSubject()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
            }
        else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--RANDOMIP")
            && this.containsEqualsIgnoreCase(commands,"--USERNAME") && this.containsEqualsIgnoreCase(commands,"--EMAILCENSORED")
                && this.containsEqualsIgnoreCase(commands,"--DOMAINFULL") && this.containsEqualsIgnoreCase(commands,"--RANDSTRING"))
            {
                try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0 ; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            if(this.containsEquals(commands,"--randstring"))
                                System.out.println("Random String in lowercase: " + getRandomStringLowerCase()); 
                            else if(this.containsEquals(commands,"--RANDSTRING"))
                                System.out.println("Random String in UpperCase : " + getRandomStringUpperCase());

                            System.out.println("Random IP: " + getRandomIP());
                             System.out.println("User Name: " + getUserName(getFromEmail(from[0].toString())));
                             System.out.println("Email Censored: " + getEmailCensored(getFromEmail(from[0].toString())));
                             System.out.println("Domain Full: " + getDomainFull(getFromEmail(from[0].toString())));
                            System.out.println("From Name: " + getFromName(from[0].toString()));
                            System.out.println("From Email: "+ getFromEmail(from[0].toString()));
                            System.out.println("Subject: " + message.getSubject()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
            }
        else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--RANDOMIP")
            && this.containsEqualsIgnoreCase(commands,"--USERNAME") && this.containsEqualsIgnoreCase(commands,"--EMAILCENSORED")
                && this.containsEqualsIgnoreCase(commands,"--DOMAINFULL") && this.containsStartWith(commands,"--NUMBER"))
            {
                try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0 ; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            
                            if(this.containsStartWith(commands,"--NUMBER1"))
                                System.out.println("Random Number: " + getNumbers(1)); 
                            else if(this.containsStartWith(commands,"--NUMBER2"))
                                System.out.println("Random Number: " + getNumbers(2));
                            else if(this.containsStartWith(commands,"--NUMBER3"))
                                System.out.println("Random Number: " + getNumbers(3));
                            else if(this.containsStartWith(commands,"--NUMBER4"))
                                System.out.println("Random Number: " + getNumbers(4));
                            else if(this.containsStartWith(commands,"--NUMBER5"))
                                System.out.println("Random Number: " + getNumbers(5));
                            else if(this.containsStartWith(commands,"--NUMBER6"))
                                System.out.println("Random Number: " + getNumbers(6));
                            else if(this.containsStartWith(commands,"--NUMBER7"))
                                System.out.println("Random Number: " + getNumbers(7));
                            else if(this.containsStartWith(commands,"--NUMBER8"))
                                System.out.println("Random Number: " + getNumbers(8));
                            else if(this.containsStartWith(commands,"--NUMBER9"))
                                System.out.println("Random Number: " + getNumbers(9));
                            else if(this.containsStartWith(commands,"--NUMBER10"))
                                System.out.println("Random Number: " + getNumbers(10));
                            
                            System.out.println("Random IP: " + getRandomIP());
                             System.out.println("User Name: " + getUserName(getFromEmail(from[0].toString())));
                             System.out.println("Email Censored: " + getEmailCensored(getFromEmail(from[0].toString())));
                             System.out.println("Domain Full: " + getDomainFull(getFromEmail(from[0].toString())));
                            System.out.println("From Name: " + getFromName(from[0].toString()));
                            System.out.println("From Email: "+ getFromEmail(from[0].toString()));
                            System.out.println("Subject: " + message.getSubject()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
            }
        else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--RANDOMIP")
            && this.containsEqualsIgnoreCase(commands,"--USERNAME") && this.containsEqualsIgnoreCase(commands,"--EMAILCENSORED")
                && this.containsEqualsIgnoreCase(commands,"--DOMAINFULL") && this.containsStartWith(commands,"--CHAR"))
            {
                try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0 ; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate());
                            
                            if(this.containsStartWith(commands,"--CHAR1"))
                                System.out.println("Random Characters in Upper Case: " + getCharUpperCase(1)); 
                            else if(this.containsStartWith(commands,"--CHAR2"))
                                System.out.println("Random Characters in Upper Case: " + getCharUpperCase(2));
                            else if(this.containsStartWith(commands,"--CHAR3"))
                                System.out.println("Random Characters in Upper Case: " + getCharUpperCase(3)); 
                            else if(this.containsStartWith(commands,"--CHAR4"))
                                System.out.println("Random Characters in Upper Case: " + getCharUpperCase(4)); 
                            else if(this.containsStartWith(commands,"--CHAR5"))
                                System.out.println("Random Characters in Upper Case: " + getCharUpperCase(5)); 
                            else if(this.containsStartWith(commands,"--CHAR6"))
                                System.out.println("Random Characters in Upper Case: " + getCharUpperCase(6)); 
                            else if(this.containsStartWith(commands,"--CHAR7"))
                                System.out.println("Random Characters in Upper Case: " + getCharUpperCase(7)); 
                            else if(this.containsStartWith(commands,"--CHAR8"))
                                System.out.println("Random Characters in Upper Case: " + getCharUpperCase(8)); 
                            else if(this.containsStartWith(commands,"--CHAR9"))
                                System.out.println("Random Characters in Upper Case: " + getCharUpperCase(9)); 
                            else if(this.containsStartWith(commands,"--CHAR10"))
                                System.out.println("Random Characters in Upper Case: " + getCharUpperCase(10));
                            else if(this.containsStartWith(commands,"--char1"))
                                System.out.println("Random Characters in Lower Case: " + getCharLowerCase(1)); 
                            else if(this.containsStartWith(commands,"--char2"))
                                System.out.println("Random Characters in Lower Case: " + getCharLowerCase(2)); 
                            else if(this.containsStartWith(commands,"--char3"))
                                System.out.println("Random Characters in Lower Case: " + getCharLowerCase(3)); 
                            else if(this.containsStartWith(commands,"--char4"))
                                System.out.println("Random Characters in Lower Case: " + getCharLowerCase(4)); 
                            else if(this.containsStartWith(commands,"--char5"))
                                System.out.println("Random Characters in Lower Case: " + getCharLowerCase(5)); 
                            else if(this.containsStartWith(commands,"--char6"))
                                System.out.println("Random Characters in Lower Case: " + getCharLowerCase(6)); 
                            else if(this.containsStartWith(commands,"--char7"))
                                System.out.println("Random Characters in Lower Case: " + getCharLowerCase(7)); 
                            else if(this.containsStartWith(commands,"--char8"))
                                System.out.println("Random Characters in Lower Case: " + getCharLowerCase(8)); 
                            else if(this.containsStartWith(commands,"--char9"))
                                System.out.println("Random Characters in Lower Case: " + getCharLowerCase(9)); 
                            else if(this.containsStartWith(commands,"--char10"))
                                System.out.println("Random Characters in Lower Case: " + getCharLowerCase(10));



                            
                            System.out.println("Random IP: " + getRandomIP());
                             System.out.println("User Name: " + getUserName(getFromEmail(from[0].toString())));
                             System.out.println("Email Censored: " + getEmailCensored(getFromEmail(from[0].toString())));
                             System.out.println("Domain Full: " + getDomainFull(getFromEmail(from[0].toString())));
                            System.out.println("From Name: " + getFromName(from[0].toString()));
                            System.out.println("From Email: "+ getFromEmail(from[0].toString()));
                            System.out.println("Subject: " + message.getSubject()); 
                            System.out.println("Email :"); 
                            System.out.println(processMessageBody(message)); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
            }
        
        
        
        //EMAIL64
        
        else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--RANDOMIP")
            && this.containsEqualsIgnoreCase(commands,"--USERNAME") && this.containsEqualsIgnoreCase(commands,"--EMAILCENSORED")
                && this.containsEqualsIgnoreCase(commands,"--DOMAINFULL") && this.containsEqualsIgnoreCase(commands,"--DOMAINNAME"))
            {
                try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random IP: " + Base64.getEncoder().encodeToString(getRandomIP().getBytes()));
                             System.out.println("User Name: " + Base64.getEncoder().encodeToString(getUserName(getFromEmail(from[0].toString())).getBytes()));
                             System.out.println("Email Censored: " + Base64.getEncoder().encodeToString(getEmailCensored(getFromEmail(from[0].toString())).getBytes()));
                             System.out.println("Domain Full: " + Base64.getEncoder().encodeToString(getDomainFull(getFromEmail(from[0].toString())).getBytes()));
                             System.out.println("Domain Name: " + Base64.getEncoder().encodeToString(getDomainName(getFromEmail(from[0].toString())).getBytes()));
                            System.out.println("From Name: " + Base64.getEncoder().encodeToString(getFromName(from[0].toString()).getBytes()));
                            System.out.println("From Email: "+ Base64.getEncoder().encodeToString(getFromEmail(from[0].toString()).getBytes()));
                            System.out.println("Subject: " + Base64.getEncoder().encodeToString(message.getSubject().getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
            }
        else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--RANDOMIP")
            && this.containsEqualsIgnoreCase(commands,"--USERNAME") && this.containsEqualsIgnoreCase(commands,"--EMAILCENSORED")
                && this.containsEqualsIgnoreCase(commands,"--DOMAINFULL") && this.containsEqualsIgnoreCase(commands,"--COUNTRY"))
            {
                try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random IP: " + Base64.getEncoder().encodeToString(getRandomIP().getBytes()));
                             System.out.println("User Name: " + Base64.getEncoder().encodeToString(getUserName(getFromEmail(from[0].toString())).getBytes()));
                             System.out.println("Email Censored: " + Base64.getEncoder().encodeToString(getEmailCensored(getFromEmail(from[0].toString())).getBytes()));
                             System.out.println("Domain Full: " + Base64.getEncoder().encodeToString(getDomainFull(getFromEmail(from[0].toString())).getBytes()));
                             System.out.println("Random Country: " + Base64.getEncoder().encodeToString(getRandomCountry().getBytes()));
                            System.out.println("From Name: " + Base64.getEncoder().encodeToString(getFromName(from[0].toString()).getBytes()));
                            System.out.println("From Email: "+ Base64.getEncoder().encodeToString(getFromEmail(from[0].toString()).getBytes()));
                            System.out.println("Subject: " + Base64.getEncoder().encodeToString(message.getSubject().getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
            }
        else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--RANDOMIP")
            && this.containsEqualsIgnoreCase(commands,"--USERNAME") && this.containsEqualsIgnoreCase(commands,"--EMAILCENSORED")
                && this.containsEqualsIgnoreCase(commands,"--DOMAINFULL") && this.containsEqualsIgnoreCase(commands,"--DATE"))
            {
                try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random IP: " + Base64.getEncoder().encodeToString(getRandomIP().getBytes()));
                             System.out.println("User Name: " + Base64.getEncoder().encodeToString(getUserName(getFromEmail(from[0].toString())).getBytes()));
                             System.out.println("Email Censored: " + Base64.getEncoder().encodeToString(getEmailCensored(getFromEmail(from[0].toString())).getBytes()));
                             System.out.println("Domain Full: " + Base64.getEncoder().encodeToString(getDomainFull(getFromEmail(from[0].toString())).getBytes()));
                             System.out.println("Date: " + Base64.getEncoder().encodeToString(getDate().getBytes()));
                            System.out.println("From Name: " + Base64.getEncoder().encodeToString(getFromName(from[0].toString()).getBytes()));
                            System.out.println("From Email: "+ Base64.getEncoder().encodeToString(getFromEmail(from[0].toString()).getBytes()));
                            System.out.println("Subject: " +Base64.getEncoder().encodeToString( message.getSubject().getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
            }
        
        else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--RANDOMIP")
            && this.containsEqualsIgnoreCase(commands,"--USERNAME") && this.containsEqualsIgnoreCase(commands,"--EMAILCENSORED")
                && this.containsEqualsIgnoreCase(commands,"--DOMAINFULL") && this.containsEqualsIgnoreCase(commands,"--DATETOMORROW"))
            {
                try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random IP: " + Base64.getEncoder().encodeToString(getRandomIP().getBytes()));
                             System.out.println("User Name: " + Base64.getEncoder().encodeToString(getUserName(getFromEmail(from[0].toString())).getBytes()));
                             System.out.println("Email Censored: " + Base64.getEncoder().encodeToString(getEmailCensored(getFromEmail(from[0].toString())).getBytes()));
                             System.out.println("Domain Full: " + Base64.getEncoder().encodeToString(getDomainFull(getFromEmail(from[0].toString())).getBytes()));
                             System.out.println("Date Tomorrow: " + Base64.getEncoder().encodeToString(getTomorrowDate().getBytes()));
                            System.out.println("From Name: " + Base64.getEncoder().encodeToString(getFromName(from[0].toString()).getBytes()));
                            System.out.println("From Email: "+ Base64.getEncoder().encodeToString(getFromEmail(from[0].toString()).getBytes()));
                            System.out.println("Subject: " + Base64.getEncoder().encodeToString(message.getSubject().getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
            }
        
        else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--RANDOMIP")
            && this.containsEqualsIgnoreCase(commands,"--USERNAME") && this.containsEqualsIgnoreCase(commands,"--EMAILCENSORED")
                && this.containsEqualsIgnoreCase(commands,"--DOMAINFULL") && this.containsEqualsIgnoreCase(commands,"--PC_OS"))
            {
                try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random IP: " + Base64.getEncoder().encodeToString(getRandomIP().getBytes()));
                             System.out.println("User Name: " + Base64.getEncoder().encodeToString(getUserName(getFromEmail(from[0].toString())).getBytes()));
                             System.out.println("Email Censored: " + Base64.getEncoder().encodeToString(getEmailCensored(getFromEmail(from[0].toString())).getBytes()));
                             System.out.println("Domain Full: " + Base64.getEncoder().encodeToString(getDomainFull(getFromEmail(from[0].toString())).getBytes()));
                             System.out.println("Random PC OS: " + Base64.getEncoder().encodeToString(getRandomPCOS().getBytes()));
                            System.out.println("From Name: " + Base64.getEncoder().encodeToString(getFromName(from[0].toString()).getBytes()));
                            System.out.println("From Email: "+ Base64.getEncoder().encodeToString(getFromEmail(from[0].toString()).getBytes()));
                            System.out.println("Subject: " + Base64.getEncoder().encodeToString(message.getSubject().getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
            }
        
        else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--RANDOMIP")
            && this.containsEqualsIgnoreCase(commands,"--USERNAME") && this.containsEqualsIgnoreCase(commands,"--EMAILCENSORED")
                && this.containsEqualsIgnoreCase(commands,"--DOMAINFULL") && this.containsEqualsIgnoreCase(commands,"--PC_BROWSER"))
            {
                try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random IP: " + Base64.getEncoder().encodeToString(getRandomIP().getBytes()));
                             System.out.println("User Name: " + Base64.getEncoder().encodeToString(getUserName(getFromEmail(from[0].toString())).getBytes()));
                             System.out.println("Email Censored: " + Base64.getEncoder().encodeToString(getEmailCensored(getFromEmail(from[0].toString())).getBytes()));
                             System.out.println("Domain Full: " + Base64.getEncoder().encodeToString(getDomainFull(getFromEmail(from[0].toString())).getBytes()));
                             System.out.println("Random PC Browser: " + Base64.getEncoder().encodeToString(getRandomPCBrowser().getBytes()));
                            System.out.println("From Name: " + Base64.getEncoder().encodeToString(getFromName(from[0].toString()).getBytes()));
                            System.out.println("From Email: "+ Base64.getEncoder().encodeToString(getFromEmail(from[0].toString()).getBytes()));
                            System.out.println("Subject: " + Base64.getEncoder().encodeToString(message.getSubject().getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
            }
        else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--RANDOMIP")
            && this.containsEqualsIgnoreCase(commands,"--USERNAME") && this.containsEqualsIgnoreCase(commands,"--EMAILCENSORED")
                && this.containsEqualsIgnoreCase(commands,"--DOMAINFULL") && this.containsEqualsIgnoreCase(commands,"--COUTRYCITY"))
            {
                try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random IP: " + Base64.getEncoder().encodeToString(getRandomIP().getBytes()));
                             System.out.println("User Name: " + Base64.getEncoder().encodeToString(getUserName(getFromEmail(from[0].toString())).getBytes()));
                             System.out.println("Email Censored: " + Base64.getEncoder().encodeToString(getEmailCensored(getFromEmail(from[0].toString())).getBytes()));
                             System.out.println("Domain Full: " + Base64.getEncoder().encodeToString(getDomainFull(getFromEmail(from[0].toString())).getBytes()));
                             System.out.println("Random City: " + Base64.getEncoder().encodeToString(getRandomCity().getBytes()));
                            System.out.println("From Name: " + Base64.getEncoder().encodeToString(getFromName(from[0].toString()).getBytes()));
                            System.out.println("From Email: "+ Base64.getEncoder().encodeToString(getFromEmail(from[0].toString()).getBytes()));
                            System.out.println("Subject: " + Base64.getEncoder().encodeToString(message.getSubject().getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
            }
        else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--RANDOMIP")
            && this.containsEqualsIgnoreCase(commands,"--USERNAME") && this.containsEqualsIgnoreCase(commands,"--EMAILCENSORED")
                && this.containsEqualsIgnoreCase(commands,"--DOMAINFULL") && this.containsEqualsIgnoreCase(commands,"--ANDROID_OS"))
            {
                try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random IP: " + Base64.getEncoder().encodeToString(getRandomIP().getBytes()));
                             System.out.println("User Name: " + Base64.getEncoder().encodeToString(getUserName(getFromEmail(from[0].toString())).getBytes()));
                             System.out.println("Email Censored: " + Base64.getEncoder().encodeToString(getEmailCensored(getFromEmail(from[0].toString())).getBytes()));
                             System.out.println("Domain Full: " + Base64.getEncoder().encodeToString(getDomainFull(getFromEmail(from[0].toString())).getBytes()));
                             System.out.println("Random Android OS: " + Base64.getEncoder().encodeToString(getRandomAndroidOS().getBytes()));
                            System.out.println("From Name: " + Base64.getEncoder().encodeToString(getFromName(from[0].toString()).getBytes()));
                            System.out.println("From Email: "+ Base64.getEncoder().encodeToString(getFromEmail(from[0].toString()).getBytes()));
                            System.out.println("Subject: " +Base64.getEncoder().encodeToString( message.getSubject().getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
            }
        else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--RANDOMIP")
            && this.containsEqualsIgnoreCase(commands,"--USERNAME") && this.containsEqualsIgnoreCase(commands,"--EMAILCENSORED")
                && this.containsEqualsIgnoreCase(commands,"--DOMAINFULL") && this.containsEqualsIgnoreCase(commands,"--ANDROID_BROWSER"))
            {
                try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random IP: " + Base64.getEncoder().encodeToString(getRandomIP().getBytes()));
                             System.out.println("User Name: " + Base64.getEncoder().encodeToString(getUserName(getFromEmail(from[0].toString())).getBytes()));
                             System.out.println("Email Censored: " + Base64.getEncoder().encodeToString(getEmailCensored(getFromEmail(from[0].toString())).getBytes()));
                             System.out.println("Domain Full: " + Base64.getEncoder().encodeToString(getDomainFull(getFromEmail(from[0].toString())).getBytes()));
                             System.out.println("Rabdin Android Browser: " + Base64.getEncoder().encodeToString(getRandomAndroidBrowser().getBytes()));
                            System.out.println("From Name: " + Base64.getEncoder().encodeToString(getFromName(from[0].toString()).getBytes()));
                            System.out.println("From Email: "+ Base64.getEncoder().encodeToString(getFromEmail(from[0].toString()).getBytes()));
                            System.out.println("Subject: " + Base64.getEncoder().encodeToString(message.getSubject().getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
            }
        
        else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--RANDOMIP")
            && this.containsEqualsIgnoreCase(commands,"--USERNAME") && this.containsEqualsIgnoreCase(commands,"--EMAILCENSORED")
                && this.containsEqualsIgnoreCase(commands,"--DOMAINFULL") && this.containsEqualsIgnoreCase(commands,"--UA"))
            {
                try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random IP: " + Base64.getEncoder().encodeToString(getRandomIP().getBytes()));
                             System.out.println("User Name: " + Base64.getEncoder().encodeToString(getUserName(getFromEmail(from[0].toString())).getBytes()));
                             System.out.println("Email Censored: " + Base64.getEncoder().encodeToString(getEmailCensored(getFromEmail(from[0].toString())).getBytes()));
                             System.out.println("Domain Full: " + Base64.getEncoder().encodeToString(getDomainFull(getFromEmail(from[0].toString())).getBytes()));
                             System.out.println("Random User Agent: " + Base64.getEncoder().encodeToString(getRandomUserAgent().getBytes()));
                            System.out.println("From Name: " + Base64.getEncoder().encodeToString(getFromName(from[0].toString()).getBytes()));
                            System.out.println("From Email: "+ Base64.getEncoder().encodeToString(getFromEmail(from[0].toString()).getBytes()));
                            System.out.println("Subject: " + Base64.getEncoder().encodeToString(message.getSubject().getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
            }
        else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--RANDOMIP")
            && this.containsEqualsIgnoreCase(commands,"--USERNAME") && this.containsEqualsIgnoreCase(commands,"--EMAILCENSORED")
                && this.containsEqualsIgnoreCase(commands,"--DOMAINFULL") && this.containsEqualsIgnoreCase(commands,"--APPLEAPPS"))
            {
                try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random IP: " + Base64.getEncoder().encodeToString(getRandomIP().getBytes()));
                             System.out.println("User Name: " + Base64.getEncoder().encodeToString(getUserName(getFromEmail(from[0].toString())).getBytes()));
                             System.out.println("Email Censored: " + Base64.getEncoder().encodeToString(getEmailCensored(getFromEmail(from[0].toString())).getBytes()));
                             System.out.println("Domain Full: " + Base64.getEncoder().encodeToString(getDomainFull(getFromEmail(from[0].toString())).getBytes()));
                             System.out.println("Random Apple App: " + Base64.getEncoder().encodeToString(getRandomAppleApps().getBytes()));
                            System.out.println("From Name: " + Base64.getEncoder().encodeToString(getFromName(from[0].toString()).getBytes()));
                            System.out.println("From Email: "+ Base64.getEncoder().encodeToString(getFromEmail(from[0].toString()).getBytes()));
                            System.out.println("Subject: " + Base64.getEncoder().encodeToString(message.getSubject().getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
            }
        else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--RANDOMIP")
            && this.containsEqualsIgnoreCase(commands,"--USERNAME") && this.containsEqualsIgnoreCase(commands,"--EMAILCENSORED")
                && this.containsEqualsIgnoreCase(commands,"--DOMAINFULL") && this.containsEqualsIgnoreCase(commands,"--APPLEPHONES"))
            {
                try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random IP: " + Base64.getEncoder().encodeToString(getRandomIP().getBytes()));
                             System.out.println("User Name: " + Base64.getEncoder().encodeToString(getUserName(getFromEmail(from[0].toString())).getBytes()));
                             System.out.println("Email Censored: " + Base64.getEncoder().encodeToString(getEmailCensored(getFromEmail(from[0].toString())).getBytes()));
                             System.out.println("Domain Full: " + Base64.getEncoder().encodeToString(getDomainFull(getFromEmail(from[0].toString())).getBytes()));
                             System.out.println("Random Apple Phone: "+ Base64.getEncoder().encodeToString(getRandomApplePhones().getBytes()));
                            System.out.println("From Name: " + Base64.getEncoder().encodeToString(getFromName(from[0].toString()).getBytes()));
                            System.out.println("From Email: "+ Base64.getEncoder().encodeToString(getFromEmail(from[0].toString()).getBytes()));
                            System.out.println("Subject: " + Base64.getEncoder().encodeToString(message.getSubject().getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
            }
        else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--RANDOMIP")
            && this.containsEqualsIgnoreCase(commands,"--USERNAME") && this.containsEqualsIgnoreCase(commands,"--EMAILCENSORED")
                && this.containsEqualsIgnoreCase(commands,"--DOMAINFULL") && this.containsEqualsIgnoreCase(commands,"--UNIVERSAL_BROWSER"))
            {
                try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            System.out.println("Random IP: " + Base64.getEncoder().encodeToString(getRandomIP().getBytes()));
                             System.out.println("User Name: " + Base64.getEncoder().encodeToString(getUserName(getFromEmail(from[0].toString())).getBytes()));
                             System.out.println("Email Censored: " + Base64.getEncoder().encodeToString(getEmailCensored(getFromEmail(from[0].toString())).getBytes()));
                             System.out.println("Domain Full: " + Base64.getEncoder().encodeToString(getDomainFull(getFromEmail(from[0].toString())).getBytes()));
                             System.out.println("Random Universal Browser: " + Base64.getEncoder().encodeToString(getRandomUniversalBrowser().getBytes()));
                            System.out.println("From Name: " + Base64.getEncoder().encodeToString(getFromName(from[0].toString()).getBytes()));
                            System.out.println("From Email: "+ Base64.getEncoder().encodeToString(getFromEmail(from[0].toString()).getBytes()));
                            System.out.println("Subject: " + Base64.getEncoder().encodeToString(message.getSubject().getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
            }
        else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--RANDOMIP")
            && this.containsEqualsIgnoreCase(commands,"--USERNAME") && this.containsEqualsIgnoreCase(commands,"--EMAILCENSORED")
                && this.containsEqualsIgnoreCase(commands,"--DOMAINFULL") && this.containsEqualsIgnoreCase(commands,"--RANDSTRING"))
            {
                try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            if(this.containsEquals(commands,"--randstring"))
                                System.out.println("Random String in lowercase: " + Base64.getEncoder().encodeToString(getRandomStringLowerCase().getBytes())); 
                            else if(this.containsEquals(commands,"--RANDSTRING"))
                                System.out.println("Random String in UpperCase : " + Base64.getEncoder().encodeToString(getRandomStringUpperCase().getBytes())); 
                            

                            System.out.println("Random IP: " + Base64.getEncoder().encodeToString(getRandomIP().getBytes()));
                             System.out.println("User Name: " + Base64.getEncoder().encodeToString(getUserName(getFromEmail(from[0].toString())).getBytes()));
                             System.out.println("Email Censored: " + Base64.getEncoder().encodeToString(getEmailCensored(getFromEmail(from[0].toString())).getBytes()));
                             System.out.println("Domain Full: " + Base64.getEncoder().encodeToString(getDomainFull(getFromEmail(from[0].toString())).getBytes()));
                            System.out.println("From Name: " + Base64.getEncoder().encodeToString(getFromName(from[0].toString()).getBytes()));
                            System.out.println("From Email: "+ Base64.getEncoder().encodeToString(getFromEmail(from[0].toString()).getBytes()));
                            System.out.println("Subject: " + Base64.getEncoder().encodeToString(message.getSubject().getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
            }
        else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--RANDOMIP")
            && this.containsEqualsIgnoreCase(commands,"--USERNAME") && this.containsEqualsIgnoreCase(commands,"--EMAILCENSORED")
                && this.containsEqualsIgnoreCase(commands,"--DOMAINFULL") && this.containsStartWith(commands,"--NUMBER"))
            {
                try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            if(this.containsStartWith(commands,"--NUMBER1"))
                                System.out.println("Random Number: " + (Base64.getEncoder().encodeToString(getNumbers(1).getBytes()))); 
                            else if(this.containsStartWith(commands,"--NUMBER2"))
                                System.out.println("Random Number: " + (Base64.getEncoder().encodeToString(getNumbers(2).getBytes())));
                            else if(this.containsStartWith(commands,"--NUMBER3"))
                                System.out.println("Random Number: " + (Base64.getEncoder().encodeToString(getNumbers(3).getBytes())));
                            else if(this.containsStartWith(commands,"--NUMBER4"))
                                System.out.println("Random Number: " + Base64.getEncoder().encodeToString(getNumbers(4).getBytes()));
                            else if(this.containsStartWith(commands,"--NUMBER5"))
                                System.out.println("Random Number: " + Base64.getEncoder().encodeToString(getNumbers(5).getBytes()));
                            else if(this.containsStartWith(commands,"--NUMBER6"))
                                System.out.println("Random Number: " + Base64.getEncoder().encodeToString(getNumbers(6).getBytes()));
                            else if(this.containsStartWith(commands,"--NUMBER7"))
                                System.out.println("Random Number: " + Base64.getEncoder().encodeToString(getNumbers(7).getBytes()));
                            else if(this.containsStartWith(commands,"--NUMBER8"))
                                System.out.println("Random Number: " + Base64.getEncoder().encodeToString(getNumbers(8).getBytes()));
                            else if(this.containsStartWith(commands,"--NUMBER9"))
                                System.out.println("Random Number: " + Base64.getEncoder().encodeToString(getNumbers(9).getBytes()));
                            else if(this.containsStartWith(commands,"--NUMBER10"))
                                System.out.println("Random Number: " + Base64.getEncoder().encodeToString(getNumbers(10).getBytes()));

                            
                            System.out.println("Random IP: " + Base64.getEncoder().encodeToString(getRandomIP().getBytes()));
                             System.out.println("User Name: " + Base64.getEncoder().encodeToString(getUserName(getFromEmail(from[0].toString())).getBytes()));
                             System.out.println("Email Censored: " + Base64.getEncoder().encodeToString(getEmailCensored(getFromEmail(from[0].toString())).getBytes()));
                             System.out.println("Domain Full: " + Base64.getEncoder().encodeToString(getDomainFull(getFromEmail(from[0].toString())).getBytes()));
                            System.out.println("From Name: " + Base64.getEncoder().encodeToString(getFromName(from[0].toString()).getBytes()));
                            System.out.println("From Email: "+ Base64.getEncoder().encodeToString(getFromEmail(from[0].toString()).getBytes()));
                            System.out.println("Subject: " + Base64.getEncoder().encodeToString(message.getSubject().getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
            }
        else if(this.containsEqualsIgnoreCase(commands,"Mailer") && this.containsEqualsIgnoreCase(commands, "--EMAIL64")
            && this.containsEqualsIgnoreCase(commands,"--SUBJECT") && this.containsEqualsIgnoreCase(commands,"--FROMMAIL")
            && this.containsEqualsIgnoreCase(commands,"--FROMNAME") && this.containsEqualsIgnoreCase(commands,"--RANDOMIP")
            && this.containsEqualsIgnoreCase(commands,"--USERNAME") && this.containsEqualsIgnoreCase(commands,"--EMAILCENSORED")
                && this.containsEqualsIgnoreCase(commands,"--DOMAINFULL") && this.containsStartWith(commands,"--CHAR"))
            {
                try
                {
                        store = session.getStore("imaps");
                        store.connect();
                        inbox = store.getFolder("INBOX");
                        inbox.open(Folder.READ_ONLY);
                        Message messages[] = inbox.search(new FlagTerm(new Flags(Flag.SEEN), false));
                        System.out.println("Total Number of emails = " + messages.length);
                        int count=1;
                        for (int i =messages.length-1 ; i >=0; i--)
                        {
                            System.out.println("Email No: "+count++);
                            Message message = messages[i];
                            Address[] from = message.getFrom(); 
                            System.out.println("-------------------------------"); 
                            System.out.println("Date : " + message.getSentDate()); 
                            if(this.containsStartWith(commands,"--CHAR1"))
                                System.out.println("Random Characters in Upper Case: " + Base64.getEncoder().encodeToString(getCharUpperCase(1).getBytes())); 
                            else if(this.containsStartWith(commands,"--CHAR2"))
                                System.out.println("Random Characters in Upper Case: " +Base64.getEncoder().encodeToString( getCharUpperCase(2).getBytes()));
                            else if(this.containsStartWith(commands,"--CHAR3"))
                                System.out.println("Random Characters in Upper Case: " + Base64.getEncoder().encodeToString(getCharUpperCase(3).getBytes())); 
                            else if(this.containsStartWith(commands,"--CHAR4"))
                                System.out.println("Random Characters in Upper Case: " + Base64.getEncoder().encodeToString(getCharUpperCase(4).getBytes())); 
                            else if(this.containsStartWith(commands,"--CHAR5"))
                                System.out.println("Random Characters in Upper Case: " + Base64.getEncoder().encodeToString(getCharUpperCase(5).getBytes())); 
                            else if(this.containsStartWith(commands,"--CHAR6"))
                                System.out.println("Random Characters in Upper Case: " + Base64.getEncoder().encodeToString(getCharUpperCase(6).getBytes())); 
                            else if(this.containsStartWith(commands,"--CHAR7"))
                                System.out.println("Random Characters in Upper Case: " + Base64.getEncoder().encodeToString(getCharUpperCase(7).getBytes())); 
                            else if(this.containsStartWith(commands,"--CHAR8"))
                                System.out.println("Random Characters in Upper Case: " + Base64.getEncoder().encodeToString(getCharUpperCase(8).getBytes())); 
                            else if(this.containsStartWith(commands,"--CHAR9"))
                                System.out.println("Random Characters in Upper Case: " + Base64.getEncoder().encodeToString(getCharUpperCase(9).getBytes())); 
                            else if(this.containsStartWith(commands,"--CHAR10"))
                                System.out.println("Random Characters in Upper Case: " + Base64.getEncoder().encodeToString(getCharUpperCase(10).getBytes()));
                            else if(this.containsStartWith(commands,"--char1"))
                                System.out.println("Random Characters in Lower Case: " + Base64.getEncoder().encodeToString(getCharLowerCase(1).getBytes())); 
                            else if(this.containsStartWith(commands,"--char2"))
                                System.out.println("Random Characters in Lower Case: " + Base64.getEncoder().encodeToString(getCharLowerCase(2).getBytes())); 
                            else if(this.containsStartWith(commands,"--char3"))
                                System.out.println("Random Characters in Lower Case: " + Base64.getEncoder().encodeToString(getCharLowerCase(3).getBytes())); 
                            else if(this.containsStartWith(commands,"--char4"))
                                System.out.println("Random Characters in Lower Case: " + Base64.getEncoder().encodeToString(getCharLowerCase(4).getBytes())); 
                            else if(this.containsStartWith(commands,"--char5"))
                                System.out.println("Random Characters in Lower Case: " + Base64.getEncoder().encodeToString(getCharLowerCase(5).getBytes())); 
                            else if(this.containsStartWith(commands,"--char6"))
                                System.out.println("Random Characters in Lower Case: " + Base64.getEncoder().encodeToString(getCharLowerCase(6).getBytes())); 
                            else if(this.containsStartWith(commands,"--char7"))
                                System.out.println("Random Characters in Lower Case: " + Base64.getEncoder().encodeToString(getCharLowerCase(7).getBytes())); 
                            else if(this.containsStartWith(commands,"--char8"))
                                System.out.println("Random Characters in Lower Case: " + Base64.getEncoder().encodeToString(getCharLowerCase(8).getBytes())); 
                            else if(this.containsStartWith(commands,"--char9"))
                                System.out.println("Random Characters in Lower Case: " + Base64.getEncoder().encodeToString(getCharLowerCase(9).getBytes())); 
                            else if(this.containsStartWith(commands,"--char10"))
                                System.out.println("Random Characters in Lower Case: " + Base64.getEncoder().encodeToString(getCharLowerCase(10).getBytes())); 
                            
                            
                            
                            System.out.println("Random IP: " + Base64.getEncoder().encodeToString(getRandomIP().getBytes()));
                             System.out.println("User Name: " + Base64.getEncoder().encodeToString(getUserName(getFromEmail(from[0].toString())).getBytes()));
                             System.out.println("Email Censored: " + Base64.getEncoder().encodeToString(getEmailCensored(getFromEmail(from[0].toString())).getBytes()));
                             System.out.println("Domain Full: " + Base64.getEncoder().encodeToString(getDomainFull(getFromEmail(from[0].toString())).getBytes()));
                            System.out.println("From Name: " + Base64.getEncoder().encodeToString(getFromName(from[0].toString()).getBytes()));
                            System.out.println("From Email: "+ Base64.getEncoder().encodeToString(getFromEmail(from[0].toString()).getBytes()));
                            System.out.println("Subject: " + Base64.getEncoder().encodeToString(message.getSubject().getBytes())); 
                            System.out.println("Email :"); 
                            System.out.println(Base64.getEncoder().encodeToString(processMessageBody(message).getBytes())); 
                            System.out.println("--------------------------------");
                        }
                        inbox.close(true); 
                        store.close();
                    } 
                    catch (Exception e) 
                    { 
                        System.out.println("Error Occured: Check Credentials"); 
                    }
            }
            else
            {
                    System.out.println("Invalid Syntax/Command!");
            }
        
     
        
    }
    
    
    
}
