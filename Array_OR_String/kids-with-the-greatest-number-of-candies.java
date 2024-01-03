class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
List<Boolean> result = new ArrayList<>();
        int max=0;
        for(int candy:candies)
        {  max=Math.max(max,candy);
            // if(max <= candies[i]){
            //     max=candies[i];
    //calculate largest as extra is constant and largest is constant so....
            
        }
        for(int candy:candies)
        {
        
         result.add((candy+extraCandies>=max));

            // if((candies[i]+extraCandies)>=max)
            // {
            //   result.add(true);
            // }
            // else{
            //     result.add(false);
            // }
        }
        return result;
    }
}
