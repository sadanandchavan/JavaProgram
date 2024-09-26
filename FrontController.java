package com.sada.controller;


import java.util.HashMap;
import java.util.StringTokenizer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/FrontController")
public class FrontController {


	private static final Logger logger = LogManager.getLogger(FrontController.class);

	//http://localhost:8080/FrontController/reverse?string=ABCD
	@GetMapping("/reverse")
	public String reverseString(@RequestParam String string) {

		logger.info("Request received for string reverse {}",string);

		if(string ==null || string.equals("")) {
			throw new IllegalArgumentException("Not a valid input.");
		}

		StringBuilder sb= new StringBuilder();
		char [] stringArray = string.toCharArray();

		for(int i=stringArray.length-1;i>=0;i--) {
			sb.append(stringArray[i]);
		}

		logger.info("Reeverse string {}",string);
		return sb.toString();
	}

	//http://localhost:8080/FrontController/checkvowel?string=ABCD
	@RequestMapping("/checkvowel")
	public String checkVowelIsPresent(@RequestParam String msg) {
		if(msg ==null || msg.equals("")) {
			throw new IllegalArgumentException("Not a valid input.");
		}

		if(msg.matches(".*[aeiou].*")) {
			return "Present"; 
		}

		return "Not Present";

	}

	//http://localhost:8080/FrontController/isprime?number=23
	@RequestMapping("/isprime")
	public String isPrime(@RequestParam int number) {

		if(number==0 || number==1 ) {
			return "Not a prime number";
		}

		for (int i=2; i<=number/2; i++ ) {
			if(number%2==0) {
				return "Not a prime number";
			}
		}


		return "Prime number";

	}

	//http://localhost:8080/FrontController/printfib?number=4
	@GetMapping("printfib")
	public String printFibonacci(@RequestParam int number) {

		int a=0;
		int b=1;
		int c=1;

		StringBuilder sb = new StringBuilder(); 

		for (int i=1; i<=number; i++) {
			sb.append(a+",");
			a=b;
			b=c;
			c=a+b;

		}

		return sb.toString();
	} 

	//http://localhost:8080/FrontController/palindrome?msg=121
	@GetMapping("palindromestr")
	public String  checkPalindromeString(@RequestParam String msg) {

		int length= msg.length();
		for (int i = 0; i <length; i++) {
			if(msg.charAt(i)!= msg.charAt(length-1-i)) {
				return msg+" is Not Palindrome";
			}
		}
		return msg+ " is Palindrome";
	}

	//http://localhost:8080/FrontController/removespace?msg=ABCD%20EFGH
	@GetMapping("removespace")
	public String  removeWhiteSpace(@RequestParam String msg) {
		StringBuilder sb = new StringBuilder();
		int length= msg.length();
		for (int i = 0; i <length; i++) {
			if(msg.charAt(i)!=' ') {
				sb.append(msg.charAt(i));
			}
		}
		return sb.toString();
	}

	//http://localhost:8080/FrontController/duplicateChar?msg=ABbbCDEFGHHHHH
	@GetMapping("duplicateChar")
	public HashMap<Character, Integer>  duplicateChar(@RequestParam String msg) {
		StringBuilder sb = new StringBuilder();
		HashMap<Character, Integer> countmap= new HashMap<Character, Integer>();

		char [] chararray =msg.toCharArray();
		int length= msg.length();
		for (int i = 0; i <length; i++) {

			if(countmap.containsKey(chararray[i])){
				countmap.put(chararray[i], countmap.get(chararray[i])+1);
			}else {
				countmap.put(chararray[i], 1);
			}
		}
		return countmap;
	}

	//http://localhost:8080/FrontController/reverseeachworld?msg=ABCD%2020EFGH%2020IJKL
	@GetMapping("reverseeachworld")
	public String  ReverseEachWord(@RequestParam String msg) {
		logger.info("Request received for Reverse Each Word {}",msg);
		StringBuilder sb = new StringBuilder();
		//String [] wordArray = msg.split("\\ ");
		//String [] wordArray = msg.split(" ");
		//String [] wordArray = msg.split("\\s+");
		String [] wordArray = msg.split("\\n");

		StringTokenizer st = new StringTokenizer(msg," ");

		while (st.hasMoreTokens()) {
			logger.info("Split {}",st.nextElement());
		}

		logger.info("After split ",st);
		for (int i = 0; i < wordArray.length-1; i++) {

			for (int j = wordArray[i].length(); j <wordArray[i].length(); j--) {
				sb.append(wordArray[j]);
			}
			sb.append(" ");
		}
		return sb.toString();

	}
	
	
	//http://localhost:8080/FrontController/isprime?number=23
	@RequestMapping("/factorial")
	public String factorial(@RequestParam int number) {

		int fact=1;
		for (int i=1; i<=number; i++ ) {
			fact=fact*i;
		}
		return String.valueOf(fact);

	}
	
	
	//http://localhost:8080/FrontController/isprime?number=23
	@RequestMapping("/palindromeno")
	public String Palindrome (@RequestParam int number) {
		
		int rem , sum=0, temp;
		
		temp= number;
		
		while(number>0) {
			logger.info(" number {} ",number);
			rem= number%10;
			logger.info("After rem {} ",rem);
			sum=(sum*10)+rem;
			logger.info("After sum {} ",sum);
			number=number/10;
			logger.info("Agaiin  number {} ",number);
		}
		
		if(temp==sum) {
			return "Palindrome";
		}
		return "Not Palindrome";
			
		}
		

		
}
