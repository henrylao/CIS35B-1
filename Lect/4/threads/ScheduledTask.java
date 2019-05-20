package examples.threads;
/**A class to demonstrate using the Timer utility to schedule
 * tasks on a background thread.
 */
public class ScheduledTask extends java.util.TimerTask {
   String message;
/**A construct a task
 * @param message is a String to be displayed by the task
 */   
   ScheduledTask(String message) {
   	this.message = message;
   }
/**The task is simply to print the message to the console
 */
   public void run() {
   	System.out.println(message);
   }   
}
