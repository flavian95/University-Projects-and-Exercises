



import numpy as np
import cv2
import os
import pandas as pd
from matplotlib import pyplot as plt
import statistics
import time

# --- PARAMETERS ---
caleBD = r'C:\Users\flavi\OneDrive\Desktop\New folder\3rd Year\Pattern Recognition\ORL'
nrPozePers = 10
nrPozeAntrenare = 8
nrPers = 40
nrPixeli = 10304

# --- FUNCTIONS ---

def nn(A, poza_test, norma):
    z = np.zeros(len(A[0]))
    for i in range(len(A[0])):
        if norma == 'cos':
            z[i] = 1 - np.dot(A[:, i], poza_test) / (np.linalg.norm(A[:, i]) * np.linalg.norm(poza_test))
        elif norma == 'infinit':
            z[i] = np.linalg.norm(A[:, i] - poza_test, np.inf)
        else:
            p = float(norma)
            z[i] = np.linalg.norm(A[:, i] - poza_test, p)
    return np.argmin(z)


def knn(A, poza_test, norma, k):
    z = np.zeros(len(A[0]))
    for i in range(len(A[0])):
        if norma == 'cos':
            z[i] = 1 - np.dot(A[:, i], poza_test) / (np.linalg.norm(A[:, i]) * np.linalg.norm(poza_test))
        elif norma == 'infinit':
            z[i] = np.linalg.norm(A[:, i] - poza_test, np.inf)
        else:
            p = float(norma)
            z[i] = np.linalg.norm(A[:, i] - poza_test, p)

    pozitii = np.argsort(z)[:k]
    persoane = pozitii // nrPozeAntrenare + 1
    persoana = statistics.mode(persoane)
    return (persoana - 1) * nrPozeAntrenare


def configurareA(caleDB):
    A = np.zeros((nrPixeli, nrPozeAntrenare * nrPers))
    for i in range(1, nrPers + 1):
        for j in range(1, nrPozeAntrenare + 1):
            calePoza = os.path.join(caleDB, f's{i}', f'{j}.pgm')
            poza = cv2.imread(calePoza, 0)
            A[:, (i - 1) * nrPozeAntrenare + (j - 1)] = np.reshape(poza, (nrPixeli,))
    print("Matricea A creata cu dimensiunea:", A.shape)
    return A


def test_and_stats(A, func, norme, k=None):
    """
    Computes recognition rates, timing, and demo predictions simultaneously.
    Also writes results to CSV.
    """
    results_demo = {}
    stats = {'Norma': [], 'RR': [], 'Time': []}

    poza_test_demo = np.reshape(cv2.imread(os.path.join(caleBD, 's1', '9.pgm'), 0), (-1,))

    for norma in norme:
        corecte = 0
        timp_total = 0

        for i in range(1, nrPers + 1):
            for j in range(nrPozeAntrenare + 1, nrPozePers + 1):
                calePozaTest = os.path.join(caleBD, f's{i}', f'{j}.pgm')
                poza_test = np.reshape(cv2.imread(calePozaTest, 0), (-1,))

                start = time.time()
                poz = func(A, poza_test, norma) if k is None else func(A, poza_test, norma, k)
                timp_total += time.time() - start
                persoana = poz // nrPozeAntrenare + 1

                if persoana == i:
                    corecte += 1

        RR = corecte / total_tests * 100
        timp_mediu = timp_total / total_tests
        stats['Norma'].append(norma)
        stats['RR'].append(RR)
        stats['Time'].append(timp_mediu)

        # demo image
        poz_demo = func(A, poza_test_demo, norma) if k is None else func(A, poza_test_demo, norma, k)
        persoana_demo = poz_demo // nrPozeAntrenare + 1
        results_demo[norma] = (poz_demo, persoana_demo)

        print(f"\n--- Norma: {norma} ---")
        print(f"Rata recunoaștere: {RR:.2f}%, timp mediu: {timp_mediu:.4f}s")

    # --- Save to CSV ---
    if k is None:
        csv_name = "stats_NN.csv"
    else:
        csv_name = f"stats_KNN_k{k}.csv"

    df = pd.DataFrame(stats)
    df.to_csv(csv_name, index=False)
    print(f"Rezultatele salvate în {csv_name}")

    return results_demo, stats


def plot_results(results, A, poza_test_demo, title_prefix="NN"):
    num_cols = len(results) + 1
    plt.figure(figsize=(3 * num_cols, 4))
    plt.subplot(1, num_cols, 1)
    plt.imshow(np.reshape(poza_test_demo, (112, 92)), cmap='gray')
    plt.title("Imagine test")
    plt.axis('off')

    for idx, (norma, (poz, pers)) in enumerate(results.items()):
        plt.subplot(1, num_cols, idx + 2)
        plt.imshow(np.reshape(A[:, poz], (112, 92)), cmap='gray')
        plt.title(f"{title_prefix} - {norma}\nP.{pers}")
        plt.axis('off')

    plt.suptitle(f"{title_prefix} pentru diferite norme")
    plt.tight_layout()
    plt.show()

