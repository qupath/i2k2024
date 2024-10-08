# QuPath/Gradle scripting project

This repo contains a minimal Gradle project to help with QuPath scripting.

## What's this for?

QuPath's script editor is pretty minimal.
It's much easier to write complex scripts with the full power of an [IDE (Integrated Development Environment)](https://en.wikipedia.org/wiki/Integrated_development_environment).

A good IDE can provide autocompletion, direct links to QuPath source code & documentation, and help spot bugs and typos much earlier.

The tricky bit is setting up the IDE with all the QuPath dependencies so that this works.

Which is where this repo comes in.

## How do I use it?

The IDE I've used more for writing QuPath scripts is [IntelliJ IDEA Community Edition](https://www.jetbrains.com/idea/).
Therefore the instructions focus on that - but potentially the approach could be used for other IDEs.

### Scripting with IntelliJ

* Download the latest release of the repo (or fork & clone)
  * Unzip the contents if needed
* Within IntelliJ, use *File &rarr; New... &rarr; Project from existing sources* and provide the path to the download
* Follow IntelliJ's prompts if needed, e.g. to set up a 'Groovy SDK'
* Write your QuPath scripts as *.groovy* files inside the 'scripts' directory
  * Create a new script by right-clicking the 'scripts' directory in IntelliJ and choosing *New &rarr; Groovy script*
* Enjoy IntelliJ's Groovy support to make scripting easier

Whenever you want to run the script in QuPath, drag it onto QuPath's main window and run it via the script editor as normal.

> **Tip!**
> 
> If *File &rarr; Auto refresh files* is selected in QuPath's script editor, then saving the script in IntelliJ should result in it automatically being reloaded when you switch to QuPath.
> 
> (Full disclosure: a bug in QuPath v0.4.0 and v0.4.1 broke the auto-refresh feature - but it will be fixed in v0.4.2.)


### Set a script directory in QuPath

In QuPath, *Automate &rarr; Shared scripts* allows you to specify a directory containing scripts.

You can set it to the directory containing your scripts here to make them available through QuPath's menus.

### Specifying dependencies

You can change the QuPath version in `settings.gradle`.

You can change the dependencies in `build.gradle`.

Since v0.4.0, if you want to use a dependency already managed within QuPath you can use the Gradle category feature - requesting a library from [libs.versions.toml](https://github.com/qupath/qupath/blob/main/gradle/libs.versions.toml) to ensure the version matches.


## License

There's nothing special here: it's just a template repo for convenience.

Use it as you wish (without warranty, of course).

If it had a license, it would be the [Unlicense](https://unlicense.org).
I didn't include the unlicense file though, since if anyone forks the repo then they might forget to remove it - and inadvertently unlicense their own scripts.