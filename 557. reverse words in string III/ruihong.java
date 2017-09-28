class Solution {
    public String reverseWords(String s) {
        String result = "";
        String[] value = s.split(" ");
        for(int i = 0; i < value.length; i++)
        {
            String output = "";
		    byte[] in = value[i].getBytes();
		    byte[] out = new byte[in.length];
            for(int j = 0; j < in.length; j ++)
                out[j] = in[in.length - 1 - j];
            if(i + 1 < value.length)
            {
                result = result + new String(out) + " ";
            }
            else 
            {
                result = result + new String(out);
            }
                
        }
        return result;
    }
}