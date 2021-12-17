/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guinewworld;

import java.util.Random;

/**
 *
 * @author ericbrown
 */
public class Player {
    
    private int hitPoints;
    
    private int dexerity;
    
    private int strength;
    
    private int intelligence;
    
    private int toatalgold;

    public Player() {
        
        setHitPoints(20);
        
        setDexerity(rollDice());
        
        setStrength(rollDice());
        
        setIntelligence(rollDice());
        
        
        
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public int getDexerity() {
        return dexerity;
    }

    public int getStrength() {
        return strength;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public int getToatalgold() {
        return toatalgold;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public void setDexerity(int dexerity) {
        this.dexerity = dexerity;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public void setToatalgold(int toatalgold) {
        this.toatalgold = toatalgold;
    }
    
    public int rollDice(){
        Random random = new Random();
        int dice = random.nextInt(6) + 1 + random.nextInt(6) +1 + random.nextInt(6) + 1;
        
      return  dice;
    }
    
}
