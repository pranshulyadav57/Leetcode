class Solution:
    def threeFibonacciSum(self, n: int) -> bool:
        a = 0;
        b = 1;
        while((a+b) < n) :
            c = a+b;
            if((a+b+c) == n) :
                return True
            a = b;
            b = c;
        return False
        
        