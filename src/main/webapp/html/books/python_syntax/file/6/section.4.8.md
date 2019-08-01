# 在方法内通过self获取对象属性

``` python
class Hero(object):
    """定义了一个英雄类，可以移动和攻击"""
    def move(self):
        """实例方法"""
        print("正在前往事发地点...")

    def attack(self):
        """实例方法"""
        print("发出了一招强力的普通攻击...")

    def info(self):
        """在类的实例方法中，通过self获取该对象的属性"""
        print("英雄 %s 的生命值 :%d" % (self.name, self.hp))
        print("英雄 %s 的攻击力 :%d" % (self.name, self.atk))
        print("英雄 %s 的护甲值 :%d" % (self.name, self.armor))
        

# 实例化了一个英雄对象 泰达米尔
taidamier = Hero()

# 给对象添加属性，以及对应的属性值
taidamier.name = "泰达米尔"  # 姓名
taidamier.hp = 2600  # 生命值
taidamier.atk = 450  # 攻击力
taidamier.armor = 200  # 护甲值

# 通过.成员选择运算符，获取对象的实例方法
taidamier.info()  # 只需要调用实例方法info()，即可获取英雄的属性
taidamier.move()
taidamier.attack()

```


#### 问题：
> 创建对象后再去添加属性有点不合适，有没有简单的办法，可以在创建对象的时候，就已经拥有这些属性？
