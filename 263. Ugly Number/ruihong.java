class Solution {
    public boolean isUgly(int num) {
        int temp = 0;
        while(num != 1)
        {
            temp = num;
            if(num % 2 == 0)
                num = num / 2;
            if(num % 3 == 0)
                num = num / 3;
            if(num % 5 == 0)
                num = num / 5;
            if(num == temp)
                return false;
        }
        return true;
    }
}