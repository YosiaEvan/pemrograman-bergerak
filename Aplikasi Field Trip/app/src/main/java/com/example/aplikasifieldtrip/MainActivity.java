package com.example.aplikasifieldtrip;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    // deklarasi beberapa variabel/object yang digunakan di dalam aplikasi utama
    private EditText txtNama, txtNIM, txtNoHandphone, txtNoMakan;
    private Button btnTambahMahasiswa, btnDaftarMahasiswa;
    DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // melakukan inisialisasi dari setiap object
        txtNama = findViewById(R.id.txtNamaMhs);
        txtNIM = findViewById(R.id.txtNIMMhs);
        txtNoHandphone = findViewById(R.id.txtNoHPMhs);
        txtNoMakan = findViewById(R.id.txtNoMakanMhs);
        btnTambahMahasiswa = findViewById(R.id.btnTambahMhs);
        btnDaftarMahasiswa = findViewById(R.id.btnDaftarMahasiswa);

        // menginisiasi dari class dbHandler untuk mengirimkan context yang ingin dimasukan ke database
        dbHandler = new DBHandler(MainActivity.this);

        // membuat sebuah onClickListener yang akan mengirimkan isi dari setiap Object yang ada dalam layout ke values yang dikirimkan context di atas
        btnTambahMahasiswa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String namaMhs = txtNama.getText().toString();
                String nimMhs = txtNIM.getText().toString();
                String noHPMhs = txtNoHandphone.getText().toString();
                String noMakanMhs = txtNoMakan.getText().toString();

                // mengecek apakah ada field yang kosong berdasarkan nilai string yang sudah dimasukan
                if(namaMhs.isEmpty() && nimMhs.isEmpty() && noHPMhs.isEmpty() && noMakanMhs.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Tolong isi semua Field", Toast.LENGTH_SHORT).show();
                }

                dbHandler.tambahMahasiswa(namaMhs, nimMhs, noHPMhs,noMakanMhs);

                // membuat notifikasi dalam bentuk toast untuk menyatakan data tersimpan
                Toast.makeText(MainActivity.this, "Mahasiswa berhasil Ditambahkan", Toast.LENGTH_SHORT).show();

                // menjalankan baris di bawah ini untuk mengatur isi dari masing-masing text agar kosong kembali
                txtNama.setText("");
                txtNIM.setText("");
                txtNoHandphone.setText("");
                txtNoMakan.setText("");
            }
        });

        // membuat sebuah action ketika tombol btnDaftarMahasiswa di klik
        btnDaftarMahasiswa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent ( MainActivity.this, DaftarMahasiswa.class);
                startActivity(i);
            }
        });
    }
}