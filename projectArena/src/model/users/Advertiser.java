/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.users;

/**
 *
 * @author S153298
 */
public class Advertiser extends User {

    private double accountBalance;

    /**
     * This function will return the userType for this class.
     *
     * @return
     */
    public UserType getType() {
        return UserType.ADVERTISER;
    }
}
