/**
 * ImageJ's PolygonRoi class has a 'fitSpline()' method that can be used for smoothing.
 * Here, we use that for QuPath in order to smooth some 'polyline' ROIs (i.e. open polygons).
 */

import ij.gui.PolygonRoi
import qupath.imagej.tools.IJTools
import qupath.lib.objects.PathObject
import qupath.lib.objects.PathObjectTools
import qupath.lib.roi.PolylineROI
import qupath.lib.roi.interfaces.ROI

import static qupath.lib.scripting.QP.*

/**
 * Get all the selected objects that have 'polyline' ROIs
 */
var polylineObjects = getSelectedObjects().findAll(p -> p.getROI() instanceof PolylineROI)
if (polylineObjects.isEmpty()) {
    getLogger().warn("Please select some objects with polyline ROIs first!")
    return
}

/**
 * Use 'collect' in Groovy to transform each element of a collection to something else
 */
var smoothedObjects = polylineObjects.collect(p -> smoothPolyline(p))

/**
 * Add the new objects we just created
 */
addObjects(smoothedObjects)

/**
 * Smooth the polyline ROI of an input object.
 * @param pathObject
 * @return
 */
PathObject smoothPolyline(PathObject pathObject) {
    // Attempt to smooth the polyline
    var smoothed = smoothPolylineROI(pathObject.getROI())
    // Create an object like the input (e.g. annotation, detection) with same classification
    var newObject = PathObjectTools.createLike(pathObject, smoothed)
    // Append to the existing classification
    newObject.classifications += ['Smoothed']
    return newObject
}

/**
 * Apply spline fit to an input ROI, using ImageJ.
 * @param polyline
 * @return
 */
ROI smoothPolylineROI(ROI polyline) {
    var roi = IJTools.convertToIJRoi(polyline, null, 1.0)
    if (roi instanceof PolygonRoi) {
        roi.fitSpline()
        return IJTools.convertToROI(roi, null, 1.0, polyline.getImagePlane())
    } else {
        // We expect to get PolygonRois... so hopefully this never happens
        getLogger().warn("Polyline unexpectedly converted to ${roi}")
        return polyline
    }
}