package com.egeperk.fitnesuiapp;

import android.os.Parcel;
import android.os.Parcelable;

public class FitnessMove implements Parcelable {

    private String fitnessName;
    private String fitnessPicture;
    private String fitnessDescription;
    private int fitnessCalorie;

    public FitnessMove(String fitnessName, String fitnessPicture, String fitnessDescription, int fitnessCalorie) {
        this.fitnessName = fitnessName;
        this.fitnessDescription = fitnessDescription;
        this.fitnessPicture = fitnessPicture;
        this.fitnessCalorie = fitnessCalorie;


    }

    public String getFitnessName() {
        return fitnessName;
    }

    public String getFitnessDescription() {
        return fitnessDescription;
    }

    public String getFitnessPicture() {
        return fitnessPicture;
    }


    public int getFitnessCalorie() {
        return fitnessCalorie;
    }

    protected FitnessMove(Parcel in) {

        fitnessName = in.readString();
        fitnessPicture = in.readString();
        fitnessDescription = in.readString();
        fitnessCalorie = in.readInt();

    }

    public static final Creator<FitnessMove> CREATOR = new Creator<FitnessMove>() {
        @Override
        public FitnessMove createFromParcel(Parcel in) {
            return new FitnessMove(in);
        }

        @Override
        public FitnessMove[] newArray(int size) {
            return new FitnessMove[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(fitnessName);
        dest.writeString(fitnessPicture);
        dest.writeString(fitnessDescription);
        dest.writeInt(fitnessCalorie);

    }
}