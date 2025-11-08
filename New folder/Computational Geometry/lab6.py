import math

def translate_points(points, gx, gy):
    """Translate all points by vector (-gx, -gy)."""
    return [(x - gx, y - gy) for x, y in points]

def centroid(points):
    """Compute the centroid of a polygon with vertices points."""
    n = len(points)
    cx = sum(x for x, y in points) / n
    cy = sum(y for x, y in points) / n
    return cx, cy

def quadrant(x, y):
    """Determine the quadrant of point (x, y) relative to the origin."""
    if x > 0 and y >= 0:
        return 1
    elif x <= 0 and y > 0:
        return 2
    elif x < 0 and y <= 0:
        return 3
    elif x >= 0 and y < 0:
        return 4
    return 0

def angle_with_x_axis(x, y):
    """Compute the angle of point (x, y) with the x-axis."""
    return math.atan2(y, x)

def sort_points(points):
    """Sort points by quadrant and angle with x-axis."""
    return sorted(points, key=lambda p: (quadrant(*p), angle_with_x_axis(*p)))

def determinant(p, q, r):
    """Calculate the determinant to check the orientation of point r with respect to line pq."""
    px, py = p
    qx, qy = q
    rx, ry = r
    return (qx - px) * (ry - py) - (qy - py) * (rx - px)

def localize_point_in_polygon(vertices, M):
    """Localize point M in relation to a convex polygon with vertices."""
    
    Gx, Gy = centroid(vertices)
    translated_vertices = translate_points(vertices, Gx, Gy)
    translated_M = (M[0] - Gx, M[1] - Gy)
    
    sorted_vertices = sort_points(translated_vertices)
    
    if translated_M == (0, 0):
        return "Interior"
    
    n = len(sorted_vertices)
    low, high = 0, n - 1
    while low <= high:
        mid = (low + high) // 2
        A = sorted_vertices[mid]
        B = sorted_vertices[(mid + 1) % n]
        
        if determinant(A, B, translated_M) > 0:
            return "Interior"
        elif determinant(A, B, translated_M) < 0:
            return "Exterior"
        else:
            return "Border"
    
    return "Unknown"

vertices = [(1, 3), (4, 5), (6, 2), (5, -1), (2, -2)]
M = (3, 2)
result = localize_point_in_polygon(vertices, M)
print(f"The point M is in the {result} of the polygon.")