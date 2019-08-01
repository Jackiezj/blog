# 模块中的`__all__`

## 1. 没有`__all__`

![](../Images/Snip20170102_15.png)

![](../Images/Snip20170102_16.png)

![](../Images/Snip20170102_17.png)

## 2. 模块中有`__all__`

![](../Images/Snip20170102_18.png)

![](../Images/Snip20170102_19.png)

### 总结
* 如果一个文件中有\_\_all\_\_变量，那么也就意味着这个变量中的元素，不会被from xxx import *时导入