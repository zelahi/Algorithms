class Node:
    def __init__(self, val):
        self.val = val
        self.next = None
    
class SortedLinkedList:
    def __init__(self, val):
        self.head = Node(None)
        self.mid = self.head
        self.tail = self.head
        self.no_of_nodes = 1
    
    def insert(self, val):
        tmp = self._create_node(val)

        if self.head.next is None:
            self.head.next = tmp
            self.tail = tmp
            self.mid = self.tail
            self.no_of_nodes += 1
        else:
            curr = self.insert_pt(val)
            tmp.next = curr.next
            curr.next = tmp
    
    def _create_node(self, val):
        return Node(val)
    
    def find(self, val):
        curr = self.head
        while curr is not None:
            if curr.val == val:
                return val
            curr = curr.next
        return None
    
    def remove(self, to_delete):
        curr = self.head
        if self.head.val == to_delete:
            tmp = self.head
            self.head = self.head.next
            tmp.next = None
            return

        while curr.next is not None and curr.next.val != to_delete:
            curr = curr.next

        # Value does not exist in the linked list
        if curr.next is None and curr.val != to_delete:
            print("value not found")
            return 

        tmp = curr.next
        curr.next = curr.next.next
        tmp.next = None

    def insert_pt(self, val):
        if self.head.next is None:
            return self.head
                
        curr = self.head
        while curr.next is not None and curr.next.val < val:
            curr = curr.next

        return curr
    
    def print_list(self):
        curr = self.head
        res = []
        while curr is not None:
            res.append(curr.val)
            curr = curr.next
        print(res)

# ========= Test Driver Code =======
test = SortedLinkedList(5)
test.insert(1)
test.insert(3)
test.insert(7)
test.print_list()
print(test.find(4))
print(test.find(5))
test.remove(3)
test.remove(9)
test.print_list()
test.insert(3)
test.print_list()
print(test.insert_pt(2).val)
