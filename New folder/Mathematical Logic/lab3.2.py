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

# Helper function to convert the truth table for G(p, q, r, s, t) to CNF
def truth_table_to_cnf():
    # The truth table represents the formula G(p, q, r, s, t) and it's false for these rows:
    false_rows = [
        ('00000'), ('00001'), ('00010'), ('00011'), ('00100'), ('00101'), ('00110'), ('00111'),
        ('01000'), ('01001'), ('01010'), ('01011'), ('01100'), ('01101'), ('01110'), ('01111'),
        ('10000'), ('10001'), ('10010'), ('10011'), ('10100'), ('10101'), ('10110'), ('10111'),
        ('11000'), ('11001'), ('11010'), ('11011'), ('11100'), ('11101'), ('11110'), ('11111')
    ]

    cnf_clauses = set()
    
    # The variables for the 5-variable case: p, q, r, s, t
    variables = ['p', 'q', 'r', 's', 't']
    
    for row in false_rows:
        # Create the clause where the truth value is false (0)
        clause = set()
        for i, value in enumerate(row):
            var = variables[i]
            if value == '0':
                clause.add(f'¬{var}')  # If the value is 0, negate the variable
            else:
                clause.add(var)  # If the value is 1, keep the variable as is
        cnf_clauses.add(frozenset(clause))
    
    return cnf_clauses

# Example formulas for the system p→q, q→r, r→s, s→t, ¬(p→t)
formulas = ['p→q', 'q→r', 'r→s', 's→t', '¬(p→t)']

# Convert formulas to CNF
cnf_clauses = convert_to_cnf(formulas)

# Convert the truth table of G(p, q, r, s, t) to CNF and add to the CNF clauses
cnf_clauses.update(truth_table_to_cnf())

# Apply the resolution algorithm to check for inconsistency
if resolution(cnf_clauses):
    print("The system is consistent.")
else:
    print("The system is inconsistent.")