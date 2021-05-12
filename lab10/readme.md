# lab10

见项目 notifyme，和以homework命名的文件。

update部分的修改代码如下：

```java
//Implement inbox style notification
        NotificationCompat.InboxStyle iStyle =  new NotificationCompat.InboxStyle();
        iStyle.addLine("Message 1.");
        iStyle.addLine("Message 2.");
        iStyle.addLine("Message 3.");
        iStyle.addLine("Message 4.");
        iStyle.addLine("Message 5.");
        iStyle.setSummaryText("+2 more");

       notifyBuilder
                .setSmallIcon(R.drawable.new_mail)
                .setContentTitle("Inbox Style Notification Example")
                .setStyle(iStyle);
```

