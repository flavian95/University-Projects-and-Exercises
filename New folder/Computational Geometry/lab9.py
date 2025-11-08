class Vertex:
    def __init__(self, x, y):
        self.x = x
        self.y = y
        self.incident_edge = None  # A half-edge originating from this vertex

class HalfEdge:
    def __init__(self):
        self.origin = None  # Starting vertex of the half-edge
        self.twin = None  # Twin half-edge in the opposite direction
        self.incident_face = None  # Face this half-edge borders
        self.next = None  # Next half-edge in counterclockwise order
        self.prev = None  # Previous half-edge in counterclockwise order

class Face:
    def __init__(self):
        self.outer_component = None  # An outer half-edge (if a hole exists)
        self.inner_components = []  # Inner half-edges forming boundaries

class DCEL:
    def __init__(self):
        self.vertices = []
        self.half_edges = []
        self.faces = []

    def add_vertex(self, x, y):
        v = Vertex(x, y)
        self.vertices.append(v)
        return v

    def add_half_edge_pair(self, origin, destination):
        he1 = HalfEdge()
        he2 = HalfEdge()

        he1.origin = origin
        he2.origin = destination

        he1.twin = he2
        he2.twin = he1

        self.half_edges.extend([he1, he2])

        return he1, he2

    def link_half_edges(self, he1, he2):
        he1.next = he2
        he2.prev = he1

# Example usage for constructing the DCEL
dcel = DCEL()

# Add vertices (coordinates extracted from the image and documents)
vertices = [
    dcel.add_vertex(-7, 1),  # Vertex 1
    dcel.add_vertex(-4, 2),  # Vertex 2
    dcel.add_vertex(5, 2),   # Vertex 3
    dcel.add_vertex(-4, 0),  # Vertex 4
    dcel.add_vertex(5, 5),   # Vertex 5
    dcel.add_vertex(-1, 6),  # Vertex 6
    dcel.add_vertex(-6, 8),  # Vertex 7
    dcel.add_vertex(4, 10),  # Vertex 8
    dcel.add_vertex(-2, 11), # Vertex 9
    dcel.add_vertex(6, 13),  # Vertex 10
    dcel.add_vertex(1, 15),  # Vertex 11
]

# Add edges and connect them (based on adjacency and directions in the PSLG)
edges = []
edges.append(dcel.add_half_edge_pair(vertices[0], vertices[1]))  # Edge 1
edges.append(dcel.add_half_edge_pair(vertices[1], vertices[2]))  # Edge 2
edges.append(dcel.add_half_edge_pair(vertices[2], vertices[3]))  # Edge 3
edges.append(dcel.add_half_edge_pair(vertices[3], vertices[4]))  # Edge 4
edges.append(dcel.add_half_edge_pair(vertices[4], vertices[5]))  # Edge 5

# Additional edge-linking logic can be added as needed
