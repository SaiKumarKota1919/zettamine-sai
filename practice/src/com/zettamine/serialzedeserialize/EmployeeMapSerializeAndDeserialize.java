package com.zettamine.serialzedeserialize;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class EmployeeMapSerializeAndDeserialize {
	private static final String FILEPATH = "C:\\Users\\Kota Sai Kumr\\Desktop\\employee\\serializedata.ser";

	public static void main(String[] args) {

		Map<Employee, Set<Certification>> empMap = new TreeMap<>();

		Certification azureFundamentals = new Certification(125, "AZ-900", 1);
		Certification azureIot = new Certification(121, "AZ-220", 2);
		Certification azureSupportEngineer = new Certification(120, "AZ-720", 3);
		Certification azureDataFund = new Certification(122, "DP-900", 3);

		empMap.put(new ContractEmployee(1001, 201, "vijay", 10), getCertificationsSet());
		empMap.put(new ContractEmployee(1002, 202, "surya", 20),
				getCertificationsSet(azureDataFund, azureIot, azureIot));
		empMap.put(new ContractEmployee(1003, 203, "karthik", 10), getCertificationsSet(azureSupportEngineer));

		empMap.put(new RegularEmployee("101516R21", 301, "raja", 20), getCertificationsSet());
		empMap.put(new RegularEmployee("101517u32", 302, "akhil", 20),
				getCertificationsSet(azureDataFund, azureFundamentals, azureIot, azureSupportEngineer));
		empMap.put(new RegularEmployee("101519T49", 303, "rafi", 10), getCertificationsSet(azureIot));


		try (FileInputStream fileInputStream = new FileInputStream(FILEPATH);
				ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
				FileOutputStream fileOutputStream = new FileOutputStream(FILEPATH);
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
			
			serializeData(empMap, objectOutputStream);

			System.out.println("After performing deserialization the data is: ");

			for (Map.Entry<Employee, Set<Certification>> deserializedMapEntry : getDeserializedData(objectInputStream)
					.entrySet()) 
			{
				System.out.println(deserializedMapEntry.getKey() + " : " + deserializedMapEntry.getValue());
				System.out.println();
		}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}

	}

	
	private static Map<Employee, Set<Certification>> getDeserializedData(ObjectInputStream objectInputStream)
			throws ClassNotFoundException, IOException {

		Object object = objectInputStream.readObject();
		
		return (Map<Employee, Set<Certification>>)object;
	}

	private static void serializeData(Map<Employee, Set<Certification>> empMap, ObjectOutputStream objectOutputStream)
			throws IOException {
		objectOutputStream.writeObject(empMap);
		System.out.println("serialization completed");
	}

	private static Set<Certification> getCertificationsSet(Certification... cert) {

		Set<Certification> certificationsSet = new TreeSet<Certification>();

		for (Certification c : cert) {
			certificationsSet.add(c);
		}

		return certificationsSet;
	}

}
