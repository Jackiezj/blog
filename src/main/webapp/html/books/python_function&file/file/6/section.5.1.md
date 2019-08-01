# 有参数的\_\_init\_\_()方法

``` python
class Hero(object):
    """定义了一个英雄类，可以移动和攻击"""

    def __init__(self, name, skill, hp, atk, armor):
        """ __init__() 方法，用来做变量初始化 或 赋值 操作"""
        # 英雄名
        self.name = name
        # 技能
        self.skill = skill
        # 生命值：
        self.hp = hp
        # 攻击力
        self.atk = atk
        # 护甲值
        self.armor = armor

    def move(self):
        """实例方法"""
        print("%s 正在前往事发地点..." % self.name)

    def attack(self):
        """实例方法"""
        print("发出了一招强力的%s..." % self.skill)

    def info(self):
        print("英雄 %s 的生命值 :%d" % (self.name, self.hp))
        print("英雄 %s 的攻击力 :%d" % (self.name, self.atk))
        print("英雄 %s 的护甲值 :%d" % (self.name, self.armor))


# 实例化英雄对象时，参数会传递到对象的__init__()方法里
taidamier = Hero("泰达米尔", "旋风斩", 2600, 450, 200)
gailun = Hero("盖伦", "大宝剑", 4200, 260, 400)


# print(gailun)
# print(taidamier)

# 不同对象的属性值的单独保存
print(id(taidamier.name)) 
print(id(gailun.name))

# 同一个类的不同对象，实例方法共享
print(id(taidamier.move())) 
print(id(gailun.move()))

```


#### 说明：
* 通过一个类，可以创建多个对象，就好比 通过一个模具创建多个实体一样

* `__init__(self)`中，默认有1个参数名字为self，如果在创建对象时传递了2个实参，那么`__init__(self)`中出了self作为第一个形参外还需要2个形参，例如`__init__(self,x,y)`

####注意：
1. 在类内部获取 属性 和 实例方法，通过self获取；
2. 在类外部获取 属性 和 实例方法，通过对象名获取。

3. 如果一个类有多个对象，每个对象的属性是各自保存的，都有各自独立的地址；
4. 但是实例方法是所有对象共享的，只占用一份内存空间。类会通过self来判断是哪个对象调用了实例方法。



