/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.users;
import java.util.Scanner;

/**
 *
 * @author S153298
 */
public class Operator extends User{
    Operator op = new Operator(); 
    Scanner sc = new Scanner(System.in);
    Advertiser advert;
     /**
     * This function will return the userType for this class.
     * @return 
     */
 
    public  UserType getType(){
        return UserType.OPERATOR;
    }    

}
/*public boolean replyRequest(){
String answer;
advert.sendRequest();
System.out.println("Does the sadvertiser have your permission? Yes or No");
answer = sc.nextLine();
if (answer == "yes"){
   return true;  
}
else 
    return false; 
}
}
*/