def plot_line_stats_from_csv(csv_path, title_prefix, colors=('blue', 'red')):
    df = pd.read_csv(csv_path)
    norme = df['Norma']
    RR = df['RR'] / 100.0  # Convert from percentage to fraction (e.g., 92 → 0.92)
    times = df['Time']

    plt.figure(figsize=(10, 4))
    
    # Recognition Rate plot (0–1 range)
    plt.subplot(1, 2, 1)
    plt.plot(norme, RR, marker='o', linestyle='-', color=colors[0])
    plt.title(f"{title_prefix} - Recognition Rate")
    plt.ylabel("Recognition Rate (0–1)")
    plt.ylim(0, 1)
    
    # Average Query Time plot
    plt.subplot(1, 2, 2)
    plt.plot(norme, times, marker='o', linestyle='-', color=colors[1])
    plt.title(f"{title_prefix} - Average Query Time (s)")
    plt.ylabel("Average Query Time (s)")
    
    plt.tight_layout()
    plt.show()


# --- LOAD DATABASE ---
A = configurareA(caleBD)
nrPozeTest = nrPozePers - nrPozeAntrenare
total_tests = nrPers * nrPozeTest
k_values = [3, 5, 7, 9, 11]
norme = ['cos', 'infinit', '1', '2']
poza_test_demo = np.reshape(cv2.imread(os.path.join(caleBD, 's1', '8.pgm'), 0), (-1,))

# --- NN ---
print("\n===== NN =====")
results_NN, stats_NN = test_and_stats(A, nn, norme)

# --- KNN ---
results_KNN = {}
stats_KNN = {}
for k in k_values:
    print(f"\n===== KNN (k={k}) =====")
    results_KNN[k], stats_KNN[k] = test_and_stats(A, knn, norme, k)

# --- VISUALIZATION ---
plot_results(results_NN, A, poza_test_demo, title_prefix="NN")
for k in k_values:
    plot_results(results_KNN[k], A, poza_test_demo, title_prefix=f"KNN (k={k})")

# --- LINE PLOTS FROM CSV ---
plot_line_stats_from_csv("stats_NN.csv", "NN", colors=('blue', 'red'))
for k in k_values:
    plot_line_stats_from_csv(f"stats_KNN_k{k}.csv", f"KNN k={k}", colors=('green', 'orange'))










# import numpy as np
# import cv2
# import os
# from matplotlib import pyplot as plt
# import statistics
# import time

# # --- PARAMETERS ---
# caleBD = r'C:\Users\flavi\OneDrive\Desktop\New folder\3rd Year\Pattern Recognition\ORL'
# nrPozePers = 10
# nrPozeAntrenare = 8
# nrPers = 40
# nrPixeli = 10304

# # --- FUNCTIONS ---

# def nn(A, poza_test, norma):
#     z = np.zeros(len(A[0]))
#     for i in range(len(A[0])):
#         if norma == 'cos':
#             z[i] = 1 - np.dot(A[:, i], poza_test) / (np.linalg.norm(A[:, i]) * np.linalg.norm(poza_test))
#         elif norma == 'infinit':
#             z[i] = np.linalg.norm(A[:, i] - poza_test, np.inf)
#         else:
#             p = float(norma)
#             z[i] = np.linalg.norm(A[:, i] - poza_test, p)
#     return np.argmin(z)

# def knn(A, poza_test, norma, k):
#     z = np.zeros(len(A[0]))
#     for i in range(len(A[0])):
#         if norma == 'cos':
#             z[i] = 1 - np.dot(A[:, i], poza_test) / (np.linalg.norm(A[:, i]) * np.linalg.norm(poza_test))
#         elif norma == 'infinit':
#             z[i] = np.linalg.norm(A[:, i] - poza_test, np.inf)
#         else:
#             p = float(norma)
#             z[i] = np.linalg.norm(A[:, i] - poza_test, p)

#     pozitii = np.argsort(z)[:k]
#     persoane = pozitii // nrPozeAntrenare + 1
#     persoana = statistics.mode(persoane)
#     return (persoana - 1) * nrPozeAntrenare

# def configurareA(caleDB):
#     A = np.zeros((nrPixeli, nrPozeAntrenare * nrPers))
#     for i in range(1, nrPers + 1):
#         for j in range(1, nrPozeAntrenare + 1):
#             calePoza = os.path.join(caleDB, f's{i}', f'{j}.pgm')
#             poza = cv2.imread(calePoza, 0)
#             A[:, (i - 1) * nrPozeAntrenare + (j - 1)] = np.reshape(poza, (nrPixeli,))
#     print("Matricea A creata cu dimensiunea:", A.shape)
#     return A

# def test_and_stats(A, func, norme, k=None):
#     """
#     Computes recognition rates, timing, and demo predictions simultaneously.
#     Returns:
#         results_demo: dict for demo image predictions
#         stats: dict with 'RR' and 'time' for line plots
#     """
#     results_demo = {}
#     stats = {'RR': [], 'time': []}
#     poza_test_demo = np.reshape(cv2.imread(os.path.join(caleBD, 's1', '8.pgm'), 0), (-1,))

#     for norma in norme:
#         corecte = 0
#         timp_total = 0

