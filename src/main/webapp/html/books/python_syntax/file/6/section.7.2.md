## super()的使用

#### 问题：

```python
class Master(object):
    def __init__(self):
        self.kongfu = "古法煎饼果子配方"  # 实例变量，属性

    def make_cake(self):  # 实例方法，方法
        print("[古法] 按照 <%s> 制作了一份煎饼果子..." % self.kongfu)


# 父类是 Master类
class School(Master):
    def __init__(self):
        self.kongfu = "现代煎饼果子配方"

    def make_cake(self):
        print("[现代] 按照 <%s> 制作了一份煎饼果子..." % self.kongfu)
        super().__init__()  # 执行父类的构造方法
        super().make_cake()  # 执行父类的实例方法


# 父类是 School 和 Master
class Prentice(School, Master):  # 多继承，继承了多个父类
    def __init__(self):
        self.kongfu = "猫氏煎饼果子配方"

    def make_cake(self):
        self.__init__()  # 执行本类的__init__方法，做属性初始化 self.kongfu = "猫氏...."
        print("[猫氏] 按照 <%s> 制作了一份煎饼果子..." % self.kongfu)

    def make_all_cake(self):
        # 方式1. 指定执行父类的方法（代码臃肿）
        # School.__init__(self)
        # School.make_cake(self)
        #
        # Master.__init__(self)
        # Master.make_cake(self)
        #
        # self.__init__()
        # self.make_cake()

        # 方法2. super() 带参数版本，只支持新式类
        # super(Prentice, self).__init__() # 执行父类的 __init__方法 
        # super(Prentice, self).make_cake()
        # self.make_cake()

        # 方法3. super()的简化版，只支持新式类
        super().__init__()  # 执行父类的 __init__方法 
        super().make_cake()  # 执行父类的 实例方法
        self.make_cake()  # 执行本类的实例方法


damao = Prentice()
damao.make_cake()
damao.make_all_cake()

# print(Prentice.__mro__)

```

#### 知识点：

> 子类继承了多个父类，如果父类类名修改了，那么子类也要涉及多次修改。而且需要重复写多次调用，显得代码臃肿。

> 使用super() 可以逐一调用所有的父类方法，并且只执行一次。调用顺序遵循 __mro__ 类属性的顺序。

> **注意：如果继承了多个父类，且父类都有同名方法，则默认只执行第一个父类的(同名方法只执行一次，目前super()不支持执行多个父类的同名方法)**

> super() 在Python2.3之后才有的机制，用于通常单继承的多层继承。


