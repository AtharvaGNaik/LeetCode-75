class Solution {
    public String gcdOfStrings(String str1, String str2) {
        int gcdLen;
        if(!(str1+str2).equals(str2+str1))
        {
           return"";
        }
        else{
            gcdLen=gcd(str1.length(),str2.length());
           
            return str1.substring(0,gcdLen);
        }
    }
    private int gcd(int a, int b)
    {
        int temp;
         while(b!=0)
            {
              temp = b;
              b = a % b;
              a = temp;
            }
            return a;
    }
}
