# 子类调用父类同名属性和方法

```python
class Master(object):
    def __init__(self):
        self.kongfu = "古法煎饼果子配方"  # 实例变量，属性

    def make_cake(self):                    # 实例方法，方法
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
        print("执行子类的__init__方法前，self.kongfu属性：%s" % self.kongfu)
        self.__init__() # 执行本类的__init__方法，做属性初始化 self.kongfu = "猫氏...."
        print("执行子类的__init__方法前，self.kongfu属性：%s" % self.kongfu)
        print("[猫氏] 按照 <%s> 制作了一份煎饼果子..." % self.kongfu)


    # 调用父类方法格式：父类类名.父类方法(self)
    def make_old_cake(self):
        # 不推荐这样访问父类的实例属性，相当于创建了一个新的父类对象
        # print("直接调用Master类的kongfu属性：%s" % Master().kongfu)

        # 可以通过执行Master类的__init__方法，来修改self的属性值
        print("执行Master类的__init__方法前，self.kongfu属性：%s" % self.kongfu)
        Master.__init__(self) # 调用了父类Master的__init__方法 self.kongfu = "古法...."
        print("执行Master类的__init__方法后，self.kongfu属性：%s" % self.kongfu)
        Master.make_cake(self) # 调用父类Master的实例方法


    def make_new_cake(self):
        # 不推荐这样访问类的实例属性，相当于创建了一个新的父类对象
        # print("直接调用School类的kongfu属性：%s" % School().kongfu)

        # 可以通过执行School类的__init__方法，来修改self的属性值
        print("执行School类的__init__方法前，self.kongfu属性：%s" % self.kongfu)
        School.__init__(self) # 调用了父类School的__init__方法 self.kongfu = "现代...."
        print("执行School类的__init__方法后，self.kongfu属性：%s" % self.kongfu)
        School.make_cake(self) # 调用父类School的实例方法

# 实例化对象，自动执行子类的__init__方法
damao = Prentice()

damao.make_cake() # 调用子类的方法（默认重写了父类的同名方法）

print("--" * 10)
damao.make_old_cake() # 进入实例方法去调用父类Master的方法

print("--" * 10)
damao.make_new_cake() # 进入实例方法去调用父类School的方法

print("--" * 10)
damao.make_cake() # 调用本类的实例方法


```

执行结果：

``` j
执行子类的__init__方法前，self.kongfu属性：猫氏煎饼果子配方
执行子类的__init__方法前，self.kongfu属性：猫氏煎饼果子配方
[猫氏] 按照 <猫氏煎饼果子配方> 制作了一份煎饼果子...
--------------------
执行Master类的__init__方法前，self.kongfu属性：猫氏煎饼果子配方
执行Master类的__init__方法后，self.kongfu属性：古法煎饼果子配方
[古法] 按照 <古法煎饼果子配方> 制作了一份煎饼果子...
--------------------
执行School类的__init__方法前，self.kongfu属性：古法煎饼果子配方
执行School类的__init__方法后，self.kongfu属性：现代煎饼果子配方
[现代] 按照 <现代煎饼果子配方> 制作了一份煎饼果子...
--------------------
执行子类的__init__方法前，self.kongfu属性：现代煎饼果子配方
执行子类的__init__方法前，self.kongfu属性：猫氏煎饼果子配方
[猫氏] 按照 <猫氏煎饼果子配方> 制作了一份煎饼果子...
```

#### 核心点：
> 无论何时何地，self都表示是子类的对象。在调用父类方法时，通过传递self参数，来控制方法和属性的访问修改。

#### 剧情发展：
> 大猫的煎饼果子店非常红火，终于有一天，他成了世界首富！！
> 
> 但是他也老了，所以他希望把 师傅的配方 和 学校的配方 以及自己的配方 继续传承下去...（多层继承）


