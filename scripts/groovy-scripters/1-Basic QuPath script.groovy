/*
This script adds a new measurement to every detection of the current image.
*/

// Get detections
var detections = getDetectionObjects()

// Iterate over detections
detections.each { detection ->

    // Get measurements
    var measurements = detection.getMeasurements()   // or detection.measurements (see 0-Basic Groovy syntax.groovy line 54)

    // Add new measurement
    measurements["New measurement"] = 2 * measurements["Nucleus: Area"]
}