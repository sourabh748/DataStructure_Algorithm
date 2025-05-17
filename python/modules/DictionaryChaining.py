from .chaining.LinkedList import LinkedList

# 1. Chaining we have 2 types of technique
        # 1. Rehasing
        # 2. Balance Tree Conversion

class DictionaryChain:
    def __init__(self, capacity):
        self.__capacity = capacity
        self.__hash_map = [None] * self.__capacity
    
    def setItem(self, key, value):
        _h = abs(hash(key)) % self.__capacity
        if self.__hash_map[_h] is None:
            self.__hash_map[_h] = LinkedList(key, value)
        else:
            self.__hash_map[_h].add(key, value)
    
    def getItem(self, key):
        _h = abs(hash(key)) % self.__capacity
        if self.__hash_map[_h] is None:
            return -1
        return self.__hash_map[_h].find(key)
    
    def removeItem(self, key):
        _h = abs(hash(key)) % self.__capacity

        if self.__hash_map[_h] is None:
            return
        elif self.__hash_map[_h].head.key == key and self.__hash_map[_h].head.next is None:
            self.__hash_map[_h] = None
        else:
            self.__hash_map[_h].remove(key)

    def __setitem__(self, key, value):
        self.setItem(key, value)

    def __getitem__(self, key):
        return self.getItem(key)
        