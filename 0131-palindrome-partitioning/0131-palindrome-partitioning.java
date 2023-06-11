class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result=new ArrayList<>();
        List<String> current_list=new ArrayList<>();
        backtrack(result, s, 0, current_list);    
        return result;
    }
    
    void backtrack(List<List<String>> result, String s, int index, List<String> current_list) {
        if(s.length()==index) {
            result.add(new ArrayList<>(current_list));
            return;
        }
        
        for(int i=index; i<s.length();i++) {
            if(isPalindrome(s, index, i)) {
             current_list.add(s.substring(index, i+1));
             backtrack(result, s, i+1, current_list);
             current_list.remove(current_list.size()-1);
            }
        }
    }
    
    boolean isPalindrome(String s, int start, int end) {
        while(start<=end) {
            if(s.charAt(start++)!=s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }
}