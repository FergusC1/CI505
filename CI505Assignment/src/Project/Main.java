package Project;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
public class Main {
	public static void main(String[] args) {
		
		List<studentRecords> students = List.of(
				new studentRecords(
					"Hervey",
					"Hale",
					01,
					04,
					2004,
					1,
					"Philosophy",
					"Thinking"	
						),
				new studentRecords(
						"Roxy",
						"Burns",
						21,
						11,
						2003,
						2,
						"Music",
						"Drums"
						),
				new studentRecords(
						"Rory",
						"Stanley",
						9,
						8,
						2002,
						3,
						"Computer_Science",
						"Games Design"
						),
				new studentRecords(
						"Roger",
						"Burns",
						21,
						11,
						2003,
						4,
						"Computer_Science",
						"AI"
						),
				new studentRecords(
						"Douglas",
						"Mondy",
						01,
						12,
						2006,
						5,
						"Computer_Science",
						"AI"
						),
				
				new studentRecords(
						"Arvel",
						"Attaway",
						14,
						03,
						2004,
						6,
						"Computer_Science",
						"Games Design"
						)

						
						
						);
		

int exit = 1;
Consumer<studentRecords> printToTerminal 
= x -> System.out.println(x);
Scanner menu = new Scanner(System.in);
Scanner ans = new Scanner(System.in);
Scanner nameSearch = new Scanner(System.in);

List<studentRecords> students1 = null; 
students.stream()
.forEach(item -> System.out.println(item));


BiConsumer<String, Integer> combineID
	=(First, Year) -> System.out.println(""+First +"" +Year);
while (exit != 0) {
	
	
	
	
	System.out.println("What would you like to do?");
	System.out.println("Type 'display' to display all students");
	System.out.println("Type 'add' to add a student");
	System.out.println("Type 'search to search by something");
	System.out.println("Type 'remove' to remove a student");
	System.out.println("Type 'exit' to exit");
	

	String nMenu = menu.next();
	if (nMenu.equalsIgnoreCase("remove")) {
	
			System.out.println("Enter the ID you would like to Remove");
			String ID1 = ans.next();

			int ID2 = Integer.parseInt(ID1);

			Predicate<studentRecords> removeID
				= (studentRecords) -> ID2 != studentRecords.ID();
			List <studentRecords>removed = students.stream()
			.filter(removeID)
			.collect(Collectors.toList());

			students = Stream.of(removed)
					.flatMap(Collection::stream)
					.collect(Collectors.toList());
			

			students.stream()
				.forEach (item -> System.out.println(item));
			

			
			
	}

	if (nMenu.equalsIgnoreCase("add")) {
		System.out.println("Please enter the student's first name, Last name, Birth day, month, year, ID, Course, Module");
		students1 = List.of(
				new studentRecords(
						ans.next(),
						ans.next(),
						ans.nextInt(),
						ans.nextInt(),
						ans.nextInt(),
						ans.nextInt(),
						ans.next(),
						ans.next()
						)
		
				);
		
		students = Stream.of(students, students1)
				.flatMap(Collection::stream)
				.collect(Collectors.toList());

		
	}
	

	if (nMenu.equalsIgnoreCase("display")){
		
		students.stream()
			.forEach ( item -> System.out.println(item));

		
		
	}
	

	if (nMenu.equalsIgnoreCase("Search")) {
		System.out.println("Would you like to search by Name, ID, Course or date of birth");
		String search = ans.next();
		if (search.equals("Name")) {
			System.out.println("Enter the name you would like to search for");
			String name1 = ans.next();

			Predicate<studentRecords> searchName=
					(studentRecords) -> name1.equals(studentRecords.studentFirst());
					
			students.stream()
				.filter(searchName)
				.forEach(printToTerminal);


			}
		if (search.equals("ID")) {
			System.out.println("Enter the ID you would like to search for");
			String ID1 = ans.next();
			int ID2 = Integer.parseInt(ID1);

			Predicate<studentRecords> searchID=
					(studentRecords) -> ID2 == studentRecords.ID();
					
			students.stream()
				.filter(searchID)
				.forEach(printToTerminal);


			}
		if (search.equals("Course")) {
			System.out.println("Enter the Course you would like to search for");
			String course1 = ans.next();

			Predicate<studentRecords> searchCourse=
					(studentRecords) -> course1.equals(studentRecords.course());
					
			students.stream()
				.filter(searchCourse)
				.forEach(printToTerminal);
			
			System.out.println("Type Module to Search by Module");
			String module = ans.next();
			if (module.equals("Module")) {
				System.out.println("Enter the module you would like to search for");
				String module1 = ans.next();
				Predicate<studentRecords> searchModule=
						(studentRecords) -> module1.equals(studentRecords.module());
						
				students.stream()
					.filter(searchCourse)
					.filter(searchModule)
					.forEach(printToTerminal);
				
			}

			}
		
		if (search.equals("Date")) {
			System.out.println("Enter the Birth Year you would like to search for");
			String Year1 = ans.next();
			int Year2 = Integer.parseInt(Year1);

			Predicate<studentRecords> isEqual
				= (studentRecords) -> Year2 == studentRecords.dobYear();
				
			Predicate<studentRecords> isAbove
				=(studentRecords) -> Year2 < studentRecords.dobYear();
				Predicate<studentRecords> isBelow
				=(studentRecords) -> Year2 > studentRecords.dobYear();
			
			System.out.println("This is students born in that year");		
			students.stream()
				.filter(isEqual)
				.forEach(printToTerminal);
			System.out.println("This is students born after that year");		
			students.stream()
				.filter(isAbove)
				.forEach(printToTerminal);
			System.out.println("This is students born Before that year");		
			students.stream()
				.filter(isBelow)
				.forEach(printToTerminal);


			}
		

		
	
	
			
	if (nMenu.equalsIgnoreCase("exit")) {
		exit = 0;
		
	}
	}
	

}
	

	
	

}
}






	
	



	
	
				

						
						
				

				


		


		
	

