/*
This file contains some information regarding the Groovy syntax
*/


// Use 'var' to declare variables:
var someVariable = "Some value"

// Use 'println' to print some text or variable:
println(someVariable)
println someVariable    // parentheses are optional
println "Some other value"

// Semi-columns are optional

// Use '[]' to create a list:
var someList = []

// Use 'add', '<<', or 'addAll' to add elements to a list:
someList.add "someElement0"
someList << "someElement1"
someList.addAll "someElement2", "someElement3"

// Use '[i]' to access the (i+1)th element of a list:
println someList[2]     // print the third element
println someList[-1]    // print the last element

// Use 'each' to iterate over a list:
someList.each { element ->
    println element
}

// Use 'findAll' to filter a list
var elementsEndingWith1 = someList.findAll { element ->
    element.endsWith("1")
}
println elementsEndingWith1    // will print [someElement1]

// Use 'collect' to transform elements of a list
var someListUpperCased = someList.collect { element ->
    element.toUpperCase()
}
println someListUpperCased    // will print [SOMEELEMENT1, SOMEELEMENT2, SOMEELEMENT3]

// Use '[:]' to create an empty map
var someMap = [:]

// Use '[""]' to access or create an element of a map
someMap["someKey"] = "Some value"

// When a function has the form 'getAbc()', you can use 'abc' instead
var project1 = getProject()
var project2 = project            // same as project1

// Use the safe navigation operator '?.' instead of checking for null objects:
var imageData = getCurrentImageData()
if (project != null && project.getEntry(imageData) != null && project.getEntry(imageData).getImageName() == "some name") {}
// can be replaced by:
if (project?.getEntry(imageData)?.getImageName() == "some name") {}

// More information can be found on https://groovy-lang.org/