#         for i in range(1, nrPers + 1):
#             for j in range(nrPozeAntrenare + 1, nrPozePers + 1):
#                 calePozaTest = os.path.join(caleBD, f's{i}', f'{j}.pgm')
#                 poza_test = np.reshape(cv2.imread(calePozaTest, 0), (-1,))

#                 start = time.time()
#                 poz = func(A, poza_test, norma) if k is None else func(A, poza_test, norma, k)
#                 timp_total += time.time() - start
#                 persoana = poz // nrPozeAntrenare + 1

#                 if persoana == i:
#                     corecte += 1

#         RR = corecte / total_tests * 100
#         timp_mediu = timp_total / total_tests
#         stats['RR'].append(RR)
#         stats['time'].append(timp_mediu)

#         # demo image
#         poz_demo = func(A, poza_test_demo, norma) if k is None else func(A, poza_test_demo, norma, k)
#         persoana_demo = poz_demo // nrPozeAntrenare + 1
#         results_demo[norma] = (poz_demo, persoana_demo)

#         print(f"\n--- Norma: {norma} ---")
#         print(f"Rata recunoaștere: {RR:.2f}%, timp mediu: {timp_mediu:.4f}s")

#     return results_demo, stats

# def plot_results(results, A, poza_test_demo, title_prefix="NN"):
#     num_cols = len(results) + 1
#     plt.figure(figsize=(3 * num_cols, 4))
#     plt.subplot(1, num_cols, 1)
#     plt.imshow(np.reshape(poza_test_demo, (112, 92)), cmap='gray')
#     plt.title("Imagine test")
#     plt.axis('off')

#     for idx, (norma, (poz, pers)) in enumerate(results.items()):
#         plt.subplot(1, num_cols, idx + 2)
#         plt.imshow(np.reshape(A[:, poz], (112, 92)), cmap='gray')
#         plt.title(f"{title_prefix} - {norma}\nP.{pers}")
#         plt.axis('off')

#     plt.suptitle(f"{title_prefix} pentru diferite norme")
#     plt.tight_layout()
#     plt.show()

# def plot_line_stats(stats, norme, title_prefix, colors):
#     plt.figure(figsize=(10,4))
#     plt.subplot(1,2,1)
#     plt.plot(norme, stats['RR'], marker='o', linestyle='-', color=colors[0])
#     plt.title(f"{title_prefix} - Recognition Rate (%)")
#     plt.ylabel("Recognition Rate (%)")
#     plt.subplot(1,2,2)
#     plt.plot(norme, stats['time'], marker='o', linestyle='-', color=colors[1])
#     plt.title(f"{title_prefix} - Average Query Time (s)")
#     plt.ylabel("Average Query Time (s)")
#     plt.tight_layout()
#     plt.show()


# # --- LOAD DATABASE ---
# A = configurareA(caleBD)
# nrPozeTest = nrPozePers - nrPozeAntrenare
# total_tests = nrPers * nrPozeTest
# k_values = [3, 5, 7, 9, 11]
# norme = ['cos', 'infinit', '1', '2']
# poza_test_demo = np.reshape(cv2.imread(os.path.join(caleBD, 's1', '8.pgm'), 0), (-1,))

# # --- NN ---
# print("\n===== NN =====")
# results_NN, stats_NN = test_and_stats(A, nn, norme)

# # --- KNN ---
# results_KNN = {}
# stats_KNN = {}
# for k in k_values:
#     print(f"\n===== KNN (k={k}) =====")
#     results_KNN[k], stats_KNN[k] = test_and_stats(A, knn, norme, k)

# # --- VISUALIZATION ---
# plot_results(results_NN, A, poza_test_demo, title_prefix="NN")
# for k in k_values:
#     plot_results(results_KNN[k], A, poza_test_demo, title_prefix=f"KNN (k={k})")

# # --- LINE PLOTS ---
# plot_line_stats(stats_NN, norme, "NN", colors=('blue','red'))
# for k in k_values:
#     plot_line_stats(stats_KNN[k], norme, f"KNN k={k}", colors=('green','orange'))





























# import numpy as np
# import cv2
# import os
# from matplotlib import pyplot as plt
# import statistics
# import time

# # --- PARAMETERS ---
# caleBD = r'C:\Users\flavi\OneDrive\Desktop\New folder\3rd Year\Pattern Recognition\ORL'
# nrPozePers = 10
# nrPozeAntrenare = 8
# nrPers = 40
# nrPixeli = 10304

# # --- FUNCTIONS ---

# def nn(A, poza_test, norma):
#     z = np.zeros(len(A[0]))
#     for i in range(len(A[0])):
#         if norma == 'cos':
#             z[i] = 1 - np.dot(A[:, i], poza_test) / (np.linalg.norm(A[:, i]) * np.linalg.norm(poza_test))
#         elif norma == 'infinit':
#             z[i] = np.linalg.norm(A[:, i] - poza_test, np.inf)
#         else:
#             p = float(norma)
#             z[i] = np.linalg.norm(A[:, i] - poza_test, p)
#     return np.argmin(z)

