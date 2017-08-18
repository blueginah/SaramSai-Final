package study.release.saramsai;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by Tronze on 2017-08-15.
 */

public class DeveloperIntroducingPage extends Activity {

    private ImageView developerBtnBack;
    private ImageView imgbk, imghl, imginna, imgjaewon, imgjiyoung, imgjw, imggsb, imgyup;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.developers_page);

        ConnectXMLwithJAVA();
        SetupDeveloperBackButton();
        SetupImage();
    }

    private void ConnectXMLwithJAVA() {
        developerBtnBack = (ImageView) findViewById(R.id.developerBtnBack);
        imgbk = (ImageView) findViewById(R.id.imgbk);
        imghl = (ImageView) findViewById(R.id.imghl);
        imginna = (ImageView) findViewById(R.id.imginna);
        imgjaewon = (ImageView) findViewById(R.id.imgjaewon);
        imgjiyoung = (ImageView) findViewById(R.id.imgjiyoung);
        imgjw = (ImageView) findViewById(R.id.imgjw);
        imggsb = (ImageView) findViewById(R.id.imgsbg);
        imgyup = (ImageView) findViewById(R.id.imgyup);
    }

    private void SetupImage() {
        //Picasso.with(this).load(R.drawable.tronze).resize(500, 500).centerCrop().into(imgbk);
        Glide.with(this).load(R.drawable.tronze).into(imgbk);
        Glide.with(this).load(R.drawable.hl).into(imghl);
        Glide.with(this).load(R.drawable.inna).into(imginna);
        Glide.with(this).load(R.drawable.jaewon).into(imgjaewon);
        Glide.with(this).load(R.drawable.hjy).into(imgjiyoung);
        Glide.with(this).load(R.drawable.jw).into(imgjw);
        Glide.with(this).load(R.drawable.gsb).into(imggsb);
        Glide.with(this).load(R.drawable.yup).into(imgyup);
    }

    private void SetupDeveloperBackButton() {
        developerBtnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}
