class Solution:
    def smallestDistancePair(self, nums: list[int], k: int) -> int:
        nums.sort()
        n = len(nums)
        lo, hi = 0, nums[-1] - nums[0]

        def count_pairs(dist):
            """Count pairs with distance <= dist using two pointers."""
            cnt = 0
            left = 0
            for right in range(n):
                while nums[right] - nums[left] > dist:
                    left += 1
                cnt += right - left
            return cnt

        while lo < hi:
            mid = (lo + hi) // 2
            if count_pairs(mid) >= k:
                hi = mid
            else:
                lo = mid + 1
        return lo
        