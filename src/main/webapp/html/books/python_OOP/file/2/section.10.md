# break和continue

## 1. break

### <1> for循环

* 普通的循环示例如下：

```python

name = 'itheima'

for x in name:
	print('----')
	print(x)
else:
    print("==for循环过程中，如果没有执行break退出，则执行本语句==")

```

 运行结果:
 
```
----
i
----
t
----
h
----
e
----
i
----
m
----
a
==for循环过程中，如果没有break则执行==
```


* 带有break的循环示例如下:

```python

name = 'itheima'

for x in name:
	print('----')
	if x == 'e': 
		break
	print(x)
else:
    print("==for循环过程中，如果没有执行break退出，则执行本语句==")

```

运行结果:

```
----
i
----
t
----
h
----
```


### <2> while循环

* 普通的循环示例如下：

```python

i = 0

while i<5:
	i = i+1
	print('----')
	print(i)
else:
    print("==while循环过程中，如果没有执行break退出，则执行本语句==")

```

运行结果:

```
----
1
----
2
----
3
----
4
----
5
==while循环过程中，如果没有break则执行==
```

* 带有break的循环示例如下:

```python

i = 0

while i<5:
	i = i+1
	print('----')
	if i==3:
		break
	print(i)
else:
    print("==while循环过程中，如果没有执行break退出，则执行本语句==")

```

 运行结果:

```
----
1
----
2
----
```


### **小结:**
  * break的作用：立刻结束break所在的循环


## 2. continue

### <1> for循环

* 带有continue的循环示例如下:

```python

name = 'itheima'

for x in name:
	print('----')
	if x == 'e': 
		continue
	print(x)
else:
    print("==while循环过程中，如果没有break则执行==")
```

 运行结果:

```
----
i
----
t
----
h
----
----
i
----
m
----
a
==while循环过程中，如果没有break则执行==
```


### <2> while循环

* 带有continue的循环示例如下:

```python

i = 0

while i<5:
	i = i+1
	print('----')
	if i==3:
		continue
	print(i)

```

 运行结果:

```
----
1
----
2
----
----
4
----
5
```


### **小结:**
 - continue的作用：用来结束本次循环，紧接着执行下一次的循环


## 3. 注意点

* break/continue只能用在循环中，除此以外不能单独使用

* break/continue在嵌套循环中，只对最近的一层循环起作用
