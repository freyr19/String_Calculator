package is.ru.stringcalculator;

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
		return Integer.parseInt(number);
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