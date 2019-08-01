## 定义类

定义一个类，格式如下：

```python
class 类名:
	方法列表

```

demo：定义一个Hero类

``` python
# class Hero:  # 经典类（旧式类）定义形式
# class Hero():

class Hero(object):  # 新式类定义形式
    def info(self):
        print("英雄各有见，何必问出处。")
```

#### 说明：
* 定义类时有2种形式：新式类和经典类，上面代码中的Hero为新式类，前两行注释部分则为经典类；

* object 是Python 里所有类的最顶级父类；

* 类名 的命名规则按照"大驼峰命名法"；
*  info 是一个实例方法，第一个参数一般是self，表示实例对象本身，当然了可以将self换为其它的名字，其作用是一个变量 这个变量指向了实例对象
