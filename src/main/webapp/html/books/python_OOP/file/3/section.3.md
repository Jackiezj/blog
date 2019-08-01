# 字符串输入

之前在学习input的时候，通过它能够完成从键盘获取数据，然后保存到指定的变量中；

注意：input获取的数据，都以字符串的方式进行保存，即使输入的是数字，那么也是以字符串方式保存

demo:

```python
	userName = input('请输入用户名:')
	print("用户名为：%s" % userName)

	password = input('请输入密码:')
	print("密码为：%s" % password)
```

结果：（根据输入的不同结果也不同）

```python
	请输入用户名:itheima
	用户名为： itheima
	请输入密码:haohaoxuexitiantianxiangshang
	密码为： haohaoxuexitiantianxiangshang
```
