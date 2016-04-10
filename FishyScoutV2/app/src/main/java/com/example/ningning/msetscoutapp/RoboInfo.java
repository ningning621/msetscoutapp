package com.example.ningning.msetscoutapp;

import android.support.v4.app.FragmentActivity;
import android.widget.EditText;

/**
 * Created by Alice on 2/15/2016.
 */
public class RoboInfo {

   String matchT;
   String teamT;
   String scouterT;
   String notesT;
   String balls = "0";
   String endGameT = "N";
   String result = "Lose";
   String high = "";
   String low = "";
   String fileName = "";

   static final RoboInfo me = new RoboInfo();

   public static RoboInfo getInstance() {
      return me;
   }

   //AUTONOMOUS

   //match text
   public void setMatchT(String str){
      matchT = str;
   }
   public String getMatchT(){
      return matchT;
   }

   //team text
   public void setTeamT(String str){
      teamT = str;
   }
   public String getTeamT(){
      return teamT;
   }

   //scouter text
   public void setScouterT(String str){
      scouterT = str;
   }
   public String getScouterT(){
      return scouterT;
   }

   public void setFileName(String str) {fileName = str;}
   public String getFileName() { return fileName;}


    public void setHigh(String str) { high = str; }
    public String getHigh()
    {
        return high;
    }

    public void setLow(String str) { low = str; }
    public String getLow() {
        return low;
    }

   //POST MATCH
   public void setNotesT(String str){
      notesT = str;
   }
   public String getNotesT(){
      return notesT;
   }

   public void setEndGameT(String str) {endGameT = str; }
   public String getEndGameT() {return endGameT; }

   public void setResult(String str) {result = str; }
   public String getResult() {return result; }
}
