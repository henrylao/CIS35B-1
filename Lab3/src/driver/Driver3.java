//============================================================================
// Project     : Lab3
// Name        : Driver3.java
// Author      : Tianqi Yang
// Time        : 5/9/2019
// IDE         : Eclipse
// Description : It is the thrid driver of the project
//============================================================================
package driver;

import adapter.BuildAuto;
import adapter.CreateAuto;
import adapter.Choice;
import adapter.UpdateAuto;

public class Driver3 {
	public static void main(String[] args) {	
		CreateAuto a1 = new BuildAuto();
		a1.BuildAuto("Car1.txt");
		a1.printAuto("ZTW"); 
		UpdateAuto b1 = new BuildAuto();
		b1.updateOptionSetName("ZTW", "Color", "Deceptive Appearance");
		b1.updateOptionPrice("ZTW", "Transmission", "Automatic", 999);
		a1.printAuto("ZTW"); 
		CreateAuto a2 = new BuildAuto();
		a2.BuildAuto("Car2.txt");
		a2.printAuto("Model 3"); 
		//testing make choice
		Choice c1 = new BuildAuto();
		c1.setOptionChoice("ZTW", "Deceptive Appearance", "Liquid Grey Clearcoat Metallic");
		c1.setOptionChoice("ZTW","Transmission","Automatic");
		c1.setOptionChoice("ZTW", "Brakes/Traction Control", "ABS with Advance Trac");
		c1.setOptionChoice("ZTW", "Side Impact Air Bags", "Present");
		c1.setOptionChoice("ZTW", "Power Moonroof", "Present");
		c1.printChoices("ZTW");
		//testing get total price
		System.out.print("Total price: ");
		System.out.println(c1.getTotal("ZTW"));
		//testing delete car1
		b1.deleteAuto("ZTW");
		a1.printAuto("ZTW");
		a2.printAuto("Model 3"); 
	}
}
/*
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
 5.Sangria Red Clearcoat Metallic         0.00
 6.French Blue Clearcoat Metallic         0.00
 7.Twilight Blue Clearcoat Metallic       0.00
 8.CD Silver Clearcoat Metallic           0.00
 9.Pitch Black Clearcoat                  0.00
10.Cloud 9 White Clearcoat                0.00

Transmission
----------------------------------------------
Options:                                   Fee
 1.Automatic                            999.00
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


Cannot find Model 3

Model Make:                              Tesla
Model Name:                            Model 3
Year:                                     2019
Base Price:                           36200.00

Color
----------------------------------------------
Options:                                   Fee
 1.Solid Black                            0.00
 2.Deep Blue Metallic                     0.00
 3.Midnight Silver Metallic             100.00
 4.Pearl White Multi-Coat               100.00
 5.Red Multi-Coat                       100.00

Powertrain
----------------------------------------------
Options:                                   Fee
 1.AC Electric Motor                      0.00
 2.Single-Speed Fixed Gear              200.00

Tires
----------------------------------------------
Options:                                   Fee
 1.18''                                   0.00
 2.19''                                 200.00

Wheels
----------------------------------------------
Options:                                   Fee
 1.Normal                                 0.00
 2.Sport Alloy                          200.00


Choices
----------------------------------------------
Optionset:                Deceptive Appearance
Liquid Grey Clearcoat Metallic            0.00
----------------------------------------------
Optionset:                        Transmission
Automatic                               999.00
----------------------------------------------
Optionset:             Brakes/Traction Control
ABS with Advance Trac                  1625.00
----------------------------------------------
Optionset:                Side Impact Air Bags
Present                                 350.00
----------------------------------------------
Optionset:                      Power Moonroof
Present                                 595.00
----------------------------------------------
Total price: 22124.0
Detele the car ZTW

Cannot find ZTW

Model Make:                              Tesla
Model Name:                            Model 3
Year:                                     2019
Base Price:                           36200.00

Color
----------------------------------------------
Options:                                   Fee
 1.Solid Black                            0.00
 2.Deep Blue Metallic                     0.00
 3.Midnight Silver Metallic             100.00
 4.Pearl White Multi-Coat               100.00
 5.Red Multi-Coat                       100.00

Powertrain
----------------------------------------------
Options:                                   Fee
 1.AC Electric Motor                      0.00
 2.Single-Speed Fixed Gear              200.00

Tires
----------------------------------------------
Options:                                   Fee
 1.18''                                   0.00
 2.19''                                 200.00

Wheels
----------------------------------------------
Options:                                   Fee
 1.Normal                                 0.00
 2.Sport Alloy                          200.00



*/