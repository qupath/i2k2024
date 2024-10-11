/*
This script exports the current image to the OME Zarr format.

It can be used by clicking on "Run" or "Run for project".
*/


// Import all classes that are used in this script
import qupath.lib.images.writers.ome.zarr.OMEZarrWriter


// Define the output path
var outputPath = buildPathInProject(getCurrentImageName() + ".ome.zarr")

// Get current image server
var currentImageServer = getCurrentServer()

// Create Zarr builder
var builder = new OMEZarrWriter.Builder(currentImageServer, outputPath)

// Build the Zarr builder. This creates a Zarr writer
var writer = builder.build()

// Use the writer to write the image
writer.writeImage()

// Close the writer
writer.close()