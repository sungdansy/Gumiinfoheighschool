package kr.kro.sosohanbox.gumiinformationschool;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {

    ViewFlipper v_fllipper;
    Button schoolGuideButton, schoolScheduleButton, qualificationScheduleButton, mealButton, recruitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("구미정보고등학교");

        int images[] = {
                R.drawable.m_img_001,
                R.drawable.img_01,
                R.drawable.img_02,
                R.drawable.img_03
        };

        v_fllipper = findViewById(R.id.image_slide);

        for(int image : images) {
            fllipperImages(image);
        }

        schoolGuideButton = (Button) findViewById(R.id.btn_schoolGuide);
        schoolGuideButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "학교 소개", Toast.LENGTH_SHORT).show();
            }
        });

        schoolScheduleButton = (Button) findViewById(R.id.btn_schoolSchedule);
        schoolScheduleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "학교 일정", Toast.LENGTH_SHORT).show();
            }
        });

        qualificationScheduleButton = (Button) findViewById(R.id.btn_homeMessage);
        qualificationScheduleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "모바일 가정통신문", Toast.LENGTH_SHORT).show();
            }
        });

        recruitButton = (Button) findViewById(R.id.btn_recruit);
        recruitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), recruitActivity.class);
                startActivity(intent);
            }
        });

        mealButton = (Button) findViewById(R.id.btn_meal);
        mealButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), mealsActivity.class);
                startActivity(intent);
            }
        });
    }


    // 이미지 슬라이더 구현 메서드
    public void fllipperImages(int image) {
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);

        v_fllipper.addView(imageView);      // 이미지 추가
        v_fllipper.setFlipInterval(6000);       // 자동 이미지 슬라이드 딜레이시간(1000 당 1초)
        v_fllipper.setAutoStart(true);          // 자동 시작 유무 설정

        // animation
        v_fllipper.setInAnimation(this,android.R.anim.fade_in);
        v_fllipper.setOutAnimation(this,android.R.anim.fade_out);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menuSettings:
                Toast.makeText(getApplicationContext(), "설정", Toast.LENGTH_SHORT).show();
                break;
        }

        return true;
    }

    private final long FINISH_IONTERVAL_TIME = 2000;
    private long backpressedTime = 0;

    @Override
    public void onBackPressed() {
        long tempTime = System.currentTimeMillis();
        long intervalTime = tempTime - backpressedTime;

        if(0 <= intervalTime && FINISH_IONTERVAL_TIME >= intervalTime) {
            super.onBackPressed();
        } else {
            backpressedTime = tempTime;
            Toast.makeText(getApplicationContext(), "한 번 더 뒤로가기 누르면 앱이 종료됩니다.", Toast.LENGTH_SHORT).show();
        }
    }
}
