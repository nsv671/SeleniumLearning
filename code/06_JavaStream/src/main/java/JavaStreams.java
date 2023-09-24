import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JavaStreams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> names = new ArrayList<String>();
		
		names.add("Nitesh");
		names.add("Mukesh");
		names.add("Amit");
		names.add("Anita");
		names.add("Bijay");
		names.add("Aklesh");
		names.add("Rinki");
		names.add("Abhay");
		
		int count =0;
		
		for(String name : names) {
			if(name.startsWith("A")) {
				count++;
			}
		}
		System.out.println("the count of the names that starts with A is  --> "+ count);
		
		
		//STRAMS
		Long countOfNameWhichStartWithA = names.stream().filter(name -> name.startsWith("A")).count();
		System.out.println("the count of the names that starts with A is  --> " + countOfNameWhichStartWithA + "  Calculated using stream API");
		
		Long countOfNameWhichStartWithAUsingSTREAMobject = Stream.of("Nitesh", "Mukesh", "Amit", "Anita", "Bijay", "Aklesh", "Rinki", "Abhay").filter(name -> {
			if(name.startsWith("A"))
				return true;
			return false;
		}).count();
		System.out.println("the count of the names that starts with A is  --> " + countOfNameWhichStartWithAUsingSTREAMobject + "  Calculated using stream API");
		
		Stream<String> countOfNameWhichStartWithAUsingSTREAMobjectWithoutTerminalOperation = Stream.of("Nitesh", "Mukesh", "Amit", "Anita", "Bijay", "Aklesh", "Rinki", "Abhay").filter(name -> {
			if(name.startsWith("A"))
				return true;
			return false;
		});
		System.out.println(countOfNameWhichStartWithAUsingSTREAMobjectWithoutTerminalOperation);
		
		//Stream with ForEach loop
		names.stream().filter(name -> name.length()>5).forEach(item -> System.out.println(item));
		System.out.println("*************************************************************");
		names.stream().filter(name -> name.length()>5).limit(1).forEach(item -> System.out.println(item));
		
		//Streams with map
		System.out.println("********STREAMS with map********");
		names.stream().filter(name -> name.length()>5).map(item -> item.toLowerCase()).forEach(item -> System.out.println(item));
		System.out.println("*************************************************************");
		names.stream().filter(name -> name.startsWith("A")).sorted().map(item -> item.toUpperCase()).forEach(item -> System.out.println(item));
		
		ArrayList<String> names1 = new ArrayList<String>(Arrays.asList("Bob", "Himer", "Alex", "Devid"));
		
		Stream<String> newStream = Stream.concat(names.stream(), names1.stream());
		boolean anymatch = newStream.anyMatch(name -> name.equalsIgnoreCase("Bob"));
		System.out.println(anymatch);
		
		//Creating new colletion from stream
		List<String> list = names1.stream().filter(name -> name.startsWith("A")).collect(Collectors.toList());
		System.out.println(list);
		System.out.println("*************************************************************");
		
		List<Integer> integer = Arrays.asList(1,3,5,2,4,3,4,2,6,4);
		integer.stream().distinct().forEach(s -> System.out.println(s));
		System.out.println("*************************************************************");
		List<Integer> newInteger = integer.stream().distinct().sorted().collect(Collectors.toList());
		System.out.println(newInteger.get(3));
	}

}