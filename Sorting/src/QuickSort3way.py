import random
from string import ascii_lowercase
 
def quicksort(array, begin=0, end=None):
    if begin < end:
        lt = begin
        i = begin + 1
        gt = end
        v = array[begin]
        while i <= gt:
            if array[i] < v:
                array[lt],array[i] = array[i],array[lt]
                lt += 1
                i += 1
            elif array[i] > v:
                array[i],array[gt] = array[gt],array[i]
                gt -= 1
            else:
                i += 1
        quicksort(array, begin, lt-1)
        quicksort(array, gt+1, end)
 
 
arr = ascii_lowercase[:8]+'eeabddhhh'
arr = ''.join(random.sample(arr,len(arr)))
print(arr)
arr = list(arr)
quicksort(arr,0,len(arr)-1)
print(''.join(arr))