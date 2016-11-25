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
    public abstract UserType getType();
}
