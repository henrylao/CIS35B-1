package examples.threads; 
/** 
  * Enclosing and inner classes to demonstrate how  
  * to synchronize methods between them.
  */
public class Enclosing {
   private String name = "";
   /** get the name value
     * @return the name
     */
   public synchronized String getName() {
      return name;
   }
   /** set the name value
     * @param s the input name value
     */
   public synchronized void setName( String s ) {
      name = s;
   }
   /** Example inner class
     */
   public class Insider {
      /** convert the name to all upper case
        */
      public void upperCaseName() {
         synchronized( Enclosing.this ) {
            name = name.toUpperCase();
         }
      }
   }
   /** Test method for the class
     * @param args not used
     */
   public static void main( String[] args ) {
      Enclosing enc = new Enclosing();
      enc.setName( "Maria" );
      Insider ins = enc.new Insider();
      ins.upperCaseName();
      System.out.println( enc.getName() );
   }
}