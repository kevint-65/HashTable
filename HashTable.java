import java.util.*;

public class HashTable {

	Patient[] patientArray;

	HashTable() {

		patientArray = new Patient[11];

		for (int i = 0; i < 11; i++) {
			patientArray[i] = null;
		}
	}

	public void insert(Patient patient) {
		if (patientArray[hashMethod(patient.getKey())] == null) {
			patientArray[hashMethod(patient.getKey())] = patient;
		} else {
			Patient newPatient = patientArray[hashMethod(patient.getKey())];
			while (newPatient.getNext() != null) {
				newPatient = newPatient.getNext();
			}

			newPatient.setNext(patient);
		}

	}

	public void HashDelete(Patient patient) {

		if (patientArray[hashMethod(patient.getKey())] != null) {
			Patient oldPatient = null;
			Patient nextPatient = patientArray[hashMethod(patient.getKey())];
			while (nextPatient.getNext() != null && nextPatient.getKey() != oldPatient.getKey()) {

				oldPatient = nextPatient;
				nextPatient = nextPatient.getNext();
			}
			if (nextPatient.getKey() == patient.getKey()) {
				if (oldPatient == null) {
					patientArray[hashMethod(patient.getKey())] = nextPatient.getNext();
				} else {
					oldPatient.setNext(nextPatient.getNext());
				}
			}
		}
	}

	public Patient HashSearch(int key) {
		Patient hashIndex = patientArray[hashMethod(key)];
		while (hashIndex != null) {
			if (hashIndex.getKey() == key) {
				System.out.println("Patient: " + hashIndex.getValue());
				return hashIndex;

			}
			hashIndex = hashIndex.getNext();
		}
		System.out.println("Try Again: Could not find: ");
		return null;
	}

	public int hashMethod(Integer hashValue) {

		int x = hashValue.hashCode();
		x %= 11;
		if (x < 0) {
			x = x + 1;
		}
		return x;

	}

	public void displayHashTable() {

		System.out.println("|Priority Number Patient Name| \n");
		for (int i = 0; i < patientArray.length; i++) {
			System.out.print("Index " + i + ": ");
			Patient value = patientArray[i];
			while (value != null) {
				System.out.print("|Priority: " + value.getKey() + " Name: "
						+ "" +  value.getValue() + "|  ----> ");
				value = value.getNext();
			}
			System.out.println();
		}
	}


}
