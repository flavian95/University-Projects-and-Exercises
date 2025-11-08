from itertools import combinations

# Utility function to get the negation of a literal
def negate(literal):
    if literal.startswith('¬'):
        return literal[1:]
    else:
        return '¬' + literal

# Function to perform resolution on two clauses
def resolve(clause1, clause2):
    resolved = set()
    for lit1 in clause1:
        for lit2 in clause2:
            if lit1 == negate(lit2):  # Complementary literals
                resolved.add(frozenset(clause1 - {lit1} | clause2 - {lit2}))
    return resolved

# Function to apply the resolution principle to a set of clauses
def resolution(clauses):
    new_clauses = set(clauses)
    while True:
        resolvents = set()
        for (clause1, clause2) in combinations(new_clauses, 2):
            resolvents.update(resolve(clause1, clause2))
        
        if frozenset() in resolvents:  # If empty clause (⊥) is found
            return False  # Inconsistent system
        
        # If no new clauses are generated, stop
        if resolvents.issubset(new_clauses):
            return True  # Consistent system
        
        new_clauses.update(resolvents)

# Helper function to convert the system of formulas to CNF
def convert_to_cnf(formulas):
    cnf_clauses = set()
    
    # Handling individual formulas
    for formula in formulas:
        if formula == 'p→q':
            cnf_clauses.add(frozenset(['¬p', 'q']))  # p → q = ¬p ∨ q
        elif formula == 'q→r':
            cnf_clauses.add(frozenset(['¬q', 'r']))  # q → r = ¬q ∨ r
        elif formula == 'r→s':
            cnf_clauses.add(frozenset(['¬r', 's']))  # r → s = ¬r ∨ s
        elif formula == 's→t':
            cnf_clauses.add(frozenset(['¬s', 't']))  # s → t = ¬s ∨ t
        elif formula == '¬(p→t)':
            cnf_clauses.add(frozenset(['p', '¬t']))  # ¬(p → t) = p ∧ ¬t

    return cnf_clauses

# Helper function to convert the truth table for G(p, q, r, s) to CNF
def truth_table_to_cnf():
    # The truth table represents the formula G(p, q, r, s) and it's false for these rows:
    false_rows = [
        ('0000'), ('0001'), ('0010'), ('0011'),
        ('0100'), ('0101'), ('0110'), ('0111'),
        ('1000'), ('1001'), ('1010'), ('1011'),
        ('1100'), ('1101'), ('1110'), ('1111')
    ]

    cnf_clauses = set()
    
    for row in false_rows:
        # Create the clause where the truth value is false (0)
        clause = set()
        for i, value in enumerate(row):
            if value == '0':
                clause.add(f'¬{chr(112 + i)}')  # 'p' -> chr(112), 'q' -> chr(113), etc.
            else:
                clause.add(chr(112 + i))  # 'p' -> chr(112), 'q' -> chr(113), etc.
        cnf_clauses.add(frozenset(clause))
    
    return cnf_clauses

# Example formulas for the system p→q, q→r, r→s, s→t, ¬(p→t)
formulas = ['p→q', 'q→r', 'r→s', 's→t', '¬(p→t)']

# Convert formulas to CNF
cnf_clauses = convert_to_cnf(formulas)

# Convert the truth table of G(p, q, r, s) to CNF and add to the CNF clauses
cnf_clauses.update(truth_table_to_cnf())

# Apply the resolution algorithm to check for inconsistency
if resolution(cnf_clauses):
    print("The system is consistent.")
else:
    print("The system is inconsistent.")