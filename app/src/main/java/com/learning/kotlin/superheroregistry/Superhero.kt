package com.learning.kotlin.superheroregistry

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Superhero(val heroName:String, val alterEgo:String, val bio:String, val power:Float):Parcelable