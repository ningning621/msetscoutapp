package com.example.ningning.msetscoutapp;

/**
 * Low Bar text change size
 * End Game
 */

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Space;
import android.widget.Spinner;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.ArrayList;

//teleop is part 2 of input activity
public class Teleop extends Fragment {

    RoboInfo myRobo = RoboInfo.getInstance();
    ToggleButton hang;
    ToggleButton challenge;
    ToggleButton none;

    Button spinnerEasy1;
    Button spinnerMed1;
    Button spinnerHard1;
    Button spinnerFail1;
    Button spinnerDelete1;

    Button spinnerEasy2;
    Button spinnerMed2;
    Button spinnerHard2;
    Button spinnerFail2;
    Button spinnerDelete2;

    Button spinnerEasy3;
    Button spinnerMed3;
    Button spinnerHard3;
    Button spinnerFail3;
    Button spinnerDelete3;

    Button spinnerEasy4;
    Button spinnerMed4;
    Button spinnerHard4;
    Button spinnerFail4;
    Button spinnerDelete4;

    Button spinnerEasy5;
    Button spinnerMed5;
    Button spinnerHard5;
    Button spinnerFail5;
    Button spinnerDelete5;

    TextView textView1;
    TextView textView2;
    TextView textView3;
    TextView textView4;
    TextView textView5;


    //high and low stuff
    Button highHit;
    Button highMiss;
    Button highDelete;
    Button lowHit;
    Button lowMiss;
    Button lowDelete;

    TextView highView;
    TextView lowView;

    static TextView spinner1;
    static TextView spinnerD1;
    static TextView spinner2;
    static TextView spinnerD2;
    static TextView spinner3;
    static TextView spinnerD3;
    static TextView spinner4;
    static TextView spinnerD4;
    static TextView spinner5;
    static TextView spinnerD5;
    static TextView highGoalD2;
    static TextView lowGoalD2;
    static ToggleButton defense;

    Button shotsBlocked;
    Button shotsNotBlocked;
    Button shotsDelete;
    static TextView shotsView;
    TableRow shotsRow;

