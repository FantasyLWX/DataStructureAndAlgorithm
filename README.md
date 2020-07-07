# DataStructureAndAlgorithm

数据结构与算法 Java 版

## 为什么要学习数据结构与算法？

我们学习数据结构和算法，并不是为了死记硬背几个知识点。我们的目的是建立时间复杂度、空间复杂度意识，写出高质量的代码，能够设计基础架构，提升编程技能，训练逻辑思维，积攒人生经验，以此获得工作回报，实现你的价值，完善你的人生。

所以，不管你是业务开发工程师，还是基础架构工程师；不管你是初入职场的初级工程师，还是工作多年的资深架构师，又或者是想转人工智能、区块链这些热门领域的程序员，数据结构与算法作为计算机的基础知识、核心知识，都是必须要掌握的。

**掌握了数据结构与算法，你看待问题的深度，解决问题的角度就会完全不一样。** 因为这样的你，就像是站在巨人的肩膀上，拿着生存利器行走世界。数据结构与算法，会为你的编程之路，甚至人生之路打开一扇通往新世界的大门。

## 什么是数据结构？什么是算法？

从广义上讲，数据结构就是指一组数据的存储结构。算法就是操作数据的一组方法。

图书馆储藏书籍你肯定见过吧？为了方便查找，图书管理员一般会将书籍分门别类进行“存储”。按照一定规律编号，就是书籍这种“数据”的存储结构。

那我们如何来查找一本书呢？有很多种办法，你当然可以一本一本地找，也可以先根据书籍类别的编号，是人文，还是科学、计算机，来定位书架，然后再依次查找。笼统地说，这些查找方法都是算法。

从狭义上讲，也就是我们专栏要讲的，是指某些著名的数据结构和算法，比如队列、栈、堆、二分查找、动态规划等。这些都是前人智慧的结晶，我们可以直接拿来用。我们要讲的这些经典数据结构和算法，都是前人从很多实际操作场景中抽象出来的，经过非常多的求证和检验，可以高效地帮助我们解决很多实际的开发问题。

那数据结构和算法有什么关系呢？为什么大部分书都把这两个东西放到一块儿来讲呢？这是因为，数据结构和算法是相辅相成的。数据结构是为算法服务的，算法要作用在特定的数据结构之上。因此，我们无法孤立数据结构来讲算法，也无法孤立算法来讲数据结构。比如，因为数组具有随机访问的特点，常用的二分查找算法需要用数组来存储数据。但如果我们选择链表这种数据结构，二分查找算法就无法工作了，因为链表并不支持随机访问。数据结构是静态的，它只是组织数据的一种方式。如果不在它的基础上操作、构建算法，孤立存在的数据结构就是没用的。

## 数据结构

### 数组

- [实现一个支持动态扩容的数组][dynamic-array]
- [实现一个大小固定的有序数组，支持增删查改操作][ordered-array]

[dynamic-array]: ./src/com/fantasy/datastructure/array/DynamicArray.java
[ordered-array]: ./src/com/fantasy/datastructure/array/OrderedArray.java

### 链表

- [实现一个单链表，支持增删操作][single-linked-list]
- [实现一个循环链表，支持增删操作][circular-linked-list]
- [实现一个双向链表，支持增删操作][doubly-linked-list]

[single-linked-list]: ./src/com/fantasy/datastructure/linkedlist/SingleLinkedList.java
[circular-linked-list]: ./src/com/fantasy/datastructure/linkedlist/CircularLinkedList.java
[doubly-linked-list]: ./src/com/fantasy/datastructure/linkedlist/DoublyLinkedList.java

## 算法

### 数组

- [将两个有序数组合并为一个有序数组][merge-two-ordered-array]

[merge-two-ordered-array]: ./src/com/fantasy/algorithm/array/MergeTwoOrderedArray.java

### 链表

- [反转单链表][reverse-linked-list]
- [将两个有序链表合并为一个有序链表][merge-two-ordered-linked-list]

[reverse-linked-list]: ./src/com/fantasy/algorithm/linkedlist/ReverseLinkedList.java
[merge-two-ordered-linked-list]: ./src/com/fantasy/algorithm/linkedlist/MergeTwoOrderedLinkedList.java
