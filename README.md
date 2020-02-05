## 极创社区（仿码匠社区）

## 参考资料
[视频链接](https://www.bilibili.com/video/av65117012)

## 相关工具
* IDEA
* Git
* ...
    
## 相关技术
* Git
* Spring Boot
* Thymeleaf
* Mybatis
* h2
* Lombok
* ...

## Bash
#### Git
* 上传所有文件到暂存区
```
git add *
```
* 提交暂存区的文件到本地版本库,并且附上提交信息
```
git commit -m "提交信息"
```
* 将本地版本库推送到远程服务器
```
git push
```

#### Flyway
```
mvn flyway:migration
mvn compile flyway:migrate
```

#### Mybatis Generator
```
mvn -Dmybatis.generator.overwrite=true mybatis-generator:generate
```