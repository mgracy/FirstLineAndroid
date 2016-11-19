# FirstLineAndroid


参照第一行代码广播章节的BroadcastBestPractice做的个人练习，本书中
的sample在Android6.0 会抛出异常：
 Process: com.glmgracy.broadcastbestpractice, PID: 11800
                  java.lang.RuntimeException: Unable to start receiver com.glmgracy.broadcastbestpractice.ForceOfflineReceiver: android.view.WindowManager$BadTokenException: Unable to add window android.view.ViewRootImpl$W@c652433 -- permission denied for this window type
                      at android.app.ActivityThread.handleReceiver(ActivityThread.java:2732)

在代码方面作出调整后，即可实现作者的效果。 
<code>
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    btnForceOffline = (Button) findViewById(R.id.btnForceOfflineLine);
    btnForceOffline.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent("com.glmgracy.broadcastbestpractice.FORCE_OFFLINE");
            sendBroadcast(intent);
        }
    });
    if (!Settings.canDrawOverlays(this)) {
        Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
                Uri.parse("package:" + getPackageName()));
        startActivityForResult(intent, 10);
    }
}


@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    if (requestCode == 10) {
        if (!Settings.canDrawOverlays(this)) {
            // SYSTEM_ALERT_WINDOW permission not granted...
            Toast.makeText(this, "not granted", Toast.LENGTH_SHORT);
        }
    }
}
</code>
效果如下：
<image src=""></image>
