# 子类重写父类的同名属性和方法

```python

class Master(object):
    def __init__(self):
        self.kongfu = "古法煎饼果子配方" 

    def make_cake(self): 
        print("[古法] 按照 <%s> 制作了一份煎饼果子..." % self.kongfu)


class School(object):
    def __init__(self):
        self.kongfu = "现代煎饼果子配方"

    def make_cake(self):
        print("[现代] 按照 <%s> 制作了一份煎饼果子..." % self.kongfu)


class Prentice(School, Master):  # 多继承，继承了多个父类
    def __init__(self):
        self.kongfu = "猫氏煎饼果子配方"

    def make_cake(self):
        print("[猫氏] 按照 <%s> 制作了一份煎饼果子..." % self.kongfu)


# 如果子类和父类的方法名和属性名相同，则默认使用子类的
# 叫 子类重写父类的同名方法和属性
damao = Prentice()
print(damao.kongfu) # 子类和父类有同名属性，则默认使用子类的
damao.make_cake() # 子类和父类有同名方法，则默认使用子类的

# 子类的魔法属性__mro__决定了属性和方法的查找顺序
print(Prentice.__mro__)

```

#### 剧情发展：
> 大猫的新配方大受欢迎，但是有些顾客希望也能吃到古法配方和 现代配方 的煎饼果子...（子类调用父类的同名属性和方法）


