package day20;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;


public class ArrayChanger {

	public static void main(String[] args) {
		List<String> words = Arrays.asList("cat", "beh", "house", "Matilda",
				"water", "arrow", "villains", "no");
		// 1
		words.stream().forEach(s -> System.out.println("  " + s));
		// 2
		words.stream().forEach(System.out::println);
		// 3
		words.stream().map(s -> s + "!").forEach(System.out::println);
		words.stream().map(s -> s.replace("i", "eye"))
				.forEach(System.out::println);
		words.stream().map(String::toUpperCase).forEach(System.out::println);
		// 4
		words.stream().filter(s -> s.contains("b"))
				.forEach(System.out::println);
		// words.stream().filter(String :: contains
		// ("b")).forEach(System.out::println);??
		words.stream().filter(s -> s.length() < 4).forEach(System.out::println);
		words.stream().filter(s -> s.length() % 2 == 0)
				.forEach(System.out::println);
		// 5
		String firstShortWithE = words.stream().map(String::toUpperCase)
				.filter(s -> s.length() < 4).filter(s -> s.contains("e"))
				.findFirst().toString();
		System.out.println(firstShortWithE);// ???
		// 6

		// 7
		String oneUpperCase = words.stream().reduce("",
				(s1, s2) -> s1.toUpperCase() + s2.toUpperCase());
		System.out.println(oneUpperCase);
		//8
		String oneUpperCase1 = words.stream().map(String::toUpperCase)
				.reduce("",(s1, s2) -> s1 + s2);
		System.out.println(oneUpperCase1);
		//9
		Optional<String> oneWithCommas = words.stream().reduce(
				(s1, s2) -> s1 + "," + s2);
		System.out.println(oneWithCommas);
		// 10
		System.out.printf("8 random nums: %s.%n",
				StreamUtils.randomNumberList(8));
		// 11
		System.out.printf("10 numbers starting at 50, by 5's: %s.%n",
				StreamUtils.orderedNumberList(50, 5, 10));
		//12
		List<Integer> nums1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
		int sum = nums1.stream().reduce(0,(x,y) -> x + y);
		System.out.println("Sum: " + sum);
		
		//13
		int parallelSum = nums1.parallelStream().reduce(0,(x, y) -> x + y);
		System.out.println("Parallel sum: " + parallelSum);
		
		//14
		List<Double> doub1 = Arrays.asList(1.02, 2.43, 3.0, 4.9, 5.0, 6.43, 7.9, 8.0);
		Double prod = doub1.stream().reduce(1.0,(x,y) -> x * y);
		System.out.println("Prod: " + prod);
		
		Double parallelProd = doub1.parallelStream().reduce(1.0,(x, y) -> x * y);
		System.out.println("Parallel prod: " + parallelProd);
				
	}

		
}
