package com.example.android.scorekeeper;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import static android.view.View.GONE;
import static com.example.android.scorekeeper.R.id.imageA;
import static com.example.android.scorekeeper.R.id.winner_button;
import static com.example.android.scorekeeper.R.layout.sample;

public class MainActivity extends AppCompatActivity {
    int scoreTeamA;
    int scoreTeamB;
    String TEAM_SCORE;
    String TEAM_SCOREB;
    final Context context = this;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scoreTeamA = 0;
        scoreTeamB = 0;
        TEAM_SCORE = "teamScoreA";
        TEAM_SCOREB = "teamScoreB";
        final Spinner spinnerA = (Spinner) findViewById(R.id.spinnerA);
        final Spinner spinnerB = (Spinner) findViewById(R.id.spinnerB);
        final int[] teamEmblems = {R.drawable.atlanta_hawks, R.drawable.boston_celtics, R.drawable.charlotte_bobcats, R.drawable.chicago_bulls, R.drawable.cleveland_cavaliers,
                R.drawable.dallas_mavericks, R.drawable.denver_nuggets, R.drawable.detroit_pistons, R.drawable.golden_state_warriors,
                R.drawable.houston_rockets, R.drawable.indiana_pacers, R.drawable.la_clippers, R.drawable.la_lakers,
                R.drawable.memphis_grizzlies, R.drawable.miami_heat, R.drawable.milwaukee_bucks, R.drawable.minnesota_timberwolves,
                R.drawable.new_jersey_nets, R.drawable.new_orleans_hornets, R.drawable.new_york_knicks, R.drawable.oklahoma_city_thunder,
                R.drawable.orlando_magic, R.drawable.philadelphia_sixers, R.drawable.phoenix_suns, R.drawable.portland_trail_blazers,
                R.drawable.sacramento_kings, R.drawable.san_antonio_spurs, R.drawable.toronto_raptors, R.drawable.utah_jazz, R.drawable.washington_wizards};



        /*Set onClickListener for the winner Button
        *Display a Dialog showing the Winner's Team name and Emblem
        * Or the Draw Dialog if Score is equal
        *
         */
        Button winner_btn = (Button) findViewById(winner_button);
        winner_btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {


                final Dialog winner = new Dialog(context);
                winner.setContentView(sample);
                winner.setTitle("The Winner is");
                ImageView dot = (ImageView) winner.findViewById(R.id.dialog_imageview);
                TextView text = (TextView) winner.findViewById(R.id.dialog_text);


                if (scoreTeamA > scoreTeamB) {
                    text.setText(R.string.WIN_RESULT_A);

                    dot.setImageResource(teamEmblems[spinnerA.getSelectedItemPosition()]);

                } else if (scoreTeamA < scoreTeamB) {
                    text.setText(R.string.WIN_RESULT_B);
                    dot.setImageResource(teamEmblems[spinnerB.getSelectedItemPosition()]);


                } else {
                    text.setText(R.string.DRAW);
                    dot.setVisibility(GONE);
                }
                Button dialogButton = (Button) winner.findViewById(R.id.dialogbuttonOK);
                // if button is clicked, close the custom dialog
                dialogButton.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        winner.dismiss();
                    }
                });
                winner.show();


            }
        });


        /*
         *Locate spinnerA,get the position of the selected spinner item,change imageA with the image from the p array with the same positio
         */

        spinnerA.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                position = spinnerA.getSelectedItemPosition();
                ImageView teamA = (ImageView) findViewById(imageA);
                teamA.setImageResource(teamEmblems[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                ImageView teamA = (ImageView) findViewById(imageA);
                teamA.setImageResource(R.drawable.sample_a);
            }


        });
        /**
         *Locate spinnerB,get the position of the selected spinner item,change imageB with the image from the p array with the same position
         */

        spinnerB.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                position = spinnerB.getSelectedItemPosition();
                ImageView teamB = (ImageView) findViewById(R.id.imageB);
                teamB.setImageResource(teamEmblems[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                ImageView teamB = (ImageView) findViewById(R.id.imageB);
                teamB.setImageResource(R.drawable.sample_b);
            }

        });

        /** Keeps the score values from saved state,used when user changes orientation from portrait to landscape
         */
        if (savedInstanceState != null) {
            // Restore score values from saved state
            scoreTeamA = savedInstanceState.getInt(TEAM_SCORE, scoreTeamA);
            scoreTeamB = savedInstanceState.getInt(TEAM_SCOREB, scoreTeamB);
            // Display score values from saved state
            displayForTeamA(scoreTeamA);
            displayForTeamB(scoreTeamB);

        }
    }


    /**
     * Increase the score for Team A by 1 point.
     */
    public void addOneForTeamA(View v) {
        scoreTeamA = scoreTeamA + 1;
        displayForTeamA(scoreTeamA);
    }

    /**
     * Increase the score for Team A by 2 points.
     */
    public void addTwoForTeamA(View v) {
        scoreTeamA = scoreTeamA + 2;
        displayForTeamA(scoreTeamA);
    }

    /**
     * Increase the score for Team A by 3 points.
     */
    public void addThreeForTeamA(View v) {
        scoreTeamA = scoreTeamA + 3;
        displayForTeamA(scoreTeamA);
    }

    /**
     * Increase the score for Team B by 1 point.
     */
    public void addOneForTeamB(View v) {
        scoreTeamB = scoreTeamB + 1;
        displayForTeamB(scoreTeamB);
    }

    /**
     * Increase the score for Team B by 2 points.
     */
    public void addTwoForTeamB(View v) {
        scoreTeamB = scoreTeamB + 2;
        displayForTeamB(scoreTeamB);
    }

    /**
     * Increase the score for Team B by 3 points.
     */
    public void addThreeForTeamB(View v) {
        scoreTeamB = scoreTeamB + 3;
        displayForTeamB(scoreTeamB);
    }

    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.scoreTeamA);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the given score for Team B.
     */
    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.scoreTeamB);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Resets the score for both teams back to 0.
     */
    public void resetScore(View v) {
        scoreTeamA = 0;
        scoreTeamB = 0;
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
    }


    @Override

    public void onSaveInstanceState(Bundle savedInstanceState) {
        // Save the team's current score values
        savedInstanceState.putInt(TEAM_SCORE, scoreTeamA);
        savedInstanceState.putInt(TEAM_SCOREB, scoreTeamB);


        // Always call the superclass so it can save the view hierarchy state
        super.onSaveInstanceState(savedInstanceState);
    }

}