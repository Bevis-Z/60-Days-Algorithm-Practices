#!/bin/python3

import math
import os
import random
import re
import sys



#
# Complete the 'maximum_path' function below.
#
# The function is expected to return an INTEGER.
# The function accepts INTEGER_ARRAY node_values as parameter.
#

def maximum_path(node_values):
    # Write your code here
    n = len(node_values)
    dp = [-1] * n

    def findsol(i, currlvl):
        if i >= n:
            return 0
        if dp[i] != -1:
            return dp[i]
        val = node_values[i] + findsol(i + currlvl + 1, currlvl + 1)
        val = max(val, node_values[i] + findsol(i + currlvl + 2, currlvl + 1))
        dp[i] = val
        return val

    return findsol(0, 0)




if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    node_values_count = int(input().strip())

    node_values = []

    for _ in range(node_values_count):
        node_values_item = int(input().strip())
        node_values.append(node_values_item)

    result = maximum_path(node_values)

    fptr.write(str(result) + '\n')

    fptr.close()