# def knn(A, poza_test, norma, k):
#     z = np.zeros(len(A[0]))
#     for i in range(len(A[0])):
#         if norma == 'cos':
#             z[i] = 1 - np.dot(A[:, i], poza_test) / (np.linalg.norm(A[:, i]) * np.linalg.norm(poza_test))
#         elif norma == 'infinit':
#             z[i] = np.linalg.norm(A[:, i] - poza_test, np.inf)
#         else:
#             p = float(norma)
#             z[i] = np.linalg.norm(A[:, i] - poza_test, p)

#     pozitii = np.argsort(z)[:k]
#     persoane = pozitii // nrPozeAntrenare + 1
#     persoana = statistics.mode(persoane)
#     return (persoana - 1) * nrPozeAntrenare

# def configurareA(caleDB):
#     A = np.zeros((nrPixeli, nrPozeAntrenare * nrPers))
#     for i in range(1, nrPers + 1):
#         for j in range(1, nrPozeAntrenare + 1):
#             calePoza = os.path.join(caleDB, f's{i}', f'{j}.pgm')
#             poza = cv2.imread(calePoza, 0)
#             A[:, (i - 1) * nrPozeAntrenare + (j - 1)] = np.reshape(poza, (nrPixeli,))
#     print("Matricea A creata cu dimensiunea:", A.shape)
#     return A

# # --- LOAD DATABASE ---
# A = configurareA(caleBD)
# nrPozeTest = nrPozePers - nrPozeAntrenare
# total_tests = nrPers * nrPozeTest
# k_values = [3, 5, 7, 9, 11]
# norme = ['cos', 'infinit', '1', '2']

# results = {"NN": {}, "KNN": {k: {} for k in k_values}}
# poza_test_demo = np.reshape(cv2.imread(os.path.join(caleBD, 's1', '8.pgm'), 0), (-1,))

# # --- NN ---
# print("\n===== NN =====")
# for norma in norme:
#     print(f"\n--- Norma: {norma} ---")
#     corecte_nn = 0
#     timp_total_nn = 0

#     for i in range(1, nrPers + 1):
#         for j in range(nrPozeAntrenare + 1, nrPozePers + 1):
#             calePozaTest = os.path.join(caleBD, f's{i}', f'{j}.pgm')
#             poza_test = np.reshape(cv2.imread(calePozaTest, 0), (-1,))

#             start = time.time()
#             pozitia_nn = nn(A, poza_test, norma)
#             timp_total_nn += time.time() - start
#             persoana_nn = pozitia_nn // nrPozeAntrenare + 1

#             if persoana_nn == i:
#                 corecte_nn += 1

#     RR_nn = corecte_nn / total_tests * 100
#     timp_mediu_nn = timp_total_nn / total_tests
#     print(f"Rata recunoaștere: {RR_nn:.2f}%, timp mediu: {timp_mediu_nn:.4f}s")

#     pozitia_nn_demo = nn(A, poza_test_demo, norma)
#     persoana_nn_demo = pozitia_nn_demo // nrPozeAntrenare + 1
#     results["NN"][norma] = (pozitia_nn_demo, persoana_nn_demo)


# # --- KNN ---
# for k in k_values:
#     print(f"\n===== KNN (k={k}) =====")
#     for norma in norme:
#         print(f"\n--- Norma: {norma} ---")
#         corecte_knn = 0
#         timp_total_knn = 0

#         for i in range(1, nrPers + 1):
#             for j in range(nrPozeAntrenare + 1, nrPozePers + 1):
#                 calePozaTest = os.path.join(caleBD, f's{i}', f'{j}.pgm')
#                 poza_test = np.reshape(cv2.imread(calePozaTest, 0), (-1,))

#                 start = time.time()
#                 pozitia_knn = knn(A, poza_test, norma, k)
#                 timp_total_knn += time.time() - start
#                 persoana_knn = pozitia_knn // nrPozeAntrenare + 1

#                 if persoana_knn == i:
#                     corecte_knn += 1

#         RR_knn = corecte_knn / total_tests * 100
#         timp_mediu_knn = timp_total_knn / total_tests
#         print(f"Rata recunoaștere: {RR_knn:.2f}%, timp mediu: {timp_mediu_knn:.4f}s")

#         pozitia_knn_demo = knn(A, poza_test_demo, norma, k)
#         persoana_knn_demo = pozitia_knn_demo // nrPozeAntrenare + 1
#         results["KNN"][k][norma] = (pozitia_knn_demo, persoana_knn_demo)


# # --- VISUALIZATION ---
# print("\n=== Vizualizare rezultate după tipul clasificatorului ===")

# # NN visualization
# num_cols = len(norme) + 1
# plt.figure(figsize=(3 * num_cols, 4))
# plt.subplot(1, num_cols, 1)
# plt.imshow(np.reshape(poza_test_demo, (112, 92)), cmap='gray')
# plt.title("Imagine test")
# plt.axis('off')

# for idx, norma in enumerate(norme):
#     poz, pers = results["NN"][norma]
#     plt.subplot(1, num_cols, idx + 2)
#     plt.imshow(np.reshape(A[:, poz], (112, 92)), cmap='gray')
#     plt.title(f"NN - {norma}\nP.{pers}")
#     plt.axis('off')

# plt.suptitle("NN pentru diferite norme")
# plt.tight_layout()
# plt.show()

