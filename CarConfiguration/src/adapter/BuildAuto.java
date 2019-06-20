//============================================================================
// Project     : Lab5
// Name        : BuildAuto.java
// Author      : Tianqi Yang
// Time        : 5/29/2019
// IDE         : Eclipse
// Description : BuildAuto is the child class of ProxyAUtomobile and implements
// tow interface that CreateAuto and UpdateAuto
//============================================================================
package adapter;

import client.AutoClient;
import scale.EditInterface;
import server.AutoServer;

public class BuildAuto extends ProxyAutomobile implements CreateAuto, UpdateAuto, FixAuto, Choice, EditInterface, AutoServer, AutoClient{


}