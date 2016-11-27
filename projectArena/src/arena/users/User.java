/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arena.users;

/**
 *
 * @author S153298
 */
public abstract class User {
    private int userID;
    private String userName;
    
    
    public enum UserType{
        PLAYER, OPERATOR, ADVERTISER, LEAGUEOWNER
    }
    /**
     * This function takes a UserType and returns a object of that type (though 
     * cast as the User-superclass)
     * @param userType
     * @return 
     */
    public static User userFactory(UserType userType){
        switch (userType){
            case PLAYER: return new Player();
            case OPERATOR: return new Operator();
            case ADVERTISER: return new Advertiser();
            case LEAGUEOWNER: return new LeagueOwner();
            default: System.out.println("Error, you look like a butt");
                return null;
        }
    }
    
    /**
     * This function will return whatever type of user the instance really is.
     * Concrete implementation can be found in subclasses. 
     * @return 
     */
    public abstract UserType getType();
}
