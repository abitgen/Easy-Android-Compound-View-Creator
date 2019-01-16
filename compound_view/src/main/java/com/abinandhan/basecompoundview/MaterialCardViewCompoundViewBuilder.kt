package com.abinandhan.basecompoundview

import android.content.Context
import android.util.AttributeSet
import com.google.android.material.card.MaterialCardView

abstract class MaterialCardViewCompoundViewBuilder<T>(context: Context, open val attrs:AttributeSet) :
    MaterialCardView(context, attrs),
    CompoundViewBuilderParams<T> where T : CompoundViewParams{

    protected fun build() = buildParams(context, layout, attrs, styleable, params)
    fun get(paramName:T):T = getParamValue(paramName, params)
}