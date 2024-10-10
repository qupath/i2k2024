/*
This script add a new measurement to every detection of the current image.
*/


getDetectionObjects().each { detection ->
    def measurements = detection.getMeasurements()
    
    measurements["New measurement"] = 2 * measurements["Nucleus: Area"]
}