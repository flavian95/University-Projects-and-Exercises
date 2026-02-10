import json
import numpy as np

# Load the dataset
with open('C:/Users/flavi/OneDrive/Desktop/Code/New folder/Numerical Analysis/dev-v2.0.json', 'r') as f:
    data = json.load(f)['data']

# Explore the data structure
first_entry = data[0]
title = first_entry['title']
paragraphs = first_entry['paragraphs']

# Extract the first set of questions
first_paragraph = paragraphs[0]
questions = first_paragraph['qas']

# Extract the first question and its answers
first_question = questions[0]['question']
first_answers = [answer['text'] for answer in questions[0]['answers']]

# Remove duplicate answers by converting the list to a set and back to a list
unique_answers = list(set(first_answers))

# Convert unique answers to a NumPy array
unique_answers_array = np.array(unique_answers)

# Display the results
print(f"Title: {title}")
print(f"First Question: {first_question}")
print(f"Unique Answers: {unique_answers_array}")
