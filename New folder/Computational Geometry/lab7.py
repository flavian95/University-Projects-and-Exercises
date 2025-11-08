# Define DCEL classes
class Vertex:
    def __init__(self, x, y, id):
        self.x = x  # X-coordinate
        self.y = y  # Y-coordinate
        self.id = id  # Vertex ID
        self.incident_edge = None  # A half-edge originating from this vertex

class HalfEdge:
    def __init__(self, origin, twin=None, next_edge=None, prev_edge=None, face=None):
        self.origin = origin  # The origin vertex of the half-edge
        self.twin = twin  # The twin half-edge (opposite direction)
        self.next_edge = next_edge  # The next half-edge in the cycle
        self.prev_edge = prev_edge  # The previous half-edge in the cycle
        self.face = face  # The face to the left of the half-edge

class Face:
    def __init__(self, id):
        self.id = id  # Face ID
        self.outer_component = None  # An edge on the outer boundary of the face
        self.inner_components = []  # Edges on the inner boundaries (holes)

# Build the DCEL structure
class DCEL:
    def __init__(self):
        self.vertices = {}  # Key: Vertex ID, Value: Vertex object
        self.edges = []  # List of HalfEdges
        self.faces = {}  # Key: Face ID, Value: Face object

    def add_vertex(self, id, x, y):
        if id not in self.vertices:
            self.vertices[id] = Vertex(x, y, id)

    def add_half_edge(self, origin_id, twin_id=None, face_id=None):
        origin = self.vertices.get(origin_id)
        if origin is None:
            raise ValueError("Vertex must be added before creating an edge.")
        
        edge = HalfEdge(origin=origin, face=self.faces.get(face_id))
        self.edges.append(edge)
        
        # Link twin edges if provided
        if twin_id is not None:
            twin_edge = self.edges[twin_id]
            edge.twin = twin_edge
            twin_edge.twin = edge

        return edge

    def add_face(self, id):
        if id not in self.faces:
            self.faces[id] = Face(id)

# Initialize DCEL instance
dcel = DCEL()

# Add vertices (assumed coordinates, adjust as needed)
vertices_data = [
    (1, 0, 0), (2, 1, 0), (3, 2, 0), (4, 0, 1), (5, 1, 1), 
    (6, 2, 1), (7, 0, 2), (8, 1, 2), (9, 2, 2), (10, 0, 3)
]
for v_id, x, y in vertices_data:
    dcel.add_vertex(v_id, x, y)

# Add edges based on the table
edge_data = [
    (1, 4, 6, 1, 2, 12, 14), (2, 3, 8, 2, 3, 4, 15), (3, 9, 3, 0, 2, 16, None),
    (4, 1, 3, 2, 0, 5, None), (5, 1, 7, 2, 0, 19, None), (6, 1, 4, 2, 0, 8, 18),
    (7, 10, 8, 6, 5, 9, None), (8, 4, 5, 1, 5, 3, None), (9, 5, 7, 0, 5, 11, 9),
    (10, 7, 11, 5, 6, 19, 14), (11, 5, 10, 5, 13, 12, None), (12, 4, 7, 1, 5, 3, None),
    (13, 5, 7, 0, 5, 9, None), (14, 6, 8, 1, 2, 12, None), (15, 8, 9, 3, 4, 7, 3),
    (16, 9, 12, 3, 0, 15, 17), (17, 12, 13, 0, 0, 16, 18), (18, 11, 13, 0, 0, 16, 18),
    (19, 11, 12, 0, 7, 4, 11)
]
for edge_id, va, vb, f1, f2, m1, m2 in edge_data:
    if va not in dcel.vertices or vb not in dcel.vertices:
        continue  # Skip if vertex information is incomplete
    if f1 != 0:
        dcel.add_face(f1)
    if f2 != 0:
        dcel.add_face(f2)
    edge = dcel.add_half_edge(origin_id=va, face_id=f1)

# Sorting procedures
def sort_vertices_by_y(dcel):
    return sorted(dcel.vertices.values(), key=lambda v: (v.y, v.x))

def sort_edges_by_origin(dcel):
    return sorted(dcel.edges, key=lambda e: e.origin.id)

sorted_vertices = sort_vertices_by_y(dcel)
sorted_edges = sort_edges_by_origin(dcel)

# Display sorted results
sorted_vertices_info = [(v.id, v.x, v.y) for v in sorted_vertices]
sorted_edges_info = [(e.origin.id, e.twin.origin.id if e.twin else None) for e in sorted_edges]

print("Sorted Vertices:", sorted_vertices_info)
print("Sorted Edges:", sorted_edges_info)
