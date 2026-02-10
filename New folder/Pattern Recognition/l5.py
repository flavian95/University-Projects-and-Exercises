
import numpy as np
import matplotlib.pyplot as plt

# ==========================================================
# PART 0 – CREATE "IMAGES" (SIMULATED DATA)
# ==========================================================

np.random.seed(42)

num_pixels = 20
num_images = 10

x = np.linspace(0, 2*np.pi, num_pixels)
A = np.zeros((num_pixels, num_images))

for i in range(num_images):
    A[:, i] = np.sin(x) + 0.1 * i + 0.2 * np.random.randn(num_pixels)

A = A.astype(np.float64)

# ==========================================================
# STEP 1 – MEAN IMAGE
# ==========================================================

media = np.mean(A, axis=1)

# ==========================================================
# STEP 2 – CENTER TRAINING DATA
# ==========================================================

B = A.copy()
A = (A.T - media).T

# ==========================================================
# STEP 3 – OPTIMAL COVARIANCE MATRIX
# ==========================================================

L = np.dot(A.T, A)

# ==========================================================
# STEP 4 – EIGENFACES (HQPB)
# ==========================================================

d, V_L = np.linalg.eig(L)

idx = np.argsort(d)[::-1]

k = 5
idx = idx[:k]
V_L = V_L[:, idx]

HQPB = np.dot(A, V_L)

# Normalize eigenfaces
for i in range(k):
    HQPB[:, i] /= np.linalg.norm(HQPB[:, i])

# ==========================================================
# STEP 5 – PROJECT TRAINING IMAGES
# ==========================================================

proiectii = np.dot(A.T, HQPB)

# Restore original training images
A = B

# ==========================================================
# PART 2 – TESTING (NN on projections)
# ==========================================================

# --- Create a TEST image (unknown face) ---
cautat = np.sin(x) + 0.15 + 0.2 * np.random.randn(num_pixels)

# ==========================================================
# Step 1 – Center test image
# ==========================================================

cautat = cautat - media

# ==========================================================
# Step 2 – Project test image into eigenface space
# ==========================================================

pr_cautat = np.dot(cautat, HQPB)

# ==========================================================
# Step 3 – Nearest Neighbor (NN)
# ==========================================================

def NN(proiectii, pr_cautat, norma=2):
    """
    proiectii: training projections (num_images x k)
    pr_cautat: test projection (k,)
    norma: 2 = Euclidean, 1 = Manhattan
    """
    distances = np.zeros(proiectii.shape[0])

    for i in range(proiectii.shape[0]):
        if norma == 2:
            distances[i] = np.linalg.norm(proiectii[i] - pr_cautat)
        else:
            distances[i] = np.sum(np.abs(proiectii[i] - pr_cautat))

    pozitia = np.argmin(distances)
    return pozitia, distances

pozitia, distances = NN(proiectii, pr_cautat, norma=2)

print("Test image matched with training image index:", pozitia)
print("Distances:", distances)

# ==========================================================
# OPTIONAL VISUAL CHECK
# ==========================================================

plt.figure(figsize=(10, 5))
plt.plot(cautat, label="Centered test image", linewidth=2)
plt.plot(HQPB[:, 0], label="First eigenface")
plt.legend()
plt.grid(True)
plt.show()