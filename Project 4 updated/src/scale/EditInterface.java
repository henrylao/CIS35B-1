package scale;

public interface EditInterface {
    public void editOptionSetName(String model, String name, String newName);
    public void editOptionName(String model, String optionSetName, String optionName, String newOptionName);
    public void editOptionValue(String model, String optionSetName, String optionName, double newValue);
}
