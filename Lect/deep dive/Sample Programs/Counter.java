import java.io.Serializable;

public class Counter implements Serializable{

  // Initialize the bean on creation
  int count = 0;

  // Parameterless Constructor
  public Counter() {

  }

  // Property Getter
  public int getCount() {

    // Increment the count property, with every request
    count++;

    return this.count;
  }

  // Property Setter
  public void setCount(int count) {

    this.count = count;
  }
}

