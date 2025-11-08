
def implies(p, q):
    return not p or q

def biconditional(p, q):
    return (p and q) or (not p and not q)

def negation(p):
    return not p

def conjunction(p, q):
    return p and q

def disjunction(p, q):
    return p or q

variables = ['A', 'C', 'D']
results = []

for A in [True, False]:
    for C in [True, False]:
        for D in [True, False]:
            C_implies_D = implies(C, D)
            A_or_C = disjunction(A, C)
            A_bi_A_or_C = biconditional(A, A_or_C)
            neg_A = negation(A)
            neg_C_and_D = conjunction(negation(C), D)
            neg_C_and_D_and_A = conjunction(neg_C_and_D, A)
            neg_C_and_D_and_A_and_neg_A = conjunction(neg_C_and_D_and_A, neg_A)

            overall_expression = conjunction(
                implies(C_implies_D, disjunction(neg_A, A_bi_A_or_C)),
                neg_C_and_D_and_A_and_neg_A
            )
            
            results.append((A, C, D, overall_expression))

print(f"{'A':<5} {'C':<5} {'D':<5} {'Result':<7}")
print("-" * 25)
for A, C, D, result in results:
    print(f"{str(A):<5} {str(C):<5} {str(D):<5} {str(result):<7}")
