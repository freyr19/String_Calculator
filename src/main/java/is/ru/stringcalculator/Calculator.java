package is.ru.stringcalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

	public static int add(String text) throws Exception {

		String delimiter = ";|/n";
    	String numbersWithoutDelimiter = text;
		if(text.equals("")){
			return 0;
		}
		else if(text.contains(",") || text.contains("\n"))  {
			return sum(splitNumbers(text));
		
		}
		else if (text.startsWith("//")) {
        int delimiterIndex = text.indexOf("//") + 2;
        delimiter = text.substring(delimiterIndex, delimiterIndex + 1);
        numbersWithoutDelimiter = text.substring(text.indexOf("n") + 1);
    	return multi(numbersWithoutDelimiter, delimiter);
    }
    
		else
			return 1;
	}


	private static int toInt(String number){
		int num = Integer.parseInt(number);
		if (num < 0) {
			
		}
		if (num > 1000) {
			num = 0;
		}
		return num;
	}

	private static String[] splitNumbers(String numbers){
	   //the regex "\W".This matches any non-word character.
	  	return numbers.split("\\W");
	}
      
    private static int sum(String[] numbers) throws Exception{
 	    
		for(String number : numbers){
		    if (toInt(number) < 0) {
		    	throw new Exception("Negatives not allowed: -1");
		    }
		}
		int total = 0;
        for(String number : numbers){
        	
        		total += toInt(number);
        	
		}
		return total;
    }

    private static int multi(String numbers, String delimiter) {
    int returnValue = 0;
    String[] numbersArray = numbers.split(delimiter);
    for (String number : numbersArray) {
        if (!number.trim().isEmpty()) {
            returnValue += Integer.parseInt(number.trim());
        }
    }
    return returnValue;
	}
}