package examples.threads.bank;
/** A class to demonstrate wait and notify methods
  */
public class BankAccount {
   private int balance = 0;
   private boolean isOpen = true;
   /** The method withdraws an amount from the
     * account. If funds are insufficient, it will
     * wait until the funds are available or the
     * account is closed.  
     * @param amount The amount to be withdrawn from
     *    the account
     * @return true if the withdrawal is successful, 
     *    false otherwise
     * @exception InterruptedException If another
     *    thread calls the <b>interrupt</b> method
     */
   public synchronized boolean withdraw( int amount )
                throws InterruptedException {
      while ( amount > balance && isOpen() ) {
         System.out.println( "Waiting for "
                             + "some money ..." );
            wait();
      }
      boolean result = false;
      if ( isOpen() ) {
         balance -= amount;
         result = true;
      }
      return result;
   }
   /** The method to deposit an amount into the
     * account provided that the account is open.
     * When the deposit is  successful, it will notify
     * all waiting operations that there is now more
     * money in the account
     * @param amount The amount to be deposited into
     *    the account
     * @return true if the deposit is successful, 
     *    false otherwise
     */
   public synchronized boolean deposit( int amount ) {
      if ( isOpen() ) {
         balance += amount;
         notifyAll();
         return true;
      } else {
         return false;
      }
   }
   /** Check to see if the account is open
     * @return true if it is open, otherwise false
     */
   public synchronized boolean isOpen() {
      return isOpen;
   }
   /** Close the bank account */
   public synchronized void close() {
      isOpen = false;
      notifyAll();
   }
}