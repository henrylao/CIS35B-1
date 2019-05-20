package examples.threads.bank;

import examples.threads.bank.*;

/** 
  * A class to demonstrate wait and notify methods
  */
public class Spender extends Thread {

   private BankAccount account;

   /** Class constructor method
     * @param ba The bank account from which
     *    this spender takes the money
     */
   public Spender( BankAccount ba ) {
      account = ba;
   }

   /** The method the spender uses
     * to take out money
     */
   public void run() {
      while( account.isOpen() ) {
         try {
            if ( account.withdraw( 500 ) ) {
               System.out.println( 
               "$500 successfully withdrawn." );
            }
            sleep( 1000 ); 
         } catch ( InterruptedException iex ) {
            // display any interruptions but continue
            System.err.println( iex );
         }
      }
   }
}