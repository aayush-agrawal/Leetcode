class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        
        Map<Integer, Integer> map = new TreeMap<>();
        for(int i=0; i<arr1.length; i++) {
            map.putIfAbsent(arr1[i],0);
            map.put(arr1[i], map.get(arr1[i])+1);
        }
        
        int[] result = new int[arr1.length];
        int index = 0;
        for(int i=0; i<arr2.length; i++) {
            if(map.containsKey(arr2[i])) {
                int count = map.get(arr2[i]);
                while(count-->0) {
                    result[index++] = arr2[i];
                }
                map.remove(arr2[i]);
            }
        }
        
        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            int count = entry.getValue();
            for(int i=0; i<count; i++) {
                result[index++] = entry.getKey();        
            }

        }
        
        return result;
    }
}