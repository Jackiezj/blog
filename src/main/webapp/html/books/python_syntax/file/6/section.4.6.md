# 添加和获取对象的属性

``` python
class Hero(object):
    """定义了一个英雄类，可以移动和攻击"""
    def move(self):
        """实例方法"""
        print("正在前往事发地点...")

    def attack(self):
        """实例方法"""
        print("发出了一招强力的普通攻击...")

# 实例化了一个英雄对象 泰达米尔
taidamier = Hero()

# 给对象添加属性，以及对应的属性值
taidamier.name = "泰达米尔"  # 姓名
taidamier.hp = 2600  # 生命值
taidamier.atk = 450  # 攻击力
taidamier.armor = 200  # 护甲值

# 通过.成员选择运算符，获取对象的属性值
print("英雄 %s 的生命值 :%d" % (taidamier.name, taidamier.hp))
print("英雄 %s 的攻击力 :%d" % (taidamier.name, taidamier.atk))
print("英雄 %s 的护甲值 :%d" % (taidamier.name, taidamier.armor))

# 通过.成员选择运算符，获取对象的实例方法
taidamier.move()
taidamier.attack()
```


#### 问题：
> 对象创建并添加属性后，能否在类的实例方法里获取这些属性呢？如果可以的话，应该通过什么方式？
