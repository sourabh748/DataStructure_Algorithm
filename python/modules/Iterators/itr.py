import sys

class Iter:
    
    def __init__(self, n):
        self.__n = n

    def __iter__(self):
        self.__current = -1
        return self
    
    def __next__(self):
        self.__current += 1

        if self.__current >= self.__n:
            raise StopIteration("loop ends hear")
        
        return self.__current
    
def gen(x):
    print('before pause')
    for i in range(x):
        yield i
    print("after pause")

def csv_file_reader(file_path):
    for row in open(file_path):
        yield row

if __name__ == '__main__':
    for i in gen(10):
        print(i)