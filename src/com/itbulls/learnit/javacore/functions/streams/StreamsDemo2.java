package com.itbulls.learnit.javacore.functions.streams;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsDemo2 {

	public static void main(String[] args) throws IOException {
		System.out.println("Test buildStream start");

		// Stream from values
		Stream<String> streamFromValues = Stream.of("a1", "a2", "a3");
		System.out.println(
				"streamFromValues = " + streamFromValues.collect(Collectors.toList())); 
		
		
		// Stream from array
		String[] array = { "a1", "a2", "a3" };
		Stream<String> streamFromArrays = Arrays.stream(array);
		System.out.println(
				"streamFromArrays = " + streamFromArrays.collect(Collectors.toList())); 
		
		

		Stream<String> streamFromArrays1 = Stream.of(array);
		System.out.println(
				"streamFromArrays1 = " + streamFromArrays1.collect(Collectors.toList())); 
		
		
		// Stream from file
		File file = new File("1.tmp");
		file.deleteOnExit();
		PrintWriter out = new PrintWriter(file);
		out.println("a1");
		out.println("a2");
		out.println("a3");
		out.close();

		Stream<String> streamFromFiles = Files.lines(Paths.get(file.getAbsolutePath()));
		System.out.println(
				"streamFromFiles = " + streamFromFiles.collect(Collectors.toList())); 

		
		// Stream from Collection
		Collection<String> collection = Arrays.asList("a1", "a2", "a3");
		Stream<String> streamFromCollection = collection.stream();
		System.out.println("streamFromCollection = "
				+ streamFromCollection.collect(Collectors.toList())); 

		
		// Numeric stream from String
		IntStream streamFromString = "123".chars();
		System.out.print("streamFromString = ");
		streamFromString.forEach((e) -> System.out.print(e + " , ")); 
		System.out.println();

		// With the help Stream.builder
		Stream.Builder<String> builder = Stream.builder();
		Stream<String> streamFromBuilder = builder.add("a1").add("a2").add("a3").build();
		System.out.println("streamFromBuilder = "
				+ streamFromBuilder.collect((Collectors.toList()))); 
		

		// Infinite Streams
		// Stream.iterate
		Stream<Integer> streamFromIterate = Stream.iterate(1, n -> n + 2);
		System.out.println("streamFromIterate = "
				+ streamFromIterate.limit(3).collect(Collectors.toList())); 
		

		// Stream.generate
		Stream<String> streamFromGenerate = Stream.generate(() -> "a1");
		System.out.println("streamFromGenerate = "
				+ streamFromGenerate.limit(3).collect(Collectors.toList())); 
		

		// Empty Stream
		Stream<String> streamEmpty = Stream.empty();
		System.out.println("streamEmpty = " 
				+ streamEmpty.collect(Collectors.toList())); 
										

		// Parallel Stream
		Stream<String> parallelStream = collection.parallelStream();
		System.out.println(
				"parallelStream = " + parallelStream.collect(Collectors.toList())); 
		
		
		testFilterAndCount();
		testFindFirstSkipCount();
		testLimit();
		testDistinct();
		testMatch();
		testMap();
		testMapToInt();
		testFlatMap();
		testFlatMapToInt();
		testSorted();
		testMinMax();
		testForEach();
		testPeek();
		testReduce();
	}

	private static void testFilterAndCount() {
        System.out.println();
        System.out.println("Test filter and count start");
        Collection<String> collection = Arrays.asList("a1", "a2", "a3", "a1");
        Collection<People> peoples = Arrays.asList(
                new People("William", 16, Sex.MAN),
                new People("John", 23, Sex.MAN),
                new People("Helen", 42, Sex.WOMEN),
                new People("Peter", 69, Sex.MAN)
        );

        long count = collection.stream().filter("a1"::equals).count();
        System.out.println("count = " + count); 

        List<String> select = collection.stream()
        		.filter((s) -> s.contains("1"))
        		.collect(Collectors.toList());
        System.out.println("select = " + select); 

        List<People> militaryService = peoples.stream()
        		.filter((p)-> p.getAge() >= 18 && p.getAge() < 27
                && p.getSex() == Sex.MAN).collect(Collectors.toList());
        System.out.println("militaryService = " + militaryService); 

        double manAverageAge = peoples.stream().filter((p) -> p.getSex() == Sex.MAN).
                mapToInt(People::getAge).average().getAsDouble();
        System.out.println("manAverageAge = " + manAverageAge); 

        long peopleHowCanWork = peoples.stream()
        		.filter((p) -> p.getAge() >= 18)
        		.filter(
                (p) -> (p.getSex() == Sex.WOMEN && p.getAge() < 55) || 
                (p.getSex() == Sex.MAN && p.getAge() < 60)).count();
        System.out.println("peopleHowCanWork = " + peopleHowCanWork); 

    }

    private static void testFindFirstSkipCount() {
        Collection<String> collection = Arrays.asList("a1", "a2", "a3", "a1");

        System.out.println("Test findFirst and skip start");
        String first = collection.stream().findFirst().orElse("1");
        System.out.println("first = " + first); 

        String last = collection.stream().skip(collection.size() - 1)
        		.findAny().orElse("1");
        System.out.println("last = " + last ); 

        String find = collection.stream().filter("a3"::equals).findFirst().get();
        System.out.println("find = " + find); 

        String third = collection.stream().skip(2).findFirst().get();
        System.out.println("third = " + third); 

        System.out.println();
        System.out.println("Test collect start");
        List<String> select = collection.stream()
        		.filter((s) -> s.contains("1"))
        		.collect(Collectors.toList());
        System.out.println("select = " + select); 
    }

    private static void testLimit() {
        System.out.println();
        System.out.println("Test limit start");
        Collection<String> collection = Arrays.asList("a1", "a2", "a3", "a1");

        List<String> limit = collection.stream().limit(2).collect(Collectors.toList());
        System.out.println("limit = " + limit); 

        List<String> fromTo = collection.stream().skip(1).limit(2).collect(Collectors.toList());
        System.out.println("fromTo = " + fromTo); 

        String last = collection.stream().skip(collection.size() - 1).findAny().orElse("1");
        System.out.println("last = " + last ); 
    }

    private enum Sex {
        MAN,
        WOMEN
    }

    private static class People {
        private final String name;
        private final Integer age;
        private final Sex sex;

        public People(String name, Integer age, Sex sex) {
            this.name = name;
            this.age = age;
            this.sex = sex;
        }

        public String getName() {
            return name;
        }

        public Integer getAge() {
            return age;
        }

        public Sex getSex() {
            return sex;
        }

        @Override
        public String toString() {
            return "{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", sex=" + sex +
                    '}';
        }
        
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof People)) return false;
            People people = (People) o;
            return Objects.equals(name, people.name) &&
                    Objects.equals(age, people.age) &&
                    Objects.equals(sex, people.sex);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, age, sex);
        }
    }
    
    
    
    private static void testDistinct() {
        System.out.println();
        System.out.println("Test distinct start");
        Collection<String> ordered = Arrays.asList("a1", "a2", "a2", "a3", "a1", "a2", "a2");
        Collection<String> nonOrdered = new HashSet<>(ordered);

        List<String> distinct = nonOrdered.stream()
        		.distinct()
        		.collect(Collectors.toList());
        System.out.println("distinct = " + distinct); 

        List<String> distinctOrdered = ordered.stream()
        		.distinct()
        		.collect(Collectors.toList());
        System.out.println("distinctOrdered = " + distinctOrdered); 
    }
    
    private static void testMatch() {
        System.out.println();
        System.out.println("Test anyMatch, allMatch, noneMatch  start");
        Collection<String> collection = Arrays.asList("a1", "a2", "a3", "a1");

        boolean isAnyOneTrue = collection.stream().anyMatch("a1"::equals);
        System.out.println("anyOneTrue " + isAnyOneTrue); 
        boolean isAnyOneFalse = collection.stream().anyMatch("a8"::equals);
        System.out.println("anyOneFlase " + isAnyOneFalse); 

        boolean isAll = collection.stream().allMatch((s) -> s.contains("1"));
        System.out.println("isAll " + isAll); 

        boolean isNotEquals = collection.stream().noneMatch("a7"::equals);
        System.out.println("isNotEquals " + isNotEquals); 
    }
    
    private static void testMap() {
        System.out.println();
        System.out.println("Test map start");
        Collection<String> collection = Arrays.asList("a1", "a2", "a3", "a1");
        List<String> transform = collection.stream()
        		.map((s) -> s + "_1")
        		.collect(Collectors.toList());
        System.out.println("transform = " + transform); 

        List<Integer> number = collection.stream()
        		.map((s) -> Integer.parseInt(s.substring(1)))
        		.collect(Collectors.toList());
        System.out.println("number = " + number); 

    }

    private static void testMapToInt() {
        System.out.println();
        System.out.println("Test mapToInt start");
        Collection<String> collection = Arrays.asList("a1", "a2", "a3", "a1");
        int[] number = collection.stream()
        		.mapToInt((s) -> Integer.parseInt(s.substring(1)))
        		.toArray();
        System.out.println("number = " + Arrays.toString(number)); 

    }

    private static void testFlatMap() {
        System.out.println();
        System.out.println("Test flat map start");
        Collection<String> collection = Arrays.asList("1,2,0", "4,5");
        String[] number = collection.stream()
        		.flatMap((p) -> Arrays.asList(p.split(",")).stream())
        		.toArray(String[]::new);
        System.out.println("number = " + Arrays.toString(number)); 
    }

    private static void testFlatMapToInt() {
        System.out.println();
        System.out.println("Test flat map start");
        Collection<String> collection = Arrays.asList("1,2,0", "4,5");
        int sum = collection.stream()
        		.flatMapToInt((p) -> 
	        		Arrays.asList(p.split(",")).stream()
	        		.mapToInt(Integer::parseInt))
        		.sum();
        System.out.println("sum = " + sum); 
    }
    
    
    private static void testSorted() {
        System.out.println();
        System.out.println("Test sorted start");

        Collection<String> collection = Arrays
        		.asList("a1", "a4", "a3", "a2", "a1", "a4");

        List<String> sorted = collection.stream().sorted().collect(Collectors.toList());
        System.out.println("sorted = " + sorted); 

        List<String> sortedDistinct = collection.stream()
        		.sorted()
        		.distinct()
        		.collect(Collectors.toList());
        System.out.println("sortedDistinct = " + sortedDistinct); 

        List<String> sortedReverse = collection
        		.stream()
        		.sorted((o1, o2) -> -o1.compareTo(o2))
        		.collect(Collectors.toList());
        System.out.println("sortedReverse = " + sortedReverse); 

        List<String> distinctReverse = collection.stream()
        		.sorted((o1, o2) -> -o1.compareTo(o2))
        		.distinct()
        		.collect(Collectors.toList());
        System.out.println("distinctReverse = " + distinctReverse); 

        Collection<People> peoples = Arrays.asList(
                new People("William", 16, Sex.MAN),
                new People("John", 23, Sex.MAN),
                new People("Helen", 42, Sex.WOMEN),
                new People("Peter", 69, Sex.MAN)
        );

        Collection<People> byName = peoples.stream()
        		.sorted((o1,o2) -> -o1.getName().compareTo(o2.getName()))
        		.collect(Collectors.toList());
        System.out.println("byName = " + byName); 
        

        Collection<People> bySexAndAge = peoples.stream()
        		.sorted((o1, o2) -> o1.getSex() != o2.getSex() ? o1.getSex().
                compareTo(o2.getSex()) : o1.getAge().compareTo(o2.getAge()))
        		.collect(Collectors.toList());
        System.out.println("bySexAndAge = " + bySexAndAge); 
    }

    
    private static void testMinMax() {
        System.out.println();
        System.out.println("Test min and max start");
        Collection<String> collection = Arrays.asList("a1", "a2", "a3", "a1");

        String max = collection.stream().max(String::compareTo).get();
        System.out.println("max " + max); 

        String min = collection.stream().min(String::compareTo).get();
        System.out.println("min " + min); 


        Collection<People> peoples = Arrays.asList(
        	     new People("William", 16, Sex.MAN),
                 new People("John", 23, Sex.MAN),
                 new People("Helen", 42, Sex.WOMEN),
                 new People("Peter", 69, Sex.MAN)
        );

        People older = peoples.stream()
        		.max((p1, p2) -> p1.getAge().compareTo(p2.getAge())).get();
        System.out.println("older " + older); 

        People younger = peoples.stream()
        		.min((p1, p2) -> p1.getAge().compareTo(p2.getAge())).get();
        System.out.println("younger " + younger); 
    }
    
    private static void testForEach() {
        System.out.println();
        System.out.println("For each start");
        Collection<String> collection = Arrays.asList("a1", "a2", "a3", "a1");
        System.out.print("forEach = ");
        collection.stream().map(String::toUpperCase)
        	.forEach((e) -> System.out.print(e + ",")); 
        System.out.println();

        Collection<StringBuilder> list = 
        		Arrays.asList(new StringBuilder("a1"), new StringBuilder("a2"), new StringBuilder("a3"));
        list.stream().forEachOrdered((p) -> p.append("_new"));
        System.out.println("forEachOrdered = " + list); 
    }

    private static void testPeek() {
        System.out.println();
        System.out.println("Test peek start");
        Collection<String> collection = Arrays.asList("a1", "a2", "a3", "a1");
        System.out.print("peak1 = ");
        List<String> peek = collection.stream().map(String::toUpperCase).peek((e) -> System.out.print(e + ",")).
                collect(Collectors.toList());
        System.out.println(); 
        System.out.println("peek2 = " + peek); 

        Collection<StringBuilder> list = Arrays.asList(new StringBuilder("a1"), new StringBuilder("a2"), new StringBuilder("a3"));
        List<StringBuilder> newList = list
        		.stream()
        		.peek((p) -> p.append("_new")).collect(Collectors.toList());
        System.out.println("newList = " + newList); 
    }
    
    private static void testReduce() {
        System.out.println();
        System.out.println("Test reduce start");

        Collection<Integer> collection = Arrays.asList(1, 2, 3, 4, 2);

        Integer sum = collection.stream()
        		.reduce((s1, s2) -> s1 + s2).orElse(0); 
        Integer sumOld = 0;
        for(Integer i: collection) {
            sumOld += i;
        }
        System.out.println("sum = " + sum + " : " + sumOld); 

        Integer max1 = collection.stream()
        		.reduce((s1, s2) -> s1 > s2 ? s1 : s2).orElse(0); 
        Integer max2 = collection.stream()
        		.reduce(Integer::max).orElse(0); 
        Integer maxOld = null; 
        for(Integer i: collection) {
            maxOld = maxOld != null && maxOld > i? maxOld: i;
        }
        maxOld = maxOld == null? 0 : maxOld;
        System.out.println("max = " + max1 + " : " + max2 + " : " + maxOld); 
        
        Integer min = collection.stream()
        		.reduce((s1, s2) -> s1 < s2 ? s1 : s2).orElse(0); 
        Integer minOld = null; 
        for(Integer i: collection) {
            minOld = minOld != null && minOld < i? minOld: i;
        }
        minOld = minOld == null? 0 : minOld;
        System.out.println("min = " + min+ " : " + minOld); 

        Integer last = collection.stream().reduce((s1, s2) -> s2).orElse(0); 
        Integer lastOld = null; 
        for(Integer i: collection) {
            lastOld = i;
        }
        lastOld = lastOld == null? 0 : lastOld;
        System.out.println("last = " + last + " : " + lastOld); 

        Integer sumMore2 = collection.stream()
        		.filter(o -> o > 2).reduce((s1, s2) -> s1 + s2).orElse(0);   
        Integer sumMore2Old = 0; 
        for(Integer i: collection) {
            if(i > 2) {
                sumMore2Old += i;
            }
        }
        System.out.println("sumMore2 = " + sumMore2 + " : " + sumMore2Old); 

        Integer sumOdd = collection.stream().filter(o -> o % 2 != 0)
        		.reduce((s1, s2) -> s1 + s2).orElse(0); 
        Integer sumOddOld = 0; 
        for(Integer i: collection) {
            if(i % 2 != 0) {
                sumOddOld += i;
            }
        }
        System.out.println("sumOdd = " + sumOdd + " : " + sumOddOld); 


        Collection<People> peoples = Arrays.asList(
       	     new People("William", 16, Sex.MAN),
             new People("John", 23, Sex.MAN),
             new People("Helen", 42, Sex.WOMEN),
             new People("Peter", 69, Sex.MAN)
        );

        int oldMan = peoples.stream().filter((p) -> p.getSex() == Sex.MAN)
        		.map(People::getAge).reduce((s1, s2) -> s1 > s2 ? s1 : s2).get();
        System.out.println("oldMan = " + oldMan); 
       

        int younger = peoples.stream()
        		.filter((p) -> p.getName()
        				.contains("е")).mapToInt(People::getAge)
        		.reduce((s1, s2) -> s1 < s2 ? s1 : s2).orElse(0);
        System.out.println("younger = " + younger); 
    }
       
    
    private static void testCollect() {
        System.out.println();
        System.out.println("Test distinct start");

        Collection<String> strings = Arrays.asList("a1", "b2", "c3", "a1");

        List<String> distinct = strings.stream()
        		.distinct().collect(Collectors.toList());
        System.out.println("distinct = " + distinct); 
        
        String[] array = strings.stream().distinct().map(String::toUpperCase).toArray(String[]::new);
        System.out.println("array = " + Arrays.asList(array)); 

        String join = strings.stream().collect(Collectors.joining(" : ", "<b> ", " </b>"));
        System.out.println("join = " + join); 

        Map<String, String> map = strings.stream()
        		.distinct()
        		.collect(Collectors.toMap((p) -> 
        			p.substring(0, 1), (p) -> p.substring(1, 2)));
        System.out.println("map = " + map); 

        Map<String, List<String>> groups = strings.stream().collect(Collectors.groupingBy((p) -> p.substring(0, 1)));
        System.out.println("groups = " + groups); 

        Map<String, String> groupJoin = strings.stream().collect(Collectors.groupingBy((p) -> p.substring(0, 1), Collectors.mapping((p) -> p.substring(1, 2), Collectors.joining(":"))));
        System.out.println("groupJoin = " + groupJoin); 

        Collection<Integer> numbers = Arrays.asList(1, 2, 3, 4);

        long sumOdd = numbers.stream().collect(Collectors.summingInt(((p) -> p % 2 == 1 ? p : 0)));
        System.out.println("sumOdd = " + sumOdd); 

        double average = numbers.stream().collect(Collectors.averagingInt((p) -> p - 1));
        System.out.println("average = " + average); 

        IntSummaryStatistics statistics = numbers.stream()
        		.collect(Collectors.summarizingInt((p) -> p + 3));
        System.out.println("statistics = " + statistics); 

        long sumEven = numbers.stream().collect(Collectors.summarizingInt((p) -> p % 2 == 0 ? p : 0)).getSum();
        System.out.println("sumEven = " + sumEven); 

        Map<Boolean, List<Integer>> parts = numbers.stream().collect(Collectors.partitioningBy((p) -> p % 2 == 0));
        System.out.println("parts = " + parts); 
    }
}
