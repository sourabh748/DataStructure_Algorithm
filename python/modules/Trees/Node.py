from typing import Any

class BSTNode:
    def __init__(self, key, value=None, parent= None):
        self.key = key
        self.value = value
        self.left = None
        self.right = None
        self.parent = parent
    
    def __repr__(self):
        return f'BSTNode(Key={self.key}, value={self.value}'
    
    def __str__(self):
        return self.__str__()