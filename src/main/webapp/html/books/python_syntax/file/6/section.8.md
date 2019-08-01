# 多继承：子类继承多个父类

``` python
class Master(object):
    def __init__(self):
        self.kongfu = "古法煎饼果子配方"  # 实例变量，属性

    def make_cake(self):                    # 实例方法，方法
        print("[古法] 按照 <%s> 制作了一份煎饼果子..." % self.kongfu)
    
    def dayandai(self):
        print("师傅的大烟袋..")

class School(object):
    def __init__(self):
        self.kongfu = "现代煎饼果子配方"

    def make_cake(self):
        print("[现代] 按照 <%s> 制作了一份煎饼果子..." % self.kongfu)

    def xiaoyandai(self):
        print("学校的小烟袋..")

# class Prentice(School, Master):  # 多继承，继承了多个父类（School在前）
#     pass

# damao = Prentice()
# print(damao.kongfu)
# damao.make_cake()
# damao.dayandai()
# damao.xiaoyandai()


class Prentice(Master, School):  # 多继承，继承了多个父类（Master在前）
    pass

damao = Prentice()
print(damao.kongfu) # 执行Master的属性
damao.make_cake() # 执行Master的实例方法

# 子类的魔法属性__mro__决定了属性和方法的查找顺序
print(Prentice.__mro__)

damao.dayandai() # 不重名不受影响
damao.xiaoyandai()


```

#### 说明：
- 多继承可以继承多个父类，也继承了所有父类的属性和方法
- 注意：如果多个父类中有同名的 属性和方法，则默认使用第一个父类的属性和方法（根据类的魔法属性__mro__的顺序来查找）
- 多个父类中，不重名的属性和方法，不会有任何影响。


#### 剧情发展：
> 大猫掌握了 师傅的配方 和 学校的配方，通过研究，大猫在两个配方的基础上，创建了一种全新的煎饼果子配方，称之为 "猫氏煎饼果子配方"。（子类重写父类同名属性和方法）
