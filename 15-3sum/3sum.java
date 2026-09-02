class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int l = nums.length - 1;
        Arrays.sort(nums);
        
        
        for (int xIdx = 0; xIdx <= l; xIdx++) {
            if (xIdx > 0 && nums[xIdx] == nums[xIdx - 1])
                continue;
            
            
            int yIdx = xIdx + 1;
            int zIdx = l;
            
            
            while (zIdx > yIdx) {
                int summ = nums[xIdx] + nums[yIdx] + nums[zIdx];
                
                
                if (summ > 0)
                    zIdx--;
                else if (summ < 0)
                    yIdx++;
                else {
                    List<Integer> subAns = new ArrayList<>();
                    subAns.add(nums[xIdx]);
                    subAns.add(nums[yIdx]);
                    subAns.add(nums[zIdx]);
                    ans.add(subAns);
                    yIdx++;
                    zIdx--;


                    while (zIdx > yIdx && nums[yIdx - 1] == nums[yIdx])
                        yIdx++;


                    while (zIdx > yIdx && nums[zIdx] == nums[zIdx + 1])
                        zIdx--;
                }
            }
        }
        
        
        return ans;
    }
}