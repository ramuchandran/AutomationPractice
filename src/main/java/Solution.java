import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {    
    public int maxLength(List<String> arr) {
        return helper(arr,0,"");
    }
    
    private int helper(List<String> arr,int index,String cur){        
        if(index==arr.size()){
            return cur.length();
        }     
        
        int res=cur.length();
        for(int i=index;i<arr.size();i++){
            String str=cur+arr.get(i);           
            if(isUnique(str)){
                res=Math.max(res,helper(arr,i+1,str)); 
                System.out.println(str);
            }
            
        }
        return res;
    }
    
    private boolean isUnique(String s){
        Set<Character> set=new HashSet<>();
        for(char c:s.toCharArray()){
            if(!set.add(c)){
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
//		String[] str= {"co","dil","ity"};
		String[] str= {"abc","yyy","tyn","jan"};
		Solution solution= new Solution();
		System.out.println(solution.maxLength(Arrays.asList(str)));
	}
}