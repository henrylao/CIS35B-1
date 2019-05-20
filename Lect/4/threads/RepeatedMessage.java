 
/** A class to demonstrate why synchronized methods
  * are needed by showing what can happen when they
  * are not synchronized.
  */
public class RepeatedMessage implements Runnable {
   private static Object sharedLock = new Object();

   private String message;
   private int pauseTime;
   /**  field stopFlag tells thread when to stop 
     * declared volatile to ensure every thread sees
     * change immediately
     */
    private volatile boolean stopFlag; //ensure that stopFlag value is not corrupted.

   /** Construct a repeating message
     * @param inputMessage the message to be
     *    repeated
     * @param inputPauseTime the time, in ms,
     *    paused between each letter of the
     *    message
     */
   public RepeatedMessage( String inputMessage, 
                           int inputPauseTime ) {
      message = inputMessage;
      pauseTime = inputPauseTime;
   }
 
   /** Display a repeating message
     * @param rm the message to be repeated
     * @exception InterruptedException if the thread
     *    does not sleep for the full time specified
     */
   public static 
          void displayMessage( RepeatedMessage rm ) 
                      throws InterruptedException {
      synchronized ( sharedLock ) {
         for( int i=0; i < rm.message.length(); i++ ) {
            System.out.print( rm.message.charAt( i ) );
            Thread.currentThread().sleep( 50);
         }
         System.out.println();
      }
   }

   /** The workings of the thread
     */
   public void run() {
      stopFlag = false;
      try {
         while ( ! stopFlag ) {
            displayMessage( this );
            Thread.currentThread().sleep( pauseTime );
         }
      } catch( InterruptedException ie ) {
         return;
      }
   }
   
   /** A method to set a flag to stop the thread
     */
    public void finish() {
      stopFlag = true;
      return;
   }	
 
   /** The test method for the class
     * @param args not used
     */
   public static void main( String[] args ) {
      try {
         RepeatedMessage m1
            = new RepeatedMessage( "bonjour!", 500 );
         Thread m1t = new Thread(m1);
         m1t.start();
         RepeatedMessage m2
            = new RepeatedMessage( "HELLO!", 111 );
         Thread m2t= new Thread(m2);
         m2t.start();

         // pause to let the threads run,
         // then stop them
         Thread.sleep( 5000 );
         m1.finish();
         m2.finish();
	 m1t.join();
	 m2t.join();
      } catch( InterruptedException ie ) {
         ie.printStackTrace();
      }
      finally {
         // flush the output buffer
         System.out.println();
      }
   }
}