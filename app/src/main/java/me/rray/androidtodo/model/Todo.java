package me.rray.androidtodo.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

/**
 * Created by RRay on 12/7/2017.
 */

public class Todo implements Parcelable{

    public String text;
    public Date remainDate;


    public Todo(String text, Date remainDate) {
        this.text = text;
        this.remainDate = remainDate;
    }


    protected Todo(Parcel in) {
        text = in.readString();
        remainDate = new Date(in.readLong());
    }

    public static final Creator<Todo> CREATOR = new Creator<Todo>() {
        @Override
        public Todo createFromParcel(Parcel in) {
            return new Todo(in);
        }

        @Override
        public Todo[] newArray(int size) {
            return new Todo[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(text);
        parcel.writeLong(remainDate.getTime());
    }
}