    Space space;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState) {
        View in = inflater.inflate(R.layout.activity_teleop, container,false); // adds Teleop tab to input activity

        textView1 = (TextView) in.findViewById(R.id.ratingText1);
        textView2 = (TextView) in.findViewById(R.id.ratingText2);
        textView3 = (TextView) in.findViewById(R.id.ratingText3);
        textView4 = (TextView) in.findViewById(R.id.ratingText4);
        textView5 = (TextView) in.findViewById(R.id.ratingText5);

        hang = (ToggleButton) in.findViewById(R.id.hangToggle);
        challenge = (ToggleButton) in.findViewById(R.id.challengeToggle);
        none = (ToggleButton) in.findViewById(R.id.noneToggle);
        defense = (ToggleButton) in.findViewById(R.id.defenseToggle);

        hang.setOnCheckedChangeListener(changeChecker);
        challenge.setOnCheckedChangeListener(changeChecker);
        none.setOnCheckedChangeListener(changeChecker);
        defense.setOnCheckedChangeListener(changeChecker);

        spinnerEasy1 = (Button) in.findViewById(R.id.eBut1);
        spinnerMed1 = (Button) in.findViewById(R.id.mBut1);
        spinnerHard1 = (Button) in.findViewById(R.id.hBut1);
        spinnerFail1 = (Button) in.findViewById(R.id.xFail1);
        spinnerDelete1 = (Button) in.findViewById(R.id.xBut1);

        spinnerEasy2 = (Button) in.findViewById(R.id.eBut2);
        spinnerMed2 = (Button) in.findViewById(R.id.mBut2);
        spinnerHard2 = (Button) in.findViewById(R.id.hBut2);
        spinnerFail2 = (Button) in.findViewById(R.id.xFail2);
        spinnerDelete2 = (Button) in.findViewById(R.id.xBut2);

        spinnerEasy3 = (Button) in.findViewById(R.id.eBut3);
        spinnerMed3 = (Button) in.findViewById(R.id.mBut3);
        spinnerHard3 = (Button) in.findViewById(R.id.hBut3);
        spinnerFail3 = (Button) in.findViewById(R.id.xFail3);
        spinnerDelete3 = (Button) in.findViewById(R.id.xBut3);

        spinnerEasy4 = (Button) in.findViewById(R.id.eBut4);
        spinnerMed4 = (Button) in.findViewById(R.id.mBut4);
        spinnerHard4 = (Button) in.findViewById(R.id.hBut4);
        spinnerFail4 = (Button) in.findViewById(R.id.xFail4);
        spinnerDelete4 = (Button) in.findViewById(R.id.xBut4);

        spinnerEasy5 = (Button) in.findViewById(R.id.eBut5);
        spinnerMed5 = (Button) in.findViewById(R.id.mBut5);
        spinnerHard5 = (Button) in.findViewById(R.id.hBut5);
        spinnerFail5 = (Button) in.findViewById(R.id.xFail5);
        spinnerDelete5 = (Button) in.findViewById(R.id.xBut5);


        //high and low stuff
        highHit = (Button) in.findViewById(R.id.highGoalHitButton);
        highMiss = (Button) in.findViewById(R.id.highGoalMissButton);
        highDelete = (Button) in.findViewById(R.id.highGoalDeleteButton);
        lowHit = (Button) in.findViewById(R.id.lowGoalHitButton);
        lowMiss = (Button) in.findViewById(R.id.lowGoalMissButton);
        lowDelete = (Button) in.findViewById(R.id.lowGoalDeleteButton);

        highView = (TextView) in.findViewById(R.id.highGoalView2);
        lowView = (TextView) in.findViewById(R.id.lowGoalView2);

        spinnerEasy1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView1.append("0 ");
            }
        });

        spinnerMed1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView1.append("1 ");
            }
        });

        spinnerHard1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView1.append("2 ");
            }
        });

        spinnerFail1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView1.append("3 ");
            }
        });

        spinnerDelete1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (textView1.getText().length() > 0) {
                    textView1.setText(textView1.getText().subSequence(0, textView1.getText().length() - 2));
                }
            }
        });

        spinnerEasy2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView2.append("0 ");
            }
        });

        spinnerMed2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView2.append("1 ");
            }
        });

        spinnerHard2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView2.append("2 ");
            }
        });

        spinnerFail2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView2.append("3 ");
            }
        });

        spinnerDelete2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (textView2.getText().length() > 0) {
                    textView2.setText(textView2.getText().subSequence(0, textView2.getText().length() - 2));
                }
            }
        });

        spinnerEasy3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView3.append("0 ");
            }
        });

        spinnerMed3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView3.append("1 ");
            }
        });

        spinnerHard3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView3.append("2 ");
            }
        });

        spinnerFail3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView3.append("3 ");
            }
        });

        spinnerDelete3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (textView3.getText().length() > 0) {
                    textView3.setText(textView3.getText().subSequence(0, textView3.getText().length() - 2));
                }
            }
        });

        spinnerEasy4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView4.append("0 ");
            }
        });

        spinnerMed4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView4.append("1 ");
            }
        });

        spinnerHard4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView4.append("2 ");
            }
        });

        spinnerFail4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView4.append("3 ");
            }
        });

        spinnerDelete4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (textView4.getText().length() > 0) {
                    textView4.setText(textView4.getText().subSequence(0, textView4.getText().length() - 2));
                }
            }
        });

        spinnerEasy5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView5.append("0 ");
            }
        });

        spinnerMed5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView5.append("1 ");
            }
        });

        spinnerHard5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView5.append("2 ");
            }
        });

        spinnerFail5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView5.append("3 ");
            }
        });

        spinnerDelete5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (textView5.getText().length() > 0) {
                    textView5.setText(textView5.getText().subSequence(0, textView5.getText().length() - 2));
                }
            }
        });


        //high and low stuff
        highHit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                highView.append("1 ");
            }
        });

        highMiss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                highView.append("0 ");
            }
        });

        highDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (highView.getText().length() > 0) {
                    highView.setText(highView.getText().subSequence(0, highView.getText().length() - 2));
                }
            }
        });

        lowHit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lowView.append("1 ");
            }
        });

        lowMiss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lowView.append("0 ");
            }
        });

        lowDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lowView.getText().length() > 0) {
                    lowView.setText(lowView.getText().subSequence(0, lowView.getText().length() - 2));
                }
            }
        });

        spinner1 = (TextView) in.findViewById(R.id.textViewLowBar);
        spinnerD1 = (TextView) in.findViewById(R.id.ratingText1);
        spinner2 = (TextView) in.findViewById(R.id.textSpinnerA);
        spinnerD2 = (TextView) in.findViewById(R.id.ratingText2);
        //spinner2.setText(Autonomous.a.getSelectedItem().toString());
        spinner3 = (TextView) in.findViewById(R.id.textSpinnerB);
       // spinner3.setText(Autonomous.b.getSelectedItem().toString());
        spinnerD3 = (TextView) in.findViewById(R.id.ratingText3);
        spinner4 = (TextView) in.findViewById(R.id.textSpinnerC);
        //spinner4.setText(Autonomous.c.getSelectedItem().toString());
        spinnerD4 = (TextView) in.findViewById(R.id.ratingText4);
        spinner5 = (TextView) in.findViewById(R.id.textSpinnerD);
       // spinner5.setText(Autonomous.d.getSelectedItem().toString());
        spinnerD5 = (TextView) in.findViewById(R.id.ratingText5);
        highGoalD2 = (TextView) in.findViewById(R.id.highGoalView2);
        lowGoalD2 = (TextView) in.findViewById(R.id.lowGoalView2);

        shotsBlocked = (Button)in.findViewById(R.id.blockedButton);
        shotsNotBlocked = (Button) in.findViewById(R.id.notBlockedButton);
        space = (Space)in.findViewById(R.id.space2);
        shotsView = (TextView) in.findViewById(R.id.shotsBlockedTextView);
        shotsDelete = (Button) in.findViewById(R.id.blockedDeleteButton);
        shotsRow = (TableRow) in.findViewById(R.id.shotsRow);

        shotsBlocked.setVisibility(View.GONE);
        shotsNotBlocked.setVisibility(View.GONE);
        shotsDelete.setVisibility(View.GONE);
        space.setVisibility(View.VISIBLE);
        shotsRow.setVisibility(View.GONE);

        defense.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (defense.isChecked()) {
                    shotsBlocked.setVisibility(View.VISIBLE);
                    shotsNotBlocked.setVisibility(View.VISIBLE);
                    shotsDelete.setVisibility(View.VISIBLE);
                    space.setVisibility(View.GONE);
                    shotsRow.setVisibility(View.VISIBLE);
                } else {
                    shotsBlocked.setVisibility(View.GONE);
                    shotsNotBlocked.setVisibility(View.GONE);
                    shotsDelete.setVisibility(View.GONE);
                    space.setVisibility(View.VISIBLE);
                    shotsRow.setVisibility(View.GONE);
                }
            }
        });

        shotsBlocked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shotsView.append("1 ");
            }
        });

        shotsNotBlocked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shotsView.append("0 ");
            }
        });

        shotsDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (shotsView.getText().length() > 0) {
                    shotsView.setText(shotsView.getText().subSequence(0, shotsView.getText().length() - 2));
                }
            }
        });



        return in;
    };


    CompoundButton.OnCheckedChangeListener changeChecker = new CompoundButton.OnCheckedChangeListener() {

        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (isChecked) {
                if (buttonView != hang) {
                    hang.setChecked(false);
                }
                if (buttonView != challenge) {
                    challenge.setChecked(false);
                }
                if (buttonView != none) {
                    none.setChecked(false);
                }
                if (buttonView == hang) {
                    String str = "H";
                    myRobo.setEndGameT(str);
                }
                if (buttonView == challenge) {
                    String str = "CHA";
                    myRobo.setEndGameT(str);
                }
                if (buttonView == none) {
                    String str = "N";
                    myRobo.setEndGameT(str);
                }
            }
        }
    };

}