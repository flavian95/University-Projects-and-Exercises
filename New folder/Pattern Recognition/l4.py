
import statistics
import cv2
import os
import matplotlib as plot
import numpy as np
from matplotlib import pyplot as plt

caleBD=r''
fnrPozePers = 10
nrPozeAntrenare = 8
nrPers = 40
nrPixeli = 10304

poza_test = r's6\9.pgm'
poza_test = cv2.imread(poza_test,0)
poza_test = np.array(poza_test)
poza_test = np.reshape(poza_test,(-1))

norma = input('Introduceti norma: ')

def NN(A, poza_test, norma):
    pozitia=[]
    z = np.zeros(len(A[0]))
    for i in range(0,len(A[0])):
        if(norma=='cos'):
            z[i] = 1-np.dot(A[:,i], poza_test)/(np.linalg.norm(A[:,i])*np.linalg.norm(poza_test))
        elif(norma=='infinit'):
            z[i] = np.linalg.norm(A[:,i]-poza_test, np.inf)
        else:
            p=float(norma)
            z[i]=np.linalg.norm(A[:,i]-poza_test, p)
    pozitia = np.argmin(z)
    return pozitia


def configurreA(caleBD):
    A = np.zeros((nrPixeli, nrPozeAntrenare * nrPers))

    for i in range(1, nrPers +1):
        for j in range(1, nrPozeAntrenare+1):
            calePoza = os.path.join(caleBD, f's{i}', f'{j}.pgm')
            poza = cv2.imread(calePoza, 0)
            pozaVect = np.reshape(poza, (nrPixeli,))
            A[:,(i - 1) * nrPozeAntrenare + (j - 1)] = pozaVect
    print("Matrice A creata cu dimensiunea:",A.shape)
    return A

#K-NN Algorithm

def KNN(A, poza_test,norma,k):
    pozitia=[]
    z = np.zeros(len(A[0]))
    for i in range(0,len(A[0])):
        if(norma=='cos'):
            z[i] = 1-np.dot(A[:,i], poza_test)/(np.linalg.norm(A[:,i])*np.linalg.norm(poza_test))
        elif(norma=='infinit'):
            z[i] = np.linalg.norm(A[:,i]-poza_test, np.inf)
        else:
            p=float(norma)
            z[i]=np.linalg.norm(A[:,i]-poza_test, p)
    index = np.argsort(z)
    index_x = index[:k]        
    class_k = (index_x // 8)+1
    p0 = statistics.mode(index_x)
    return p0

A = configurreA(caleBD)

pozitia = KNN(A, poza_test, norma,4)
persoana = pozitia // nrPozeAntrenare + 1
print('Poz test este de la persoana:',persoana)
print(pozitia)

#Vizualizare perspectiva

pozaGasita = np.reshape(A[:,pozitia],(112,92))
plt.figure(figsize=(8,4))
plt.subplot(1,2,1)
plt.imshow(np.reshape(poza_test,(112,92)),cmap='gray',vmin=0,vmax=225)
plt.title("Imagine test")
plt.axis('off')


plt.subplot(1,2,2)
plt.imshow(pozaGasita,cmap='gray',vmin=0,vmax=255)
plt.title("Imagine recunoscuta(K-NN)")
plt.axis('off')



plt.tight_layout()
plt.show()





# def nn(A, poza_test, norma):
#     pozitia = []
#     z = np.zeros(len(A[0]))
#     for i in range(0, len(A[0])):
#         if norma == 'cos':
#             z[i] = np.dot(A[:, i], poza_test) / (np.linalg.norm(A[:, i]) * np.linalg.norm(poza_test))
#         elif norma == 'infinit':
#             z[i] = np.linalg.norm(A[:, i] - poza_test, np.inf)
#         elif norma == '1':
#             # Manhattan (L1) distance
#             z[i] = np.linalg.norm(A[:, i] - poza_test, 1)
#         elif norma == '2':
#             # Euclidean (L2) distance
#             z[i] = np.linalg.norm(A[:, i] - poza_test, 2)
#         else:
#             p = float(norma)
#             z[i] = np.linalg.norm(A[:, i] - poza_test, p)
#     # print(np.shape(z)) # afiseaza dimensiunea vectorului de distanta
#     # print(z) # afiseaza toate distantele
#     if norma == 'cos':
#         pozitia = np.argmax(z)
#     else:
#         pozitia = np.argmin(z)
#     # print(z[positia]) # afiseaza distanta minima
#     return pozitia