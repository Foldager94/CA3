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
public class KoalaDTO {
    String fact, link;

    public KoalaDTO(KoalaFactDTO fact, KoalaImgDTO img) {
        this.fact = fact.getFact();
        this.link = img.getLink();
        
    }

    
    
    
}
