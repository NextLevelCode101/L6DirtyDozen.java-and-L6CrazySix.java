/*
James Pierce Block 1
L6bDirtyDozen.java      
Use conditional statements and loops to  solve challenges
 */
import edu.fcps.karel2.Display;
import edu.fcps.karel2.Robot;
import edu.fcps.karel2.WorldFrame;
import javax.swing.JOptionPane;
   
public class L6bDirtyDozen {
   
   public static void main(String[] args) {
     
      String[] choices = {"tasks4", "tasks5", "tasks6"};
      String filename = (String)JOptionPane.showInputDialog(null, "Choose a map.", "Map Choices", JOptionPane.PLAIN_MESSAGE, null, choices, choices[0]);
      Display.openWorld("maps/" + filename + ".map");
      Display.setSize(10, 10);
      Display.setSpeed(8);
      WorldFrame.getCurrent().setLocation(0, 0);
   
     
      task_07(); //Go to the beeper or the wall (whichever one comes first).  
      task_08(); //Go until you are next to another Robot. Count how many times you moved, then put that amount of  beepers down.
      task_09(); //Put down 5 different piles with 4 beepers in each pile.
      task_10(); //Fill in every gap with a beeper.  Stop when you reach a wall.
      task_11(); //While there is a wall to your right, put down one beeper at each step
      task_12(); //Go until there is a wall to your right and you are standing on a beeper
   
   
   }  

// Go to the beeper or the wall (whichever one comes first).
   public static void task_07() {
      Robot temp = new Robot(1, 1, Display.EAST, 0);
      while(temp.frontIsClear() && !temp.nextToABeeper())
      {
      temp.move();
      }
   
         
   }
   
   
     
// Go until you are next to another Robot. Count how many times you moved, then put that amount of  beepers down
   public static void task_08() {
      Robot temp = new Robot(1, 2, Display.EAST, 100);
     
      //random Robot
      int randomX = (int)(Math.random() * 10 + 1);
      Robot randomRobot = new Robot(randomX, 2, Display.EAST, 0);
      int count = 0;
      while (!temp.nextToARobot())
      {
         temp.move();
         count++;
      }
     
      for(int i=0; i<count;i++)
      {
         temp.putBeeper();
      }
   
     
   
   }
   
  //Put down 5 different piles with 4 beepers in each pile.
   public static void task_09() {
      Robot t = new Robot(1, 3, Display.EAST, 100);
      for (int i=0; i<5;i++){
         for (int j=0;j<4;j++)
            t.putBeeper();
         t.move();
       }
       
   }

     
// Fill in every gap with a beeper.  Stop when you reach a wall.
   public static void task_10() {
      Robot t = new Robot(1, 4, Display.EAST, 100);
     while (t.frontIsClear()){
      if(!t.nextToABeeper())
      t.putBeeper();
      t.move();
      }
   }
     
// While there is a wall to your right, put down one beeper at each step
   public static void task_11() {
      Robot t = new Robot(1, 5,Display.EAST, 100);
       while (!t.rightIsClear())
       {
       t.putBeeper();
       t.move();
       }
   }
     
//Go until there is a wall to your right and you are standing on a beeper
   public static void task_12() {
      Robot t = new Robot(1, 6, Display.EAST, 0);
      while (!t.nextToABeeper()||t.rightIsClear())
      t.move();
     
   }
   

}
