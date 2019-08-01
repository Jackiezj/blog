## 文件的相关操作

有些时候，需要对文件进行重命名、删除等一些操作，python的os模块中都有这么功能

### 1. 文件重命名

os模块中的rename()可以完成对文件的重命名操作

rename(需要修改的文件名, 新的文件名)

```python
import os
os.rename("毕业论文.txt", "毕业论文-最终版.txt")
```

### 2. 删除文件

os模块中的remove()可以完成对文件的删除操作

remove(待删除的文件名)

```python
import os
os.remove("毕业论文.txt")
```


### 3. 创建文件夹

```python
import os
os.mkdir("张三")
```

### 4. 获取当前目录
```python
import os
os.getcwd()
```

### 5. 改变默认目录
```python
import os
os.chdir("../")
```

### 6. 获取目录列表
```python
import os
os.listdir("./")
```


### 7. 删除文件夹
```python
import os
os.rmdir("张三")
```