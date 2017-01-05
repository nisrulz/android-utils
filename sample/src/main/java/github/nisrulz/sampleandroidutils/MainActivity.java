package github.nisrulz.sampleandroidutils;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import github.nisrulz.androidutils.debug.DebugUtils;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
  }

  @Override
  protected void onResume() {
    super.onResume();

    DebugUtils.keepScreenOnWhileDebugging(this, BuildConfig.DEBUG);
  }
}