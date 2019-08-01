# 多态

所谓多态：定义时的类型和运行时的类型不一样，此时就成为多态
，多态的概念是应用于Java和C#这一类强类型语言中，而Python崇尚“鸭子类型”。

> 鸭子类型：虽然我想要一只"鸭子"，但是你给了我一只鸟。
但是只要这只鸟走路像鸭子，叫起来像鸭子，游泳也像鸭子，我就认为这是鸭子。

Python的多态，就是弱化类型，重点在于对象参数是否有指定的属性和方法，如果有就认定合适，而不关心对象的类型是否正确。

* Python伪代码实现Java或C#的多态

```python

class F1(object):
    def show(self):
        print('F1.show')

class S1(F1):
    def show(self):
        print('S1.show')

class S2(F1):
    def show(self):
        print('S2.show')

# 由于在Java或C#中定义函数参数时，必须指定参数的类型
# 为了让Func函数既可以执行S1对象的show方法，又可以执行S2对象的show方法，
# 所以在def Func的形参中obj的类型是 S1和S2的父类即F1
# 
# 而实际传入的参数是：S1对象和S2对象

def Func(F1 obj): 
    """Func函数需要接收一个F1类型或者F1子类的类型"""
    
    print(obj.show())
    
s1_obj = S1()
Func(s1_obj) # 在Func函数中传入S1类的对象 s1_obj，执行 S1 的show方法，结果：S1.show

s2_obj = S2()
Func(s2_obj) # 在Func函数中传入Ss类的对象 ss_obj，执行 Ss 的show方法，结果：S2.show

```

> 通俗点理解：定义obj这个变量是说的类型是：F1的类型，但是在真正调用Func函数时给其传递的不一定是F1类的实例对象，有可能是其子类的实例对象，
> 这种情况就是所谓的多态

* Python “鸭子类型”

```python
class F1(object):
    def show(self):
        print('F1.show')

class S1(F1):
    def show(self):
        print('S1.show')

class S2(F1):
    def show(self):
        print('S2.show')

def Func(obj):  
    # python是弱类型，即无论传递过来的是什么，obj变量都能够指向它，这也就没有所谓的多态了（弱化了这个概念）
    print(obj.show())

s1_obj = S1()
Func(s1_obj) 

s2_obj = S2()
Func(s2_obj) 

```