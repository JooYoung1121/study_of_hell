
def solution(n, num):
    num.sort()

    for i in num:
        print(i)


n = int(input())
num =[]
for _ in range(n):
    num.append(int(input()))

solution(n, num)