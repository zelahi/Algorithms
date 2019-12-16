class Node:
    def __init__(self, key=-1):
        self.key = key 
        self.up = Node(key)
        self.down = Node(key)
        self.left = Node(key)
        self.right = Node(key)
    
    
    
