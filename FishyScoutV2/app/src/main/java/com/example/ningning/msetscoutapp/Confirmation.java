package com.example.ningning.msetscoutapp;

/**
 * EditText
 * ToggleButton
 * Spinner
 * High/Low Custom code (EMHX)
 * Toggle RadioGroup custom code
 */

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Confirmation extends AppCompatActivity {
    //AUTONOMOUS
    TextView matchD;
    TextView teamD;
    TextView scouterD;
    TextView spyD;
    TextView reachD;
    TextView crossD;
    TextView highGoalD1;
    TextView lowGoalD1;

    //TELEOP
    TextView spinner1;
    TextView spinnerD1;
    TextView spinner2;
    TextView spinnerD2;
    TextView spinner3;
    TextView spinnerD3;
    TextView spinner4;
    TextView spinnerD4;
    TextView spinner5;
    TextView spinnerD5;
    TextView highGoalD2;
    TextView lowGoalD2;
    TextView defense;
    TextView endGame;
    TextView shotsBlocked;


    //POST MATCH
    TextView notesD;
    TextView breach;
    TextView capture;
    TextView result;
    TextView totalPoints;

    //  private RoboInfo confirmation = new RoboInfo();
    RoboInfo myRobo = RoboInfo.getInstance();
    String matchT;

    //DataUpdate dataUpdate;


    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation);

        //AUTONOMOUS
        matchD = (TextView) findViewById(R.id.matchNumberDisplay);
        teamD = (TextView) findViewById(R.id.teamNumberDisplay);
        scouterD = (TextView) findViewById(R.id.scouterNameDisplay);
        spyD = (TextView) findViewById(R.id.spyDisplay);
        reachD = (TextView) findViewById(R.id.reachesDefensesDisplay);
        crossD = (TextView) findViewById(R.id.crossesDefenseDisplay);
        highGoalD1 = (TextView) findViewById(R.id.highGoalsDisplay1);
        lowGoalD1 = (TextView) findViewById(R.id.lowGoalsDisplay1);

        //TELEOP
        spinner1 = (TextView) findViewById(R.id.tspinnerDisplay1);
        spinnerD1 = (TextView) findViewById(R.id.ratingDisplay1);
        spinner2 = (TextView) findViewById(R.id.tspinnerDisplay2);
        spinnerD2 = (TextView) findViewById(R.id.ratingDisplay2);
        spinner3 = (TextView) findViewById(R.id.tspinnerDisplay3);
        spinnerD3 = (TextView) findViewById(R.id.ratingDisplay3);
        spinner4 = (TextView) findViewById(R.id.tspinnerDisplay4);
        spinnerD4 = (TextView) findViewById(R.id.ratingDisplay4);
        spinner5 = (TextView) findViewById(R.id.tspinnerDisplay5);
        spinnerD5 = (TextView) findViewById(R.id.ratingDisplay5);
        highGoalD2 = (TextView) findViewById(R.id.highGoalsDisplay2);
        lowGoalD2 = (TextView) findViewById(R.id.lowGoalsDisplay2);
        defense = (TextView) findViewById(R.id.defenseDisplay);
        shotsBlocked = (TextView) findViewById(R.id.blockedDisplay);
        endGame = (TextView) findViewById(R.id.endGameDisplay);


        //POST MATCH
        notesD = (TextView) findViewById(R.id.notesDisplay);
        breach = (TextView) findViewById(R.id.breachDisplay);
        capture = (TextView) findViewById(R.id.captureDisplay);
        result = (TextView) findViewById(R.id.resultDisplay);
        totalPoints = (TextView) findViewById(R.id.totalPointsDisplay);


        Bundle bundle = new Bundle();
        final String name = bundle.getString("a");
        matchD.setText(name);

        RoboInfo confirm = RoboInfo.getInstance();

        //AUTONOMOUS
        //matchD.setText(confirm.getMatchT());
        //teamD.setText(confirm.getTeamT());
        //scouterD.setText(confirm.getScouterT());
        matchD.setText(Autonomous.matchText.getText().toString());
        teamD.setText(Autonomous.teamText.getText().toString());
        scouterD.setText(Autonomous.scouterText.getText().toString());
        spyD.setText(Autonomous.spyButton.getText().toString());
        if (Autonomous.num == 1) {
            reachD.setText("False");
            crossD.setText("None");
        }
        else if (Autonomous.num == 2) {
            reachD.setText("True");
            crossD.setText("None");
        }
        else {
            reachD.setText("False");
            crossD.setText(Autonomous.crossSpinner.getSelectedItem().toString());
        }
        highGoalD1.setText(myRobo.getHigh());
        lowGoalD1.setText(myRobo.getLow());

        //TELEOP
        spinner1.setText(Teleop.spinner1.getText().toString());
        spinnerD1.setText(Teleop.spinnerD1.getText().toString());
        spinner2.setText(Autonomous.a.getSelectedItem().toString());
        spinnerD2.setText(Teleop.spinnerD2.getText().toString());
        spinner3.setText(Autonomous.b.getSelectedItem().toString());
        spinnerD3.setText(Teleop.spinnerD3.getText().toString());
        spinner4.setText(Autonomous.c.getSelectedItem().toString());
        spinnerD4.setText(Teleop.spinnerD4.getText().toString());
        spinner5.setText(Autonomous.d.getSelectedItem().toString());
        spinnerD5.setText(Teleop.spinnerD5.getText().toString());
        highGoalD2.setText(Teleop.highGoalD2.getText().toString());
        lowGoalD2.setText(Teleop.lowGoalD2.getText().toString());
        defense.setText(Teleop.defense.getText().toString());
        shotsBlocked.setText(Teleop.shotsView.getText().toString());
        endGame.setText(myRobo.getEndGameT().toString());

        //POST MATCH
        notesD.setText(PostMatch.notesText.getText().toString());
        breach.setText(PostMatch.breach.getText().toString());
        capture.setText(PostMatch.capture.getText().toString());
