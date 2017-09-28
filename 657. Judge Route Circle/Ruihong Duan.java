class Solution {
    public boolean judgeCircle(String moves) {
        int horizon = 0;
		int vertical = 0;
		char[] ch = moves.toCharArray();
		
		for (int i = 0; i < ch.length ; i++)
		{
			
			if(ch[i] == 'R')
				horizon++;
			else if(ch[i] == 'U')
				vertical++;
			else if(ch[i] == 'L')
				horizon--;
			else 
				vertical--;
		}
		
		if(horizon == 0 && vertical == 0)
			return true;
		else
			return false;
    }
}