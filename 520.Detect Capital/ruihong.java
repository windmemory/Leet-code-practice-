class Solution {
    public boolean detectCapitalUse(String word) {
        		byte[] in = word.getBytes();
		if(in.length > 1)
		{
			if(in[0] >= 'a' && in[0] <= 'z')
			{
				for(int i = 1; i < in.length; i++)
				{
					if(in[i] < 'a' || in[i] >'z')
						return false;
				}
				return true;
			}
			else
			{
				if(in[1] >= 'a' && in[1] <= 'z')
				{
					for(int i = 1; i < in.length; i++)
					{
						if(in[i] < 'a' || in[i] >'z')
							return false;
					}
					return true;
				}
				else
				{
					for(int i = 1; i < in.length; i++)
					{
						if(in[i] < 'A' || in[i] >'Z')
							return false;
					}
					return true;
				}
			}
		}
		else
			return true;
    }
}