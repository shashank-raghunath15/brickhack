# -*- coding: utf-8 -*-
"""
Created on Sat Jan 27 15:14:23 2018

@author: Ankesh N. Bhoi
"""



import requests
from bs4 import BeautifulSoup
import operator

def start(url):
    word_list=[]
    source_code=requests.get(url).text
    soup=BeautifulSoup(source_code)
    for text in soup.findAll('a',{'class':'resource food'}):
        maal=text.string
        words=maal.lower().split()
        for each_word in words:
            word_list.append(each_word)
            print(each_word)
    print(len(word_list))
    clean_up_list(word_list)
    
def clean_up_list(wl):
    clean_wl=[]
    for wrd in wl:
        smb="~!@#$%^&*()_+-=[];',./{}}:/\">?<1234567890"
        for i in range(0,len(smb)):
            wrd = wrd.replace(smb[i],"")
        if (len(wrd)>0):
            clean_wl.append(wrd)
    print(clean_wl)
    dict(clean_wl)

def dict(cln_wl):
    dictonary={}
    for wd in cln_wl:
        if wd in dictonary:
            dictonary[wd]+=1
        else:
            dictonary[wd]=1
    
    for key , val in sorted(dictonary.items(),key=operator.itemgetter(1)):
        print (key,val)             
        
            
            

start("http://www.bbc.com/food/ingredients/by/letter/c")