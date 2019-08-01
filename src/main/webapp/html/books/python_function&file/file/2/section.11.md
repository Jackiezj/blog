# for循环

像while循环一样，for可以完成循环的功能。

在Python中 for循环可以遍历任何序列的项目，如一个列表或者一个字符串等。

## for循环的格式

```python

for 临时变量 in 列表或者字符串等可迭代对象:
    循环满足条件时执行的代码
```

### demo1

```python
name = 'itheima'

for x in name:
	print(x)
```

运行结果如下:

```
i
t
h
e
i
m
a
```

### demo2

```python
>>> for x in name:
        print(x)
        if x == 'l':
            print("Hello world!")

```

运行结果如下:

```python
h
e
l
Hello world!
l
Hello world!
o
```

### demo3

```python

# range(5) 在python就业班中进行讲解会牵扯到迭代器的知识，
# 作为刚开始学习python的我们，此阶段仅仅知道range(5)表示可以循环5次即可
for i in range(5):
    print(i)
    
'''
效果等同于 while 循环的：

i = 0
while i < 5:
    print(i)
    i += 1
'''

```

运行结果如下:

```python
0
1
2
3
4
```
