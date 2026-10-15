class Solution {
    public int mySqrt(int x) {
        long maxPossible = 0;
        if(x==1)
            return 1;
        for(long i=1; i<x; i++)
        {
            if(i*i==x)
            {
                maxPossible = i;
                return (int)i;
            }
            else if(i*i < x)
                maxPossible = i;
            else
                break;
        }
        return (int)maxPossible;
    }
}