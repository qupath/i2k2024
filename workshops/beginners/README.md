# QuPath for Beginners

## Background
-	QuPath (version [0.6.0-rc3](https://github.com/qupath/qupath/releases/tag/v0.6.0-rc3) for the latest features). Installation instructions [here](https://qupath.readthedocs.io/en/latest/docs/intro/installation.html).
-	Image(s). The following workshop uses [OS-2.ndpi, OS-3.ndpi](https://openslide.cs.cmu.edu/download/openslide-testdata/Hamamatsu/) and [BBBC007_v1_images](https://bbbc.broadinstitute.org/BBBC007). 

Optional Extensions via the extension manager within QuPath
-	[InstanSeg](https://github.com/qupath/qupath-extension-instanseg)
-	[OMERO](https://github.com/qupath/qupath-extension-omero)

## Orientation
### Welcome Window
The first window to pop up when running QuPath is the welcome window. It hopes to provide some useful QuPath links such as documentation or where to get help. From here you can also adjust the theme to either dark or light mode. settings to check for updates to the software and extensions (which we will discuss later) to make sure you have access to the latest features.

![image](https://qupath.readthedocs.io/en/latest/_images/steps_welcome.jpg)

### QuPath Tour
A new feature for 0.6 is the QuPath Tour. Under the menu select `Help → QuPath Tour` to be guided around the applications interface and tools. We suggest opening an image first but this isn’t required and will be covering that in the next section.

## Basic Workflow

The following section takes you through a very basic workflow from image to results. We will use this workflow later to expand on certain aspects to tailor the workflow to different user needs. 

### Create a project
For easy organisation of images and analysis we recommend working on your images within [projects](https://qupath.readthedocs.io/en/latest/docs/tutorials/projects.html). The quickest way to create a project is by making an empty folder on your desktop and dragging and dropping into the QuPath window. A new project can also be created via the menu `File → Project... → Create project` which will open file explorer so you can create an empty folder where you would like your project to be. 

### Import images
Once you have a project, [images can also be added](https://qupath.readthedocs.io/en/latest/docs/tutorials/projects.html#add-images) to the project by dragging and dropping them into QuPath. This will prompt the import window where you can finely tune some of the parameters if required. 

![image](https://qupath.readthedocs.io/en/latest/_images/project_import.png)

### Set the image stain type
When you open an imported image, you will be prompted to select the type of image. This lets QuPath know what stains the image has so it can assign them “channels”. For example, an H&E image would have a channel for Haematoxylin and Eosin after the default color profiles have been extracted. More on extracting the stains can be found in the [QuPath docs](https://qupath.readthedocs.io/en/latest/docs/tutorials/separating_stains.html).

![image](https://qupath.readthedocs.io/en/latest/_images/stains_type.jpg)

### Draw annotation
Define the region you would like to count some cells within using the [annotation tools](https://qupath.readthedocs.io/en/latest/docs/starting/annotating.html) within the toolbar. If you create one you dislike, they can be easily deleted by selecting so they are yellow (instead of red) and then press the backspace key. The bigger the annotation the more effort it will take for the computer so it’s best to start with a smaller annotation for now and make it bigger once we know the parameters you’re looking for. 

![image](https://qupath.readthedocs.io/en/latest/_images/drawings.jpg)


### Detect cells
Now we have a region, we can count some cells! In the menu, select `Analyze → Cell detection → Positive cell detection`. Lots of parameters can be edited in this window to suit your specific cells and we recommend spending some time finely tuning these to your cell types. 

![image](https://qupath.readthedocs.io/en/latest/_images/ki67_detecting_final_markup.jpg)

### Investigate measurements
With the cells counted in the annotation we can now look at the measurements! These can be found either by selecting the annotation within the annotation pane or by opening `Measure → Show annotation measurements`. This will show the results in table form with the option to sort by each metric (try clicking on the collum headers!) or view in histogram form by selecting `Show Histograms`. The individual detection measurements can be viewed in a similar results way via `Measure → Show detection measurements`. 

### Export measurements
The measurements can either be exported from the [measurement table](https://qupath.readthedocs.io/en/latest/_images/project_import.png) for a single image or via the [measurement exporter](https://qupath.readthedocs.io/en/latest/_images/exporting_measurements.png) if you want to batch export. For this single image, we will use the first method which quite simply involves selecting either `copy to clipboard` and pasting where you would like or select `save` and navigate to your preferred location. If you would like to define a file type, opt for the `measurement exporter`

![image](https://qupath.readthedocs.io/en/latest/_images/measurement_table.png)

## What if...

### The cell detection isn't good enough?
InstanSeg! Try some pre-trained segmentation models by following the instructions [here](https://github.com/qupath/qupath-extension-instanseg). Note: the InstanSeg extension is included in v0.6.0-rc3 so no need to use the extension manager or drag and drop the jar. 

### Many images needing the same analysis?
Save yourself some time and use a script (don't let it scare you!). You don't have to know programming to script as QuPath tracks your workflow and then generates the script for you. More on generating a script can be found [here](https://qupath.readthedocs.io/en/latest/docs/scripting/workflows_to_scripts.html).

### Measuring areas?
Not everyone is staining for cells and that's where the pixel classifer can be useful. The [QuPath documentation](https://qupath.readthedocs.io/en/latest/docs/tutorials/pixel_classification.html) guides through a simple and more complex classification. 

