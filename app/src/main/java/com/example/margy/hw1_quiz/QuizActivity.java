package com.example.margy.hw1_quiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class QuizActivity extends AppCompatActivity {

    private static final int TOTAL_QUESTIONS = 2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        getFragmentManager()
                .beginTransaction()
                .replace(R.id.main_fragment_container, Question1.newInstance(0, TOTAL_QUESTIONS))
                .addToBackStack(null)
                .commit();


    }
}
