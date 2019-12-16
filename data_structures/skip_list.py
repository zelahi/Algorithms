import random

# [0] -> same level
# everything else is indexed at the other levels.
    # each index corresponds to a different level

# Key of next node is less than key to be inserted then we keep on moving forward on the same level

# Key of next node is greater than the key to be inserted then we store the pointer to current node i
#   at update[i] and move one level down and continue our search.
class Node:
    def __init__(self, key, level):
        self.key = key
        self.next = [None] * (level+1)

class SkipList:
    def __init__(self, max_lvl, P):
        # The max number of levels 
        self.MAX_LVL = max_lvl
        self.partition = P
        self.header = self.__createNode(self.MAX_LVL, -1)
        self.level = 0
    
    def insert(self, key):
        update = [None] *(self.MAX_LVL+1)
        curr = self.header

        for i in range(self.level,-1,-1):
            while curr.next[i] and curr.next[i].key < key:
                curr = curr.next[i]
            update[i] = curr

        curr = curr.next[0]
        if curr == None or curr.key != key:
            rlevel = self.__randomLevel()
    
            if rlevel > self.level:
                for i in range(self.level+1, rlevel+1):
                    update[i] = self.header
                self.level = rlevel
            
            n = self.__createNode(rlevel, key)

            for i in range(rlevel+1):
                n.next[i] = update[i].next[i]
                update[i].next[i] = n
    
    def search(self, search_key):
        curr = self.header
        
        for i in range(self.level,-1,-1):
            while curr.next[i] and curr.next[i].key < search_key:
                curr = curr.next[i]
        
        curr = curr.next[0]
        return curr and curr.key == search_key

    def delete(self, key):
        update = [None] * (self.MAX_LVL+1)
        curr =  self.header

        for i in range(self.level,-1,-1):
            while curr.next[i] and curr.next[i].key < key:
                curr = curr.next[i]
            update[i] = curr
        
        curr  = curr.next[0]

        if curr is not None and curr.key == key:
            for i in range(self.level+1):
                if update[i].next[i] != curr:
                    break
                update[i].next[i] = curr.next[i]
        
        while self.level > 0 and self.header.next[self.level] == None:
            self.level -= 1
    
    def print_list(self):
        for lvl in range(self.level):
            print('Level {}:'.format(lvl), end=" ")
            node = self.header.next[lvl]
            while node != None:
                print(node.key, end=" ")
                node = node.next[lvl]
            print("")

    def __createNode(self, lvl, key):
        n = Node(key, lvl)
        return n
    
    def __randomLevel(self):
        lvl = 0
        while random.random() < self.partition and lvl < self.MAX_LVL:
            lvl += 1
        return lvl
        
def main(): 
    lst = SkipList(3, 0.5) 
    lst.insert(3) 
    lst.insert(6)
    lst.insert(7)
    lst.insert(9)
    lst.insert(12)
    lst.insert(19)
    lst.insert(17)
    lst.insert(26)
    lst.insert(21)
    lst.insert(25)
    lst.print_list()
    print(lst.search(7))
    print(lst.search(5))
    print(lst.search(17))
    lst.delete(19)
    lst.print_list()

  
main()
