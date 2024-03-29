class Program5{
   public static void main( String[ ] args ) {
      new MyThread( "foo" ).start();
      new MyThread( "bar" ).start();
   }
}
class MyThread extends Thread {
   public MyThread( String name ) { super( name ); }
   public void run() {
      while ( true )
         if ( getName().equalsIgnoreCase( "foo" ) )
           fooM();
         else
           barM();
   }
   private synchronized void fooM() {
      System.out.println( getName() + " entering fooM." );
      while ( getName().equalsIgnoreCase( "bar" ) )
        try {
           wait(); // wait indefinitely
        } catch( InterruptedException e ) { }
      barM();  // invoke other synchronized method
      System.out.println( getName() + " exiting fooM." );
      notify(); // awaken the other thread, if it's waiting
   }
   private synchronized void barM() {
      System.out.println( getName() + " entering barM." );
      while ( getName().equalsIgnoreCase( "foo" ) )
        try {
           wait(); // wait indefinitely
        } catch( InterruptedException e ) { }
      fooM();  // invoke other synchronized method
      System.out.println( getName() + " exiting barM." );
      notify(); // awaken the other thread, if it's waiting
   }
}
