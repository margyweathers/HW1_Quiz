package com.example.margy.hw1_quiz;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Question1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Question1 extends Fragment {

    private static final String ARG_NUMBER_CORRECT = "param1";
    private static final String ARG_TOTAL_QUESTIONS = "param2";

    private EditText answer;
    private String stringAnswer;
    private int correct;
    private int total;
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
    public static Question1 newInstance(int correct, int total) {
        Question1 fragment = new Question1();
        Bundle args = new Bundle();
        args.putInt(ARG_NUMBER_CORRECT, correct);
        args.putInt(ARG_TOTAL_QUESTIONS, total);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        if(getArguments() != null){
            correct = getArguments().getInt(ARG_NUMBER_CORRECT);
            total = getArguments().getInt(ARG_TOTAL_QUESTIONS);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = null;
        view = inflater.inflate(R.layout.fragment_question1, container, false);

        nextButton = (Button) view.findViewById(R.id.next);
        answer = (EditText) view.findViewById(R.id.answer);

        return view;
    }

    public void onViewCreated(final View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Note: no answer for first question is marked wrong
                stringAnswer = answer.getText().toString();
                if (stringAnswer.equals("")){
                    getFragmentManager()
                            .beginTransaction()
                            .replace(R.id.main_fragment_container, Question1.newInstance(correct, total))
                            .addToBackStack(null)
                            .commit();
                }
                else if (stringAnswer.equalsIgnoreCase("Dave")){
                    correct = 1;
                }
                else{
                    correct = 0;
                }
                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.main_fragment_container, question2.newInstance(correct, total))
                        .addToBackStack(null)
                        .commit();
            }
        });

    }

}
