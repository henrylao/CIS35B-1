package adapter;

public interface Choice {
	public void setOptionChoice(String modelName, String optionSetName, String optionName);
	public void printChoices(String modelName);
	public float getTotal(String modelName);
}