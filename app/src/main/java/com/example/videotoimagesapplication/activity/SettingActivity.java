package com.example.videotoimagesapplication.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.videotoimagesapplication.R;

public class SettingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Settings");
        findViewById(R.id.fileFormat).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CharSequence fileFormat[] = new CharSequence[]{"JPG", "PNG"};

                AlertDialog.Builder builder = new AlertDialog.Builder(SettingActivity.this);
                builder.setTitle("Select Option");
                builder.setItems(fileFormat, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case 0:
                                PlayVideoActivity.format = "JPG";
                                ((TextView)findViewById(R.id.viewFileFormat)).setText("JPG");
                                break;
                            case 1:
                                PlayVideoActivity.format = "PNG";
                                ((TextView)findViewById(R.id.viewFileFormat)).setText("PNG");
                                break;
                        }
                    }
                });
                builder.show();
            }
        });
        findViewById(R.id.quanlity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CharSequence fileFormat[] = new CharSequence[]{"Best", "Very High", "High", "Medium", "Low"};

                AlertDialog.Builder builder = new AlertDialog.Builder(SettingActivity.this);
                builder.setTitle("Select Option");
                builder.setItems(fileFormat, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case 0:
                                PlayVideoActivity.quanlity = "Best";
                                ((TextView)findViewById(R.id.viewQuanlity)).setText("Best");
                                break;
                            case 1:
                                PlayVideoActivity.quanlity = "Very High";
                                ((TextView)findViewById(R.id.viewQuanlity)).setText("Very High");
                                break;
                            case 2:
                                PlayVideoActivity.quanlity = "High";
                                ((TextView)findViewById(R.id.viewQuanlity)).setText("High");
                                break;
                            case 3:
                                PlayVideoActivity.quanlity = "Medium";
                                ((TextView)findViewById(R.id.viewQuanlity)).setText("Medium");
                                break;
                            case 4:
                                PlayVideoActivity.quanlity = "Low";
                                ((TextView)findViewById(R.id.viewQuanlity)).setText("Low");
                                break;
                        }
                    }
                });
                builder.show();
            }
        });
        findViewById(R.id.size).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CharSequence fileFormat[] = new CharSequence[]{"0.5x", "1x", "1.5x", "2x", "3x"};

                AlertDialog.Builder builder = new AlertDialog.Builder(SettingActivity.this);
                builder.setTitle("Select Option");
                builder.setItems(fileFormat, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case 0:
                                PlayVideoActivity.size = "0.5x";
                                ((TextView)findViewById(R.id.viewSize)).setText("0.5x");
                                break;
                            case 1:
                                PlayVideoActivity.size = "1x";
                                ((TextView)findViewById(R.id.viewSize)).setText("1x");
                                break;
                            case 2:
                                PlayVideoActivity.size = "1.5x";
                                ((TextView)findViewById(R.id.viewSize)).setText("1.5x");
                                break;
                            case 3:
                                PlayVideoActivity.size = "2x";
                                ((TextView)findViewById(R.id.viewSize)).setText("2x");
                                break;
                            case 4:
                                PlayVideoActivity.size = "3x";
                                ((TextView)findViewById(R.id.viewSize)).setText("3x");
                                break;
                        }
                    }
                });
                builder.show();
            }
        });
    }
}