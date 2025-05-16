from typing import Any
import ctypes

class MeraList:
    def __init__(self):
        self.__size = 1
        self.__length = 0
        self.A = self.__make_array(self.__size)
    
    def __make_array(self, capacity: int):
        return (capacity*ctypes.py_object)()

    def append(self, item: Any):
        if self.__size == self.__length:
            self.__resize(self.__size*2)

        self.A[self.__length] = item
        self.__length += 1

    def pop(self):
        if self.__length == 0:
            raise IndexError("pop from empty list")
        self.__length -= 1
        return self.A[self.__length]
    
    def clear(self):
        self.__length = 0
        self.__size = 1
        self.A = self.__make_array(self.__size)
    
    def insert(self, index: int, element: int):
        if self.__length == self.__size:
            self.__resize(self.__length * 2)
        
        # index >= length add element at last index
        if index >= self.__length:
            self.A[self.__length] = element
        # If index is in rage then add at specified Position
        else:
            for i in range(index, self.__length):
                self.A[i + 1] = self.A[i]
            self.A[index] = element
        self.__length += 1

    def find(self, item):
        index = 0
        while index < self.__length:
            if self.A[index] == item:
                return index
            index += 1
        raise ValueError("item is not in the list")


    def remove(self, item: int):
        index = self.find(item)
        self.__delitem__(index)
    
    def __resize(self, increased_capacity: int):
        B = self.__make_array(increased_capacity)
        self.__size = increased_capacity
        for index in range(self.__length):
            B[index] = self.A[index]
        
        self.A = B
    
    def __len__(self):
        return self.__length
    
    def __str__(self):
        result = ''
        for index in range(self.__length):
            result = (result + str(self.A[index]) + ',') if index != self.__length -1 else (result + str(self.A[index]))
        
        return f'[{result}]'
    
    def __getitem__(self, index):
        if self.__length - 1 < index:
            raise IndexError("list index out of range")
        
        return self.A[index]
    
    def __delitem__(self, index):
        if not (index >= 0 and index <= self.__length -1):
            raise IndexError("list assignment index out of range")
        for i in range(index + 1, self.__length):
            self.A[i -1] = self.A[i]
        self.__length -= 1