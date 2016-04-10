package com.example.ningning.msetscoutapp;

/**
 * Results
 */

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.ArrayList;

//part 3 of input activity
public class PostMatch extends Fragment {
    ToggleButton win;
    ToggleButton lose;
    ToggleButton tie;

    RoboInfo myRobo = RoboInfo.getInstance();

    Button submit;

    String match;
    View fromAuto;

    private RoboInfo postInfo = new RoboInfo();
    String matchT;
    String notesT;



    static EditText notesText;
    static ToggleButton breach;
    static ToggleButton capture;
    static ToggleButton result;
    static EditText totalPoints;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState) {
        View in = inflater.inflate(R.layout.activity_post_match, container, false); // adds PostMatch tab to input activity

        notesText = (EditText) in.findViewById(R.id.notesEdit);
        breach = (ToggleButton) in.findViewById(R.id.breachToggle);
        capture = (ToggleButton) in.findViewById(R.id.captureToggle);
        //result = (ToggleButton) in.findViewById(R.id.tieToggle);
        totalPoints = (EditText) in.findViewById(R.id.totalPointsEdit);

        win = (ToggleButton) in.findViewById(R.id.winToggle);
        lose = (ToggleButton) in.findViewById(R.id.loseToggle);
        tie = (ToggleButton) in.findViewById(R.id.tieToggle);

        win.setOnCheckedChangeListener(changeChecker);
        lose.setOnCheckedChangeListener(changeChecker);
        tie.setOnCheckedChangeListener(changeChecker);



       submit = (Button) in.findViewById(R.id.submitButton);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Autonomous.teamText.getText().toString().length() == 0) {
                    Toast.makeText(getActivity(), "Add Team Number!", Toast.LENGTH_SHORT).show();
                }
                else if (Autonomous.matchText.getText().toString().length() == 0) {
                    Toast.makeText(getActivity(), "Add Match Number!", Toast.LENGTH_SHORT).show();
                }
                else if ( Autonomous.scouterText.getText().toString().length() == 0) {
                    Toast.makeText(getActivity(), "Add Scouter Name!", Toast.LENGTH_SHORT).show();
                }
                else if (PostMatch.totalPoints.getText().toString().length() == 0) {
                    Toast.makeText(getActivity(), "Add Total Points!", Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent toConfirmation = new Intent(getActivity(), Confirmation.class);
                    startActivity(toConfirmation);
                }
            }
        });

        notesText.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                String str = notesText.getText().toString();
                postInfo.setNotesT(str);
            }
        });

        return in;
    }

    CompoundButton.OnCheckedChangeListener changeChecker = new CompoundButton.OnCheckedChangeListener() {

        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (isChecked) {
                if (buttonView != win) {
                    win.setChecked(false);
                }
                if (buttonView != lose) {
                    lose.setChecked(false);
                }
                if (buttonView != tie) {
                    tie.setChecked(false);
                }
                if (buttonView == win) {
                    String str = "Win";
                    myRobo.setResult(str);
                }
                else if (buttonView == lose) {
                    String str = "Lose";
                    myRobo.setResult(str);
                }
                else if (buttonView == tie) {
                    String str = "Tie";
                    myRobo.setResult(str);
                }
            }
        }
    };

}
