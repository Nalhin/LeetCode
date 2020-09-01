# Design and implement a data structure for Least Recently Used (LRU) cache. It
# should support the following operations: get and put.
#
#  get(key) - Get the value (will always be positive) of the key if the key exits
#  in the cache, otherwise return -1.
# put(key, value) - Set or insert the value if the key is not already present. W
# hen the cache reached its capacity, it should invalidate the least recently used
#  item before inserting a new item.
#
#  The cache is initialized with a positive capacity.
#
#  Follow up:
# Could you do both operations in O(1) time complexity?
#
#  Example:
#
#
# LRUCache cache = new LRUCache( 2 /* capacity */ );
#
# cache.put(1, 1);
# cache.put(2, 2);
# cache.get(1);       // returns 1
# cache.put(3, 3);    // evicts key 2
# cache.get(2);       // returns -1 (not found)
# cache.put(4, 4);    // evicts key 1
# cache.get(1);       // returns -1 (not found)
# cache.get(3);       // returns 3
# cache.get(4);       // returns 4
#
#
#
#  Related Topics Design
#  👍 6417 👎 270


# leetcode submit region begin(Prohibit modification and deletion)
class Node:
    def __init__(self, val, key, prev=None, next=None):
        self.val = val
        self.prev = prev
        self.next = next
        self.key = key


class LRUCache:
    def __init__(self, capacity: int):
        self.capacity = capacity
        self.cache = {}
        self.head = Node(-1, -1)
        self.tail = Node(-1, -1, prev=self.head)
        self.head.next = self.tail

    def get(self, key: int) -> int:
        if key not in self.cache:
            return -1
        node = self.cache[key]
        self._move_to_tail(node)
        return node.val

    def put(self, key: int, value: int) -> None:
        if key in self.cache:
            self.cache[key].val = value
            self._move_to_tail(self.cache[key])
        else:
            if len(self.cache) >= self.capacity:
                self._remove_node(self.head.next)
            self._add_last(key, value)

    def _remove_node(self, node):
        node.prev.next, node.next.prev = node.next, node.prev
        del self.cache[node.key]

    def _add_last(self, key, value):
        new = Node(value, key, next=self.tail, prev=self.tail.prev)
        self.cache[key] = new
        self.tail.prev.next = new
        self.tail.prev = new

    def _move_to_tail(self, node):
        node.prev.next, node.next.prev = node.next, node.prev
        node.prev = self.tail.prev
        node.next = self.tail
        self.tail.prev.next = node
        self.tail.prev = node

# Your LRUCache object will be instantiated and called as such:
# obj = LRUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)
# leetcode submit region end(Prohibit modification and deletion)
