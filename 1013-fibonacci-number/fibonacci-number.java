class Solution {
    public int fib(int n) {
        return fibo(n);    
    }
    private int fibo(int n){
        //base condition
        if(n==0) return 0;

        if(n==1) return 1;
        //recursive relation
        return fibo(n-1)+fibo(n-2);
    }
}