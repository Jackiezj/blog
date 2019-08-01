## 函数参数(二)

### <1>. 缺省参数

调用函数时，缺省参数的值如果没有传入，则取默认值。

下例会打印默认的age，如果age没有被传入：
	
```python
def printinfo(name, age=35):
   # 打印任何传入的字符串
   print("name: %s" % name)
   print("age %d" % age)
 
# 调用printinfo函数
printinfo(name="miki")  # 在函数执行过程中 age去默认值35
printinfo(age=9 ,name="miki")
```

以上实例输出结果：

```python
name: miki
age: 35
name: miki
age: 9
```
#### 总结：
* 在形参中默认有值的参数，称之为缺省参数
* 注意：带有默认值的参数一定要位于参数列表的最后面
	```python
	>>> def printinfo(name, age=35, sex):
	... 	print name
	...
	  File "<stdin>", line 1
	SyntaxError: non-default argument follows default argument
	```

### <2>. 不定长参数
有时可能需要一个函数能处理比当初声明时更多的参数, 这些参数叫做不定长参数，声明时不会命名。

基本语法如下：

```python
def functionname([formal_args,] *args, **kwargs):
   """函数_文档字符串"""
   function_suite
   return [expression]
```

#### 注意：
* 加了星号（\*）的变量args会存放所有未命名的变量参数，args为元组
* 而加\*\*的变量kwargs会存放命名参数，即形如key=value的参数， kwargs为字典.

```python
>>> def fun(a, b, *args, **kwargs):
... 	"""可变参数演示示例"""
... 	print("a =%d" % a)
... 	print("b =%d" % b)
... 	print("args:")
... 	print(args)
... 	print("kwargs: ")
... 	for key, value in kwargs.items():
... 		print("key=%s" % value)
...
>>> fun(1, 2, 3, 4, 5, m=6, n=7, p=8)  # 注意传递的参数对应
a = 1
b = 2
args:
(3, 4, 5)
kwargs: 
p = 8
m = 6
n = 7
>>>
>>>
>>>
>>> c = (3, 4, 5)
>>> d = {"m":6, "n":7, "p":8}
>>> fun(1, 2, *c, **d)	# 注意元组与字典的传参方式
a = 1
b = 2
args:
(3, 4, 5)
kwargs: 
p = 8
m = 6
n = 7
>>>
>>>
>>>
>>> fun(1, 2, c, d) # 注意不加星号与上面的区别
a = 1
b = 2
args:
((3, 4, 5), {'p': 8, 'm': 6, 'n': 7})
kwargs:
>>>
>>>
```

### <3>. 缺省参数在\*args后面
```python
def sum_nums_3(a, *args, b=22, c=33, **kwargs):
    print(a)
    print(b)
    print(c)
    print(args)
    print(kwargs)

sum_nums_3(100, 200, 300, 400, 500, 600, 700, b=1, c=2, mm=800, nn=900)

```

#### 说明：
* 如果很多个值都是不定长参数，那么这种情况下，可以将缺省参数放到 \*args的后面， 但如果有\*\*kwargs的话，\*\*kwargs必须是最后的
