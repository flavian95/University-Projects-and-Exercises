def quadrant(x, y):
    if x > 0 and y >= 0:
        return 1
    if x <= 0 and y > 0:
        return 2
    if x < 0 and y <= 0:
        return 3
    if x >= 0 and y < 0:
        return 4
    return 0

def det(x1, y1, x2, y2, x3, y3):
    return x1 * y2 + x2 * y3 + x3 * y1 - x3 * y2 - x2 * y1 - x1 * y3

def main():
    vx = [0] * 20
    vy = [0] * 20

    n = int(input("Number of Points: "))

    for i in range(1, n + 1):
        print(f"Point {i} has coordinates: ")
        vx[i] = int(input("x: "))
        vy[i] = int(input("y: "))

    for i in range(1, n - 1):
        for j in range(i + 1, n + 1):
            if quadrant(vx[i], vy[i]) > quadrant(vx[j], vy[j]) or \
               (quadrant(vx[i], vy[i]) == quadrant(vx[j], vy[j]) and 
                det(vx[i], vy[i], vx[j], vy[j], 0, 0) > 0):
                
                vx[i], vx[j] = vx[j], vx[i]
                vy[i], vy[j] = vy[j], vy[i]

    for i in range(1, n + 1):
        print(f"Point {i} at ({vx[i]}, {vy[i]})")

if __name__ == "__main__":
    main()