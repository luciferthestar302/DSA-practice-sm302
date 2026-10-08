class Solution {
    public int maxChunksToSorted(int[] arr) {
        int count=0;
        int cumSum = 0;
        int sum = 0; //Original array sum

        for(int i=0;i<arr.length;i++){
            cumSum+=arr[i];

            sum+=i;

            if(cumSum==sum){
                count++;
            }
        }
        return count;
    }
}