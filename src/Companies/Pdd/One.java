/*
n,M = list(map(int,input().split()))
        time = list(map(int,input().split()))
        dict = {}
        for index in range(M):
        a,b = list(map(int, input().split()))
        if b not in dict.keys():
        dict[b] = [a]
        else:
        dict[b].append(a)
        for i in range(1,n+1):
        if i not in dict.keys():
        dict[i] = []

        res=[]
        while len(res) != n:
        tmp = []
        for i in dict.keys():
        if len(dict[i])==0:
        tmp.append(i)
        tmp2 = []
        for i in tmp:
        tmp2.append(time[i-1])
        id = tmp[tmp2.index(min(tmp2))]
        res.append(id)
        for i in dict.keys():
        if id in dict[i]:
        dict[i].remove(id)
        time[id-1]=10000000
        res = [str(x) for x in res]
        print(" ".join(res))*/
