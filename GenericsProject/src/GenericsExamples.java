import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://docs.oracle.com/javase/tutorial/java/generics/index.html
 * @author Trevor Chase
 *
 */


public class GenericsExamples {

	public void boxesTest(){
		List<Box<String>> boxStringList = new ArrayList<>();
		
		Box<String> boxString = new Box<>();
		boxString.setObj("A String");

		Box<String> boxString2 = new Box<>();
		boxString2.setObj("A String");
		
		boxStringList.add(boxString);
		boxStringList.add(boxString2);
		
		List<Box<Integer>> boxIntList = new ArrayList<>();
		
		Box<Integer> boxInt = new Box<>();
		boxInt.setObj(12113);

		Box<Integer> boxInt2 = new Box<>();
		boxInt2.setObj(2323);
		
		boxIntList.add(boxInt);
		boxIntList.add(boxInt2);
		
		boxString.inspect(123);

	}
	
	public void pairsTest(){
		Pair<String, String> pair1 = new OrderedPair<>("job1", "teacher");
		Pair<Integer, String> pair2 = new OrderedPair<>(1, "card1");
		
		System.out.println(pair1.getKey());
		System.out.println(pair2.getKey());
		
		System.out.println(pair1.getValue());
		System.out.println(pair2.getValue());
	}
	
	public void showSumOfNumbers(){
		sumOfNumbers(Arrays.asList(1,2,3,4));
		sumOfNumbers(Arrays.asList(4L, 323L, 88L));
		
		List<Double> numberList = new ArrayList<>();
		numberList.add(34.23);
		numberList.add(98.34);
		
		sumOfNumbers(numberList);
	}
	
	// Used typically within collections.  Good for DAOs (Data Access Objects)
	// Lower Bounds:
	// <? extends Number> means that the type can be anything as long as it extends the number class
	//					  used in methods that get or retrieve information from an object
	// Upper Bounds: 
	// <? super Number> means that the type can be anything as long as it the super class of number
	//					used in methods that get or set information within an object
	public void sumOfNumbers(List<? extends Number> numbers){
		double d = 0.0;
		for(Number n: numbers){
			d=d + n.doubleValue();
		}
	}
	
}