//        result.setText(PostMatch.result.getText().toString());
        totalPoints.setText(PostMatch.totalPoints.getText().toString());
        result.setText(myRobo.getResult().toString());


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * Checks if the app has permission to write to device storage
     * <p/>
     * If the app does not has permission then the user will be prompted to grant permissions
     *
     * @param activity
     */
    public static void verifyStoragePermissions(Activity activity) {
        // Check if we have write permission
        int permission = ActivityCompat.checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE);

        if (permission != PackageManager.PERMISSION_GRANTED) {
            // We don't have permission so prompt the user
            ActivityCompat.requestPermissions(
                    activity,
                    PERMISSIONS_STORAGE,
                    REQUEST_EXTERNAL_STORAGE
            );
        }
    }


    // write text to file
    public void Export(View v) {
        try {
            verifyStoragePermissions(this);
            File root = new File(Environment.getExternalStorageDirectory(), "Notes");
            // if external memory exists and folder with name Notes
            if (!root.exists()) {
                root.mkdirs(); // this will create folder.
            }
            File filepath = new File(root, "b3" +
                    ".txt");  // file path to save
            FileWriter writer = new FileWriter(filepath, true);
            if(filepath.length() != 0) {
                writer.append("\n");
            }
                writer.append("Team Number, " + Autonomous.teamText.getText().toString() + "\n");
                writer.append("Match Number, " + Autonomous.matchText.getText().toString() + "\n");
                writer.append("Scouter Name, " + Autonomous.scouterText.getText().toString() + "\n");
                writer.append("Defenses on Field, " + getAb(Teleop.spinner1.getText().toString()) + ", " + getAb(Autonomous.a.getSelectedItem().toString()) + ", "
                        + getAb(Autonomous.b.getSelectedItem().toString()) + ", " + getAb(Autonomous.c.getSelectedItem().toString()) + ", "
                        + getAb(Autonomous.d.getSelectedItem().toString()) + "\n");
                writer.append("Spy Zone, " + getTf(Autonomous.spyButton.getText().toString()) + "\n");
                writer.append("Auto Reaches Defense, ");
                if (Autonomous.num == 2) {
                    writer.append("True");
                }
                else {
                    writer.append("False");
                }
                writer.append("\n");
                writer.append("Auto Crosses Defense, ");
                if (Autonomous.num == 0) {
                    writer.append(getAb(Autonomous.crossSpinner.getSelectedItem().toString()));
                }
                else {
                    writer.append(" ");
                }
                writer.append("\n");
                writer.append("Auto High Goal Shots, " + myRobo.getHigh() + "\n");
                writer.append("Auto Low Goal Shots, " + myRobo.getLow() + "\n");
                writer.append("Difficulty to Cross " + getAb(Teleop.spinner1.getText().toString()) + ", " + Teleop.spinnerD1.getText().toString() + "\n");
                writer.append("Difficulty to Cross " + getAb(Autonomous.a.getSelectedItem().toString()) + ", " + Teleop.spinnerD2.getText().toString() + "\n");
                writer.append("Difficulty to Cross " + getAb(Autonomous.b.getSelectedItem().toString()) + ", " + Teleop.spinnerD3.getText().toString() + "\n");
                writer.append("Difficulty to Cross " + getAb(Autonomous.c.getSelectedItem().toString()) + ", " + Teleop.spinnerD4.getText().toString() + "\n");
                writer.append("Difficulty to Cross " + getAb(Autonomous.d.getSelectedItem().toString()) + ", " + Teleop.spinnerD5.getText().toString() + "\n");
                writer.append("Teleop High Goal Shots, " + Teleop.highGoalD2.getText().toString() + "\n");
                writer.append("Teleop Low Goal Shots, " + Teleop.lowGoalD2.getText().toString() + "\n");
                writer.append("Shots Blocked, " + Teleop.shotsView.getText().toString() + "\n");
                writer.append("Total Points, " + PostMatch.totalPoints.getText().toString() + "\n");
                writer.append("Play Defense, " + getTf(Teleop.defense.getText().toString()) + "\n");
                writer.append("End Game, " + myRobo.getEndGameT());
                if (PostMatch.capture.getText().toString().equals("Yes")) {
                    writer.append(", " + "CAP");
                }
                if (PostMatch.breach.getText().toString().equals("Yes")) {
                    writer.append(", " + "B");
                }
                writer.append("\n");
                writer.append("Result, " + myRobo.getResult().toString() + "\n");
                writer.append("Notes, " + PostMatch.notesText.getText().toString());

                writer.flush();
                writer.close();
                myRobo.setLow("");
                myRobo.setHigh("");
                myRobo.setEndGameT("N");
                myRobo.setResult("Lose");
                Toast.makeText(getBaseContext(), "File updated!", Toast.LENGTH_SHORT).show();
                Intent toHome = new Intent(this, MainActivity.class);
                startActivity(toHome);

        } catch (IOException e) {
            e.printStackTrace();
            Log.d("file error", "" + e.getMessage());
        }
    }

    public String getAb(String str) {
        switch (str) {
            case "None":
                return "  ";
            case "Portcullis":
                return "PC";
            case "Cheval de Frise":
                return "CF";
            case "Moat":
                return "M";
            case "Ramparts":
                return "RP";
            case "Sally Port":
                return "SP";
            case "Drawbridge":
                return "DB";
            case "Rock Wall":
                return "RW";
            case "Rough Terrain":
                return "RT";
            case "Low Bar":
                return "LB";
            default:
                return " ";
        }
    }

    public String getTf(String str) {
        switch (str) {
            case "Yes":
                return "True";
            case "No":
                return "False";
            case "Offense":
                return "False";
            case "Defense":
                return "True";
            default:
                return " ";
        }
    }

}