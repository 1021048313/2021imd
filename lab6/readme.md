# lab6 User Interaction

## practice

修改成购物车图标

```xml
app:srcCompat="@drawable/ic_shopping_cart"
```

## homework

### 水平布局

修改`content_main.xml`

图片和文字的布局修改如下

```xml
 <ImageView
        android:id="@+id/donut"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:layout_marginStart="24dp"
        android:layout_marginLeft="24dp"
        android:layout_marginTop="24dp"
        android:contentDescription="@string/donut_content"
        android:onClick="showDonutOrder"
        app:layout_constraintEnd_toStartOf="@+id/icecream"
        app:layout_constraintHorizontal_bias="0.5"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/text_intro"
        app:srcCompat="@drawable/donut_circle" />

    <ImageView
        android:id="@+id/icecream"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:layout_marginTop="24dp"
        android:contentDescription="@string/icecream_content"
        android:onClick="showIceCreamOrder"
        app:layout_constraintEnd_toStartOf="@+id/froyo"
        app:layout_constraintHorizontal_bias="0.5"
        app:layout_constraintStart_toEndOf="@+id/donut"
        app:layout_constraintTop_toBottomOf="@+id/text_intro"
        app:srcCompat="@drawable/icecream_circle" />

    <ImageView
        android:id="@+id/froyo"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:layout_marginTop="24dp"
        android:layout_marginEnd="24dp"
        android:layout_marginRight="24dp"
        android:contentDescription="@string/froyo_content"
        android:onClick="showFroyoOrder"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.5"
        app:layout_constraintStart_toEndOf="@+id/icecream"
        app:layout_constraintTop_toBottomOf="@+id/text_intro"
        app:srcCompat="@drawable/froyo_circle" />

    <TextView
        android:id="@+id/donut_description"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:layout_marginTop="24dp"
        android:text="@string/donut_content"
        app:layout_constraintEnd_toEndOf="@+id/donut"
        app:layout_constraintStart_toStartOf="@+id/donut"
        app:layout_constraintTop_toBottomOf="@+id/donut" />

    <TextView
        android:id="@+id/icecream_description"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:layout_marginTop="24dp"
        android:text="@string/icecream_content"
        app:layout_constraintEnd_toEndOf="@+id/froyo"
        app:layout_constraintStart_toEndOf="@+id/icecream"
        app:layout_constraintTop_toBottomOf="@+id/froyo" />

    <TextView
        android:id="@+id/froyo_description"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:layout_marginTop="24dp"
        android:text="@string/froyo_content"
        app:layout_constraintEnd_toEndOf="@+id/icecream"
        app:layout_constraintStart_toEndOf="@+id/donut"
        app:layout_constraintTop_toBottomOf="@+id/icecream"/>
```

### 返回信息

1. 增加空白页的布局，新增一个文本显示框id为showorder

2. Mainactivity中，String orderlist变量存储订购信息

   最后通过intent发送

   ```java
   orderlist=orderlist.substring(0,orderlist.length()-1);
   intent.putExtra("orderlist",orderlist);
   startActivity(intent);
   ```

3. orderactivity中

   ```java
   //找到文本框
   showorder=findViewById(R.id.showorder);
   //接收intent的信息
   Intent intent = getIntent();
   String orderlist=intent.getStringExtra("orderlist");
   showorder.setText(orderlist);
   ```

   

