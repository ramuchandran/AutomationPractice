import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MathUtil {
	
	public static Integer[] sortNumbersByOccurences(int[] nums) {
		 Map<Integer, Integer> numMap = IntStream.of(nums).boxed()
		.collect(Collectors.toMap(i->i, i-> 1,(existinCount,newCount)-> existinCount+newCount));
		TreeMap<Integer,Integer> sortedMap = new TreeMap<Integer,Integer>(new ValueComparator(numMap));
		sortedMap.putAll(numMap);
		return sortedMap.keySet().toArray(new Integer[0]);
	}
	
	public static void main(String[] args) {
		int[] nums = {5,5,6,2,3,3,3,4,7,8,1,9,9,9,16,20,20};
		Integer[] sorted = sortNumbersByOccurences(nums);
		System.out.println(Arrays.toString(sorted));
	}

}

class ValueComparator implements  Comparator<Integer>{
	
	Map<Integer, Integer> numMap ;
	public ValueComparator(Map<Integer, Integer> numMap ) {
		this.numMap = numMap;
	}

	@Override
	public int compare(Integer key1, Integer key2) {
		Integer val1 = numMap.get(key1);
		Integer val2 = numMap.get(key2);
		int compare= val1.compareTo(val2);
		return compare!=0?compare: key1.compareTo(key2);
	}
	
}
