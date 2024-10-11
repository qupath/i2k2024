/*
This script adds a new measurement to every detection of the current image.
*/


getDetectionObjects().each { detection ->
    detection.measurements["New measurement"] = 2 * detection.measurements["Nucleus: Area"]
}