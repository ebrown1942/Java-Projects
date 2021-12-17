package guinewworld;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ericbrown
 */
public class Room {
    
    private NPCS monster;
    
    private int gold;
    
    private String [][] room;

    private boolean blocked = false;
    
    private boolean monsterPresent = false;
    
    int row = 0;
    
    int col = 0;
    
    public Room() {
       
        
        room = new String [10][10];
        
        for (int row = 0; row < room.length; row ++) {
            for (int col = 0; col < room[row].length; col ++){
                room [row][col] = "";
            }
                
        }
            
            
        
   
        
        gold = 30;
        
        
       
        
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }
    public boolean getMonsterStatus (){
        return monsterPresent;
    }
    
    public void setMonster (NPCS monster){
        this.monster = monster;
        monsterPresent = true;
    }
    
    public int getGold (){
        return gold;
    }
    
    public void moveLeft(){
        col --;
        if (col < 0 )
            col = 0;
    }
    public void moveRight(){
        col ++;
        if (col > 9 )
            col = 9;
    }
    public void moveUp(){
        row --;
        if (row < 0 )
            row = 0;
    }
    public void moveDown(){
        row ++;
        if (row > 9 )
            row = 9;
    }
   
}
