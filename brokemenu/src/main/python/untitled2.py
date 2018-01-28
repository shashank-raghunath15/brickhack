import numpy as np
import matplotlib.pyplot as plt
import pandas as pd
from flask import Flask
from flask import json
from flask import request
import re
import nltk
#nltk.download('stopwords')
from nltk.corpus import stopwords
from nltk.stem.porter import PorterStemmer



app = Flask(__name__)


@app.route('/items', methods=("POST",))
def foodlist():       
        dataset = pd.read_csv('Book1.csv')
        X = dataset.iloc[:, :].values
        x=X.tolist()

#text="Finely grind the cereal and bagel chips in a food processor and transfer to a large resealable plastic bag. Add 3 teaspoons olive oil, the paprika, 2 teaspoons salt, and pepper to taste and toss." 
#text="Combine chipotle powder, garlic powder, cinnamon, and onion powder in a small bowl.Pat pineapple rings dry.Heat 1 teaspoon olive oil in a large, nonstick saucepan over medium-high heat. Add pineapple rings and red onion; sprinkle with 3 tablespoons reserved pineapple juice and brown sugar. Cook until pineapple is lightly browned, about 3 minutes per side. Transfer pineapple-onion mixture to a plate.Pat pork chops dry and lightly season both sides with salt and pepper.Transfer chops onto a plate and top with the pineapple-onion mixture. Sprinkle goat cheese on top."
#text=input().strip()
# Cleaning the texts
        #text='pineapple cucumber'
        data = request.form
        text = data['txt']
        #import nltk
        
        
        #from nltk.stem.porter import PorterStemmer
        
        
        inp = re.sub('[^a-zA-Z]', ' ', text)
        inp = inp.lower()
        inp = inp.split()
        #ps = PorterStemmer()
        #inp = [ps.stem(word) for word in inp if word not in set(stopwords.words('english'))]
        
        ingredients=[item for sublist in x for item in sublist]
        items=[]
        
        for i in ingredients:
            r = re.sub('[^a-zA-Z]', ' ', i)
            r = r.lower()
        #    ps = PorterStemmer()
        #    inp = [ps.stem(word) for word in inp if word not in set(stopwords.words('english'))]
            inp = [word for word in inp if word not in set(stopwords.words('english'))]
            items.append(r)
        
        food=[]    
        for i in range(len(inp)):
            if inp[i] in items:
                food.append(inp[i])
        food=list(set(food))       
        if 'olive' in food:
            if 'oil' in food:
                food.remove('olive')
                food.remove('oil')
                food.append('olive oil')
                
        if 'powder'  in inp:
            
            wp=[]
            for i, j in enumerate(inp):
                if j == 'powder':
                    wp=i-1
                    if inp[wp] in food:
                        food.remove(inp[wp])
                    
                    food.append(inp[wp]+' powder')
        
        if 'spray'  in inp:
            
            wp=[]
            for i, j in enumerate(inp):
                if j == 'spray':
                    wp=i-1
                    if inp[wp] in food:
                        food.remove(inp[wp])
                    
                    food.append(inp[wp]+' spray')          
        food=list(set(food))
        print(inp)	
        print(food)	
        
        return json.dumps(food)
        
if __name__ == '__main__':
    app.run()