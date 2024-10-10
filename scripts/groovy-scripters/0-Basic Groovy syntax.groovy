/*
This file contains some information regarding the Groovy syntax
*/


// Use 'def' to declare variables:
def someVariable = "Some value"

// Use 'println' to print some text or variable:
println someVariable
println "Some other value"

// Semi-columns are optional

// Use '[]' to create a list:
def someList = []

// Use 'add' or 'addAll' to add elements to a list:
someList.add("someElement1")
someList.addAll("someElement2", "someElement3")

// Use '[i]' to access the ith element of a list:
println someList[1]

// Use 'each' to iterate over a list:
someList.each { element -> 
    println element
}

// Use 'findAll' to filter a list
def elementsEndingWith1 = someList.findAll { element ->
    element.endsWith("1")
}
println elementsEndingWith1    // will print [someElement1]

// Use 'collect' to transform elements of a list
def someListUpperCased = someList.collect { element ->
    element.toUpperCase()
}
println someListUpperCased    // will print [SOMEELEMENT1, SOMEELEMENT2, SOMEELEMENT3]

// Use '[:]' to create an empty map
def someMap = [:]

// Use '[""]' to access or create an element of a map
map["someKey"] = "Some value"

// Use the safe navigation operator '?.' instead of checking for null objects:
if (getProject() != null && getProject().getEntry(getCurrentImageData()) != null && getProject().getEntry(getCurrentImageData()).getImageName() == "some name") {}
// can be replaced by:
if (getProject()?.getEntry(getCurrentImageData())?.getImageName() == "some name") {}

// More information can be found on https://groovy-lang.org/​
