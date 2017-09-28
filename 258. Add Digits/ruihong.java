class Solution {
    public int addDigits(int num) {
        int result = 0;
		while(num >= 10)
		{
			result = num % 10 + result;
			num = num / 10;
		}
		result = num + result;
		
		if(result >= 10)
			return addDigits(result);
		else
			return result;
    }
}