# # KNN visualization
# for k in k_values:
#     num_cols = len(norme) + 1
#     plt.figure(figsize=(3 * num_cols, 4))
#     plt.subplot(1, num_cols, 1)
#     plt.imshow(np.reshape(poza_test_demo, (112, 92)), cmap='gray')
#     plt.title("Imagine test")
#     plt.axis('off')

#     for idx, norma in enumerate(norme):
#         poz, pers = results["KNN"][k][norma]
#         plt.subplot(1, num_cols, idx + 2)
#         plt.imshow(np.reshape(A[:, poz], (112, 92)), cmap='gray')
#         # plt.title(f"KNN k={k}\n{norma} → P.{pers}")
#         plt.axis('off')

#     plt.suptitle(f"KNN (k={k}) pentru diferite norme")
#     plt.tight_layout()
#     plt.show()

# # --- NN statistics (line plots) ---
# RR_nn_list = []
# time_nn_list = []

# for norma in norme:
#     corecte_nn = 0
#     timp_total_nn = 0

#     for i in range(1, nrPers + 1):
#         for j in range(nrPozeAntrenare + 1, nrPozePers + 1):
#             calePozaTest = os.path.join(caleBD, f's{i}', f'{j}.pgm')
#             poza_test = np.reshape(cv2.imread(calePozaTest, 0), (-1,))

#             start = time.time()
#             pozitia_nn = nn(A, poza_test, norma)
#             timp_total_nn += time.time() - start
#             persoana_nn = pozitia_nn // nrPozeAntrenare + 1

#             if persoana_nn == i:
#                 corecte_nn += 1

#     RR_nn_list.append(corecte_nn / total_tests * 100)
#     time_nn_list.append(timp_total_nn / total_tests)

# # Plot NN line plots
# plt.figure(figsize=(10,4))
# plt.subplot(1,2,1)
# plt.plot(norme, RR_nn_list, marker='o', linestyle='-', color='blue')
# plt.title("NN - Recognition Rate (%)")
# plt.ylabel("Recognition Rate (%)")
# plt.subplot(1,2,2)
# plt.plot(norme, time_nn_list, marker='o', linestyle='-', color='red')
# plt.title("NN - Average Query Time (s)")
# plt.ylabel("Average Query Time (s)")
# plt.tight_layout()
# plt.show()


# # --- KNN statistics (line plots) ---
# for k in k_values:
#     RR_knn_list = []
#     time_knn_list = []

#     for norma in norme:
#         corecte_knn = 0
#         timp_total_knn = 0

#         for i in range(1, nrPers + 1):
#             for j in range(nrPozeAntrenare + 1, nrPozePers + 1):
#                 calePozaTest = os.path.join(caleBD, f's{i}', f'{j}.pgm')
#                 poza_test = np.reshape(cv2.imread(calePozaTest, 0), (-1,))

#                 start = time.time()
#                 pozitia_knn = knn(A, poza_test, norma, k)
#                 timp_total_knn += time.time() - start
#                 persoana_knn = pozitia_knn // nrPozeAntrenare + 1

#                 if persoana_knn == i:
#                     corecte_knn += 1

#         RR_knn_list.append(corecte_knn / total_tests * 100)
#         time_knn_list.append(timp_total_knn / total_tests)

#     # Plot KNN line plots for this k
#     plt.figure(figsize=(10,4))
#     plt.subplot(1,2,1)
#     plt.plot(norme, RR_knn_list, marker='o', linestyle='-', color='green')
#     plt.title(f"KNN k={k} - Recognition Rate (%)")
#     plt.ylabel("Recognition Rate (%)")
#     plt.subplot(1,2,2)
#     plt.plot(norme, time_knn_list, marker='o', linestyle='-', color='orange')
#     plt.title(f"KNN k={k} - Average Query Time (s)")
#     plt.ylabel("Average Query Time (s)")
#     plt.tight_layout()
#     plt.show()





































# # --- MAIN LOOP ---
# results = {}
# poza_test_demo = os.path.join(caleBD, 's1', '8.pgm')
# poza_test_demo = np.reshape(cv2.imread(poza_test_demo, 0), (-1,))

# for norma in norme:
#     print(f"\n===== NORMA: {norma} =====")
#     corecte_nn = 0
#     timp_total_nn = 0

#     # --- NN recognition loop ---
#     for i in range(1, nrPers + 1):
#         for j in range(nrPozeAntrenare + 1, nrPozePers + 1):
#             calePozaTest = os.path.join(caleBD, f's{i}', f'{j}.pgm')
#             poza_test = np.reshape(cv2.imread(calePozaTest, 0), (-1,))

#             start = time.time()
#             pozitia_nn = nn(A, poza_test, norma)
#             timp_total_nn += (time.time() - start)
#             persoana_nn = pozitia_nn // nrPozeAntrenare + 1

#             if persoana_nn == i:
#                 corecte_nn += 1

#     RR_nn = corecte_nn / total_tests * 100
#     timp_mediu_nn = timp_total_nn / total_tests
#     print(f"NN -> Rata recunoaștere: {RR_nn:.2f}%, timp mediu: {timp_mediu_nn:.4f}s")

#     # --- KNN ---
#     rr_knn = {}
#     for k in k_values:
#         corecte_knn = 0
#         timp_total_knn = 0

