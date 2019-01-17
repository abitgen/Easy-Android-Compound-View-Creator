package com.abinandhan.basecompoundview

interface CompoundViewParamsSet : CompoundViewParams{
    fun getValues() : HashMap<*,*>
    fun setProperties(values:HashMap<*,*>):Any?
}