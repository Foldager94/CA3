/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

/**
 *
 * @author ckfol
 */
public class KoalaFactDTO {
    String fact;
    
    public KoalaFactDTO(String fact) {
        this.fact = fact;
    }

    public String getFact() {
        return fact;
    }
    
}