#         for i in range(1, nrPers + 1):
#             for j in range(nrPozeAntrenare + 1, nrPozePers + 1):
#                 calePozaTest = os.path.join(caleBD, f's{i}', f'{j}.pgm')
#                 poza_test = np.reshape(cv2.imread(calePozaTest, 0), (-1,))

#                 start = time.time()
#                 pozitia_knn = knn(A, poza_test, norma, k)
#                 timp_total_knn += (time.time() - start)
#                 persoana_knn = pozitia_knn // nrPozeAntrenare + 1

#                 if persoana_knn == i:
#                     corecte_knn += 1

#         RR_knn = corecte_knn / total_tests * 100
#         timp_mediu_knn = timp_total_knn / total_tests
#         rr_knn[k] = (RR_knn, timp_mediu_knn)
#         print(f"KNN (k={k}) -> Rata recunoaștere: {RR_knn:.2f}%, timp mediu: {timp_mediu_knn:.4f}s")

#     # --- Save results for visualization ---
#     pozitia_nn_demo = nn(A, poza_test_demo, norma)
#     persoana_nn_demo = pozitia_nn_demo // nrPozeAntrenare + 1

#     rezultate_knn_demo = {}
#     for k in k_values:
#         pozitia_knn_demo = knn(A, poza_test_demo, norma, k)
#         persoana_knn_demo = pozitia_knn_demo // nrPozeAntrenare + 1
#         rezultate_knn_demo[k] = (pozitia_knn_demo, persoana_knn_demo)

#     results[norma] = {
#         "NN": (pozitia_nn_demo, persoana_nn_demo),
#         "KNN": rezultate_knn_demo
#     }

# # --- VISUALIZATION ---
# for norma in norme:
#     print(f"\n=== Vizualizare rezultate pentru norma: {norma} ===")
#     k_values = [3, 5, 7, 9, 11]
#     num_cols = len(k_values) + 2
#     plt.figure(figsize=(3 * num_cols, 4))

#     # Imagine test
#     plt.subplot(1, num_cols, 1)
#     plt.imshow(np.reshape(poza_test_demo, (112, 92)), cmap='gray', vmin=0, vmax=255)
#     plt.title("Imagine test")
#     plt.axis('off')

#     # NN
#     poz_nn, pers_nn = results[norma]["NN"]
#     plt.subplot(1, num_cols, 2)
#     plt.imshow(np.reshape(A[:, poz_nn], (112, 92)), cmap='gray', vmin=0, vmax=255)
#     plt.title(f"NN → Pers. {pers_nn}")
#     plt.axis('off')

#     # KNN
#     for idx, k in enumerate(k_values):
#         poz_knn, pers_knn = results[norma]["KNN"][k]
#         plt.subplot(1, num_cols, idx + 3)
#         plt.imshow(np.reshape(A[:, poz_knn], (112, 92)), cmap='gray', vmin=0, vmax=255)
#         plt.title(f"KNN(k={k}) → P.{pers_knn}")
#         plt.axis('off')

#     plt.suptitle(f"Norma: {norma}", fontsize=14)
#     plt.tight_layout()
#     plt.show()










# import numpy as np
# import cv2
# import os
# from matplotlib import pyplot as plt
# import statistics
# import time

# caleBD = r'C:\Users\flavi\OneDrive\Desktop\New folder\3rd Year\Pattern Recognition\ORL'
# nrPozePers = 10
# nrPozeAntrenare = 8
# nrPers = 40  # nr. foldere din BD
# nrPixeli = 10304  # daca rezolutia este 112 x 92

# poza_test = r'C:\Users\flavi\OneDrive\Desktop\New folder\3rd Year\Pattern Recognition\ORL\s1\8.pgm'  # hard-coded sau citit cu input()
# poza_test = cv2.imread(poza_test, 0)
# # plt.imshow(poza_test, cmap='gray', vmin=0, vmax=255)
# # plt.show()

# poza_test = np.array(poza_test)
# poza_test = np.reshape(poza_test, (-1,))  # vectorizata (dim. 10304)

# norma = input("Introduceti norma: ")  # hard-coded sau input()

# def nn(A, poza_test, norma):
#     pozitia = []
#     z = np.zeros(len(A[0]))
#     for i in range(0, len(A[0])):
#         if norma == 'cos':
#             z[i] = 1- np.dot(A[:, i], poza_test) / (np.linalg.norm(A[:, i]) * np.linalg.norm(poza_test))
#         elif norma == 'infinit':
#             z[i] = np.linalg.norm(A[:, i] - poza_test, np.inf)
#         # elif norma == '1':
#         #     # Manhattan (L1) distance
#         #     z[i] = np.linalg.norm(A[:, i] - poza_test, 1)
#         # elif norma == '2':
#         #     # Euclidean (L2) distance
#         #     z[i] = np.linalg.norm(A[:, i] - poza_test, 2)
#         else:
#             p = float(norma)
#             z[i] = np.linalg.norm(A[:, i] - poza_test, p)
#     # print(np.shape(z)) # afiseaza dimensiunea vectorului de distanta
#     # print(z) # afiseaza toate distantele
#     pozitia = np.argmin(z)
#     # print(z[positia]) # afiseaza distanta minima
#     return pozitia

