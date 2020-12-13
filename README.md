#### 1、目录结构
```
|-- src
    |-- com.freedom
        |-- graph
            |-- Graph        图
            |-- GraphTest
        |-- hashtab
            |-- HashTab        哈希表
            |-- HashTabTest
        |-- linkedlist
            |-- CircleSingleLinkedList        单向环形链表
            |-- DoubleLinkedList        双向链表
            |-- DoubleLinkedListTest
            |-- Josepfu        约瑟夫
            |-- SingleLinkedList        单链表
            |-- SingleLinkedListTest
        |-- queue
            |-- CircleArrayQueue        数组模拟环形队列
            |-- CircleArrayQueueTest
        |-- recursion
            |-- Maze        迷宫问题
            |-- Queen8        八皇后问题
        |-- search
            |-- BinarySearch        二分查找
            |-- FibonacciSearch        斐波那契（黄金分割法）查找
            |-- InsertValueSearch        插值查找
            |-- SearchTest
        |-- sort
            |-- BubbleSort        冒泡排序
            |-- BucketSort        桶排序
            |-- CountSort        计数排序
            |-- HeapSort        堆排序
            |-- InsertSort        插入排序
            |-- MergeSort        归并排序
            |-- QuickSort        快速排序
            |-- RadixSort        基数排序
            |-- SelectSort        选择排序
            |-- ShellSort        希尔排序
            |-- SortTest
        |-- sparseaary 
            |-- sparseArray        稀疏数组
        |-- stack
            |-- ArrayStack        数组模拟栈
            |-- ArrayStackTest        
            |-- Calculator        综合计算器（中缀表达式）
            |-- InfixToSuffixExpression        中缀表达式转换为后缀表达式
            |-- InversePolandNotation        逆波兰计算器
            |-- ReversePolishMultiCalc        逆波兰表达式完整版
        |-- tree
            |-- binarysorttree
                |-- AVLNode
                |-- AVLTree        平衡二叉树
                |-- AVLTreeTest
                |-- BinarySortTree        二叉排序树
                |-- BinarySortTreeTest
                |-- Node
            |-- binarytree
                |-- ArrBinaryTree        顺序数组二叉树
                |-- ArrBinaryTreeTest
                |-- BinaryTree        二叉树
                |-- BinaryTreeTest
                |-- HeroNode
                |-- ThreadedBinaryTree        线索化二叉树
                |-- ThreadedBinaryTreeTest
            |-- huffman
                |-- HuffmanCoding        赫夫曼编码
                |-- HuffmanCodingNode
                |-- HuffmanCodingTest
                |-- HuffmanNode
                |-- HuffmanTree        赫夫曼树
                |-- HuffmanTreeTest
```

#### 2、前缀、中缀、后缀表达式（逆波兰表达式）
##### 2.1 前缀表达式（波兰表达式）
**2.1.1 定义**

前缀表达式的运算符位于操作符之前。例如：（3+4）*5-6对应的前缀表达式就是“- * + 3 4 5 6”。

**2.1.2 求值**

**从右至左**扫描表达式，遇到数字时，将数字压入堆栈，遇到运算符时，弹出栈顶的两个数，用运算符对它们做相应的计算（栈顶元素和次顶元素），并讲结果入栈；重复上述过程直到表达式最左端，最后运算得出的值即为表达式的结果。例如：（3+4）*5-6对应的前缀表达式就是“- * + 3 4 5 6”，针对前缀表达式求值步骤如下：
>* 从右至左扫描，将6、5、4、3压入堆栈；
>* 遇到+运算符，因此填出3和4（3为栈顶元素，4为次顶元素），计算出3+4=7，将7入栈；
>* 接下来是*运算符，因此弹出7和5，计算出7*5=35，将35入栈；
>* 最后是-运算符，计算出35-6=29，因此最终结果是29。

