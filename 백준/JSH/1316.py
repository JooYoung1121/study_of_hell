
def check(number):
    arr=[]
    for i, a in enumerate(number):
        if a in arr:
            return False
        else:
            if i<len(number)-1

                if a!=number[i+1]:
                    arr.append(a)
    return True


def solution(arr):
    count = 0
    for number in arr:
        if check(number):
            count+=1
    return count


n= int(input())
arr = []
for _ in range(n):
    arr.append(input())

print(solution(arr))