# def knn(A, poza_test, norma):
#     pozitia = []
#     z = np.zeros(len(A[0]))
#     for i in range(0, len(A[0])):
#         if norma == 'cos':
#             z[i] = 1- np.dot(A[:, i], poza_test) / (np.linalg.norm(A[:, i]) * np.linalg.norm(poza_test))
#         elif norma == 'infinit':
#             z[i] = np.linalg.norm(A[:, i] - poza_test, np.inf)
#         # elif norma == '1':
#         #     # Manhattan (L1) distance
#         #     z[i] = np.linalg.norm(A[:, i] - poza_test, 1)
#         # elif norma == '2':
#         #     # Euclidean (L2) distance
#         #     z[i] = np.linalg.norm(A[:, i] - poza_test, 2)
#         else:
#             p = float(norma)
#             z[i] = np.linalg.norm(A[:, i] - poza_test, p)
#     # print(np.shape(z)) # afiseaza dimensiunea vectorului de distanta
#     # print(z) # afiseaza toate distantele

#     pozitii = np.argsort(z)
#     pozitii = pozitii[:k]
#     persoane = pozitii//8 + 1
#     persoana = statistics.mode(persoane)
#     return ( persoana - 1) * 8

#     # print(z[positia]) # afiseaza distanta minima
#     # return pozitia


# def configurareA(caleDB):
#     A= np.zeros((nrPixeli, nrPozeAntrenare * nrPers))

#     for i in range(1, nrPers + 1):
#         for j in range(1, nrPozeAntrenare + 1):
#             calePoza = os.path.join(caleDB, f's{i}' , f'{j}.pgm')
#             poza = cv2. imread(calePoza, 0) #grayscale
#             pozaVect = np.reshape(poza, (nrPixeli,))
#             A[:, (i - 1) * nrPozeAntrenare + (j - 1)] = pozaVect
#         # print(f"Persoana {i} incarcata")  
#     print("Matricea A a creata cu dimensiunea: ", A.shape)     
#     return A
    
# A = configurareA(caleBD) 

# nrPozeTest = nrPozePers - nrPozeAntrenare
# total_tests = nrPers * nrPozeTest

# # --- NN statistics ---
# corecte_nn = 0
# timp_total_nn = 0

# for i in range(1, nrPers + 1):  # each person
#     for j in range(nrPozeAntrenare + 1, nrPozePers + 1):  # test images
#         calePozaTest = os.path.join(caleBD, f's{i}', f'{j}.pgm')
#         poza_test = cv2.imread(calePozaTest, 0)
#         poza_test = np.reshape(poza_test, (-1,))

#         # --- NN ---
#         start = time.time()
#         pozitia_nn = nn(A, poza_test, norma)
#         timp_total_nn += (time.time() - start)
#         persoana_nn = pozitia_nn // nrPozeAntrenare + 1

#         if persoana_nn == i:
#             corecte_nn += 1

# RR_nn = corecte_nn / total_tests * 100
# timp_mediu_nn = timp_total_nn / total_tests

# print(f"\nNN -> Rata de recunoaștere: {RR_nn:.2f}%")
# print(f"NN -> Timp mediu de interogare: {timp_mediu_nn:.4f} secunde")

# # --- KNN statistics for multiple k ---
# k_values = [3, 5, 7, 9, 11]
# for k in k_values:
#     corecte_knn = 0
#     timp_total_knn = 0

#     for i in range(1, nrPers + 1):
#         for j in range(nrPozeAntrenare + 1, nrPozePers + 1):
#             calePozaTest = os.path.join(caleBD, f's{i}', f'{j}.pgm')
#             poza_test = cv2.imread(calePozaTest, 0)
#             poza_test = np.reshape(poza_test, (-1,))

#             start = time.time()
#             pozitia_knn = knn(A, poza_test, norma)
#             timp_total_knn += (time.time() - start)
#             persoana_knn = pozitia_knn // nrPozeAntrenare + 1

#             if persoana_knn == i:
#                 corecte_knn += 1

#     RR_knn = corecte_knn / total_tests * 100
#     timp_mediu_knn = timp_total_knn / total_tests

#     print(f"KNN (k={k}) -> Rata de recunoaștere: {RR_knn:.2f}%")
#     print(f"KNN (k={k}) -> Timp mediu de interogare: {timp_mediu_knn:.4f} secunde")

# # --- Run NN on a single test image ---
# pozitia_nn = nn(A, poza_test, norma)
# persoana_nn = pozitia_nn // nrPozeAntrenare + 1
# print('Rezultat NN -> Poza test este de la persoana:', persoana_nn)

# # --- Run KNN for all k values and store results ---
# k_values = [3, 5, 7, 9, 11]
# rezultate_knn = {}

# for k in k_values:
#     pozitia_knn = knn(A, poza_test, norma)
#     persoana_knn = pozitia_knn // nrPozeAntrenare + 1
#     rezultate_knn[k] = {
#         "pozitia": pozitia_knn,
#         "persoana": persoana_knn
#     }
#     print(f'Rezultat KNN (k={k}) -> Poza test este de la persoana: {persoana_knn}')

