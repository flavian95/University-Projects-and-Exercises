
from typing import List

class Point:
    def __init__(self, x: float, y: float):
        self.x = x
        self.y = y

def is_point_inside_polygon(M: Point, polygon: List[Point]) -> int:
    n = len(polygon)
    count = 0

    for i in range(n):
        Pi = polygon[i]
        PiPlus1 = polygon[(i + 1) % n]

        if Pi.y < PiPlus1.y:
            A, B = Pi, PiPlus1
        else:
            A, B = PiPlus1, Pi

        if Pi.y == PiPlus1.y and M.y == Pi.y and min(Pi.x, PiPlus1.x) <= M.x <= max(Pi.x, PiPlus1.x):
            return 2

        if A.y < M.y <= B.y:
            orientation = (M.x - A.x) * (B.y - A.y) - (M.y - A.y) * (B.x - A.x)

            if orientation == 0 and min(A.x, B.x) <= M.x <= max(A.x, B.x):
                return 2

            if orientation > 0:
                count += 1

    return count % 2

def main():
    polygon = [
        Point(0, 0),  
        Point(4, 0),  
        Point(6, 3),  
        Point(4, 6),
        Point(0, 6), 
        Point(-2, 3),
    ]
    
    M = Point(3, 3)

    is_inside = is_point_inside_polygon(M, polygon)
    if is_inside == 2:
        print("Point M is on the polygon.")
    elif is_inside == 0:
        print("Point M is outside the polygon.")
    elif is_inside == 1:
        print("Point M is inside the polygon.")

if __name__ == "__main__":
    main()