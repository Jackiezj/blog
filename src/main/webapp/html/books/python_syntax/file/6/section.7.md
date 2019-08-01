# 继承介绍以及单继承

## 1. 现实中的继承

在现实生活中，继承一般指的是子女继承父辈的财产，如下图

![继承](../Images/01-第9天-3.png)

搞不好,结果如下.. 

![继承](../Images/01-第9天-4.png)


## 2. 程序中的继承

- 在程序中，继承描述的是多个类之间的所属关系。
- 如果一个类A里面的属性和方法可以复用，则可以通过继承的方式，传递到类B里。
- 那么类A就是基类，也叫做父类；类B就是派生类，也叫做子类。



```python
# 父类
class A(object):
    def __init__(self):
        self.num = 10
    
    def print_num(self):
        print(self.num + 10)
# 子类
class B(A):
    pass


b = B()
print(b.num) 
b.print_num()

```
