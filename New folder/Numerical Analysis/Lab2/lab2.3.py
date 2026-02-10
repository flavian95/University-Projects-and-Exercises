import json
import numpy as np

# Load the dataset
with open('C:/Users/flavi/OneDrive/Desktop/Code/New folder/Numerical Analysis/dev-v2.0.json', 'r') as f:
    data = json.load(f)['data']

# Task 1: How many topics can we find in the dataset?
num_topics = len(data)

# Task 2: For each topic, count the number of available paragraphs.
paragraph_counts_per_topic = [len(topic['paragraphs']) for topic in data]

# Task 3: Create a 1D NumPy array for the total number of paragraphs
total_paragraphs = sum(paragraph_counts_per_topic)  # Total paragraphs across all topics
questions_per_paragraph = []

# Task 4: Iterate over each paragraph and insert into the array the total number of questions for each paragraph.
for topic in data:
    for paragraph in topic['paragraphs']:
        num_questions = len(paragraph['qas'])
        questions_per_paragraph.append(num_questions)

# Convert the list into a NumPy array
questions_per_paragraph_array = np.array(questions_per_paragraph)

# Task 5: Calculate the average number of questions per paragraph.
avg_questions_per_paragraph = np.mean(questions_per_paragraph_array)

# Task 6: Find the average number of words per paragraph.
total_words = 0
for topic in data:
    for paragraph in topic['paragraphs']:
        # Count the number of words in the context (paragraph text)
        total_words += len(paragraph['context'].split())

avg_words_per_paragraph = total_words / total_paragraphs

# Task 7: Find the percentage of questions with no answer.
total_questions = 0
no_answer_questions = 0

for topic in data:
    for paragraph in topic['paragraphs']:
        for qa in paragraph['qas']:
            total_questions += 1
            if len(qa['answers']) == 0:
                no_answer_questions += 1

percentage_no_answer = (no_answer_questions / total_questions) * 100

# Displaying the results
print(f"Number of topics: {num_topics}")
print(f"Paragraph counts per topic: {paragraph_counts_per_topic}")
print(f"Average number of questions per paragraph: {avg_questions_per_paragraph}")
print(f"Average number of words per paragraph: {avg_words_per_paragraph}")
print(f"Percentage of questions with no answer: {percentage_no_answer:.2f}%")
