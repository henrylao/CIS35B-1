////************************************************************************************************
////USAGE OF wait() and notify() or notifyall()
//class coffee {
////not waiting on each other
//boolean available=false; //indicating there nothing to get.
//	int contents = 0;
//	public synchronized int get() {    // won't work!
//	    if (available == true) {
//        	available = false;
//        	return contents;
//    		}
//		return contents;
//     	}
//	public synchronized void put(int value) {    // won't work!
//	    if (available == false) {
//        		available = true;
//		        contents = value;
//    		}
//	}
//}
//
//
//class coffee7 {
//boolean available=false; //indicating there nothing to get.
////waiting on each other.
//int contents = 0;
//
//public synchronized int get() {
//    while (available == false) {
//        try {
//            // wait for Producer to put value
//            wait();
//        } catch (InterruptedException e) {
//        }
//    }
//    available = false;
//    // notify Producer that value has been retrieved
//    notifyAll();
//	return contents ;
//}
//public synchronized void put(int value) {
//    while (available == true) {
//        try {
//            // wait for Consumer to get value
//            wait();
//        } catch (InterruptedException e) {
//        }
//    }
//    contents = value;
//    available = true;
//    // notify Consumer that value has been set
//    notifyAll();
// } 
//}
