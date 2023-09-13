#!/bin/python3

import math
import os
import random
import re
import sys

import datetime as dt

import pandas as pd
import numpy as np
import random

#
# Complete the 'calcMissing' function below.
#
# The function accepts STRING_ARRAY readings as parameter.
#


def calcMissing(readings):
    # Write your code here
    dates = []
    temp_values = []
    for x in readings:
        temp_list = x.split('\t')
        dates.append(temp_list[0])
        temp_values.append(temp_list[1])
    

    df = pd.DataFrame(list(zip(dates,temp_values)), 
               columns =['X', 'Y'])
    df['X'] = pd.to_datetime(df['X'])

    missing_indices = df.Y.str.contains('^Missing')
    missing_dates = df.X[missing_indices]
        
    b=df.index[missing_indices]
    df1 = df.drop(b)

    df1['Date']=df1['X'].map(dt.datetime.toordinal)
    df1['Y'] = pd.to_numeric(df1['Y'])

    x = df1[['Date']]
    y = np.asarray(df1['Y'])
    
    from sklearn.ensemble import GradientBoostingRegressor
    lr = GradientBoostingRegressor()
    lr.fit(x,y)

    
    x_test = df.X[b]
    x_test1 = x_test.map(dt.datetime.toordinal)
    y_pred = lr.predict(np.array(x_test1).reshape(-1,1))
    for p in y_pred:
        print(p) 

if __name__ == '__main__':
    readings_count = int(input().strip())

    readings = []

    for _ in range(readings_count):
        readings_item = input()
        readings.append(readings_item)

    calcMissing(readings)
