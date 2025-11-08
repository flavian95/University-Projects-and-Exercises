import re
from collections import Counter

def count_propositional_variables(formula):
    variables = ['A', 'C', 'D']
    
    occurrences = re.findall(r'[A-Z]', formula)
    
    counter = Counter(occurrences)
    
    result = {var: counter.get(var, 0) for var in variables}
    
    return result

formula = '(((C → D) → (¬A ∨ (A ∼ (A ∨ C))))&(((¬C&D)&A)&¬A))'

result = count_propositional_variables(formula)
print(result)
