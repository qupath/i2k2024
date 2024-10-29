/**
 * This is a QuPath script to illustrate some simple image processing using ImageJ.
 *
 * Here, we request an image, apply some smoothing, set an auto-threshold, and use that to create an annotation.
 *
 * The advantage of using QuPath here is that we can work with whole slide images.
 *
 * Even though we threshold on a low-resolution version, we are able to easily rescale the ROI and visualize
 * everything on the full-resolution image.
 */

import ij.process.AutoThresholder
import ij.process.ColorProcessor
import qupath.imagej.processing.SimpleThresholding
import qupath.imagej.tools.IJTools
import qupath.lib.images.ImageData
import qupath.lib.objects.PathObjects
import qupath.lib.regions.RegionRequest

import static qupath.lib.scripting.QP.*

/**
 * Let's start by defining the auto-threshold method we want to use.
 * Common options include Default, Otsu, Triangle - or check out the full list at
 * https://imagej.net/ij/developer/api/ij/ij/process/AutoThresholder.Method.html
 */
var method = AutoThresholder.Method.Otsu

/**
 * The ImageData is the main data structure in QuPath.
 */
var imageData = getCurrentImageData()

/**
 * We use an 'ImageServer' to request pixels and metadata.
 * These are usually read lazily (on-demand) at a resolution that we choose.
 * The ImageServer will internally figure out how to return the pixels to us.
 */
var server = imageData.getServer()

/**
 * The downsample value tells the ImageServer how much to 'scale down' the image.
 * A downsample of 1 means the full resolution image, 2 means to divide the width & height by 2.
 * Here, we calculate a downsample so neither the width nor height of the image is bigger than 1024 pixels.
 */
double downsample = Math.max(1.0, Math.max(server.getWidth(), server.getHeight()) / 1024.0)

/**
 * A 'RegionRequest' encapsulates the ID of the ImageServer (historically called 'path'...
 * though it's no longer a path), the downsample, and the bounding box of the region you want.
 * Here, we create a request for the entire image.
 */
var request = RegionRequest.createInstance(
        server.getPath(),
        downsample,
        0, 0, server.getWidth(), server.getHeight())

/**
 * We could now use {@code server.readRegion(request)} but that would give us a
 * Java BufferedImage.
 *
 * So instead we'll use IJTools to convert the output of our request into an ImagePlus.
 */
var imp = IJTools.convertToImagePlus(server, request).getImage()

/**
 * Now we are in the land of ImageJ.
 * Let's ensure we have a grayscale image...
 */
var ip = imp.getProcessor()
if (ip instanceof ColorProcessor)
    ip = ip.convertToByteProcessor()

/**
 * ...smooth a bit...
 */
ip.blurGaussian(2.0)

/**
 * ...and set a threshold.
 */
boolean darkBackground = imageData.getImageType() == ImageData.ImageType.FLUORESCENCE
ip.setAutoThreshold(method, darkBackground)

/**
 * With QuPath's 'SimpleThreshold' helper class, we can generate a QuPath ROI
 * from the thresholded pixels.
 */
var roi = SimpleThresholding.thresholdToROI(ip, request)

/**
 * Now we can create a new Annotation, and set some properties if we like
 */
var annotation = PathObjects.createAnnotationObject(roi)
annotation.classification = "Made with ImageJ: " + method

/**
 * Finally, we add our new annotation to QuPath's object hierarchy
 */
var hierarchy = imageData.getHierarchy()
hierarchy.addObject(annotation)