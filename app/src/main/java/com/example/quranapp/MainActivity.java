package com.example.quranapp;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn;
    TextView txtSurah,txtVerse,txtDisplay;
    QDH qdh = new QDH();
    QuranArabicText versesObject = new QuranArabicText();



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn =findViewById(R.id.btnSearch);
        txtSurah = findViewById(R.id.txtSurah);
        txtVerse = findViewById(R.id.txtVerse);
        txtDisplay = findViewById(R.id.verseDisplay);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(R.id.btnSearch == view.getId()){
            int surahNo = Integer.parseInt(txtSurah.getText().toString());
            int verseNo = Integer.parseInt(txtVerse.getText().toString());
            int surahFirstVerse = qdh.getSurahStart(surahNo-1);
            String finalVerse = versesObject.QuranArabicText[surahFirstVerse + verseNo -1];
            txtDisplay.setText(finalVerse);

        }

    }
}