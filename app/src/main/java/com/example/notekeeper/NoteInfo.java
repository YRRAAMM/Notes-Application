package com.example.notekeeper;

import android.os.Parcel;
import android.os.Parcelable;

public final class NoteInfo implements Parcelable{
    private CourseInfo mCourse;
    private String mTitle;
    private String mText;
    private int mId;

    public NoteInfo(int id, CourseInfo course, String title, String text) {
        mId = id;
        mCourse = course;
        mTitle = title;
        mText = text;
    }

    public NoteInfo(CourseInfo course, String title, String text) {
        mCourse = course;
        mTitle = title;
        mText = text;
    }

    private NoteInfo(Parcel source) {
        mCourse = source.readParcelable(CourseInfo.class.getClassLoader()); // or just getClass().getClassLoader()
        mTitle = source.readString();
        mText = source.readString();
    }

    public int getId() {
        return mId;
    }

    public CourseInfo getCourse() {
        return mCourse;
    }

    public void setCourse(CourseInfo course) {
        mCourse = course;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getText() {
        return mText;
    }

    public void setText(String text) {
        mText = text;
    }

    private String getCompareKey() {
        return mCourse.getCourseId() + "|" + mTitle + "|" + mText;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NoteInfo that = (NoteInfo) o;

        return getCompareKey().equals(that.getCompareKey());
    }

    @Override
    public int hashCode() {
        return getCompareKey().hashCode();
    }

    @Override
    public String toString() {
        return getCompareKey();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    // responsible to write information for the type instance into the Parcel
    // and it receives a Parcel as a parameter.
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        // course a reference type
        dest.writeParcelable(mCourse, 0); // content, any special behavior
        dest.writeString(mTitle);
        dest.writeString(mText);
    }
    // Parcelable.Creator anonymous class
    public static final Parcelable.Creator<NoteInfo> CREATOR = new Parcelable.Creator<NoteInfo>() {
        @Override
        public NoteInfo createFromParcel(Parcel source) {
            // Parcel values must be accessed in the same order they were written.
            // because they have no Identifiers they simply written in and read back out in order
            // new technique when implementing createFromParcel is rather than setting the values
            // directly within createFromParcel
            // we instead use a private constructor.


            return new NoteInfo(source);
        }

        @Override
        public NoteInfo[] newArray(int size) {
            return new NoteInfo[size];
        }
    };
}
