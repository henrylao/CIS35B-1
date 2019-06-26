package examples.threads.bank;
/** 
  * A class to demonstrate wait and notify methods
  */
public class Saver implements Runnable {
   private BankAccount account;
   /** Class constructor method
     * @param ba The bank account where this saver
     *    puts the money
     */
   public Saver( BankAccount ba ) {
      account = ba;
   }
   /** The method the saver uses to put away money */
   public void run() {
      while( account.isOpen() ) {
         try {
            if ( account.deposit( 100 ) ) {
               System.out.println( 
               "$100 successfully deposited." );
            }
            Thread.currentThread().sleep( 1000 );
         } catch ( InterruptedException iex ) {
            // display the exception, but continue
            System.err.println( iex );
         }
      }
   }
}