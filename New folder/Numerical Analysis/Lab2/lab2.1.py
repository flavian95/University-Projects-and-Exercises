# import json

# with open('C:/Users/flavi/OneDrive/Desktop/Code/New folder/Numerical Analysis/dev-v2.0.json', 'r') as f:
#     data = json.load(f)['data']

# Exploring the Dataset: The JSON structure has several keys, but the most important ones for our analysis are:

# "version": Version of the dataset.
# "data": A list of data entries, each containing:
# "title": A title of a topic (e.g., "Normans").
# "paragraphs": A list of paragraphs related to that topic, each containing:
# "context": The text or context for the questions.
# "qas": A list of questions with answers

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

# Convert answers to a NumPy array
answers_array = np.array(first_answers)

# Display the results
print(f"Title: {title}")
print(f"First Question: {first_question}")
print(f"Answers: {answers_array}")