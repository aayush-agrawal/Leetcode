class Solution {
    public int romanToInt(String s) {
        
        if(s.isEmpty()) {
            return 0;
        }
        
        Map<Character, Integer> map = Map.of('I',1,'V',5,'X',10,'L',50,'C',100,'D',500,'M',1000);
        char[] arr = s.toCharArray();
        
        int result = map.get(arr[s.length()-1]);
        
        for(int i=s.length()-2; i>=0; i--) {
            if(map.get(arr[i])>=map.get(arr[i+1]))
                result += map.get(arr[i]);
            else
                result -= map.get(arr[i]);
        }
        
        return result;
    }
}