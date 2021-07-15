def solution(alp):
    for c in cro:
        alp = alp.replace(c, '!')
    print(len(alp))

cro = ['c=', 'c-', 'dz=', 'd-', 'lj', 'nj', 's=', 'z=']
alphabet = input()
solution(alphabet)
