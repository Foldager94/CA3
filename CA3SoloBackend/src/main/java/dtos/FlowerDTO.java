/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import entities.Flowers;

/**
 *
 * @author ckfol
 */
public class FlowerDTO {
    String flowerName;

    public FlowerDTO(Flowers flower) {
        this.flowerName = flower.getFlower();
    }

    public String getFlowerName() {
        return flowerName;
    }

    public void setFlowerName(String flowerName) {
        this.flowerName = flowerName;
    }
    
    
}
