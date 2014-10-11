#TDD exercise, solution first steps
## String Calculator

### Build
Compile:

    #!/bin/bash    
    javac src/main/java/is/ru/stringcalculator/*.java -d classes
    
Clean:
     
     #!/bin/bash
     rm -r classes/*

Compile tests:

    #!/bin/bash
    javac -classpath "classes/:lib/junit-4.11.jar" src/test/java/is/ru/stringcalculator/*.java -d classes

Unit Test:

    #!/bin/bash
    java -cp "classes/:lib/junit-4.11.jar:lib/hamcrest-core-1.3.jar" org.junit.runner.JUnitCore is.ru.stringcalculator.CalculatorTest 
    
  
 Build and Test:
      
      #!/bin/bash
    ./bin/clean
    ./bin/compile
    ./bin/compile_tests
    ./bin/unit_test
    
### TDD

#### Test Empty
CalculatorTest

    @Test
    public void testEmptyString() {
    	assertEquals(0, Calculator.add(""));
    }

Calculator    

    public static int add(String test){
        return 0;
    } 
    
#### Test One Number
CalculatorTest

    @Test
    public void testOneNumber(){
    	assertEquals(1, Calculator.add("1"));
    }
    
Calculator

    public static int add(String text){
        if(text.equals("")){
    	    return 0;
        }
        else
        	return 1;
        	
#### Test Two Number

CalculatorTest:
    
    @Test
    public void testTwoStrings(){
    	assertEquals(3, Calculator.add("1,2"));
 	}
 	
 Calculator
 
     if(text.equals("")){
        return 0;
 	}
    else if(text.contains(",")){
    	String[] numbers = text.split(",");
    	return toInt(numbers[0]) + toInt(numbers[1]);
    }
 	else
 		return 1;
 	
    #Refactor
    private static int toInt(String number){
    	return Integer.parseInt(number);
    }
    
#### Test 

CalculatorTest:

    @Test
    public void testMultipleNumbers(){
    	assertEquals(6, Calculator.add("1,2,3"));
    }
    
Calculator:

    else if(text.contains(",")){
        String[] numbers = text.split(",");
        int total = 0;
        for(String number : numbers){
		    total += toInt(number);
		}
		return total;
 	}
 	#Refactor
 	private static String[] splitNumbers(String numbers){
	    return numbers.split(",");
	}
      
    private static int sum(String[] numbers){
 	    int total = 0;
        for(String number : numbers){
		    total += toInt(number);
		}
		return total;
    }
    #After refactoring
    public static int add(String text){
		if(text.equals("")){
			return 0;
		}
		else if(text.contains(",")){
			return sum(splitNumbers(text));
		}
		else
			return 1;
	}