package com.example.baitap_01;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private EditText edtInput;
    private Button btnProcessText, btnRandom;
    private TextView tvStudentName, tvReversedText, tvOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Ẩn tiêu đề của cửa sổ (phải gọi trước setContentView)
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);
        // Ẩn ActionBar (nếu có)
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        // Ánh xạ View
        edtInput = findViewById(R.id.edtInput);
        btnProcessText = findViewById(R.id.btnProcessText);
        btnRandom = findViewById(R.id.btnRandom);
        tvStudentName = findViewById(R.id.tvStudentName);
        tvReversedText = findViewById(R.id.tvReversedText);
        tvOutput = findViewById(R.id.tvOutput);

        // Hiển thị tên sinh viên
        tvStudentName.setText("Nguyễn Văn A");

        // Bắt sự kiện nút
        btnProcessText.setOnClickListener(v -> handleTextProcessing());
        btnRandom.setOnClickListener(v -> generateRandomNumbers());
    }

    private void generateRandomNumbers() {
        Random random = new Random();
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            numbers.add(random.nextInt(100));
        }
        Log.d("RandomNumbers", "Mảng ngẫu nhiên: " + numbers);
        processNumbers(numbers);
    }

    private void processNumbers(ArrayList<Integer> numbers) {
        ArrayList<Integer> evenNumbers = new ArrayList<>();
        ArrayList<Integer> oddNumbers = new ArrayList<>();

        for (int num : numbers) {
            if (num % 2 == 0) {
                evenNumbers.add(num);
            } else {
                oddNumbers.add(num);
            }
        }

        // In kết quả ra Log.d
        Log.d("RandomNumbers", "Mảng ngẫu nhiên: " + numbers);
        Log.d("EvenNumbers", "Số chẵn: " + evenNumbers);
        Log.d("OddNumbers", "Số lẻ: " + oddNumbers);
    }

    private void handleTextProcessing() {
        String input = edtInput.getText().toString().trim();
        if (input.isEmpty()) {
            Toast.makeText(this, "Vui lòng nhập chuỗi!", Toast.LENGTH_SHORT).show();
            return;
        }
        tvReversedText.setText("Chuỗi đảo ngược: " + reverseWords(input));
    }

    private String reverseWords(String str) {
        String[] words = str.split(" ");
        StringBuilder reversed = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            reversed.append(words[i].toUpperCase()).append(" ");
        }
        return reversed.toString().trim();
    }
}
