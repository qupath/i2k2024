/*
This script exports the current image to the OME Zarr format.

It can be used by clicking on "Run" or "Run for project".
*/


// Import all classes that are used in this script
import qupath.lib.images.writers.ome.zarr.OMEZarrWriter


// Define a folder containing all exported images within the project directory
var containingFolderPath = buildPathInProject("export")

// Create the export folder
mkdirs(containingFolderPath)

// Create the output path of the image
var outputPath = "${containingFolderPath}/${getCurrentImageName()}.ome.zarr"    // The '/' delimiter also works on Windows

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