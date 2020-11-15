/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import entities.User;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ckfol
 */
public class UserDTO {
    String username, password, zodiacsign, flower;

    public UserDTO(String username, String password, String zodiacsign, String flower) {
        this.username = username;
        this.password = password;
        this.zodiacsign = zodiacsign;
        this.flower = flower;
    }

    public UserDTO(User user) {
        this.username = user.getUserName();
        this.zodiacsign = user.getZodiacSign();
        this.flower = user.getFlower().getFlower();
    }
    
    

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getZodiacsign() {
        return zodiacsign;
    }

    public String getFlower() {
        return flower;
    }
    

}
