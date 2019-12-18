class Node:
    def __init__(self):
        self.child = {}
        self.isEnd = False


class Trie:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.root = Node()

    def insert(self, word: str) -> None:
        """
        Inserts a word into the trie.
        """
        node = self.root
        for char in word:
            if char not in node.child:
                node.child[char] = Node()
            node = node.child[char]
        node.isEnd = True

    def search(self, word: str) -> bool:
        """
        Returns if the word is in the trie.
        """
        node = self.root
        for char in word:
            if char not in node.child:
                return False
            node = node.child[char]
        return node.isEnd

    def startsWith(self, prefix: str) -> bool:
        """
        Returns if there is any word in the trie that starts with the given prefix.
        """
        node = self.root
        for char in prefix:
            if char not in node.child:
                return False
            node = node.child[char]
        return True

    def delete(self, word):
        return self.__delete(self.root, word, 0)
    
    def __delete(self, node, word, i):
        if len(word) == i:
            if not node.isEnd:
                return False
            node.isEnd = False
            return len(node.child) == 0
        if word[i] not in node.child:
            return False
        to_delete = self.__delete(node.child[word[i]], word, i+1)
        if to_delete:
            node.child.pop(word[i])
            return len(node.child) == 0
        return False