## 多函数程序的基本使用流程

一般在实际开发过程中，一个程序往往由多个函数（后面知识中会讲解类）组成，并且多个函数共享某些数据，这种场景是经常出现的，因此下面来总结下，多个函数中共享数据的几种方式

### 1. 使用全局变量
```python

g_num = 0

def test1():
	global g_num
	# 将处理结果存储到全局变量g_num中.....
	g_num = 100

def test2():
	# 通过获取全局变量g_num的值, 从而获取test1函数处理之后的结果
	print(g_num)

# 1. 先调用test1得到数据并且存到全局变量中
test1()

# 2. 再调用test2，处理test1函数执行之后的这个值
test2()


```

### 2. 使用函数的返回值、参数
```python

def test1():
	 # 通过return将一个数据结果返回
	 return 50

def test2(num):
	# 通过形参的方式保存传递过来的数据，就可以处理了
	print(num)

# 1. 先调用test1得到数据并且存到变量result中
result = test1()

# 2. 调用test2时，将result的值传递到test2中，从而让这个函数对其进行处理
test2(result)


```

### 3. 函数嵌套调用
```python

def test1():
	# 通过return将一个数据结果返回
	return 20

def test2():
	# 1. 先调用test1并且把结果返回来
	result = test1()
	# 2. 对result进行处理
	print(result)

# 调用test2时，完成所有的处理
test2()


```
