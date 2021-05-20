# lab11

## homework

见项目ScoreKeeper

**ps 录屏软件在旋转手机时会退出，所以1、2 是连续的翻转效果，实际运行是连贯的，3是重置数据。**

### 导入项目

加载项目的时候报错`Failed to find target with hash string 'android-26' in: C:\Users\admin\AppData\Local\Android\Sdk`

进入Sdk manager（studio右上角）选26，build Tools也装一下

### 共享首选项

在MainActivity中引入`SharedPrefences`

```java
// Shared preferences object
private SharedPreferences mPreferences;
// Name of shared preferences file
private String sharedPrefFile =
    "com.example.android.scorekeeper";
```

将`OnCreate()`修改为

```java
@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Find the TextViews by ID
        mScoreText1 = findViewById(R.id.score_1);
        mScoreText2 = findViewById(R.id.score_2);
        mPreferences = getSharedPreferences(sharedPrefFile, MODE_PRIVATE);

        // Restores the scores if there is savedInstanceState.
//        if (savedInstanceState != null) {
//
//            mScore1 = savedInstanceState.getInt(STATE_SCORE_1);
//            mScore2 = savedInstanceState.getInt(STATE_SCORE_2);
//
//            //Set the score text views
//            mScoreText1.setText(String.valueOf(mScore1));
//            mScoreText2.setText(String.valueOf(mScore2));
//        }
        mScore1=mPreferences.getInt(STATE_SCORE_1,0);
        mScore2=mPreferences.getInt(STATE_SCORE_2,0);
        mScoreText1.setText(String.valueOf(mScore1));
        mScoreText2.setText(String.valueOf(mScore2));
    }
```

删掉`OnSavedInstances()`重写`onPause()`函数记录SharedPreferences

```java
@Override
protected void onPause() {
    super.onPause();
    SharedPreferences.Editor preferencesEditor = mPreferences.edit();
    //score1
    preferencesEditor.putInt(STATE_SCORE_1, mScore1);
    //score2
    preferencesEditor.putInt(STATE_SCORE_2, mScore2);
    preferencesEditor.apply();
}
```

### 重置

```java
public void reset(View view) {
    // Reset count
    mCount = 0;
    mShowCountTextView.setText(String.format("%s", mCount));

    // Reset color
    mColor = ContextCompat.getColor(this,
                                    R.color.default_background);
    mShowCountTextView.setBackgroundColor(mColor);

    // Clear preferences
    SharedPreferences.Editor preferencesEditor = mPreferences.edit();
    preferencesEditor.clear();
    preferencesEditor.apply();
}
```

