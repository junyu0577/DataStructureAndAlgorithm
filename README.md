# DataStructureAndAlgorithm

### 目录

* [DataStructure](#datastructure)
   * [排序](#排序)
       * [基础排序](#基础排序)
       * [高级排序](#高级排序)
   * [线性](#线性)
       * [数组](#数组)
       * [栈](#栈)
       * [队列](#队列)
   * [堆](#堆)
   * [树](#树)
        * [二分搜索树](#二分搜索树)
        * [AVL树](#avl树)
        * [线段树](#线段树)
        * [字典树/前缀树](#trie)
   * [并查集](#并查集)
   * [图](#图)
       * [无权图](#无权图)
       * [带权图](#带权图)
       * [最小生成树](#最小生成树)
       * [最短路径](#最短路径)

* [LeetCode](#LeetCode)
  * [Array](#array)
  * [String](#string)
  * [Sort](#sort)
  * [LinkedList](#linkedlist)
  * [Tree](#tree)
  * [Math](#math)
  * [HashTable](#hashtable)
  * [DP](#dp)
  * [Others](#others)
  * [Backtracking](#backtracking)
  * [Heap](#heap)
  * [Greedy](#greedy)



### datastructure

#### 排序
##### 基础排序
|  名称  | 描述 |
|---|---|
|  [选择排序](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/data_structure/sort/SelectionSort.java) |  |
|  [冒泡排序](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/data_structure/sort/BubbleSort.java) |  |
|  [插入排序](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/data_structure/sort/InsertionSort.java) |  |
|  [插入排序优化](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/data_structure/sort/InsertionSort2.java) | 通过减少交换的操作,提升效率 |

##### 高级排序
|  名称  | 描述 |
|---|---|
|  [希尔排序](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/data_structure/sort/ShellSort.java) | 强化版的插入排序 |
|  [归并排序](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/data_structure/sort/MergeSort.java) |  |
|  [归并排序优化](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/data_structure/sort/MergeSort2.java) | 针对近乎有序的数组，通过减少merge操作以及当元素的数量少于等于16个时使用插入排序 |
|  [归并排序BU](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/data_structure/sort/MergeSortBU.java) | 改递归为遍历，自底向上进行归并 |
|  [快速排序](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/data_structure/sort/QuickSort.java) |  |
|  [快速排序优化](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/data_structure/sort/QuickSort2.java) | 针对近乎有序的数组，防止时间复杂度退化到O(n^2) |
|  [二路快速排序](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/data_structure/sort/QuickSort3.java) | 针对近乎有序的数组，提升效率 |
|  [三路快速排序](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/data_structure/sort/QuickSort4.java) | 针对存在大量重复元素的数组，提升效率 |
|  [堆排序](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/data_structure/sort/HeapSort.java) |  |
|  [堆排序优化](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/data_structure/sort/HeapSort2.java) | 通过Heapify数组建堆代替原先的insert逐个插入 |
|  [原地堆](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/data_structure/sort/HeapSort3.java) | 没有开辟新的数组空间，直接在原来的数组上进行堆排 |


#### 线性
##### 数组
|  名称  | 描述 |
|---|---|
|  [数组](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/data_structure/linear/Array.java) | 动态数组 |

##### 栈
|  名称  | 描述 |
|---|---|
|  [栈](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/data_structure/linear/StackArray.java) | 基于数组的实现 |

##### 队列
|  名称  | 描述 |
|---|---|
|  [队列](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/data_structure/linear/QueueArray.java) |  |
|  [循环队列](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/data_structure/linear/LoopQueue.java) | 出队操作为O(1) |


#### 堆
|  名称  | 描述 |
|---|---|
|  [最大堆](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/data_structure/heap/MaxHeap.java) |  |
|  [最小堆](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/data_structure/heap/MinHeap.java) |  |
|  [最大索引堆](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/data_structure/heap/MaxIndexHeap.java) | 通过增加索引数组，避免直接对数据进行交换操作 |
|  [最小索引堆](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/data_structure/heap/MinIndexHeap.java) | 同上 |

#### 树
##### 二分搜索树
|  名称  | 描述 |
|---|---|
|  [二分查找](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/data_structure/binary_search_tree/Binary_Search.java) |  |
|  [二分搜索树](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/data_structure/binary_search_tree/BST.java) |  |
|  [二分搜索树遍历](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/data_structure/binary_search_tree/BST_Order.java) | 深度优先（前中后序遍历）、广度优先(层序遍历) |
|  [二分搜索树删除](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/data_structure/binary_search_tree/BST_Delete.java) | Hibbard Deletion |


##### avl树
|  名称  | 描述 |
|---|---|
|  [AVL树](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/data_structure/binary_search_tree/avl/AVLTree.java) | 通过LL/RR/LR/RL 操作维护平衡因子，达到自平衡 |


##### 线段树
|  名称  | 描述 |
|---|---|
|  [线段树](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/data_structure/binary_search_tree/segment_tree/SegmentTree.java) | 存放给定区间内对应的信息,针对区间内数据频繁变更 |

##### trie
|  名称  | 描述 |
|---|---|
|  [Trie](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/data_structure/binary_search_tree/trie/Trie.java) | 查询与添加操作的效率取决于元素的长度而非树中的数量 |



#### 并查集
|  名称  | 描述 |
|---|---|
|  [并查集](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/data_structure/union_find/UnionFind.java) | QUICK FIND，union和isConnected时间复杂度分别为O(n) 和 O(1) |
|  [并查集优化](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/data_structure/union_find/UnionFind2.java) | QUICK UNION，提升union过程的效率 |
|  [并查集优化](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/data_structure/union_find/UnionFind3.java) | 基于SIZE的优化 |
|  [并查集优化](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/data_structure/union_find/UnionFind4.java) | 基于RANK的优化 |
|  [并查集优化](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/data_structure/union_find/UnionFind5.java) | 路径压缩 (Path Compression) |
|  [并查集优化](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/data_structure/union_find/UnionFind6.java) | 路径压缩 (Path Compression) 递归方式|

#### 图
##### 无权图
|  名称  | 描述 |
|---|---|
|  [图的表示](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/data_structure/graph/DenseGraph.java) | 邻接矩阵 |
|  [图的表示](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/data_structure/graph/SparseGraph.java) | 邻接表 |
|  [图文件读取](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/data_structure/graph/ReadGraph.java) | 用于测试图 |
|  [DFS求连通分量](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/data_structure/graph/Component.java) |  |

##### 带权图
|  名称  | 描述 |
|---|---|
|  [图的表示](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/data_structure/graph/weight/DenseWeightGraph.java) | 邻接矩阵 |
|  [图的表示](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/data_structure/graph/weight/SparseWeightGraph.java) | 邻接表 |

##### 最小生成树
|  名称  | 描述 |
|---|---|
|  [Prim算法](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/data_structure/graph/weight/LazyPrimMST.java) | (Lazy Prim) |
|  [Prim算法优化](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/data_structure/graph/weight/PrimMST.java) |  |
|  [Kruskal算法](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/data_structure/graph/weight/KruskalMST.java) |  |

##### 最短路径
|  名称  | 描述 |
|---|---|
|  [Dijkstra算法](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/data_structure/graph/weight/Dijkstra.java) | 针对没有负权边的图 |
|  [Bellman Ford算法](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/data_structure/graph/weight/BellmanFord.java) | 针对有负权边而没有负权环的图 |

<br/>

### LeetCode

#### Array

|  难度  | 问题 |
|---|---|
|  easy | [Two Sum](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/array/_001_TwoSum.java) |
|  easy | [Two Sum II Input array is sorted](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/array/_167_Two_Sum_II_Input_array_is_sorted.java) |
|  easy | [Single Number](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/array/_002_SingleNumber.java) |
|  easy | [Rotate Array](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/array/_003_RotateArray.java) |
|  easy | [Move Zeroes](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/array/_004MoveZeroes.java) |
|  easy | [Contains Duplicate](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/array/_005_ContainsDuplicate.java) |
|  easy | [Remove Duplicates from Sorted Array](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/array/_006_RemoveDuplicatesfromSortedArray.java) |
|  easy | [Intersection Of Two Arrays II](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/array/_007_IntersectionOfTwoArrays_II.java) |
|  easy | [Plus One](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/array/_008_PlusOne.java) |
|  easy | [Best Time To Buy And Sell Stock II](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/array/_009_BestTimeToBuyAndSellStockII.java) |
|  easy | [Rotate Image](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/array/_010_RotateImage.java) |
|  easy | [Range Sum Query - Immutable](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/array/_303_Range_Sum_Query_Immutable.java) |
|  easy | [Valid Sudoku](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/array/_036_Valid_Sudoku.java) |
|  easy | [Single Number](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/array/_136_Single_Number.java) |
|  easy | [Find All Numbers Disappeared in an Array](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/array/_448_Find_All_Numbers_Disappeared_in_an_Array.java) |
|  easy | [Flipping an Image](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/array/_832_Flipping_an_Image.java) |
|  easy | [Array Partition I](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/array/_561_Array_Partition_I.java) |
|  easy | [Transpose Matrix](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/array/_867_Transpose_Matrix.java) |
|  easy | [Max Consecutive Ones](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/array/_485_Max_Consecutive_Ones.java) |
|  easy | [Majority Element](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/array/_169_Majority_Element.java) |
|  easy | [Toeplitz Matrix](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/array/_766_Toeplitz_Matrix.java) |
|  easy | [Largest Number At Least Twice of Others](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/array/_747_Largest_Number_At_Least_Twice_of_Others.java) |
|  easy | [Remove Element](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/array/_027_Remove_Element.java) |
|  easy | [Search Insert Position](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/array/_035_Search_Insert_Position.java) |
|  easy | [Positions of Large Groups](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/array/_830_Positions_of_Large_Groups.java) |
|  easy | [Maximum Product of Three Numbers](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/array/_628_Maximum_Product_of_Three_Numbers.java) |
|  easy | [Peak Index in a Mountain Array](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/array/_852_Peak_Index_in_a_Mountain_Array.java) |
|  easy | [Intersection of Two Arrays](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/array/_349_Intersection_of_Two_Arrays.java) |
|  easy | [Find Smallest Letter Greater Than Target](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/array/_744_Find_Smallest_Letter_Greater_Than_Target.java) |
|  easy | [Binary Search](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/array/_704_Binary_Search.java) |
|  easy | [Fair Candy Swap](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/array/_888_Fair_Candy_Swap.java) |
|  easy | [Non decreasing Array](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/array/_665_Non_decreasing_Array.java) |
|  easy | [Max Area of Island](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/array/_695_Max_Area_of_Island.java) |
|  easy | [Next Greater Element I](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/array/_496_Next_Greater_Element_I.java) |
|  easy | [1 bit and 2 bit Characters](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/array/_717_1_bit_and_2_bit_Characters.java) |
|  easy | [Monotonic Array](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/array/_896_Monotonic_Array.java) |
|  easy | [Reshape the Matrix](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/array/_566_Reshape_the_Matrix.java) |
|  easy | [Find Pivot Index](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/array/_724_Find_Pivot_Index.java) |
|  easy | [Maximum Average Subarray I](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/array/_643_Maximum_Average_Subarray_I.java) |
|  easy | [Sort Array By Parity](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/array/_905_Sort_Array_By_Parity.java) |
|  easy | [X of a Kind in a Deck of Cards](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/array/_914_X_of_a_Kind_in_a_Deck_of_Cards.java) |
|  easy | [Teemo Attacking](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/array/_495_Teemo_Attacking.java) |
|  easy | [Sort Array By Parity II](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/array/_922_Sort_Array_By_Parity_II.java) |
|  easy | [Relative Ranks](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/array/_506_Relative_Ranks.java) |
|  easy | [Smallest Range I](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/array/_908_Smallest_Range_I.java) |
|  easy | [Unique Email Addresses](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/array/_929_Unique_Email_Addresses.java) |
|  easy | [Degree of an Array](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/array/_697_Degree_of_an_Array.java) |
|  easy | [Reorder Log Files](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/array/_937_Reorder_Log_Files.java) |
|  easy | [Valid Mountain Array](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/array/_941_Valid_Mountain_Array.java) |
|  easy | [N-Repeated Element in Size 2N Array](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/array/_961_N_Repeated_Element_in_Size_2N_Array.java) |
|  easy | [Squares of a Sorted Array](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/array/_977_Squares_of_a_Sorted_Array.java) |
|  easy | [Largest Perimeter Triangle](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/array/_976_Largest_Perimeter_Triangle.java) |
|  easy | [Sum of Even Numbers After Queries](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/array/_985_Sum_of_Even_Numbers_After_Queries.java) |
|  easy | [Add to Array Form of Integer](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/array/_989_Add_to_Array_Form_of_Integer.java) |
|  easy | [Binary Prefix Divisible By 5](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/array/_1018_Binary_Prefix_Divisible_By_5.java) |
|  easy | [Destination City](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/array/_1436_Destination_City.java) |
|  easy | [Kids With the Greatest Number of Candies](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/array/_1431_Kids_With_the_Greatest_Number_of_Candies.java) |
|  easy | [Minimum Subsequence in Non-Increasing Order](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/array/_1403_Minimum_Subsequence_in_Non_Increasing_Order.java) |
|  easy | [Find Lucky Integer in an Array](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/array/_1394_Find_Lucky_Integer_in_an_Array.java) |
|  easy | [Create Target Array in the Given Order](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/array/_1389_Create_Target_Array_in_the_Given_Order.java) |
|  easy | [Lucky Numbers in a Matrix](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/array/_1380_Lucky_Numbers_in_a_Matrix.java) |
|  easy | [How Many Numbers Are Smaller Than the Current Number](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/array/_1365_How_Many_Numbers_Are_Smaller_Than_the_Current_Number.java) |
|  easy | [Contains Duplicate II](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/array/_219_Contains_Duplicate_II.java) |
|  easy | [Build an Array With Stack Operations](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/array/_1441_Build_an_Array_With_Stack_Operations.java) |
|  easy | [Count Negative Numbers in a Sorted Matrix](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/array/_1351_Count_Negative_Numbers_in_a_Sorted_Matrix.java) |
|  easy | [The K Weakest Rows in a Matrix](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/array/_1337_The_K_Weakest_Rows_in_a_Matrix.java) |
|  easy | [Decompress Run-Length Encoded List](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/array/_1313_Decompress_Run_Length_Encoded_List.java) |
|  easy | [Number of Students Doing Homework at a Given Time](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/array/_1450_Number_of_Students_Doing_Homework_at_a_Given_Time.java) |
|  medium | [Maximum Swap](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/medium/array/_670_Maximum_Swap.java) |
|  medium | [3Sum](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/medium/array/_015_3Sum.java) |
|  medium | [Group Anagrams](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/medium/array/_049_Group_Anagrams.java) |
|  medium | [Single Number II](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/medium/array/_137_Single_Number_II.java) |
|  medium | [Single Number III](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/medium/array/_260_Single_Number_III.java) |
|  medium | [Find All Duplicates in an Array](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/medium/array/_442_Find_All_Duplicates_in_an_Array.java) |
|  medium | [Find Minimum in Rotated Sorted Array](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/medium/array/_153_Find_Minimum_in_Rotated_Sorted_Array.java) |
|  medium | [Single Element in a Sorted Array](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/medium/array/_540_Single_Element_in_a_Sorted_Array.java) |
|  medium | [Set Matrix Zeroes](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/medium/array/_073_Set_Matrix_Zeroes.java) |
|  medium | [Next Greater Element II](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/medium/array/_503_Next_Greater_Element_II.java) |
|  medium | [Increasing Triplet Subsequence](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/medium/array/_334_Increasing_Triplet_Subsequence.java) |
|  medium | [Search a 2D Matrix](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/medium/array/_074_Search_a_2D_Matrix.java) |
|  medium | [Search a 2D Matrix II](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/medium/array/_240_Search_a_2D_Matrix_II.java) |
|  medium | [Find Peak Element](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/medium/array/_162_Find_Peak_Element.java) |
|  medium | [Merge Intervals](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/medium/array/_056_Merge_Intervals.java) |
|  medium | [Task Scheduler](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/medium/array/_621_Task_Scheduler.java) |
|  medium | [Reveal Cards In Increasing Order](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/medium/array/_950_Reveal_Cards_In_Increasing_Order.java) |
|  medium | [Check If All 1's Are at Least Length K Places Away](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/medium/array/_1437_Check_If_All_1s_Are_at_Least_Length_K_Places_Away.java) |
|  medium | [Contains Duplicate III](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/medium/array/_220_Contains_Duplicate_III.java) |
|  medium | [Minimum Size Subarray Sum](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/medium/array/_209_Minimum_Size_Subarray_Sum.java) |
|  hard | [Find Minimum in Rotated Sorted Array II](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/hard/array/_154_Find_Minimum_in_Rotated_Sorted_Array_II.java) |

#### String

|  难度  | 问题 |
|---|---|
|  easy | [Reverse String](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/string/_344_Reverse_String.java) |
|  easy | [First Unique Character In A String](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/string/_387_FirstUniqueCharacterInAString.java) |
|  easy | [Reverse Integer](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/string/_007_Reverse_Integer.java) |
|  easy | [Valid Anagram](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/string/_242_Valid_Anagram.java) |
|  easy | [Longest Common Prefix](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/string/_014_Longest_Common_Prefix.java) |
|  easy | [Valid Palindrome](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/string/_125_Valid_Palindrome.java) |
|  easy | [String To Integer atoi](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/string/_008_String_To_Integer_atoi.java) |
|  easy | [Implement strStr](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/string/_028_Implement_strStr.java) |
|  easy | [CountAndSay](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/string/_038_Count_And_Say.java) |
|  easy | [Valid Parentheses](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/string/_020_Valid_Parentheses.java) |
|  easy | [To Lower Case](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/string/_709_To_Lower_Case.java) |
|  easy | [Unique Morse Code Words](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/string/_804_Unique_Morse_Code_Words.java) |
|  easy | [Length of Last Word](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/string/_058_Length_of_Last_Word.java) |
|  easy | [Reverse Words in a String III](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/string/_557_Reverse_Words_in_a_String_III.java) |
|  easy | [Detect Capital](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/string/_520_Detect_Capital.java) |
|  easy | [Rotate String](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/string/_796_Rotate_String.java) |
|  easy | [Judge Route Circle](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/string/_657_Judge_Route_Circle.java) |
|  easy | [Shortest Distance to a Character](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/string/_821_Shortest_Distance_to_a_Character.java) |
|  easy | [Find the Difference](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/string/_389_Find_the_Difference.java) |
|  easy | [Goat Latin](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/string/_824_Goat_Latin.java) |
|  easy | [Ransom Note](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/string/_383_Ransom_Note.java) |
|  easy | [Most Common Word](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/string/_819_Most_Common_Word.java) |
|  easy | [Rotated Digits](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/string/_788_Rotated_Digits.java) |
|  easy | [Reverse Only Letters](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/string/_917_Reverse_Only_Letters.java) |
|  easy | [Long Pressed Name](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/string/_925_Long_Pressed_Name.java) |
|  easy | [Groups of Special Equivalent Strings](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/string/_893_Groups_of_Special_Equivalent_Strings.java) |
|  easy | [Count Binary Substrings](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/string/_696_Count_Binary_Substrings.java) |
|  easy | [Reverse Vowels of a String](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/string/_345_Reverse_Vowels_of_a_String.java) |
|  easy | [Camelcase Matching](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/string/_1023_Camelcase_Matching.java) |
|  easy | [Remove All Adjacent Duplicates In String](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/string/_1047_Remove_All_Adjacent_Duplicates_In_String.java) |
|  easy | [Maximum Score After Splitting a String](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/string/_1422_Maximum_Score_After_Splitting_a_String.java) |
|  easy | [Reformat The String](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/string/_1417_Reformat_The_String.java) |
|  easy | [String Matching in an Array](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/string/_1408_String_Matching_in_an_Array.java) |
|  easy | [Generate a String With Characters That Have Odd Counts](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/string/_1374_Generate_a_String_With_Characters_That_Have_Odd_Counts.java) |
|  easy | [Increasing Decreasing String](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/string/_1370_Increasing_Decreasing_String.java) |
|  easy | [Number of Days Between Two Dates](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/string/_1360_Number_of_Days_Between_Two_Dates.java) |
|  easy | [Defanging an IP Address](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/string/_1108_Defanging_an_IP_Address.java) |
|  easy | [Split a String in Balanced Strings](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/string/_1221_Split_a_String_in_Balanced_Strings.java) |
|  medium | [Longest Substring Without Repeating Characters](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/medium/string/_003_Longest_Substring_Without_Repeating_Characters.java) |
|  medium | [Longest Palindromic Substring](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/medium/string/_005_Longest_Palindromic_Substring.java) |
|  medium | [Partition Labels](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/medium/string/_763_Partition_Labels.java) |
|  medium | [Minimum Number of Frogs Croaking](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/medium/string/_1419_Minimum_Number_of_Frogs_Croaking.java) |
|  medium | [HTML Entity Parser](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/medium/string/_1410_HTML_Entity_Parser.java) |
|  medium | [Number of Substrings Containing All Three Characters](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/medium/string/_1358_Number_of_Substrings_Containing_All_Three_Characters.java) |
|  medium | [Longest Repeating Character Replacement](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/medium/string/_424_Longest_Repeating_Character_Replacement.java) |
|  medium | [Find All Anagrams in a String](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/medium/string/_438_Find_All_Anagrams_in_a_String.java) |
|  medium | [Find All Anagrams in a String](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/medium/string/_1347_Minimum_Number_of_Steps_to_Make_Two_Strings_Anagram.java) |

#### Sort

|  难度  | 问题 |
|---|---|
|  easy | [Merge Sorted Array](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/sort/_088_Merge_Sorted_Array.java) |
|  easy | [First Bad Version](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/sort/_002_FirstBadVersion.java) |
|  medium | [Find First and Last Position of Element in Sorted Array](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/medium/sort/_034_Find_First_and_Last_Position_of_Element_in_Sorted_Array.java) |
|  medium | [Sort Colors](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/medium/sort/_075_Sort_Colors.java) |
|  medium | [Kth Largest Element in an Array](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/medium/sort/_215_Kth_Largest_Element_in_an_Array.java) |
|  medium | [Search in Rotated Sorted Array](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/medium/sort/_033_Search_in_Rotated_Sorted_Array.java) |
|  medium | [Pancake Sorting](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/medium/sort/_969_Pancake_Sorting.java) |
|  medium | [Sort an Array](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/medium/sort/_912_Sort_an_Array.java) |

#### LinkedList

|  难度  | 问题 |
|---|---|
|  easy | [Delete Node In A Linked List](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/linkedList/_237_DeleteNodeInALinkedList.java) |
|  easy | [Linked List Cycle](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/linkedList/_141_Linked_List_Cycle.java) |
|  easy | [Reverse Linked List](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/linkedList/_206_ReverseLinked_List.java) |
|  easy | [Palindrome Linked List](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/linkedList/_234_Palindrome_Linked_List.java) |
|  easy | [Merge Two Sorted Lists](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/linkedList/_021_Merge_Two_Sorted_Lists.java) |
|  easy | [Remove Linked List Elements](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/linkedList/_203_Remove_Linked_List_Elements.java) |
|  easy | [Middle of the Linked List](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/linkedList/_876_Middle_of_the_Linked_List.java) |
|  easy | [Remove Duplicates from Sorted List](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/linkedList/_083_Remove_Duplicates_from_Sorted_List.java) |
|  easy | [Intersection of Two Linked Lists](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/linkedList/_160_Intersection_of_Two_Linked_Lists.java) |
|  easy | [Convert Binary Number in a Linked List to Integer](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/linkedList/_1290_Convert_Binary_Number_in_a_Linked_List_to_Integer.java) |
|  medium | [Remove Nth Node From End of List](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/medium/linkedList/_019_Remove_Nth_Node_From_End_of_List.java) |

#### Tree

|  难度  | 问题 |
|---|---|
|  easy | [Binary Tree Level Order Traversal](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/tree/_102_Binary_Tree_Level_Order_Traversal.java) |
|  easy | [Maximum_Depth_of_Binary_Tree](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/tree/_104_Maximum_Depth_of_Binary_Tree.java) |
|  easy | [Validate_Binary_Search_Tree](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/tree/_098_Validate_Binary_Search_Tree.java) |
|  easy | [Convert_Sorted_Array_to_Binary_Search_Tree](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/tree/_108_Convert_Sorted_Array_to_Binary_Search_Tree.java) |
|  easy | [Symmetric Tree](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/tree/_101_Symmetric_Tree.java) |
|  easy | [Invert Binary Tree](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/tree/_226_Invert_Binary_Tree.java) |
|  easy | [Average of Levels in Binary Tree](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/tree/_637_Average_of_Levels_in_Binary_Tree.java) |
|  easy | [Two Sum IV Input is a BST](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/tree/_653_Two_Sum_IV_Input_is_a_BST.java) |
|  easy | [Sum of Left Leaves](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/tree/_404_Sum_of_Left_Leaves.java) |
|  easy | [Binary Tree Level Order Traversal II](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/tree/_107_Binary_Tree_Level_Order_Traversal_II.java) |
|  easy | [Search in a Binary Search Tree](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/tree/_700_Search_in_a_Binary_Search_Tree.java) |
|  easy | [Convert BST to Greater Tree](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/tree/_538_Convert_BST_to_Greater_Tree.java) |
|  easy | [Same Tree](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/tree/_100_Same_Tree.java) |
|  easy | [Binary Tree Paths](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/tree/_257_Binary_Tree_Paths.java) |
|  easy | [Second Minimum Node In a Binary Tree](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/tree/_671_Second_Minimum_Node_In_a_Binary_Tree.java) |
|  easy | [Path Sum](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/tree/_112_Path_Sum.java) |
|  easy | [Merge Two Binary Trees](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/tree/_617_Merge_Two_Binary_Trees.java) |
|  easy | [Leaf Similar Trees](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/tree/_872_Leaf_Similar_Trees.java) |
|  easy | [Maximum Depth of N-ary Tree](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/tree/_559_Maximum_Depth_of_N_ary_Tree.java) |
|  easy | [N-ary Tree Postorder Traversal](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/tree/_590_N_ary_Tree_Postorder_Traversal.java) |
|  easy | [N-ary Tree Preorder Traversal](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/tree/_589_N_ary_Tree_Preorder_Traversal.java) |
|  easy | [N-ary Tree Level Order Traversal](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/tree/_429_N_ary_Tree_Level_Order_Traversal.java) |
|  easy | [Trim a Binary Search Tree](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/tree/_669_Trim_a_Binary_Search_Tree.java) |
|  easy | [Binary Tree Tilt](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/tree/_563_Binary_Tree_Tilt.java) |
|  easy | [Diameter of Binary Tree](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/tree/_543_Diameter_of_Binary_Tree.java) |
|  easy | [Subtree of Another Tree](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/tree/_572_Subtree_of_Another_Tree.java) |
|  easy | [Construct String from Binary Tree](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/tree/_606_Construct_String_from_Binary_Tree.java) |
|  easy | [Lowest Common Ancestor of a Binary Search Tree](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/tree/_235_Lowest_Common_Ancestor_of_a_Binary_Search_Tree.java) |
|  easy | [Balanced Binary Tree](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/tree/_110_Balanced_Binary_Tree.java) |
|  easy | [Minimum Depth of Binary Tree](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/tree/_111_Minimum_Depth_of_Binary_Tree.java) |
|  easy | [Increasing Order Search Tree](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/tree/_897_Increasing_Order_Search_Tree.java) |
|  easy | [Univalued Binary Tree](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/tree/_965_Univalued_Binary_Tree.java) |
|  easy | [Sum of Root To Leaf Binary Numbers](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/tree/_1022_Sum_of_Root_To_Leaf_Binary_Numbers.java) |
|  medium | [Range Sum Query - Mutable](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/medium/tree/_307_Range_Sum_Query_Mutable.java) |
|  medium | [Binary Tree Inorder Traversal](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/medium/tree/_094_Binary_Tree_Inorder_Traversal.java) |
|  medium | [Binary Tree Zigzag Level Order Traversal](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/medium/tree/_103_Binary_Tree_Zigzag_Level_Order_Traversal.java) |
|  medium | [Kth Smallest Element in a BST](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/medium/tree/_230_Kth_Smallest_Element_in_a_BST.java) |
|  medium | [Construct Binary Tree from Preorder and Inorder Traversal](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/medium/tree/_105_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal.java) |
|  medium | [Implement Trie Prefix Tree](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/medium/design/_208_Implement_Trie_Prefix_Tree.java) |
|  medium | [Add and Search Word - Data structure design](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/medium/design/_211_Add_and_Search_Word_Data_structure_design.java) |
|  medium | [Map Sum Pairs](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/medium/design/_677_Map_Sum_Pairs.java) |
|  medium | [Maximum Binary Tree](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/medium/tree/_654_Maximum_Binary_Tree.java) |
|  medium | [Binary Tree Pruning](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/medium/tree/_814_Binary_Tree_Pruning.java) |
|  medium | [Find Bottom Left Tree Value](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/medium/tree/_513_Find_Bottom_Left_Tree_Value.java) |
|  medium | [Find Largest Value in Each Tree Row](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/medium/tree/_515_Find_Largest_Value_in_Each_Tree_Row.java) |
|  medium | [Insert into a Binary Search Tree](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/medium/tree/_701_Insert_into_a_Binary_Search_Tree.java) |
|  medium | [Binary Tree Preorder Traversal](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/medium/tree/_144_Binary_Tree_Preorder_Traversal.java) |
|  medium | [Range Sum of BST](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/medium/tree/_938_Range_Sum_of_BST.java) |
|  medium | [Flip Equivalent Binary Trees](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/medium/tree/_951_Flip_Equivalent_Binary_Trees.java) |
|  medium | [Balance a Binary Search Tree](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/medium/tree/_1382_Balance_a_Binary_Search_Tree.java) |
|  medium | [Find a Corresponding Node of a Binary Tree in a Clone of That Tree](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/medium/tree/_1379_Find_a_Corresponding_Node_of_a_Binary_Tree_in_a_Clone_of_That_Tree.java) |
|  medium | [Longest ZigZag Path in a Binary Tree](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/medium/tree/_1372_Longest_ZigZag_Path_in_a_Binary_Tree.java) |

#### Math

|  难度  | 问题 |
|---|---|
|  easy | [Count_Primes](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/math/_001_Count_Primes.java) |
|  easy | [Power_of_Three](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/math/_362_Power_of_Three.java) |
|  easy | [Fizz Buzz](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/math/_412_Fizz_Buzz.java) |
|  easy | [Roman to Integer](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/math/_013_Roman_to_Integer.java) |
|  easy | [Power of Two](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/math/_231_Power_of_Two.java) |
|  easy | [Self Dividing Numbers](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/math/_728_Self_Dividing_Numbers.java) |
|  easy | [Add Digits](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/math/_258_Add_Digits.java) |
|  easy | [Add Strings](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/math/_415_Add_Strings.java) |
|  easy | [Power of Four](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/math/_342_Power_of_Four.java) |
|  easy | [Factorial Trailing Zeroes](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/math/_172_Factorial_Trailing_Zeroes.java) |
|  easy | [Ugly Number](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/math/_263_Ugly_Number.java) |
|  easy | [Palindrome Number](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/math/_009_Palindrome_Number.java) |
|  easy | [Happy Number](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/math/_202_Happy_Number.java) |
|  easy | [Excel Sheet Column Number](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/math/_171_Excel_Sheet_Column_Number.java) |
|  easy | [DI String Match](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/math/_942_DI_String_Match.java) |
|  easy | [Largest Time for Given Digits](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/math/_949_Largest_Time_for_Given_Digits.java) |
|  easy | [Divisor Game](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/math/_1025_Divisor_Game.java) |
|  easy | [Closest Divisors](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/math/_1362_Closest_Divisors.java) |
|  easy | [Subtract the Product and Sum of Digits of an Integer](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/math/_1281_Subtract_the_Product_and_Sum_of_Digits_of_an_Integer.java) |
|  easy | [Find Numbers with Even Number of Digits](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/math/_1295_Find_Numbers_with_Even_Number_of_Digits.java) |
|  medium | [Pow x n](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/medium/math/_050_Pow_x_n.java) |
|  medium | [Ugly Number II](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/medium/math/_264_Ugly_Number_II.java) |

#### HashTable

|  难度  | 问题 |
|---|---|
|  easy | [Jewels and Stones](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/hashTable/_771_Jewels_and_Stones.java) |
|  easy | [Uncommon Words from Two Sentences](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/hashTable/_884_Uncommon_Words_from_Two_Sentences.java) |
|  easy | [Set Mismatch](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/hashTable/_645_Set_Mismatch.java) |
|  easy | [Subdomain Visit Count](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/hashTable/_811_Subdomain_Visit_Count.java) |
|  easy | [Keyboard Row](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/hashTable/_500_Keyboard_Row.java) |
|  easy | [Number of Lines To Write String](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/hashTable/_806_Number_of_Lines_To_Write_String.java) |
|  easy | [Island Perimeter](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/hashTable/_463_Island_Perimeter.java) |
|  easy | [Distribute Candies](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/hashTable/_575_Distribute_Candies.java) |
|  easy | [Shortest Completing Word](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/hashTable/_748_Shortest_Completing_Word.java) |
|  easy | [Employee Importance](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/hashTable/_690_Employee_Importance.java) |
|  easy | [Verifying an Alien Dictionary](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/hashTable/_953_Verifying_an_Alien_Dictionary.java) |
|  easy | [Longest Palindrome](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/hashTable/_409_Longest_Palindrome.java) |
|  easy | [Minimum Index Sum of Two Lists](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/hashTable/_599_Minimum_Index_Sum_of_Two_Lists.java) |
|  easy | [Longest Word in Dictionary](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/hashTable/_720_Longest_Word_in_Dictionary.java) |
|  easy | [Longest Harmonious Subsequence](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/hashTable/_594_Longest_Harmonious_Subsequence.java) |
|  easy | [Isomorphic Strings](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/hashTable/_594_Longest_Harmonious_Subsequence.java) |
|  easy | [Find Common Characters](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/hashTable/_1002_Find_Common_Characters.java) |
|  medium | [Daily Temperatures](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/medium/hashTable/_739_Daily_Temperatures.java) |
|  medium | [Battleships in a Board](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/medium/hashTable/_419_Battleships_in_a_Board.java) |
|  medium | [Find Duplicate File in System](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/medium/hashTable/_609_Find_Duplicate_File_in_System.java) |
|  medium | [Display Table of Food Orders in a Restaurant](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/medium/hashTable/_1418_Display_Table_of_Food_Orders_in_a_Restaurant.java) |
|  hard | [Maximum Frequency Stack](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/hard/hashTable/_895_Maximum_Frequency_Stack.java) |


#### Heap

|  难度  | 问题 |
|---|---|
|  easy | [Kth Largest Element in a Stream](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/heap/_703_Kth_Largest_Element_in_a_Stream.java) |
|  medium | [Top K Frequent Elements](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/medium/heap/_347_Top_K_Frequent_Elements.java) |
|  medium | [Kth Smallest Element in a Sorted Matrix](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/medium/heap/_378_Kth_Smallest_Element_in_a_Sorted_Matrix.java) |
|  medium | [Sort Characters By Frequency](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/medium/heap/_451_Sort_Characters_By_Frequency.java) |
|  medium | [Top K Frequent Words](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/medium/heap/_692_Top_K_Frequent_Words.java) |


#### Greedy

|  难度  | 问题 |
|---|---|
|  easy | [Lemonade Change](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/greedy/_860_Lemonade_Change.java) |
|  easy | [Assign Cookies](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/greedy/_455_Assign_Cookies.java) |
|  easy | [String Without AAA or BBB](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/greedy/_984_String_Without_AAA_or_BBB.java) |
|  easy | [Two City Scheduling](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/greedy/_1029_Two_City_Scheduling.java) |


#### Others

|  难度  | 问题 |
|---|---|
|  easy | [Missing Number](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/others/_268_Missing_Number.java) |
|  easy | [Number of 1 Bits](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/others/_191_Number_of_1_Bits.java) |
|  easy | [Hamming Distance](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/others/_461_Hamming_Distance.java) |
|  easy | [Reverse Bits](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/others/_190_Reverse_Bits.java) |
|  easy | [Pascal's Triangle](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/others/_118_Pascal_Triangle.java) |
|  easy | [Find the Duplicate Number](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/others/_287_Find_the_Duplicate_Number.java) |
|  easy | [Binary Number with Alternating Bits](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/others/_693_Binary_Number_with_Alternating_Bits.java) |
|  easy | [Binary Gap](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/others/_868_Binary_Gap.java) |
|  easy | [Backspace String Compare](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/others/_844_Backspace_String_Compare.java) |
|  easy | [Baseball Game](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/others/_682_Baseball_Game.java) |
|  easy | [Nim Game](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/others/_292_Nim_Game.java) |
|  easy | [Number Complement](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/others/_476_Number_Complement.java) |
|  easy | [Number of Recent Calls](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/others/_933_Number_of_Recent_Calls.java) |
|  easy | [Complement of Base 10 Integer](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/others/_1012_Complement_of_Base_10_Integer.java) |
|  easy | [Remove Outermost Parentheses](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/others/_1021_Remove_Outermost_Parentheses.java) |
|  easy | [Prime Number of Set Bits in Binary Representation](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/others/_762_Prime_Number_of_Set_Bits_in_Binary_Representation.java) |
|  easy | [Sort Integers by The Number of 1 Bits](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/others/_1356_Sort_Integers_by_The_Number_of_1_Bits.java) |
|  easy | [Number of Steps to Reduce a Number to Zero](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/others/_1342_Number_of_Steps_to_Reduce_a_Number_to_Zero.java) |
|  medium | [Evaluate Reverse Polish Notation](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/medium/others/_150_Evaluate_Reverse_Polish_Notation.java) |
|  medium | [Score of Parentheses](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/medium/others/_856_Score_of_Parentheses.java) |
|  medium | [Longest Word in Dictionary through Deleting](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/medium/others/_524_Longest_Word_in_Dictionary_through_Deleting.java) |
|  medium | [Boats to Save People](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/medium/others/_881_Boats_to_Save_People.java) |
|  medium | [Validate Stack Sequences](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/medium/others/_946_Validate_Stack_Sequences.java) |

#### Design

|  难度  | 问题 |
|---|---|
|  easy | [Min Stack](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/design/_155_Min_Stack.java) |
|  easy | [Shuffle an Array](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/design/_384_Shuffle_an_Array.java) |
|  easy | [Guess Number Higher or Lower](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/design/_374_Guess_Number_Higher_or_Lower.java) |
|  easy | [Implement Queue using Stacks](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/design/_232_Implement_Queue_using_Stacks.java) |
|  easy | [Implement Stack using Queues](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/design/_225_Implement_Stack_using_Queues.java) |
|  medium | [Encode and Decode TinyURL](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/medium/design/_535_Encode_and_Decode_TinyURL.java) |
|  medium | [Design a Stack With Increment Operation](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/medium/design/_1381_Design_a_Stack_With_Increment_Operation.java) |
|  medium | [Product of the Last K Numbers](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/medium/design/_1352_Product_of_the_Last_K_Numbers.java) |

#### DP

|  难度  | 问题 |
|---|---|
|  easy | [Climbing Stairs](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/dp/_70_Climbing_Stairs.java) |
|  easy | [Best Time to Buy and Sell Stock](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/dp/_121_Best_Time_to_Buy_and_Sell_Stock.java) |
|  easy | [Maximum Subarray](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/dp/_053_Maximum_Subarray.java) |
|  easy | [House Robber](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/easy/dp/_198_House_Robber.java) |

#### Backtracking

|  难度  | 问题 |
|---|---|
|  medium | [Letter Combinations of a Phone Number](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/medium/backtracking/_017_Letter_Combinations_of_a_Phone_Number.java) |
|  medium | [Permutations](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/medium/backtracking/_046_Permutations.java) |
|  medium | [Combinations](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/medium/backtracking/_077_Combinations.java) |
|  medium | [Subsets](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/medium/backtracking/_078_Subsets.java) |
|  medium | [Word Search](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/medium/backtracking/_079_Word_Search.java) |
|  medium | [Combination Sum III](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/medium/backtracking/_216_Combination_Sum_III.java) |
|  medium | [Letter Case Permutation](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/medium/backtracking/_784_Letter_Case_Permutation.java) |
|  medium | [Letter Tile Possibilities](https://github.com/junyu0577/DataStructureAndAlgorithm/blob/master/Solution/src/com/github/junyu/solution/leetCode/medium/backtracking/_1079_Letter_Tile_Possibilities.java) |

