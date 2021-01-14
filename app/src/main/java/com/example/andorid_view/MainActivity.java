package com.example.andorid_view;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.andorid_view.fragment.AutoInputFragment;
import com.example.andorid_view.fragment.BlankFragment;
import com.example.andorid_view.fragment.CheckboxFragment;
import com.example.andorid_view.fragment.FileSearchFragment;
import com.example.andorid_view.fragment.RadioGroupFragment;
import com.example.andorid_view.fragment.XiangbuFragment;

public class MainActivity extends AppCompatActivity {
    Button calcActivity,blank_btn,autoinput_btn,radio_btn,checkbox_btn,notify,xiangbu,filesearch;
    LinearLayout fragment_container;
    private FragmentManager manager;
    private FragmentTransaction transaction;
    private Fragment lastF;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

    }

    private void init() {
        calcActivity = findViewById(R.id.calc_activity);
        blank_btn = findViewById(R.id.blank_btn);
        autoinput_btn = findViewById(R.id.autoinput_btn);
        autoinput_btn = findViewById(R.id.autoinput_btn);
        radio_btn = findViewById(R.id.radio_btn);
        checkbox_btn = findViewById(R.id.checkbox_btn);
        notify = findViewById(R.id.notify);
        xiangbu = findViewById(R.id.xiangbu);
        filesearch = findViewById(R.id.filesearch);


        fragment_container = findViewById(R.id.fragment_container);


        calcActivity.setOnClickListener(new MainClickListenter());
        blank_btn.setOnClickListener(new MainClickListenter());
        autoinput_btn.setOnClickListener(new MainClickListenter());
        radio_btn.setOnClickListener(new MainClickListenter());
        checkbox_btn.setOnClickListener(new MainClickListenter());
        notify.setOnClickListener(new MainClickListenter());
        xiangbu.setOnClickListener(new MainClickListenter());
        filesearch.setOnClickListener(new MainClickListenter());
    }

    class MainClickListenter implements View.OnClickListener{
        @RequiresApi(api = Build.VERSION_CODES.O)
        @Override
        public void onClick(View v) {
            manager = getSupportFragmentManager();
            transaction = manager.beginTransaction();
            switch (v.getId()) {
                case R.id.calc_activity:
                    CalculatorActivity.start(MainActivity.this);
                    finish();
                    break;
                case R.id.blank_btn:
                    if(lastF != null) {
                        transaction.remove(lastF);
                    }
                    BlankFragment blankFragment = new BlankFragment();
                    lastF = blankFragment;
                    transaction.replace(R.id.fragment_container, blankFragment);
                    transaction.commit();
                    break;
                case R.id.autoinput_btn:
                    if(lastF != null) {
                        transaction.remove(lastF);
                    }
                    AutoInputFragment autoInputFragment = new AutoInputFragment();
                    lastF = autoInputFragment;
                    transaction.replace(R.id.fragment_container, autoInputFragment);
                    transaction.commit();
                    break;
                case R.id.radio_btn:
                    if(lastF != null) {
                        transaction.remove(lastF);
                    }
                    RadioGroupFragment radioGroupFragment = new RadioGroupFragment();
                    lastF = radioGroupFragment;
                    transaction.replace(R.id.fragment_container, radioGroupFragment);
                    transaction.commit();
                    break;
                case R.id.checkbox_btn:
                    if(lastF != null) {
                        transaction.remove(lastF);
                    }
                    CheckboxFragment checkboxFragment = new CheckboxFragment();
                    lastF = checkboxFragment;
                    transaction.replace(R.id.fragment_container, checkboxFragment);
                    transaction.commit();
                    break;
                case R.id.notify:
                    Toast.makeText(MainActivity.this,"norify",Toast.LENGTH_SHORT).show();
                    Intent it = new Intent(MainActivity.this, CalculatorActivity.class); //设置点击跳转的地址
                    PendingIntent pit = PendingIntent.getActivity(MainActivity.this, 0, it, 0);
                    NotificationManager notificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
//                    notificationManager.createNotificationChannel(new NotificationChannel("","叶良辰", NotificationManager.IMPORTANCE_LOW));
                    Notification.Builder mBuilder = new Notification.Builder(MainActivity.this);
                    Notification.Builder 叶良辰 = mBuilder.setContentTitle("叶良辰")                        //标题
                            .setChannelId("123")                            //通道ID(没有不显示)
                            .setContentText("我有一百种方法让你呆不下去~")      //内容
                            .setSubText("——记住我叫叶良辰")                    //内容下面的一小段文字
                            .setTicker("收到叶良辰发送过来的信息~")             //收到信息后状态栏显示的文字信息
                            .setWhen(System.currentTimeMillis())           //设置通知时间
                            .setSmallIcon(R.mipmap.ic_launcher)            //设置小图标
//                            .setLargeIcon(LargeBitmap)                     //设置大图标
                            .setDefaults(Notification.DEFAULT_VIBRATE)    //设置默认的三色灯与振动器
                            .setVibrate(new long[]{100, 250, 100, 500})
//                            .setSound(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.biaobiao))  //设置自定义的提示音
                            .setAutoCancel(true)                           //设置点击后取消Notification
                            .setContentIntent(pit);//设置PendingIntent

                    notificationManager.notify(1,mBuilder.build());
//                    notificationManager.cancel(1);       //关闭指定id的消息
//                    notificationManager.cancelAll();      //关闭该应用的所有的消息
                    break;
                case R.id.xiangbu:
                    if(lastF != null) {
                        transaction.remove(lastF);
                    }
                    XiangbuFragment xiangbuFragment = new XiangbuFragment();
                    lastF = xiangbuFragment;
                    transaction.replace(R.id.fragment_container, xiangbuFragment);
                    transaction.commit();
                    break;
                case R.id.filesearch:
                    if(lastF != null) {
                        transaction.remove(lastF);
                    }
                    FileSearchFragment fileSearchFragment = new FileSearchFragment();
                    lastF = fileSearchFragment;
                    transaction.replace(R.id.fragment_container, fileSearchFragment);
                    transaction.commit();
                    break;
            }
        }
    }

    public static void start(Context context) {
        context.startActivity(new Intent(context,MainActivity.class));
    }

    private void showNotification() {

    }

}