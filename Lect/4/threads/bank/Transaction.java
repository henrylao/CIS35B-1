package bank;
/**
 * Class Transaction demonstrates ThreadLocal 
 * static variables. It contains an instance 
 * Variable for comparison purposes. 
 */
public class Transaction {  
   // use counter to issue sequential transaction numbers 
   private static int tranCount = 0;
   // trandId and threadTranId demonstrate the impact of ThreadLocal
   private int tranId = 0;
   private static ThreadLocal threadTranId = new ThreadLocal() {
      	protected synchronized Object initialValue() {
      	 return new Integer(tranCount);
      	}
      };   	
   public Transaction() {
      tranId=(++tranCount);
   }         
   public static int getThreadTranId() {
      return ((Integer) (threadTranId.get())).intValue();
   }         
   public void setThreadTranId( int id) {
      threadTranId.set(new Integer(id));   	
   }         
   public int getTranId() {
      return tranId;
   }         
   public void setTranId( int id) {
      tranId = id;
   }    
}       
        
