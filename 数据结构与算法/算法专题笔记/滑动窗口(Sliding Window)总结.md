### 一、滑动窗口思想：

> ①）窗口由两个指针构成，一个左指针left，一个右指针right，然后[left,right]表示的索引范围是一个窗口了。
>
> ②）右指针right的功能是用来扩展窗口：当窗口内的条件没有达到题目要求时，我们需要不断移动右指针right直到窗口内的条件第一次满足题目要求为止。
>
> ③）左指针left的功能是用来缩小窗口的：当窗口内的条件已满足题目条件或多于题目条件时（窗口溢出），我们缩小窗口，也就是左指针left需要右移直到窗口条件不满足为止。这时，我们需要记录当前窗口的大小，并更新目前为止满足条件的最小窗口记录。之后，再次扩展右指针right，使得窗口满足题目的条件。

**注：滑动窗口用来处理连续满足一定条件的连续区间的性质（长度等）问题的，两个指针都起始于原点，并一前一后向终点前进。**
————————————————
[参考链接](https://blog.csdn.net/qq_43152052/article/details/102840715)

### 二、 习题解析： 

+  [leetcode3. 无重复字符的最长子串](https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/)：用set用来当窗口，用来存放遍历到的字符，若没有遇到重复字符，right继续扩展，同时更新max；若遇到重复字符，我们需要缩小窗口，也就是left右移。具体可见：[题解](https://blog.csdn.net/qq_43152052/article/details/99714650)。 

+ leetcode76.最小覆盖子串：用两个hashmap（window,needs）来建立字符表，其中needs用来建立存放模式串t的字符表，window用来存放总串s中用来和needs匹配字符的字符表。当窗口的字符个数满足needs时，我们需要更新子串的长度以及子串的起始位置，然后就是缩小窗口了。具体可见：题解。

+ leetcode239滑动窗口最大值：本题就是滑动窗口的练手题，第一种解法就是暴力法求解，当窗口的大小等于k时，我们需要将该窗口内的最大值添加到result中，同时右移左指针left将窗口缩小；当窗口的大小小于k时，我们进行滑动right就行了。

  第二种解法使用双向队列作为窗口，来保存数组的下标，并保持窗口头部的下标表示的元素为该窗口的最大值。具体可见：题解。

+  [leetcode424. 替换后的最长重复字符](https://leetcode-cn.com/problems/longest-repeating-character-replacement/)：本题字符表来表示窗口，窗口的大小与最多字符个数之间的差值表示可以替换的字符个数，当可以替换的字符个数大于k时，我们需要缩小窗口，也就是left右移，直到可以替换的字符个数等于k时，我们可以得到结果。具体可见：[题解](https://blog.csdn.net/qq_43152052/article/details/102578696)。 

+  [leetcode438. 找到字符串中所有字母异位词](https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/)：本题求的是模式串p在总串s中的所有字母异位词，所以我们所建立的窗口windows大小维持在与模式串p生成的字符表needs的大小相等即可。具体可见：[题解](https://blog.csdn.net/qq_43152052/article/details/102509079)。 

+ leetcode滑动窗口中位数：对于暴力法求窗口内的中位数导致超时，所以我们使用multiset利用其底层为二叉排序树的数据结构来作为窗口，因为二叉排序树，插入和删除元素的时间复杂度为0(logn)，所以我们利用其自排序功能可以很快的求出中位数。具体可见：题解。

+ leetcode字符串的排列：本题属于438.找到字符串中的所有字母异位词的子题，前者是找到所有异位词并添加异位词出现的下标，而本题比前者简单多了，若在总串找到模式串的异位词，直接返回ture就行了；若遍历完整个总串也没找到模式串的异位词，返回false就行。具体可见：题解。

+ leetcodeK个不同整数的子数组：使用hashmap来表示窗口，具体可见：题解

+ leetcodeK连续位的最小翻转次数：本题使用队列来作为窗口，window用来存放被反转元素的下标，window的长度表示反转的次数。具体可见：题解。

+ leetcode最长湍流子数组：当窗口到达数组末尾或者湍流不成立，我们需要划分窗口。具体可见：题解。

+ leetcode移动石子直到连续Ⅱ：具体可见：题解。

+  [leetcode1052.爱生气的书店老板](https://leetcode-cn.com/problems/grumpy-bookstore-owner/)：对于不生气的人数我们需要全部加上，我们的滑动窗口用来统计窗口大小为X内的不生气人数，然后需要记录所有窗口中最多的生气人数，最后结果就是不生气人数加上所有窗口中最多的生气人数。具体可见：[题解](https://blog.csdn.net/qq_43152052/article/details/102749706)。 

+ leetcode [1074.元素和为目标值的子矩阵数量](https://leetcode-cn.com/problems/number-of-submatrices-that-sum-to-target/)：对于每一行计算前缀和，对于每一列计算行累加和，然后这个问题就变成和目标和子数组相同了。具体可见：[题解](https://blog.csdn.net/qq_43152052/article/details/102839238)。 

+ leetcode [1208.尽可能使字符串相等](https://leetcode-cn.com/problems/get-equal-substrings-within-budget/)：口表示t和s的相对应的子字符串做差值之后的cost。若窗口内的cost小于等于maxCost时，我们需要记录最长的子字符串；若cost大于maxCost的话，表示窗口溢出，我们需要缩小窗口了。具体可见：[题解](https://blog.csdn.net/qq_43152052/article/details/102750441)。 

  

  ————————————————

### 三、总结