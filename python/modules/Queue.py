from .LinkedList import Node

class Queue:
    def __init__(self):
        self.__front = None
        self.__rear = None

    def enqueue(self, item):    # Time Complexity O(1)
        node = Node(item)
        if self.__rear is None:
            self.__front = self.__rear = node
        else:
            self.__rear.next = node
            self.__rear = node

    def dequeue(self):     # Time Complexity O(1)
        if self.__front == self.__rear == None:
            return -1

        else:
            data = self.__front.data
            if self.__front == self.__rear:
                self.__front = self.__rear = None
            else:
                self.__front = self.__front.next
            return data
    
    def is_empty(self):
        return self.__front == self.__rear == None
    
    def front(self):
        if self.__front is None:
            raise IndexError("No Element is found")
        return self.__front.data
    
    def rear(self):
        if self.__rear is None:
            raise IndexError("No Element is found")
        return self.__rear.data
        
    def __str__(self):
        result = ""
        curr = self.__head

        while curr is not None:
            result = (result + str(curr.data) + "->") if curr.next is not None else (result + str(curr.data))
            curr = curr.next
        return result
    
    