##### 2.2 中缀表达式
中缀表达式就是常见得运算表达式，如（3+4）*5-6。中缀表达式得求值是我们人最熟悉得，但是对计算机来说却不好操作，因此，再计算结果时，往往将中缀表达式转成其它表达式来操作（一般转成后缀表达式）。

##### 2.3 后缀表达式（逆波兰表达式）
**2.3.1 定义**

后缀表达式的运算符位于操作数之后。例如：（3+4）*5-6对应的后缀表达式就是“3 4 + 5 * 6 -”。

**2.3.2 求值**

**从左至右**扫描表达式，遇到数字时，将数字压入堆栈，遇到运算符时，弹出栈顶的两个数，用运算符对它们做相应的计算（栈顶元素和词顶元素），并将结果入栈；重复上述过程直到表达式最右端，最后运算得出的值即为表达式的结果。例如：（3+4）*5-6对应的前缀表达式就是“3 4 + 5 * 6 -”，针对后缀表达式求值步骤如下：
>* 从左至右扫描，将3和4压入堆栈；
>* 遇到+运算符，因此弹出4和3（4为栈顶元素，3为次顶元素），计算出3+4=7，将7入栈；
>* 将5入栈；
>* 接下来是*运算符，因此弹出7和5，计算出7*5=35，将35入栈；
>* 将6入栈；
>* 最后是-运算符，计算出35-6=29，因此最终结果是29。

