import itertools

def implies(p, q):
    return not p or q

def neg(p):
    return not p

def disjunction(p, q):
    return p or q

def conjunction(p, q):
    return p and q

def xor(p, q):
    return p != q

def formula(A, C, D):
    part1 = implies(implies(C, D), disjunction(neg(A), xor(A, disjunction(A, C))))
    
    part2 = conjunction(conjunction(conjunction(neg(C), D), A), neg(A))
    
    return conjunction(part1, part2)

def generate_truth_table():
    print("A | C | D | Formula")
    print("-" * 25)
    
    for A, C, D in itertools.product([False, True], repeat=3):
        result = formula(A, C, D)
        print(f"{int(A)} | {int(C)} | {int(D)} | {int(result)}")

def count_sub_formulas():
    sub_formulas = [
        "C", "D", "C → D", "A", "¬A", "A ∨ C", "A ∼ (A ∨ C)", 
        "¬A ∨ (A ∼ (A ∨ C))", "(C → D) → (¬A ∨ (A ∼ (A ∨ C)))",
        "¬C", "¬C & D", "(¬C & D) & A", "¬A", "((¬C & D) & A) & ¬A",
        "(((C → D) → (¬A ∨ (A ∼ (A ∨ C)))) & (((¬C & D) & A) & ¬A))"
    ]
    
    return len(sub_formulas)

if __name__ == "__main__":
    print(f"Number of sub-formulas: {count_sub_formulas()}\n")
    generate_truth_table()
