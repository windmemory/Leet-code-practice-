class Solution {
    public int hammingDistance(int x, int y) {
        int result = 0;
        while(x != 0 || y != 0)
        {
        	//System.out.println(x + " " + y);
        	if (x % 2 != y % 2)
        		result++;
        	
        	x = x / 2;
        	y = y / 2;
        	//System.out.println(x + " " + y);
        }
        
        return result;
    }
    
}