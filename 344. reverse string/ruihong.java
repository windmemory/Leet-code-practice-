class Solution {
    public String reverseString(String s) {
        String output = "";
		byte[] in = s.getBytes();
		byte[] out = new byte[in.length];
		
		for(int j = 0; j < in.length; j++)
		{
			out[j] = in[in.length - 1 - j];
		}	
		output = new String(out);
		return output;
    }
}