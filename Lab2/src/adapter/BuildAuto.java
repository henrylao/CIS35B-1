//============================================================================
// Project     : Lab2
// Name        : BuildAuto.java
// Author      : Tianqi Yang
// Time        : 4/18/2019
// IDE         : Eclipse
// Description : BuildAuto is the child class of ProxyAUtomobile and implements
// tow interface that CreateAuto and UpdateAuto
//============================================================================
package adapter;

import java.io.IOException;

public class BuildAuto extends ProxyAutomobile implements CreateAuto, UpdateAuto, FixAuto{

}