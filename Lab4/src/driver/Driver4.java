//============================================================================
// Project     : Lab4
// Name        : Driver4.java
// Author      : Tianqi Yang
// Time        : 5/9/2019
// IDE         : Eclipse
// Description : It is the fourth driver of the project which test the thread
// and synchronized
//============================================================================
package driver;

import adapter.BuildAuto;
import adapter.EditInterface;

public class Driver4 {
	public static void main(String[] args) {	
		BuildAuto a1 = new BuildAuto();
		a1.BuildAuto("Car1.txt");
		
        EditInterface editThread1 = new BuildAuto();   
        EditInterface editThread2 = new BuildAuto();
        
        //show non-synchronized
		System.out.println("==============================================\nTesting non-synchronized\n");
		System.out.println("Update price of automatic to 1111");
		editThread2.editOptionPrice(2, "ZTW", "Transmission", "Automatic", 1111);
		System.out.println("Update price of automatic to 2222");
		editThread2.editOptionPrice(2, "ZTW", "Transmission", "Automatic", 2222);
        //show synchronized
		try {
			Thread.sleep(100);
			System.out.println("==============================================\nTesting synchronized\n");
			System.out.println("Update price of automatic to 3333");
			editThread2.editOptionPrice(2, "ZTW", "Transmission", "Automatic", 3333);
			Thread.sleep(100);
			System.out.println("Update price of automatic to 4444");
			editThread2.editOptionPrice(2, "ZTW", "Transmission", "Automatic", 4444);
			Thread.sleep(100);
			System.out.println("==============================================\nTesting other methods\n");
			//testing other methods
			System.out.println("Update option set name: color to Deceptive Appearance");
			editThread1.editOptionSetName(0, "ZTW", "Color", "Deceptive Appearance");
			Thread.sleep(100);
			System.out.println("Update Sangria Red Clearcoat Metallic to Red");
			editThread2.editOptionName(1, "ZTW", "Deceptive Appearance", "Sangria Red Clearcoat Metallic", "Red");
			Thread.sleep(100);
			System.out.println("Update price of automatic to 5555");
			editThread2.editOptionPrice(2, "ZTW", "Transmission", "Automatic", 5555);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
/*
=====================================================
Testing non-synchronized

Update price of automatic to 1111
Update price of automatic to 2222
Thread-0 started 
Thread-1 started 
Thread-1 completed.
Print result:
Thread-0 completed.
Print result:
Model Make:                               Ford
Model Name:                                ZTW
Year:                                     2014
Base Price:                           18555.00

Color
----------------------------------------------
Options:                                   Fee
 1.Fort Knox Gold Clearcoat Metallic      0.00
 2.Liquid Grey Clearcoat Metallic         0.00
 3.Infra-Red Clearcoat                    0.00
 4.Grabber Green Clearcoat Metallic       0.00
 5.Sangria Red Clearcoat Metallic         0.00
 6.French Blue Clearcoat Metallic         0.00
 7.Twilight Blue Clearcoat Metallic       0.00
 8.CD Silver Clearcoat Metallic           0.00
 9.Pitch Black Clearcoat                  0.00
10.Cloud 9 White Clearcoat                0.00

Transmission
----------------------------------------------
Options:                                   Fee
 1.Automatic                           2222.00
 2.Manual                              -815.00

Brakes/Traction Control
----------------------------------------------
Options:                                   Fee
 1.Standard                               0.00
 2.ABS                                  400.00
 3.ABS with Advance Trac               1625.00

Side Impact Air Bags
----------------------------------------------
Options:                                   Fee
 1.Present                              350.00
 2.Not Present                            0.00

Power Moonroof
----------------------------------------------
Options:                                   Fee
 1.Present                              595.00
 2.Not Present                            0.00


Model Make:                               Ford
Model Name:                                ZTW
Year:                                     2014
Base Price:                           18555.00

Color
----------------------------------------------
Options:                                   Fee
 1.Fort Knox Gold Clearcoat Metallic      0.00
 2.Liquid Grey Clearcoat Metallic         0.00
 3.Infra-Red Clearcoat                    0.00
 4.Grabber Green Clearcoat Metallic       0.00
 5.Sangria Red Clearcoat Metallic         0.00
 6.French Blue Clearcoat Metallic         0.00
 7.Twilight Blue Clearcoat Metallic       0.00
 8.CD Silver Clearcoat Metallic           0.00
 9.Pitch Black Clearcoat                  0.00
10.Cloud 9 White Clearcoat                0.00

Transmission
----------------------------------------------
Options:                                   Fee
 1.Automatic                           2222.00
 2.Manual                              -815.00

Brakes/Traction Control
----------------------------------------------
Options:                                   Fee
 1.Standard                               0.00
 2.ABS                                  400.00
 3.ABS with Advance Trac               1625.00

Side Impact Air Bags
----------------------------------------------
Options:                                   Fee
 1.Present                              350.00
 2.Not Present                            0.00

Power Moonroof
----------------------------------------------
Options:                                   Fee
 1.Present                              595.00
 2.Not Present                            0.00




=====================================================
Testing synchronized

Update price of automatic to 3333
Thread-2 started 
Thread-2 completed.
Print result:
Model Make:                               Ford
Model Name:                                ZTW
Year:                                     2014
Base Price:                           18555.00

Color
----------------------------------------------
Options:                                   Fee
 1.Fort Knox Gold Clearcoat Metallic      0.00
 2.Liquid Grey Clearcoat Metallic         0.00
 3.Infra-Red Clearcoat                    0.00
 4.Grabber Green Clearcoat Metallic       0.00
 5.Sangria Red Clearcoat Metallic         0.00
 6.French Blue Clearcoat Metallic         0.00
 7.Twilight Blue Clearcoat Metallic       0.00
 8.CD Silver Clearcoat Metallic           0.00
 9.Pitch Black Clearcoat                  0.00
10.Cloud 9 White Clearcoat                0.00

Transmission
----------------------------------------------
Options:                                   Fee
 1.Automatic                           3333.00
 2.Manual                              -815.00

Brakes/Traction Control
----------------------------------------------
Options:                                   Fee
 1.Standard                               0.00
 2.ABS                                  400.00
 3.ABS with Advance Trac               1625.00

Side Impact Air Bags
----------------------------------------------
Options:                                   Fee
 1.Present                              350.00
 2.Not Present                            0.00

Power Moonroof
----------------------------------------------
Options:                                   Fee
 1.Present                              595.00
 2.Not Present                            0.00



Update price of automatic to 4444
Thread-3 started 
Thread-3 completed.
Print result:
Model Make:                               Ford
Model Name:                                ZTW
Year:                                     2014
Base Price:                           18555.00

Color
----------------------------------------------
Options:                                   Fee
 1.Fort Knox Gold Clearcoat Metallic      0.00
 2.Liquid Grey Clearcoat Metallic         0.00
 3.Infra-Red Clearcoat                    0.00
 4.Grabber Green Clearcoat Metallic       0.00
 5.Sangria Red Clearcoat Metallic         0.00
 6.French Blue Clearcoat Metallic         0.00
 7.Twilight Blue Clearcoat Metallic       0.00
 8.CD Silver Clearcoat Metallic           0.00
 9.Pitch Black Clearcoat                  0.00
10.Cloud 9 White Clearcoat                0.00

Transmission
----------------------------------------------
Options:                                   Fee
 1.Automatic                           4444.00
 2.Manual                              -815.00

Brakes/Traction Control
----------------------------------------------
Options:                                   Fee
 1.Standard                               0.00
 2.ABS                                  400.00
 3.ABS with Advance Trac               1625.00

Side Impact Air Bags
----------------------------------------------
Options:                                   Fee
 1.Present                              350.00
 2.Not Present                            0.00

Power Moonroof
----------------------------------------------
Options:                                   Fee
 1.Present                              595.00
 2.Not Present                            0.00



=====================================================
Testing other methods

Update option set name: color to Deceptive Appearance
Update Sangria Red Clearcoat Metallic to Red
Thread-4 started 
Update price of automatic to 2000
Thread-4 completed.
Print result:
Thread-5 started 
Thread-5 completed.
Print result:
Thread-6 started 
Thread-6 completed.
Print result:
Model Make:                               Ford
Model Name:                                ZTW
Year:                                     2014
Base Price:                           18555.00

Deceptive Appearance
----------------------------------------------
Options:                                   Fee
 1.Fort Knox Gold Clearcoat Metallic      0.00
 2.Liquid Grey Clearcoat Metallic         0.00
 3.Infra-Red Clearcoat                    0.00
 4.Grabber Green Clearcoat Metallic       0.00
 5.Red                                    0.00
 6.French Blue Clearcoat Metallic         0.00
 7.Twilight Blue Clearcoat Metallic       0.00
 8.CD Silver Clearcoat Metallic           0.00
 9.Pitch Black Clearcoat                  0.00
10.Cloud 9 White Clearcoat                0.00

Transmission
----------------------------------------------
Options:                                   Fee
 1.Automatic                           2000.00
 2.Manual                              -815.00

Brakes/Traction Control
----------------------------------------------
Options:                                   Fee
 1.Standard                               0.00
 2.ABS                                  400.00
 3.ABS with Advance Trac               1625.00

Side Impact Air Bags
----------------------------------------------
Options:                                   Fee
 1.Present                              350.00
 2.Not Present                            0.00

Power Moonroof
----------------------------------------------
Options:                                   Fee
 1.Present                              595.00
 2.Not Present                            0.00



Model Make:                               Ford
Model Name:                                ZTW
Year:                                     2014
Base Price:                           18555.00

Deceptive Appearance
----------------------------------------------
Options:                                   Fee
 1.Fort Knox Gold Clearcoat Metallic      0.00
 2.Liquid Grey Clearcoat Metallic         0.00
 3.Infra-Red Clearcoat                    0.00
 4.Grabber Green Clearcoat Metallic       0.00
 5.Red                                    0.00
 6.French Blue Clearcoat Metallic         0.00
 7.Twilight Blue Clearcoat Metallic       0.00
 8.CD Silver Clearcoat Metallic           0.00
 9.Pitch Black Clearcoat                  0.00
10.Cloud 9 White Clearcoat                0.00

Transmission
----------------------------------------------
Options:                                   Fee
 1.Automatic                           2000.00
 2.Manual                              -815.00

Brakes/Traction Control
----------------------------------------------
Options:                                   Fee
 1.Standard                               0.00
 2.ABS                                  400.00
 3.ABS with Advance Trac               1625.00

Side Impact Air Bags
----------------------------------------------
Options:                                   Fee
 1.Present                              350.00
 2.Not Present                            0.00

Power Moonroof
----------------------------------------------
Options:                                   Fee
 1.Present                              595.00
 2.Not Present                            0.00



Model Make:                               Ford
Model Name:                                ZTW
Year:                                     2014
Base Price:                           18555.00

Deceptive Appearance
----------------------------------------------
Options:                                   Fee
 1.Fort Knox Gold Clearcoat Metallic      0.00
 2.Liquid Grey Clearcoat Metallic         0.00
 3.Infra-Red Clearcoat                    0.00
 4.Grabber Green Clearcoat Metallic       0.00
 5.Red                                    0.00
 6.French Blue Clearcoat Metallic         0.00
 7.Twilight Blue Clearcoat Metallic       0.00
 8.CD Silver Clearcoat Metallic           0.00
 9.Pitch Black Clearcoat                  0.00
10.Cloud 9 White Clearcoat                0.00

Transmission
----------------------------------------------
Options:                                   Fee
 1.Automatic                           2000.00
 2.Manual                              -815.00

Brakes/Traction Control
----------------------------------------------
Options:                                   Fee
 1.Standard                               0.00
 2.ABS                                  400.00
 3.ABS with Advance Trac               1625.00

Side Impact Air Bags
----------------------------------------------
Options:                                   Fee
 1.Present                              350.00
 2.Not Present                            0.00

Power Moonroof
----------------------------------------------
Options:                                   Fee
 1.Present                              595.00
 2.Not Present                            0.00



*/