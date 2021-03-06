## 二分搜索

要点：source 按顺序排列，可比大小。

代码要点：注意while 循环的终止条件和mid +/-1

复杂度：O(logn)

顺序匹配搜索：O(n)

## 选择排序

要点：双循环，内循环每次选择一个最大or最小值，并同时删除该值。

复杂度:O(n*n)

## 快速排序



要点：分而治之思想，先找出最简单的情况（0个或1个数组元素），再增加一点复杂度（两个元素数组）的情况如何处理。任意找到一个基准点值，根据小于和大于这个值将数组分成两个数组，把这两个数组放入方法递归使他们排好序然后拼接 smaller,基准值，bigger=>最终为从小到大排列的数组。

复杂度：递归调用的广度和深度O(nlogn)

## 广度优先搜索

要点：从一个root节点开始，优先递归子节点，如果一个子节点不是目标，把这个子节点的子节点数组添加到搜索数组当中。

复杂度：O(V+N)，n节点数，V链接的边数

## 迪杰斯特拉算法

要点：问题最简单化，已知从A点出发，可以分别到达B点和C点，而从B也可以到达C点,那么你如何计算从A点出发cost最小到达B点和C点？

假设从cost(A,B) = 2,cost(A,C) = 2，cost(B,C) = 1。显然，A到B，A到C的cost最小都是2,也即是直达。

我们来改变条件：cost(A,B) = 2,cost(A,C) = 4，cost(B,C) = 1，显然，从A->C，我们可以选择从A->B->C = 3,小于A直达C。

上面距离方式，而我们用程序怎么描述呢？

突破点：一个必然点就是，如果A仅可以达到C，我们求A->C最小cost点时，肯定认为就是A直达C最短。

如果A可以到达两个点以上，我们就需要考虑，是否存在一个点N，使得AN+NC < AC的存在。

特例，如果我们已知C点是A出发能直达的各个点中，cost最小的，那么显然AN+NC>AC，比如
cost(A,B) = 2,cost(A,C) = 1，cost(A,D)=3,cost(B,C) = 1，你会发现C点是直达点中，最近的一个，ok，所以此时，你应该有”贪婪“的想法，就是我先去离A点最近的点，说不定这个点去另外的点，比直达点更近，这个是算法的关键。

再次回到 cost(A,B) = 2,cost(A,C) = 4，cost(B,C) = 1

B点就是我们的这个关键贪婪点，显然这个B点是确定了的，从A到B cost最小的点，怎么求出这个点呢？

我们以A到各个点的cost来组成一个数组

[0,2,4] 显然，除去0，我们求出这个数组最小值为2。

我们查看基于cost2，遍历可到达的点，应该是C点，我们回头查询，A点到达C点的值是4，而4>2+cost(B,C) ，好，我们把2+1 = 3 填入上面这个数组 [0,2,3]，显然，我们知道了A->C的路径变成了A->B->C ,cost最小。

推广到一般的情况，有些点，A可能直达不了，需要跳转，但是跳转的路径有很多，怎么选择cost最短的路径呢？其实过程和上面的一样，就是一个由近及远的，覆盖刚才那个数组的过程。



例子：

```
 0,1,2,3 四个点，0->(1,2),2->(1,3),1->(3)
* weight(0,1) = 4
* weight(0,2) = 1
* weight(2,1) = 2
* weight(2,3) = 4
* weight(1,3) = 1
```

我们先求从0到达点3的cost最小的值和路径：

1. 构建0到各个顶点的权重，weights = [0,4,1,NaN]

2. 取出这个数组中离0最近的直达点，这个点不在已经处理过的点的列表中。

3. 2的结果就是2号点，权重是1，那么我们看下它能到达的点分别是1号点和3号点。我们查权重数组，发现如果从0到1，需要权重是4，而我们从0->2->1只要1+2 = 3,所以我们把这值替换4，[0,3,1,NaN].

   3号点原先是无法直达的，现在则知道可以从2点达到它，所以[0,3,1,5]。结束了吗？还有关键一步，把2号点记录为依据处理过的点。所谓已经处理过的点，就是说这个点已经是求得cost最小的点了。

4. 继续返回2，得到的点是1号点，花费是3。这个过程和3一样，查找到1可以到达3，而那么计算0->1->3的cost是3+1 = 4,是小于原先从2到达3号点的，所以数组变成了[0,3,1,4]。记录1号点已经求得最短路径。

5. 返回2，求得 3号点，花费4。它没有点可去了，整个过程结束。

我们来查找表，发现weights[3] = 4，所以0->3 cost 最少是4。

实际代码中，我们还会去记录实际的路径，比如0->2->1->3，这个比较简单，不做描述。

上面的代码就是在用查找到某个贪婪点能达到的点，看起始点到达这个点的cost是否低于权重数组里的值。

简化公式就是是否符合 AN+NC<AC ，如果存在，那么AC的路径就变成AN->NC，其中，这个N，你可以认为是这样的，AN0+N0N1+N1N2+N(i-1)N(i) <AC。

