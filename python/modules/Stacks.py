from LinkedList import Node

class Stack:
    def __init__(self):
        self.top = None

    def is_empty(self):
        return self.top is None
    
    def push(self, item):
        new_node = Node(item)
        new_node.next = self.top
        self.top = new_node

    