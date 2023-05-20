参考：https://blog.csdn.net/weixin_68829137/article/details/128458049

目录：
    1，阻塞队列
    2，非阻塞队列
    3，双端队列（很少使用）

# 前言
Java提供的线程安全的队列 主要分为阻塞队列和非阻塞队列俩大类
1，abstractQueue--非阻塞队列
    非阻塞并发队列最典型的就是ConcurrentLinkedQueue，这个类不会让线程阻塞，利用CAS保证了线程安全。
2，blokingQueue--阻塞队列
    阻塞队列的典型例子就是BlockingQueue接口的实现类
3，deque--双端队列

阻塞队列的特点：
    1，平衡生产，消费两端。
    2，最重要的两个方法：take()和put()
        take：从队列中获取数据，如果队列中没有数据会阻塞，有数据的时候自动解除阻塞。
        put：往队列中添加数据，如果数据满了会阻塞，知道队列有空间之后，自动解除阻塞。
    3，阻塞队列（误无界队列）的最大空间是：Integer.MAX_VALUE。
阻塞队列的常用方法：
    抛出异常：add、remove、element
    返回结果但是不抛出异常：offer、poll、peek、
    阻塞：take、put
常见阻塞队列：
    1，有界阻塞队列：ArrayBlockingQueue
        构造函数1：public ArrayBlockingQueue(int capacity)
        构造函数2：public ArrayBlockingQueue(int capacity, boolean fair)
        1，创建它的时候就需要指定它的容量，之后也不可以在扩容了，
        在构造函数中我们同样可以指定是否是公平的。
        2，如果ArrayBlockingQueue被设置为非公平的，那么就存在插队的可能；
        如果设置为公平的，那么等待了最长时间的线程会优先被处理，其它线程不允许插队。
    2，无界阻塞队列：LinkedBlockingQueue
        如果我们不指定它的初始容量，那么它的默认容量就为整形的最大值Integer.MAX_VALUE。
    3，SynchronousQueue
        1，它没有地方来暂存元素，导致每次取数据都要先阻塞，直到有数据放入；
        同理，每次放数据的时候也会阻塞，直到有消费者来取。
        2，SynchronousQueue的容量不是1而是0
    4，PriorityBlockingQueue
        1，PriorityBlockingQueue是一个支持优先级的无界阻塞队列，
        可以通过自定义类实现compareTo()方法来制定元素排序规则，
        或者初始化时通过构造器参数Comparator来制定排序规则。
        2，它的take方法在队列为空时会阻塞，但是正因为它是无界队列，而且会自动扩容，
        所以它的队列永远不会满，所以它的put()方法永远不会阻塞，添加操作始终都会成功。
    5，DelayQueue
        1，DelayQueue具有延迟的功能，我们可以设定在队列中的任务延迟多久之后执行。它是无界队列，
        但是放入的元素必须实现Delayed接口，
        而Delayed接口又继承了Comparable接口，所以自然就拥有了比较和排序的能力.
        2，getDelay方法返回的是还剩下多长的延迟时间才会被执行。如果返回0或者负数则代表任务已过期。
        元素会根据延迟时间的长短被放到队列的不同位置，越靠近队列头代表越早过期。


非阻塞队列的特点：
    1，java中提供了基于CAS非阻塞算法实现的队列，
    比较有代表性的有ConcurrentLinkedQueue和LinkedTransferQueue，它们的性能一般比阻塞队列的好。
队列的方法：
    add             增加一个元索             如果队列已满，则抛出一个IIIegaISlabEepeplian异常
    remove          移除并返回队列头部的元素  如果队列为空，则抛出一个NoSuchElementException异常
  　element         返回队列头部的元素        如果队列为空，则抛出一个NoSuchElementException异常
  　offer           添加一个元素并返回true    如果队列已满，则返回false
    poll            移除并返问队列头部的元素   如果队列为空，则返回null
    peek            返回队列头部的元素        如果队列为空，则返回null
    put             添加一个元素             如果队列满，则阻塞
    take            移除并返回队列头部的元素   如果队列为空，则阻塞
    drainTo(list)   一次性取出队列所有元素
有代表性的非阻塞队列：
    1，ConcurrentLinkedQueue
        非阻塞队列ConcurrentLickedQueue使用CAS非阻塞算法+不停重试的实际来实现线程安全的.
    2，LinkedTransferQueue
        LinkedTransferQueue 通过使用CAS来实现并发控制，是一个无界的安全队列。其长度可以无限延伸，当然带来的问题也是显而易见的。