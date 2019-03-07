package valerioemanuele.blog;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Test {

	public static void main(String[] args) throws IOException {
		feature1();
		feature2();
		feature3();
		feature4();
		feature5();
		feature6();
		feature7();
		feature8();
		feature9();
		//feature10() --> esegui questa classe direttamente con java <path>/Test.java
	}

	private static void feature9() {
		System.out.println("Feature 9");
		List<Integer> list = new ArrayList<>(Arrays.asList(2,4,6,8));

		//da java 11
		System.out.println("java11array");
		Integer[] java11array = list.toArray(Integer[]::new);
		Arrays.stream(java11array).forEach(System.out::println);
		System.out.println("oldArray");
		//prima di java 11
		Integer[] oldArray = new Integer[list.size()];
		list.toArray(oldArray);
		Arrays.stream(oldArray).forEach(System.out::println);
	}

	private static void feature8() {
		System.out.println("Feature 8");
		var str = Pattern.compile("aba").asMatchPredicate();//matches
		var str2 = Pattern.compile("aba").asPredicate(); //is found
		
		String case1 = "abaaba";
		String case2 = "aba";
		System.out.println("Case 1");
		System.out.println(str.test(case1));
		System.out.println(str2.test(case1));
		
		System.out.println("Case 2");
		System.out.println(str.test(case2));
		System.out.println(str2.test(case2));
		
	}

	private static void feature7() {
		System.out.println("Feature 7");
		StringBuffer a = new StringBuffer();
		StringBuffer b = new StringBuffer();
		StringBuffer c = new StringBuffer();
		a.append("Valerio");
		b.append("Emanuele");
		c.append("Valerio");
		
		System.out.println(a.compareTo(b));
		System.out.println(a.compareTo(c));
		
	}

	private static void feature6() throws IOException {
		System.out.println("Feature 6");
		Path path = Files.writeString(Files.createTempFile("test", ".txt"), "Valerio Emanuele TEST");
		String s = Files.readString(path);
		System.out.println(s);
	}

	private static void feature5() {
		System.out.println("Feature 5");
		Optional<String> str = Optional.empty();
		System.out.println(!str.isPresent()); //prima di Java 11 
		System.out.println(str.isEmpty()); //da Java 11 
		
		str = Optional.of("Valerio Emanuele");
		System.out.println(!str.isPresent()); //prima di Java 11 
		System.out.println(str.isEmpty()); //da Java 11 
	}

	private static void feature4() {
		System.out.println("Feature 4");
		List<String> testStrings = new ArrayList<>(Arrays.asList("ABC", "", "   "));
		
		//Prima di Java 11
		testStrings
			.stream()
			.filter(s -> !s.isBlank())
			.forEach(System.out::println);
		
		//Da Java 11
		testStrings
		.stream()
		.filter(Predicate.not(String::isBlank))
		.forEach(System.out::println);
	}

	private static void feature3() {
		System.out.println("Feature 3");
		//prima di JAVA 11
		System.out.println(TimeUnit.MILLISECONDS.convert(5L, TimeUnit.MINUTES));
		//Da Java 11
		System.out.println(TimeUnit.MILLISECONDS.convert(Duration.ofMinutes(5)));
	}

	private static void feature2() {
		System.out.println("Feature 2");
		String to = "\u2000HoWhitespace ";
		System.out.println("<"+to.strip()+">");
		System.out.println("<"+to.stripLeading()+">");
		System.out.println("<"+to.stripTrailing()+">");
		System.out.println("<"+to.trim()+">");
	}

	private static void feature1() {
		System.out.println("Feature 1");
		List<Integer> list = new ArrayList<>();
		list.addAll(Arrays.asList(2,4,6,8));

		System.out.println("Lista prima della funzione");		
		list.stream().forEach(System.out::println);
		
		IntFunction<Integer> raddoppiaValore = (final var x) -> x * 2;
		
		list = list.stream()
			.map(val -> raddoppiaValore.apply(val))
			.collect(Collectors.toList());
		
		System.out.println("Lista dopo la funzione");
		list.stream().forEach(System.out::println);
	}

}
