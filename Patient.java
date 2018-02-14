/*
 * Patient is a Helper Class 
 * This class is used to declare parameters 
 * for the Patients from HashTable.java 
 * Mainly getting and setter methods
 
 */
public class Patient {
	private String value;
	private int key;
	private Patient next;

	// Method will initial values

	Patient(String value, int key) {
		this.key = key;
		this.value = value;
		this.next = null;
	}

	// Method will return value
	public String getValue() {
		return value;
	}

	//Method will set value
	//Doesn't return value
	public void setValue(String value) {
		this.value = value;
	}

	//Method will get Key when called on
	public int getKey() {
		return key;
	}

	//Method will get next value when called
	public Patient getNext() {
		return next;
	}

	//Method will set Next value 
	public void setNext(Patient next) {
		this.next = next;
	}

	//Convert values into String Type
	public String toString() {
		String s = key + ", " + value;
		return s;
	}

}
