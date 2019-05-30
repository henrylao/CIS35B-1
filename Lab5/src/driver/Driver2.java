//============================================================================
// Project     : Lab4
// Name        : Driver.java
// Author      : Tianqi Yang
// Time        : 4/18/2019
// IDE         : Eclipse
// Description : It is the driver of the project
//============================================================================
//package driver;
//import java.io.*;
//
//import adapter.*;
//
//public class Driver2 {
//	public static void main(String[] args) {	
//		//get errors 
//		CreateAuto a1 = new BuildAuto();
//		a1.BuildAuto("Car1.txt");
//		a1.printAuto(); 
//		UpdateAuto b1 = new BuildAuto();
//		b1.updateOptionSetName("FordZTW", "Color", "Deceptive Appearance");
//		b1.updateOptionPrice("FordZTW", "Transmission", "Automatic", 999);
//		//a1.printAuto();
//		//fixed errors
//		//get errors 
//		CreateAuto a2 = new BuildAuto();
//		a2.BuildAuto("Car1.txt");
//		a2.printAuto();
//		UpdateAuto b2 = new BuildAuto();
//		b2.updateOptionSetName("FordZTW", "Color", "Deceptive Appearance");
//		b2.updateOptionPrice("FordZTW", "Transmission", "Automatic", 999);
//		a2.printAuto();
//	}
//}
/*
 2019.05.02.22.37.31 FixProblems errorno = 1, errormsg = First line is not correct
Enter the modelName, baseprice, and optionSet size: FordZTW,18555,5
Color,  !!!This line is not complete
2019.05.02.22.37.39 FixProblems errorno = 2, errormsg = Cannot create optionSet
Enter the optionSet name, optionSet size: Color,10
Fort Knox Gold Clearcoat Metallic,  !!!This line is not complete
2019.05.02.22.37.44 FixProblems errorno = 3, errormsg = Cannot create option
Enter the option: Fort Knox Gold Clearcoat Metallic,0
 Model Name:                           FordZTW
 Base Price                           18555.00

 Color
 ---------------------------------------------
 Name                                      Fee
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
 ---------------------------------------------
 Name                                      Fee
 1.Automatic                            815.00
 2.Manual                                 0.00

 Brakes/Traction Control
 ---------------------------------------------
 Name                                      Fee
 1.Standard                               0.00
 2.ABS                                  400.00
 3.ABS with Advance Trac               1625.00

 Side Impact Air Bags
 ---------------------------------------------
 Name                                      Fee
 1.Present                                0.00
 2.Not Present                          350.00

 Power Moonroof
 ---------------------------------------------
 Name                                      Fee
 1.Present                                0.00
 2.Not Present                          595.00


UpdateOptionSetName fail, error number = 302
2019.05.02.22.37.52 FixProblems errorno = 1, errormsg = First line is not correct
Enter the modelName, baseprice, and optionSet size: FordZTW,18555,5
Color,  !!!This line is not complete
2019.05.02.22.38.37 FixProblems errorno = 2, errormsg = Cannot create optionSet
Enter the optionSet name, optionSet size: Color,10
Fort Knox Gold Clearcoat Metallic,  !!!This line is not complete
2019.05.02.22.38.44 FixProblems errorno = 3, errormsg = Cannot create option
Enter the option: Fort Knox Gold Clearcoat Metallic,0
Enter the correct optionSetname, newName: Color,Deceptive Appearance
 Model Name:                           FordZTW
 Base Price                           18555.00

 Deceptive Appearance
 ---------------------------------------------
 Name                                      Fee
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
 ---------------------------------------------
 Name                                      Fee
 1.Automatic                            815.00
 2.Manual                                 0.00

 Brakes/Traction Control
 ---------------------------------------------
 Name                                      Fee
 1.Standard                               0.00
 2.ABS                                  400.00
 3.ABS with Advance Trac               1625.00

 Side Impact Air Bags
 ---------------------------------------------
 Name                                      Fee
 1.Present                                0.00
 2.Not Present                          350.00

 Power Moonroof
 ---------------------------------------------
 Name                                      Fee
 1.Present                                0.00
 2.Not Present                          595.00


UpdateOptionSetName fail, error number = 302
 Model Name:                           FordZTW
 Base Price                           18555.00

 Deceptive Appearance
 ---------------------------------------------
 Name                                      Fee
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
 ---------------------------------------------
 Name                                      Fee
 1.Automatic                            999.00
 2.Manual                                 0.00

 Brakes/Traction Control
 ---------------------------------------------
 Name                                      Fee
 1.Standard                               0.00
 2.ABS                                  400.00
 3.ABS with Advance Trac               1625.00

 Side Impact Air Bags
 ---------------------------------------------
 Name                                      Fee
 1.Present                                0.00
 2.Not Present                          350.00

 Power Moonroof
 ---------------------------------------------
 Name                                      Fee
 1.Present                                0.00
 2.Not Present                          595.00



*/