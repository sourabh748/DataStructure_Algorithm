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
                root.left.parent = root
            
            if key > root.key:
                root.right = innerSetFunction(root.right, key, value)
                root.right.parent = root
            
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
    
    @staticmethod
    def findSuccessor(root, key):
        
        if root is None:
            return None

        successor = None
        curr = root
        while curr is not None:
            if curr.key > key:
                successor = curr
                curr = curr.left
                continue
            
            if key >= curr.key:
                curr = curr.right

        return successor
    
    @staticmethod
    def helper_method(root):
        curr = root
        while curr.right is not None:
            curr = curr.right
        return curr
    
    def deleteItem(self, key):

        if self.__root.key == key:
            if self.__root.left is None and self.__root.right is None:
                self.__root = None
            elif self.__root.left is not None:
                sibling_r = self.__root.right
                self.__root = self.__root.left

                curr = self.__root
                right_leaf = TreeMap.helper_method(curr)
                right_leaf.right = sibling_r
                self.__root.parent = None
            else:
                self.__root = self.__root.right
                self.__root.parent = None

            return


        node = self.__findItem(key)

        if node is not None:
            ancestor = node.parent
            if node.left is None and node.right is None:
                if node.key < ancestor.key:
                    ancestor.left = None
                else:
                    ancestor.right = None
            elif node.left is not None:
                sibling_l = node.left
                sibling_r = node.right
                right_leaf = TreeMap.helper_method(sibling_l)

                if node.key < ancestor.key:
                    ancestor.left = sibling_l
                else:
                    ancestor.right = sibling_l
                right_leaf.right = sibling_r
                sibling_l.parent = ancestor
            else:
                sibling_r = node.right
                if node.key < ancestor.key:
                    ancestor.left = sibling_r
                else:
                    ancestor.right = sibling_r
                sibling_r.parent = ancestor
            node.parent = None
        else:
            raise ValueError("key not found")
    
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
            root.parent = parent

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
    
    def __delitem__(self, key):
        self.deleteItem(key)