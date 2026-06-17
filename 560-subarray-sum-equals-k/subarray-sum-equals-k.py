class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        # Dictionary to store the frequency of prefix sums
        # Base case: A prefix sum of 0 has occurred 1 time (empty prefix)
        prefix_sums = {0: 1}
        
        current_sum = 0
        total_subarrays = 0
        
        for num in nums:
            # Update the running cumulative sum
            current_sum += num
            
            # Check if there is a previous prefix sum that satisfies: 
            # current_sum - previous_prefix_sum = k  ->  previous_prefix_sum = current_sum - k
            diff = current_sum - k
            if diff in prefix_sums:
                total_subarrays += prefix_sums[diff]
                
            # Record the current prefix sum in the dictionary
            prefix_sums[current_sum] = prefix_sums.get(current_sum, 0) + 1
            
        return total_subarrays