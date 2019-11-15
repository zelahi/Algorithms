class node:
    def __init__(self, value=None):
        self.value = value
        self.left = None
        self.right = None

class binary_search_tree:
    def __init__(self):
        self.root=None

    def insert(self, value):
        if self.root is None:
            self.root = node(value)
        else:
          self._insert(value, self.root)
    
    def _insert(self, value, curr_node):
        if value < curr_node.value:
            if curr_node.left is None:
                curr_node.left = node(value)
            else:
                self._insert(value, curr_node.left)
        
        if value > curr_node.value:
            if curr_node.right is None:
                curr_node.right = node(value)
            else:
                self._insert(value, curr_node.right)
        
        if value == curr_node.value:
            print('Value already inserted')
    
    def print_tree(self, traversal_type):
        if self.root is not None:
            if traversal_type == "inorder_i":
                self._print_inorder_tree_iterative(self.root)
            elif traversal_type == "inorder":
                self._print_inorder_tree(self.root)
            elif traversal_type == "preorder":
                self._print_preorder_tree(self.root)
            elif traversal_type == "preorder_i":
                self._print_preorder_tree_iterative(self.root)
            elif traversal_type == "postorder":
                self._print_post_order_tree(self.root)
            elif traversal_type == "postorder_i":
                self._print_post_order_tree_iterative(self.root)
            else:
                print('Not a valid option')
    
    def _print_inorder_tree_iterative(self, root):
        stack = []
        curr_node = root

        while True:
            if curr_node is not None:
                stack.append(curr_node)
                curr_node = curr_node.left
            elif(stack):
                curr_node = stack.pop()
                print(curr_node.value, end=" ")
                curr_node = curr_node.right
            else:
                break
        print()
    
    def _print_preorder_tree_iterative(self, root):
        if root is None:
            return
        
        stack = []
        curr_node = root
        stack.append(curr_node)

        while len(stack) > 0:
            if curr_node is not None:
                curr_node = stack.pop()
                print(curr_node.value)
            
            if curr_node.right is not None:
                stack.append(curr_node.right)
            if curr_node.left is not None:
                stack.append(curr_node.left)
    
    def _print_post_order_tree_iterative(self, root):
        if root is None:
            return
        
        stack1 = []
        stack2 = []
        curr_node = root
        stack1.append(curr_node)

        while len(stack1) > 0:
            if curr_node is not None:
                curr_node = stack1.pop()
                stack2.append(curr_node)

            if curr_node.left is not None:
                stack1.append(curr_node.left)
            if curr_node.right is not None:
                stack1.append(curr_node.right)
        
        while len(stack2) > 0:
            curr_node = stack2.pop()
            print(curr_node.value)


    def _print_preorder_tree(self, curr_node):
        if curr_node is not None:
            print(curr_node.value)
            self._print_preorder_tree(curr_node.left)
            self._print_preorder_tree(curr_node.right)

    def _print_post_order_tree(self, curr_node):
        if curr_node is not None:
            self._print_post_order_tree(curr_node.left)
            self._print_post_order_tree(curr_node.right)
            print(curr_node.value)

    def _print_inorder_tree(self, curr_node):
        if curr_node is not None:
            self._print_inorder_tree(curr_node.left)
            print(curr_node.value)
            self._print_inorder_tree(curr_node.right)

def fill_tree(tree, num_elems=100, max_int=1000):
    from random import randint
    for _ in range(num_elems):
        curr_elem = randint(0, max_int)
        tree.insert(curr_elem)
    return tree

tree = binary_search_tree()
tree = fill_tree(tree, 10, 10)
print("==== In Order traversal Iterative ====")
tree.print_tree("inorder_i")
print("==== In Order traversal ====")
tree.print_tree("inorder")
print("==== Pre Order traversal ====")
tree.print_tree("preorder")
print("==== Pre order traversal Iterative ====")
tree.print_tree("preorder_i")
print("==== Post order traversal ====")
tree.print_tree("postorder")
print("==== Post order traversal Iterative ====")
tree.print_tree("postorder_i")

