package examples.threads;

import java.io.*;

/** 
  * A class to demonstrate threads and piped streams
  */
public class PlumbingThreads implements Runnable {

   private PipedInputStream pipeIn;
   private PipedOutputStream pipeOut;

   /** Create a PlumbingThreads object to connect with 
     * an existing PipedOutputStream
     */
   public PlumbingThreads( PipedOutputStream p ) {
      pipeOut = p;
   }

   /** Create a PlumbingThreads object to connect with
     * an existing PipedInputStream
     */
   public PlumbingThreads( PipedInputStream p ) {
      pipeIn = p;
   }

   /** Read from standard input and echo
     * the characters to the output pipe
     * @exception IOException general I/O error
     */
   public void sendKeystrokes() throws IOException {
      int c;
      while ( ( c = System.in.read() ) != -1 ) {
         pipeOut.write( c );
      }
      pipeOut.close();
   }

   /** Read characters from the input pipe
     * and echo them to standard out
     * @exception IOException general I/O error
     */
   public void receiveKeystrokes() throws IOException {
      int c;
      while ( ( c = pipeIn.read() ) != -1 ) {
         System.out.write( c );
      }
      pipeIn.close();
   }

   /** The workings of the threads
     */
   public void run() {
      try {
         // determine if this an input or
         // output thread and go to work
         if ( pipeIn != null ) {
            receiveKeystrokes();
         } else if ( pipeOut != null ) {
            sendKeystrokes();
         }
      } catch ( IOException ioe ) {
         System.err.println( ioe );
      }
   }

   /** The test method for the class
     * @param args not used
     */
   public static void main( String[] args ) {
      try {
         // create the input and output pipes
         PipedInputStream istream
            = new PipedInputStream();
         PipedOutputStream ostream
            = new PipedOutputStream( istream );

         // construct the plumbing threads, 
         // specifying the newly created pipes
         PlumbingThreads in
            = new PlumbingThreads( istream );
         PlumbingThreads out
            = new PlumbingThreads( ostream );

         // put the threads into separate groups
         ThreadGroup inputGroup
            = new ThreadGroup( "input thread group");
         ThreadGroup outputGroup
            = new ThreadGroup( "output thread group");

         // construct threads with existing
         // plumbing threads
         Thread inputThread
            = new Thread( inputGroup, in,
                          "input pipe" );
         Thread outputThread
            = new Thread( outputGroup, out,
                          "output pipe" );

         // start the threads and let them go!
         inputThread.start();
         outputThread.start();
      } catch ( IOException ioe ) {
         System.err.println( ioe );
      }
   }
}