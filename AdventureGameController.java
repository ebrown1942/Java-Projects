/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guinewworld;

import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author ericbrown
 */
public class AdventureGameController implements Initializable {

    Player mainChracter;
    NPCS monster1;
    Room livingRoom;
    Room couchRoom;
    Room kitcheRoom;
    ArrayList<Room> rooms;

    int index;

    @FXML
    private Button FightB;
    @FXML
    private Button SearchRoomB;
    @FXML
    private Button RunB;
    @FXML
    private Button SleepB;
    @FXML
    private Label DexL;
    @FXML
    private Label STRL;
    @FXML
    private Label INTL;
    @FXML
    private Label HPL;
    @FXML
    private Label GoldL;
    @FXML
    private Button LeftB;
    @FXML
    private Button RightB;
    @FXML
    private Button UPb;
    @FXML
    private Button DownB;
    @FXML
    private Button Start;
    @FXML
    private Label Status;
    @FXML
    private Button CouchRoomB;
    @FXML
    private Button KitchenRoomB;
    @FXML
    private Button LivingRoomL;
    @FXML
    private TextArea StatusField;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        mainChracter = new Player();

        monster1 = new NPCS();

        livingRoom = new Room();

        couchRoom = new Room();
        couchRoom.setMonster(monster1);

        kitcheRoom = new Room();

        rooms = new ArrayList();
        rooms.add(livingRoom);
        rooms.add(kitcheRoom);
        rooms.add(couchRoom);

    }

    @FXML
    private void Fight(ActionEvent event) {
        int Fightdice = rollDice2();
        if (Fightdice >= monster1.getDexerity()){
            int monsterHitPoints = monster1.getHitPoints();
        int damage = mainChracter.getStrength() / 3;
        int newMonsterHitPoints  = monsterHitPoints - damage;
        monster1.setHitPoints(newMonsterHitPoints);
         Status.setText(" You wounded the monster!" + damage);
        if (newMonsterHitPoints < 0){
            Status.setText("You have defeated the Monster!");
        }else {
            Status.setText("He is attacking us!");
            monsterAttack();
           
        }
        
    }
    }
    @FXML
    private void SearchRoom(ActionEvent event) {
        rollDice2();
        if (rollDice2() < mainChracter.getIntelligence()) {
          int newtotalGold = mainChracter.getToatalgold() + 5;
          GoldL.setText(newtotalGold + "");
          Status.setText("You have found gold!");
            
        }else {
            Status.setText("You are not smart enough!");
        }

    }

    @FXML
    private void Run(ActionEvent event) {
        rollDice2();
        if (rollDice2() < mainChracter.getIntelligence()) {
            monsterAttack();
        }else ChangeRoomKitchen(event);
        
        Status.setText("You are in the Kitchen");
    }

    @FXML
    private void Sleep(ActionEvent event) {
       HPL.setText(mainChracter.getHitPoints() + "");
    }

    @FXML
    private void Left(ActionEvent event) {
        Status.setText("You moved left");
        rooms.get(index).moveLeft();
        
    }

    @FXML
    private void Right(ActionEvent event) {
        Status.setText("You moved right");
        rooms.get(index).moveRight();
    }

    @FXML
    private void Up(ActionEvent event) {
        Status.setText("You moved Up");
        rooms.get(index).moveUp();
    }

    @FXML
    private void Down(ActionEvent event) {
        Status.setText("You moved Down");
        rooms.get(index).moveDown();
    }

    @FXML
    private void Refresh(ActionEvent event) {
        displayPlayer();

        Status.setText("Start Playing!");
    }

    private void displayPlayer() {
        DexL.setText(mainChracter.getDexerity() + "");
        STRL.setText(mainChracter.getStrength() + "");
        INTL.setText(mainChracter.getIntelligence() + "");
        HPL.setText(mainChracter.getHitPoints() + "");
        GoldL.setText(mainChracter.getToatalgold() + "");
    }

    @FXML
    private void ChangeRoomCouch(ActionEvent event) {
        index = 2;
        if (rooms.get(index).isBlocked()) {
            Status.setText("This room blocked!");
        } else {
            Status.setText("You are in the Couch Room. Monster Near!");
        }
    }

    @FXML
    private void ChangeRoomKitchen(ActionEvent event) {
        index = 1;
        if (rooms.get(index).isBlocked()) {
            Status.setText("This room blocked!");
        } else {
            Status.setText("You are in the Kitchen");
        }
    }

    @FXML
    private void ChangeRoomLiving(ActionEvent event) {
        index = 0;
        if (rooms.get(index).isBlocked()) {
            Status.setText("This room blocked!");
        } else {
            Status.setText("You are in the Living Room.");
        }
    }
    public int rollDice2(){
        Random random2 = new Random();
        int dice = random2.nextInt(20);
        
      return  dice;
    }
    
    public void monsterAttack (){
      int mainChracterHitPoints = mainChracter.getHitPoints();
      int playerDamage = monster1.getStrength() / 3;
      int newmainChracterHitPoints = mainChracterHitPoints - playerDamage;
      HPL.setText(newmainChracterHitPoints + "");
      
        
    }

}
