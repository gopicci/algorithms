import random
from string import ascii_lowercase
 
def partition(array, begin, end):
    i = begin+1
    j = end
    v = array[begin]
 
    while True:
        while array[i] <= v and i < end:
            i += 1
        while array[j] >= v and j > begin:
            j -= 1
       
        if i >= j:
            break    
        else:
            array[i], array[j] = array[j], array[i]
   
    array[j], array[begin] = array[begin], array[j]
    return j
 
 
def quicksort(array, begin=0, end=None):
    if begin < end:
        pivot = partition(array, begin, end)
        quicksort(array, begin, pivot-1)
        quicksort(array, pivot+1, end)
 
 
arr = ascii_lowercase[:8]+'eeabddhhh'
arr = ''.join(random.sample(arr,len(arr)))
print(arr)
arr = list(arr)
quicksort(arr,0,len(arr)-1)
print(''.join(arr))