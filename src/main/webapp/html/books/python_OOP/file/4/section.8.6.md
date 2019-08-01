## 拆包、交换变量的值

### <1> 对返回的数据直接拆包

```python
def get_my_info():
    high = 178
    weight = 100
    age = 18
    return high, weight, age


# result = get_my_info()
# print(result)

my_high, my_weight, my_age = get_my_info()
print(my_high)
print(my_weight)
print(my_age)


```

#### 总结：
* 拆包时要注意，需要拆的数据的个数要与变量的个数相同，否则程序会异常
* 除了对元组拆包之外，还可以对列表、字典等拆包
	```python
	In [17]: a, b = (11, 22)
	In [18]: a
	Out[18]: 11
	In [19]: b
	Out[19]: 22

	In [20]: a, b = [11, 22]
	In [21]: a
	Out[21]: 11
	In [22]: b
	Out[22]: 22

	In [23]: a, b = {"m":11, "n":22}  # 取出来的是key，而不是键值对
	In [24]: a
	Out[24]: 'm'
	In [25]: b
	Out[25]: 'n'
	```

### <2> 交换2个变量的值

```python
# 第1种方式
# a = 4
# b = 5
# c = 0
#
# c = a
# a = b
# b = c
#
# print(a)
# print(b)

# 第2种方式
# a = 4
# b = 5
# a = a+b  # a=9, b=5
# b = a-b  # a=9, b=4
# a = a-b  # a=5, b=4
# print(a)
# print(b)

# 第3种方式
a, b = 4, 5
a, b = b, a

print(a)
print(b)

```