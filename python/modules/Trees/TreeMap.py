from .Node import BSTNode

class TreeMap:
    def __init__(self):
        self.__root = None

    def setItem(self, key, value=None):
        def innerSetFunction(root, key, value):
            if root is None:
                root = BSTNode(key, value)
                return root
            
            if key < root.key:
                root.left = innerSetFunction(root.left, key, value)
                root.parent = root
            
            if key > root.key:
                root.right = innerSetFunction(root.right, key, value)
                root.parent = root
            
            return root
        
        success = self.updateItem(key, value)
        if success:
            return
        self.__root = innerSetFunction(self.__root, key, value)

    def __findItem(self, key):
        def innerfind(root, key):
            if root is None:
                return None
            
            if root.key == key:
                return root
            
            if key < root.key:
                return innerfind(root.left, key)
            return innerfind(root.right, key)
        
        return innerfind(self.__root, key)
    
    def findItem(self, key):
        return self.__getitem__(key)
    
    def updateItem(self, key, value):
        item = self.__findItem(key)
        if item is not None:
            item.value = value
            return True
        return False
    
    @classmethod
    def calculateMin(cls, root):
        if root is None:
            return None, None
        
        left_min, left_max = cls.calculateMin(root.left)
        right_min, right_max = cls.calculateMin(root.right)

        min_key = min([x for x in (left_min, root.key, right_min) if x is not None])
        max_key = max([x for x in (left_max, root.key, right_max) if x is not None])
        
        return min_key, max_key
    
    @property
    def length(self):
        def calculateLength(root):
            if root is None:
                return 0
            return 1 + calculateLength(root.left) + calculateLength(root.right)
        
        return calculateLength(self.__root)
    
    @property
    def height(self):
        def calculateHeight(root):
            if root is None:
                return 0
            return 1 + max(calculateHeight(root.left), calculateHeight(root.right))
        return calculateHeight(self.__root)
    
    @property
    def min(self):
        return TreeMap.calculateMin(self.__root)[0]
    
    @property
    def root(self):
        return self.__root.key
    
    @root.setter
    def root(self, root):
        if isinstance(root, BSTNode):
            self.__root = root
            return
        raise ValueError("root must be the instance of TreeMap or BSTNode")
    
    @classmethod
    def create_balance_binary_tree(cls, arr, lo=0, hi= None, parent= None):
        if isinstance(arr, list) or isinstance(arr, tuple):
            if hi is None:
                hi = len(arr) -1

            if lo > hi:
                return None
            
            mid = (lo + hi) // 2
            key, value = arr[mid]

            root = BSTNode(key, value)
            root.left = cls.create_balance_binary_tree(arr, lo, mid -1, root)
            root.right = cls.create_balance_binary_tree(arr, mid + 1, hi, root)

            return root
    
    @classmethod
    def display_trees(cls, root, level=0, prefix=""):
        if root is not None:
            cls.display_trees(root.left, level + 1, "↗")
            print("   "* level + prefix+ str(root.key))
            cls.display_trees(root.right, level + 1, "↘")

    def dp(self):
        self.display_trees(self.__root)

    
    def __len__(self):
        return self.length
    
    def __setitem__(self, key, value):
        self.setItem(key, value)

    def __getitem__(self, key):
        item = self.__findItem(key)

        if item is None:
            return -1
        return item.value