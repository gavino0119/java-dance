#### [70. 爬楼梯](https://leetcode-cn.com/problems/climbing-stairs/)

>  f(x)=f(x−1)+f(x−2) 

1. 暴力递归

   ```java
   class Solution {
       public int climbStairs(int n) {
           if(n==1)
               return 1;
           if(n==2)
               return 2;
           return climbStairs(n-1) + climbStairs(n-2); 
       }
   }
   ```

   

2. 记忆化递归

   ```java
   class Solution {
       public int climbStairs(int n) {
           //记忆化递归
           int[] memo = new int[n+1];//存储中间结果，避免重复计算
           return climbStairsMemo(n,memo);
       }
   
       public int climbStairsMemo(int n,int[] memo){
           //有值时直接返回
           if(memo[n]>0)
               return memo[n];
           if(n==1){
               memo[n] = 1;
           }else if(n==2){
               memo[n] = 2;
           }else{
               memo[n] = climbStairsMemo(n-1,memo) + climbStairsMemo(n-2,memo);
           }
           return memo[n];
       }
   }
   ```

   

3. 动态规划

   ```java
   class Solution {
       public int climbStairs(int n) {
           //dp
           if(n==1)
               return 1;
           
           //记录n个状态，从1到n依次更新
           int[] dp = new int[n+1];
           dp[1] = 1;
           dp[2] = 2;
   
           for(int i=3;i<=n;i++){
               dp[i] = dp[i-1] + dp[i-2];
           }
           return dp[n];
       }
   }
   ```

   

4. 利用滚动数组将空间复杂度优化到O（1）

   ```java
   class Solution {
       public int climbStairs(int n) {
           //dp
           if(n==1)
               return 1;
           
           //记录n个状态，从1到n依次更新
           /*
           int[] dp = new int[n+1];
           dp[1] = 1;
           dp[2] = 2;
           */
           int first = 1;
           int second = 2;
           for(int i=3;i<=n;i++){
               // dp[i] = dp[i-1] + dp[i-2];
               int third = first + second;
               first = second;
               second = third;
           }
           // return dp[n];
           return second;
       }
   }
   ```

   

#### [198. 打家劫舍](https://leetcode-cn.com/problems/house-robber/)