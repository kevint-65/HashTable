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

	public static void main(String[] args) {

		HashTable hashTable = new HashTable();
		Random random = new Random();
		Scanner scanner = new Scanner(System.in);
		int input = 1;

		hashTable.insert(new Patient("Dr. Wu           ", random.nextInt(10000)));
		hashTable.insert(new Patient("Bedi Pranika     ", random.nextInt(10000)));
		hashTable.insert(new Patient("Ronald Green     ", random.nextInt(10000)));
		hashTable.insert(new Patient("Kevin Tieu       ", random.nextInt(10000)));
		hashTable.insert(new Patient("Allan Ho         ", random.nextInt(10000)));
		hashTable.insert(new Patient("Timonthy Ho      ", random.nextInt(10000)));
		hashTable.insert(new Patient("Axel Hugo        ", random.nextInt(10000)));
		hashTable.insert(new Patient("Justin Leinbach  ", random.nextInt(10000)));
		hashTable.insert(new Patient("Alex Len         ", random.nextInt(10000)));
		hashTable.insert(new Patient("Anish Patel      ", random.nextInt(10000)));
		hashTable.insert(new Patient("Parth Patel      ", random.nextInt(10000)));
		hashTable.insert(new Patient("Minh Phan        ", random.nextInt(10000)));
		hashTable.insert(new Patient("Tommy Phan       ", random.nextInt(10000)));
		hashTable.insert(new Patient("Luis Reyes       ", random.nextInt(10000)));
		hashTable.insert(new Patient("Paras Segal      ", random.nextInt(10000)));
		hashTable.insert(new Patient("Karan Sheth      ", random.nextInt(10000)));
		hashTable.insert(new Patient("Yuta Sugiura     ", random.nextInt(10000)));
		hashTable.insert(new Patient("Tong Hung        ", random.nextInt(10000)));
		hashTable.insert(new Patient("Solbi You        ", random.nextInt(10000)));
		hashTable.insert(new Patient("John McGinley    ", random.nextInt(10000)));

		while (input != 5) {

			System.out.println("\n1: Diplay Hash Table: ");
			System.out.println("2: Insert Patient: ");
			System.out.println("3: Delete Patien: ");
			System.out.println("4: Search Patient: ");
			System.out.println("5: Exit Program: ");
			System.out.println("Please Select Option: ");

			input = scanner.nextInt();
			if (input == 1) {
				System.out.println("You Entered: " + input + "\n");
				hashTable.displayHashTable();
				System.out.println();
			}

			else if (input == 2) {
				System.out.println("You Entered: " + input + "\n");
				System.out.println("Enter Patient Name: ");
				String name = scanner.next();
				System.out.println("Patient Name: " + name + scanner.nextLine());
				int key = (random.nextInt(100000) + 1);
				hashTable.insert(new Patient(name, key));
				System.out.println("\nPatient: " + name + " has been inserted");
				System.out.println("Hash Value: " + key + "\n");
				System.out.println("Hash Table \n");
				hashTable.displayHashTable();
			}

			else if (input == 3) {

				System.out.println("Enter the patient's name: ");
				String name = scanner.next();
				System.out.println("Patient Name: " + name + scanner.nextLine());
				System.out.println("Enter Patient Key: ");
				int dValue = scanner.nextInt();
				hashTable.HashDelete(new Patient(name, dValue));
				hashTable.displayHashTable();

			}

			else if (input == 4) {
				System.out.println("You Entered: " + input + "\n");
				System.out.println("Enter Priority Number: ");
				int num = scanner.nextInt();
				hashTable.HashSearch(num);
				System.out.println("Priority Number: " + num + "\n");

			}

			else {
				System.out.println("You Entered: " + input + "\n");
				System.out.println("Thank you for your time");
				scanner.close();

			}

		}
	}

}