#### 3、十种排序算法
![](https://gitee.com/freedom9/markdown_images/raw/master/%E6%95%B0%E6%8D%AE%E7%BB%93%E6%9E%84%E5%92%8C%E7%AE%97%E6%B3%95/%E5%B8%B8%E7%94%A8%E7%AE%97%E6%B3%95%E7%9A%84%E6%AF%94%E8%BE%83.jpg)
##### 3.1 冒泡排序（Bubble Sort）
基本思想：通过对待排序序列从前到后（从下标较小的元素开始），依次比较相邻元素的值，若发现逆序则交换，使值较大的元素逐渐从前移向后部，就像水底下的气泡一样逐渐向上冒。

![](https://gitee.com/freedom9/markdown_images/raw/master/%E6%95%B0%E6%8D%AE%E7%BB%93%E6%9E%84%E5%92%8C%E7%AE%97%E6%B3%95/%E5%86%92%E6%B3%A1%E6%8E%92%E5%BA%8F.gif)

##### 3.2 选择排序（Selection Sort）
基本思想：第一次从待排序的数据元素中选出最小（或最大）的一个元素，存放在序列的起始位置，然后再从剩余的未排序元素寻找到最小（大）元素，然后放到已排序的序列的末尾。依此类推，直到全部待排序的数据元素的个数为零。选择排序是不稳定的排序方法。

![](https://gitee.com/freedom9/markdown_images/raw/master/%E6%95%B0%E6%8D%AE%E7%BB%93%E6%9E%84%E5%92%8C%E7%AE%97%E6%B3%95/(%E7%AE%80%E5%8D%95)%E9%80%89%E6%8B%A9%E6%8E%92%E5%BA%8F.gif)

##### 3.3 插入排序（Insertion Sort）
基本思想：把n个待排序的元素看成为一个有序表和一个无序表，开始时有序表中只包含一个元素，无序表中包含有n-1个元素，排序过程中每次从无序表中取出第一个元素，把它的排序码依次与有序表元素的排序码进行比较，将它插入到有序表中的适当位置，使之成为新的有序表。

![](https://gitee.com/freedom9/markdown_images/raw/master/%E6%95%B0%E6%8D%AE%E7%BB%93%E6%9E%84%E5%92%8C%E7%AE%97%E6%B3%95/(%E7%9B%B4%E6%8E%A5)%E6%8F%92%E5%85%A5%E6%8E%92%E5%BA%8F.gif)

##### 3.4 希尔排序（Shell Sort）
基本思想：把记录按下标的一定增量分组，对每组使用插入排序算法排序，随着增量逐渐减少，每组包含的关键词越来越多，当增量减至1时，整个文件适被分成一组，算法便终止。希尔排序又称“缩小增量排序”，是直接插入排序算法的一种更高效的改进版本。

![](https://gitee.com/freedom9/markdown_images/raw/master/%E6%95%B0%E6%8D%AE%E7%BB%93%E6%9E%84%E5%92%8C%E7%AE%97%E6%B3%95/%E5%B8%8C%E5%B0%94%E6%8E%92%E5%BA%8F.gif)

##### 3.5 快速排序
基本思想：通过一趟排序将要排序的数据分割成独立的两个部分，其中一部分的所有数据都比另外一部分的所有数据都要小，然后再按此方法对这两部分数据分别进行快速排序，整个排序过程可以递归进行，以此达到整个数据变成有序序列。

![](https://gitee.com/freedom9/markdown_images/raw/master/%E6%95%B0%E6%8D%AE%E7%BB%93%E6%9E%84%E5%92%8C%E7%AE%97%E6%B3%95/%E5%BF%AB%E9%80%9F%E6%8E%92%E5%BA%8F.gif)

##### 3.6 归并排序（Merge Sort）
基本思想：采用经典的分治（divide-and-conquer）策略（分治法将问题分（divide）成一些小的问题然后递归求解，而治（conquer）的阶段则将分的阶段得到的各答案“修补”在一起，即分而治之）。

![](https://gitee.com/freedom9/markdown_images/raw/master/%E6%95%B0%E6%8D%AE%E7%BB%93%E6%9E%84%E5%92%8C%E7%AE%97%E6%B3%95/%E5%BD%92%E5%B9%B6%E6%8E%92%E5%BA%8F.gif)

##### 3.7 基数排序（Radix Sort）
基本思想：将所有待比较数值统一为同样的数位长度，数位较短的的数前面补零。然后，从低位开始，依次进行一次排序。这样从最低位排序一直到最高位排序完成以后，数列就变成一个有序序列。

![](https://gitee.com/freedom9/markdown_images/raw/master/%E6%95%B0%E6%8D%AE%E7%BB%93%E6%9E%84%E5%92%8C%E7%AE%97%E6%B3%95/%E5%9F%BA%E6%95%B0%E6%8E%92%E5%BA%8F.gif)

##### 3.8 计数排序（Count Sort）
基本思想：把数组元素作为数组得下标，然后用一个临时数组记录该元素出现的次数，例如：temp[i] = m表示元素i一共出现了m次。最后把临时数组的数据从小到大汇总起来，汇总完的数据变为有序的。

![](https://gitee.com/freedom9/markdown_images/raw/master/%E6%95%B0%E6%8D%AE%E7%BB%93%E6%9E%84%E5%92%8C%E7%AE%97%E6%B3%95/%E8%AE%A1%E6%95%B0%E6%8E%92%E5%BA%8F.gif)

##### 3.9 桶排序（Bucket Sort）
基本思想：把数组中的数划分到不同的区间，再对每个桶中的数进行排序，然后再把所有桶中的数返回给原数组。

![](https://gitee.com/freedom9/markdown_images/raw/master/%E6%95%B0%E6%8D%AE%E7%BB%93%E6%9E%84%E5%92%8C%E7%AE%97%E6%B3%95/%E6%A1%B6%E6%8E%92%E5%BA%8F.png)

##### 3.10 堆排序（Heap Sort）
基本思想：将待排序序列构造成一个大顶堆，此时整个序列的最大值就是堆顶的根节点；将其与末尾元素进行交换，此时末尾就是最大值；然后将剩下n - 1个元素重新构造成一个堆，这样会得到n个元素的次小值。如此反复执行，便能得到一个有序序列。

![](https://gitee.com/freedom9/markdown_images/raw/master/%E6%95%B0%E6%8D%AE%E7%BB%93%E6%9E%84%E5%92%8C%E7%AE%97%E6%B3%95/%E5%A0%86%E6%8E%92%E5%BA%8F.gif)


