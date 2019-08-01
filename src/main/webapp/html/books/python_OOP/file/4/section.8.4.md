## 函数返回值(二)

在python中我们怎样返回多个值？

### <1> 多个return?

```python

def create_nums():
	print("---1---")
	return 1  # 函数中下面的代码不会被执行，因为return除了能够将数据返回之外，还有一个隐藏的功能：结束函数
	print("---2---")
	return 2
	print("---3---")

```

#### 总结1：
* 一个函数中可以有多个return语句，但是只要有一个return语句被执行到，那么这个函数就会结束了，因此后面的return没有什么用处
* 如果程序设计为如下，是可以的因为不同的场景下执行不同的return
	```python
	def create_nums(num):
		print("---1---")
		if num == 100:
			print("---2---")
			return num+1  # 函数中下面的代码不会被执行，因为return除了能够将数据返回之外，还有一个隐藏的功能：结束函数
		else:
			print("---3---")
			return num+2
		print("---4---")

	result1 = create_nums(100)
	print(result1)  # 打印101
	result2 = create_nums(200)
	print(result2)  # 打印202

	```

### <2> 一个函数返回多个数据的方式

```python
def divid(a, b):
	shang = a//b
	yushu = a%b 
	return shang, yushu  #默认是元组

result = divid(5, 2)
print(result)  # 输出(2, 1)
```

#### 总结2：
* return后面可以是元组，列表、字典等，只要是能够存储多个数据的类型，就可以一次性返回多个数据
	```python
		def function():
			# return [1, 2, 3]
			# return (1, 2, 3)
			return {"num1": 1, "num2": 2, "num3": 3}
	```
* 如果return后面有多个数据，那么默认是元组
	```python
		In [1]: a = 1, 2
		In [2]: a
		Out[2]: (1, 2)

		In [3]:
		In [3]: b = (1, 2)
		In [4]: b
		Out[4]: (1, 2)

		In [5]:
	```



