# [Java项目]坦克大战_TankGame（中文说明）

[**English**](https://github.com/ZZHow1024/TankGame_Java/blob/main/README_EN.md)

学习 Java 的入门小项目，争取最终达到可玩的程度

项目来源：韩顺平老师[[**https://space.bilibili.com/651245581**](https://space.bilibili.com/651245581)]

---
Website：

[[Java项目]坦克大战_TankGame | ZZHow](https://www.zzhow.com/TankGame)

Source Code：

https://github.com/ZZHow1024/TankGame_Java

Releases：

https://github.com/ZZHow1024/TankGame_Java/releases

---

## 使用说明

- 确定您使用的操作系统
    - Windows：
        - 选择 .zip压缩包/.exe安装包/.msi安装包
    - Linux：
        - 选择 .deb安装包/.rpm安装包
    - macOS：
        - 选择 .dmg磁盘镜像/.pkg安装包
- 下载对应的文件
- Windows 可直接运行.exe文件，Linux 和 macOS 需要执行安装操作后再运行

---

## 功能介绍

- TankGame1.0
    - 窗体标题 和 icon 显示
    - 游戏面板绘制（灰色矩形）
    - 我方坦克绘制，并可实现 WASD 键控制坦克 上左下右 移动
    - 敌方坦克绘制，不可移动
- TankGame2.0
    - 敌方坦克可随机移动
    - 敌方坦克可随机发射子弹
    - 我方坦克可通过空格键发射子弹
    - 游戏胜利/失败判断
    - 显示游戏时间
    - 游戏开始确认
    - 游戏重玩

---

## 知识点总结

- TankGame1.0
    - Java 集合类(`Vector`)
    - Java 绘图(`JFrame类`、`Panel类`、`Graphics类` 和 `Color类`)
    - 读取图片(`getImage()方法` 和 `getResource()方法`)
    - 键盘监听(`KeyListener接口` 与 其中的 `keyPressed()方法`)
- TankGame2.0
    - Java 多线程(继承 `Thread类`/实现 `Runnable接口`)

---

## **效果图**

![Tank Game 1.0](https://www.notion.so/image/https%3A%2F%2Fprod-files-secure.s3.us-west-2.amazonaws.com%2F4b165318-6383-451c-8845-110b786c9f0a%2F1f69128c-ff77-4a30-ad43-235842eb361f%2FTankGame1.0.png?table=block&id=eb7c1e37-5851-4b48-97cd-cf371603d957&t=eb7c1e37-5851-4b48-97cd-cf371603d957&width=1482&cache=v2)

Tank Game 1.0

![Tank Game 2.0](https://www.notion.so/image/https%3A%2F%2Fprod-files-secure.s3.us-west-2.amazonaws.com%2F4b165318-6383-451c-8845-110b786c9f0a%2F1c716d7d-99de-47cc-99d9-9d2986df0863%2FTankGame2.0.png?table=block&id=0b8e553c-7f0a-41ca-896c-d9388ce3c02a&t=0b8e553c-7f0a-41ca-896c-d9388ce3c02a&width=708&cache=v2)

Tank Game 2.0
