package study.release.saramsai;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;

/**
 * Created by Tronze on 2017-07-22.
 */

public class StartActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_page);

        HandleDisplayStartScreen(DisplayStartScreen());
    }

    private void GoToMainActivity() {
        startActivity(new Intent(GetContext(), MainActivity.class));
        finish();
    }

    private Runnable DisplayStartScreen() {
        Runnable displayRunnable = new Runnable() {
            @Override
            public void run() {
                GoToMainActivity();
            }
        };
        return displayRunnable;
    }

    private int GetPauseTime() {
        return 3000;
    }

    private void HandleDisplayStartScreen(Runnable displayRunnable) {
        Handler displayHandler = new Handler();
        displayHandler.postDelayed(displayRunnable, GetPauseTime());
    }

    private Context GetContext() {
        return this;
    }
}
