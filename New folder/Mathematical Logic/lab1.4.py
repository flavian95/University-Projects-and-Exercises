def count_logical_connectives(formula):
    connectives = {
        '→': 'implication',  
        '¬': 'negation',     
        '∨': 'disjunction',  
        '∧': 'conjunction',   
        '∼': 'biconditional' 
    }
    
    count = 0
    
    for connective in connectives.keys():
        count += formula.count(connective)
    
    return count

formula = "(((C → D) → (¬A ∨ (A ∼ (A ∨ C)))) & (((¬C ∧ D) ∧ A) ∧ ¬A))"

logical_length = count_logical_connectives(formula)
print(f"The order (logical length) of the formula is: {logical_length}")
