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
        EditInterface editThread3 = new BuildAuto();   
        EditInterface editThread4 = new BuildAuto();
        EditInterface editThread5 = new BuildAuto();   
        EditInterface editThread6 = new BuildAuto();
        EditInterface editThread7 = new BuildAuto();   
        EditInterface editThread8 = new BuildAuto();
        EditInterface editThread9 = new BuildAuto();

        //show synchronized
		try {
			 
	        //show non-synchronized
			System.out.println("==============================================\nTesting non-synchronized changing option name");
			System.out.println("Update set name of automatic: Standard to Noraml");
			editThread1.editOptionName(3, "ZTW", "Brakes/Traction Control", "Standard", "Normal");
			System.out.println("Update set name of automatic: Standard to Advanced");
			editThread2.editOptionName(3, "ZTW", "Brakes/Traction Control", "Standard", "Advanced");
			//should only change to Normal but it changed to Normal so it failed
			Thread.sleep(100);
			System.out.println("==============================================\nTesting non-synchronized changing option price");
			System.out.println("Update Automatic price of automatic to 1111");
			editThread3.editOptionPrice(4, "ZTW", "Transmission", "Automatic", 1111);
			System.out.println("Update Automatic price of automatic to 2222");
			editThread4.editOptionPrice(4, "ZTW", "Transmission", "Automatic", 2222);
			Thread.sleep(100);
			System.out.println("==============================================\nTesting synchronized changing option name \n");
			System.out.println("Update Present to Has in Side Impacet Air Bigs");
			editThread5.editOptionName(1, "ZTW", "Side Impact Air Bags", "Present", "Has");
			System.out.println("Update should fail");
			editThread6.editOptionName(1, "ZTW", "Side Impact Air Bags", "Present", "haha");
			Thread.sleep(100);
			System.out.println("==============================================\nTesting synchronized changning option price\n");
			System.out.println("Update price of automatic to 4444");
			editThread7.editOptionPrice(2, "ZTW", "Transmission", "Automatic", 4444);
			System.out.println("Update price of automatic to 5555");
			editThread8.editOptionPrice(2, "ZTW", "Transmission", "Automatic", 5555);
			Thread.sleep(100);
			System.out.println("==============================================\nTesting other methods\n");
			//testing other methods
			System.out.println("Update option set name: color to Deceptive Appearance");
			editThread9.editOptionSetName(0, "ZTW", "Color", "Deceptive Appearance");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
/*
==============================================
Testing non-synchronized changing option name
Update set name of automatic: Standard to Noraml
Update set name of automatic: Standard to Advanced
Start thread 3
Start thread 3
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
 1.Automatic                              0.00
 2.Manual                              -815.00

Brakes/Traction Control
----------------------------------------------
Options:                                   Fee
 1.Advanced                               0.00
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



Stopping thread 3
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
 1.Automatic                              0.00
 2.Manual                              -815.00

Brakes/Traction Control
----------------------------------------------
Options:                                   Fee
 1.Advanced                               0.00
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



Stopping thread 3
==============================================
Testing non-synchronized changing option price
Update Automatic price of automatic to 1111
Update Automatic price of automatic to 2222
Start thread 4
Start thread 4
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
 1.Advanced                               0.00
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



Stopping thread 4
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
 1.Advanced                               0.00
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



Stopping thread 4
==============================================
Testing synchronized changing option name 

Update Present to Has in Side Impacet Air Bigs
Update should fail
Start thread 1
Start thread 1
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
 1.Advanced                               0.00
 2.ABS                                  400.00
 3.ABS with Advance Trac               1625.00

Side Impact Air Bags
----------------------------------------------
Options:                                   Fee
 1.Has                                  350.00
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
 1.Advanced                               0.00
 2.ABS                                  400.00
 3.ABS with Advance Trac               1625.00

Side Impact Air Bags
----------------------------------------------
Options:                                   Fee
 1.Has                                  350.00
 2.Not Present                            0.00

Power Moonroof
----------------------------------------------
Options:                                   Fee
 1.Present                              595.00
 2.Not Present                            0.00



Stopping thread 1

Stopping thread 1
==============================================
Testing synchronized changning option price

Update price of automatic to 4444
Update price of automatic to 5555
Start thread 2
Start thread 2
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
 1.Automatic                           5555.00
 2.Manual                              -815.00

Brakes/Traction Control
----------------------------------------------
Options:                                   Fee
 1.Advanced                               0.00
 2.ABS                                  400.00
 3.ABS with Advance Trac               1625.00

Side Impact Air Bags
----------------------------------------------
Options:                                   Fee
 1.Has                                  350.00
 2.Not Present                            0.00

Power Moonroof
----------------------------------------------
Options:                                   Fee
 1.Present                              595.00
 2.Not Present                            0.00



Stopping thread 2
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
 1.Automatic                           5555.00
 2.Manual                              -815.00

Brakes/Traction Control
----------------------------------------------
Options:                                   Fee
 1.Advanced                               0.00
 2.ABS                                  400.00
 3.ABS with Advance Trac               1625.00

Side Impact Air Bags
----------------------------------------------
Options:                                   Fee
 1.Has                                  350.00
 2.Not Present                            0.00

Power Moonroof
----------------------------------------------
Options:                                   Fee
 1.Present                              595.00
 2.Not Present                            0.00



Stopping thread 2
==============================================
Testing other methods

Update option set name: color to Deceptive Appearance
Start thread 0
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
 5.Sangria Red Clearcoat Metallic         0.00
 6.French Blue Clearcoat Metallic         0.00
 7.Twilight Blue Clearcoat Metallic       0.00
 8.CD Silver Clearcoat Metallic           0.00
 9.Pitch Black Clearcoat                  0.00
10.Cloud 9 White Clearcoat                0.00

Transmission
----------------------------------------------
Options:                                   Fee
 1.Automatic                           5555.00
 2.Manual                              -815.00

Brakes/Traction Control
----------------------------------------------
Options:                                   Fee
 1.Advanced                               0.00
 2.ABS                                  400.00
 3.ABS with Advance Trac               1625.00

Side Impact Air Bags
----------------------------------------------
Options:                                   Fee
 1.Has                                  350.00
 2.Not Present                            0.00

Power Moonroof
----------------------------------------------
Options:                                   Fee
 1.Present                              595.00
 2.Not Present                            0.00



Stopping thread 0

*/