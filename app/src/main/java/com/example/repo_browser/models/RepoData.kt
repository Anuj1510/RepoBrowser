package com.example.repo_browser.models

import android.os.Parcel
import android.os.Parcelable

data class RepoData(val owner: owner,val name:String) : Parcelable {
    constructor(parcel: Parcel) : this(
        TODO("owner"),
        parcel.readString()!!
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<RepoData> {
        override fun createFromParcel(parcel: Parcel): RepoData {
            return RepoData(parcel)
        }

        override fun newArray(size: Int): Array<RepoData?> {
            return arrayOfNulls(size)
        }
    }
}
