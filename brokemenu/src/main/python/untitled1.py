# -*- coding: utf-8 -*-
"""
Created on Sat Jan 27 14:22:22 2018

@author: Ankesh N. Bhoi
"""
import numpy as np
import matplotlib.pyplot as plt
import pandas as pd

# Importing the dataset
dataset = pd.read_csv('Book1.csv')
X = dataset.iloc[:, :].values
x=X.tolist()
print(x[1])
#text="Finely grind the cereal and bagel chips in a food processor and transfer to a large resealable plastic bag. Add 3 teaspoons olive oil, the paprika, 2 teaspoons salt, and pepper to taste and toss." 
text="Combine chipotle powder, garlic powder, cinnamon, and onion powder in a small bowl.Pat pineapple rings dry.Heat 1 teaspoon olive oil in a large, nonstick saucepan over medium-high heat. Add pineapple rings and red onion; sprinkle with 3 tablespoons reserved pineapple juice and brown sugar. Cook until pineapple is lightly browned, about 3 minutes per side. Transfer pineapple-onion mixture to a plate.Pat pork chops dry and lightly season both sides with salt and pepper.Transfer chops onto a plate and top with the pineapple-onion mixture. Sprinkle goat cheese on top."
# Cleaning the texts
import re
import nltk
nltk.download('stopwords')
from nltk.corpus import stopwords
from nltk.stem.porter import PorterStemmer
corpus = []

inp = re.sub('[^a-zA-Z]', ' ', text)
inp = inp.lower()
inp = inp.split()
ps = PorterStemmer()
inp = [ps.stem(word) for word in inp if word not in set(stopwords.words('english'))]

ingredients=[item for sublist in x for item in sublist]
items=[]

for i in ingredients:
    r = re.sub('[^a-zA-Z]', ' ', i)
    r = r.lower()
#    ps = PorterStemmer()
#    inp = [ps.stem(word) for word in inp if word not in set(stopwords.words('english'))]
    items.append(r)

food=[]    
for i in range(len(inp)):
    if inp[i] in items:
        food.append(inp[i])
        
    


