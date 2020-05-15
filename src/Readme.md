## 滑动窗口
注意三点：  
1. 扩大和缩小窗口时对窗口内容的更新
2. 在缩小窗口时如何更新结果
3. 缩小窗口的条件

## 快慢指针
### 1. 判定链表中是否有环
### 2. 已知链表中含有环，返回这个环的起始位置
当快慢指针相遇时，让其中任一个指针指向头节点，然后让它俩以相同速度前进，再次相遇时所在的节点位置就是环开始的位置
```
   ListNode detectCycle(ListNode head) {
      ListNode fast, slow;
      fast = slow = head;
      while (fast != null && fast.next != null) {
          fast = fast.next.next;
          slow = slow.next;
          if (fast == slow) break;
      }
      // 上面的代码类似 hasCycle 函数
      slow = head;
      while (slow != fast) {
          fast = fast.next;
          slow = slow.next;
      }
      return slow;
  }
```
### 3. 寻找链表中点
当快指针到达链表尽头时，慢指针就处于链表的中间位置。
### 4. 寻找链表的倒数第 k 个元素
快指针先走k步

## 快慢指针
用于有序数组，如二分查找，两数和
