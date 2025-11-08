
def b_sort(A):
    for i in range(len(A) - 1):
        for j in range(len(A) - 1):
            if A[j] > A[j + 1]:
                A[j], A[j + 1] = A[j + 1], A[j]
    return A

def main():
    A = [1, 3, 5, 7]
    B = [6, 4, 2, 8]
    C = [5, 7, 9, 3]
    
    B1 = b_sort(B)
    B1 = [2 * b for b in B1]
    
    C1 = b_sort(C)
    
    D = [0, 0, 0, 0]
    
    for i in range(len(B)):
        for j in range(len(B)):
            D[j] = A[i] + C1[j]
        
        l = 0
        m = 0
        
        while l <= len(B) - 1 and m <= len(B) - 1:
            if D[l] == B1[m]:
                print("Found it!")
                print(f"{{({A[i]}, {B1[m] // 2}, {C1[l]})}}")
                break
            elif D[l] < B1[m]:
                l += 1
            else:
                m += 1

if __name__ == "__main__":
    main()