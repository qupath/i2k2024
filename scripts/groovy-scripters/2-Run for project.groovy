/*
This script create an annotation covering the entire image and apply
a cell detection algorithm.

It is intended to be run by calling "Run for project". When that's the case,
it does the same thing as the "3-Run.groovy" script.

It can be run by calling "Run". In that case, it will only run on the
current image.
*/


// Create an annotation covering the entire CURRENT image, and select it
createFullImageAnnotation(true)

// Apply the cell detection algorithm to the CURRENT image on the selected annotation
runPlugin(
    'qupath.imagej.detect.cells.WatershedCellDetection',
    '{"detectionImageBrightfield":"Hematoxylin OD","requestedPixelSizeMicrons":0.5,"backgroundRadiusMicrons":8.0,"backgroundByReconstruction":true,"medianRadiusMicrons":0.0,"sigmaMicrons":1.5,"minAreaMicrons":10.0,"maxAreaMicrons":400.0,"threshold":0.1,"maxBackground":2.0,"watershedPostProcess":true,"excludeDAB":false,"cellExpansionMicrons":5.0,"includeNuclei":true,"smoothBoundaries":true,"makeMeasurements":true}'
)
