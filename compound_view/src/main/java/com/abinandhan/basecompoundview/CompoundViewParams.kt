package com.abinandhan.basecompoundview

import android.content.res.TypedArray
import android.view.View

interface CompoundViewParams : CompoundViewParamObj{
    fun getValue(): Any?
    fun setProperty(value: Any?): Any?
}