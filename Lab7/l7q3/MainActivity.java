package com.example.l7q3;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.BackgroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText searchInput;
    private TextView textViewContent;
    private String originalText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchInput = findViewById(R.id.searchInput);
        textViewContent = findViewById(R.id.textViewContent);
        Button btnSearch = findViewById(R.id.btnSearch);
        Button btnHighlight = findViewById(R.id.btnHighlight);
        Button btnSort = findViewById(R.id.btnSort);

        originalText = getString(R.string.digital_transformation_text);

        btnSearch.setOnClickListener(v -> searchKeyword());
        btnHighlight.setOnClickListener(v -> highlightKeyword());
        btnSort.setOnClickListener(v -> sortContent());
    }

    private void searchKeyword() {
        String keyword = searchInput.getText().toString().trim();
        if (!keyword.isEmpty()) {
            String text = originalText;
            String highlighted = text.replaceAll("(?i)" + keyword, "<font color='red'><b>" + keyword + "</b></font>");
            textViewContent.setText(Html.fromHtml(highlighted));
        } else {
            textViewContent.setText(originalText);
        }
    }

    private void highlightKeyword() {
        String keyword = searchInput.getText().toString().trim();
        if (!keyword.isEmpty()) {
            Spannable spannable = new SpannableString(originalText);
            String lowerCaseText = originalText.toLowerCase();
            String lowerCaseKeyword = keyword.toLowerCase();
            int index = lowerCaseText.indexOf(lowerCaseKeyword);

            while (index >= 0) {
                spannable.setSpan(new BackgroundColorSpan(Color.YELLOW), index, index + keyword.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                index = lowerCaseText.indexOf(lowerCaseKeyword, index + 1);
            }

            textViewContent.setText(spannable);
        } else {
            textViewContent.setText(originalText);
        }
    }

    private void sortContent() {
        List<String> words = Arrays.asList(originalText.split("\\s+"));
        Collections.sort(words, Comparator.naturalOrder());
        String sortedText = String.join(" ", words);
        textViewContent.setText(sortedText);
    }
}
