from .Node import Node

class LinkedList:
    def __init__(self, key, value):
        self.__head = Node(key, value)

    def add(self, key, value):
        
        curr = self.__head
        while curr.key != key and curr.next != None:
            curr = curr.next

        if curr.key == key:
            curr.value = value
            return
        
        curr.next = Node(key, value)

    def remove(self, key):
        curr = self.__head
        prev = None
        while curr.next is not None and curr.key != key:
            prev = curr
            curr = curr.next

        if curr.key == key:
            prev.next = curr.next

    def find(self, key):
        curr = self.__head
        while curr is not None and curr.key != key:
            curr = curr.next

        if curr.key == key:
            return curr.value
        return -1

    @property
    def head(self):
        return self.__head
    
    @head.setter
    def head(self, head):
        self.__head = head

    