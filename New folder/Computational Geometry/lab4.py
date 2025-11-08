
def delta(x1, y1, x2, y2, x3, y3):
    """Calculate the signed area (determinant) for points (x1, y1), (x2, y2), (x3, y3)."""
    return (x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2))

def determine_case(A, B, C, M):
    x_a, y_a = A
    x_b, y_b = B
    x_c, y_c = C
    x_m, y_m = M

    d1 = delta(x_m, y_m, x_a, y_a, x_b, y_b)
    d2 = delta(x_m, y_m, x_b, y_b, x_c, y_c)
    d3 = delta(x_m, y_m, x_c, y_c, x_a, y_a)

    main_case = delta(x_a, y_a, x_b, y_b, x_c, y_c)

    if main_case > 0:
        print('Positive')
        if d1 > 0 and d2 > 0 and d3 > 0:
            return "ME(1)"
        elif d1 > 0 and d2 > 0 and d3 == 0:
            return "ME(2)"
        elif d1 > 0 and d2 == 0 and d3 > 0:
            return "ME(3)"
        elif d1 == 0 and d2 > 0 and d3 > 0:
            return "ME(4)"
        elif d1 > 0 and d2 == 0 and d3 == 0:
            return "ME(5)"
        elif d1 == 0 and d2 > 0 and d3 == 0:
            return "ME(6)"
        elif d1 == 0 and d2 == 0 and d3 > 0:
            return "ME(7)"
        elif d1 > 0 and d2 < 0 and d3 > 0:
            return "ME(8)"
        elif d1 > 0 and d2 > 0 and d3 < 0:
            return "ME(9)"
        elif d1 < 0 and d2 > 0 and d3 > 0:
            return "ME(10)"
        elif d1 > 0 and d2 < 0 and d3 == 0:
            return "ME(11)"
        elif d1 == 0 and d2 > 0 and d3 < 0:
            return "ME(12)"
        elif d1 < 0 and d2 == 0 and d3 > 0:
            return "ME(13)"
        elif d1 > 0 and d2 < 0 and d3 < 0:
            return "ME(14)"
        elif d1 < 0 and d2 > 0 and d3 < 0:
            return "ME(15)"
        elif d1 < 0 and d2 < 0 and d3 > 0:
            return "ME(16)"
        elif d1 < 0 and d2 == 0 and d3 == 0:
            return "ME(17)"
        elif d1 == 0 and d2 < 0 and d3 == 0:
            return "ME(18)"
        elif d1 < 0 and d2 < 0 and d3 < 0:
            return "ME(19)"
    elif main_case < 0:
        print('Negative')
        if d1 < 0 and d2 < 0 and d3 < 0:
            return "ME(1)"
        elif d1 < 0 and d2 < 0 and d3 == 0:
            return "ME(2)"
        elif d1 < 0 and d2 == 0 and d3 < 0:
            return "ME(3)"
        elif d1 == 0 and d2 < 0 and d3 < 0:
            return "ME(4)"
        elif d1 < 0 and d2 == 0 and d3 == 0:
            return "ME(5)"
        elif d1 == 0 and d2 < 0 and d3 == 0:
            return "ME(6)"
        elif d1 == 0 and d2 == 0 and d3 < 0:
            return "ME(7)"
        elif d1 < 0 and d2 > 0 and d3 < 0:
            return "ME(8)"
        elif d1 < 0 and d2 < 0 and d3 > 0:
            return "ME(9)"
        elif d1 > 0 and d2 < 0 and d3 < 0:
            return "ME(10)"
        elif d1 < 0 and d2 > 0 and d3 == 0:
            return "ME(11)"
        elif d1 == 0 and d2 < 0 and d3 > 0:
            return "ME(12)"
        elif d1 > 0 and d2 == 0 and d3 < 0:
            return "ME(13)"
        elif d1 < 0 and d2 > 0 and d3 > 0:
            return "ME(14)"
        elif d1 > 0 and d2 < 0 and d3 > 0:
            return "ME(15)"
        elif d1 > 0 and d2 > 0 and d3 < 0:
            return "ME(16)"
        elif d1 > 0 and d2 == 0 and d3 == 0:
            return "ME(17)"
        elif d1 == 0 and d2 > 0 and d3 == 0:
            return "ME(18)"
        elif d1 > 0 and d2 > 0 and d3 > 0:
            return "ME(19)"
    else:
        return "ABC is not a triangle (degenerate case)"

A = (1, 1)
B = (4, 1)
C = (2, 5)
M = (6, 0)

result = determine_case(A, B, C, M)
print("Result:", result)