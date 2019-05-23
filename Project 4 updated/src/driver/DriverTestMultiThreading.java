package driver;

import scale.EditInterface;
import adapter.BuildAuto;

public class DriverTestMultiThreading {
    
    public static void main(String[] args) {
            
        BuildAuto buildAuto = new BuildAuto();
        buildAuto.buildAuto("auto_info.txt");
        
        EditInterface editThread1 = new BuildAuto();   
        EditInterface editThread2 = new BuildAuto();

        try {
            System.out.println("Update 8-speed Transmission: present to 5000");
            editThread1.editOptionValue("Sedan", "Transmission", "automatic", 5000.0);
            Thread.sleep(100);
            System.out.println("Update 8-speed Transmission: present to 2000");
            editThread2.editOptionValue("Sedan", "Transmission", "automatic", 2000.0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        
    }
}
