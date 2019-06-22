//============================================================================
// Project     : Lab6
// Name        : ServerDriver.java
// Author      : Tianqi Yang
// Time        : 6/22/2019
// IDE         : Eclipse
// Description : it starts the Server
//============================================================================
package driver;

import adapter.BuildAuto;
import server.AutoServer;

public class ServerDriver {
	public static void main(String[] args) {
		int port = 7777;
		AutoServer serve = new BuildAuto();
		serve.serve(port);
	}
}
/*
Start server.
/127.0.0.1
Creating server object streams ... 
Sending client interaction choices ... 
Reading client request ... 
1
Sending client request follow-up ... 
Waiting for client to upload file ... 
Ford,ZTW,2014,18555
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
Not Present,0
Adding new Automobile to database ... 
Sending client interaction choices ... 
Reading client request ... 
1
Sending client request follow-up ... 
Waiting for client to upload file ... 
{BasePrice=36200, 4b1=200, 1a1=0, 1d1=100, 4Wheels=, 3a1=0, 3b=19'', 3a=18'', 00=4, 30=2, Make=Tesla, 1b1=0, 1e1=100, Model=Model 3, 3b1=200, 1e=Red Multi-Coat, 1d=Pearl White Multi-Coat, 1c=Midnight Silver Metallic, 4baSport=Alloy, 1b=Deep Blue Metallic, 1a=Solid Black, 4a=Normal, 2a1=0, 10=5, 40=2, Year=2019, 4a1=0, 1c1=100, 2b=Single-Speed Fixed Gear, 2=Powertrain, 2a=AC Electric Motor, 1=Color, 3Tires=, 2b1=200, 20=2}
Adding new Automobile to database ... 
Sending client interaction choices ... 
Reading client request ... 
1
Sending client request follow-up ... 
Waiting for client to upload file ... 
Tesla,Performance,2019,48950
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
Not Present,0
Adding new Automobile to database ... 
Sending client interaction choices ... 
Reading client request ... 
2
Sending client request follow-up ... 
Waiting for client to select Automobile ... 
Sending Automobile object to client ... 
Sending client interaction choices ... 
Reading client request ... 
2
Sending client request follow-up ... 
Waiting for client to select Automobile ... 
Sending Automobile object to client ... 
Sending client interaction choices ... 
Reading client request ... 
0
Closing server input stream for client /127.0.0.1 ... 
Closing server output stream for client /127.0.0.1 ... 
Closing client socket /127.0.0.1 ... 
*/