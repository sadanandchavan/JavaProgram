package com.sada;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class JavaProgram {

	public  void duplicateElement(String[] args) {
		System.out.println("Start..");
		List<String> list = Arrays.asList("JAVA","Spring","JAVA","JSON","XML","AJAX","JSON");

		List list2=list.stream().distinct().collect(Collectors.toList());
		for (Object object : list2) {
			System.out.println(object.toString());
		}


	}


	public void getFrequencyOfElement(List<String> list ) {

		Map<String,Long> map = list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println("Output " +map.toString());

		List list2 =list.stream().filter(s->s.startsWith("J")).collect(Collectors.toList());
		System.out.println("Start with J="+list2);

		Stream<String> list3 =list.stream().filter(s->Character.isDigit(s.charAt(0)));
		System.out.println("Start withnumber="+list3.collect(Collectors.toList()));


	}

	public void sortNumber(List <Integer> numbers) {

		List list2 =numbers.stream().sorted((a,b)-> b.compareTo(a)).distinct().limit(1).collect(Collectors.toList());
		for (Object object : list2) {
			System.out.println(object.toString()+",");

		}
	}

	public void checkPalindrome(String msg) {

		IntStream ist= IntStream.range(0, msg.length()/2);   //.noneMatch(i->msg.charAt(i)!=msg.charAt(msg.length()-i-1));
	} 


	public void removeDuplicate(List <Integer> numbers){
		Set set = new HashSet();

		List numberList =numbers.stream().filter(number->set.add(number)).collect(Collectors.toList());
		for (Object object : numberList) {
			System.out.println("Remove Duplicate no"+object.toString());
		}

	}

	private void getInteger(List <Integer> numbers) {

		numbers.stream().filter(n->n%2==0).forEach(System.out::print);

	}

	private void numberstartWith(List <Integer> numbers) {

		List<String> myList = numbers.stream().map(number->number+"").filter(number->number.startsWith("2")).collect(Collectors.toList());
		/*
		System.out.println("First element "+numbers.stream().max((a,b)->b.compareTo(a)));
		for(Object obj: myList ){
			System.out.println("Number Start with "+obj);

		}
		 */
	}

	private void totalnumber(List <Integer> numbers) {
		System.out.println("Count of number= "+numbers.stream().count());

		//int max= numbers.stream().max(Integer::compare).get();

		int max= numbers.stream().max(Comparator.naturalOrder()).get();
		System.out.println("max number "+max);


		int min= numbers.stream().max(Comparator.naturalOrder()).get();
		System.out.println("max number "+min);

	}

	public  void SortOddEven() {
		System.out.println("Start..");

		List <Integer> numberList = Arrays.asList(6, 8, 14, 5,7,9,23,37,44,66,67,99);

		Map<Boolean, List<Integer>> oddEvenNumbersMap = numberList.stream().collect(Collectors.partitioningBy(i->i%2==0));

		System.out.println("Oiutput ="+oddEvenNumbersMap);

		Set<Entry<Boolean,List<Integer>>> entrySet= oddEvenNumbersMap.entrySet();

		for (Entry<Boolean, List<Integer>> entry : entrySet) {

			if(entry.getKey()) {
				List<Integer> list = entry.getValue();
				for (int i : list)
				{
					System.out.println("Even "+i);
				}
			}else{
				List<Integer> list = entry.getValue();
				for (int i : list)
				{
					System.out.println("ODD"+i);
				}
			}

		}
	}




	public static void main(String[] args) {
		System.out.println("Application Start.");

		JavaProgram jp = new JavaProgram();
		List <String> list = Arrays.asList("JAVA", "SPRING","JSON","XML","BEAN","JAVA","XML", "4BOOK");
		jp.getFrequencyOfElement(list);

		List <Integer> number = Arrays.asList(2,5,7,14,99,38,89,23,16,3,3,3,3,3,3,999);
		jp.sortNumber(number);

		jp.checkPalindrome("sada");

		jp.removeDuplicate(number);

		jp.getInteger(number);

		jp.numberstartWith(number);

		jp.totalnumber(number);

	}

}
