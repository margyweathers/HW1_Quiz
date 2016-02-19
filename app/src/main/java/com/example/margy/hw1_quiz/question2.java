package com.example.margy.hw1_quiz;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link question2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class question2 extends Fragment {

    private static final String ARG_NUMBER_CORRECT = "param1";

    private RadioButton doggy;
    private RadioButton pony;
    private RadioButton unicorn;
    private Button finishButton;
    private int correct;

    public question2() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param correct Number of correct questions so far
     * @return A new instance of fragment question2.
     */
    // TODO: Rename and change types and number of parameters
    public static question2 newInstance(int correct) {
        question2 fragment = new question2();
        Bundle args = new Bundle();
        args.putInt(ARG_NUMBER_CORRECT, correct);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(getArguments() != null){
            correct = getArguments().getInt(ARG_NUMBER_CORRECT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = null;
        view = inflater.inflate(R.layout.fragment_question2, container, false);

        // instantiate widgets
        doggy = (RadioButton) view.findViewById(R.id.doggy);
        pony = (RadioButton) view.findViewById(R.id.pony);
        unicorn = (RadioButton) view.findViewById(R.id.unicorn);
        finishButton = (Button) view.findViewById(R.id.finish);

        return view;
    }

    public void onViewCreated(View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        finishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!doggy.isChecked() && !pony.isChecked() && !unicorn.isChecked()){
                    getFragmentManager()
                            .beginTransaction()
                            .replace(R.id.main_fragment_container, question2.newInstance(correct))
                            .addToBackStack(null)
                            .commit();
                }

                else if (unicorn.isChecked()){
                    correct++;
                    displayResults(correct);
                }
                else{
                    displayResults(correct);
                }
            }
        });
    }

    private void displayResults(int correct){
        new AlertDialog.Builder(getActivity())
                .setCancelable(true)
                .setTitle("Score:")
                .setMessage(correct + "/2")
                .setPositiveButton("Restart", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        getFragmentManager()
                                .beginTransaction()
                                .replace(R.id.main_fragment_container, Question1.newInstance())
                                .addToBackStack(null)
                                .commit();
                    }
                })
                .setNegativeButton("Quit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent quit = new Intent(getActivity(), MainActivity.class);
                        question2.this.startActivity(quit);

                    }
                })
                .show();

    }

}
