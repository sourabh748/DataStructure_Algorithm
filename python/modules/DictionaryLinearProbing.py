from typing import Any

class DictionaryLinear:                                    # ( Open Addressing Technique ------> Linear Probing )
    def __init__(self, size) -> None:
        self.__size = size
        self.__slot = [None]*size
        self.__value = [None]*size

    def setItem(self, key, value):
        # If append operation and size of array is full then resize the array and insert key value pair in it
        # if item is not present insert item
        # if item is present update item

        _h = abs(hash(key)) % self.__size
        hash_buff = _h
        if self.__slot[_h] is None:
            self.__slot[_h] = key
            self.__value[_h] = value
        else:
            if self.__slot[_h] == key:
                self.__slot[_h] = key
                self.__value[_h] = value
                return
            _h = self.__rehash(_h)
            while self.__slot[_h] != key and self.__slot[_h] is not None and _h != hash_buff:
                _h = self.__rehash(_h)
            if _h == hash_buff:
                self.__resize(key, value)
                return
            self.__slot[_h] = key
            self.__value[_h] = value
    
    def __resize(self, key, value):
        self.__size = self.__size * 2

        slot = [None] * self.__size
        _value = [None] * self.__size

        for index in range(self.__size//2):
            _h = abs(hash(self.__slot[index])) % self.__size
            if slot[_h] is None:
                slot[_h] = self.__slot[index]
                _value[_h] = self.__value[index]
            else:
                while slot[_h] != None:
                    _h = self.__rehash(_h)
                slot[_h] = self.__slot[index]
                _value[_h] = self.__value[index]

        self.__slot = slot
        self.__value = _value

        self.setItem(key, value)

    
    def getItem(self, key, default= -1) -> Any:
        _h = abs(hash(key)) % self.__size
        hash_buff = _h

        if self.__slot[_h] == key:
            return self.__value[_h]
        
        _h = self.__rehash(hash_buff)

        while self.__slot[_h] != key and _h != hash_buff:
            _h = self.__rehash(_h)
        
        if _h == hash_buff:
            return default
        return self.__value[_h]

    def __rehash(self, _h) -> int:
        return (_h + 1) % self.__size

    def __getitem__(self, key) -> Any:
        return self.getItem(key)
    
    def __setitem__(self, key, value) -> None:
        self.setItem(key, value)