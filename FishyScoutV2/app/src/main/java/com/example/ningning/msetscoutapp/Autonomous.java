package com.example.ningning.msetscoutapp;


import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
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
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Space;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.ArrayList;
import java.util.List;

//part 1 of input activity
public class Autonomous extends Fragment  {

    // 2/17 revisions
    RoboInfo myRobo = RoboInfo.getInstance();

    Button highHit;
    Button highMiss;
    Button highDelete;

    static Button defenses;

    Button lowHit;
    Button lowMiss;
    Button lowDelete;
    Space space;

     TextView highView;
     TextView lowView;

    static EditText matchText;
    static EditText teamText;
    static EditText scouterText;
    static ToggleButton spyButton;
    static Spinner crossSpinner;
    static TextView highGoal;
    static TextView lowGoal;

    static Spinner a;
    static Spinner b;
    static Spinner c;
    static Spinner d;

    static int num = 1;
    ArrayAdapter<String> adapter;

    @TargetApi(Build.VERSION_CODES.GINGERBREAD)
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState) {
        View in = inflater.inflate(R.layout.activity_autonomous, container, false); // adds Autonomous tab to input activity

        // 2/17 Heher revisions
        matchText = (EditText)in.findViewById(R.id.matchNumberEdit);
        teamText = (EditText)in.findViewById(R.id.teamNumberEdit);
        scouterText = (EditText)in.findViewById(R.id.scouterNameEdit);
        spyButton = (ToggleButton) in.findViewById(R.id.spyToggleButton);
        defenses = (Button) in.findViewById(R.id.defensebutton);
        crossSpinner = (Spinner) in.findViewById(R.id.crossDefenseSpinner);
        highGoal = (TextView) in.findViewById(R.id.highGoalView1);
        lowGoal = (TextView) in.findViewById(R.id.lowGoalView1);
        space = (Space) in.findViewById(R.id.space1);

        //set up radiogroup-like behaviors for toggle buttons

        highHit = (Button) in.findViewById(R.id.highGoalHitButton1);
        highMiss = (Button) in.findViewById(R.id.highGoalMissButton1);
        highDelete = (Button) in.findViewById(R.id.highGoalDeleteButton1);
        lowHit = (Button) in.findViewById(R.id.lowGoalHitButton1);
        lowMiss = (Button) in.findViewById(R.id.lowGoalMissButton1);
        lowDelete = (Button) in.findViewById(R.id.lowGoalDeleteButton1);

        a = (Spinner) in.findViewById(R.id.spinnerA);
        b = (Spinner) in.findViewById(R.id.spinnerB);
        c = (Spinner) in.findViewById(R.id.spinnerC);
        d = (Spinner) in.findViewById(R.id.spinnerD);

        final List<String> defenseList = new ArrayList<String>();
        defenseList.add("Low Bar");
        defenseList.add(Autonomous.a.getSelectedItem().toString());
        defenseList.add(Autonomous.b.getSelectedItem().toString());
        defenseList.add(Autonomous.c.getSelectedItem().toString());
        defenseList.add(Autonomous.d.getSelectedItem().toString());

        adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, defenseList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        crossSpinner.setAdapter(adapter);

        a.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                Teleop.spinner2.setText(Autonomous.a.getSelectedItem().toString());
                defenseList.remove(1);
                defenseList.add(1, Autonomous.a.getSelectedItem().toString());

            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                Teleop.spinner2.setText(Autonomous.a.getSelectedItem().toString());
            }

        });
        b.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                Teleop.spinner3.setText(Autonomous.b.getSelectedItem().toString());

                defenseList.remove(2);
                defenseList.add(2, Autonomous.b.getSelectedItem().toString());

            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                Teleop.spinner3.setText(Autonomous.b.getSelectedItem().toString());
            }

        });
        c.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                Teleop.spinner4.setText(Autonomous.c.getSelectedItem().toString());

                defenseList.remove(3);
                defenseList.add(3, Autonomous.c.getSelectedItem().toString());

            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                Teleop.spinner4.setText(Autonomous.c.getSelectedItem().toString());
            }

        });
        d.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                Teleop.spinner5.setText(Autonomous.d.getSelectedItem().toString());

                defenseList.remove(4);
                defenseList.add(4, Autonomous.d.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                Teleop.spinner5.setText(Autonomous.d.getSelectedItem().toString());
            }

        });
        highView = (TextView) in.findViewById(R.id.highGoalView1);
        lowView = (TextView) in.findViewById(R.id.lowGoalView1);
        highView.setText(myRobo.getHigh());
        lowView.setText(myRobo.getLow());
        highHit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                highView.append("1 ");
                myRobo.setHigh(myRobo.getHigh() + "1 ");
            }
        });

        highMiss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                highView.append("0 ");
                myRobo.setHigh(myRobo.getHigh() + "0 ");
            }
        });

        highDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (highView.getText().length() > 0) {
                    highView.setText(highView.getText().subSequence(0, highView.getText().length() - 2));
                    myRobo.setHigh(myRobo.getHigh().substring(0, myRobo.getHigh().length() - 2));
                }
            }
        });

        lowHit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lowView.append("1 ");
                myRobo.setLow(myRobo.getLow() + "1 ");
            }
        });

        lowMiss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lowView.append("0 ");
                myRobo.setLow(myRobo.getLow() + "0 ");
            }
        });

        lowDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lowView.getText().length() > 0) {
                    lowView.setText(lowView.getText().subSequence(0, lowView.getText().length() - 2));
                    myRobo.setLow(myRobo.getLow().substring(0, myRobo.getLow().length() - 2));
                }
            }
        });

        // 2/17 revision
        matchText.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                String str = matchText.getText().toString();
                myRobo.setMatchT(str);
            }
        });

        teamText.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                String str = teamText.getText().toString();
                myRobo.setTeamT(str);
            }
        });

        scouterText.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                String str = scouterText.getText().toString();
                myRobo.setScouterT(str);
            }
        });

        if (num == 1) {
            defenses.setText("None");
            crossSpinner.setVisibility(View.GONE);
            space.setVisibility(View.VISIBLE);
        }
        if (num == 2) {
            defenses.setText("Reach");
            crossSpinner.setVisibility(View.GONE);
            space.setVisibility(View.VISIBLE);
        }
        if (num == 3 || num==0) {
            defenses.setText("Cross");
            num = 0;
            crossSpinner.setVisibility(View.VISIBLE);
            space.setVisibility(View.GONE);

        }
        defenses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num++;
                if (num == 1) {
                    defenses.setText("None");
                    crossSpinner.setVisibility(View.GONE);
                    space.setVisibility(View.VISIBLE);
                }
                if (num == 2) {
                    defenses.setText("Reach");
                    crossSpinner.setVisibility(View.GONE);
                    space.setVisibility(View.VISIBLE);
                }
                if (num == 3) {
                    defenses.setText("Cross");
                    num = 0;
                    crossSpinner.setVisibility(View.VISIBLE);
                    space.setVisibility(View.GONE);
                }
            }
        });

        return in;
    }

}


