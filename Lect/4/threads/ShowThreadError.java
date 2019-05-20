package examples.threads;
/** 
  * A class to demonstrate the run-time error that
  * occurs if wait, notify, or notifyAll are used
  * when no lock has been obtained.
  */
public class ShowThreadError {
   private int value;
   /** Set the value of an object
     * This method is synchronized
     * @param v the object's new value
     */
   public synchronized void setValue( int v ) {
      value = v;
      doTheNotificationThing();	// okay here
   }
   /** Get the value of the object
     * This method is synchronized
     * @return the object's value
     */
   public synchronized int getValue() {
      return value;
   }
   /** Notify waiting objects of a change
     * This method is not synchronized
     */
   public void doTheNotificationThing() {
      notifyAll();
   } 	
   /** Test method for the class
     * @param args not used
     */
   public static void main( String[] args ) {
      ShowThreadError t = new ShowThreadError();
      t.setValue( 10 );	
      System.out.println( "value has been set to "
                          + t.getValue() );
      // the next statement causes a run-time error
      t.doTheNotificationThing();
   }
}
