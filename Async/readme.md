## Async Context Manager - 

    In Pyhton Async Context Manager is an object that creates a context that allows you to allocate the resource before running
    asynchronous code and release them after.

    To use this type of context manager, you need to async with statement.

    Asynchronous context managers are particularly useful when you need to run setup and teardown logic reliably, even if your asynchronous code encounters an error or interruption.

    To create an asynchronous context manager, you define a class that implements two special method:

    . __aenter__() is called when entering the context.
    . __aexit__() is called when leaving the context.

    Asynchronous Context Manager

    class AsyncContextManager:
        async def __aenter__(self):
            print("Entering context: Setup logic here...")
            return self
        async def __aexit__(self, exc_type, exc_val, exc_tb):
            print("Exiting context: Teardown logic here...")


    async def main():
        async with AsyncContextManager():
            print("Inside context: Your async code here...")


    import asyncio
    asyncio.run(main())

## Resource

[👉 click Understanding coroutines and Task in pyhton](https://medium.com/python-features/understanding-coroutines-tasks-in-depth-in-python-af2a4c0e1073) 

[👉 click Mastering Python’s Asyncio: A Practical Guide](https://medium.com/@moraneus/mastering-pythons-asyncio-a-practical-guide-0a673265cf04) ! Important

[👉 python docs](https://docs.python.org/3/library/asyncio.html)

