class Node:
    def __init__(self, data):
        self.data = data
        self.next = None

class LinkedList:
    def __init__(self):
        self.__head = None
        self.__count = 0

    def __len__(self):
        # Length of Linked is the number of Nodes
        return self.__count
    
    def insert_head(self, value):
        new_node = Node(value)
        new_node.next = self.__head
        self.__head = new_node
        self.__count += 1
    
    def append(self, value):

        if not self.__head:
            self.insert_head(value)
            return
        curr = self.__head
        while curr.next != None:
            curr = curr.next

        curr.next = Node(value)
        self.__count += 1

    def insert(self, index, item):
        
        # index < 0 ❌
        if index < 0:
            raise IndexError("LL index is out of range")
        
        # LL is empty or index == 0
        if not self.__head or index == 0:
            self.insert_head(item)
            return
        # index >= count
        if index >= self.__count:
            index = self.__count

        # index is in between linked list
        curr, curr_count = self.__head, 0
        new_node = Node(item)

        while curr != None:

            if curr_count == index -1:
                new_node.next = curr.next
                curr.next = new_node
                self.__count += 1
                return
            curr = curr.next
            curr_count += 1

    def clear(self):
        self.__head = None
        self.__count = 0
    
    def delete_head(self):
        if not self.__head:
            return
        self.__head = self.__head.next
        self.__count -= 1
    
    def pop(self):

        if self.__head == None or self.__head.next == None:
            self.delete_head()
            return
        curr = self.__head
        while curr.next.next != None:
            curr = curr.next
        curr.next = None
        self.__count -= 1

    def remove(self, **kwargs):
        index = kwargs.get('index', -1)
        value = kwargs.get('value', -1)

        if (index == value == -1) or (index != -1 and value != -1):
            raise ValueError("either of the index or value must be specified")
        
        if not self.__head:
                return
        
        if index != -1:
            if index < 0 or index >= self.__count:
                raise IndexError("LL index is out of range")
            
            if index == 0:
                self.delete_head()
            
            curr, count = self.__head, 0
            while curr != None:
                if count == index -1:
                    curr.next = curr.next.next
                    self.__count -= 1
                    return
                curr = curr.next
                count += 1
        elif value != -1:

            if self.__count == 1 or self.__head.data == value:
                if self.__head.data == value:
                    self.delete_head()
                    return
                raise ValueError("Item is not found")
                    
            curr = self.__head
            while curr.next != None and curr.next.data != value:
                curr = curr.next

            if curr != None:
                curr.next = curr.next.next
                self.__count -= 1
                return
            raise ValueError("Item is not found")
        
    def find(self, value):
        # if LL is empty
        if not self.__head:
            return -1
        
        curr, index = self.__head, 0
        while curr != None and curr.data != value:
            index += 1
            curr = curr.next
        if curr != None:
            return index
        return -1
    
    def head(self):
        return self.__head

    def __getitem__(self,index):
        if not self.__head:
            return -1
        if not (index >=0 and index <= self.__count -1):
            raise IndexError("LL index out of range")
        
        curr = self.__head
        while curr != None and index > 0:
            index -= 1
            curr = curr.next

        if curr:
            return curr.data
        return -1


    def __str__(self):
        result = ""
        curr = self.__head
        while curr  != None:
            result = (result + str(curr.data) + "->") if curr.next else (result + str(curr.data))
            curr = curr.next
        return result