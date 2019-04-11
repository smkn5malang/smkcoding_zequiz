package com.example.appquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView pertanyaan ;
    RadioGroup rg;
    RadioButton PilihanA,PilihanB,PilihanC,PilihanD;
    int nomor = 0;
    public static int hasil, benar, salah;

//pertanyaan quiz
    String[] pertanyaan_quiz = new String[]{
            "1.Pertanyaan 1",
            "2.Pertanyaan 2",
            "3.Pertanyaan 3",
            "4.Pertanyaan 4",
            "5.Pertanyaan 5",
            "6.Pertanyaan 6",
            "3.Pertanyaan 7",
            "4.Pertanyaan 8",
            "5.Pertanyaan 9",
            "6.Pertanyaan 10",
    };

    //pilihan jawaban a, b, c, d
    String[] pilihan_jawaban = new String[]{
            "p1","p2","p3","p4",
            "p1","p2","p3","p4",
            "p1","p2","p3","p4",
            "p1","p2","p3","p4",
            "p1","p2","p3","p4",
            "p1","p2","p3","p4",
            "p1","p2","p3","p4",
            "p1","p2","p3","p4",
            "p1","p2","p3","p4",
            "p1","p2","p3","p4",
    };
    //jawaban yang benar
    String[] jawaban_benar = new String[]{
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pertanyaan = (TextView)findViewById(R.id.pertanyaan);
        rg = (RadioGroup)findViewById(R.id.radio_group);
        PilihanA = (RadioButton) findViewById(R.id.pilihanA);
        PilihanB = (RadioButton) findViewById(R.id.pilihanB);
        PilihanC = (RadioButton) findViewById(R.id.pilihanC);
        PilihanD = (RadioButton) findViewById(R.id.pilihanD);

        pertanyaan.setText(pertanyaan_quiz[nomor]);
        PilihanA.setText(pilihan_jawaban[0]);
        PilihanB.setText(pilihan_jawaban[1]);
        PilihanC.setText(pilihan_jawaban[2]);
        PilihanD.setText(pilihan_jawaban[3]);
        PilihanA.setText(pilihan_jawaban[4]);
        PilihanB.setText(pilihan_jawaban[5]);
        PilihanC.setText(pilihan_jawaban[6]);
        PilihanD.setText(pilihan_jawaban[7]);
        PilihanA.setText(pilihan_jawaban[8]);
        PilihanB.setText(pilihan_jawaban[9]);


        rg.check(0);
        benar = 0;
        salah = 0;

    }
    public void next(View view){
        if(PilihanA.isChecked()||PilihanB.isChecked()||PilihanC.isChecked()||PilihanD.isChecked()) {
            RadioButton jawaban_user = (RadioButton) findViewById(rg.getCheckedRadioButtonId());
            String ambil_jawaban_user = jawaban_user.getText().toString();
            if (ambil_jawaban_user.equalsIgnoreCase(jawaban_benar[nomor])) benar++;
            else salah++;
            nomor++;
            if (nomor < pertanyaan_quiz.length) {
                pertanyaan.setText(pertanyaan_quiz[nomor]);
                PilihanA.setText(pilihan_jawaban[(nomor * 4) + 0]);
                PilihanB.setText(pilihan_jawaban[(nomor * 4) + 1]);
                PilihanC.setText(pilihan_jawaban[(nomor * 4) + 2]);
                PilihanD.setText(pilihan_jawaban[(nomor * 4) + 3]);
            } else {
                hasil = benar = 10;
                Intent selesai = new Intent(getApplicationContext(), HasilQuiz.class);
                startActivity(selesai);
            }
        }
        else{
            Toast.makeText(this, "Pilih Jawaban",Toast.LENGTH_SHORT).show();
        }
    }
}

