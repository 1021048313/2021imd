package com.example.notifyme;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    //buttons
    private Button button_notify;
    private Button button_cancel;
    private Button button_update;
    //notification id
    private static final String PRIMARY_CHANNEL_ID = "primary_notification_channel";
    //保存 notification manager
    private NotificationManager mNotifyManager;
    //未来管理notification
    private static final int NOTIFICATION_ID = 0;
    public int clicktime=0;

    //update broadcast message
    private static final String ACTION_UPDATE_NOTIFICATION =
            "com.example.android.notifyme.ACTION_UPDATE_NOTIFICATION";
    //broadcast receiver
    private NotificationReceiver mReceiver = new NotificationReceiver();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //执行create
        createNotificationChannel();

        //register broadcast
        registerReceiver(mReceiver,new IntentFilter(ACTION_UPDATE_NOTIFICATION));

        //click
        button_notify = findViewById(R.id.notify);
        //click listener
        button_notify.setOnClickListener(view -> sendNotification());

        //update
        button_update = findViewById(R.id.update);
        //update listener
        button_update.setOnClickListener(view -> updateNotification());

        //cancel
        button_cancel = findViewById(R.id.cancel);
        //cancel listener
        button_cancel.setOnClickListener(view -> cancelNotification());

        //只有nofity
        setNotificationButtonState(true, false, false);




    }


    //unregister broadcast
    @Override
    protected void onDestroy() {
        unregisterReceiver(mReceiver);
        super.onDestroy();
    }

    //create notification
    public void createNotificationChannel()
    {
        mNotifyManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        //检查SDK版本
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            // Create a NotificationChannel
            NotificationChannel notificationChannel = new NotificationChannel(PRIMARY_CHANNEL_ID,
                    "InboxStyle Notification", NotificationManager.IMPORTANCE_HIGH);
            //config
            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(Color.RED);
            notificationChannel.enableVibration(true);
            notificationChannel.setDescription("Notification from Inbox");
            mNotifyManager.createNotificationChannel(notificationChannel);
        }
    }

    //notify function
    public void sendNotification() {
//        System.out.println("clicked!");
        clicktime++;
        Intent updateIntent = new Intent(ACTION_UPDATE_NOTIFICATION);
        PendingIntent updatePendingIntent = PendingIntent.getBroadcast
                (this, NOTIFICATION_ID, updateIntent, PendingIntent.FLAG_ONE_SHOT);


        //调用notifybuilder
        NotificationCompat.Builder notifyBuilder = getNotificationBuilder();
        notifyBuilder.addAction(R.drawable.ic_update, "Update Notification!", updatePendingIntent);
        mNotifyManager.notify(NOTIFICATION_ID, notifyBuilder.build());

        //notify不能点
        setNotificationButtonState(false, true, true);


    }

    //notify helper
    private NotificationCompat.Builder getNotificationBuilder(){
        // intent以打开应用
        Intent notificationIntent = new Intent(this, MainActivity.class);
        //设置pending
        PendingIntent notificationPendingIntent = PendingIntent.getActivity(this,
                NOTIFICATION_ID, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        //设置notification内容
        NotificationCompat.Builder notifyBuilder = new NotificationCompat.Builder(this, PRIMARY_CHANNEL_ID)
                .setContentTitle("You've been notified!")
                .setContentText("This is your notification text."+clicktime)
                .setSmallIcon(R.drawable.ic_android)
                .setContentIntent(notificationPendingIntent)
                .setAutoCancel(true)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setDefaults(NotificationCompat.DEFAULT_ALL);

        return notifyBuilder;
    }

    //update
    public void updateNotification() {
        // Load the drawable resource into the a bitmap image.
        Bitmap aBitmap = BitmapFactory
                .decodeResource(getResources(), R.drawable.mascot_1);

        // Build the notification with all of the parameters using helper
        // method.
        NotificationCompat.Builder notifyBuilder = getNotificationBuilder();
        // Update the notification style to BigPictureStyle.
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

//        notifyBuilder.setStyle(inbox);
//        notifyBuilder=new Notification.Builder(this)
//                .setContentTitle("5 New mails from " + "sender".toString())
//                .setContentText("subject")
//                .setSmallIcon(R.drawable.new_mail)
//                .setLargeIcon(aBitmap)
//                .setStyle(new Notification.InboxStyle()
//                        .addLine("str1")
//                        .addLine("str2")
//                .setSummaryText("ddd")
//                .build();

        // Deliver the notification.
        mNotifyManager.notify(NOTIFICATION_ID, notifyBuilder.build());

        // Disable the update button, leaving only the cancel button enabled.
        setNotificationButtonState(false, false, true);
    }
    //cancel
    public void cancelNotification() {
        mNotifyManager.cancel(NOTIFICATION_ID);
        // 只有notify可点
        setNotificationButtonState(true, false, false);
    }





    //调整button的显示限制
    void setNotificationButtonState(Boolean isNotifyEnabled,
                                    Boolean isUpdateEnabled,
                                    Boolean isCancelEnabled) {
        button_notify.setEnabled(isNotifyEnabled);
        button_update.setEnabled(isUpdateEnabled);
        button_cancel.setEnabled(isCancelEnabled);
    }


    //broadcast
    public class NotificationReceiver extends BroadcastReceiver {

        public NotificationReceiver() {
        }

        @Override
        public void onReceive(Context context, Intent intent) {
            // Update the notification
            updateNotification();
        }
    }
}