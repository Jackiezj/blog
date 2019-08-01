## 函数的文档说明

```python
>>> def test(a,b):
...     "用来完成对2个数求和"
...     print("%d"%(a+b))
... 
>>> 
>>> test(11,22)
33
```

如果执行，以下代码

```python
>>> help(test)
```

能够看到test函数的相关说明

```python
Help on function test in module __main__:

test(a, b)
    用来完成对2个数求和
(END)

```
