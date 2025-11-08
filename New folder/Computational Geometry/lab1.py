
def find_position(arr):
    x = float(input("Enter the value of x: "))
    n = len(arr)

    if x < arr[0]:
        print(f"x is before a1")
        return

    if x > arr[-1]:
        print(f"x is after an")
        return

    low, high = 0, n - 1
    while low <= high:
        mid = (low + high) // 2

        if x == arr[mid]:
            print(f"x is exactly a{mid+1}")
            return
        elif x < arr[mid]:
            high = mid - 1
        else:
            low = mid + 1

    print(f"x is between a{high+1} and a{low+1}")

arr = [1, 3, 5, 7, 9] 
find_position(arr)