# # --- Visualization ---
# num_cols = len(k_values) + 2  # test + NN + all KNNs
# plt.figure(figsize=(3*num_cols, 4))

# # Imaginea test
# plt.subplot(1, num_cols, 1)
# plt.imshow(np.reshape(poza_test, (112, 92)), cmap='gray', vmin=0, vmax=255)
# plt.title("Imagine test")
# plt.axis('off')

# # NN result
# pozaGasita_nn = np.reshape(A[:, pozitia_nn], (112, 92))
# plt.subplot(1, num_cols, 2)
# plt.imshow(pozaGasita_nn, cmap='gray', vmin=0, vmax=255)
# plt.title(f"NN → Persoana {persoana_nn}")
# plt.axis('off')

# # KNN results
# for idx, k in enumerate(k_values):
#     pozitia_knn = rezultate_knn[k]["pozitia"]
#     persoana_knn = rezultate_knn[k]["persoana"]
#     pozaGasita_knn = np.reshape(A[:, pozitia_knn], (112, 92))

#     plt.subplot(1, num_cols, idx + 3)
#     plt.imshow(pozaGasita_knn, cmap='gray', vmin=0, vmax=255)
#     plt.title(f"KNN (k={k}) → Pers. {persoana_knn}")
#     plt.axis('off')

# plt.tight_layout()
# plt.show()













# # Run NN
# pozitia_nn = nn(A, poza_test, norma)
# persoana_nn = pozitia_nn // nrPozeAntrenare + 1
# print('Rezultat NN -> Poza test este de la persoana:', persoana_nn)

# # Run KNN
# pozitia_knn = knn(A, poza_test, norma)
# persoana_knn = pozitia_knn // nrPozeAntrenare + 1
# print('Rezultat KNN (k =', k, ') -> Poza test este de la persoana:', persoana_knn)

# # Visualization
# pozaGasita_nn = np.reshape(A[:, pozitia_nn], (112, 92))
# pozaGasita_knn = np.reshape(A[:, pozitia_knn], (112, 92))

# plt.figure(figsize=(12, 4))

# plt.subplot(1, 3, 1)
# plt.imshow(np.reshape(poza_test, (112, 92)), cmap='gray', vmin=0, vmax=255)
# plt.title("Imagine test")
# plt.axis('off')

# plt.subplot(1, 3, 2)
# plt.imshow(pozaGasita_nn, cmap='gray', vmin=0, vmax=255)
# plt.title(f"NN → Persoana {persoana_nn}")
# plt.axis('off')

# plt.subplot(1, 3, 3)
# plt.imshow(pozaGasita_knn, cmap='gray', vmin=0, vmax=255)
# plt.title(f"KNN (k={k}) → Persoana {persoana_knn}")
# plt.axis('off')

# plt.tight_layout()
# plt.show()














































# pozitia = nn(A, poza_test, norma)
# persoana = pozitia // nrPozeAntrenare + 1 # +1 pt ca incepem de la persoana 1
# print('Poza test este de la persoana: ', persoana)
# print(pozitia)


# #Vizualizare comparativa

# pozaGasita = np.reshape(A[:, pozitia], (112, 92))

# plt.figure(figsize=(8, 4))

# plt.subplot(1, 2, 1)
# plt.imshow(np.reshape(poza_test, (112, 92)), cmap='gray', vmin=0, vmax= 255)
# plt.title("Imagine test")
# plt.axis('off')

# plt.subplot(1, 2, 2)
# plt.imshow(pozaGasita, cmap='gray', vmin=0, vmax = 255)
# plt.title("Imagine recunoscuta (NN)")
# plt.axis('off')

# plt.tight_layout()
# plt.show()


























# poza_test_112_92 = np.reshape(poza_test, (112, 92))  # OK
# poza_test_92_112 = np.reshape(poza_test, (92, 112))  # Blurred
# poza_test_56_184 = np.reshape(poza_test, (56, 184))  # Double image
# poza_test_184_56 = np.reshape(poza_test, (184, 56))  # Blurred, longer in length
# poza_test_28_368 = np.reshape(poza_test, (28, 368))  # 4 images

# plt.figure(figsize=(12, 8))

# plt.subplot(2, 3, 1)
# plt.imshow(poza_test_112_92, cmap='gray', vmin=0, vmax=255)
# plt.title("112 x 92")
# plt.axis('off')

# plt.subplot(2, 3, 2)
# plt.imshow(poza_test_92_112, cmap='gray', vmin=0, vmax=255)
# plt.title("92 x 112")
# plt.axis('off')

# plt.subplot(2, 3, 3)
# plt.imshow(poza_test_56_184, cmap='gray', vmin=0, vmax=255)
# plt.title("56 x 184")
# plt.axis('off')

# plt.subplot(2, 3, 4)
# plt.imshow(poza_test_184_56, cmap='gray', vmin=0, vmax=255)
# plt.title("184 x 56")
# plt.axis('off')

# plt.subplot(2, 3, 5)
# plt.imshow(poza_test_28_368, cmap='gray', vmin=0, vmax=255)
# plt.title("28 x 368")
# plt.axis('off')

# plt.tight_layout()
# plt.show()