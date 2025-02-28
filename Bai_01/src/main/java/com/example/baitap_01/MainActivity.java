package com.example.baitap_01;

import android.os.Bundle;
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

    private EditText edtInput, edtNumbers;
    private Button btnProcessText, btnProcessNumber, btnRandom;
    private TextView tvStudentName, tvReversedText, tvOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

    private void handleInputNumbers() {
        String input = edtNumbers.getText().toString().trim();
        if (input.isEmpty()) {
            Toast.makeText(this, "Vui lòng nhập danh sách số!", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            String[] numStrings = input.split(",");
            ArrayList<Integer> numbers = new ArrayList<>();
            for (String numStr : numStrings) {
                numbers.add(Integer.parseInt(numStr.trim()));
            }

            if (numbers.isEmpty()) {
                Toast.makeText(this, "Không có số hợp lệ!", Toast.LENGTH_SHORT).show();
                return;
            }

            processNumbers(numbers);
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Vui lòng nhập số hợp lệ!", Toast.LENGTH_SHORT).show();
        }
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
