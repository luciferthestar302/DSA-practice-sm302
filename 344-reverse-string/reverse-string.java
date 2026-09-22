class Solution {
    public void reverseString(char[] s) {
        
    //     int left = 0; int right = s.length-1;
    // //     while(left<=right){
    //         char tmp = s[left];
    //         s[left]  = s[right];
    //         s[right] = tmp;
    //         left++;
    //         right--;
    //     }
    // }
    // Using Recursion
    
    reverseSString(s, 0, s.length-1);
    }
    private void reverseSString(char[] s, int left, int right){
        if(left>=right) return;

        char tmp = s[left];
        s[left]  = s[right];
        s[right] = tmp;
    reverseSString(s, left+1, right-1);    
    } 
}