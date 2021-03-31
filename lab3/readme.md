# Layouts and resources for the UI

http://ajb.aston.ac.uk/codelabs/Unit_1.2a/index.html?index=..%2F..index#0

## 计数器

### 要求

> The HelloToast app consists of two `Button` elements and one `TextView`. When the user taps the first `Button`, it displays a short message (a [Toast](https://developer.android.com/reference/android/widget/Toast.html)) on the screen. Tapping the second `Button` increases a "click" counter displayed in the `TextView`, which starts at zero.

根据教程做，其中textAlignment属性没有，搜索gravity设置为center

### Coding

1. 按照教程我感觉我旋转后的效果还行，后来我把数字调整到200sp后就出现了如网站上所示的数字下面缺点的问题。所以如果要修改应该就是修改大小，数字的大小和textview能占的宽度都可以。

2. 复制项目并改名，

   :walking: 主要就是改名然后rebuild

2. 见项目Hello Toast

## 更改布局

源代码见项目Hi Toast

## 作业

- 初始情况和点击“zero”按钮后，其颜色设置为灰色，其余情况设置为明亮色（颜色自选）。
- 判断”count”，根据奇偶情况变换颜色（颜色自选）。

源代码见项目Change Toast

snapshot.png为程序截图，video.webm为程序运行录屏（录屏用的虚拟机自带的录屏功能，不知道为啥会有黑屏，运行的时候是流畅的……）





