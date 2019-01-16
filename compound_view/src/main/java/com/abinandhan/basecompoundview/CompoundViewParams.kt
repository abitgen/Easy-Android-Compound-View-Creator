package com.abinandhan.basecompoundview

import android.content.res.TypedArray
import android.view.View

interface CompoundViewParams {
    var parentView: View?
    var typedArray: TypedArray?
    fun getValue(): Any?
    fun setProperty(value: Any?): Any?
}