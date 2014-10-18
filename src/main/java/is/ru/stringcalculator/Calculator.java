package is.ru.stringcalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
	private static String REGEX = ",|\n";
	
	public static int add(String text)  {
		
		Matcher matcher = Pattern.compile("^//((.)|(\\[(.+?)\\])+)\n(.*)").matcher(text);
		String number = text;

		if(matcher.find()){
			if(matcher.group(2)!= null){
				REGEX = Pattern.quote(matcher.group(2))+"|,";
			}
			else
			{
				String delimiter = matcher.group(1);
				Matcher delimiterMatcher = Pattern.compile("\\[(.+?)\\]").matcher(delimiter);
				StringBuffer allDelimiter = new StringBuffer();
				while (delimiterMatcher.find())
				{
					if(allDelimiter.length() == 0)
					{
						allDelimiter.append(Pattern.quote(delimiterMatcher.group(1)));
					}
					else
					{
						allDelimiter.append("|" + Pattern.quote(delimiterMatcher.group(1)));
					}
				}
				REGEX = allDelimiter.toString()+"|,";
			}
			number = matcher.group(5);
		}
		return Sum(getNumber(number));
	}


	public static int convertInt(String num, StringBuffer negative){
		int number = Integer.parseInt(num);
		if(number < 0) negative.append(" "+number);
		if(number >= 1000) number = 0;
		return number;
	}
	public static String[] getNumber(String number){
		if(number.isEmpty())
		{
			return new String[0];
		}
		else
		{
			return number.split(REGEX);
		}
	}
	public static int Sum(String[] numbers){
		int sum = 0;
		StringBuffer negative = new StringBuffer();
		for(String temp : numbers){
			sum += convertInt(temp,negative);
		}
		if (negative.length()>0) throw new RuntimeException("Negatives not allowed:" + negative);
			return sum;
		}
	}




