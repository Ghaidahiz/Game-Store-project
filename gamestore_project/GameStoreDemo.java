package gamestore_project;
import java.util.*;

public class GameStoreDemo {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in); 


       GameStore GEA = new GameStore("GEA", 50, 50);

System.out.println("WELCOME TO GEA GAME STORE !");
int check;

do
{
System.out.println("ARE YOU A .. \n 1- USER? \n 2-ADMIN?");
 check = sc.nextInt();

if(check==1)
{
    System.out.println("PLEASE ENTER YOUR NAME :");
   String name = sc.next();
    System.out.println("PLEASE ENTER YOUR WALLET AMOUNT :");
 //double wallet = sc.nextDouble();

User u1 = new User(name, wallet );

System.out.println(" PLEASE SELECTTHE NUMBER OF SERVICE THAT YOU WANT : ");
System.out.println("1- BUY A GAME ? \n 2-SEND GIFT TO A FRIEND ? \n 3-UNINSTALL GAME ? \n 4- FIND GAME ?");
int choice = sc.nextInt();

while (choice<0 && choice>4 ) {
    System.out.println("WRONG INPUT , PLEASE TRY AGAIN ?");
    System.out.println("1- BUY A GAME ? \n 2-SEND GIFT TO A FRIEND ? \n 3-UNINSTALL GAME ? \n 4- FIND GAME ?");
    choice = sc.nextInt(); 
}

switch (choice) {
    case 1:

        
        break;

    case 2:
        break;

    case 3:
    break;

    case 4:
    break;

    case 0:
    break;
}






























}
else
if(check==2)
{





























}
else
System.out.println("invalid input , try again..");


}while(check!=1 && check!=2);



    }

}
