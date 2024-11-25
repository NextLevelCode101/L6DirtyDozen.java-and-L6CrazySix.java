/* 
Farhan Khan Block 1
L6CrazySix.java       
Use conditional statements and loops to  solve challenges
 */
  
import edu.fcps.karel2.Display;
import edu.fcps.karel2.Robot;
import edu.fcps.karel2.WorldFrame; 
import javax.swing.JOptionPane;
//IMported everything 
public class L6CrazySix {
   // this is calling the file name
   public static void main(String[] args) {
      
      String[] choices = {"tasks1", "tasks2", "tasks3"};
      String filename = (String)JOptionPane.showInputDialog(null, "Choose a map.", "Map Choices", JOptionPane.PLAIN_MESSAGE, null, choices, choices[0]);
      Display.openWorld("maps/" + filename + ".map");
      Display.setSize(10, 10);
      Display.setSpeed(10);
      WorldFrame.getCurrent().setLocation(0, 0);
   //set everything i needed to
      
      task_01(); //go to the end of the row of beepers
      task_02(); //go to the beeper
      task_03(); //go to the wall
      task_04(); //go to the wall, pick up all the beepers (max one per pile)
      task_05(); //go to the wall, pick up all the beepers
      task_06(); //go to the end of the row of beepers, there is one gap exactly one beeper wide
      // task functions called
   }
   
      
		
	// Go to the end of the row of beepers
   public static void task_01() {
      Robot temp = new Robot(1, 1, Display.EAST, 0);
      while (temp.nextToABeeper())
             temp.move();
      //task1 
         
   }
   
   
      
	// Go to the beeper
   public static void task_02() { 
      Robot temp = new Robot(1, 2, Display.EAST, 0);
     while (!temp.nextToABeeper())
             temp.move();
    
     //task2   
   
   }
   
   
      
	// Go to the wall
   public static void task_03() {
      Robot temp = new Robot(1, 3, Display.EAST, 0);
      while (temp.frontIsClear())
             temp.move();
      
         //task3
   }
      
      
      
	// Go to the wall, pick up all the beepers (max one per pile)
   public static void task_04() { 
      Robot temp = new Robot(1, 4, Display.EAST, 0);
       while (temp.frontIsClear()){
       if (temp.nextToABeeper())
             temp.pickBeeper();
             temp.move();
             //task4
}
             
      
         
   }
   
   
       
	// Go to the wall, pick up all the beepers 
   public static void task_05() { 
      Robot temp = new Robot(1, 5,Display.EAST, 0);
       while (temp.frontIsClear()){
       while (temp.nextToABeeper())
             temp.pickBeeper();
             temp.move();
}
        while (temp.nextToABeeper())
             temp.pickBeeper();
       
         //task5
   }
   
   
      
	// Go to the end of the row of beepers, there is one gap exactly one beeper wide
   public static void task_06() {
      Robot temp = new Robot(1, 6, Display.EAST, 0);
       
       while (temp.nextToABeeper()){
             temp.move();
        if(!temp.nextToABeeper())
             temp.move();
             //task6
         
}
      
         
   }
   

}
