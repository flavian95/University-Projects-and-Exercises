def generate_truth_table_5var(binary_input):
    lexicographical_order = [f"{i:05b}" for i in range(32)]
    
    truth_table = [(lexicographical_order[i], int(binary_input[i])) for i in range(32)]
    
    return truth_table

def get_minterms(truth_table):
    return [combo for combo, output in truth_table if output == 1]

def get_maxterms(truth_table):
    return [combo for combo, output in truth_table if output == 0]

def to_sop_form(minterms):
    sop_terms = []
    for term in minterms:
        expression = ""
        for i, bit in enumerate(term):
            variable = chr(65 + i) 
            if bit == '0':
                expression += f"{variable}'" 
            else:
                expression += f"{variable}"
        sop_terms.append(expression)
    return " + ".join(sop_terms)

def to_pos_form(maxterms):
    pos_terms = []
    for term in maxterms:
        expression = ""
        for i, bit in enumerate(term):
            variable = chr(65 + i)
            if bit == '0':
                expression += f"{variable} + "
            else:
                expression += f"{variable}' + "
        pos_terms.append(f"({expression[:-3]})") 
    return " ".join(pos_terms)

binary_input = "11110010010010010011001111010001"

truth_table = generate_truth_table_5var(binary_input)

minterms = get_minterms(truth_table)
maxterms = get_maxterms(truth_table)

sop_form = to_sop_form(minterms)

pos_form = to_pos_form(maxterms)

print("Truth Table:", truth_table)
print("Minterms (binary combinations):", minterms)
print("Maxterms (binary combinations):", maxterms)
print("SOP Expression:", sop_form)
print("POS Expression:", pos_form)