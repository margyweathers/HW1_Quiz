package com.example.margy.hw1_quiz;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Question1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Question1 extends Fragment {

    private EditText answer;
    private String stringAnswer;
    private int correct;
    private Button nextButton;

    public Question1() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment Question1.
     */
    public static Question1 newInstance() {
        Question1 fragment = new Question1();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = null;
        view = inflater.inflate(R.layout.fragment_question1, container, false);

        nextButton = (Button) view.findViewById(R.id.next);

        return view;
    }

    public void onViewCreated(final View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // If the user has not entered an answer
                if ((EditText) view.findViewById(R.id.answer) == null){
                    getFragmentManager()
                            .beginTransaction()
                            .replace(R.id.main_fragment_container, Question1.newInstance())
                            .addToBackStack(null)
                            .commit();
                }

                answer = (EditText) view.findViewById(R.id.answer);
                stringAnswer = answer.getText().toString();
                if (stringAnswer.equalsIgnoreCase("Dave")){
                    correct = 1;
                }
                else{
                    correct = 0;
                }
                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.main_fragment_container, Question1.newInstance())
                        .addToBackStack(null)
                        .commit();
            }
        });

    }

}
