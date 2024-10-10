/*
This script loops over each image of the current project, and for each
image, create an annotation covering the entire image and apply
a cell detection algorithm.

It is intended to be run by calling "Run". When that's the case,
it does the same thing as the "2-Run for project.groovy" script run
by calling "Run for project".
*/


// Get current project
def project = getProject()

// Get images of the project
def imageEntries = project.getImageList()

// Iterate over image entries
imageEntries.each { imageEntry ->
    // Get image data of image entry
    def imageData = imageEntry.readImageData()

    // Create an annotation covering the entire PROVIDED image data, and select it
    createAllFullImageAnnotations(imageData, true)

    // Apply the cell detection algorithm to the PROVIDED image on the selected annotation
    runPlugin(
        'qupath.imagej.detect.cells.WatershedCellDetection',
        imageData,
        '{"detectionImageBrightfield":"Hematoxylin OD","requestedPixelSizeMicrons":0.5,"backgroundRadiusMicrons":8.0,"backgroundByReconstruction":true,"medianRadiusMicrons":0.0,"sigmaMicrons":1.5,"minAreaMicrons":10.0,"maxAreaMicrons":400.0,"threshold":0.1,"maxBackground":2.0,"watershedPostProcess":true,"excludeDAB":false,"cellExpansionMicrons":5.0,"includeNuclei":true,"smoothBoundaries":true,"makeMeasurements":true}'
    )

    // Save annotation and detections
    imageEntry.saveImageData(imageData);
}
