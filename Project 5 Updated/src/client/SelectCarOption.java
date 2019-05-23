package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import model.Automobile;
import model.OptionSet;

public class SelectCarOption {
    public void configure(Automobile automobile) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(OptionSet opset: automobile.getOpset()) {
            System.out.println(opset.toString());
            System.out.print("Select one option: ");
            String option = null;
            try {
                option = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            automobile.setOptionChoice(opset, option);
        }
        automobile.print();
    }
}
