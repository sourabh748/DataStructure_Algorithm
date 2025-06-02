import asyncio
import time

lock = asyncio.Lock()

async def say_something(sleep_time, what):
    await asyncio.sleep(sleep_time)
    print(what)

async def fetch_data(id, sleep_time, error = None):
    print(f"coroutine {id} starting to Fetch data...")
    await asyncio.sleep(sleep_time)

    if error:
        raise asyncio.CancelledError("Custom Cancelled")
    
    print("Data Fetched")
    return {"id": id, "data": f"sample data for coroutine {id}" }

async def main():
    await some_function()

async def some_function():

    global lock
    tasks = set()

    print(f"started at {time.strftime('%X')}")

    async with lock:
        async with asyncio.TaskGroup() as tg:
            for id, sleep_deplay in enumerate([2, 1, 3], start=1):
                task = tg.create_task(fetch_data(id, sleep_deplay))
                tasks.add(task)
                task.add_done_callback(tasks.discard)
                
            try:
                task4 = tg.create_task(fetch_data(3, 4, True))
                task4.add_done_callback(tasks.discard)
                tasks.add(task4)
            except asyncio.CancelledError as e:
                print(e)
            finally:
                tasks.discard(task4)

            tg.create_task(say_something(3, "Sourabh Suman"))
            tg.create_task(say_something(5, "Suman"))

    print(f"finished at {time.strftime('%X')}")

    results = [task.result() for task in tasks]

    for result in results:
        print(f"Recived result: {result}")


if __name__ == '__main__':
    asyncio.run(main())