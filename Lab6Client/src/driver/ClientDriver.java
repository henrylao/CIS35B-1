//============================================================================
// Project     : Lab6
// Name        : ClientDriver.java
// Author      : Tianqi Yang
// Time        : 6/22/2019
// IDE         : Eclipse
// Description : it starts the client
//============================================================================
package driver;

import adapter.BuildAuto;
import client.AutoClient;

public class ClientDriver {
	public static void main(String[] args) {
		int port = 7777;
		//String host = "10.44.3.26";
		String host = "127.0.0.1";
		AutoClient client = new BuildAuto();
		client.client(host, port);
	}
}
//Testing upload three files and choice options for different automobile
/*
Connecting to host ... 
Connected to host, creating object streams ... 
Communicating with host ... 
Received server response ... 

Enter 1 to upload a new Automobile
Enter 2 to configure an Automobile
Enter 0 to terminate connection

Response to server: 
1
Sending 1 to server ... 

Received server response ... 
Upload a file to create an Automobile
Response to server: 
1.txt
Sending Ford,ZTW,2014,18555
0Color
Fort Knox Gold Clearcoat Metallic,0
Liquid Grey Clearcoat Metallic,0
Infra-Red Clearcoat,0
Grabber Green Clearcoat Metallic,0
Sangria Red Clearcoat Metallic,0
French Blue Clearcoat Metallic,0
Twilight Blue Clearcoat Metallic,0
CD Silver Clearcoat Metallic,0
Pitch Black Clearcoat,0
Cloud 9 White Clearcoat,0
0Transmission
Automatic,0
Manual,-815
0Brakes/Traction Control
Standard,0
ABS,400
ABS with Advance Trac,1625
0Side Impact Air Bags
Present,350
Not Present,0
0Power Moonroof
Present,595
Not Present,0 to server ... 

Received server response ... 
Automobile object successfully added to database
Press any key to return to main menu
Response to server: 

Sending  to server ... 

Received server response ... 

Enter 1 to upload a new Automobile
Enter 2 to configure an Automobile
Enter 0 to terminate connection

Response to server: 
1
Sending 1 to server ... 

Received server response ... 
Upload a file to create an Automobile
Response to server: 
2.prop
Sending {BasePrice=36200, 4b1=200, 1a1=0, 1d1=100, 4Wheels=, 3a1=0, 3b=19'', 3a=18'', 00=4, 30=2, Make=Tesla, 1b1=0, 1e1=100, Model=Model 3, 3b1=200, 1e=Red Multi-Coat, 1d=Pearl White Multi-Coat, 1c=Midnight Silver Metallic, 4baSport=Alloy, 1b=Deep Blue Metallic, 1a=Solid Black, 4a=Normal, 2a1=0, 10=5, 40=2, Year=2019, 4a1=0, 1c1=100, 2b=Single-Speed Fixed Gear, 2=Powertrain, 2a=AC Electric Motor, 1=Color, 3Tires=, 2b1=200, 20=2} to server ... 

Received server response ... 
Automobile object successfully added to database
Press any key to return to main menu
Response to server: 

Sending  to server ... 

Received server response ... 

Enter 1 to upload a new Automobile
Enter 2 to configure an Automobile
Enter 0 to terminate connection

Response to server: 
1
Sending 1 to server ... 

Received server response ... 
Upload a file to create an Automobile
Response to server: 
3.txt
Sending Tesla,Performance,2019,48950
0Color
Solid Black,0
Midnight Silver Metallic,1000
Deep Blue Metallic,1000
Pearl White Multi-Coat,1500
Red Multi-Coat,2000
0Wheel
18" Aero Wheels,0
0Premium Interior
All Black,0
Black and White,1000
0Autopilot
Present,0
0Full Self-Driving Capability
Present,6000
Not Present,0 to server ... 

Received server response ... 
Automobile object successfully added to database
Press any key to return to main menu
Response to server: 

Sending  to server ... 

Received server response ... 

Enter 1 to upload a new Automobile
Enter 2 to configure an Automobile
Enter 0 to terminate connection

Response to server: 
2
Sending 2 to server ... 

Received server response ... 
Select an Automobile from the following list to configure: 
1.ZTW
2.Model 3
3.Performance

Response to server: 
ZTW
Sending ZTW to server ... 

Received server response ... 
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


Choice one option:
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
----------------------------------------------
1

Choice one option:
Transmission
----------------------------------------------
Options:                                   Fee
 1.Automatic                              0.00
 2.Manual                              -815.00
----------------------------------------------
1

Choice one option:
Brakes/Traction Control
----------------------------------------------
Options:                                   Fee
 1.Standard                               0.00
 2.ABS                                  400.00
 3.ABS with Advance Trac               1625.00
----------------------------------------------
3

Choice one option:
Side Impact Air Bags
----------------------------------------------
Options:                                   Fee
 1.Present                              350.00
 2.Not Present                            0.00
----------------------------------------------
1

Choice one option:
Power Moonroof
----------------------------------------------
Options:                                   Fee
 1.Present                              595.00
 2.Not Present                            0.00
----------------------------------------------
1

Choices
----------------------------------------------
Optionset:                               Color
Fort Knox Gold Clearcoat Metallic         0.00
----------------------------------------------
Optionset:                        Transmission
Automatic                                 0.00
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
Total is: 21125.0
Press any key to return to main menu
Response to server: 

Sending  to server ... 

Received server response ... 

Enter 1 to upload a new Automobile
Enter 2 to configure an Automobile
Enter 0 to terminate connection

Response to server: 
2
Sending 2 to server ... 

Received server response ... 
Select an Automobile from the following list to configure: 
1.ZTW
2.Model 3
3.Performance

Response to server: 
Performance
Sending Performance to server ... 

Received server response ... 
Model Make:                              Tesla
Model Name:                        Performance
Year:                                     2019
Base Price:                           48950.00

Color
----------------------------------------------
Options:                                   Fee
 1.Solid Black                            0.00
 2.Midnight Silver Metallic            1000.00
 3.Deep Blue Metallic                  1000.00
 4.Pearl White Multi-Coat              1500.00
 5.Red Multi-Coat                      2000.00

Wheel
----------------------------------------------
Options:                                   Fee
 1.18" Aero Wheels                        0.00

Premium Interior
----------------------------------------------
Options:                                   Fee
 1.All Black                              0.00
 2.Black and White                     1000.00

Autopilot
----------------------------------------------
Options:                                   Fee
 1.Present                                0.00

Full Self-Driving Capability
----------------------------------------------
Options:                                   Fee
 1.Present                             6000.00
 2.Not Present                            0.00


Choice one option:
Color
----------------------------------------------
Options:                                   Fee
 1.Solid Black                            0.00
 2.Midnight Silver Metallic            1000.00
 3.Deep Blue Metallic                  1000.00
 4.Pearl White Multi-Coat              1500.00
 5.Red Multi-Coat                      2000.00
----------------------------------------------
5

Choice one option:
Wheel
----------------------------------------------
Options:                                   Fee
 1.18" Aero Wheels                        0.00
----------------------------------------------
1

Choice one option:
Premium Interior
----------------------------------------------
Options:                                   Fee
 1.All Black                              0.00
 2.Black and White                     1000.00
----------------------------------------------
2

Choice one option:
Autopilot
----------------------------------------------
Options:                                   Fee
 1.Present                                0.00
----------------------------------------------
1

Choice one option:
Full Self-Driving Capability
----------------------------------------------
Options:                                   Fee
 1.Present                             6000.00
 2.Not Present                            0.00
----------------------------------------------
1

Choices
----------------------------------------------
Optionset:                               Color
Red Multi-Coat                         2000.00
----------------------------------------------
Optionset:                               Wheel
18" Aero Wheels                           0.00
----------------------------------------------
Optionset:                    Premium Interior
Black and White                        1000.00
----------------------------------------------
Optionset:                           Autopilot
Present                                   0.00
----------------------------------------------
Optionset:        Full Self-Driving Capability
Present                                6000.00
----------------------------------------------
Total is: 57950.0
Press any key to return to main menu
Response to server: 

Sending  to server ... 

Received server response ... 

Enter 1 to upload a new Automobile
Enter 2 to configure an Automobile
Enter 0 to terminate connection

Response to server: 
0
Sending 0 to server ... 

Closing client input stream ... 
Closing client output stream ... 
Closing client console input stream ... 
Closing client socket ... 
*/