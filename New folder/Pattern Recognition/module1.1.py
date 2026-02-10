


import numpy as np
import cv2
import os
import pandas as pd
from matplotlib import pyplot as plt
import statistics
import time

caleBD = r'C:\Users\OneDrive\Desktop\New folder\3rd Year\Pattern Recognition\ORL'
nrPozePers = 10
nrPozeAntrenare = 8
nrPers = 40
nrPixeli = 10304

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

        poz_demo = func(A, poza_test_demo, norma) if k is None else func(A, poza_test_demo, norma, k)
        persoana_demo = poz_demo // nrPozeAntrenare + 1
        results_demo[norma] = (poz_demo, persoana_demo)

        print(f"\n--- Norma: {norma} ---")
        print(f"Rata recunoaștere: {RR:.2f}%, timp mediu: {timp_mediu:.4f}s")

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
    RR = df['RR'] / 100.0
    times = df['Time']

    plt.figure(figsize=(10, 4))
    
    plt.subplot(1, 2, 1)
    plt.plot(norme, RR, marker='o', linestyle='-', color=colors[0])
    plt.title(f"{title_prefix} - Recognition Rate")
    plt.ylabel("Recognition Rate (0–1)")
    plt.ylim(0, 1)
    
    plt.subplot(1, 2, 2)
    plt.plot(norme, times, marker='o', linestyle='-', color=colors[1])
    plt.title(f"{title_prefix} - Average Query Time (s)")
    plt.ylabel("Average Query Time (s)")
    
    plt.tight_layout()
    plt.show()


A = configurareA(caleBD)
nrPozeTest = nrPozePers - nrPozeAntrenare
total_tests = nrPers * nrPozeTest
k_values = [3, 5, 7, 9, 11]
norme = ['cos', 'infinit', '1', '2']
poza_test_demo = np.reshape(cv2.imread(os.path.join(caleBD, 's1', '8.pgm'), 0), (-1,))

print("\n===== NN =====")
results_NN, stats_NN = test_and_stats(A, nn, norme)

results_KNN = {}
stats_KNN = {}
for k in k_values:
    print(f"\n===== KNN (k={k}) =====")
    results_KNN[k], stats_KNN[k] = test_and_stats(A, knn, norme, k)

plot_results(results_NN, A, poza_test_demo, title_prefix="NN")
for k in k_values:
    plot_results(results_KNN[k], A, poza_test_demo, title_prefix=f"KNN (k={k})")

plot_line_stats_from_csv("stats_NN.csv", "NN", colors=('blue', 'red'))
for k in k_values:
    plot_line_stats_from_csv(f"stats_KNN_k{k}.csv", f"KNN k={k}", colors=('green', 'orange'))