package examples.threads;
/**A lass to demonstrate using the Timer utility to schedule
 * tasks on a background thread.
 */
public class ScheduleTasks {
   
   public static void main(String[] args) {
      ScheduledTask hello1 = new ScheduledTask("Hello Joe");
      ScheduledTask hello2 = new ScheduledTask("Hello Paula");
      ScheduledTask howareyou = new ScheduledTask("How are you?");
      ScheduledTask fine = new ScheduledTask("I'm fine thank-you, and you?");
      ScheduledTask fine2 = new ScheduledTask("I'm fine too");
      ScheduledTask goodbye1 = new ScheduledTask("Goodbye Joe");
      ScheduledTask goodbye2 = new ScheduledTask("Goodbye Paula");
      // run the timer thread as a daemon
      java.util.Timer timer = new java.util.Timer(true);
      timer.schedule(hello1, 1000);
      timer.schedule(goodbye2, 6000);
      System.out.println("Two old friends meet.");
      timer.schedule(howareyou, 3000);
      timer.schedule(fine2, 4500);
      System.out.println("They haven't seen each other in years.");
      timer.schedule(fine, 4000);
      System.out.println("They have gone their separate ways.");
      timer.schedule(goodbye1, 5500);
      timer.schedule(hello2, 1000);
      try {
         Thread.currentThread().sleep(7000);
      } catch (InterruptedException e) {};
   }
}