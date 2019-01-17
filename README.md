# Easy-Android-Compound-View-Creator
Create compound views easily - written in Kotlin

Compound Views comprises of multiple views wrapped together.
This sample can help you create Compound views in simple steps

1. Create your layout file which comprises of multiple views.
2. Create a `<declare-styleable>` for your view, `attrs.xml` file, with attributes you you would like to set for views via xml attrs.
3. Create your View Class that extends Your Custom ViewGroupBuilder ( If ViewGroupBuilder is not availble for your desired ViewGroup, create one just like other file in this project, just extend the Builder to your desired ViewGroup class.
4. Create Enum class that extends interface CompoundViewParamsSet/ CompoundViewParams
5. Get and set all your properties here inside enum class
6. Use it in your acivity

**Note : This is experimental. Any code improvement can be suggested to improve.**
Pull request and Forks are most welcome. 
