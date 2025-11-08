import re

def count_distinct_variables(formula):
    variables = re.findall(r'[A-Z]', formula)
    
    distinct_variables = set(variables)
    
    return len(distinct_variables), distinct_variables

formula = "(((C → D) → (¬A ∨ (A ∼ (A ∨ C))))&(((¬C&D)&A)&¬A))"

num_variables, variables = count_distinct_variables(formula)

print(f"Number of distinct propositional variables: {num_variables}")
print(f"Distinct variables: {variables}")
