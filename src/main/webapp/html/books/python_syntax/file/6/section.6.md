## `__del__()`方法

创建对象后，python解释器默认调用`__init__()`方法；

当删除对象时，python解释器也会默认调用一个方法，这个方法为`__del__()`方法


```python
class Hero(object):

    # 初始化方法
    # 创建完对象后会自动被调用
    def __init__(self, name):
        print('__init__方法被调用')
        self.name = name

    # 当对象被删除时，会自动被调用
    def __del__(self):
        print("__del__方法被调用")
        print("%s 被 GM 干掉了..." % self.name)


# 创建对象
taidamier = Hero("泰达米尔")

# 删除对象
print("%d 被删除1次" % id(taidamier))
del(taidamier)


print("--" * 10)


gailun = Hero("盖伦")
gailun1 = gailun
gailun2 = gailun

print("%d 被删除1次" % id(gailun))
del(gailun)

print("%d 被删除1次" % id(gailun1))
del(gailun1)

print("%d 被删除1次" % id(gailun2))
del(gailun2)


```


#### 总结
* 当有变量保存了一个对象的引用时，此对象的引用计数就会加1；

* 当使用del() 删除变量指向的对象时，则会减少对象的引用计数。如果对象的引用计数不为1，那么会让这个对象的引用计数减1，当对象的引用计数为0的时候，则对象才会被真正删除（内存被回收）。
